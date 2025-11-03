# Asignación de Dominios - Semana 05: Polimorfismo

## 📋 Información General

**IMPORTANTE:** Continúas con tu mismo dominio. Esta semana implementarás **polimorfismo** mediante sobrecarga y sobrescritura de métodos.

---

## 🎯 Objetivo de esta Semana

Aplicar polimorfismo en tu sistema:

1. **Sobrecarga de métodos** (mismo nombre, diferentes parámetros)
2. **Sobrescritura de métodos** (`@Override` desde clase padre)
3. **Polimorfismo en tiempo de ejecución** (dynamic binding)
4. **Arrays/ArrayList polimórficos**
5. **Métodos genéricos** que trabajen con la clase padre

---

## 🔄 Progresión del Proyecto

```
Semana 01 → Clases básicas
Semana 02 → Relaciones y colecciones
Semana 03 → Encapsulación
Semana 04 → Herencia
Semana 05 → Polimorfismo ⬅️ AQUÍ
```

---

## 📝 Ejercicios Semanales

### 📄 Ver: [EJERCICIOS_SEMANALES.md](./EJERCICIOS_SEMANALES.md)

**Ejercicios (100 puntos):**
1. Implementar sobrecarga de métodos (25 pts)
2. Sobrescribir métodos con @Override (25 pts)
3. Crear métodos polimórficos (25 pts)
4. Demostración completa de polimorfismo (25 pts)

---

## 🏗️ Estructura de Entrega

```
semana-05/
├── README.md
├── [ClaseMejorada1].java
├── [ClaseMejorada2].java
├── [ClaseGestora].java (con métodos polimórficos)
├── Main.java
└── POLIMORFISMO.md
```

---

## 💡 Ejemplo: Sobrecarga y Sobrescritura

### Sobrecarga (Overloading):
```java
public class Calculadora {
    // Mismo método, diferentes parámetros
    public double calcular(double a, double b) {
        return a + b;
    }
    
    public double calcular(double a, double b, double c) {
        return a + b + c;
    }
    
    public double calcular(double[] numeros) {
        double suma = 0;
        for (double num : numeros) {
            suma += num;
        }
        return suma;
    }
}
```

### Sobrescritura (Overriding):
```java
public class Empleado {
    public double calcularSalario() {
        return salarioBase;
    }
}

public class EmpleadoPlanta extends Empleado {
    @Override
    public double calcularSalario() {
        return salarioBase + bono;  // Comportamiento diferente
    }
}
```

### Polimorfismo en Acción:
```java
public class SistemaRH {
    // Método polimórfico: acepta cualquier Empleado
    public void procesarNomina(Empleado empleado) {
        double salario = empleado.calcularSalario();  // Polimorfismo
        System.out.println("Salario: $" + salario);
    }
    
    // ArrayList polimórfico
    public void procesarTodos(ArrayList<Empleado> empleados) {
        for (Empleado emp : empleados) {
            procesarNomina(emp);  // Funciona con cualquier subclase
        }
    }
}
```

---

## 📊 Ejemplos de Polimorfismo por Dominio

| Dominio | Clase Padre | Método Polimórfico |
|---------|-------------|--------------------|
| Agencia Viajes | ServicioTuristico | `calcularCosto()` |
| Restaurante | Platillo | `preparar()` |
| Biblioteca | Material | `calcularMulta()` |
| Tienda Online | Producto | `calcularPrecioFinal()` |
| Hospital | Tratamiento | `aplicar()` |
| Gimnasio | Membresia | `calcularCosto()` |

---

## ✅ Checklist

- [ ] Implementé sobrecarga (mínimo 2 métodos)
- [ ] Sobrescribí métodos con @Override
- [ ] Creé métodos que aceptan clase padre
- [ ] Usé ArrayList polimórfico
- [ ] Main demuestra polimorfismo dinámico
- [ ] POLIMORFISMO.md completo
- [ ] Todo compila y ejecuta

---

**Ver [EJERCICIOS_SEMANALES.md](./EJERCICIOS_SEMANALES.md) para ejemplos detallados.**
