#!/usr/bin/env bash
# Verifica la integridad estructural del bootcamp (adaptado de bc-python):
#   1. Nombres de carpeta week-NN-slug y ejercicio-NN-slug bien formados.
#   2. Enlaces relativos en markdown que resuelven a una ruta real.
#   3. Tabla "Navegación" al pie de todo .md de las semanas publicadas.
#   4. 0-assets/ solo con SVG, accesibles y enlazados desde algún .md.
#   5. Sin carpetas solution/ (los starters no traen la respuesta).
#   6. Todo .sh con shebang `env bash`, `set -euo pipefail` y bit de ejecución.
#   7. Imágenes de contenedor fijadas: sin tag o :latest no valen.
#   8. Tuteo: ninguna forma de voseo en el markdown.
#   9. PostgreSQL y nunca MySQL.
#  10. Puertos de Compose publicados solo en 127.0.0.1.
#
# Las comprobaciones 3, 6 (en bootcamp/) y 7 (en bootcamp/) solo se aplican a
# las semanas marcadas con ✅ en bootcamp/README.md.
#
# Uso: scripts/verificar-enlaces.sh
# Salida: lista de problemas encontrados; exit code 1 si hay al menos uno.

set -euo pipefail
cd "$(dirname "$0")/.."
export LC_ALL=C.UTF-8

fail=0

publicadas=$(grep -oE '^\| \[[0-9]{2}\]\(([a-z0-9_-]+)/README\.md\).*\| ✅ \|$' bootcamp/README.md \
             | sed -E 's/^\| \[[0-9]{2}\]\(([a-z0-9_-]+)\/README\.md\).*/\1/' || true)

esta_publicada() {
  local ruta="$1" slug
  for slug in $publicadas; do
    case "$ruta" in *"$slug"*) return 0 ;; esac
  done
  return 1
}

# Fuera de bootcamp/ siempre aplica; dentro, solo en semanas publicadas.
aplica() {
  case "$1" in
    bootcamp/*|./bootcamp/*) esta_publicada "$1" ;;
    *) return 0 ;;
  esac
}

if [ -z "$publicadas" ]; then
  echo "AVISO: ninguna semana marcada como ✅ en bootcamp/README.md."
fi

echo "== 1. Nombres de carpeta =="
while IFS= read -r d; do
  if ! [[ "$(basename "$d")" =~ ^week-[0-9]{2}-[a-z0-9_]+$ ]]; then
    echo "NOMBRE INVALIDO (week): $d"; fail=1
  fi
done < <(find bootcamp -mindepth 1 -maxdepth 1 -type d -iname "week-*")
while IFS= read -r d; do
  if ! [[ "$(basename "$d")" =~ ^ejercicio-[0-9]{2}-[a-z0-9-]+$ ]]; then
    echo "NOMBRE INVALIDO (ejercicio): $d"; fail=1
  fi
done < <(find bootcamp -mindepth 3 -maxdepth 3 -type d -path "*/2-practicas/*")

echo "== 2. Enlaces relativos en markdown =="
# No parsea markdown de verdad: quita los bloques ``` y busca "](...)".
while IFS= read -r f; do
  content=$(awk '/^```/{c=!c; next} !c' "$f")
  while IFS= read -r link; do
    [ -z "$link" ] && continue
    clean="${link%%#*}"
    [ -z "$clean" ] && continue
    case "$clean" in http*|\<http*|ws*|mailto:*|/*) continue ;; esac
    if [ ! -e "$(realpath -m "$(dirname "$f")/$clean")" ]; then
      echo "ENLACE ROTO: $f -> $link"; fail=1
    fi
  done < <(printf '%s\n' "$content" | grep -oE '\]\([^)]+\)' | sed -E 's/^\]\(//;s/\)$//' || true)
done < <(find . -iname "*.md" -not -path "./.git/*" \
           -not -path "./.claude/*" -not -path "./.github/*")

echo "== 3. Navegación al pie de cada .md de semanas publicadas =="
while IFS= read -r md; do
  esta_publicada "$md" || continue
  if ! grep -q "^## 🔗 Navegación" "$md" || ! grep -q "^| Anterior | Actual | Siguiente |" "$md"; then
    echo "SIN TABLA DE NAVEGACION: $md"; fail=1
  fi
done < <(find bootcamp -mindepth 2 -iname "*.md" -not -path "*/starter/*")

echo "== 4. Diagramas SVG en 0-assets/ =="
while IFS= read -r otro; do
  echo "NO ES SVG: $otro"; fail=1
done < <(find bootcamp -path "*/0-assets/*" -type f ! -name '*.svg')
while IFS= read -r svg; do
  for req in 'viewBox=' 'role="img"' '<title' '<desc'; do
    grep -q "$req" "$svg" || { echo "SVG SIN $req: $svg"; fail=1; }
  done
  grep -rqF --include='*.md' "0-assets/$(basename "$svg")" bootcamp \
    || { echo "SVG HUERFANO (no enlazado desde ningun .md): $svg"; fail=1; }
done < <(find bootcamp -path "*/0-assets/*" -name "*.svg")

echo "== 5. Sin carpetas solution/ =="
while IFS= read -r d; do
  echo "CARPETA DE SOLUCION (no se publica): $d"; fail=1
done < <(find bootcamp -type d -iname "solution*")

echo "== 6. Cabecera de los scripts bash =="
while IFS= read -r sh; do
  aplica "$sh" || continue
  if [ "$(head -1 "$sh")" != "#!/usr/bin/env bash" ]; then
    echo "SHEBANG INCORRECTO (debe ser '#!/usr/bin/env bash'): $sh"; fail=1
  fi
  if ! grep -q 'set -euo pipefail' "$sh"; then
    echo "SIN 'set -euo pipefail': $sh"; fail=1
  fi
  if [ ! -x "$sh" ]; then
    echo "SIN BIT DE EJECUCION (chmod +x): $sh"; fail=1
  fi
done < <(find scripts bootcamp -name "*.sh" 2>/dev/null)

echo "== 7. Imágenes fijadas (sin tag o :latest) =="
# Una referencia válida lleva ":<tag>" en su último segmento o "@sha256:".
while IFS= read -r f; do
  aplica "$f" || continue
  # Etapas con nombre de un Dockerfile multi-stage ("FROM base"): no son imágenes.
  etapas=$(grep -ioE '^FROM[[:space:]].*[[:space:]]AS[[:space:]]+[a-z0-9_.-]+' "$f" | awk '{print $NF}' || true)
  while IFS= read -r linea; do
    ref=$(sed -E 's/^[[:space:]-]*(image:|FROM|COPY[[:space:]]+--from=)[[:space:]]*//; s/[[:space:]]+(AS|as)[[:space:]].*$//; s/[[:space:]]+#.*$//; s/[[:space:]].*$//; s/["'\'']//g' <<<"$linea")
    case "$ref" in *'<'*|*'$'*|*'{{'*|scratch) continue ;; esac
    grep -qxF "$ref" <<<"$etapas" && continue
    ultimo="${ref##*/}"
    if { [[ "$ultimo" != *:* ]] && [[ "$ref" != *@sha256:* ]]; } || [[ "$ultimo" == *:latest ]]; then
      echo "IMAGEN SIN VERSION (sin tag o :latest): $f: $linea"; fail=1
    fi
  done < <(grep -E '^[[:space:]-]*image:[[:space:]]*[^[:space:]]|^FROM[[:space:]]|^COPY[[:space:]]+--from=[a-z0-9.-]+/' "$f" || true)
done < <(find bootcamp \( -name "*.yaml" -o -name "*.yml" -o -name "Dockerfile*" \) \
           2>/dev/null)

echo "== 8. Tuteo, sin voseo =="
# CLAUDE.md cita las formas prohibidas como ejemplo.
VOSEO='podés|tenés|querés|sabés|hacé|usá|configurá|ejecutá|revisá|fijate|mirá|probá|instalá|corré|creá|agregá|dejá|empezá|verificá|comprobá|poné|vení|andá|decí|vos'
while IFS= read -r f; do
  if out=$(grep -nwiE "$VOSEO" "$f"); then
    printf 'VOSEO: %s\n%s\n' "$f" "$(sed 's/^/  /' <<<"$out")"; fail=1
  fi
done < <(find . -iname "*.md" -not -path "./.git/*" -not -name "CLAUDE.md")

echo "== 9. PostgreSQL, nunca MySQL =="
while IFS= read -r f; do
  aplica "$f" || continue
  if out=$(grep -niwE 'mysql|mariadb' "$f"); then
    printf 'BASE DE DATOS PROHIBIDA (usa PostgreSQL): %s\n%s\n' "$f" "$(sed 's/^/  /' <<<"$out")"; fail=1
  fi
done < <(find bootcamp docs \( -name "*.md" -o -name "*.sh" -o -name "*.java" -o -name "pom.xml" \
           -o -name "*.properties" -o -name "Dockerfile*" -o -name "*.yaml" -o -name "*.yml" \) 2>/dev/null)

echo "== 10. Puertos de Compose solo en 127.0.0.1 =="
while IFS= read -r f; do
  aplica "$f" || continue
  if out=$(grep -nE '^[[:space:]]*-[[:space:]]*["'\'']?([0-9]+(-[0-9]+)?:|0\.0\.0\.0:)' "$f"); then
    printf 'PUERTO ABIERTO A LA RED (usa "127.0.0.1:HOST:CONTENEDOR"): %s\n%s\n' "$f" "$(sed 's/^/  /' <<<"$out")"; fail=1
  fi
done < <(find bootcamp \( -name "compose*.yaml" -o -name "compose*.yml" \) 2>/dev/null)

if [ "$fail" -eq 0 ]; then
  echo "OK: sin problemas detectados."
fi
exit "$fail"
