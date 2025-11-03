# Formato de Entrega - Semana 07

## 📁 Estructura de Carpetas

Tu entrega debe tener la siguiente estructura:

```
semana-07/
├── README.md                     ← Descripción de tu proyecto
├── src/
│   └── com/
│       └── [tudominio]/
│           ├── modelo/           ← Clases del dominio
│           ├── servicio/         ← Lógica de negocio
│           ├── excepciones/      ← Excepciones personalizadas
│           ├── util/             ← (Opcional) Utilidades
│           └── Main.java         ← Punto de entrada
└── docs/                         ← (Opcional) Documentación adicional
```

### Ejemplo Completo: Agencia de Viajes

```
semana-07/
├── README.md
├── src/
│   └── com/
│       └── agencia/
│           ├── modelo/
│           │   ├── Reserva.java
│           │   ├── Cliente.java
│           │   └── Destino.java
│           ├── servicio/
│           │   └── GestorReservas.java
│           ├── excepciones/
│           │   ├── ReservaInvalidaException.java
│           │   ├── DisponibilidadException.java
│           │   └── PagoRechazadoException.java
│           └── Main.java
└── docs/
    └── diagrama-paquetes.png
```

---

## 📄 Contenido del README.md

Tu `README.md` debe incluir:

### Plantilla:

```markdown
# Semana 07: Paquetes y Excepciones - [Tu Dominio]

## 👤 Información del Estudiante
- **Nombre**: [Tu nombre completo]
- **Ficha**: [Número de ficha]
- **Dominio**: [Nombre de tu dominio]
- **Fecha**: [DD/MM/YYYY]

## 📝 Descripción del Proyecto

[Breve descripción de tu dominio y qué hace tu sistema]

**Ejemplo**: Sistema de gestión para una agencia de viajes que permite registrar reservas, clientes y destinos con validaciones robustas y manejo de excepciones.

## 📦 Estructura de Paquetes

```
com.[tudominio]/
├── modelo/          - [Descripción]
├── servicio/        - [Descripción]
├── excepciones/     - [Descripción]
└── Main.java        - [Descripción]
```

## ⚠️ Excepciones Personalizadas

### 1. [NombreExcepcion1]
- **Tipo**: Checked (extends Exception)
- **Cuándo se lanza**: [Descripción]
- **Ejemplo**: [Caso de uso]

### 2. [NombreExcepcion2]
- **Tipo**: Checked (extends Exception)
- **Cuándo se lanza**: [Descripción]
- **Ejemplo**: [Caso de uso]

## 🚀 Cómo Ejecutar

### Desde terminal:
```bash
cd semana-07
javac -d bin src/com/[tudominio]/*/*.java src/com/[tudominio]/*.java
java -cp bin com.[tudominio].Main
```

### Desde IntelliJ IDEA:
1. Abrir proyecto en IntelliJ
2. Clic derecho en `Main.java`
3. Run 'Main.main()'

## ✅ Funcionalidades Implementadas

- [x] Organización en paquetes (com.dominio.*)
- [x] Mínimo 2 excepciones personalizadas
- [x] Validaciones con excepciones
- [x] Try-catch en Main
- [x] Finally para limpieza
- [x] 5 casos de prueba en Main

## 📊 Salida Esperada

```
=== Sistema de Gestión - Semana 07 ===

--- Caso 1: Reserva Válida ---
✅ Reserva agregada: Reserva[R001, Ana García, 2024-XX-XX, $1500000.00]

--- Caso 2: Código Inválido ---
❌ Código incorrecto: Código debe tener formato R### (ejemplo: R001)

...
```

## 🔧 Cambios Aplicados desde Semana 06

1. **Reorganización**: Código movido de raíz a paquetes
2. **Excepciones**: Creadas 2 excepciones personalizadas
3. **Validaciones**: Agregadas validaciones con throw
4. **Manejo de errores**: Try-catch en operaciones críticas

## 💡 Decisiones de Diseño

- **Checked vs Unchecked**: Se usaron excepciones checked porque [razón]
- **Paquete excepciones**: Separado para facilitar mantenimiento
- **Validaciones**: Implementadas en [clase/método] porque [razón]

## 📚 Referencias

- [Teoría de paquetes](../1-teoria/01-organizacion-paquetes.md)
- [Teoría de excepciones](../1-teoria/02-manejo-excepciones.md)
- Documentación Oracle Java

---

**Versión**: 1.0  
**Semana**: 07  
**Estado**: ✅ Completo
```

---

## 📤 Método de Entrega

### Opción 1: Git (Recomendado)

```bash
# 1. Navegar a la raíz del repositorio
cd bc-oop-java

# 2. Agregar cambios de la semana 07
git add bootcamp/semana-07/

# 3. Commit con formato específico
git commit -m "feat(semana-07): Implementar paquetes y excepciones en [DOMINIO]"

# 4. Push al repositorio
git push origin main
```

### Opción 2: Carpeta Compartida

Comprimir la carpeta `semana-07/` en un archivo ZIP:

**Nombre del archivo**: `Semana07_[TuNombre]_[Ficha].zip`

**Ejemplo**: `Semana07_JuanPerez_3228970.zip`

---

## ✅ Checklist Pre-Entrega

Antes de entregar, verifica que:

### Estructura y Organización (25 pts)
- [ ] Estructura de carpetas coincide con la especificada
- [ ] Paquetes siguen convención (com.dominio.modulo)
- [ ] Todos los archivos tienen declaración `package`
- [ ] Imports organizados (específicos, no wildcards)
- [ ] Código compila sin errores

### Excepciones Personalizadas (25 pts)
- [ ] Mínimo 2 excepciones personalizadas creadas
- [ ] Nombres terminan en "Exception"
- [ ] Tipo checked (extend `Exception`)
- [ ] Constructores: mensaje y mensaje+causa
- [ ] Documentadas con Javadoc

### Validaciones y Manejo (30 pts)
- [ ] Métodos críticos declaran excepciones con `throws`
- [ ] Se lanzan excepciones con `throw` cuando corresponde
- [ ] Main tiene try-catch para manejar excepciones
- [ ] Mensajes de error descriptivos
- [ ] Al menos 1 uso de finally

### Funcionalidad y Pruebas (20 pts)
- [ ] Main incluye mínimo 5 casos de prueba
- [ ] Casos cubren tanto éxitos como errores
- [ ] Programa ejecuta sin errores
- [ ] Salida es clara y comprensible
- [ ] README.md completo y detallado

---

## 📊 Criterios de Evaluación

| Aspecto | Puntos | Descripción |
|---------|--------|-------------|
| **Organización Paquetes** | 25 | Estructura, declaraciones, imports |
| **Excepciones Personalizadas** | 25 | Creación, constructores, uso |
| **Validaciones** | 30 | Throw, throws, try-catch, mensajes |
| **Funcionalidad** | 20 | Main con casos, README completo |
| **TOTAL** | **100** | |

---

## 🚫 Errores Comunes a Evitar

### 1. Estructura de Carpetas Incorrecta
❌ **Mal**:
```
src/
├── Reserva.java          ← Sin paquetes
└── GestorReservas.java
```

✅ **Bien**:
```
src/
└── com/
    └── agencia/
        ├── modelo/
        │   └── Reserva.java
        └── servicio/
            └── GestorReservas.java
```

### 2. Package No Coincide con Carpetas
❌ **Mal**:
```java
// Archivo en: src/com/agencia/modelo/Reserva.java
package agencia.modelo;  ← Falta 'com'
```

✅ **Bien**:
```java
// Archivo en: src/com/agencia/modelo/Reserva.java
package com.agencia.modelo;  ← Correcto
```

### 3. Excepciones Unchecked en vez de Checked
❌ **Mal** (para errores de negocio):
```java
public class ReservaInvalidaException extends RuntimeException {
    // ...
}
```

✅ **Bien**:
```java
public class ReservaInvalidaException extends Exception {
    // ...
}
```

### 4. Catch Vacío
❌ **Mal**:
```java
try {
    procesarReserva();
} catch (Exception e) {
    // Nada
}
```

✅ **Bien**:
```java
try {
    procesarReserva();
} catch (ReservaInvalidaException e) {
    System.err.println("❌ Error: " + e.getMessage());
}
```

### 5. README Incompleto
❌ **Mal**: README vacío o con solo título

✅ **Bien**: README con todas las secciones de la plantilla

---

## 📅 Fechas Importantes

- **Fecha de entrega**: [Definida por instructor]
- **Fecha límite**: [Definida por instructor]
- **Sustentación**: [Definida por instructor]

---

## ❓ Preguntas Frecuentes

**P: ¿Puedo usar mi IDE favorito?**  
R: Sí, pero asegúrate de que la estructura de carpetas sea correcta.

**P: ¿Debo incluir archivos .class?**  
R: NO. Solo código fuente (.java). Agrega `bin/` al `.gitignore`.

**P: ¿Puedo crear más de 2 excepciones?**  
R: ¡Sí! Se valora la creatividad y cobertura completa.

**P: ¿Qué pasa si mi código no compila?**  
R: Perderás puntos significativos. Verifica antes de entregar.

**P: ¿Puedo trabajar en equipo?**  
R: NO. Es evaluación individual. Cada quien su dominio.

---

## 📞 Soporte

Si tienes dudas:
1. Consulta el material de teoría
2. Revisa los ejercicios de práctica
3. Pregunta en el foro del curso
4. Contacta al instructor

---

**¡Éxito en tu entrega!** 🎯
