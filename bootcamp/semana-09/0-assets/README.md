# Assets Visuales - Semana 09: Proyecto Final

Esta carpeta contiene diagramas SVG que ilustran la integración de todos los conceptos de POO en el proyecto final.

---

## 📊 Diagramas Disponibles

### 1. **1-integracion-poo.svg**
Diagrama que muestra cómo se integran los 4 pilares de POO en un proyecto completo.

**Contenido**:
- Encapsulación: Atributos privados + getters/setters
- Herencia: Jerarquías de clases padre-hijo
- Polimorfismo: Sobrecarga y sobrescritura
- Abstracción: Clases abstractas e interfaces
- Cómo interactúan entre sí

---

### 2. **2-arquitectura-proyecto.svg**
Estructura de paquetes y organización del código.

**Contenido**:
- Paquete `modelo/`: Entidades del dominio
- Paquete `servicio/`: Lógica de negocio
- Paquete `excepciones/`: Excepciones personalizadas
- Paquete `util/`: Utilidades y validadores
- Clase `Main.java`: Punto de entrada
- Flujo de comunicación entre capas

---

### 3. **3-flujo-crud.svg**
Flujo de operaciones CRUD en el sistema.

**Contenido**:
- Usuario → Menú → Servicio → Colección
- CREATE: Validación → Agregar a colección
- READ: Búsqueda en colección → Mostrar
- UPDATE: Buscar → Validar → Modificar
- DELETE: Buscar → Confirmar → Eliminar
- Manejo de excepciones en cada paso

---

### 4. **4-colecciones-proyecto.svg**
Uso de colecciones en el proyecto final.

**Contenido**:
- ArrayList<T> para listas ordenadas
- HashMap<K,V> para búsquedas rápidas
- Cuándo usar cada una
- Operaciones comunes
- Iteración segura

---

### 5. **5-excepciones-flujo.svg**
Manejo de excepciones personalizado.

**Contenido**:
- Jerarquía de excepciones del proyecto
- Try-catch-finally en acción
- Throw vs Throws
- Propagación de excepciones
- Mensajes al usuario

---

## 🎨 Características de los SVG

- **Tema**: Oscuro (#0d1117) sin degradados
- **Formato**: Escalable (SVG vectorial)
- **Colores**:
  - Verde (#3fb950): Exitoso/Correcto
  - Azul (#58a6ff): Información/Proceso
  - Amarillo (#d29922): Advertencia/Atención
  - Rojo (#f85149): Error/Excepción
  - Púrpura (#d2a8ff): Abstracción/Interfaz

---

## 📚 Relación con Teoría

| SVG | Archivo de Teoría Relacionado |
|-----|-------------------------------|
| 1-integracion-poo.svg | 1-teoria/01-repaso-poo.md |
| 2-arquitectura-proyecto.svg | 1-teoria/03-buenas-practicas.md |
| 3-flujo-crud.svg | 2-practica/proyecto-final/enunciado/ |
| 4-colecciones-proyecto.svg | (Semana 08) |
| 5-excepciones-flujo.svg | (Semana 07) |

---

## 🔧 Uso

Estos diagramas sirven como referencia visual durante:
1. La planificación del proyecto
2. El diseño de la arquitectura
3. La implementación del código
4. La presentación final

Consúltalos frecuentemente para asegurar que tu proyecto integra correctamente todos los conceptos.

---

**Total de assets**: 5 diagramas SVG  
**Formato**: Vectorial escalable  
**Tema**: Dark mode sin degradados
