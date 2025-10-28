# Ejercicios Prácticos - Semana 02: Clases y Objetos

## 📚 Descripción

Esta carpeta contiene 4 ejercicios prácticos progresivos para dominar los conceptos fundamentales de clases y objetos en Java. Los ejercicios construyen sobre el conocimiento previo de la semana 00 (fundamentos de Java).

---

## 🎯 Objetivos de Aprendizaje

Al completar estos ejercicios, serás capaz de:

1. ✅ Crear clases con atributos y métodos
2. ✅ Instanciar objetos usando `new`
3. ✅ Entender la diferencia entre clase y objeto
4. ✅ Aplicar encapsulación básica con `private` y getters/setters
5. ✅ Modelar entidades del mundo real en código
6. ✅ Usar constructores para inicializar objetos

---

## 📋 Lista de Ejercicios

### Ejercicio 1: Primera Clase Básica ⭐
**Dificultad:** Muy Básico  
**Duración estimada:** 20 minutos  
**Objetivo:** Crear tu primera clase con atributos y métodos simples

**Temas:**
- Sintaxis de clase
- Atributos (variables de instancia)
- Métodos básicos
- Compilación y ejecución

**Archivos:**
- `ejercicio-01-clase-basica/`

---

### Ejercicio 2: Atributos y Métodos ⭐⭐
**Dificultad:** Básico  
**Duración estimada:** 30 minutos  
**Objetivo:** Trabajar con múltiples atributos y métodos más complejos

**Temas:**
- Múltiples atributos de diferentes tipos
- Métodos con parámetros
- Métodos con retorno
- Métodos void vs métodos con return

**Archivos:**
- `ejercicio-02-atributos-metodos/`

---

### Ejercicio 3: Instanciación de Objetos ⭐⭐
**Dificultad:** Básico  
**Duración estimada:** 35 minutos  
**Objetivo:** Crear y manipular múltiples objetos

**Temas:**
- Palabra clave `new`
- Múltiples instancias de una clase
- Diferencia entre clase y objeto
- Referencias a objetos
- Constructores básicos

**Archivos:**
- `ejercicio-03-instanciacion/`

---

### Ejercicio 4: Encapsulación Básica ⭐⭐⭐
**Dificultad:** Intermedio  
**Duración estimada:** 45 minutos  
**Objetivo:** Aplicar encapsulación con modificadores de acceso

**Temas:**
- Modificador `private`
- Métodos getter y setter
- Validación de datos
- Buenas prácticas de encapsulación

**Archivos:**
- `ejercicio-04-encapsulacion-basica/`

---

## 📊 Niveles de Dificultad

| Símbolo | Nivel | Descripción |
|---------|-------|-------------|
| ⭐ | Muy Básico | Primer contacto con el concepto |
| ⭐⭐ | Básico | Aplicación directa de conceptos |
| ⭐⭐⭐ | Intermedio | Requiere análisis y diseño simple |

---

## 🗂️ Estructura de Cada Ejercicio

Cada carpeta de ejercicio contiene:

```
ejercicio-XX-nombre/
├── README.md                  # Instrucciones completas del ejercicio
├── enunciado.md              # Descripción del problema a resolver
└── solucion/                 # Solución propuesta (para referencia)
    ├── *.java
    └── README.md
```

---

## 🎓 Metodología de Trabajo

### Recomendación de Flujo

1. **Lee** el README.md del ejercicio
2. **Lee** el enunciado.md completo
3. **Planifica** mentalmente tu solución
4. **Implementa** el código paso a paso
5. **Compila** y prueba frecuentemente
6. **Verifica** que cumple todos los requisitos
7. **Compara** con la solución (solo después de intentar)

### Trabajo Individual vs Colaborativo

**Individual:**
- Mayor autonomía y aprendizaje profundo
- Ideal para ejercicios 1 y 2

**Pair Programming:**
- Un estudiante escribe (Driver)
- Otro guía y revisa (Navigator)
- Intercambiar roles cada 10-15 minutos
- Ideal para ejercicios 3 y 4

---

## ✅ Checklist por Ejercicio

Antes de considerar un ejercicio completo:

- [ ] El código compila sin errores
- [ ] El código ejecuta correctamente
- [ ] Cumple todos los requisitos del enunciado
- [ ] Nombres de variables y métodos son descriptivos
- [ ] Código está indentado correctamente
- [ ] Incluye comentarios en partes clave
- [ ] Has probado con diferentes valores
- [ ] Entiendes cada línea que escribiste

---

## 🚀 Cómo Compilar y Ejecutar

### Desde la Terminal

```bash
# Navegar a la carpeta del ejercicio
cd ejercicio-01-clase-basica/

# Compilar
javac *.java

# Ejecutar
java Main
```

### Desde IntelliJ IDEA

1. Abrir la carpeta del ejercicio
2. Click derecho en `Main.java`
3. Seleccionar "Run 'Main.main()'"

---

## 📝 Formato de Entrega

### Estructura en GitHub

```
repositorio-apellido-nombre/
├── semana-02/
│   ├── ejercicio-01/
│   │   ├── src/
│   │   │   ├── Persona.java
│   │   │   └── Main.java
│   │   └── README.md
│   ├── ejercicio-02/
│   │   ├── src/
│   │   └── README.md
│   ├── ejercicio-03/
│   │   ├── src/
│   │   └── README.md
│   └── ejercicio-04/
│       ├── src/
│       └── README.md
```

### Requisitos de Entrega

- ✅ Repositorio GitHub estructurado
- ✅ Código compilable y funcional
- ✅ README.md en cada ejercicio con instrucciones
- ✅ Comentarios en el código
- ❌ NO archivos .zip o .rar
- ❌ NO archivos sueltos sin estructura

---

## 🎯 Criterios de Evaluación

| Criterio | Peso | Descripción |
|----------|------|-------------|
| **Funcionalidad** | 40% | ¿El código hace lo que debe? |
| **Correctitud** | 25% | ¿Usa clases y objetos correctamente? |
| **Código Limpio** | 20% | ¿Es legible y bien formateado? |
| **Buenas Prácticas** | 15% | ¿Sigue convenciones Java? |

---

## 💡 Tips para el Éxito

### Antes de Codificar

1. ✏️ **Dibuja** un diagrama simple de la clase
2. 📝 **Lista** qué atributos necesitas
3. 🔧 **Identifica** qué métodos son necesarios
4. 🤔 **Piensa** en los tipos de datos apropiados

### Durante la Codificación

1. 🚦 **Empieza simple:** Primero atributos, luego métodos básicos
2. 🔨 **Compila frecuentemente:** No escribas todo y luego compiles
3. 🧪 **Prueba cada método:** Verifica que funciona antes de continuar
4. 💬 **Comenta:** Explica partes no obvias

### Después de Codificar

1. ✅ **Verifica** todos los requisitos cumplidos
2. 🔍 **Revisa** nombres de variables (¿son descriptivos?)
3. 📐 **Formatea** el código (indentación consistente)
4. 🤓 **Compara** con la solución (¿hay mejores formas?)

---

## 🐛 Errores Comunes

### 1. Confundir Clase con Objeto

```java
// ❌ INCORRECTO - Persona es una clase, no un objeto
Persona.nombre = "Juan";

// ✅ CORRECTO - p es un objeto de la clase Persona
Persona p = new Persona();
p.nombre = "Juan";
```

### 2. Olvidar instanciar con `new`

```java
// ❌ INCORRECTO - Solo declaración
Persona p;
p.nombre = "Juan";  // NullPointerException

// ✅ CORRECTO - Declaración + instanciación
Persona p = new Persona();
p.nombre = "Juan";
```

### 3. Atributos públicos (sin encapsulación)

```java
// ⚠️ MAL - Atributos públicos
public class Persona {
    public String nombre;  // Cualquiera puede modificar
}

// ✅ MEJOR - Atributos privados con getters/setters
public class Persona {
    private String nombre;
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
```

### 4. Método main en la clase de dominio

```java
// ❌ INCORRECTO - main en clase de dominio
public class Persona {
    String nombre;
    
    public static void main(String[] args) {
        // Código de prueba aquí
    }
}

// ✅ CORRECTO - main en clase separada
public class Main {
    public static void main(String[] args) {
        Persona p = new Persona();
        // Código de prueba aquí
    }
}
```

---

## 🔗 Recursos Relacionados

### Material Teórico de la Semana

- `/1-teoria/01-concepto-clase.md` - ¿Qué es una clase?
- `/1-teoria/02-concepto-objeto.md` - ¿Qué es un objeto?
- `/1-teoria/03-atributos-metodos.md` - Componentes de una clase
- `/1-teoria/04-instanciacion.md` - Crear objetos con `new`
- `/1-teoria/05-encapsulacion-basica.md` - Modificadores de acceso

### Glosario y Referencias

- `/3-recursos/glosario.md` - Términos clave
- `/3-recursos/referencias.md` - Links externos útiles

---

## 📈 Progreso Recomendado

### Durante la Sesión de Clase (4 horas)

| Tiempo | Actividad |
|--------|-----------|
| 0:00 - 0:50 | Ejercicio 1 + Ejercicio 2 (inicio) |
| 0:50 - 1:05 | **Descanso** ☕ |
| 1:05 - 1:55 | Ejercicio 2 (fin) + Ejercicio 3 (inicio) |
| 1:55 - 2:10 | **Descanso** ☕ |
| 2:10 - 3:00 | Ejercicio 3 (fin) + Ejercicio 4 (inicio) |
| 3:00 - 3:15 | **Descanso** ☕ |
| 3:15 - 4:00 | Ejercicio 4 (fin) + revisión |

### Trabajo Autónomo (2 horas recomendadas)

- Completar ejercicios pendientes
- Refactorizar código
- Experimentar con variaciones
- Revisar soluciones
- Documentar aprendizajes

---

## 🏆 Desafíos Adicionales

Si terminas los ejercicios antes de tiempo:

1. **Mejora tu código:**
   - Agrega validaciones
   - Mejora los nombres de variables
   - Agrega más métodos útiles

2. **Crea tu propia clase:**
   - Modela algo de tu interés (Mascota, Videojuego, etc.)
   - Aplica todo lo aprendido
   - Hazla lo más completa posible

3. **Documenta con Javadoc:**
   - Aprende sintaxis de Javadoc
   - Documenta tus clases y métodos
   - Genera documentación HTML

4. **Experimento con objetos:**
   - Crea un array de objetos
   - Implementa búsqueda de objetos
   - Modifica objetos en masa

---

## 📊 Autoevaluación

Después de cada ejercicio, reflexiona:

- [ ] ¿Entiendo la diferencia entre clase y objeto?
- [ ] ¿Puedo crear una clase desde cero?
- [ ] ¿Sé cuándo usar atributos vs variables locales?
- [ ] ¿Entiendo para qué sirven los getters y setters?
- [ ] ¿Puedo explicar mi código a un compañero?
- [ ] ¿Qué fue lo más difícil y cómo lo resolví?

---

## 🆘 ¿Necesitas Ayuda?

### Durante la Clase
1. 🙋 Levanta la mano y pregunta al instructor
2. 👥 Consulta con un compañero
3. 📖 Revisa el material teórico

### Fuera de Clase
1. 📧 Email al instructor
2. 💬 Foro del curso en Teams/Moodle
3. 📚 Documentación oficial de Java
4. 🌐 Stack Overflow (para dudas específicas)

### Recursos Online
- [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/)
- [W3Schools Java](https://www.w3schools.com/java/)
- [GeeksforGeeks Java](https://www.geeksforgeeks.org/java/)

---

## ⚠️ Política de Copia

**IMPORTANTE:**

- ✅ **Permitido:** Consultar documentación, tutoriales, ejemplos
- ✅ **Permitido:** Discutir conceptos con compañeros
- ✅ **Permitido:** Pedir ayuda al instructor
- ❌ **NO permitido:** Copiar código de compañeros
- ❌ **NO permitido:** Compartir soluciones completas
- ❌ **NO permitido:** Usar código sin entenderlo

**Consecuencias:** Código copiado = Calificación de 0.0

**Filosofía:** El objetivo es **aprender**, no solo "entregar". Si copias, te engañas a ti mismo.

---

## 🎉 Motivación Final

> "Programar es como aprender a tocar un instrumento: la práctica constante es la clave del dominio."

**Recuerda:**
- 💪 Todos empezamos desde cero
- 🐢 El progreso es más importante que la velocidad
- 🧠 Los errores son oportunidades de aprendizaje
- 🎯 Cada línea de código te acerca a ser mejor programador

**¡Disfruta el proceso de aprendizaje!** 🚀

---

**Bootcamp POO Java - SENA | Semana 02 - Prácticas**  
**Última actualización:** Octubre 2025  
**Versión:** 1.0
