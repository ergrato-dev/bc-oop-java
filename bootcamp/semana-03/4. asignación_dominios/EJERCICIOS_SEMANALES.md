# Ejercicios Semanales - Semana 03: Encapsulación y Constructores

## 📋 Información General

**Semana:** 03 - Encapsulación y Constructores  
**Puntuación Total:** 100 puntos  
**Entrega:** Repositorio GitHub personal

---

## 📝 Ejercicio 1: Encapsulación Completa (30 puntos)

Refactoriza TODAS tus clases aplicando encapsulación completa.

**Requisitos:**
- Todos los atributos `private`
- Getters para todos los atributos
- Setters con validaciones
- Métodos auxiliares privados

**Ejemplo:**
```java
public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    
    // Getters
    public String getCodigo() { return codigo; }
    public double getPrecio() { return precio; }
    
    // Setters con validación
    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("Precio debe ser positivo");
        }
    }
    
    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    }
    
    // Método privado auxiliar
    private boolean validarCodigo(String codigo) {
        return codigo != null && codigo.length() >= 3;
    }
}
```

---

## 📝 Ejercicio 2: Sobrecarga de Constructores (25 puntos)

Implementa mínimo **2 constructores** en cada clase principal.

**Ejemplo:**
```java
public class Cliente {
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    
    // Constructor completo
    public Cliente(String nombre, String email, String telefono, String direccion) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    // Constructor básico (llama al completo)
    public Cliente(String nombre, String email) {
        this(nombre, email, "Sin teléfono", "Sin dirección");
    }
    
    // Constructor mínimo
    public Cliente(String nombre) {
        this(nombre, nombre.toLowerCase() + "@example.com");
    }
}
```

---

## 📝 Ejercicio 3: Validaciones (25 puntos)

Implementa validaciones en constructores y setters.

**Validaciones comunes:**
- Strings no nulos ni vacíos
- Números positivos
- Rangos válidos
- Formatos correctos (email, teléfono)

**Ejemplo:**
```java
public void setEmail(String email) {
    if (email == null || !email.contains("@")) {
        throw new IllegalArgumentException("Email inválido");
    }
    this.email = email;
}

public void setEdad(int edad) {
    if (edad < 0 || edad > 120) {
        throw new IllegalArgumentException("Edad fuera de rango");
    }
    this.edad = edad;
}
```

---

## 📝 Ejercicio 4: Documento MEJORAS.md (20 puntos)

Documenta las mejoras realizadas.

**Contenido:**
```markdown
# Mejoras - Semana 03

## Encapsulación Aplicada

### Clase: [NombreClase]
- Atributos encapsulados: [lista]
- Validaciones agregadas: [descripción]

## Constructores Sobrecargados

### Clase: [NombreClase]
- Constructor 1: [descripción]
- Constructor 2: [descripción]

## Beneficios Logrados
- [Beneficio 1]
- [Beneficio 2]
```

---

## ✅ Criterios de Evaluación

| Criterio | Puntos |
|----------|--------|
| Encapsulación completa | 30 |
| Sobrecarga constructores | 25 |
| Validaciones | 25 |
| Documento MEJORAS.md | 20 |
| **TOTAL** | **100** |

---

## 📦 Entrega

```bash
git add semana-03/
git commit -m "feat(semana-03): Aplicar encapsulación y validaciones"
git push origin main
```
