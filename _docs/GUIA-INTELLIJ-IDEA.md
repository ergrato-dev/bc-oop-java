# 🚀 Guía de Configuración de IntelliJ IDEA para Bootcamp POO Java

## 📋 Índice
1. [Estructura Recomendada](#estructura-recomendada)
2. [Configuración Inicial](#configuración-inicial)
3. [Importar Proyecto](#importar-proyecto)
4. [Configurar Módulos](#configurar-módulos)
5. [Ejecutar Ejercicios](#ejecutar-ejercicios)
6. [Atajos y Productividad](#atajos-y-productividad)
7. [Plugins Recomendados](#plugins-recomendados)

---

## 🏗️ Estructura Recomendada

### Opción 1: Proyecto Multi-Módulo (⭐ RECOMENDADA)

Esta estructura permite:
- ✅ Cada semana como módulo independiente
- ✅ Compilación y ejecución por ejercicio
- ✅ Sin conflictos de nombres entre clases
- ✅ Facilita testing unitario

```
oop_java/                                    # Proyecto raíz
├── .idea/                                   # Configuración IntelliJ
│   ├── .gitignore
│   ├── misc.xml                             # JDK y configuración
│   ├── modules.xml                          # Módulos del proyecto
│   ├── encodings.xml                        # UTF-8
│   └── codeStyles/
│       └── Project.xml                      # Estilo de código
├── bootcamp/
│   ├── semana-00/
│   │   ├── semana-00.iml                   # Módulo IntelliJ
│   │   ├── src/
│   │   │   └── main/
│   │   │       └── java/
│   │   │           └── com/
│   │   │               └── sena/
│   │   │                   └── bootcamp/
│   │   │                       └── semana00/
│   │   │                           ├── ejercicio01/
│   │   │                           │   ├── HolaMundo.java
│   │   │                           │   └── MiPrimerPrograma.java
│   │   │                           ├── ejercicio02/
│   │   │                           │   ├── Calculadora.java
│   │   │                           │   └── ConversionTemperatura.java
│   │   │                           ├── ejercicio03/
│   │   │                           ├── ejercicio04/
│   │   │                           ├── ejercicio05/
│   │   │                           └── ejercicio06/
│   │   ├── 0-assets/                       # Recursos (no compilables)
│   │   ├── 1-teoria/                       # Documentación
│   │   ├── 2-practica/                     # Ejercicios originales (ref.)
│   │   └── 3-recursos/
│   ├── semana-01/
│   │   └── src/main/java/com/sena/bootcamp/semana01/
│   └── semana-02/
├── out/                                     # Salida compilada (ignorado)
├── .gitignore
└── README.md
```

### Opción 2: Estructura por Source Roots

Mantener estructura actual pero configurando cada carpeta de ejercicio como Source Root:

```
bootcamp/semana-00/2-practica/
├── ejercicio-01-hola-mundo/
│   ├── src/                    ← Marcar como "Sources Root" (azul)
│   │   └── HolaMundo.java
│   └── out/                    ← Compilado aquí
├── ejercicio-02-variables/
│   ├── src/                    ← Marcar como "Sources Root"
│   └── out/
└── ...
```

---

## ⚙️ Configuración Inicial

### Paso 1: Verificar Instalación de JDK

1. Abrir IntelliJ IDEA
2. `File` → `Project Structure` → `SDKs`
3. Verificar **JDK 21** (LTS)
   - Si no está: `+` → `Add JDK` → Seleccionar ruta del JDK

**Rutas comunes en Linux:**
```bash
/usr/lib/jvm/java-21-openjdk
/opt/jdk-21
```

### Paso 2: Configurar Preferencias Globales

1. `File` → `Settings` (Ctrl + Alt + S)
2. **Editor → Code Style → Java**:
   - Indent: 4 espacios
   - Tab size: 4
   - Continuation indent: 4
   - ✅ Use tab character: NO (usar espacios)

3. **Editor → General → Auto Import**:
   - ✅ Add unambiguous imports on the fly
   - ✅ Optimize imports on the fly

4. **Editor → Font**:
   - Font: JetBrains Mono o Fira Code
   - Size: 14-16
   - ✅ Enable ligatures (opcional)

5. **Build, Execution, Deployment → Compiler**:
   - ✅ Build project automatically
   - Heap size: 2048 MB (para proyectos grandes)

---

## 📂 Importar Proyecto

### Método 1: Abrir Como Proyecto Existente

1. `File` → `Open`
2. Navegar a: `/home/epti/Documentos/sena/4T25/oop_java`
3. Seleccionar la carpeta raíz `oop_java`
4. Click `OK`
5. IntelliJ detectará automáticamente la estructura

### Método 2: Clonar desde Git (Para Estudiantes)

1. `File` → `New` → `Project from Version Control`
2. URL: `https://github.com/ergrato-dev/bc-oop-java.git`
3. Directory: Elegir ubicación local
4. Click `Clone`

---

## 🔧 Configurar Módulos

### Opción 1: Configuración Manual (Estructura Actual)

Para cada carpeta de ejercicio:

1. Click derecho en `ejercicio-XX-nombre/`
2. `Mark Directory as` → `Sources Root` (carpeta src si existe)
3. Crear carpeta `out` para compilados
4. Click derecho en `out/` → `Mark Directory as` → `Excluded`

**Automatizar con terminal:**

```bash
cd /home/epti/Documentos/sena/4T25/oop_java/bootcamp/semana-00/2-practica

# Crear estructura src para cada ejercicio
for dir in ejercicio-*/; do
    mkdir -p "$dir/src"
    mkdir -p "$dir/out"
    # Mover archivos .java a src/
    mv "$dir"/*.java "$dir/src/" 2>/dev/null || true
done
```

### Opción 2: Crear Módulo Unificado (RECOMENDADO)

**Estructura a crear:**

```bash
cd /home/epti/Documentos/sena/4T25/oop_java/bootcamp/semana-00

# Crear estructura estándar
mkdir -p src/main/java/com/sena/bootcamp/semana00
mkdir -p out
```

**Migrar ejercicios:**

```bash
# Copiar archivos a nueva estructura con paquetes
cp 2-practica/ejercicio-01-hola-mundo/*.java \
   src/main/java/com/sena/bootcamp/semana00/ejercicio01/

cp 2-practica/ejercicio-02-variables/*.java \
   src/main/java/com/sena/bootcamp/semana00/ejercicio02/

# Continuar con ejercicios 03-06...
```

**Configurar en IntelliJ:**

1. Click derecho en `semana-00/`
2. `Mark Directory as` → `Module`
3. Click derecho en `src/` → `Mark Directory as` → `Sources Root`
4. Click derecho en `out/` → `Mark Directory as` → `Excluded`

---

## ▶️ Ejecutar Ejercicios

### Método 1: Run Configuration

1. Abrir archivo Java con método `main()`
2. Click en el ícono verde ▶️ al lado de `public static void main`
3. Seleccionar `Run 'NombreClase.main()'`

### Método 2: Configuración Permanente

1. `Run` → `Edit Configurations...`
2. `+` → `Application`
3. Configurar:
   - **Name**: Ejercicio 01 - Hola Mundo
   - **Main class**: HolaMundo
   - **Module**: semana-00
   - **Working directory**: `$MODULE_DIR$`
4. `Apply` → `OK`

### Método 3: Terminal Integrada

```bash
# Compilar
javac -d out src/main/java/com/sena/bootcamp/semana00/ejercicio01/HolaMundo.java

# Ejecutar
java -cp out com.sena.bootcamp.semana00.ejercicio01.HolaMundo
```

---

## ⌨️ Atajos y Productividad

### Atajos Esenciales

| Acción | Atajo | Descripción |
|--------|-------|-------------|
| **Buscar en proyecto** | `Ctrl + Shift + F` | Buscar texto en todos los archivos |
| **Buscar clase** | `Ctrl + N` | Buscar clase por nombre |
| **Buscar archivo** | `Ctrl + Shift + N` | Buscar archivo cualquiera |
| **Ejecutar** | `Shift + F10` | Ejecutar última configuración |
| **Debug** | `Shift + F9` | Ejecutar en modo debug |
| **Formatear código** | `Ctrl + Alt + L` | Auto-formatear según estilo |
| **Optimizar imports** | `Ctrl + Alt + O` | Eliminar imports no usados |
| **Completar código** | `Ctrl + Space` | Autocompletar inteligente |
| **Generar código** | `Alt + Insert` | Generar getters, setters, constructores |
| **Refactorizar** | `Ctrl + Alt + Shift + T` | Menú de refactoring |
| **Renombrar** | `Shift + F6` | Renombrar variable/clase |
| **Duplicar línea** | `Ctrl + D` | Duplicar línea actual |
| **Eliminar línea** | `Ctrl + Y` | Eliminar línea completa |
| **Comentar línea** | `Ctrl + /` | Comentar/descomentar |
| **Comentar bloque** | `Ctrl + Shift + /` | Comentario multilínea |
| **Terminal** | `Alt + F12` | Abrir terminal integrada |

### Live Templates (Snippets)

Configurar en: `File` → `Settings` → `Editor` → `Live Templates`

**Crear template "sout":**
```java
System.out.println($END$);
```

**Otros útiles:**
- `psvm` → `public static void main(String[] args)`
- `sout` → `System.out.println();`
- `fori` → `for (int i = 0; i < ; i++)`
- `iter` → `for (Type item : collection)`

---

## 🔌 Plugins Recomendados

### Instalación: `File` → `Settings` → `Plugins`

1. **Rainbow Brackets** 🌈
   - Colorea paréntesis, llaves y corchetes
   - Mejora legibilidad de código anidado

2. **Key Promoter X** ⌨️
   - Sugiere atajos cuando usas el ratón
   - Aprende atajos de teclado más rápido

3. **CodeGlance Pro** 📊
   - Minimapa del código a la derecha
   - Navegación rápida en archivos grandes

4. **GitToolBox** 🔧
   - Mejoras en integración con Git
   - Muestra blame inline

5. **String Manipulation** ✂️
   - Transformaciones de texto avanzadas
   - CamelCase, snake_case, etc.

6. **SonarLint** 🔍
   - Análisis de código en tiempo real
   - Detecta bugs y code smells

7. **Markdown** 📝
   - Ya incluido, activar preview
   - Para editar READMEs

---

## 📊 Configuración de Estructura de Proyecto

### Acceso: `File` → `Project Structure` (Ctrl + Alt + Shift + S)

#### 1. Project

- **Project SDK**: 21 (java version "21")
- **Project language level**: 21 - Record patterns, pattern matching for switch
- **Project compiler output**: `$PROJECT_DIR$/out`

#### 2. Modules

Para cada módulo (semana):

- **Name**: semana-00
- **Sources**: `src/main/java`
- **Resources**: `0-assets/`, `1-teoria/`, `3-recursos/`
- **Excluded**: `out/`, `2-practica/` (si usas estructura nueva)
- **Dependencies**: JDK 21

#### 3. Libraries

- JDK 21 (automático)
- JUnit 5 (para testing - opcional)

---

## 🎯 Convenciones de Código

### Nomenclatura

```java
// Clases: PascalCase
public class MiPrimerPrograma { }

// Métodos y variables: camelCase
public void calcularPromedio() { }
int numeroEstudiantes = 30;

// Constantes: UPPER_SNAKE_CASE
public static final int MAX_INTENTOS = 3;

// Paquetes: lowercase
package com.sena.bootcamp.semana00;
```

### Estructura de Archivo Java

```java
// 1. Package
package com.sena.bootcamp.semana00.ejercicio01;

// 2. Imports (alfabético)
import java.util.Scanner;

// 3. Comentario de clase
/**
 * Programa que imprime "Hola Mundo" en consola.
 * 
 * @author Nombre del Estudiante
 * @version 1.0
 * @since 2025-10-03
 */
// 4. Declaración de clase
public class HolaMundo {
    
    // 5. Constantes
    private static final String MENSAJE = "Hola Mundo";
    
    // 6. Variables de instancia
    private String nombre;
    
    // 7. Constructor
    public HolaMundo() {
        // ...
    }
    
    // 8. Método main (si aplica)
    public static void main(String[] args) {
        System.out.println(MENSAJE);
    }
    
    // 9. Métodos públicos
    public void metodoPublico() {
        // ...
    }
    
    // 10. Métodos privados
    private void metodoPrivado() {
        // ...
    }
    
    // 11. Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
```

---

## 🐛 Debugging en IntelliJ

### Configurar Breakpoints

1. Click en la línea donde quieres pausar (margen izquierdo)
2. Aparece un círculo rojo 🔴

### Ejecutar en Debug

1. `Run` → `Debug 'NombreClase'` (Shift + F9)
2. El programa se detiene en el breakpoint

### Ventana de Debug

| Panel | Función |
|-------|---------|
| **Variables** | Ver valores de variables actuales |
| **Watches** | Monitorear expresiones específicas |
| **Call Stack** | Ver pila de llamadas de métodos |
| **Console** | Salida del programa |

### Controles de Debug

| Acción | Atajo | Descripción |
|--------|-------|-------------|
| **Step Over** | `F8` | Ejecutar línea actual |
| **Step Into** | `F7` | Entrar en método |
| **Step Out** | `Shift + F8` | Salir de método actual |
| **Resume** | `F9` | Continuar ejecución |
| **Evaluate** | `Alt + F8` | Evaluar expresión |

---

## 📚 Estructura de Paquetes Recomendada

```
com.sena.bootcamp.semana00
├── ejercicio01
│   ├── HolaMundo.java
│   └── MiPrimerPrograma.java
├── ejercicio02
│   ├── Calculadora.java
│   └── ConversionTemperatura.java
├── ejercicio03
│   ├── EstructurasDecision.java
│   ├── Bucles.java
│   └── MenuInteractivo.java
├── ejercicio04
│   ├── OperacionesArrays.java
│   ├── EstadisticasNotas.java
│   └── BusquedaOrdenamiento.java
├── ejercicio05
│   ├── MetodosBasicos.java
│   ├── BibliotecaMatematicas.java
│   └── ValidacionDatos.java
└── ejercicio06
    └── SistemaGestion.java
```

**Ventajas:**
- ✅ Sin conflictos de nombres de clases
- ✅ Organización clara por ejercicio
- ✅ Facilita imports entre ejercicios
- ✅ Estructura profesional desde el inicio

---

## 🔄 Flujo de Trabajo Recomendado

### Para Instructores

1. **Preparar ejercicio**
   - Crear nueva clase en paquete correspondiente
   - Agregar comentarios Javadoc
   - Incluir TODOs para estudiantes

2. **Compartir con estudiantes**
   - Push a GitHub
   - Estudiantes hacen pull
   - Abren proyecto en IntelliJ

3. **Revisar trabajos**
   - Pull de cambios de estudiantes
   - Ejecutar y probar
   - Comentarios en código

### Para Estudiantes

1. **Obtener ejercicio**
   ```bash
   git pull origin main
   ```

2. **Trabajar en ejercicio**
   - Abrir clase en IntelliJ
   - Implementar TODOs
   - Ejecutar y probar

3. **Entregar trabajo**
   ```bash
   git add .
   git commit -m "feat(semana-00): completar ejercicio 01"
   git push
   ```

---

## 🎓 Tips para Principiantes

### 1. Usar el Auto-formato Constantemente

Después de escribir código:
```
Ctrl + Alt + L (Linux)
```

### 2. Aprovechar el Autocompletado

Escribir primeras letras + `Ctrl + Space`:
```java
Sys → Ctrl+Space → System.out.println()
```

### 3. Generar Código Automáticamente

En clase vacía: `Alt + Insert`
- Constructor
- Getters/Setters
- toString()
- equals() y hashCode()

### 4. Ver Documentación Rápida

Posicionar cursor en método/clase + `Ctrl + Q`

### 5. Navegar entre Errores

- Siguiente error: `F2`
- Error anterior: `Shift + F2`
- Ver descripción: `Ctrl + F1`

---

## 🔍 Solución de Problemas Comunes

### "No JDK configured"

**Solución:**
1. `File` → `Project Structure` → `Project`
2. `Project SDK` → `Add SDK` → `Download JDK`
3. Vendor: Oracle OpenJDK
4. Version: 21

### "Cannot resolve symbol"

**Causas:**
- Falta import
- Clase no está en el classpath
- Proyecto no está compilado

**Solución:**
1. `File` → `Invalidate Caches` → `Invalidate and Restart`
2. `Build` → `Rebuild Project`

### Código no se ejecuta con cambios recientes

**Solución:**
```
Build → Build Project (Ctrl + F9)
```

### IntelliJ lento

**Optimizaciones:**
1. Aumentar heap size:
   - `Help` → `Change Memory Settings`
   - Heap Size: 2048-4096 MB

2. Excluir directorios grandes:
   - Click derecho en carpeta
   - `Mark Directory as` → `Excluded`

3. Deshabilitar plugins no usados:
   - `File` → `Settings` → `Plugins`
   - Deshabilitar plugins no necesarios

---

## 📖 Recursos Adicionales

### Documentación Oficial

- [IntelliJ IDEA Docs](https://www.jetbrains.com/idea/documentation/)
- [Java 21 API Docs](https://docs.oracle.com/en/java/javase/21/docs/api/)

### Cursos y Tutoriales

- [IntelliJ IDEA Tutorial (JetBrains)](https://www.jetbrains.com/idea/guide/)
- [Java Bootcamp Resources](../README.md)

### Atajos Personalizados

`File` → `Settings` → `Keymap` → Buscar acción → Click derecho → `Add Keyboard Shortcut`

---

## ✅ Checklist de Configuración

- [ ] JDK 21 instalado y configurado
- [ ] Proyecto importado en IntelliJ
- [ ] Estructura de carpetas configurada
- [ ] Source roots marcadas correctamente
- [ ] Estilo de código configurado (4 espacios)
- [ ] Encoding UTF-8 configurado
- [ ] Plugins básicos instalados
- [ ] Git integrado y funcionando
- [ ] Primer programa compilado y ejecutado
- [ ] Familiarizado con atajos básicos

---

**Última actualización**: 3 de octubre de 2025  
**Versión IntelliJ**: 2024.2+  
**Versión Java**: 21 LTS
