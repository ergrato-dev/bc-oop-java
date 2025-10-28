# Ejercicio 04 - Encapsulación Básica

## 🎯 Objetivo
Aplicar encapsulación usando modificadores de acceso (`private`), implementar getters y setters, y validar datos de entrada.

**Duración estimada:** 45 minutos  
**Dificultad:** ⭐⭐⭐ Intermedio

---

## 📚 Conceptos a Practicar

- Modificador `private` para atributos
- Métodos getter (get...)
- Métodos setter (set...)
- Validación de datos en setters
- Buenas prácticas de encapsulación
- Uso de `this`

---

## 📝 Enunciado

Crea una clase llamada `Producto` para una tienda, aplicando encapsulación completa con validación de datos.

### Requisitos

**La clase `Producto` debe tener:**

1. **Atributos PRIVADOS:**
   - `codigo` (String)
   - `nombre` (String)
   - `precio` (double)
   - `stock` (int)
   - `categoria` (String)

2. **Constructor:**
   - Que reciba todos los parámetros
   - Que use los setters para validar

3. **Getters para todos los atributos**

4. **Setters con validación:**
   - `setCodigo()`: No puede ser vacío
   - `setNombre()`: Mínimo 3 caracteres
   - `setPrecio()`: Debe ser positivo
   - `setStock()`: No puede ser negativo
   - `setCategoria()`: No puede ser vacía

5. **Métodos adicionales:**
   - `aplicarDescuento(double porcentaje)`: Reduce el precio
   - `vender(int cantidad)`: Reduce el stock
   - `reabastecer(int cantidad)`: Aumenta el stock
   - `obtenerValorInventario()`: Retorna precio * stock
   - `mostrarInformacion()`: Muestra toda la info

---

## 💻 Estructura del Código

```java
public class Producto {
    // ===== ATRIBUTOS PRIVADOS =====
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;
    
    // ===== CONSTRUCTOR =====
    public Producto(String codigo, String nombre, double precio, int stock, String categoria) {
        // TODO: Usar setters para validar
    }
    
    // ===== GETTERS =====
    public String getCodigo() {
        return codigo;
    }
    
    // TODO: Implementar los demás getters
    
    // ===== SETTERS CON VALIDACIÓN =====
    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.trim().isEmpty()) {
            this.codigo = codigo;
        } else {
            System.out.println("✗ Error: El código no puede estar vacío");
        }
    }
    
    // TODO: Implementar los demás setters con validaciones
    
    // ===== MÉTODOS DE NEGOCIO =====
    // TODO: Implementar métodos adicionales
}
```

---

## ✅ Ejemplo de Salida Esperada

```
=== TIENDA - Gestión de Productos ===

Creando producto válido...
✓ Producto creado exitosamente

========== INFORMACIÓN DEL PRODUCTO ==========
Código: P001
Nombre: Laptop HP Pavilion
Precio: $2500000.00
Stock: 15 unidades
Categoría: Electrónica
Valor Total en Inventario: $37500000.00
==============================================

=== APLICANDO DESCUENTO ===
Aplicando 10% de descuento...
✓ Descuento aplicado. Nuevo precio: $2250000.00

=== VENTA ===
Vendiendo 5 unidades...
✓ Venta exitosa. Stock restante: 10 unidades

Vendiendo 20 unidades...
✗ Error: Stock insuficiente. Disponible: 10

=== REABASTECIMIENTO ===
Reabasteciendo 25 unidades...
✓ Reabastecimiento exitoso. Nuevo stock: 35 unidades

=== VALIDACIONES ===
Intentando establecer precio negativo...
✗ Error: El precio debe ser positivo

Intentando establecer stock negativo...
✗ Error: El stock no puede ser negativo

Intentando establecer nombre corto...
✗ Error: El nombre debe tener al menos 3 caracteres

Estado final:
Código: P001
Precio: $2250000.00
Stock: 35 unidades
Valor inventario: $78750000.00
```

---

## 🧪 Casos de Prueba

### Caso 1: Creación y operaciones válidas
```java
Producto p1 = new Producto("P001", "Laptop HP", 2500000, 15, "Electrónica");
p1.aplicarDescuento(10);
p1.vender(5);
p1.reabastecer(25);
```

### Caso 2: Validaciones
```java
Producto p2 = new Producto("", "X", -100, -5, "");  // Todos inválidos
p2.setCodigo("P002");    // Válido
p2.setNombre("Mouse");    // Válido
p2.setPrecio(50000);      // Válido
p2.setStock(100);         // Válido
```

### Caso 3: Acceso directo (debe fallar)
```java
Producto p3 = new Producto("P003", "Teclado", 80000, 50, "Periféricos");
p3.precio = -1000;  // Error de compilación: precio is private
```

---

## 💡 Pistas

1. **Getter básico:**
   ```java
   public TipoDato getNombreAtributo() {
       return nombreAtributo;
   }
   ```

2. **Setter con validación:**
   ```java
   public void setNombreAtributo(TipoDato valor) {
       if (validacion) {
           this.nombreAtributo = valor;
       } else {
           System.out.println("Error");
       }
   }
   ```

3. **Validar String no vacío:**
   ```java
   if (texto != null && !texto.trim().isEmpty()) { }
   ```

4. **Validar número positivo:**
   ```java
   if (numero > 0) { }
   ```

5. **Validar longitud String:**
   ```java
   if (texto.length() >= 3) { }
   ```

---

## ⚠️ Errores Comunes

### Error 1: Atributos públicos
```java
// ❌ INCORRECTO - Sin encapsulación
public class Producto {
    public String nombre;  // Cualquiera puede modificar
    public double precio;
}

// ✅ CORRECTO - Con encapsulación
public class Producto {
    private String nombre;  // Solo accesible vía métodos
    private double precio;
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
```

### Error 2: Setter sin validación
```java
// ❌ INCORRECTO - Permite valores inválidos
public void setPrecio(double precio) {
    this.precio = precio;  // Puede ser negativo
}

// ✅ CORRECTO - Con validación
public void setPrecio(double precio) {
    if (precio > 0) {
        this.precio = precio;
    } else {
        System.out.println("Error: precio debe ser positivo");
    }
}
```

### Error 3: No usar this
```java
// ⚠️ AMBIGUO
public void setNombre(String nombre) {
    nombre = nombre;  // No hace nada
}

// ✅ CORRECTO
public void setNombre(String nombre) {
    this.nombre = nombre;
}
```

### Error 4: Constructor sin validación
```java
// ❌ INCORRECTO - Asignación directa
public Producto(String nombre, double precio) {
    this.nombre = nombre;  // Sin validar
    this.precio = precio;
}

// ✅ CORRECTO - Usa setters
public Producto(String nombre, double precio) {
    setNombre(nombre);  // Valida
    setPrecio(precio);   // Valida
}
```

---

## 🎯 Criterios de Evaluación

| Criterio | Puntos | Descripción |
|----------|--------|-------------|
| **Encapsulación** | 3 | Todos los atributos son privados |
| **Getters** | 1 | Todos los getters implementados |
| **Setters** | 3 | Todos los setters con validación |
| **Métodos de negocio** | 2 | vender, reabastecer, etc. funcionan |
| **Validaciones** | 1 | Todas las validaciones correctas |

**Total:** 10 puntos

---

## 🚀 Desafíos Adicionales

1. **Sistema completo de tienda:**
   - Clase `Tienda` que gestiona array de `Producto`
   - Métodos: agregar, buscar, listar

2. **Más validaciones:**
   - Código debe tener formato específico (ej: P-#### )
   - Categorías predefinidas (enum)
   - Límites de descuento (máximo 50%)

3. **Historial:**
   - Registrar fecha de última venta
   - Contador de ventas totales

4. **Comparable:**
   - Implementar comparación por precio
   - Ordenar productos

---

## 📝 Preguntas de Reflexión

1. ¿Por qué hacer los atributos `private`?
2. ¿Qué ventaja tienen los setters sobre asignación directa?
3. ¿Puedes acceder a atributos privados desde otra clase?
4. ¿Qué pasa si no tienes setter para un atributo?
5. ¿Cuándo usarías validación en getters?

---

## 🔗 Recursos

- [Oracle: Controlling Access](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)
- [W3Schools: Encapsulation](https://www.w3schools.com/java/java_encapsulation.asp)

---

## 📤 Entrega

```
repositorio-apellido-nombre/
└── semana-02/
    └── ejercicio-04/
        ├── src/
        │   ├── Producto.java
        │   └── Main.java
        └── README.md
```

### Checklist:

- [ ] Todos los atributos son privados
- [ ] Todos los getters implementados
- [ ] Todos los setters con validación
- [ ] Constructor usa setters
- [ ] Métodos de negocio funcionan
- [ ] Validaciones previenen datos inválidos

---

**¡Domina la encapsulación!** 🔒
