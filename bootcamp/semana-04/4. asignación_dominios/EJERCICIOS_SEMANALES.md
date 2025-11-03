# Ejercicios Semanales - Semana 04: Herencia

## 📋 Información General

**Semana:** 04 - Herencia  
**Puntuación Total:** 100 puntos

---

## 📝 Ejercicio 1: Crear Clase Padre (25 puntos)

Identifica una jerarquía en tu dominio y crea la clase padre.

**Requisitos:**
- Atributos `protected` (compartidos con subclases)
- Constructor completo
- Al menos 2 métodos que puedan ser heredados

**Ejemplo:**
```java
public class Empleado {
    protected String nombre;
    protected String identificacion;
    protected double salarioBase;
    
    public Empleado(String nombre, String id, double salario) {
        this.nombre = nombre;
        this.identificacion = id;
        this.salarioBase = salario;
    }
    
    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre);
        System.out.println("ID: " + identificacion);
    }
    
    public double calcularSalario() {
        return salarioBase;
    }
}
```

---

## 📝 Ejercicio 2: Crear Subclases (30 puntos)

Crea mínimo **2 subclases** que hereden de la clase padre.

**Ejemplo:**
```java
public class EmpleadoPlanta extends Empleado {
    private int anosAntiguedad;
    
    public EmpleadoPlanta(String nombre, String id, double salario, int anos) {
        super(nombre, id, salario);  // Llamar constructor padre
        this.anosAntiguedad = anos;
    }
    
    @Override
    public double calcularSalario() {
        double bono = salarioBase * 0.05 * anosAntiguedad;
        return salarioBase + bono;
    }
}

public class EmpleadoContrato extends Empleado {
    private int mesesContrato;
    
    public EmpleadoContrato(String nombre, String id, double salario, int meses) {
        super(nombre, id, salario);
        this.mesesContrato = meses;
    }
    
    @Override
    public double calcularSalario() {
        return salarioBase;  // Sin bonos
    }
}
```

---

## 📝 Ejercicio 3: Implementación Correcta (25 puntos)

Verifica:
- [ ] Uso correcto de `extends`
- [ ] `super()` en todos los constructores
- [ ] `@Override` en métodos sobrescritos
- [ ] Atributos `protected` en lugar de `private` donde apropiado

---

## 📝 Ejercicio 4: Demostración de Polimorfismo (20 puntos)

```java
public class Main {
    public static void main(String[] args) {
        // Array polimórfico
        Empleado[] empleados = new Empleado[3];
        
        empleados[0] = new EmpleadoPlanta("Ana", "E001", 2000000, 5);
        empleados[1] = new EmpleadoContrato("Luis", "E002", 1500000, 6);
        empleados[2] = new EmpleadoPlanta("María", "E003", 2500000, 3);
        
        // Polimorfismo en acción
        for (Empleado emp : empleados) {
            emp.mostrarInfo();
            System.out.println("Salario: $" + emp.calcularSalario());
            System.out.println("---");
        }
    }
}
```

---

## 📄 Documento JERARQUIA.md

```markdown
# Jerarquía de Clases - Semana 04

## Diagrama
```
      Empleado
         |
    +----+----+
    |         |
EmpleadoPlanta  EmpleadoContrato
```

## Justificación
[Explica por qué elegiste esta jerarquía]

## Atributos Heredados
- nombre (String)
- identificacion (String)
- salarioBase (double)

## Métodos Sobrescritos
- calcularSalario(): [Explicación de diferencias]
```

---

## ✅ Criterios de Evaluación

| Criterio | Puntos |
|----------|--------|
| Clase padre bien diseñada | 25 |
| Subclases correctas (mínimo 2) | 30 |
| Herencia implementada correctamente | 25 |
| Main con polimorfismo | 20 |
| **TOTAL** | **100** |
