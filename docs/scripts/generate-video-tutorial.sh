#!/bin/bash

################################################################################
# Script: Generador de Video Tutorial - IntelliJ IDEA Setup
# Descripción: Genera un video tutorial animado usando ffmpeg y herramientas CLI
# Autor: Bootcamp POO Java - SENA
# Fecha: 3 de octubre de 2025
################################################################################

set -e

# Colores para output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Configuración
VIDEO_DIR="$(pwd)/video-tutorial"
ASSETS_DIR="${VIDEO_DIR}/assets"
OUTPUT_VIDEO="${VIDEO_DIR}/tutorial-intellij-setup.mp4"
TEMP_DIR="${VIDEO_DIR}/temp"

# Resolución y FPS
WIDTH=1920
HEIGHT=1080
FPS=30

echo -e "${BLUE}╔════════════════════════════════════════════════════╗${NC}"
echo -e "${BLUE}║  Generador de Video Tutorial - IntelliJ IDEA      ║${NC}"
echo -e "${BLUE}╚════════════════════════════════════════════════════╝${NC}"
echo ""

################################################################################
# Verificar dependencias
################################################################################
check_dependencies() {
    echo -e "${YELLOW}🔍 Verificando dependencias...${NC}"
    
    local missing_deps=()
    
    if ! command -v ffmpeg &> /dev/null; then
        missing_deps+=("ffmpeg")
    fi
    
    if ! command -v convert &> /dev/null; then
        missing_deps+=("imagemagick")
    fi
    
    if [ ${#missing_deps[@]} -gt 0 ]; then
        echo -e "${RED}❌ Faltan dependencias:${NC}"
        for dep in "${missing_deps[@]}"; do
            echo -e "   - ${dep}"
        done
        echo ""
        echo -e "${YELLOW}Para instalar en Fedora:${NC}"
        echo "   sudo dnf install ffmpeg imagemagick"
        echo ""
        echo -e "${YELLOW}Para instalar en Ubuntu/Debian:${NC}"
        echo "   sudo apt install ffmpeg imagemagick"
        exit 1
    fi
    
    echo -e "${GREEN}✅ Todas las dependencias están instaladas${NC}"
    echo ""
}

################################################################################
# Crear estructura de directorios
################################################################################
setup_directories() {
    echo -e "${YELLOW}📁 Creando estructura de directorios...${NC}"
    
    mkdir -p "${VIDEO_DIR}"
    mkdir -p "${ASSETS_DIR}"
    mkdir -p "${TEMP_DIR}"
    
    echo -e "${GREEN}✅ Directorios creados${NC}"
    echo ""
}

################################################################################
# Generar slides como imágenes
################################################################################
generate_slides() {
    echo -e "${YELLOW}🎨 Generando slides...${NC}"
    
    # Slide 1: Portada
    convert -size ${WIDTH}x${HEIGHT} \
        xc:'#1a1a1a' \
        -gravity center \
        -pointsize 120 -fill '#4a9eff' -annotate +0-200 'Configuración IntelliJ IDEA' \
        -pointsize 60 -fill '#e0e0e0' -annotate +0-80 'Bootcamp POO Java - SENA' \
        -pointsize 80 -fill '#4ade80' -annotate +0+100 '🚀' \
        -pointsize 40 -fill '#b0b0b0' -annotate +0+300 'Tutorial paso a paso - 5 minutos' \
        "${ASSETS_DIR}/slide_01.png"
    echo -e "   ${GREEN}✓${NC} Slide 1: Portada"
    
    # Slide 2: Paso 1 - Abrir Proyecto
    convert -size ${WIDTH}x${HEIGHT} \
        xc:'#2a2a2a' \
        -gravity northwest \
        -pointsize 80 -fill '#4a9eff' -annotate +100+100 'Paso 1: Abrir el Proyecto' \
        -pointsize 50 -fill '#e0e0e0' \
        -annotate +100+250 '1. Iniciar IntelliJ IDEA' \
        -annotate +100+350 '2. File → Open' \
        -annotate +100+450 '3. Seleccionar carpeta oop_java' \
        -annotate +100+550 '4. Click OK' \
        -pointsize 40 -fill '#4ade80' -annotate +100+700 '💡 Espera a que IntelliJ indexe los archivos' \
        "${ASSETS_DIR}/slide_02.png"
    echo -e "   ${GREEN}✓${NC} Slide 2: Paso 1"
    
    # Slide 3: Paso 2 - Configurar JDK
    convert -size ${WIDTH}x${HEIGHT} \
        xc:'#2a2a2a' \
        -gravity northwest \
        -pointsize 80 -fill '#4a9eff' -annotate +100+100 'Paso 2: Configurar JDK 21' \
        -pointsize 50 -fill '#e0e0e0' \
        -annotate +100+250 '1. File → Project Structure' \
        -annotate +100+350 '2. Sección "Project"' \
        -annotate +100+450 '3. Project SDK: 21' \
        -annotate +100+550 '4. Language level: 21' \
        -pointsize 45 -fill '#fbbf24' -annotate +100+700 '⚠️  Si no aparece JDK: Add SDK → Download JDK' \
        "${ASSETS_DIR}/slide_03.png"
    echo -e "   ${GREEN}✓${NC} Slide 3: Paso 2"
    
    # Slide 4: Paso 3 - Source Roots
    convert -size ${WIDTH}x${HEIGHT} \
        xc:'#2a2a2a' \
        -gravity northwest \
        -pointsize 80 -fill '#4a9eff' -annotate +100+100 'Paso 3: Marcar Source Roots' \
        -pointsize 50 -fill '#e0e0e0' \
        -annotate +100+250 'Para CADA carpeta de ejercicio:' \
        -pointsize 45 -fill '#4ade80' \
        -annotate +100+350 '1. Click derecho en ejercicio-XX-nombre/' \
        -annotate +100+450 '2. Mark Directory as → Sources Root' \
        -annotate +100+550 '3. La carpeta cambia a azul 📁🔵' \
        -pointsize 50 -fill '#e0e0e0' \
        -annotate +100+700 'Repetir para ejercicios 01, 02, 03, 04, 05, 06' \
        "${ASSETS_DIR}/slide_04.png"
    echo -e "   ${GREEN}✓${NC} Slide 4: Paso 3"
    
    # Slide 5: Paso 4 - Excluir carpetas
    convert -size ${WIDTH}x${HEIGHT} \
        xc:'#2a2a2a' \
        -gravity northwest \
        -pointsize 80 -fill '#4a9eff' -annotate +100+100 'Paso 4: Excluir Documentación' \
        -pointsize 50 -fill '#e0e0e0' \
        -annotate +100+250 'Carpetas sin código compilable:' \
        -pointsize 45 -fill '#ef4444' \
        -annotate +100+370 '❌ 0-assets/   → Recursos gráficos' \
        -annotate +100+470 '❌ 1-teoria/   → Documentación' \
        -annotate +100+570 '❌ 3-recursos/ → Glosario' \
        -pointsize 50 -fill '#e0e0e0' \
        -annotate +100+720 'Click derecho → Mark Directory as → Excluded' \
        "${ASSETS_DIR}/slide_05.png"
    echo -e "   ${GREEN}✓${NC} Slide 5: Paso 4"
    
    # Slide 6: Paso 5 - Ejecutar
    convert -size ${WIDTH}x${HEIGHT} \
        xc:'#2a2a2a' \
        -gravity northwest \
        -pointsize 80 -fill '#4a9eff' -annotate +100+100 'Paso 5: Ejecutar Programa' \
        -pointsize 50 -fill '#e0e0e0' \
        -annotate +100+250 '1. Abrir HolaMundo.java' \
        -annotate +100+350 '2. Buscar método main' \
        -pointsize 45 -fill '#4ade80' \
        -annotate +100+450 '3. Click en ícono verde ▶️' \
        -pointsize 50 -fill '#e0e0e0' \
        -annotate +100+550 '4. Run HolaMundo.main()' \
        -pointsize 60 -fill '#4ade80' \
        -annotate +100+750 '✅ ¡Deberías ver "¡Hola Mundo!" en la consola!' \
        "${ASSETS_DIR}/slide_06.png"
    echo -e "   ${GREEN}✓${NC} Slide 6: Paso 5"
    
    # Slide 7: Atajos de teclado
    convert -size ${WIDTH}x${HEIGHT} \
        xc:'#2a2a2a' \
        -gravity northwest \
        -pointsize 80 -fill '#4a9eff' -annotate +100+100 'Atajos Esenciales' \
        -pointsize 45 -fill '#e0e0e0' \
        -annotate +150+250 'Shift + F10      → Ejecutar' \
        -annotate +150+340 'Ctrl + Alt + L   → Formatear código' \
        -annotate +150+430 'Ctrl + Space     → Autocompletar' \
        -annotate +150+520 'Ctrl + /         → Comentar línea' \
        -annotate +150+610 'Ctrl + D         → Duplicar línea' \
        -annotate +150+700 'Alt + F12        → Terminal' \
        -pointsize 40 -fill '#4ade80' \
        -annotate +100+850 '💡 Usa estos atajos para ser más productivo' \
        "${ASSETS_DIR}/slide_07.png"
    echo -e "   ${GREEN}✓${NC} Slide 7: Atajos"
    
    # Slide 8: Checklist
    convert -size ${WIDTH}x${HEIGHT} \
        xc:'#2a2a2a' \
        -gravity northwest \
        -pointsize 80 -fill '#4a9eff' -annotate +100+80 'Checklist Final' \
        -pointsize 45 -fill '#4ade80' \
        -annotate +150+220 '✅ IntelliJ IDEA abierto' \
        -annotate +150+300 '✅ JDK 21 configurado' \
        -annotate +150+380 '✅ Ejercicios como Source Root (azul)' \
        -annotate +150+460 '✅ Docs como Excluded (gris)' \
        -annotate +150+540 '✅ HolaMundo ejecutado OK' \
        -annotate +150+620 '✅ Numeración activada' \
        -annotate +150+700 '✅ Auto-import configurado' \
        -pointsize 70 -fill '#4ade80' \
        -annotate +100+850 '¡Listo para programar! 🎉' \
        "${ASSETS_DIR}/slide_08.png"
    echo -e "   ${GREEN}✓${NC} Slide 8: Checklist"
    
    # Slide 9: Final
    convert -size ${WIDTH}x${HEIGHT} \
        xc:'#1a1a1a' \
        -gravity center \
        -pointsize 100 -fill '#4ade80' -annotate +0-200 '¡Éxito!' \
        -pointsize 80 -fill '#4a9eff' -annotate +0-50 '🎓' \
        -pointsize 60 -fill '#e0e0e0' -annotate +0+100 'Bootcamp POO Java - SENA' \
        -pointsize 45 -fill '#b0b0b0' -annotate +0+250 'Consulta la documentación para más detalles' \
        -pointsize 40 -fill '#7b68ee' -annotate +0+350 'docs/GUIA-INTELLIJ-SOURCE-ROOTS.md' \
        "${ASSETS_DIR}/slide_09.png"
    echo -e "   ${GREEN}✓${NC} Slide 9: Final"
    
    echo -e "${GREEN}✅ Slides generados: 9${NC}"
    echo ""
}

################################################################################
# Generar video a partir de slides
################################################################################
create_video() {
    echo -e "${YELLOW}🎬 Generando video...${NC}"
    
    # Crear lista de slides con duración
    cat > "${TEMP_DIR}/slides.txt" << EOF
# Slide 1: Portada (5 segundos)
file '${ASSETS_DIR}/slide_01.png'
duration 5
# Slide 2: Paso 1 (8 segundos)
file '${ASSETS_DIR}/slide_02.png'
duration 8
# Slide 3: Paso 2 (8 segundos)
file '${ASSETS_DIR}/slide_03.png'
duration 8
# Slide 4: Paso 3 (10 segundos)
file '${ASSETS_DIR}/slide_04.png'
duration 10
# Slide 5: Paso 4 (8 segundos)
file '${ASSETS_DIR}/slide_05.png'
duration 8
# Slide 6: Paso 5 (8 segundos)
file '${ASSETS_DIR}/slide_06.png'
duration 8
# Slide 7: Atajos (10 segundos)
file '${ASSETS_DIR}/slide_07.png'
duration 10
# Slide 8: Checklist (8 segundos)
file '${ASSETS_DIR}/slide_08.png'
duration 8
# Slide 9: Final (5 segundos)
file '${ASSETS_DIR}/slide_09.png'
duration 5
# Repetir último slide para evitar corte
file '${ASSETS_DIR}/slide_09.png'
EOF

    # Generar video usando ffmpeg
    ffmpeg -f concat -safe 0 -i "${TEMP_DIR}/slides.txt" \
        -vf "fps=${FPS},format=yuv420p" \
        -c:v libx264 \
        -preset medium \
        -crf 23 \
        -y \
        "${OUTPUT_VIDEO}" 2>&1 | grep -E '(frame=|Duration:|Output)' || true
    
    if [ -f "${OUTPUT_VIDEO}" ]; then
        echo -e "${GREEN}✅ Video generado exitosamente${NC}"
        echo -e "   📹 Ubicación: ${OUTPUT_VIDEO}"
        
        # Obtener información del video
        local size=$(du -h "${OUTPUT_VIDEO}" | cut -f1)
        local duration=$(ffprobe -v error -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 "${OUTPUT_VIDEO}" 2>/dev/null | cut -d'.' -f1)
        
        echo -e "   📊 Tamaño: ${size}"
        echo -e "   ⏱️  Duración: ${duration} segundos"
        echo ""
    else
        echo -e "${RED}❌ Error al generar video${NC}"
        exit 1
    fi
}

################################################################################
# Generar video con narración (opcional)
################################################################################
create_video_with_audio() {
    echo -e "${YELLOW}🎤 Generando video con audio...${NC}"
    echo -e "${BLUE}ℹ️  Esta función requiere espeak o festival instalado${NC}"
    
    if ! command -v espeak &> /dev/null && ! command -v festival &> /dev/null; then
        echo -e "${YELLOW}⚠️  Herramienta TTS no encontrada, saltando audio...${NC}"
        echo ""
        return
    fi
    
    # Crear script de narración
    cat > "${TEMP_DIR}/narration.txt" << 'EOF'
Bienvenidos al tutorial de configuración de IntelliJ IDEA para el Bootcamp de Programación Orientada a Objetos con Java del SENA.

Paso uno: Abrir el proyecto.
Inicia IntelliJ IDEA, ve a File, Open, y selecciona la carpeta oop_java. Espera a que IntelliJ indexe los archivos.

Paso dos: Configurar JDK 21.
Ve a File, Project Structure. En la sección Project, selecciona JDK 21 como Project SDK. Si no aparece, descárgalo desde Add SDK.

Paso tres: Marcar Source Roots.
Para cada carpeta de ejercicio, haz click derecho, selecciona Mark Directory as, Sources Root. La carpeta cambiará a color azul. Repite para los ejercicios del uno al seis.

Paso cuatro: Excluir documentación.
Las carpetas cero guion assets, uno guion teoria, y tres guion recursos no contienen código compilable. Márcalas como Excluded haciendo click derecho y seleccionando Mark Directory as, Excluded.

Paso cinco: Ejecutar tu primer programa.
Abre el archivo HolaMundo punto java. Busca el método main y haz click en el ícono verde de play. Selecciona Run HolaMundo punto main. Deberías ver "Hola Mundo" en la consola.

Atajos esenciales: Shift F10 para ejecutar, Control Alt L para formatear código, Control Space para autocompletar, Control barra para comentar, Control D para duplicar línea, y Alt F12 para abrir la terminal.

Verifica tu configuración con el checklist final. Y eso es todo. ¡Estás listo para programar! Consulta la documentación en el repositorio para más detalles. Éxito en tu aprendizaje.
EOF

    # Generar audio con espeak (si está disponible)
    if command -v espeak &> /dev/null; then
        espeak -v es -s 150 -f "${TEMP_DIR}/narration.txt" -w "${TEMP_DIR}/narration.wav" 2>/dev/null
        
        # Combinar video con audio
        if [ -f "${TEMP_DIR}/narration.wav" ]; then
            ffmpeg -i "${OUTPUT_VIDEO}" \
                -i "${TEMP_DIR}/narration.wav" \
                -c:v copy \
                -c:a aac \
                -strict experimental \
                -shortest \
                -y \
                "${VIDEO_DIR}/tutorial-intellij-setup-con-audio.mp4" 2>&1 | grep -E '(frame=|Duration:|Output)' || true
            
            echo -e "${GREEN}✅ Video con audio generado${NC}"
            echo -e "   📹 Ubicación: ${VIDEO_DIR}/tutorial-intellij-setup-con-audio.mp4"
            echo ""
        fi
    fi
}

################################################################################
# Limpiar archivos temporales
################################################################################
cleanup() {
    echo -e "${YELLOW}🧹 Limpiando archivos temporales...${NC}"
    rm -rf "${TEMP_DIR}"
    echo -e "${GREEN}✅ Limpieza completada${NC}"
    echo ""
}

################################################################################
# Generar README del video
################################################################################
create_readme() {
    cat > "${VIDEO_DIR}/README.md" << 'EOF'
# 🎬 Video Tutorial - Configuración IntelliJ IDEA

## 📹 Contenido

Video tutorial de **~72 segundos** que muestra la configuración paso a paso de IntelliJ IDEA para el Bootcamp POO Java.

### Estructura del Tutorial

1. **Portada** (5s) - Introducción
2. **Paso 1** (8s) - Abrir el proyecto
3. **Paso 2** (8s) - Configurar JDK 21
4. **Paso 3** (10s) - Marcar Source Roots
5. **Paso 4** (8s) - Excluir documentación
6. **Paso 5** (8s) - Ejecutar primer programa
7. **Atajos** (10s) - Shortcuts esenciales
8. **Checklist** (8s) - Verificación final
9. **Cierre** (5s) - Conclusión

## 🎥 Archivos Generados

- `tutorial-intellij-setup.mp4` - Video sin audio (slides animados)
- `tutorial-intellij-setup-con-audio.mp4` - Video con narración (si disponible)
- `assets/slide_*.png` - Slides individuales (9 slides)

## 🚀 Uso

### En Clase

1. Abrir el video en pantalla completa
2. Reproducir durante la explicación inicial
3. Pausar en cada paso para demostración en vivo

### Para Estudiantes

1. Compartir video en plataforma LMS
2. Los estudiantes pueden seguir el tutorial a su ritmo
3. Pausar y reproducir según necesidad

### Streaming

Compatible con:
- YouTube
- Google Drive
- Microsoft Teams
- Plataformas LMS (Moodle, Canvas, etc.)

## 📊 Especificaciones Técnicas

- **Resolución**: 1920x1080 (Full HD)
- **FPS**: 30
- **Codec**: H.264 (libx264)
- **Formato**: MP4
- **Duración**: ~72 segundos
- **Tamaño**: ~2-5 MB (sin audio)

## 🔄 Regenerar Video

Para regenerar o modificar el video:

```bash
cd docs/scripts
./generate-video-tutorial.sh
```

### Personalización

Edita el script para:
- Cambiar duración de slides (línea 228+)
- Modificar colores y estilos (línea 93+)
- Agregar/quitar slides (función `generate_slides`)
- Cambiar resolución (variables `WIDTH` y `HEIGHT`)

## 🎨 Personalizar Slides

Los slides se generan con ImageMagick. Para modificar:

1. Editar función `generate_slides()` en el script
2. Ajustar tamaños de fuente (`-pointsize`)
3. Cambiar colores (`-fill`)
4. Modificar posiciones (`-annotate +X+Y`)

## 🎤 Agregar Narración

Si tienes `espeak` o `festival` instalado:

```bash
# Fedora
sudo dnf install espeak

# Ubuntu/Debian
sudo apt install espeak
```

El script generará automáticamente una versión con audio.

## 📝 Notas

- Los slides se generan dinámicamente (no requieren diseño manual)
- Todos los colores coinciden con el tema dark del proyecto
- El video es compatible con reproductores estándar
- Tamaño optimizado para web

## 🆘 Troubleshooting

**Error: "ffmpeg not found"**
```bash
sudo dnf install ffmpeg  # Fedora
sudo apt install ffmpeg  # Ubuntu
```

**Error: "convert not found"**
```bash
sudo dnf install ImageMagick  # Fedora
sudo apt install imagemagick  # Ubuntu
```

**Video no se reproduce**
- Verificar codec: `ffprobe tutorial-intellij-setup.mp4`
- Usar reproductor compatible (VLC, mpv)

---

**Generado**: 3 de octubre de 2025  
**Script**: `generate-video-tutorial.sh`  
**Proyecto**: Bootcamp POO Java - SENA
EOF

    echo -e "${GREEN}✅ README del video creado${NC}"
    echo ""
}

################################################################################
# Función principal
################################################################################
main() {
    check_dependencies
    setup_directories
    generate_slides
    create_video
    create_video_with_audio
    create_readme
    cleanup
    
    echo -e "${GREEN}╔════════════════════════════════════════════════════╗${NC}"
    echo -e "${GREEN}║           ✅ PROCESO COMPLETADO                    ║${NC}"
    echo -e "${GREEN}╚════════════════════════════════════════════════════╝${NC}"
    echo ""
    echo -e "${BLUE}📹 Video generado en:${NC}"
    echo -e "   ${OUTPUT_VIDEO}"
    echo ""
    echo -e "${BLUE}📖 Documentación:${NC}"
    echo -e "   ${VIDEO_DIR}/README.md"
    echo ""
    echo -e "${YELLOW}💡 Siguiente paso:${NC}"
    echo -e "   Abre el video con: ${GREEN}vlc ${OUTPUT_VIDEO}${NC}"
    echo -e "   O comparte el archivo con los estudiantes"
    echo ""
}

# Ejecutar
main
