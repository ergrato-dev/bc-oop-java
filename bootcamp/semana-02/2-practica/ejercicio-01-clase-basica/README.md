# Ejercicio 01 - Primera Clase Básica

## 🎯 Objetivo
Crear tu primera clase en Java con atributos y métodos simples, comprendiendo la estructura básica de una clase.

**Duración estimada:** 20 minutos  
**Dificultad:** ⭐ Muy Básico

---

## 📚 Conceptos a Practicar

- Sintaxis de declaración de clase
- Atributos (variables de instancia)
- Métodos simples
- Creación de objetos con `new`
- Acceso a atributos y métodos

---

## 📝 Enunciado

Crea una clase llamada `Persona` que represente a una persona con información básica.

### Requisitos

**La clase `Persona` debe tener:**

1. **Atributos:**
   - `nombre` (tipo String)
   - `edad` (tipo int)
   - `ciudad` (tipo String)

2. **Métodos:**
   - `saludar()`: Imprime un saludo con el nombre de la persona
   - `mostrarInfo()`: Muestra toda la información de la persona

3. **Clase Main:**
   - Crea un objeto de tipo Persona
   - Asigna valores a sus atributos
   - Llama a los métodos

---

## 💻 Código Inicial

### Estructura de archivos:

```
ejercicio-01-clase-basica/
├── src/
│   ├── Persona.java
│   └── Main.java
└── README.md
```

---

## 🔨 Paso a Paso

### Paso 1: Crear la clase Persona

```java
/**
 * Clase que representa a una persona
 * @author Tu Nombre
 */
public class Persona {
    // TODO: Declarar los atributos aquí
    
    
    // TODO: Crear el método saludar()
    
    
    // TODO: Crear el método mostrarInfo()
    
}
```

### Paso 2: Crear la clase Main

```java
/**
 * Clase principal para probar la clase Persona
 */
public class Main {
    public static void main(String[] args) {
        // TODO: Crear un objeto Persona
        
        // TODO: Asignar valores a los atributos
        
        // TODO: Llamar al método saludar()
        
        // TODO: Llamar al método mostrarInfo()
    }
}
```

---

## ✅ Ejemplo de Salida Esperada

```
¡Hola! Mi nombre es Juan Pérez
========== INFORMACIÓN PERSONAL ==========
Nombre: Juan Pérez
Edad: 25 años
Ciudad: Bogotá
==========================================
```

---

## 🧪 Casos de Prueba

Prueba tu código con estos casos:

### Caso 1:
```java
Persona p1 = new Persona();
p1.nombre = "María González";
p1.edad = 30;
p1.ciudad = "Medellín";
p1.saludar();
p1.mostrarInfo();
```

**Salida esperada:**
```
¡Hola! Mi nombre es María González
========== INFORMACIÓN PERSONAL ==========
Nombre: María González
Edad: 30 años
Ciudad: Medellín
==========================================
```

### Caso 2:
```java
Persona p2 = new Persona();
p2.nombre = "Carlos López";
p2.edad = 22;
p2.ciudad = "Cali";
p2.saludar();
p2.mostrarInfo();
```

---

## 💡 Pistas

1. **Declaración de atributos:**
   ```java
   tipoDato nombreAtributo;
   ```

2. **Declaración de métodos void:**
   ```java
   public void nombreMetodo() {
       // Código del método
   }
   ```

3. **Para imprimir en consola:**
   ```java
   System.out.println("Texto a imprimir");
   ```

4. **Para crear un objeto:**
   ```java
   NombreClase nombreObjeto = new NombreClase();
   ```

5. **Para acceder a atributos:**
   ```java
   nombreObjeto.nombreAtributo = valor;
   ```

6. **Para llamar métodos:**
   ```java
   nombreObjeto.nombreMetodo();
   ```

---

## ⚠️ Errores Comunes

### Error 1: Olvidar el punto y coma
```java
// ❌ INCORRECTO
String nombre

// ✅ CORRECTO
String nombre;
```

### Error 2: Usar mayúsculas en nombres de atributos
```java
// ❌ INCORRECTO (no es convención Java)
String Nombre;

// ✅ CORRECTO (camelCase)
String nombre;
```

### Error 3: Olvidar public en los métodos
```java
// ⚠️ Funciona pero no es recomendado
void saludar() { }

// ✅ MEJOR (explícitamente público)
public void saludar() { }
```

### Error 4: No instanciar el objeto
```java
// ❌ INCORRECTO - Solo declaración
Persona p;
p.nombre = "Juan";  // NullPointerException

// ✅ CORRECTO - Declaración + instanciación
Persona p = new Persona();
p.nombre = "Juan";
```

---

## 🎯 Criterios de Evaluación

| Criterio | Puntos | Descripción |
|----------|--------|-------------|
| **Clase Persona** | 3 | Tiene los 3 atributos correctos |
| **Método saludar()** | 2 | Imprime saludo correctamente |
| **Método mostrarInfo()** | 2 | Muestra toda la información |
| **Clase Main** | 2 | Crea objeto y lo usa correctamente |
| **Compilación** | 1 | El código compila sin errores |

**Total:** 10 puntos

---

## 🚀 Desafíos Adicionales

Si terminas rápido, intenta:

1. **Agregar más atributos:**
   - `telefono` (String)
   - `correo` (String)

2. **Agregar más métodos:**
   - `cumplirAnios()`: Incrementa la edad en 1
   - `cambiarCiudad(String nuevaCiudad)`: Cambia la ciudad

3. **Crear múltiples personas:**
   - Crea 3 objetos diferentes
   - Muestra la información de todos

4. **Formato mejorado:**
   - Usa colores en la consola (ANSI codes)
   - Crea un formato más atractivo

---

## 📝 Preguntas de Reflexión

Después de completar el ejercicio:

1. ¿Cuál es la diferencia entre la clase `Persona` y el objeto `p`?
2. ¿Qué pasa si no usas `new` al crear el objeto?
3. ¿Por qué los atributos están fuera de los métodos?
4. ¿Cuántos objetos `Persona` puedes crear de una clase?
5. ¿Qué significa `void` en la declaración del método?

---

## 🔗 Recursos

- [Oracle: Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html)
- [W3Schools: Java Classes](https://www.w3schools.com/java/java_classes.asp)

---

## 📤 Entrega

### Estructura en GitHub:

```
repositorio-apellido-nombre/
└── semana-02/
    └── ejercicio-01/
        ├── src/
        │   ├── Persona.java
        │   └── Main.java
        └── README.md (opcional: con reflexiones)
```

### Checklist antes de entregar:

- [ ] El código compila sin errores
- [ ] El código ejecuta correctamente
- [ ] Probaste con al menos 2 casos diferentes
- [ ] Los nombres de variables son descriptivos
- [ ] El código está correctamente indentado
- [ ] Incluiste comentarios básicos

---

**¡Éxito con tu primera clase en Java!** 🎉

---

**Nota:** Si tienes dudas, consulta la solución en la carpeta `solucion/` **solo después** de intentar el ejercicio por ti mismo.
