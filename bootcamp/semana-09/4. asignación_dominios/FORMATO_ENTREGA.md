# Formato de Entrega - Proyecto Final (Semana 09)

## 📁 Estructura de Carpetas

Tu proyecto final debe tener la siguiente estructura:

```
bc-oop-java-[ficha]-[apellido]/
├── proyecto-final/                    ⬅️ CARPETA PRINCIPAL
│   ├── README.md                      ← Documentación completa
│   ├── src/
│   │   └── com/
│   │       └── [tudominio]/
│   │           ├── modelo/            ← Entidades del negocio
│   │           ├── servicio/          ← Lógica de negocio
│   │           ├── excepciones/       ← Excepciones personalizadas
│   │           ├── util/              ← (Opcional) Utilidades
│   │           └── Main.java          ← Punto de entrada
│   └── docs/
│       ├── diagrama-clases.png        ← UML obligatorio
│       └── manual-usuario.md          ← (Opcional)
├── semana-01/                         ← Trabajo anterior (referencia)
├── semana-02/
├── ...
└── semana-08/
```

---

## 📄 Ejemplo Completo: Agencia de Viajes

```
bc-oop-java-3228970A-garcia/
├── proyecto-final/
│   ├── README.md
│   ├── src/
│   │   └── com/
│   │       └── agencia/
│   │           ├── modelo/
│   │           │   ├── Persona.java           ← Clase abstracta
│   │           │   ├── Cliente.java           ← Hereda de Persona
│   │           │   ├── Empleado.java          ← Hereda de Persona
│   │           │   ├── Destino.java           ← Clase abstracta
│   │           │   ├── DestinoNacional.java   ← Hereda de Destino
│   │           │   ├── DestinoInternacional.java
│   │           │   ├── Reserva.java
│   │           │   └── Cotizable.java         ← Interface
│   │           ├── servicio/
│   │           │   ├── GestorClientes.java
│   │           │   ├── GestorDestinos.java
│   │           │   └── GestorReservas.java
│   │           ├── excepciones/
│   │           │   ├── ClienteNoEncontradoException.java
│   │           │   ├── DestinoNoDisponibleException.java
│   │           │   └── ReservaInvalidaException.java
│   │           ├── util/
│   │           │   └── Validador.java
│   │           └── Main.java
│   └── docs/
│       ├── diagrama-clases.png
│       └── diagrama-casos-uso.png
├── semana-01/
├── semana-02/
│   ...
└── semana-08/
```

---

## 📝 Contenido del README.md

### Plantilla Obligatoria

```markdown
# Proyecto Final: Sistema de Gestión de [Tu Dominio]

## 👤 Información del Estudiante

| Campo | Valor |
|-------|-------|
| **Nombre** | [Tu nombre completo] |
| **Ficha** | [Número de ficha] |
| **Dominio** | [Tu dominio asignado] |
| **Fecha** | [DD/MM/YYYY] |

---

## 📝 Descripción del Sistema

[Descripción detallada de tu sistema: qué hace, qué problema resuelve, 
quiénes son los usuarios, etc. Mínimo 2 párrafos.]

---

## 🏗️ Arquitectura del Proyecto

### Diagrama de Clases

![Diagrama de Clases](docs/diagrama-clases.png)

### Estructura de Paquetes

| Paquete | Contenido | Clases |
|---------|-----------|--------|
| `modelo` | Entidades del negocio | [lista] |
| `servicio` | Lógica de negocio | [lista] |
| `excepciones` | Excepciones personalizadas | [lista] |
| `util` | Utilidades | [lista] |

---

## 🧬 Aplicación de Conceptos POO

### Encapsulación
- Todos los atributos son `private`
- Validaciones implementadas:
  1. [Descripción de validación 1]
  2. [Descripción de validación 2]
  3. ...

### Herencia

| Clase Padre | Clases Hijas | Atributos Heredados |
|-------------|--------------|---------------------|
| `[Padre1]` | `[Hijo1]`, `[Hijo2]` | `[atributos]` |
| `[Padre2]` | `[Hijo3]`, `[Hijo4]` | `[atributos]` |

### Polimorfismo

**Sobrescritura (@Override):**
- `[método1()]` en `[Clase]`
- `[método2()]` en `[Clase]`

**Sobrecarga (Overload):**
- `[método(param1)]` y `[método(param1, param2)]` en `[Clase]`

**Colecciones polimórficas:**
- `List<[TipoPadre]>` conteniendo objetos de tipo `[Hijo1]` y `[Hijo2]`

### Abstracción

| Tipo | Nombre | Implementaciones |
|------|--------|------------------|
| Clase abstracta | `[Nombre]` | `[Impl1]`, `[Impl2]` |
| Interface | `[Nombre]` | `[Impl1]`, `[Impl2]` |

### Excepciones Personalizadas

| Excepción | Tipo | Cuándo se lanza |
|-----------|------|-----------------|
| `[Nombre1]Exception` | Checked | [Descripción] |
| `[Nombre2]Exception` | Checked | [Descripción] |

### Colecciones

| Colección | Tipo | Propósito |
|-----------|------|-----------|
| `reservasPorCodigo` | `Map<String, Reserva>` | Búsqueda O(1) por código |
| `historialReservas` | `List<Reserva>` | Mantener orden cronológico |
| `clientesPorId` | `Map<String, Cliente>` | Búsqueda O(1) por ID |

---

## 📋 Funcionalidades del Sistema

### Menú Principal

```
=== SISTEMA DE GESTIÓN [TU DOMINIO] ===
1. [Opción 1]
2. [Opción 2]
...
0. Salir
```

### Operaciones Implementadas

| Operación | Descripción | Estado |
|-----------|-------------|--------|
| Agregar [entidad] | [Descripción] | ✅ |
| Buscar por código | [Descripción] | ✅ |
| Listar todos | [Descripción] | ✅ |
| Actualizar | [Descripción] | ✅ |
| Eliminar | [Descripción] | ✅ |
| Filtrar por [criterio] | [Descripción] | ✅ |
| Estadísticas | [Descripción] | ✅ |

---

## 🚀 Cómo Ejecutar

### Requisitos
- Java JDK 11 o superior
- IDE: IntelliJ IDEA (recomendado) o VS Code

### Compilación (Terminal)

```bash
cd proyecto-final
javac -d bin src/com/[tudominio]/*/*.java src/com/[tudominio]/*.java
```

### Ejecución (Terminal)

```bash
java -cp bin com.[tudominio].Main
```

### Desde IntelliJ IDEA

1. Abrir el proyecto
2. Marcar `src/` como Source Root
3. Clic derecho en `Main.java` → Run

---

## 📸 Capturas de Pantalla

### Menú Principal
[Imagen del menú]

### Operación CRUD
[Imagen de una operación]

### Estadísticas
[Imagen de estadísticas]

---

## 🎓 Reflexión Personal

### Desafíos Encontrados
[Describe los principales desafíos y cómo los resolviste]

### Aprendizajes Clave
[¿Qué fue lo más importante que aprendiste?]

### Mejoras Futuras
[¿Qué agregarías si tuvieras más tiempo?]

---

## 📚 Referencias

- Material del Bootcamp POO Java - SENA
- [Otras referencias utilizadas]

---

*Proyecto Final - Bootcamp POO Java - SENA - [Año]*
```

---

## ✅ Checklist de Entrega

### Estructura
- [ ] Carpeta `proyecto-final/` creada
- [ ] Estructura de paquetes correcta
- [ ] Archivo `Main.java` en la raíz del paquete
- [ ] Carpeta `docs/` con diagrama UML

### Código
- [ ] Compila sin errores
- [ ] Se ejecuta correctamente
- [ ] Todas las funcionalidades funcionan
- [ ] Sin warnings de tipos raw

### POO (verificar presencia)
- [ ] Encapsulación con validaciones
- [ ] Herencia (1 padre + 2 hijos mínimo)
- [ ] Polimorfismo (@Override + sobrecarga)
- [ ] Abstracción (clase abstracta O interface)
- [ ] Excepciones personalizadas (mínimo 2)
- [ ] Colecciones (HashMap + ArrayList)

### Documentación
- [ ] README.md completo
- [ ] Diagrama de clases UML
- [ ] Comentarios Javadoc en clases principales

### Git
- [ ] Commit con mensaje descriptivo
- [ ] Push al repositorio remoto

---

## 📤 Comandos para Entregar

```bash
# Navegar al repositorio
cd bc-oop-java-[ficha]-[apellido]

# Agregar proyecto final
git add proyecto-final/

# Commit
git commit -m "Proyecto Final: [Tu Dominio] - Integración completa de POO"

# Push
git push origin main
```

---

## ⚠️ Errores Comunes a Evitar

### 1. Estructura incorrecta
```
❌ INCORRECTO          ✅ CORRECTO
proyecto-final/        proyecto-final/
├── Clase1.java        └── src/
├── Clase2.java            └── com/
└── Main.java                  └── midominio/
                                   ├── modelo/
                                   ├── servicio/
                                   └── Main.java
```

### 2. README incompleto
- ❌ Solo descripción sin detalles técnicos
- ✅ Incluir diagrama, tabla de POO, instrucciones

### 3. Sin diagrama UML
- ❌ "No tuve tiempo de hacerlo"
- ✅ Usar draw.io o IntelliJ para generarlo

### 4. Código sin comentarios
- ❌ Solo código sin explicación
- ✅ Javadoc en clases y métodos principales

---

*Formato de Entrega - Proyecto Final - Bootcamp POO Java - SENA*
