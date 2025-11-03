# Asignación de Dominios - Semana 03: Encapsulación y Constructores

## 📋 Información General

**IMPORTANTE:** Continúas con tu mismo dominio. Esta semana mejorarás tu código aplicando **encapsulación completa** y **sobrecarga de constructores**.

---

## 🎯 Objetivo de esta Semana

Refactorizar y mejorar tu sistema aplicando:

1. **Encapsulación completa** (atributos private, getters/setters)
2. **Sobrecarga de constructores** (múltiples constructores)
3. **Validaciones** en setters y constructores
4. **Modificadores de acceso** apropiados
5. **Métodos auxiliares privados**

---

## 🔄 Progresión del Proyecto

```
Semana 01 → Clases básicas
Semana 02 → Más clases y relaciones
Semana 03 → Encapsulación y constructores ⬅️ AQUÍ
```

---

## 📝 Ejercicios Semanales

### 📄 Ver: [EJERCICIOS_SEMANALES.md](./EJERCICIOS_SEMANALES.md)

**Ejercicios (100 puntos):**
1. Refactorizar con encapsulación completa (30 pts)
2. Implementar sobrecarga de constructores (25 pts)
3. Agregar validaciones (25 pts)
4. Documento de mejoras (20 pts)

---

## 🏗️ Estructura de Entrega

```
bc-oop-java-[ficha]-[apellido]/
├── semana-01/
├── semana-02/
└── semana-03/              ⬅️ CÓDIGO MEJORADO
    ├── README.md
    ├── [Clase1Mejorada].java
    ├── [Clase2Mejorada].java
    ├── Main.java
    └── MEJORAS.md
```

---

## 💡 Ejemplo de Mejora

### Antes (Semana 02):
```java
public class Cliente {
    public String nombre;  // ❌ público
    public String email;   // ❌ público
}
```

### Después (Semana 03):
```java
public class Cliente {
    private String nombre;  // ✅ privado
    private String email;   // ✅ privado
    
    // Constructor completo
    public Cliente(String nombre, String email) {
        setNombre(nombre);
        setEmail(email);
    }
    
    // Constructor parcial
    public Cliente(String nombre) {
        this(nombre, "sin-email@example.com");
    }
    
    // Getters y setters con validación
    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email inválido");
        }
    }
}
```

---

## ✅ Checklist

- [ ] Todos los atributos son private
- [ ] Getters y setters completos
- [ ] Mínimo 2 constructores por clase
- [ ] Validaciones implementadas
- [ ] MEJORAS.md documentado
- [ ] Código compila sin errores

---

**Ver archivos detallados: [EJERCICIOS_SEMANALES.md](./EJERCICIOS_SEMANALES.md) y [FORMATO_ENTREGA.md](./FORMATO_ENTREGA.md)**
