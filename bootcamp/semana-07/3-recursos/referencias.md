# Referencias y Recursos - Semana 07

## 📚 Documentación Oficial

### Oracle Java Documentation
- **Packages**: [Java Tutorials - Creating and Using Packages](https://docs.oracle.com/javase/tutorial/java/package/)
- **Exceptions**: [Java Tutorials - Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
- **Java SE API**: [Java Platform SE 17 Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/)

### Especificaciones
- [Java Language Specification - Packages](https://docs.oracle.com/javase/specs/jls/se17/html/jls-7.html)
- [Java Language Specification - Exceptions](https://docs.oracle.com/javase/specs/jls/se17/html/jls-11.html)

---

## 🌐 Tutoriales en Línea

### W3Schools
- [Java Packages](https://www.w3schools.com/java/java_packages.asp)
- [Java Try...Catch](https://www.w3schools.com/java/java_try_catch.asp)

### GeeksforGeeks
- [Packages in Java](https://www.geeksforgeeks.org/packages-in-java/)
- [Exceptions in Java](https://www.geeksforgeeks.org/exceptions-in-java/)
- [Checked vs Unchecked Exceptions](https://www.geeksforgeeks.org/checked-vs-unchecked-exceptions-in-java/)

### Baeldung
- [Guide to Java Packages](https://www.baeldung.com/java-packages)
- [Exception Handling in Java](https://www.baeldung.com/java-exceptions)
- [Custom Exceptions in Java](https://www.baeldung.com/java-new-custom-exception)

### JavaPoint
- [Java Package](https://www.javatpoint.com/package)
- [Exception Handling](https://www.javatpoint.com/exception-handling-in-java)

---

## 📖 Artículos y Guías

### Best Practices
- [Effective Java - Exception Best Practices](https://www.oracle.com/technical-resources/articles/java/effective-exceptions.html)
- [Java Exception Handling Best Practices](https://www.baeldung.com/java-exception-handling-best-practices)
- [Clean Code - Error Handling](https://github.com/ryanmcdermott/clean-code-javascript#error-handling)

### Comparaciones
- [Checked vs Unchecked Exceptions: When to Use](https://stackify.com/specify-handle-exceptions-java/)
- [Error vs Exception in Java](https://www.baeldung.com/java-error-vs-exception)

---

## 🎥 Videos Recomendados

### YouTube
- **Programming with Mosh**: [Java Exception Handling](https://www.youtube.com/watch?v=1XAfapkBQjk)
- **Coding with John**: [Java Packages Explained](https://www.youtube.com/watch?v=h7VsyG9DrYs)
- **Java Brains**: [Exception Handling in Java](https://www.youtube.com/watch?v=9vSITZCxBQ8)

### Cursos Online
- **Udemy**: [Java Programming Masterclass - Section on Packages and Exceptions](https://www.udemy.com/course/java-the-complete-java-developer-course/)
- **Coursera**: [Java Programming and Software Engineering Fundamentals](https://www.coursera.org/specializations/java-programming)

---

## 📘 Libros

### Esenciales
- **"Effective Java" (3rd Edition)** - Joshua Bloch
  - Capítulo 10: Exceptions
  
- **"Head First Java" (3rd Edition)** - Kathy Sierra & Bert Bates
  - Capítulo 11: Exception Handling
  - Capítulo 17: Packages and Deployment

- **"Java: The Complete Reference" (12th Edition)** - Herbert Schildt
  - Capítulo 9: Packages and Interfaces
  - Capítulo 10: Exception Handling

### Avanzados
- **"Clean Code"** - Robert C. Martin
  - Capítulo 7: Error Handling
  
- **"Java Concurrency in Practice"** - Brian Goetz
  - Capítulo sobre Exception Handling en contextos concurrentes

---

## 🛠️ Herramientas

### IDEs
- **IntelliJ IDEA**: [Refactoring - Extracting Exception](https://www.jetbrains.com/help/idea/creating-and-optimizing-imports.html)
- **Eclipse**: [Java Development User Guide](https://help.eclipse.org/latest/index.jsp)

### Análisis de Código
- **SonarLint**: Detecta malas prácticas en manejo de excepciones
- **Checkstyle**: Verifica convenciones de packages e imports
- **SpotBugs**: Encuentra bugs relacionados con excepciones

---

## 💻 Repositorios y Ejemplos

### GitHub
- [Java Design Patterns - Exception Handling](https://github.com/iluwatar/java-design-patterns)
- [Awesome Java - Exception Handling Libraries](https://github.com/akullpp/awesome-java#utility)

### Stack Overflow
- [Most voted questions on Java Exceptions](https://stackoverflow.com/questions/tagged/exception+java?tab=Votes)
- [Most voted questions on Java Packages](https://stackoverflow.com/questions/tagged/package+java?tab=Votes)

---

## 📝 Cheat Sheets

### Quick Reference
- [Java Exceptions Cheat Sheet](https://www.baeldung.com/java-exceptions-cheat-sheet)
- [Java Package Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html)

### Visual Guides
- Ver carpeta `0-assets/` para diagramas visuales:
  - `1-estructura-paquetes.svg`
  - `2-jerarquia-excepciones.svg`
  - `3-try-catch-finally.svg`
  - `4-checked-vs-unchecked.svg`
  - `5-propagacion-excepciones.svg`

---

## 🌟 Recursos Adicionales

### Blogs Técnicos
- [Baeldung Java](https://www.baeldung.com/java-tutorial)
- [JournalDev Java](https://www.journaldev.com/java-tutorial-java-ee-tutorials)
- [DZone Java Zone](https://dzone.com/java-jdk-development-tutorials-tools-news)

### Comunidades
- [r/learnjava](https://www.reddit.com/r/learnjava/)
- [Stack Overflow - Java](https://stackoverflow.com/questions/tagged/java)
- [Java Discord Communities](https://discord.com/invite/java)

---

## 📊 Comparación Visual

| Aspecto | Checked | Unchecked |
|---------|---------|-----------|
| **Herencia** | `extends Exception` | `extends RuntimeException` |
| **Compilación** | Debe manejarse | Opcional |
| **Uso** | Errores recuperables | Errores de programación |
| **Ejemplos** | IOException, SQLException | NullPointerException, IllegalArgumentException |

---

## 🔍 Preguntas Frecuentes (FAQs)

### Packages
1. **¿Por qué usar dominio invertido?**
   - Evita conflictos de nombres entre diferentes proyectos

2. **¿Puedo tener clases sin paquete?**
   - Sí (package default), pero no es recomendado

3. **¿Cómo organizo paquetes en proyectos grandes?**
   - Por capas (modelo, servicio, controlador) o por funcionalidad

### Excepciones
1. **¿Cuándo crear una excepción personalizada?**
   - Cuando las excepciones estándar no representan adecuadamente tu error de negocio

2. **¿Checked o Unchecked?**
   - Checked para situaciones recuperables, Unchecked para errores de programación

3. **¿Puedo capturar múltiples excepciones en un solo catch?**
   - Sí, desde Java 7: `catch (IOException | SQLException e)`

---

**Última actualización**: Semana 07 - Bootcamp POO Java
