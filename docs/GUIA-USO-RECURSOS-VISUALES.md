# 🎬 Recursos Visuales para Enseñanza

Este documento explica cómo usar la **presentación HTML** y el **video tutorial** para enseñar la configuración de IntelliJ IDEA.

---

## 📊 1. Presentación HTML Interactiva

### 📋 Descripción

Presentación moderna de **13 slides** con:
- ✅ Navegación con teclado (flechas, espacio, inicio, fin)
- ✅ Tema dark profesional
- ✅ Animaciones suaves
- ✅ Contador de slides
- ✅ Responsive (adaptable a pantallas)
- ✅ Sin dependencias externas (funciona offline)

### 🚀 Cómo Usar

#### En el Aula de Clase

1. **Abrir la presentación:**
   ```bash
   # Opción 1: Con navegador predeterminado
   xdg-open docs/presentacion-intellij-setup.html
   
   # Opción 2: Con navegador específico
   firefox docs/presentacion-intellij-setup.html
   google-chrome docs/presentacion-intellij-setup.html
   ```

2. **Modo pantalla completa:**
   - Presiona `F11` en el navegador
   - O usa el menú del navegador

3. **Navegación durante la clase:**
   - `→` o `Espacio` = Siguiente slide
   - `←` = Slide anterior
   - `Inicio` = Primer slide
   - `Fin` = Último slide
   - `Esc` = Salir

#### Para Proyectar

**Preparación:**
1. Conecta el proyector/TV
2. Configura como pantalla extendida o duplicada
3. Abre la presentación en pantalla completa
4. Comienza desde el slide 1

**Durante la Presentación:**
- **Slides 1-2**: Introducción (2 minutos)
- **Slides 3**: Estructura del proyecto (2 minutos)
- **Slides 4-8**: Pasos de configuración (15 minutos)
  - *Pausar en cada paso para demostración en vivo*
- **Slide 9**: Atajos de teclado (3 minutos)
- **Slides 10-11**: Solución de problemas y checklist (3 minutos)
- **Slides 12-13**: Recursos y cierre (2 minutos)

**Total estimado:** ~25 minutos con demostraciones

#### Compartir con Estudiantes

**Opción 1: Repositorio Git**
```bash
# Los estudiantes clonan/pull el repo y abren:
git clone https://github.com/ergrato-dev/bc-oop-java.git
cd bc-oop-java/docs
xdg-open presentacion-intellij-setup.html
```

**Opción 2: Plataforma LMS**
1. Subir `presentacion-intellij-setup.html` a Moodle/Canvas
2. Los estudiantes descargan y abren localmente
3. También funciona directamente en el navegador del LMS

**Opción 3: Hosting Web**
- Subir a GitHub Pages, Netlify, o servidor web
- Compartir URL pública
- Estudiantes acceden desde cualquier dispositivo

### 🎨 Personalizar la Presentación

El archivo HTML es autocontenido. Para modificar:

```html
<!-- Editar contenido de slides (línea ~120+) -->
<div class="slide">
    <h2>Tu Título</h2>
    <p>Tu contenido...</p>
</div>

<!-- Cambiar colores (línea ~30+) -->
<style>
    h1 { color: #tu-color; }
</style>

<!-- Ajustar duración de animaciones (línea ~50) -->
@keyframes slideIn {
    /* Modificar aquí */
}
```

### 📱 Compatibilidad

**Navegadores:**
- ✅ Chrome/Chromium 90+
- ✅ Firefox 88+
- ✅ Edge 90+
- ✅ Safari 14+

**Dispositivos:**
- ✅ Desktop (Windows, macOS, Linux)
- ✅ Tablets (iPad, Android)
- ✅ Smartphones (iOS, Android)

---

## 🎥 2. Video Tutorial Automático

### 📋 Descripción

Script que genera **automáticamente** un video tutorial de ~72 segundos con:
- ✅ 9 slides animados (Full HD 1920x1080)
- ✅ Transiciones suaves
- ✅ Tema dark consistente
- ✅ Duración optimizada por slide
- ✅ Opción de narración con TTS (Text-to-Speech)
- ✅ Tamaño optimizado (~2-5 MB sin audio)

### 🛠️ Requisitos

```bash
# Fedora
sudo dnf install ffmpeg ImageMagick

# Ubuntu/Debian
sudo apt install ffmpeg imagemagick

# Arch Linux
sudo pacman -S ffmpeg imagemagick

# Opcional: Para audio
sudo dnf install espeak  # Fedora
sudo apt install espeak  # Ubuntu
```

### 🚀 Generar el Video

```bash
cd /home/epti/Documentos/sena/4T25/oop_java/docs/scripts

# Ejecutar generador
./generate-video-tutorial.sh
```

**Salida:**
```
video-tutorial/
├── tutorial-intellij-setup.mp4              # Video sin audio
├── tutorial-intellij-setup-con-audio.mp4    # Con narración (si espeak disponible)
├── README.md                                # Documentación
└── assets/
    ├── slide_01.png  # Portada
    ├── slide_02.png  # Paso 1
    ├── slide_03.png  # Paso 2
    ├── slide_04.png  # Paso 3
    ├── slide_05.png  # Paso 4
    ├── slide_06.png  # Paso 5
    ├── slide_07.png  # Atajos
    ├── slide_08.png  # Checklist
    └── slide_09.png  # Final
```

### 🎬 Usar el Video

#### En Clase

**Como Introducción:**
```bash
# Reproducir al inicio de la sesión
vlc video-tutorial/tutorial-intellij-setup.mp4

# O con mpv (más ligero)
mpv video-tutorial/tutorial-intellij-setup.mp4
```

**Estrategia recomendada:**
1. Reproducir video completo (1:12)
2. Pausar después del video
3. Demostrar en vivo cada paso
4. Estudiantes replican en sus máquinas

#### Compartir con Estudiantes

**Opción 1: YouTube**
```bash
# Subir a YouTube como "Unlisted" o "Public"
# Compartir link en el README del repo o LMS
```

**Opción 2: Google Drive / OneDrive**
1. Subir `tutorial-intellij-setup.mp4`
2. Configurar permisos: "Anyone with link can view"
3. Compartir enlace

**Opción 3: Plataforma LMS**
1. Subir video directamente a Moodle/Canvas
2. Embeber en página del curso
3. Los estudiantes lo ven integrado

**Opción 4: Git LFS (Large File Storage)**
```bash
# Si el video es <100MB, incluirlo en el repo
git lfs track "*.mp4"
git add video-tutorial/tutorial-intellij-setup.mp4
git commit -m "docs: add video tutorial"
git push
```

#### Reproducción en Loop

Para mostrar en pantalla de forma continua:

```bash
# VLC en loop
vlc --loop video-tutorial/tutorial-intellij-setup.mp4

# mpv en loop
mpv --loop video-tutorial/tutorial-intellij-setup.mp4
```

### 🎨 Personalizar el Video

**Modificar duración de slides:**

Edita `generate-video-tutorial.sh`, línea ~228:

```bash
# Cambiar duration (en segundos)
file '${ASSETS_DIR}/slide_01.png'
duration 5  # ← Aumentar/disminuir
```

**Cambiar colores o textos:**

Edita la función `generate_slides()`, línea ~93:

```bash
convert -size ${WIDTH}x${HEIGHT} \
    xc:'#1a1a1a' \  # ← Color de fondo
    -pointsize 120 \  # ← Tamaño de fuente
    -fill '#4a9eff' \  # ← Color de texto
    -annotate +0-200 'Tu Texto' \  # ← Contenido
    "${ASSETS_DIR}/slide_01.png"
```

**Agregar nuevos slides:**

1. Agregar generación en `generate_slides()`
2. Agregar entrada en `create_video()` (archivo `slides.txt`)
3. Actualizar contador de slides

**Cambiar resolución:**

```bash
# En la parte superior del script
WIDTH=1280   # En lugar de 1920
HEIGHT=720   # En lugar de 1080
```

### 📊 Comparación: HTML vs Video

| Característica | Presentación HTML | Video Tutorial |
|----------------|-------------------|----------------|
| **Interactividad** | ✅ Total (navegación libre) | ❌ Lineal |
| **Tamaño** | ~50 KB (1 archivo) | ~2-5 MB |
| **Navegación** | ✅ Saltar slides | ⚠️ Rebobinar |
| **Edición** | ✅ Fácil (HTML/CSS) | ⚠️ Regenerar script |
| **Compartir** | ✅ Un archivo | ✅ Plataformas video |
| **Offline** | ✅ Completamente | ✅ Una vez descargado |
| **Accesibilidad** | ✅ Screen readers | ⚠️ Subtítulos manuales |
| **Narración** | ❌ Solo visual | ✅ Con espeak |
| **Uso en clase** | ⭐⭐⭐⭐⭐ Excelente | ⭐⭐⭐⭐ Muy bueno |
| **Auto-estudio** | ⭐⭐⭐⭐ Muy bueno | ⭐⭐⭐⭐⭐ Excelente |

---

## 🎯 Estrategias Pedagógicas

### Opción 1: Solo Presentación HTML

**Cuándo usar:**
- Clase presencial con proyector
- Necesitas flexibilidad para saltar slides
- Quieres combinar con demostración en vivo
- Conexión a internet no disponible

**Flujo:**
1. Abrir presentación en pantalla completa
2. Avanzar slide por slide explicando
3. Pausar en cada paso para demostrar en vivo
4. Estudiantes replican en sus máquinas
5. Al final, compartir HTML para repaso

### Opción 2: Solo Video

**Cuándo usar:**
- Clase remota/virtual
- Quieres contenido para auto-estudio
- Necesitas algo compartible en LMS
- Los estudiantes prefieren ritmo propio

**Flujo:**
1. Compartir video antes de la clase
2. Pedir a estudiantes ver el video como tarea
3. En clase, resolver dudas específicas
4. Practicar directamente (flipped classroom)

### Opción 3: Combinación (RECOMENDADO)

**Flujo integrado:**

**Antes de la clase:**
- Compartir video (1:12) en LMS
- Estudiantes lo ven como preparación
- Toman notas de dudas

**Durante la clase (30 min):**
1. Reproducir video completo (1:12)
2. Abrir presentación HTML
3. Navegar a Slide 4 (Paso 1)
4. Demostrar en vivo cada paso:
   - Tú en pantalla proyectada
   - Estudiantes replican en paralelo
5. Pausar para preguntas en cada paso
6. Al finalizar, mostrar Slide 9 (Checklist)

**Después de la clase:**
- Video disponible para repaso
- HTML descargable del repo
- Documentación escrita en Markdown

---

## 📖 Recursos Complementarios

### Para el Instructor

- `GUIA-INTELLIJ-IDEA.md` - Referencia completa
- `GUIA-INTELLIJ-SOURCE-ROOTS.md` - Guía enfocada en Source Roots
- `presentacion-intellij-setup.html` - Slides interactivos
- `generate-video-tutorial.sh` - Generador de video

### Para el Estudiante

- `INSTRUCCIONES-INTELLIJ.md` - Guía rápida (en semana-00)
- Video tutorial - Para ver antes/después de clase
- HTML interactivo - Para repasar a su ritmo

---

## 🔄 Actualizar Recursos

### Actualizar Presentación HTML

```bash
cd docs
nano presentacion-intellij-setup.html  # Editar
# Probar abriendo en navegador
xdg-open presentacion-intellij-setup.html
```

### Regenerar Video

```bash
cd docs/scripts
nano generate-video-tutorial.sh  # Hacer cambios
./generate-video-tutorial.sh      # Regenerar
vlc ../video-tutorial/tutorial-intellij-setup.mp4  # Verificar
```

### Versionar Cambios

```bash
git add docs/
git commit -m "docs: update visual resources"
git push
```

---

## 🆘 Troubleshooting

### Presentación HTML

**No se ven los estilos:**
- Verificar que el archivo esté completo
- Abrir en navegador moderno
- Limpiar caché del navegador

**Navegación no funciona:**
- Verificar que JavaScript esté habilitado
- Refrescar página (F5)
- Probar en otro navegador

### Video Tutorial

**Error: "ffmpeg not found"**
```bash
# Instalar dependencia
sudo dnf install ffmpeg  # Fedora
sudo apt install ffmpeg  # Ubuntu
```

**Error: "convert not found"**
```bash
# Instalar ImageMagick
sudo dnf install ImageMagick
```

**Video no se reproduce:**
```bash
# Instalar codec H.264
sudo dnf install ffmpeg-libs
# O usar VLC (soporta todo)
sudo dnf install vlc
```

**Video muy grande:**
```bash
# Comprimir más en el script (línea 263)
-crf 23  # Cambiar a 28 (más compresión)
```

---

## 📊 Métricas de Uso

Para evaluar efectividad:

**Presentación HTML:**
- ¿Los estudiantes pudieron seguir sin perderse?
- ¿Hubo preguntas frecuentes sobre navegación?
- ¿Preferirían más o menos slides?

**Video Tutorial:**
- ¿Los estudiantes lo vieron antes de clase?
- ¿La duración fue apropiada?
- ¿Necesitan versión con audio?

**Recopilar feedback:**
```markdown
## Encuesta Post-Clase
1. ¿Viste el video tutorial antes de clase? (Sí/No)
2. ¿Te fue útil la presentación en clase? (1-5)
3. ¿Qué recurso prefieres para repasar? (Video/HTML/Docs)
4. ¿Qué agregarías o cambiarías?
```

---

## ✅ Checklist de Uso

**Antes de la primera clase:**
- [ ] Probar presentación HTML en el proyector
- [ ] Generar video tutorial
- [ ] Subir video a plataforma (YouTube/LMS)
- [ ] Compartir enlaces con estudiantes 24h antes
- [ ] Preparar demo en vivo de IntelliJ IDEA

**Durante la clase:**
- [ ] Iniciar con video (1:12)
- [ ] Usar presentación HTML para pasos
- [ ] Demo en vivo de cada paso
- [ ] Estudiantes replican
- [ ] Resolver dudas

**Después de la clase:**
- [ ] Verificar que recursos estén accesibles
- [ ] Responder preguntas en foro/chat
- [ ] Actualizar recursos según feedback

---

**Creado**: 3 de octubre de 2025  
**Proyecto**: Bootcamp POO Java - SENA  
**Recursos**: Presentación HTML + Video Tutorial
