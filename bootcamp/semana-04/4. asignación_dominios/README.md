# Asignación de Dominios - Semana 04: Herencia

## 📋 Información General

**IMPORTANTE:** Continúas con tu mismo dominio. Esta semana identificarás **jerarquías** en tu sistema e implementarás **herencia**.

---

## 🎯 Objetivo de esta Semana

Refactorizar tu sistema aplicando:

1. **Identificar jerarquías** "es-un" en tu dominio
2. **Crear clases padre** (superclases)
3. **Implementar herencia** con `extends`
4. **Usar `super()`** para llamar constructores padre
5. **Sobrescribir métodos** con `@Override`

---

## 🔄 Progresión del Proyecto

```
Semana 01 → Clases básicas
Semana 02 → Relaciones y colecciones
Semana 03 → Encapsulación
Semana 04 → Herencia ⬅️ AQUÍ
```

---

## 📝 Ejercicios Semanales

### 📄 Ver: [EJERCICIOS_SEMANALES.md](./EJERCICIOS_SEMANALES.md)

**Ejercicios (100 puntos):**
1. Identificar y crear clase padre (25 pts)
2. Crear mínimo 2 subclases (30 pts)
3. Implementar herencia correctamente (25 pts)
4. Demostración de polimorfismo básico (20 pts)

---

## 🏗️ Estructura de Entrega

```
semana-04/
├── README.md
├── [ClasePadre].java
├── [Subclase1].java
├── [Subclase2].java
├── [Subclase3].java (opcional)
├── Main.java
└── JERARQUIA.md
```

---

## 💡 Ejemplo: Agencia de Viajes

### Identificar Jerarquía:
- Vuelo, Hotel, Tour → todos son "Servicios Turísticos"

### Implementación:
```java
// Clase padre
public class ServicioTuristico {
    protected String nombre;
    protected double precio;
    
    public ServicioTuristico(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public void mostrarInfo() {
        System.out.println(nombre + " - $" + precio);
    }
}

// Subclase
public class Vuelo extends ServicioTuristico {
    private String origen;
    private String destino;
    
    public Vuelo(String nombre, double precio, String origen, String destino) {
        super(nombre, precio);  // Llamar constructor padre
        this.origen = origen;
        this.destino = destino;
    }
    
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Ruta: " + origen + " → " + destino);
    }
}
```

---

## 📊 Posibles Jerarquías por Dominio

| Dominio | Clase Padre | Subclases |
|---------|-------------|-----------|
| Agencia Viajes | ServicioTuristico | Vuelo, Hotel, Tour |
| Restaurante | Platillo | Entrada, PlatoFuerte, Postre |
| Biblioteca | Material | Libro, Revista, DVD |
| Tienda Online | Producto | ProductoFisico, ProductoDigital |
| Hospital | Personal | Medico, Enfermero, Administrativo |
| Gimnasio | Membresia | MensualBasica, Anual, Premium |

---

## ✅ Checklist

- [ ] Identifiqué jerarquía "es-un"
- [ ] Creé clase padre con atributos protected
- [ ] Mínimo 2 subclases con extends
- [ ] Uso super() en constructores
- [ ] Sobrescribí al menos 1 método
- [ ] Main demuestra polimorfismo
- [ ] JERARQUIA.md completo

---

**Ver [EJERCICIOS_SEMANALES.md](./EJERCICIOS_SEMANALES.md) para ejemplos completos.**
