# Contributing to Bootcamp POO Java

¡Gracias por tu interés en contribuir al Bootcamp de Programación Orientada a Objetos con Java! 🎉

Este documento proporciona pautas para contribuir al proyecto.

---

## 📋 Tabla de Contenidos

- [Código de Conducta](#código-de-conducta)
- [¿Cómo puedo contribuir?](#cómo-puedo-contribuir)
- [Guía de Estilo](#guía-de-estilo)
- [Proceso de Pull Request](#proceso-de-pull-request)
- [Reportar Bugs](#reportar-bugs)
- [Sugerir Mejoras](#sugerir-mejoras)

---

## 🤝 Código de Conducta

Este proyecto sigue el [Código de Conducta](CODE_OF_CONDUCT.md). Al participar, se espera que mantengas este código. Por favor reporta comportamientos inaceptables.

---

## 🚀 ¿Cómo puedo contribuir?

### 1. Mejorar Contenido Existente

- Corregir errores tipográficos o gramaticales
- Mejorar explicaciones de conceptos
- Añadir ejemplos adicionales
- Actualizar código obsoleto
- Mejorar diagramas UML

### 2. Agregar Nuevo Contenido

- Ejercicios prácticos adicionales
- Recursos complementarios
- Videos tutoriales
- Proyectos de ejemplo
- Casos de estudio

### 3. Mejorar Documentación

- Ampliar README de las semanas
- Crear guías paso a paso
- Documentar mejores prácticas
- Traducir contenido

### 4. Corregir Código

- Reportar y corregir bugs
- Optimizar código de ejemplo
- Añadir comentarios explicativos
- Mejorar estructura de proyectos

---

## 📝 Guía de Estilo

### Código Java

- **Convenciones**: Seguir [Java Code Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)
- **Nomenclatura**: 
  - Clases: `PascalCase`
  - Métodos y variables: `camelCase`
  - Constantes: `UPPER_SNAKE_CASE`
- **Comentarios**: Usar Javadoc para documentar clases y métodos públicos
- **Indentación**: 4 espacios (no tabs)

```java
/**
 * Clase que representa un estudiante del bootcamp.
 * 
 * @author Tu Nombre
 * @version 1.0
 */
public class Estudiante {
    private String nombre;
    private int edad;
    
    /**
     * Constructor con parámetros.
     * 
     * @param nombre Nombre del estudiante
     * @param edad Edad del estudiante
     */
    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}
```

### Markdown

- Usar headers apropiados (H1 para título, H2 para secciones)
- Bloques de código con highlighting: ```java
- Emojis para mejorar legibilidad: ✅ ❌ 💡 ⚠️
- Enlaces descriptivos
- Listas ordenadas o desordenadas según contexto

### Estructura de Archivos

```
bootcamp/semana-XX/
├── README.md
├── RUBRICA_EVALUACION.md
├── 1-teoria/
│   ├── 01-concepto-principal.md
│   └── 02-concepto-secundario.md
├── 2-practica/
│   ├── ejercicio-01/
│   │   ├── README.md
│   │   └── src/
│   └── ejercicio-02/
└── 3-recursos/
    └── glosario.md
```

---

## 🔄 Proceso de Pull Request

### 1. Fork del Repositorio

Haz un fork del repositorio a tu cuenta de GitHub.

### 2. Clonar tu Fork

```bash
git clone https://github.com/TU_USUARIO/bc-oop-java.git
cd bc-oop-java
```

### 3. Crear una Rama

```bash
git checkout -b feature/descripcion-corta
# o
git checkout -b fix/descripcion-del-bug
```

**Tipos de ramas:**
- `feature/` - Nuevas características
- `fix/` - Corrección de bugs
- `docs/` - Cambios en documentación
- `refactor/` - Refactorización de código
- `test/` - Añadir o modificar tests

### 4. Hacer Cambios

- Realiza tus cambios siguiendo la guía de estilo
- Haz commits frecuentes y descriptivos

### 5. Commit con Conventional Commits

```bash
git commit -m "feat: add new exercise for inheritance"
git commit -m "fix: correct typo in week 3 README"
git commit -m "docs: improve installation instructions"
```

**Tipos de commit:**
- `feat`: Nueva característica
- `fix`: Corrección de bug
- `docs`: Cambios en documentación
- `style`: Formato, espacios (no afecta código)
- `refactor`: Refactorización
- `test`: Añadir tests
- `chore`: Mantenimiento

### 6. Push a tu Fork

```bash
git push origin feature/descripcion-corta
```

### 7. Crear Pull Request

1. Ve a tu fork en GitHub
2. Haz clic en "Compare & pull request"
3. Completa la plantilla de PR
4. Espera revisión

### 📋 Checklist antes de PR

- [ ] El código compila sin errores
- [ ] Los archivos Java siguen convenciones
- [ ] La documentación está actualizada
- [ ] Los commits siguen Conventional Commits
- [ ] Se añadió ejemplo de uso si aplica
- [ ] Se actualizó el glosario si se añadieron términos nuevos

---

## 🐛 Reportar Bugs

Si encuentras un bug, por favor crea un issue con:

1. **Título descriptivo**
2. **Descripción detallada del problema**
3. **Pasos para reproducir**
4. **Comportamiento esperado vs actual**
5. **Capturas de pantalla** (si aplica)
6. **Entorno**: OS, versión de Java, IDE

Usa la [plantilla de Bug Report](.github/ISSUE_TEMPLATE/bug_report.md)

---

## 💡 Sugerir Mejoras

Para sugerir nuevas características:

1. **Verifica** que no exista ya un issue similar
2. **Crea un issue** con descripción clara
3. **Explica** el caso de uso
4. **Proporciona** ejemplos si es posible

Usa la [plantilla de Feature Request](.github/ISSUE_TEMPLATE/feature_request.md)

---

## 📚 Áreas que Necesitan Contribución

- [ ] Ejercicios adicionales para cada semana
- [ ] Proyectos integradores completos
- [ ] Videos tutoriales
- [ ] Traducción al inglés
- [ ] Diagramas UML interactivos
- [ ] Tests automatizados para ejercicios
- [ ] Casos de estudio del mundo real

---

## 🎓 Reconocimiento

Los contribuidores serán añadidos al archivo [CONTRIBUTORS.md](CONTRIBUTORS.md)

---

## 📞 ¿Preguntas?

Si tienes preguntas sobre cómo contribuir:

- Abre un [Discussion](https://github.com/ergrato-dev/bc-oop-java/discussions)
- Contacta a los maintainers

---

## 📜 Licencia

Al contribuir, aceptas que tus contribuciones se licenciarán bajo la [Licencia MIT](LICENSE).

---

**¡Gracias por ayudar a mejorar este bootcamp! 🚀**
