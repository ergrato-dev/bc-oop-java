# Asignación de Dominios - Semana 08: Colecciones y Programación Genérica

## 📋 Información General

**IMPORTANTE:** Continúas trabajando con el **mismo dominio asignado en la Semana 01**.

En esta semana transformarás tu sistema para usar **colecciones profesionales** en lugar de arrays, aplicando **HashMap, ArrayList con Generics** y operaciones avanzadas de búsqueda y filtrado.

---

## 🎯 Objetivo de esta Semana

Refactorizar tu sistema aplicando:

1. **Reemplazar arrays por colecciones** (ArrayList, HashMap)
2. **Aplicar Generics** para type safety
3. **Implementar búsquedas eficientes** con HashMap
4. **Usar iteradores y bucles mejorados**
5. **Agregar operaciones de filtrado y estadísticas**

---

## 🔄 Continuidad del Proyecto

### ¿Qué hiciste en Semana 07?
- ✅ Reorganizaste código en paquetes
- ✅ Agregaste validaciones con excepciones
- ✅ Creaste excepciones personalizadas

### ¿Qué harás en Semana 08?
- 🎯 **Reemplazar arrays** por ArrayList y HashMap
- 🎯 **Usar Generics** correctamente (`List<Entidad>`, `Map<String, Entidad>`)
- 🎯 **Implementar búsquedas** O(1) con HashMap
- 🎯 **Agregar operaciones** de listado, filtrado y estadísticas
- 🎯 **Manejar colecciones** de forma segura

---

## 📝 Ejercicios Semanales - Semana 08

### 📄 Ver: [EJERCICIOS_SEMANALES.md](./EJERCICIOS_SEMANALES.md)

**Ejercicios (100 puntos):**
1. Migrar arrays a ArrayList con Generics (25 pts)
2. Implementar HashMap para búsquedas rápidas (30 pts)
3. Agregar operaciones de filtrado y estadísticas (25 pts)
4. Main con demostración completa (20 pts)

---

## 🗂️ Tu Dominio Asignado

Revisa tu asignación original en:
```
bootcamp/semana-01/4. asignación_dominios/fichas/[TU_FICHA]/[TU_NOMBRE].md
```

---

## 🏗️ Estructura de Entrega

```
bc-oop-java-[ficha]-[apellido]/
├── semana-01/ ... semana-07/
│   └── ... (código previo)
└── semana-08/                    ⬅️ NUEVA CARPETA
    └── src/
        └── com/
            └── [tudominio]/
                ├── modelo/
                │   ├── [Entidad1].java
                │   ├── [Entidad2].java
                │   └── ...
                ├── servicio/
                │   └── [GestorPrincipal].java  ← Usa HashMap y ArrayList
                ├── excepciones/
                │   └── [TuExcepcion].java
                └── Main.java
```

---

## 💡 Ejemplo: Agencia de Viajes

### Antes (Semana 07 - Arrays):
```java
public class GestorReservas {
    private Reserva[] reservas = new Reserva[100];
    private int contadorReservas = 0;
    
    public void agregarReserva(Reserva r) {
        reservas[contadorReservas++] = r;
    }
    
    public Reserva buscarPorCodigo(String codigo) {
        for (int i = 0; i < contadorReservas; i++) {
            if (reservas[i].getCodigo().equals(codigo)) {
                return reservas[i];
            }
        }
        return null;
    }
}
```

### Después (Semana 08 - Colecciones):
```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorReservas {
    // HashMap para búsqueda rápida por código O(1)
    private Map<String, Reserva> reservasPorCodigo = new HashMap<>();
    
    // ArrayList para mantener orden de inserción
    private List<Reserva> historialReservas = new ArrayList<>();
    
    public void agregarReserva(Reserva r) {
        reservasPorCodigo.put(r.getCodigo(), r);
        historialReservas.add(r);
    }
    
    public Reserva buscarPorCodigo(String codigo) {
        return reservasPorCodigo.get(codigo); // O(1) en vez de O(n)
    }
    
    public List<Reserva> filtrarPorCliente(String idCliente) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva r : historialReservas) {
            if (r.getCliente().getId().equals(idCliente)) {
                resultado.add(r);
            }
        }
        return resultado;
    }
    
    public double calcularTotalVentas() {
        double total = 0;
        for (Reserva r : historialReservas) {
            total += r.getPrecio();
        }
        return total;
    }
}
```

---

## ✅ Checklist de Entrega

Antes de entregar, verifica:

- [ ] He reemplazado arrays por ArrayList
- [ ] He implementado HashMap para búsquedas por clave
- [ ] Uso Generics correctamente (`List<Entidad>`, no `List` raw)
- [ ] He agregado al menos 3 operaciones de filtrado/estadísticas
- [ ] Mi código compila sin warnings de tipos raw
- [ ] Las excepciones de semanas anteriores siguen funcionando
- [ ] Mi Main demuestra todas las funcionalidades nuevas

---

## 📖 Recursos

- [Teoría: Arrays vs Colecciones](../1-teoria/01-arrays-vs-colecciones.md)
- [Teoría: Interface List](../1-teoria/03-interface-list.md)
- [Teoría: Interface Map](../1-teoria/05-interface-map.md)
- [Teoría: Generics Básicos](../1-teoria/07-generics-basicos.md)
