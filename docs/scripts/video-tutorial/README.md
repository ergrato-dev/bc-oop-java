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
