# Asignación de Dominios - Semana 09: Proyecto Final Integrador

## 📋 Información General

**IMPORTANTE:** Tu proyecto final se desarrolla sobre el **mismo dominio que has trabajado desde la Semana 01**.

Esta semana representa la **culminación del bootcamp**. Debes integrar, pulir y presentar tu sistema completo demostrando el dominio de **todos los conceptos de POO** aprendidos durante las 8 semanas anteriores.

---

## 🎯 Objetivo del Proyecto Final

Presentar un **sistema funcional completo** que demuestre:

1. ✅ **Encapsulación** - Atributos privados con validaciones
2. ✅ **Herencia** - Jerarquía de clases bien diseñada
3. ✅ **Polimorfismo** - Sobrecarga y sobrescritura de métodos
4. ✅ **Abstracción** - Clases abstractas o interfaces
5. ✅ **Excepciones** - Manejo robusto de errores
6. ✅ **Colecciones** - HashMap y ArrayList con Generics
7. ✅ **Organización** - Paquetes estructurados
8. ✅ **Documentación** - Código y manual completos

---

## 🔄 Tu Proyecto a Través del Bootcamp

| Semana | Qué agregaste | Estado |
|--------|---------------|--------|
| S01 | Identificación de objetos, primeras clases | ✅ |
| S02 | Más clases, relaciones, ArrayList básico | ✅ |
| S03 | Encapsulación, constructores, validaciones | ✅ |
| S04 | Herencia, jerarquía de clases, `super()` | ✅ |
| S05 | Polimorfismo, `@Override`, sobrecarga | ✅ |
| S06 | Abstracción, interfaces o clases abstractas | ✅ |
| S07 | Paquetes, excepciones personalizadas | ✅ |
| S08 | Colecciones profesionales, HashMap | ✅ |
| **S09** | **Integración final y presentación** | 🎯 |

---

## 📝 Entregables del Proyecto Final

### 📄 Ver: [EJERCICIOS_SEMANALES.md](./EJERCICIOS_SEMANALES.md)

**Componentes (100 puntos):**

| Componente | Puntos | Descripción |
|------------|--------|-------------|
| Sistema funcional | 40 pts | Código completo y ejecutable |
| Documentación | 20 pts | README, Javadoc, diagrama UML |
| Presentación oral | 30 pts | Demostración y defensa técnica |
| Calidad de código | 10 pts | Buenas prácticas, organización |

---

## 🗂️ Tu Dominio Asignado

**El mismo que has trabajado desde el inicio.** Revisa:

```
bootcamp/semana-01/4. asignación_dominios/fichas/[TU_FICHA]/[TU_NOMBRE].md
```

---

## 🏗️ Estructura Final del Proyecto

```
bc-oop-java-[ficha]-[apellido]/
├── proyecto-final/                    ⬅️ CARPETA PRINCIPAL
│   ├── README.md                      ← Documentación completa
│   ├── src/
│   │   └── com/
│   │       └── [tudominio]/
│   │           ├── modelo/            ← Entidades con herencia
│   │           │   ├── [EntidadBase].java
│   │           │   ├── [EntidadHija1].java
│   │           │   ├── [EntidadHija2].java
│   │           │   └── ...
│   │           ├── servicio/          ← Lógica con colecciones
│   │           │   └── [GestorPrincipal].java
│   │           ├── excepciones/       ← Excepciones del dominio
│   │           │   ├── [Excepcion1].java
│   │           │   └── [Excepcion2].java
│   │           ├── util/              ← Utilidades
│   │           └── Main.java          ← Menú interactivo
│   └── docs/
│       ├── diagrama-clases.png        ← UML obligatorio
│       └── manual-usuario.md          ← Opcional
├── semana-01/ ... semana-08/          ← Trabajo previo (referencia)
```

---

## 💡 Lo que se espera de tu proyecto

### Ejemplo: Si tu dominio es "Agencia de Viajes"

**Semana 01**: Creaste `Reserva.java` y `Cliente.java` básicos  
**Semana 04**: Agregaste `Destino` → `DestinoNacional`, `DestinoInternacional`  
**Semana 06**: Creaste interface `Cotizable` implementada por tus clases  
**Semana 08**: Usas `HashMap<String, Reserva>` para búsquedas

**Proyecto Final**: Todo integrado en un sistema funcional con:
- Menú completo (8+ opciones)
- CRUD para todas las entidades
- Búsquedas eficientes
- Estadísticas y reportes
- Manejo de errores robusto
- Documentación profesional

---

## ✅ Checklist de Verificación POO

Antes de entregar, verifica que tu proyecto demuestra:

### Encapsulación (Semana 03)
- [ ] Todos los atributos son `private`
- [ ] Getters y setters con validaciones
- [ ] Al menos 5 validaciones en setters

### Herencia (Semana 04)
- [ ] Al menos 1 jerarquía (1 padre + 2 hijos)
- [ ] Uso correcto de `super()` en constructores
- [ ] Atributos/métodos heredados aprovechados

### Polimorfismo (Semana 05)
- [ ] Al menos 2 métodos con `@Override`
- [ ] Al menos 2 métodos sobrecargados
- [ ] Colecciones polimórficas (`List<Padre>` con hijos)

### Abstracción (Semana 06)
- [ ] Al menos 1 clase abstracta O interface
- [ ] Métodos abstractos implementados en hijos
- [ ] Abstracción usada en lógica de negocio

### Excepciones (Semana 07)
- [ ] Al menos 2 excepciones personalizadas
- [ ] try-catch en puntos críticos
- [ ] Mensajes de error descriptivos

### Colecciones (Semana 08)
- [ ] HashMap para búsquedas por clave
- [ ] ArrayList para listas ordenadas
- [ ] Generics en todas las colecciones
- [ ] Operaciones de filtrado y estadísticas

### Organización
- [ ] Código organizado en paquetes
- [ ] Comentarios Javadoc
- [ ] Nombres descriptivos (convenciones Java)

---

## 📖 Recursos de Apoyo

- [Checklist completo del proyecto](../3-recursos/checklist-proyecto.md)
- [Guía de documentación UML](../1-teoria/04-documentacion-uml.md)
- [Repaso de POO](../1-teoria/01-repaso-poo.md)
- [Buenas prácticas](../1-teoria/03-buenas-practicas.md)

---

*Semana 09 - Proyecto Final Integrador - Bootcamp POO Java - SENA*
