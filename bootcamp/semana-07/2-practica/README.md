# Ejercicios Prácticos - Semana 07

## 📚 Manejo de Paquetes y Excepciones

Esta carpeta contiene 4 ejercicios progresivos para dominar la organización en paquetes y el manejo de excepciones en Java.

---

## 🎯 Objetivos

Al completar estos ejercicios, serás capaz de:

1. ✅ Organizar código en paquetes siguiendo convenciones profesionales
2. ✅ Implementar try-catch-finally para manejo robusto de errores
3. ✅ Crear excepciones personalizadas específicas del dominio
4. ✅ Integrar paquetes y excepciones en un sistema completo

---

## 📂 Estructura de Ejercicios

### Ejercicio 01: Organización en Paquetes
**Dificultad**: ⭐⭐☆☆☆  
**Tiempo estimado**: 30 minutos  
**Objetivo**: Crear una estructura de paquetes correcta y usar import

**Contenido**:
- Crear 3 paquetes diferentes (`modelo`, `servicio`, `util`)
- Declarar 5 clases en paquetes apropiados
- Practicar imports (específicos, wildcard, static)
- Compilar y ejecutar desde terminal

---

### Ejercicio 02: Manejo Básico de Excepciones
**Dificultad**: ⭐⭐☆☆☆  
**Tiempo estimado**: 40 minutos  
**Objetivo**: Implementar try-catch-finally para manejar errores comunes

**Contenido**:
- Try-catch para `ArithmeticException`
- Múltiples catch blocks (específico a general)
- Finally para limpieza de recursos
- Manejo de `NullPointerException`
- Práctica con `IOException` (lectura de archivos)

---

### Ejercicio 03: Excepciones Personalizadas
**Dificultad**: ⭐⭐⭐☆☆  
**Tiempo estimado**: 45 minutos  
**Objetivo**: Crear y usar excepciones específicas del dominio

**Contenido**:
- Crear 2-3 excepciones personalizadas (checked)
- Agregar atributos contextuales
- Lanzar excepciones con `throw`
- Declarar excepciones con `throws`
- Capturar excepciones personalizadas

**Dominios sugeridos**:
- Agencia de Viajes: `ReservaInvalidaException`, `DisponibilidadException`
- Restaurante: `MesaNoDisponibleException`, `PlatilloAgotadoException`
- Biblioteca: `LibroNoDisponibleException`, `PrestamoVencidoException`

---

### Ejercicio 04: Proyecto Integrador
**Dificultad**: ⭐⭐⭐⭐☆  
**Tiempo estimado**: 60 minutos  
**Objetivo**: Sistema completo con paquetes y excepciones

**Contenido**:
- Estructura completa de paquetes:
  ```
  com.tudominio.modelo/
  com.tudominio.servicio/
  com.tudominio.excepciones/
  com.tudominio.util/
  ```
- Mínimo 2 excepciones personalizadas
- Validaciones con excepciones
- Manejo de errores en múltiples niveles
- Main de demostración completo

**Funcionalidades mínimas**:
- Agregar entidad (con validación)
- Listar entidades
- Buscar entidad (puede lanzar excepción)
- Operación crítica con try-catch-finally

---

## 🚀 Cómo Usar Estos Ejercicios

### 1. Lectura Previa
Lee primero los archivos de teoría de la semana 07:
- `1-teoria/01-organizacion-paquetes.md`
- `1-teoria/02-manejo-excepciones.md`
- `1-teoria/03-jerarquia-excepciones.md`
- `1-teoria/04-excepciones-personalizadas.md`

### 2. Orden Sugerido
Completa los ejercicios en orden:
1. Ejercicio 01 (fundamentos de paquetes)
2. Ejercicio 02 (excepciones básicas)
3. Ejercicio 03 (excepciones personalizadas)
4. Ejercicio 04 (integración completa)

### 3. Estructura de Cada Ejercicio

Cada carpeta de ejercicio contiene:
```
ejercicio-XX/
├── README.md           ← Instrucciones detalladas
├── solucion/           ← Solución completa comentada
└── plantilla/          ← Código inicial (opcional)
```

### 4. Compilación y Ejecución

#### Opción A: Desde IDE (IntelliJ IDEA)
1. Abre IntelliJ IDEA
2. File → Open → Selecciona carpeta del ejercicio
3. Marca la carpeta `src` como "Sources Root" (clic derecho → Mark Directory as → Sources Root)
4. Run → Run 'Main'

#### Opción B: Desde Terminal
```bash
# Navegar a la carpeta del ejercicio
cd ejercicio-01/

# Compilar (desde la raíz del proyecto)
javac -d bin src/com/tudominio/*/*.java

# Ejecutar
java -cp bin com.tudominio.Main
```

---

## ✅ Criterios de Evaluación

### Organización de Paquetes (25 puntos)
- ✅ Paquetes siguen convención (com.dominio.modulo)
- ✅ Declaración `package` al inicio de cada archivo
- ✅ Imports correctos y organizados
- ✅ Estructura de carpetas coincide con paquetes

### Manejo de Excepciones (30 puntos)
- ✅ Try-catch implementado correctamente
- ✅ Catch específico (no genérico `Exception`)
- ✅ Finally para limpieza de recursos
- ✅ Mensajes descriptivos en excepciones

### Excepciones Personalizadas (25 puntos)
- ✅ Nombres descriptivos terminan en "Exception"
- ✅ Constructores apropiados (mensaje, mensaje+causa)
- ✅ Atributos contextuales cuando aplica
- ✅ Documentadas con Javadoc

### Código y Buenas Prácticas (20 puntos)
- ✅ Código limpio y legible
- ✅ Comentarios explicativos
- ✅ Validaciones apropiadas
- ✅ Programa compila y ejecuta sin errores

---

## 💡 Consejos

### Para Paquetes:
- 📦 Agrupa clases relacionadas en el mismo paquete
- 📦 Usa nombres en minúsculas y sin espacios
- 📦 Sigue la convención de dominio invertido
- 📦 Evita imports con `*` (usa específicos)

### Para Excepciones:
- ⚠️ Captura solo lo que puedas manejar
- ⚠️ No dejes catch vacíos
- ⚠️ Usa checked para situaciones recuperables
- ⚠️ Usa unchecked para errores de programación
- ⚠️ Incluye contexto en mensajes de error

### Para Depuración:
- 🐛 Usa `printStackTrace()` para debugging (no en producción)
- 🐛 Imprime mensajes en cada paso crítico
- 🐛 Verifica que carpetas coincidan con paquetes
- 🐛 Compila todas las clases antes de ejecutar

---

## 📖 Recursos Adicionales

### Documentación Oficial:
- [Java Packages (Oracle)](https://docs.oracle.com/javase/tutorial/java/package/)
- [Exceptions (Oracle)](https://docs.oracle.com/javase/tutorial/essential/exceptions/)

### Material del Bootcamp:
- `3-recursos/glosario.md` - Términos clave
- `3-recursos/referencias.md` - Enlaces útiles
- `3-recursos/videos.md` - Video tutorial

---

## 🎓 Evaluación Final

Después de completar los 4 ejercicios, deberás:

1. **Entregar** el ejercicio 04 (proyecto integrador) completo
2. **Demostrar** ejecución funcionando sin errores
3. **Explicar** decisiones de diseño (paquetes, excepciones)
4. **Responder** preguntas sobre el código

**Puntaje Total**: 100 puntos
- Ejercicio 01: 20 puntos
- Ejercicio 02: 25 puntos
- Ejercicio 03: 25 puntos
- Ejercicio 04: 30 puntos

---

## ❓ Preguntas Frecuentes

**P: ¿Puedo usar mi propio dominio en vez de los sugeridos?**  
R: ¡Sí! Puedes usar tu dominio asignado desde la semana 01.

**P: ¿Debo crear checked o unchecked exceptions?**  
R: Para errores de negocio recuperables, usa **checked** (extend `Exception`).

**P: ¿Cómo organizo paquetes en IntelliJ?**  
R: Clic derecho en `src` → New → Package → Escribe `com.tudominio.modelo`

**P: ¿Puedo usar try-with-resources?**  
R: Sí, es una excelente práctica para recursos como archivos.

---

**¡Éxito en los ejercicios!** 🚀

Si tienes dudas, consulta primero:
1. Material de teoría
2. Glosario
3. Código de ejemplo en soluciones
4. Instructor
