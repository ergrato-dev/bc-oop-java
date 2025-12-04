# Ejercicios Semanales - Semana 08: Colecciones y Programación Genérica

## 📊 Distribución de Puntos

| Ejercicio | Descripción | Puntos |
|-----------|-------------|--------|
| **Ejercicio 1** | Migrar arrays a ArrayList con Generics | **25 pts** |
| **Ejercicio 2** | Implementar HashMap para búsquedas rápidas | **30 pts** |
| **Ejercicio 3** | Operaciones de filtrado y estadísticas | **25 pts** |
| **Ejercicio 4** | Main con demostración completa | **20 pts** |
| **TOTAL** | | **100 pts** |

---

## 📝 Ejercicio 1: Migrar Arrays a ArrayList (25 pts)

### Objetivo
Reemplazar todos los arrays de tu sistema por `ArrayList<E>` con Generics.

### Tareas

#### 1.1 Identificar arrays actuales (5 pts)
Localiza todos los arrays en tu clase gestora:
```java
// ANTES - Evitar esto
private Reserva[] reservas = new Reserva[100];
private int contador = 0;
```

#### 1.2 Convertir a ArrayList con Generics (15 pts)
```java
// DESPUÉS - Usar esto
import java.util.ArrayList;
import java.util.List;

private List<Reserva> reservas = new ArrayList<>();
```

#### 1.3 Actualizar métodos CRUD (5 pts)
```java
// Agregar (ya no necesitas contador)
public void agregar(Reserva r) {
    reservas.add(r);
}

// Eliminar por objeto
public boolean eliminar(Reserva r) {
    return reservas.remove(r);
}

// Obtener por índice
public Reserva obtener(int indice) {
    return reservas.get(indice);
}

// Tamaño
public int cantidad() {
    return reservas.size();
}
```

### Criterios de Evaluación
- ✅ No hay arrays de objetos en el código (5 pts)
- ✅ Uso de interfaz `List<E>` en declaraciones (5 pts)
- ✅ Generics correctos (no tipos raw) (5 pts)
- ✅ Métodos CRUD funcionan correctamente (5 pts)
- ✅ No hay warnings de compilación (5 pts)

---

## 📝 Ejercicio 2: Implementar HashMap (30 pts)

### Objetivo
Agregar `HashMap<K, V>` para búsquedas eficientes por clave única.

### Tareas

#### 2.1 Identificar claves únicas (5 pts)
Determina qué atributo es único para cada entidad:
- Reserva → código
- Cliente → id o documento
- Producto → código
- etc.

#### 2.2 Crear HashMap para búsqueda rápida (15 pts)
```java
import java.util.HashMap;
import java.util.Map;

public class GestorReservas {
    // Para búsqueda O(1) por código
    private Map<String, Reserva> reservasPorCodigo = new HashMap<>();
    
    // Para mantener historial ordenado
    private List<Reserva> historial = new ArrayList<>();
    
    public void agregar(Reserva r) {
        // Validar que no exista
        if (reservasPorCodigo.containsKey(r.getCodigo())) {
            throw new IllegalArgumentException("Ya existe reserva con código: " + r.getCodigo());
        }
        reservasPorCodigo.put(r.getCodigo(), r);
        historial.add(r);
    }
    
    public Reserva buscarPorCodigo(String codigo) {
        return reservasPorCodigo.get(codigo); // O(1)
    }
    
    public boolean existe(String codigo) {
        return reservasPorCodigo.containsKey(codigo);
    }
    
    public Reserva eliminar(String codigo) {
        Reserva r = reservasPorCodigo.remove(codigo);
        if (r != null) {
            historial.remove(r);
        }
        return r;
    }
}
```

#### 2.3 Agregar segundo HashMap (opcional) (10 pts)
Agrega otro HashMap para agrupar por otra clave:
```java
// Reservas agrupadas por cliente
private Map<String, List<Reserva>> reservasPorCliente = new HashMap<>();

public void agregar(Reserva r) {
    // ... código anterior ...
    
    // Agrupar por cliente
    String idCliente = r.getCliente().getId();
    if (!reservasPorCliente.containsKey(idCliente)) {
        reservasPorCliente.put(idCliente, new ArrayList<>());
    }
    reservasPorCliente.get(idCliente).add(r);
}

public List<Reserva> obtenerReservasDeCliente(String idCliente) {
    return reservasPorCliente.getOrDefault(idCliente, new ArrayList<>());
}
```

### Criterios de Evaluación
- ✅ HashMap declarado con Generics correctos (5 pts)
- ✅ Búsqueda por clave implementada (10 pts)
- ✅ Validación de duplicados al agregar (5 pts)
- ✅ Método containsKey usado apropiadamente (5 pts)
- ✅ Segundo HashMap para agrupación (5 pts bonus)

---

## 📝 Ejercicio 3: Filtrado y Estadísticas (25 pts)

### Objetivo
Implementar operaciones de filtrado y cálculo de estadísticas.

### Tareas

#### 3.1 Filtrado por criterio (10 pts)
```java
// Filtrar por rango de precio
public List<Reserva> filtrarPorPrecio(double min, double max) {
    List<Reserva> resultado = new ArrayList<>();
    for (Reserva r : historial) {
        if (r.getPrecio() >= min && r.getPrecio() <= max) {
            resultado.add(r);
        }
    }
    return resultado;
}

// Filtrar por fecha (ejemplo)
public List<Reserva> filtrarPorMes(int mes, int año) {
    List<Reserva> resultado = new ArrayList<>();
    for (Reserva r : historial) {
        if (r.getFecha().getMonthValue() == mes && 
            r.getFecha().getYear() == año) {
            resultado.add(r);
        }
    }
    return resultado;
}
```

#### 3.2 Estadísticas básicas (10 pts)
```java
// Total de ventas
public double calcularTotalVentas() {
    double total = 0;
    for (Reserva r : historial) {
        total += r.getPrecio();
    }
    return total;
}

// Promedio de precios
public double calcularPromedioPrecio() {
    if (historial.isEmpty()) return 0;
    return calcularTotalVentas() / historial.size();
}

// Encontrar máximo
public Reserva obtenerReservaMasCara() {
    if (historial.isEmpty()) return null;
    Reserva maxima = historial.get(0);
    for (Reserva r : historial) {
        if (r.getPrecio() > maxima.getPrecio()) {
            maxima = r;
        }
    }
    return maxima;
}
```

#### 3.3 Conteo por categoría (5 pts)
```java
// Contar por tipo/categoría usando Map
public Map<String, Integer> contarPorTipo() {
    Map<String, Integer> conteo = new HashMap<>();
    for (Reserva r : historial) {
        String tipo = r.getTipo();
        conteo.put(tipo, conteo.getOrDefault(tipo, 0) + 1);
    }
    return conteo;
}
```

### Criterios de Evaluación
- ✅ Al menos 2 métodos de filtrado (10 pts)
- ✅ Cálculo de total/promedio (5 pts)
- ✅ Encontrar máximo/mínimo (5 pts)
- ✅ Conteo por categoría (5 pts)

---

## 📝 Ejercicio 4: Main con Demostración (20 pts)

### Objetivo
Crear un programa Main que demuestre todas las funcionalidades.

### Tareas

#### 4.1 Menú interactivo (10 pts)
```java
public class Main {
    public static void main(String[] args) {
        GestorReservas gestor = new GestorReservas();
        Scanner scanner = new Scanner(System.in);
        
        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN ===");
            System.out.println("1. Agregar reserva");
            System.out.println("2. Buscar por código");
            System.out.println("3. Listar todas");
            System.out.println("4. Filtrar por precio");
            System.out.println("5. Ver estadísticas");
            System.out.println("6. Eliminar reserva");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
            
            switch (opcion) {
                case 1: agregarReserva(gestor, scanner); break;
                case 2: buscarReserva(gestor, scanner); break;
                case 3: listarTodas(gestor); break;
                case 4: filtrarPorPrecio(gestor, scanner); break;
                case 5: mostrarEstadisticas(gestor); break;
                case 6: eliminarReserva(gestor, scanner); break;
                case 0: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }
}
```

#### 4.2 Demostrar HashMap y ArrayList (10 pts)
```java
private static void buscarReserva(GestorReservas gestor, Scanner scanner) {
    System.out.print("Código a buscar: ");
    String codigo = scanner.nextLine();
    
    Reserva r = gestor.buscarPorCodigo(codigo); // Usa HashMap O(1)
    
    if (r != null) {
        System.out.println("Encontrada: " + r);
    } else {
        System.out.println("No existe reserva con código: " + codigo);
    }
}

private static void mostrarEstadisticas(GestorReservas gestor) {
    System.out.println("\n=== ESTADÍSTICAS ===");
    System.out.println("Total reservas: " + gestor.cantidad());
    System.out.println("Total ventas: $" + gestor.calcularTotalVentas());
    System.out.println("Promedio: $" + gestor.calcularPromedioPrecio());
    
    Reserva maxima = gestor.obtenerReservaMasCara();
    if (maxima != null) {
        System.out.println("Más cara: " + maxima);
    }
    
    System.out.println("\nConteo por tipo:");
    Map<String, Integer> conteo = gestor.contarPorTipo();
    for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
        System.out.println("  " + entry.getKey() + ": " + entry.getValue());
    }
}
```

### Criterios de Evaluación
- ✅ Menú con al menos 6 opciones (5 pts)
- ✅ Demuestra búsqueda con HashMap (5 pts)
- ✅ Demuestra iteración con for-each (5 pts)
- ✅ Demuestra estadísticas (5 pts)

---

## ✅ Checklist Final de Entrega

### Código
- [ ] No hay arrays de objetos (usar ArrayList)
- [ ] Al menos un HashMap para búsqueda por clave
- [ ] Generics en todas las colecciones (`List<E>`, `Map<K,V>`)
- [ ] Sin warnings de tipos raw
- [ ] Código compila sin errores

### Funcionalidades
- [ ] CRUD completo con colecciones
- [ ] Búsqueda O(1) con HashMap
- [ ] Al menos 2 métodos de filtrado
- [ ] Estadísticas (total, promedio, máximo)
- [ ] Menú interactivo funcional

### Documentación
- [ ] Comentarios Javadoc en clase gestora
- [ ] README.md actualizado con nuevas funcionalidades

---

## 📦 Formato de Entrega

Ver: [FORMATO_ENTREGA.md](./FORMATO_ENTREGA.md)

---

*Semana 08 - Bootcamp POO Java - SENA*
