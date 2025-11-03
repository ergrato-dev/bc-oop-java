# Asignación de Dominios - Semana 06: Abstracción e Interfaces

## 📋 Información General

**IMPORTANTE:** Continúas trabajando con el **mismo dominio asignado en la Semana 01**.

No cambias de dominio, sino que **amplías y mejoras** tu código existente aplicando los nuevos conceptos de **Abstracción e Interfaces**.

---

## 🎯 Objetivo de esta Semana

Refactorizar y expandir tu sistema aplicando:

1. **Clases Abstractas** para jerarquías con comportamiento común
2. **Interfaces** para definir capacidades y contratos
3. **Múltiple Implementación** cuando sea necesario
4. **Principios SOLID** en tu diseño
5. **Patrones de Diseño** básicos (Strategy, Factory Method, etc.)

---

## 🔄 Continuidad del Proyecto

### ¿Qué hiciste en Semana 01?
- ✅ Identificaste objetos principales de tu dominio
- ✅ Creaste clases con atributos y métodos básicos
- ✅ Implementaste encapsulación (getters/setters)

### ¿Qué hiciste en Semanas 02-05?
- ✅ **Semana 02:** Clases y objetos más complejos
- ✅ **Semana 03:** Constructores y encapsulación avanzada
- ✅ **Semana 04:** Herencia y jerarquías de clases
- ✅ **Semana 05:** Polimorfismo (sobrecarga y sobrescritura)

### ¿Qué harás en Semana 06?
- 🎯 **Identificar abstracciones** en tu jerarquía existente
- 🎯 **Crear clases abstractas** donde haya comportamiento común pero variable
- 🎯 **Definir interfaces** para capacidades independientes de la jerarquía
- 🎯 **Aplicar SOLID** para mejorar el diseño
- 🎯 **Refactorizar código** hacia mejor abstracción

---

## 📝 Ejercicios Semanales - Semana 06

### 📄 Ver: [EJERCICIOS_SEMANALES.md](./EJERCICIOS_SEMANALES.md)

Este archivo contiene:
- ✅ Ejercicios específicos de abstracción e interfaces
- ✅ Cómo aplicar estos conceptos a **TU dominio específico**
- ✅ Ejemplos adaptados por tipo de dominio
- ✅ Criterios de evaluación
- ✅ Checklist de verificación

---

## 🗂️ Tu Dominio Asignado

**Recuerda:** Tu dominio fue asignado en la Semana 01.

### 📍 Encuentra tu asignación original en:

```
bootcamp/semana-01/4. asignación_dominios/fichas/[TU_FICHA]/[TU_NOMBRE].md
```

**Fichas disponibles:**
- `3228970A/` - Ficha 2283970A
- `3228970B/` - Ficha 2283970B
- `3228973A/` - Ficha 2283973A
- `3228973B/` - Ficha 2283973B

---

## 🏗️ Estructura de tu Repositorio (Actualizada)

Tu repositorio en GitHub debe tener esta estructura acumulativa:

```
bc-oop-java-[ficha]-[nombre]/
├── README.md (actualizado con semana 06)
├── semana-01/
│   ├── ClasePrincipal.java
│   ├── ClaseSecundaria.java
│   └── Main.java
├── semana-02/
│   └── ... (código de semana 2)
├── semana-03/
│   └── ... (código de semana 3)
├── semana-04/
│   └── ... (código de semana 4)
├── semana-05/
│   └── ... (código de semana 5)
└── semana-06/                          ⬅️ NUEVA CARPETA
    ├── README.md                       (Explicación de los cambios)
    ├── abstractas/                     (Clases abstractas)
    │   └── [TuClaseAbstracta].java
    ├── interfaces/                     (Interfaces)
    │   └── [TuInterface].java
    ├── implementaciones/               (Clases concretas)
    │   └── [TuClaseConcreta].java
    ├── Main.java                       (Demostración)
    └── ANALISIS.md                     (Documento de diseño)
```

---

## 📋 Ejercicios Obligatorios (100 puntos)

| # | Ejercicio | Puntos | Entregable |
|---|-----------|--------|------------|
| 1 | Identificar y crear clase abstracta | 25 | `[TuClase]Abstract.java` |
| 2 | Crear mínimo 2 interfaces | 25 | `[TuInterface1].java`, `[TuInterface2].java` |
| 3 | Implementar jerarquía completa | 25 | Clases concretas |
| 4 | Documento de diseño y decisiones | 25 | `ANALISIS.md` |

---

## 🎯 ¿Cómo Identificar Abstracciones en TU Dominio?

### Paso 1: Revisa tu Código Actual
- ¿Tienes clases con métodos similares pero implementación diferente?
- ¿Hay comportamiento común que se repite?
- ¿Algunas clases nunca deberían instanciarse directamente?

### Paso 2: Identifica Candidatos para Clase Abstracta

**Pregúntate:**
- ¿Hay una clase "padre" que agrupa conceptos similares?
- ¿Tiene métodos que todas las subclases deben implementar?
- ¿Tiene comportamiento común que se puede reutilizar?

**Ejemplos por dominio:**

| Tu Dominio | Posible Clase Abstracta |
|------------|-------------------------|
| Agencia de Viajes | `Servicio`, `Paquete`, `Transporte` |
| Restaurante | `Platillo`, `Empleado`, `Pedido` |
| Biblioteca | `Material`, `Usuario`, `Prestamo` |
| Tienda Online | `Producto`, `MetodoPago`, `Envio` |
| Hospital | `Personal`, `Tratamiento`, `Cita` |
| Gimnasio | `Membresia`, `Entrenamiento`, `Equipo` |
| Cine | `Entrada`, `Funcion`, `Sala` |
| Universidad | `Persona`, `Curso`, `Evaluacion` |

### Paso 3: Identifica Candidatos para Interfaces

**Pregúntate:**
- ¿Hay capacidades que varias clases no relacionadas comparten?
- ¿Necesitas múltiple herencia de comportamiento?
- ¿Defines un contrato que varias clases deben cumplir?

**Ejemplos por dominio:**

| Tu Dominio | Posibles Interfaces |
|------------|---------------------|
| Agencia de Viajes | `Reservable`, `Cancelable`, `Valorable` |
| Restaurante | `Preparable`, `Entregable`, `Facturable` |
| Biblioteca | `Prestable`, `Renovable`, `Consultable` |
| Tienda Online | `Vendible`, `Descuentable`, `Enviabl` |
| Hospital | `Agendable`, `Diagnosticable`, `Facturable` |
| Gimnasio | `Reservable`, `Pagable`, `Evaluable` |
| Cine | `Reservable`, `Imprimible`, `Reembolsable` |
| Universidad | `Evaluable`, `Certificable`, `Inscribible` |

---

## 💡 Ejemplo de Evolución (Agencia de Viajes)

### Antes (Semana 05):
```java
class Vuelo {
    private String origen;
    private String destino;
    private double precio;
    
    public void reservar() { }
    public void cancelar() { }
}

class Hotel {
    private String nombre;
    private String ciudad;
    private double precioPorNoche;
    
    public void reservar() { }
    public void cancelar() { }
}
```

### Después (Semana 06):
```java
// Clase abstracta: comportamiento común
abstract class ServicioTuristico {
    protected String nombre;
    protected double precio;
    
    public abstract void calcularCosto();
    
    // Método común a todos los servicios
    public void mostrarDetalles() {
        System.out.println("Servicio: " + nombre);
        System.out.println("Costo: " + precio);
    }
}

// Interfaces: capacidades específicas
interface Reservable {
    void reservar();
    boolean verificarDisponibilidad();
}

interface Cancelable {
    void cancelar();
    double calcularPenalizacion();
}

// Clase concreta: hereda + implementa
class Vuelo extends ServicioTuristico implements Reservable, Cancelable {
    private String origen;
    private String destino;
    
    @Override
    public void calcularCosto() {
        // Implementación específica de vuelo
    }
    
    @Override
    public void reservar() {
        // Implementación específica
    }
    
    @Override
    public void cancelar() {
        // Implementación específica
    }
    
    @Override
    public boolean verificarDisponibilidad() {
        return true;
    }
    
    @Override
    public double calcularPenalizacion() {
        return precio * 0.20; // 20% de penalización
    }
}
```

**Mejoras logradas:**
- ✅ Eliminación de código duplicado
- ✅ Jerarquía clara y extensible
- ✅ Interfaces definen contratos claros
- ✅ Fácil agregar nuevos servicios
- ✅ Aplicación de principios SOLID

---

## 📦 Formato de Entrega

### Nomenclatura del Commit

```
feat(semana-06): Agregar abstracción e interfaces a [TU_DOMINIO]

- Crear clase abstracta [NombreClase]
- Implementar interfaces [Interface1], [Interface2]
- Refactorizar jerarquía aplicando SOLID
- Agregar documento de diseño
```

### Contenido del README.md de semana-06

```markdown
# Semana 06: Abstracción e Interfaces - [Tu Dominio]

## Cambios Realizados

### Clases Abstractas Creadas
- `[NombreClaseAbstracta]`: [Breve descripción]

### Interfaces Implementadas
- `[Interface1]`: [Qué capacidad define]
- `[Interface2]`: [Qué capacidad define]

### Jerarquía Final
[Describe tu jerarquía de clases]

### Principios SOLID Aplicados
- [Qué principios aplicaste y cómo]

## Diagrama de Clases
[Puedes incluir un diagrama simple en texto o imagen]

## Ejecución
```bash
javac semana-06/*.java
java semana-06.Main
```

## Salida Esperada
[Muestra la salida de tu programa]
```

---

## ✅ Checklist de Verificación

Antes de hacer push, verifica:

- [ ] Creé al menos UNA clase abstracta relevante a mi dominio
- [ ] Creé al menos DOS interfaces con métodos apropiados
- [ ] Todas las clases abstractas tienen al menos un método abstracto
- [ ] Todas las interfaces definen contratos claros
- [ ] Las clases concretas implementan TODOS los métodos requeridos
- [ ] Usé `@Override` en todos los métodos sobrescritos
- [ ] Mi código compila sin errores
- [ ] Mi `Main.java` demuestra el uso de abstracción y polimorfismo
- [ ] Incluí `ANALISIS.md` explicando mis decisiones de diseño
- [ ] Documenté por qué elegí clase abstracta vs interface en cada caso
- [ ] Apliqué al menos 2 principios SOLID
- [ ] El README.md de semana-06 está completo

---

## 🎓 Criterios de Evaluación

### Clase Abstracta (25 puntos)
- Relevante al dominio (5 pts)
- Métodos abstractos bien identificados (10 pts)
- Métodos concretos reutilizables (5 pts)
- Constructores apropiados (5 pts)

### Interfaces (25 puntos)
- Mínimo 2 interfaces diferentes (5 pts)
- Métodos coherentes con la capacidad (10 pts)
- Nombres descriptivos (5 pts)
- Implementación correcta en clases (5 pts)

### Implementación (25 puntos)
- Jerarquía coherente (10 pts)
- Código sin duplicación (5 pts)
- Uso correcto de `@Override` (5 pts)
- Compilación y ejecución exitosa (5 pts)

### Documento de Análisis (25 puntos)
- Explicación de decisiones de diseño (10 pts)
- Justificación abstracta vs interface (10 pts)
- Principios SOLID identificados (5 pts)

---

## 🔗 Referencias

- [Teoría Semana 06](../1-teoria/)
- [Prácticas Semana 06](../2-practica/)
- [Glosario](../3-recursos/glosario.md)
- [Errores Comunes](../3-recursos/errores-comunes.md)

---

## 📞 Soporte

- **Instructor:** Consultas durante la sesión presencial
- **Foro:** [GitHub Discussions](https://github.com/ergrato-dev/bc-oop-java/discussions)
- **Issues:** Para reportar problemas técnicos

---

**¡Continúa construyendo tu sistema aplicando abstracción e interfaces! 🚀**
