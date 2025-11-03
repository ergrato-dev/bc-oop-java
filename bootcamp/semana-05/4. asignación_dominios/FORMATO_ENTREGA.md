# Formato de Entrega - Semana 05

## 📁 Estructura del Proyecto

```
semana-05/
├── README.md
├── [ClasePadre].java (mejorada con métodos sobrescritos)
├── [Subclase1].java (con @Override)
├── [Subclase2].java (con @Override)
├── [ClaseGestora].java (con métodos polimórficos y sobrecarga)
├── Main.java
└── POLIMORFISMO.md
```

**Ejemplo (Agencia de Viajes):**
```
semana-05/
├── README.md
├── ServicioTuristico.java (clase padre)
├── Vuelo.java (con @Override)
├── Hotel.java (con @Override)
├── Tour.java (con @Override)
├── AgenciaViajes.java (con sobrecarga y métodos polimórficos)
├── Cliente.java
├── Reserva.java
├── SistemaReservas.java (con ArrayList polimórfico)
├── Main.java
└── POLIMORFISMO.md
```

---

## 📝 Nomenclatura

- **Archivos Java**: PascalCase (`EmpleadoPlanta.java`, `SistemaRH.java`)
- **Clases**: PascalCase (`public class EmpleadoPlanta`)
- **Métodos**: camelCase (`calcularSalario()`, `obtenerDescripcion()`)
- **Variables**: camelCase (`salarioBase`, `fechaFinContrato`)
- **Constantes**: UPPER_SNAKE_CASE (`BONO_ANTIGUEDAD`)

---

## ✅ Checklist de Entrega

Verifica que tu código tenga:

- [ ] **Sobrecarga**: Mínimo 2 métodos con mismo nombre, diferentes parámetros
- [ ] **@Override**: Correctamente usado en métodos sobrescritos
- [ ] **Métodos polimórficos**: Que acepten clase padre
- [ ] **ArrayList polimórfico**: `ArrayList<ClasePadre>`
- [ ] **Main completo**: Demuestra sobrecarga y polimorfismo
- [ ] **POLIMORFISMO.md**: Documento con análisis completo
- [ ] **Compila**: Sin errores (`javac *.java`)
- [ ] **Ejecuta**: Salida clara y coherente (`java Main`)

---

## 📄 Contenido de POLIMORFISMO.md

```markdown
# Análisis de Polimorfismo - [Tu Dominio]

## 1. Sobrecarga (Overloading)

### Métodos Sobrecargados
- `buscarReserva(String codigo)`
- `buscarReserva(Cliente cliente)`
- `buscarReserva(LocalDate inicio, LocalDate fin)`

### Justificación
[Explica por qué tiene sentido en tu dominio]

---

## 2. Sobrescritura (Overriding)

### Tabla Comparativa

| Método | Clase Padre | Subclase 1 | Subclase 2 |
|--------|-------------|------------|------------|
| `calcularCosto()` | abstract | precio base | precio * noches |

### Código Ejemplo
[Fragmento de código mostrando @Override]

---

## 3. Polimorfismo Dinámico

### Ejemplo de Dynamic Binding
[Código que demuestra enlace dinámico]

### Explicación
[Cómo funciona en tu sistema]

---

## 4. Beneficios

- **Flexibilidad**: [Ejemplo específico]
- **Extensibilidad**: [Ejemplo específico]
- **Mantenibilidad**: [Ejemplo específico]
```

---

## 🔧 Comandos para Compilar y Ejecutar

```bash
# Compilar todos los archivos
javac *.java

# Ejecutar Main
java Main

# Si usas paquete
javac -d bin src/*.java
java -cp bin Main
```

---

## 📤 Formato de Commit

```bash
git add semana-05/
git commit -m "feat(semana-05): Implementar polimorfismo en [DOMINIO]"
git push origin main
```

**Ejemplo:**
```bash
git commit -m "feat(semana-05): Implementar polimorfismo en AgenciaViajes"
```

---

## 🎯 Recordatorio

✅ **SÍ**: Continuar con tu dominio de la Semana 01  
✅ **SÍ**: Aplicar sobrecarga y sobrescritura  
✅ **SÍ**: Demostrar polimorfismo dinámico  
❌ **NO**: Cambiar de dominio  
❌ **NO**: Crear clases sin relación con semanas anteriores

---

**¡El polimorfismo hace tu código flexible y reutilizable!** 🚀
