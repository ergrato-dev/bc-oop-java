# Formato de Entrega - Semana 08

## 📁 Estructura de Carpetas

Tu entrega debe tener la siguiente estructura:

```
semana-08/
├── README.md                     ← Descripción de tu proyecto
├── src/
│   └── com/
│       └── [tudominio]/
│           ├── modelo/           ← Clases del dominio
│           ├── servicio/         ← Lógica de negocio con colecciones
│           ├── excepciones/      ← Excepciones personalizadas
│           ├── util/             ← (Opcional) Utilidades
│           └── Main.java         ← Punto de entrada
└── docs/                         ← (Opcional) Documentación adicional
```

### Ejemplo Completo: Agencia de Viajes

```
semana-08/
├── README.md
├── src/
│   └── com/
│       └── agencia/
│           ├── modelo/
│           │   ├── Reserva.java
│           │   ├── Cliente.java
│           │   └── Destino.java
│           ├── servicio/
│           │   └── GestorReservas.java    ← Usa HashMap y ArrayList
│           ├── excepciones/
│           │   ├── ReservaInvalidaException.java
│           │   └── DisponibilidadException.java
│           └── Main.java
└── docs/
    └── diagrama-clases.png
```

---

## 📄 Contenido del README.md

Tu `README.md` debe incluir:

### Plantilla:

```markdown
# Semana 08: Colecciones y Generics - [Tu Dominio]

## 👤 Información del Estudiante
- **Nombre**: [Tu nombre completo]
- **Ficha**: [Número de ficha]
- **Dominio**: [Nombre de tu dominio]
- **Fecha**: [DD/MM/YYYY]

## 📝 Descripción del Proyecto

[Breve descripción de tu sistema y las mejoras de esta semana]

**Esta semana**: Refactoricé el sistema para usar colecciones profesionales (HashMap, ArrayList) en lugar de arrays, agregando operaciones de búsqueda eficiente, filtrado y estadísticas.

## 📦 Colecciones Utilizadas

### HashMap
- `Map<String, Reserva>` - Búsqueda rápida por código
- `Map<String, List<Reserva>>` - Agrupación por cliente

### ArrayList
- `List<Reserva>` - Historial ordenado de reservas
- `List<Cliente>` - Lista de clientes registrados

## 🔍 Operaciones Implementadas

### CRUD con Colecciones
- ✅ Agregar con validación de duplicados
- ✅ Buscar por clave O(1) con HashMap
- ✅ Actualizar registro existente
- ✅ Eliminar por código

### Filtrado
- ✅ Filtrar por rango de precio
- ✅ Filtrar por fecha/período
- ✅ Filtrar por [otro criterio]

### Estadísticas
- ✅ Total de ventas
- ✅ Promedio de precios
- ✅ Elemento más caro/barato
- ✅ Conteo por categoría

## 🚀 Cómo Ejecutar

### Desde terminal:
```bash
cd semana-08
javac -d bin src/com/[tudominio]/*/*.java src/com/[tudominio]/*.java
java -cp bin com.[tudominio].Main
```

### Desde IntelliJ IDEA:
1. Abrir proyecto en IntelliJ
2. Clic derecho en `Main.java`
3. Seleccionar "Run Main.main()"

## 📸 Capturas de Pantalla

[Opcional: Agregar capturas del menú funcionando]
```

---

## 🔤 Nomenclatura

### Colecciones

| Estructura | Convención | Ejemplo |
|------------|------------|---------|
| HashMap | `[entidades]Por[Clave]` | `reservasPorCodigo` |
| ArrayList | `lista[Entidades]` o `historial[Entidades]` | `listaClientes`, `historialReservas` |
| Set | `[entidades]Unicas` | `categoriasUnicas` |

### Generics

```java
// ✅ CORRECTO - Usar Generics
private Map<String, Reserva> reservasPorCodigo = new HashMap<>();
private List<Cliente> clientes = new ArrayList<>();

// ❌ INCORRECTO - Tipos raw (sin Generics)
private Map reservasPorCodigo = new HashMap();
private List clientes = new ArrayList();
```

---

## ✅ Checklist de Entrega

Antes de entregar, verifica:

### Código
- [ ] No hay arrays de objetos (usa ArrayList)
- [ ] Al menos un HashMap para búsqueda por clave
- [ ] Generics en todas las colecciones
- [ ] Sin warnings de tipos raw
- [ ] Código compila sin errores

### Funcionalidades
- [ ] CRUD completo funciona
- [ ] Búsqueda O(1) con HashMap demostrada
- [ ] Al menos 2 filtrados implementados
- [ ] Estadísticas funcionando
- [ ] Menú interactivo completo

### Documentación
- [ ] README.md completo con plantilla
- [ ] Comentarios Javadoc en clase gestora
- [ ] Estructura de carpetas correcta

### Git
- [ ] Commit con mensaje descriptivo
- [ ] Push al repositorio remoto

---

## 📤 Cómo Entregar

1. **Crea la carpeta** `semana-08/` en tu repositorio
2. **Copia tu código** con la estructura indicada
3. **Completa el README.md** con la plantilla
4. **Verifica** con el checklist
5. **Commit y Push**:

```bash
git add semana-08/
git commit -m "Semana 08: Implementación de colecciones - [Tu Dominio]"
git push origin main
```

---

## ⚠️ Errores Comunes

### 1. Usar tipos raw
```java
// ❌ INCORRECTO
List lista = new ArrayList();
Map mapa = new HashMap();

// ✅ CORRECTO
List<Reserva> lista = new ArrayList<>();
Map<String, Reserva> mapa = new HashMap<>();
```

### 2. No validar duplicados en HashMap
```java
// ❌ INCORRECTO - Sobrescribe sin avisar
public void agregar(Reserva r) {
    mapa.put(r.getCodigo(), r);
}

// ✅ CORRECTO - Valida primero
public void agregar(Reserva r) {
    if (mapa.containsKey(r.getCodigo())) {
        throw new IllegalArgumentException("Ya existe: " + r.getCodigo());
    }
    mapa.put(r.getCodigo(), r);
}
```

### 3. Olvidar sincronizar HashMap y ArrayList
```java
// Si usas ambas estructuras, mantén sincronizadas
public void agregar(Reserva r) {
    reservasPorCodigo.put(r.getCodigo(), r);
    historial.add(r);  // ¡No olvides agregar a ambas!
}

public void eliminar(String codigo) {
    Reserva r = reservasPorCodigo.remove(codigo);
    if (r != null) {
        historial.remove(r);  // ¡Elimina de ambas!
    }
}
```

---

*Semana 08 - Bootcamp POO Java - SENA*
