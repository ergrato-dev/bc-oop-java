# Glosario - Semana 09: Proyecto Final

## A

**Abstracción**  
Principio de POO que permite ocultar detalles de implementación y mostrar solo la funcionalidad esencial a través de clases abstractas e interfaces.

**Agregación**  
Tipo de relación "tiene-un" donde los objetos pueden existir independientemente. Ejemplo: Universidad tiene Profesores, pero los profesores pueden existir sin la universidad.

**Arquitectura de Software**  
Estructura fundamental de un sistema software, incluyendo sus componentes, relaciones y principios de diseño.

---

## C

**Clase Abstracta**  
Clase que no puede ser instanciada directamente y puede contener métodos abstractos (sin implementación) y concretos (con implementación).

**Cohesión**  
Medida de cuán relacionadas están las responsabilidades de una clase. Alta cohesión significa que una clase tiene un propósito bien definido.

**Composición**  
Tipo de relación "tiene-un" fuerte donde un objeto no puede existir sin el otro. Ejemplo: Casa tiene Habitaciones, las habitaciones no existen sin la casa.

**Constructor**  
Método especial que se ejecuta al crear una instancia de una clase. Se usa para inicializar atributos.

**CRUD**  
Acrónimo de Create (Crear), Read (Leer), Update (Actualizar), Delete (Eliminar). Operaciones básicas en gestión de datos.

---

## D

**Diagrama de Casos de Uso**  
Diagrama UML que muestra las interacciones entre actores y el sistema, describiendo funcionalidades desde la perspectiva del usuario.

**Diagrama de Clases**  
Diagrama UML que muestra la estructura estática del sistema: clases, atributos, métodos y relaciones entre clases.

**DRY (Don't Repeat Yourself)**  
Principio que promueve evitar duplicación de código. Cada pieza de conocimiento debe tener una única representación en el sistema.

---

## E

**Encapsulación**  
Principio de POO que consiste en ocultar los detalles internos de una clase y exponer solo lo necesario mediante métodos públicos.

**Excepción Personalizada**  
Clase que extiende `Exception` o `RuntimeException` para representar errores específicos del dominio de la aplicación.

---

## F

**Factory Pattern**  
Patrón de diseño que proporciona una interfaz para crear objetos sin especificar su clase exacta.

---

## G

**Generics (Genéricos)**  
Característica de Java que permite escribir código type-safe que funciona con diferentes tipos de datos mediante parámetros de tipo (`<T>`).

**Getter**  
Método público que permite leer el valor de un atributo privado. Convencionalmente empieza con `get` (o `is` para boolean).

---

## H

**Herencia**  
Mecanismo de POO que permite crear clases nuevas basadas en clases existentes, heredando atributos y métodos.

---

## I

**Interface (Interfaz)**  
Contrato que define métodos que las clases deben implementar. Solo contiene declaraciones de métodos (sin implementación en versiones <Java 8).

**Inyección de Dependencias**  
Técnica donde un objeto recibe otros objetos que necesita (sus dependencias) en lugar de crearlos internamente.

---

## J

**Javadoc**  
Herramienta y formato estándar para documentar código Java mediante comentarios especiales (`/** ... */`).

---

## L

**Liskov Substitution Principle (LSP)**  
Principio SOLID que establece que objetos de subclases deben poder reemplazar objetos de la clase padre sin alterar el funcionamiento del programa.

---

## M

**Método Abstracto**  
Método declarado sin implementación en una clase abstracta. Las clases hijas deben implementarlo.

**Multiplicidad**  
En UML, indica cuántas instancias de una clase pueden asociarse con instancias de otra clase (1..1, 1..*, *, etc.).

---

## O

**Objeto**  
Instancia concreta de una clase con estado (valores de atributos) y comportamiento (métodos).

**Open/Closed Principle (OCP)**  
Principio SOLID que establece que las clases deben estar abiertas para extensión pero cerradas para modificación.

**Override (Sobrescritura)**  
Redefinir un método heredado en una clase hija con la misma firma pero diferente implementación.

---

## P

**Polimorfismo**  
Capacidad de objetos de diferentes clases de responder al mismo mensaje de manera específica. Incluye sobrecarga y sobrescritura.

**Principios SOLID**  
Cinco principios de diseño orientado a objetos: Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion.

---

## R

**Refactoring (Refactorización)**  
Proceso de reestructurar código existente sin cambiar su comportamiento externo, mejorando su diseño y legibilidad.

**Relación "es-un" (is-a)**  
Relación de herencia. Ejemplo: Perro es-un Animal.

**Relación "tiene-un" (has-a)**  
Relación de composición o agregación. Ejemplo: Auto tiene-un Motor.

---

## S

**Setter**  
Método público que permite modificar el valor de un atributo privado. Convencionalmente empieza con `set`.

**Single Responsibility Principle (SRP)**  
Principio SOLID que establece que una clase debe tener una única razón para cambiar.

**Singleton Pattern**  
Patrón de diseño que garantiza que una clase tenga solo una instancia y proporciona un punto de acceso global a ella.

**Sobrecarga (Overload)**  
Definir múltiples métodos con el mismo nombre pero diferentes parámetros en la misma clase.

**Strategy Pattern**  
Patrón de diseño que permite definir una familia de algoritmos, encapsularlos y hacerlos intercambiables.

---

## T

**Type Safety**  
Característica que previene errores de tipo en tiempo de compilación, garantizando que se usen los tipos de datos correctos.

---

## U

**UML (Unified Modeling Language)**  
Lenguaje visual estandarizado para modelar sistemas de software mediante diagramas.

**Unit Testing**  
Práctica de escribir pruebas automatizadas para verificar que unidades individuales de código (métodos, clases) funcionan correctamente.

---

## V

**Validación**  
Proceso de verificar que los datos cumplan con reglas de negocio antes de procesarlos o almacenarlos.

---

## Conceptos Integradores

### Los 4 Pilares de POO

1. **Encapsulación**: Ocultar detalles internos
2. **Herencia**: Reutilización mediante jerarquías
3. **Polimorfismo**: Múltiples formas de comportamiento
4. **Abstracción**: Modelar conceptos esenciales

### Buenas Prácticas

- **Nombres descriptivos**: Variables y métodos con nombres claros
- **Métodos pequeños**: Cada método hace una cosa bien
- **Comentarios significativos**: Explican el "por qué", no el "qué"
- **Consistencia**: Seguir convenciones de código
- **Testing**: Probar el código regularmente

### Arquitectura en Capas

- **Modelo/Dominio**: Entidades del negocio
- **Servicio/Lógica de Negocio**: Operaciones sobre las entidades
- **Presentación/UI**: Interacción con el usuario
- **Utilidades**: Funciones auxiliares reutilizables

---

## Referencias Rápidas

### Convenciones Java

```java
// Clases: PascalCase
public class LibroDigital { }

// Métodos y variables: camelCase
private String nombreCompleto;
public void calcularTotal() { }

// Constantes: UPPER_SNAKE_CASE
public static final int MAX_INTENTOS = 3;

// Paquetes: lowercase
package com.empresa.proyecto.modelo;
```

### Anotaciones Comunes

- `@Override`: Indica sobrescritura de método
- `@Deprecated`: Marca código obsoleto
- `@SuppressWarnings`: Suprime advertencias del compilador

---

## Términos del Proyecto Final

**Dominio**  
Área de conocimiento o actividad específica que el software modela (biblioteca, hospital, tienda, etc.).

**Entidad**  
Objeto del mundo real que se modela en el sistema (Libro, Paciente, Producto, etc.).

**Funcionalidad**  
Característica o capacidad específica que el sistema ofrece a los usuarios.

**Requisito**  
Condición o capacidad que el sistema debe satisfacer.

**Caso de Uso**  
Descripción de cómo un actor interactúa con el sistema para lograr un objetivo específico.

---

> **💡 Tip**: Revisa este glosario mientras desarrollas tu proyecto. Comprender estos conceptos es clave para aplicarlos correctamente.
