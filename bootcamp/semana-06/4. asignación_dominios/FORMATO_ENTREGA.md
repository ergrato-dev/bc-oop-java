# Formato de Entrega - Semana 06

## 📦 Estructura del Repositorio

Tu repositorio en GitHub debe seguir **exactamente** esta estructura:

```
bc-oop-java-[ficha]-[apellido]/
├── README.md
├── semana-01/
│   └── ... (código previo)
├── semana-02/
│   └── ... (código previo)
├── semana-03/
│   └── ... (código previo)
├── semana-04/
│   └── ... (código previo)
├── semana-05/
│   └── ... (código previo)
└── semana-06/                              ⬅️ ENTREGA ACTUAL
    ├── README.md
    ├── abstractas/
    │   ├── [TuClaseAbstracta].java
    │   └── [OtraClaseAbstracta].java (opcional)
    ├── interfaces/
    │   ├── [Interface1].java
    │   ├── [Interface2].java
    │   └── [Interface3].java (opcional)
    ├── implementaciones/
    │   ├── [ClaseConcreta1].java
    │   ├── [ClaseConcreta2].java
    │   └── [ClaseConcreta3].java
    ├── Main.java
    ├── ANALISIS.md
    └── diagramas/ (opcional)
        └── jerarquia.png
```

---

## 📝 Nomenclatura de Archivos

### Clases Abstractas (`abstractas/`)

**Formato:** `[Concepto]Abstract.java` o `[Concepto].java`

**Ejemplos:**
```
ServicioTuristico.java          (si el nombre ya indica abstracción)
MaterialBibliografico.java      (si el nombre ya indica abstracción)
ProductoAbstract.java           (si necesitas ser explícito)
EmpleadoAbstract.java           (si necesitas ser explícito)
```

**Contenido mínimo:**
- Palabra clave `abstract class`
- Mínimo 2 atributos `protected`
- Constructor
- Al menos 1 método `abstract`
- Al menos 1 método concreto

### Interfaces (`interfaces/`)

**Formato:** `[Capacidad].java` (adjetivo o capacidad)

**Ejemplos correctos:**
```
Reservable.java
Calificable.java
Descuentable.java
Prestable.java
Vendible.java
Enviabl.java
Facturable.java
```

**❌ Evitar:**
```
IReservable.java        (No usar prefijo I en Java)
ReservaInterface.java   (No usar sufijo Interface)
```

**Contenido mínimo:**
- Palabra clave `interface`
- 2-4 métodos sin implementación
- Sin atributos de instancia

### Clases Concretas (`implementaciones/`)

**Formato:** `[NombreEspecífico].java`

**Ejemplos:**
```
Vuelo.java
Hotel.java
Tour.java
PaqueteTuristico.java
```

**Contenido mínimo:**
- `extends [ClaseAbstracta]`
- `implements [Interface1], [Interface2]` (si aplica)
- Implementación de TODOS los métodos abstractos
- Uso de `@Override`

---

## 📄 Archivo README.md de semana-06

**Ubicación:** `semana-06/README.md`

**Contenido obligatorio:**

```markdown
# Semana 06: Abstracción e Interfaces

## Dominio
[Nombre de tu dominio: Agencia de Viajes, Restaurante, etc.]

## Descripción
[Breve descripción de tu sistema]

## Clases Abstractas Implementadas

### [NombreClaseAbstracta]
- **Propósito:** [Para qué sirve esta clase abstracta]
- **Métodos abstractos:**
  - `[metodo1()]`: [descripción]
  - `[metodo2()]`: [descripción]
- **Métodos concretos:**
  - `[metodo3()]`: [descripción]
- **Subclases:**
  - `[Subclase1]`
  - `[Subclase2]`

## Interfaces Implementadas

### [NombreInterface1]
- **Capacidad:** [Qué capacidad define]
- **Métodos:**
  - `[metodo1()]`: [descripción]
  - `[metodo2()]`: [descripción]
- **Implementada por:**
  - `[Clase1]`
  - `[Clase2]`

### [NombreInterface2]
[Similar estructura]

## Jerarquía de Clases

```
       <<abstract>>
    [ClaseAbstracta]
           |
    +------+------+
    |             |
[Subclase1]   [Subclase2]
    |
    +-- implements [Interface1]
    +-- implements [Interface2]
```

## Principios SOLID Aplicados

1. **SRP:** [Cómo lo aplicaste]
2. **OCP:** [Cómo lo aplicaste]
3. **LSP:** [Cómo lo aplicaste]
4. **ISP:** [Cómo lo aplicaste]
5. **DIP:** [Cómo lo aplicaste]

## Compilación y Ejecución

```bash
# Compilar
javac semana-06/**/*.java

# Ejecutar
java semana-06.Main
```

## Salida Esperada

```
=== [TÍTULO DE TU SISTEMA] ===

[Muestra aquí la salida de tu programa]
```

## Cambios Respecto a Semana 05

- [Cambio 1]
- [Cambio 2]
- [Cambio 3]

## Mejoras Futuras

- [Mejora potencial 1]
- [Mejora potencial 2]
```

---

## 📄 Archivo ANALISIS.md

**Ubicación:** `semana-06/ANALISIS.md`

**Ver:** [EJERCICIOS_SEMANALES.md](./EJERCICIOS_SEMANALES.md#ejercicio-4-documento-de-análisis-25-puntos) para el contenido completo.

**Secciones obligatorias:**
1. Identificación de Abstracciones
2. Interfaces Implementadas
3. Decisiones de Diseño (Abstracta vs Interface)
4. Principios SOLID Aplicados
5. Mejoras Logradas
6. Diagrama de Clases
7. Desafíos y Soluciones
8. Próximos Pasos

---

## 📄 Archivo Main.java

**Ubicación:** `semana-06/Main.java`

**Estructura obligatoria:**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("=== [NOMBRE DE TU SISTEMA] ===\n");
        
        // 1. Demostrar polimorfismo con clase abstracta
        System.out.println("--- Sección 1: Polimorfismo ---");
        // [Tu código aquí]
        
        // 2. Demostrar uso de interfaces
        System.out.println("\n--- Sección 2: Interfaces ---");
        // [Tu código aquí]
        
        // 3. Demostrar múltiple implementación
        System.out.println("\n--- Sección 3: Múltiple Implementación ---");
        // [Tu código aquí]
        
        System.out.println("\n=== FIN ===");
    }
}
```

---

## 🔄 Proceso de Entrega

### Paso 1: Preparar el Código

```bash
# 1. Crear la estructura de carpetas
mkdir -p semana-06/{abstractas,interfaces,implementaciones}

# 2. Mover archivos a sus carpetas
mv [TuClaseAbstracta].java semana-06/abstractas/
mv [TuInterface].java semana-06/interfaces/
mv [TuClaseConcreta].java semana-06/implementaciones/
mv Main.java semana-06/

# 3. Crear documentos
touch semana-06/README.md
touch semana-06/ANALISIS.md
```

### Paso 2: Verificar Compilación

```bash
# Compilar todo el código de semana-06
javac semana-06/abstractas/*.java
javac semana-06/interfaces/*.java
javac semana-06/implementaciones/*.java
javac semana-06/Main.java

# Ejecutar
java semana-06.Main
```

**❌ Si hay errores:** Corrígelos antes de continuar.

### Paso 3: Commit y Push

```bash
# 1. Agregar cambios
git add semana-06/

# 2. Commit con mensaje descriptivo
git commit -m "feat(semana-06): Agregar abstracción e interfaces a [TU_DOMINIO]

- Implementar clase abstracta [NombreClaseAbstracta]
- Crear interfaces [Interface1], [Interface2]
- Refactorizar jerarquía aplicando SOLID
- Agregar documento de análisis de diseño
- Demostrar polimorfismo y múltiple implementación

Closes #6"

# 3. Push a GitHub
git push origin main
```

### Paso 4: Verificar en GitHub

1. Abre tu repositorio en GitHub
2. Navega a `semana-06/`
3. Verifica que todos los archivos estén presentes
4. Verifica que el README.md se vea correctamente

---

## ✅ Checklist Completo de Entrega

### Estructura de Carpetas
- [ ] Carpeta `semana-06/` existe
- [ ] Subcarpeta `abstractas/` existe
- [ ] Subcarpeta `interfaces/` existe
- [ ] Subcarpeta `implementaciones/` existe

### Archivos de Código
- [ ] Al menos 1 clase abstracta en `abstractas/`
- [ ] Al menos 2 interfaces en `interfaces/`
- [ ] Al menos 2 clases concretas en `implementaciones/`
- [ ] Archivo `Main.java` en raíz de `semana-06/`

### Documentación
- [ ] `README.md` completo en `semana-06/`
- [ ] `ANALISIS.md` completo en `semana-06/`

### Código
- [ ] Todo el código compila sin errores
- [ ] Clase abstracta tiene mínimo 1 método abstracto
- [ ] Clase abstracta tiene mínimo 1 método concreto
- [ ] Interfaces tienen solo métodos sin implementación
- [ ] Clases concretas implementan TODOS los métodos
- [ ] Se usa `@Override` en métodos sobrescritos
- [ ] Se usa `super()` en constructores de subclases

### Main.java
- [ ] Demuestra polimorfismo con clase abstracta
- [ ] Usa referencias de tipo interface
- [ ] Muestra múltiple implementación
- [ ] Tiene salida clara y organizada

### Documentación
- [ ] README.md describe el sistema
- [ ] README.md explica jerarquía de clases
- [ ] README.md menciona principios SOLID aplicados
- [ ] ANALISIS.md justifica decisiones de diseño
- [ ] ANALISIS.md explica abstracta vs interface

### Git
- [ ] Commit con mensaje descriptivo
- [ ] Push exitoso a GitHub
- [ ] Repositorio es público o instructor tiene acceso

---

## 🎯 Ejemplo de Estructura Completa

```
bc-oop-java-3228970A-perez/
└── semana-06/
    ├── README.md                           (✅ 150-250 líneas)
    ├── ANALISIS.md                         (✅ 200-300 líneas)
    ├── Main.java                           (✅ 80-150 líneas)
    ├── abstractas/
    │   └── ServicioTuristico.java         (✅ 50-80 líneas)
    ├── interfaces/
    │   ├── Reservable.java                (✅ 15-25 líneas)
    │   ├── Calificable.java               (✅ 15-25 líneas)
    │   └── Descuentable.java              (✅ 15-25 líneas)
    └── implementaciones/
        ├── Vuelo.java                     (✅ 80-120 líneas)
        ├── Hotel.java                     (✅ 80-120 líneas)
        └── PaqueteTuristico.java          (✅ 100-150 líneas)
```

**Total aproximado:** 700-1000 líneas de código y documentación

---

## ⚠️ Errores Comunes a Evitar

### ❌ Error 1: Carpetas Mal Nombradas
```
semana-06/
├── abstract/          ❌ Debe ser "abstractas"
├── interface/         ❌ Debe ser "interfaces"
└── clases/            ❌ Debe ser "implementaciones"
```

### ❌ Error 2: Archivos en Carpetas Incorrectas
```
semana-06/
├── Vuelo.java         ❌ Debe estar en implementaciones/
├── Reservable.java    ❌ Debe estar en interfaces/
└── abstractas/
    └── Main.java      ❌ Debe estar en raíz de semana-06/
```

### ❌ Error 3: Nomenclatura Incorrecta
```
interfaces/
├── IReservable.java           ❌ No usar prefijo I
├── ReservaInterface.java      ❌ No usar sufijo Interface
└── reservable.java            ❌ Debe empezar con mayúscula
```

### ❌ Error 4: Código que No Compila
```bash
$ javac semana-06/**/*.java
Error: ...
```
**Solución:** Corrige todos los errores antes de hacer push.

### ❌ Error 5: README.md Incompleto
```markdown
# Semana 06

[Solo unas pocas líneas]
```
**Solución:** Incluye TODAS las secciones requeridas.

---

## 📞 ¿Necesitas Ayuda?

### Antes de Preguntar

1. ✅ Revisa este documento completo
2. ✅ Consulta [EJERCICIOS_SEMANALES.md](./EJERCICIOS_SEMANALES.md)
3. ✅ Lee la teoría en `/bootcamp/semana-06/1-teoria/`
4. ✅ Revisa ejemplos en `/bootcamp/semana-06/2-practica/`

### Canales de Soporte

- **GitHub Discussions:** Para dudas generales
- **Issues:** Para reportar problemas técnicos
- **Clase presencial:** Consultas directas al instructor

---

## 🏆 Criterios de Calificación Final

| Aspecto | Peso | Verificación |
|---------|------|--------------|
| **Estructura correcta** | 10% | Carpetas y archivos en ubicaciones correctas |
| **Código funcional** | 30% | Compila y ejecuta sin errores |
| **Diseño apropiado** | 30% | Uso correcto de abstractas e interfaces |
| **Documentación** | 20% | README.md y ANALISIS.md completos |
| **Principios SOLID** | 10% | Al menos 2 principios aplicados |

**Total:** 100 puntos

---

**¡Sigue este formato exactamente para obtener la máxima puntuación! ✨**
