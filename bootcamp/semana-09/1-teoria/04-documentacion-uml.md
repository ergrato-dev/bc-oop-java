# Documentación y UML

## 📐 Diagramas UML

### Diagrama de Clases

#### Elementos Básicos

```
┌─────────────────┐
│   Cliente       │ ← Nombre de la clase
├─────────────────┤
│ - id: String    │ ← Atributos (- = private, + = public)
│ - nombre: String│
│ - email: String │
├─────────────────┤
│ + Cliente()     │ ← Métodos
│ + getId(): String│
│ + validar(): void│
└─────────────────┘
```

#### Relaciones

- **Herencia**: Flecha con triángulo vacío (→▷)
- **Implementación**: Flecha punteada con triángulo (⇢▷)
- **Asociación**: Línea simple (───)
- **Composición**: Rombo negro (◆───)
- **Agregación**: Rombo blanco (◇───)

### Herramientas Recomendadas

1. **draw.io** - https://app.diagrams.net/ (Gratuito, online)
2. **Lucidchart** - https://www.lucidchart.com/ (Freemium)
3. **PlantUML** - Text-based UML

### Ejemplo con draw.io

1. Abre draw.io
2. Selecciona "UML" → "Class Diagram"
3. Arrastra componentes:
   - Rectángulo de 3 secciones para clases
   - Flechas para relaciones
4. Exporta como PNG o PDF

---

## 📝 Comentarios Javadoc

### Clase
```java
/**
 * Representa un cliente del sistema.
 * 
 * @author Tu Nombre
 * @version 1.0
 * @since 2025-11-01
 */
public class Cliente {
    // ...
}
```

### Método
```java
/**
 * Calcula el descuento aplicable al cliente.
 * 
 * @param montoCompra El monto total de la compra
 * @return El monto del descuento
 * @throws ClienteNoEncontradoException Si el cliente no existe
 */
public double calcularDescuento(double montoCompra) 
        throws ClienteNoEncontradoException {
    // ...
}
```

---

## 📄 README.md

### Plantilla Básica

```markdown
# Sistema de [Tu Dominio]

## Descripción
Breve descripción del sistema y su propósito.

## Autor
- Nombre: [Tu Nombre Completo]
- Ficha: [Número de Ficha]
- Fecha: Noviembre 2025

## Requisitos
- JDK 11 o superior
- Sistema operativo: Windows/Linux/Mac

## Instalación y Ejecución

### Compilación
```bash
javac -d bin src/**/*.java
```

### Ejecución
```bash
java -cp bin Main
```

## Funcionalidades
- ✅ CRUD de [Entidad 1]
- ✅ CRUD de [Entidad 2]
- ✅ Búsqueda por [criterio]
- ✅ Generación de reportes
- ...

## Arquitectura
### Paquetes
- `modelo/`: Entidades del dominio
- `servicio/`: Lógica de negocio
- `excepciones/`: Excepciones personalizadas
- `util/`: Utilidades

### Diagrama de Clases
![Diagrama de Clases](docs/diagrama-clases.png)

## Decisiones de Diseño
### Encapsulación
Todos los atributos son privados con getters/setters validados.

### Herencia
Jerarquía Cliente → ClienteVIP, ClienteRegular

### Colecciones
- `HashMap<String, Cliente>` para búsquedas rápidas por ID
- `ArrayList<Pedido>` para mantener historial

## Licencia
Proyecto educativo - SENA 2025
```

---

## 📊 Informe Técnico

### Estructura Sugerida (1-2 páginas)

1. **Introducción**
   - Descripción del dominio
   - Objetivos del sistema

2. **Decisiones de Diseño**
   - Por qué elegí esta jerarquía
   - Qué colecciones usé y por qué
   - Excepciones personalizadas creadas

3. **Principios de POO Aplicados**
   - Encapsulación: Ejemplo específico
   - Herencia: Diagrama y explicación
   - Polimorfismo: Dónde lo apliqué
   - Abstracción: Interfaces/clases abstractas

4. **Desafíos y Soluciones**
   - Problema encontrado
   - Cómo lo resolví
   - Qué aprendí

5. **Conclusiones**
   - Qué funcionó bien
   - Qué mejoraría

---

## ✅ Checklist de Documentación

- [ ] README.md completo
- [ ] Diagrama de clases UML (PNG/PDF)
- [ ] Informe técnico (PDF)
- [ ] Comentarios Javadoc en clases principales
- [ ] Código limpio y legible

Ver: [Checklist Completo](../3-recursos/checklist-proyecto.md)
