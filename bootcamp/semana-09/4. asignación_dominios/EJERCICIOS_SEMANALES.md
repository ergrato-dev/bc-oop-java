# Ejercicios Semanales - Semana 09: Proyecto Final Integrador

## 📊 Distribución de Puntos

| Componente | Descripción | Puntos |
|------------|-------------|--------|
| **Sistema Funcional** | Código completo y ejecutable | **40 pts** |
| **Documentación** | README, Javadoc, diagrama UML | **20 pts** |
| **Presentación Oral** | Demostración y defensa técnica | **30 pts** |
| **Calidad de Código** | Buenas prácticas, organización | **10 pts** |
| **TOTAL** | | **100 pts** |

---

## 📝 Componente 1: Sistema Funcional (40 pts)

### Objetivo
Entregar un sistema **completo y funcional** que integre todos los conceptos de POO.

### Requisitos Mínimos

#### 1.1 Estructura del Proyecto (5 pts)
```
proyecto-final/
├── src/
│   └── com/
│       └── [tudominio]/
│           ├── modelo/           ← Mínimo 5 clases
│           ├── servicio/         ← Lógica de negocio
│           ├── excepciones/      ← Mínimo 2 excepciones
│           └── Main.java
├── docs/
│   └── diagrama-clases.png
└── README.md
```

#### 1.2 Aplicación de POO (20 pts)

| Concepto | Requisito | Puntos |
|----------|-----------|--------|
| Encapsulación | Todos los atributos private + 5 validaciones | 3 pts |
| Herencia | 1 padre + 2 hijos con super() | 4 pts |
| Polimorfismo | 2 @Override + 2 sobrecarga | 4 pts |
| Abstracción | 1 clase abstracta O interface | 3 pts |
| Excepciones | 2 personalizadas + try-catch | 3 pts |
| Colecciones | HashMap + ArrayList con Generics | 3 pts |

#### 1.3 Funcionalidades (15 pts)

**Menú Interactivo (5 pts)**
- Mínimo 8 opciones funcionales
- Navegación clara sin errores
- Validación de entradas

**Operaciones CRUD (6 pts)**
- Create: Agregar nuevos registros
- Read: Buscar y listar (con HashMap O(1))
- Update: Modificar registros existentes
- Delete: Eliminar con confirmación

**Operaciones Avanzadas (4 pts)**
- Al menos 2 filtrados
- Estadísticas (total, promedio, máximo)
- Reportes o listados especiales

### Ejemplo de Menú Completo

```
=== SISTEMA DE GESTIÓN [TU DOMINIO] ===
1. Agregar [Entidad Principal]
2. Agregar [Entidad Secundaria]
3. Buscar por código
4. Listar todos
5. Actualizar registro
6. Eliminar registro
7. Filtrar por [criterio]
8. Ver estadísticas
9. Generar reporte
0. Salir

Seleccione una opción: _
```

---

## 📝 Componente 2: Documentación (20 pts)

### 2.1 README.md Completo (10 pts)

Tu README debe incluir:

```markdown
# Proyecto Final: [Nombre de tu Sistema]

## 👤 Información del Estudiante
- **Nombre**: [Tu nombre completo]
- **Ficha**: [Número de ficha]
- **Dominio**: [Tu dominio asignado desde Semana 01]
- **Fecha de entrega**: [DD/MM/YYYY]

## 📝 Descripción del Sistema

[Descripción de 2-3 párrafos explicando qué hace tu sistema, 
qué problema resuelve y para quién está diseñado]

## 🏗️ Arquitectura del Proyecto

### Diagrama de Clases
![Diagrama de Clases](docs/diagrama-clases.png)

### Estructura de Paquetes
```
com.[tudominio]/
├── modelo/          - Entidades del negocio
├── servicio/        - Lógica de negocio
├── excepciones/     - Excepciones personalizadas
└── Main.java        - Punto de entrada
```

## 🧬 Aplicación de Conceptos POO

### Herencia
- Clase padre: `[Nombre]`
- Clases hijas: `[Nombre1]`, `[Nombre2]`
- Justificación: [Por qué elegiste esta jerarquía]

### Polimorfismo
- Métodos sobrescritos: `[lista]`
- Métodos sobrecargados: `[lista]`
- Uso de colecciones polimórficas: [Sí/No y ejemplo]

### Abstracción
- [Clase abstracta / Interface]: `[Nombre]`
- Implementaciones: `[lista]`

### Excepciones Personalizadas
1. `[NombreExcepcion1]`: [Cuándo se lanza]
2. `[NombreExcepcion2]`: [Cuándo se lanza]

### Colecciones
- `HashMap<K, V>`: [Para qué se usa]
- `ArrayList<E>`: [Para qué se usa]

## 🚀 Cómo Ejecutar

### Requisitos
- Java JDK 11 o superior
- IDE recomendado: IntelliJ IDEA

### Compilación
```bash
cd proyecto-final
javac -d bin src/com/[tudominio]/*/*.java src/com/[tudominio]/*.java
```

### Ejecución
```bash
java -cp bin com.[tudominio].Main
```

## 📸 Capturas de Pantalla

[Incluir 2-3 capturas del sistema funcionando]

## 🎓 Reflexión Personal

### Desafíos encontrados
[¿Qué fue lo más difícil de implementar?]

### Aprendizajes clave
[¿Qué aprendiste durante el bootcamp?]

### Mejoras futuras
[¿Qué agregarías si tuvieras más tiempo?]
```

### 2.2 Diagrama UML (5 pts)

**Obligatorio**: Diagrama de clases que muestre:
- Todas las clases del proyecto
- Atributos y métodos principales
- Relaciones de herencia (flechas)
- Asociaciones entre clases

**Herramientas sugeridas**:
- draw.io (gratuito, online)
- Lucidchart
- PlantUML
- IntelliJ IDEA (genera automáticamente)

### 2.3 Comentarios Javadoc (5 pts)

```java
/**
 * Gestiona las operaciones CRUD para reservas.
 * Utiliza HashMap para búsquedas eficientes por código.
 * 
 * @author [Tu nombre]
 * @version 1.0
 * @since Semana 09
 */
public class GestorReservas {
    
    /**
     * Agrega una nueva reserva al sistema.
     * 
     * @param reserva La reserva a agregar
     * @throws ReservaDuplicadaException si ya existe una reserva con el mismo código
     * @throws IllegalArgumentException si la reserva es null
     */
    public void agregar(Reserva reserva) {
        // ...
    }
}
```

---

## 📝 Componente 3: Presentación Oral (30 pts)

### 3.1 Estructura de la Presentación (10-15 minutos)

| Sección | Tiempo | Contenido |
|---------|--------|-----------|
| Introducción | 2 min | Tu dominio, problema que resuelve |
| Demo en vivo | 5 min | Ejecutar CRUD completo |
| Arquitectura | 3 min | Explicar diagrama UML y decisiones |
| POO aplicada | 3 min | Mostrar herencia, polimorfismo, etc. |
| Conclusión | 2 min | Desafíos, aprendizajes |

### 3.2 Criterios de Evaluación

| Criterio | Excelente (5) | Bueno (4) | Suficiente (3) | Insuficiente (<3) |
|----------|--------------|-----------|----------------|-------------------|
| **Claridad** | Explica con precisión | Explicación clara | Explicación básica | Confuso |
| **Demo** | Sistema funciona perfecto | Funciona con errores menores | Funciona parcialmente | No funciona |
| **Dominio técnico** | Responde todo correctamente | Responde la mayoría | Responde con ayuda | No puede responder |
| **Justificación** | Justifica todas las decisiones | Justifica la mayoría | Justificaciones débiles | No justifica |

### 3.3 Preguntas Típicas del Instructor

Prepárate para responder:

1. **Herencia**: "¿Por qué elegiste esta jerarquía de clases?"
2. **Polimorfismo**: "Muéstrame un ejemplo de polimorfismo en tu código"
3. **HashMap**: "¿Por qué usaste HashMap aquí en lugar de ArrayList?"
4. **Excepciones**: "¿Qué sucede si intento [acción inválida]?"
5. **Diseño**: "¿Qué cambiarías si tuvieras que agregar [nueva funcionalidad]?"

---

## 📝 Componente 4: Calidad de Código (10 pts)

### 4.1 Buenas Prácticas (5 pts)

- [ ] Nombres descriptivos (clases PascalCase, métodos camelCase)
- [ ] Métodos pequeños con responsabilidad única
- [ ] Sin código duplicado (DRY)
- [ ] Constantes en lugar de números mágicos
- [ ] Código formateado consistentemente

### 4.2 Organización (5 pts)

- [ ] Paquetes con propósito claro
- [ ] Imports específicos (no wildcards)
- [ ] Clases en archivos separados
- [ ] Recursos (si aplica) en carpeta apropiada

---

## ✅ Checklist Final de Entrega

### Antes de entregar, verifica:

**Código**
- [ ] El proyecto compila sin errores
- [ ] El Main se ejecuta correctamente
- [ ] Todas las opciones del menú funcionan
- [ ] Las excepciones se manejan apropiadamente

**POO**
- [ ] Encapsulación: atributos private + validaciones
- [ ] Herencia: al menos 1 padre + 2 hijos
- [ ] Polimorfismo: @Override + sobrecarga
- [ ] Abstracción: clase abstracta o interface
- [ ] Excepciones: 2+ personalizadas
- [ ] Colecciones: HashMap + ArrayList

**Documentación**
- [ ] README.md completo con plantilla
- [ ] Diagrama UML incluido
- [ ] Comentarios Javadoc en clases principales

**Presentación**
- [ ] Demo funciona sin errores
- [ ] Puedo explicar cada decisión de diseño
- [ ] Conozco dónde está cada concepto de POO en mi código

---

## 📤 Cómo Entregar

1. **Crea la carpeta** `proyecto-final/` en tu repositorio
2. **Organiza el código** según la estructura indicada
3. **Completa el README.md**
4. **Agrega el diagrama UML** en `docs/`
5. **Verifica** con el checklist
6. **Commit y Push**:

```bash
git add proyecto-final/
git commit -m "Proyecto Final: [Tu Dominio] - Integración completa POO"
git push origin main
```

---

## 📅 Cronograma Sugerido

| Día | Actividad |
|-----|-----------|
| 1-2 | Revisión y refactorización del código existente |
| 3-4 | Completar funcionalidades faltantes |
| 5 | Crear diagrama UML |
| 6 | Escribir README y Javadoc |
| 7 | Preparar presentación |
| 8 | Ensayo de la demo |
| 9-10 | Ajustes finales |
| **Sesión** | **Presentación oral** |

---

*Semana 09 - Proyecto Final Integrador - Bootcamp POO Java - SENA*
