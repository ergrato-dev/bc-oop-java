# 🚀 Configuración Rápida de IntelliJ IDEA - Semana 0

## 📋 Objetivo

Configurar tu entorno de desarrollo para trabajar con los ejercicios de la Semana 0 del Bootcamp POO Java.

---

## ⚡ Configuración en 5 Pasos

### Paso 1️⃣: Abrir el Proyecto

1. Abre **IntelliJ IDEA**
2. Haz clic en `File` → `Open`
3. Navega hasta la carpeta del proyecto: `oop_java`
4. Haz clic en `OK`
5. Espera a que IntelliJ indexe los archivos (barra de progreso abajo)

### Paso 2️⃣: Configurar JDK 21

1. Ve a `File` → `Project Structure` (o presiona `Ctrl + Alt + Shift + S`)
2. En la sección **Project**:
   - **SDK**: Selecciona **21** (si no aparece, haz clic en `Add SDK` → `Download JDK`)
   - **Language level**: Selecciona **21**
3. Haz clic en `Apply` y luego `OK`

### Paso 3️⃣: Marcar Carpetas de Ejercicios como Source Roots

Para cada carpeta de ejercicio, haz lo siguiente:

1. Navega a `bootcamp/semana-00/2-practica/`
2. Click derecho en `ejercicio-01-hola-mundo/`
3. Selecciona `Mark Directory as` → **`Sources Root`**
4. La carpeta debe cambiar de color (ícono azul 📁🔵)

**Repite este paso para:**
- ✅ `ejercicio-01-hola-mundo/`
- ✅ `ejercicio-02-variables/`
- ✅ `ejercicio-03-control/`
- ✅ `ejercicio-04-arrays/`
- ✅ `ejercicio-05-metodos/`
- ✅ `ejercicio-06-integrador/`

### Paso 4️⃣: Excluir Carpetas de Documentación

Estas carpetas no contienen código compilable:

1. Click derecho en `bootcamp/semana-00/0-assets/`
2. Selecciona `Mark Directory as` → **`Excluded`**

**Repite para:**
- ❌ `0-assets/` (recursos gráficos)
- ❌ `1-teoria/` (documentación)
- ❌ `3-recursos/` (glosario)

### Paso 5️⃣: Probar la Configuración

1. Abre `bootcamp/semana-00/2-practica/ejercicio-01-hola-mundo/HolaMundo.java`
2. Busca el **ícono verde ▶️** al lado de `public static void main`
3. Haz clic en el ícono verde
4. Selecciona `Run 'HolaMundo.main()'`
5. Deberías ver "¡Hola Mundo!" en la consola

---

## ✅ Verificación de Configuración

Tu proyecto debe verse así en el panel lateral:

```
oop_java/
└── bootcamp/
    └── semana-00/
        ├── 📁 0-assets/         ❌ (Excluded - ícono gris)
        ├── 📁 1-teoria/         ❌ (Excluded - ícono gris)
        ├── 📁 2-practica/
        │   ├── 📁🔵 ejercicio-01-hola-mundo/  ✅ (Sources - ícono azul)
        │   ├── 📁🔵 ejercicio-02-variables/   ✅ (Sources - ícono azul)
        │   ├── 📁🔵 ejercicio-03-control/     ✅ (Sources - ícono azul)
        │   ├── 📁🔵 ejercicio-04-arrays/      ✅ (Sources - ícono azul)
        │   ├── 📁🔵 ejercicio-05-metodos/     ✅ (Sources - ícono azul)
        │   └── 📁🔵 ejercicio-06-integrador/  ✅ (Sources - ícono azul)
        └── 📁 3-recursos/       ❌ (Excluded - ícono gris)
```

---

## ▶️ Cómo Ejecutar un Ejercicio

### Método 1: Hacer Clic en el Ícono Verde (MÁS FÁCIL)

1. Abre cualquier archivo `.java` que tenga `public static void main(...)`
2. Busca el **ícono verde ▶️** en el margen izquierdo
3. Haz clic → `Run 'NombreClase.main()'`

### Método 2: Usar Atajo de Teclado

1. Abre el archivo Java
2. Presiona `Shift + F10`
3. El programa se ejecutará

### Método 3: Menú Run

1. Abre el archivo Java
2. `Run` → `Run...`
3. Selecciona la clase

---

## ⌨️ Atajos Esenciales para Comenzar

| Atajo | Acción |
|-------|--------|
| `Shift + F10` | Ejecutar programa |
| `Ctrl + Alt + L` | Formatear código |
| `Ctrl + Space` | Autocompletar |
| `Ctrl + S` | Guardar todo |
| `Ctrl + /` | Comentar línea |
| `Alt + F12` | Abrir terminal |

---

## 🎨 Configuración Recomendada

### Activar Numeración de Líneas

1. `File` → `Settings`
2. `Editor` → `General` → `Appearance`
3. ☑️ **Show line numbers**
4. `Apply` → `OK`

### Configurar Auto-Formato

1. `File` → `Settings`
2. `Editor` → `Code Style` → `Java`
3. **Tab size**: 4
4. **Indent**: 4
5. ☑️ **Use spaces** (no usar tabs)
6. `Apply` → `OK`

### Activar Auto-Import

1. `File` → `Settings`
2. `Editor` → `General` → `Auto Import`
3. ☑️ **Add unambiguous imports on the fly**
4. ☑️ **Optimize imports on the fly**
5. `Apply` → `OK`

---

## 🐛 Solución de Problemas

### ❌ Error: "No JDK configured"

**Solución:**
1. `File` → `Project Structure` → `Project`
2. `Project SDK` → `Add SDK` → `Download JDK`
3. Selecciona **Oracle OpenJDK 21**

### ❌ Error: "Cannot find or load main class"

**Solución:**
1. Verifica que la carpeta del ejercicio esté marcada como **Sources Root** (azul)
2. `Build` → `Rebuild Project`
3. Intenta ejecutar de nuevo

### ❌ IntelliJ está muy lento

**Solución:**
1. `Help` → `Change Memory Settings`
2. **Heap Size**: 2048 MB
3. Reiniciar IntelliJ

### ❌ Los cambios no se reflejan al ejecutar

**Solución:**
1. Presiona `Ctrl + F9` (Build Project)
2. Ejecuta de nuevo con `Shift + F10`

---

## 📚 Recursos Adicionales

- 📖 **Guía Completa**: Ver [`docs/GUIA-INTELLIJ-SOURCE-ROOTS.md`](../../docs/GUIA-INTELLIJ-SOURCE-ROOTS.md)
- 📖 **Guía Avanzada**: Ver [`docs/GUIA-INTELLIJ-IDEA.md`](../../docs/GUIA-INTELLIJ-IDEA.md)
- 🎥 **Tutorial IntelliJ**: https://www.jetbrains.com/idea/guide/
- 📄 **Atajos PDF**: https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf

---

## ✅ Checklist Final

Antes de empezar a programar, verifica:

- [ ] IntelliJ IDEA abierto con el proyecto `oop_java`
- [ ] JDK 21 configurado en `Project Structure`
- [ ] Las 6 carpetas de ejercicios marcadas como **Sources Root** (azul)
- [ ] Carpetas de documentación marcadas como **Excluded** (gris)
- [ ] Ejecutado `HolaMundo.java` exitosamente
- [ ] Numeración de líneas activada
- [ ] Auto-import configurado

---

## 🆘 ¿Necesitas Ayuda?

Si tienes problemas con la configuración:

1. Revisa la sección **Solución de Problemas** arriba
2. Consulta la guía completa en `docs/GUIA-INTELLIJ-SOURCE-ROOTS.md`
3. Pregunta al instructor durante la sesión
4. Revisa la documentación oficial: https://www.jetbrains.com/idea/documentation/

---

**¡Listo para programar!** 🚀

Ahora puedes comenzar con los ejercicios de la Semana 0.

---

**Última actualización**: 3 de octubre de 2025  
**Bootcamp**: POO Java - SENA  
**Semana**: 0 - Fundamentos de Java
