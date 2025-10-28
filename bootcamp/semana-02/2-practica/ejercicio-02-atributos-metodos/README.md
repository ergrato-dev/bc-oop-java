# Ejercicio 02 - Atributos y Métodos

## 🎯 Objetivo
Trabajar con múltiples atributos de diferentes tipos y crear métodos con parámetros y valores de retorno.

**Duración estimada:** 30 minutos  
**Dificultad:** ⭐⭐ Básico

---

## 📚 Conceptos a Practicar

- Atributos de diferentes tipos (String, int, double, boolean)
- Métodos con parámetros
- Métodos que retornan valores
- Diferencia entre `void` y métodos con `return`
- Operaciones con atributos

---

## 📝 Enunciado

Crea una clase llamada `CuentaBancaria` que represente una cuenta de banco con operaciones básicas.

### Requisitos

**La clase `CuentaBancaria` debe tener:**

1. **Atributos:**
   - `numeroCuenta` (String)
   - `titular` (String)
   - `saldo` (double)
   - `activa` (boolean)

2. **Métodos:**
   - `depositar(double monto)`: Aumenta el saldo
   - `retirar(double monto)`: Disminuye el saldo (si hay fondos suficientes)
   - `consultarSaldo()`: Retorna el saldo actual
   - `mostrarInformacion()`: Muestra todos los datos de la cuenta
   - `estaActiva()`: Retorna true si la cuenta está activa

3. **Clase Main:**
   - Crea una cuenta bancaria
   - Realiza varias operaciones (depósitos, retiros)
   - Muestra el saldo después de cada operación

---

## 💻 Código Inicial

### Estructura de archivos:

```
ejercicio-02-atributos-metodos/
├── src/
│   ├── CuentaBancaria.java
│   └── Main.java
└── README.md
```

---

## 🔨 Paso a Paso

### Paso 1: Crear la clase CuentaBancaria

```java
/**
 * Clase que representa una cuenta bancaria
 * @author Tu Nombre
 */
public class CuentaBancaria {
    // Atributos
    String numeroCuenta;
    String titular;
    double saldo;
    boolean activa;
    
    // TODO: Implementar método depositar
    public void depositar(double monto) {
        // Agregar monto al saldo
        // Mostrar mensaje de confirmación
    }
    
    // TODO: Implementar método retirar
    public void retirar(double monto) {
        // Verificar si hay fondos suficientes
        // Si sí: restar monto del saldo
        // Si no: mostrar mensaje de error
    }
    
    // TODO: Implementar método consultarSaldo
    public double consultarSaldo() {
        // Retornar el saldo actual
        return 0.0; // Cambiar esto
    }
    
    // TODO: Implementar método mostrarInformacion
    public void mostrarInformacion() {
        // Mostrar todos los datos de la cuenta
    }
    
    // TODO: Implementar método estaActiva
    public boolean estaActiva() {
        // Retornar el estado de la cuenta
        return false; // Cambiar esto
    }
}
```

---

## ✅ Ejemplo de Salida Esperada

```
=== EJERCICIO 02 - Cuenta Bancaria ===

Creando cuenta...
========== INFORMACIÓN DE LA CUENTA ==========
Número de Cuenta: 1001-2023
Titular: Ana Martínez
Saldo: $0.00
Estado: Activa
==============================================

Depositando $500000.00...
✓ Depósito exitoso. Nuevo saldo: $500000.00

Depositando $250000.00...
✓ Depósito exitoso. Nuevo saldo: $750000.00

Retirando $100000.00...
✓ Retiro exitoso. Nuevo saldo: $650000.00

Intentando retirar $800000.00...
✗ Fondos insuficientes. Saldo disponible: $650000.00

Saldo final: $650000.00

========== INFORMACIÓN DE LA CUENTA ==========
Número de Cuenta: 1001-2023
Titular: Ana Martínez
Saldo: $650000.00
Estado: Activa
==============================================
```

---

## 🧪 Casos de Prueba

### Caso 1: Operaciones básicas
```java
CuentaBancaria cuenta1 = new CuentaBancaria();
cuenta1.numeroCuenta = "1001-2023";
cuenta1.titular = "Ana Martínez";
cuenta1.saldo = 0;
cuenta1.activa = true;

cuenta1.depositar(500000);      // Saldo: 500000
cuenta1.depositar(250000);      // Saldo: 750000
cuenta1.retirar(100000);        // Saldo: 650000
cuenta1.retirar(800000);        // Error: fondos insuficientes
```

### Caso 2: Múltiples cuentas
```java
CuentaBancaria cuenta2 = new CuentaBancaria();
cuenta2.numeroCuenta = "1002-2023";
cuenta2.titular = "Pedro Gómez";
cuenta2.saldo = 1000000;
cuenta2.activa = true;

cuenta2.retirar(300000);        // Saldo: 700000
```

---

## 💡 Pistas

1. **Método con parámetro:**
   ```java
   public void nombreMetodo(tipoDato parametro) {
       // Usar el parametro aquí
   }
   ```

2. **Método con retorno:**
   ```java
   public tipoDato nombreMetodo() {
       // Código
       return valor;  // Debe ser del tipo especificado
   }
   ```

3. **Sumar a un atributo:**
   ```java
   saldo = saldo + monto;
   // o más corto:
   saldo += monto;
   ```

4. **Validación con if:**
   ```java
   if (condicion) {
       // Código si la condición es verdadera
   } else {
       // Código si la condición es falsa
   }
   ```

5. **Formatear números como moneda:**
   ```java
   System.out.printf("Saldo: $%.2f\n", saldo);
   ```

---

## ⚠️ Errores Comunes

### Error 1: Método con return pero declarado void
```java
// ❌ INCORRECTO
public void consultarSaldo() {
    return saldo;  // Error: void no puede retornar
}

// ✅ CORRECTO
public double consultarSaldo() {
    return saldo;
}
```

### Error 2: No retornar un valor
```java
// ❌ INCORRECTO
public double consultarSaldo() {
    saldo;  // Falta return
}

// ✅ CORRECTO
public double consultarSaldo() {
    return saldo;
}
```

### Error 3: No validar antes de retirar
```java
// ❌ INCORRECTO
public void retirar(double monto) {
    saldo -= monto;  // Permite saldo negativo
}

// ✅ CORRECTO
public void retirar(double monto) {
    if (saldo >= monto) {
        saldo -= monto;
    } else {
        System.out.println("Fondos insuficientes");
    }
}
```

### Error 4: Confundir parámetro con atributo
```java
// ⚠️ CONFUSO
public void depositar(double saldo) {
    saldo = saldo + saldo;  // ¿Cuál saldo?
}

// ✅ CORRECTO
public void depositar(double monto) {
    saldo = saldo + monto;  // Claro: atributo + parámetro
    // o mejor:
    this.saldo += monto;
}
```

---

## 🎯 Criterios de Evaluación

| Criterio | Puntos | Descripción |
|----------|--------|-------------|
| **Atributos** | 2 | Los 4 atributos correctos con tipos apropiados |
| **depositar()** | 2 | Aumenta saldo correctamente |
| **retirar()** | 3 | Valida fondos y resta si es posible |
| **consultarSaldo()** | 1 | Retorna el saldo |
| **mostrarInformacion()** | 1 | Muestra todos los datos |
| **estaActiva()** | 1 | Retorna el estado booleano |

**Total:** 10 puntos

---

## 🚀 Desafíos Adicionales

Si terminas rápido, intenta:

1. **Método `transferir()`:**
   ```java
   public void transferir(CuentaBancaria destino, double monto)
   ```
   Retira de esta cuenta y deposita en la otra

2. **Historial de transacciones:**
   - Agrega un atributo `int numeroTransacciones`
   - Incrementa en cada operación
   - Método `obtenerNumeroTransacciones()`

3. **Límite de retiro diario:**
   - Atributo `double limiteRetiroDiario`
   - Validar que no se exceda en `retirar()`

4. **Intereses:**
   - Método `aplicarInteres(double porcentaje)`
   - Aumenta el saldo según el porcentaje

---

## 📝 Preguntas de Reflexión

1. ¿Cuál es la diferencia entre `void` y un método que retorna `double`?
2. ¿Por qué es importante validar antes de retirar dinero?
3. ¿Qué pasa si intentas retornar un `int` en un método declarado como `double`?
4. ¿Puedes llamar a `consultarSaldo()` dentro de `mostrarInformacion()`?
5. ¿Cómo se relacionan los parámetros de un método con sus atributos?

---

## 🔗 Recursos

- [Oracle: Defining Methods](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
- [W3Schools: Java Methods](https://www.w3schools.com/java/java_methods.asp)

---

## 📤 Entrega

```
repositorio-apellido-nombre/
└── semana-02/
    └── ejercicio-02/
        ├── src/
        │   ├── CuentaBancaria.java
        │   └── Main.java
        └── README.md (opcional)
```

### Checklist:

- [ ] Todos los métodos funcionan correctamente
- [ ] El método `retirar()` valida fondos suficientes
- [ ] Los métodos con return retornan los valores correctos
- [ ] Probaste con múltiples cuentas
- [ ] El código está bien comentado

---

**¡Éxito creando tu cuenta bancaria!** 💰

