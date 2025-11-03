# ✅ Checklist del Proyecto Final

## Guía de Verificación Completa

Usa este checklist para asegurarte de que tu proyecto cumple con todos los requisitos antes de la entrega.

---

## 📋 Antes de Empezar

### Planificación (Día 1)
- [ ] Leo y comprendo completamente el enunciado del proyecto
- [ ] Identifico las entidades principales de mi dominio
- [ ] Listo las funcionalidades CRUD que necesito implementar
- [ ] Creo un boceto del diagrama de clases en papel
- [ ] Identifico qué jerarquías de herencia necesito

### Configuración del Entorno
- [ ] Tengo JDK 11 o superior instalado
- [ ] Mi IDE está configurado correctamente
- [ ] Creo la estructura de carpetas del proyecto
- [ ] Creo los paquetes necesarios (modelo, servicio, excepciones, util)

---

## 🏗️ Estructura del Proyecto

### Organización de Carpetas
- [ ] Carpeta `src/` con código fuente
- [ ] Carpeta `docs/` con documentación
- [ ] Archivo `README.md` en la raíz
- [ ] Estructura de paquetes correcta:
  ```
  src/
  ├── modelo/
  ├── servicio/
  ├── excepciones/
  ├── util/
  └── Main.java
  ```

---

## 🎯 Requisitos de Orientación a Objetos (40%)

### Clases del Dominio
- [ ] Tengo mínimo 5 clases del dominio
- [ ] Todas las clases tienen nombres descriptivos en PascalCase
- [ ] Cada clase representa una entidad del mundo real
- [ ] Las clases están en el paquete `modelo/`

### Encapsulación
- [ ] **TODOS** los atributos son privados
- [ ] Cada atributo privado tiene su getter público
- [ ] Cada atributo modificable tiene su setter público
- [ ] Los setters incluyen validaciones apropiadas
- [ ] No hay atributos públicos sin justificación

### Herencia
- [ ] Tengo al menos 1 jerarquía de herencia
- [ ] La jerarquía tiene 1 clase padre + mínimo 2 clases hijas
- [ ] La relación "es-un" tiene sentido lógicamente
- [ ] Uso `super()` en constructores de clases hijas
- [ ] Aprovecho atributos y métodos heredados
- [ ] No hay duplicación de código entre padre e hijos

### Polimorfismo
- [ ] Implemento sobrecarga de métodos (mismo nombre, diferentes parámetros)
- [ ] Implemento sobrescritura de métodos con `@Override`
- [ ] Uso referencias de clase padre para objetos de clases hijas
- [ ] Aprovecho polimorfismo en colecciones cuando es apropiado

### Abstracción
- [ ] Implemento al menos 1 clase abstracta O 1 interface
- [ ] Las clases abstractas tienen sentido conceptual
- [ ] Los métodos abstractos son implementados por todas las clases hijas
- [ ] Las interfaces definen contratos claros
- [ ] No intento instanciar clases abstractas directamente

---

## 🗂️ Colecciones y Excepciones (30%)

### Uso de Listas (ArrayList/LinkedList)
- [ ] Uso `ArrayList<T>` o `LinkedList<T>` con generics
- [ ] Declaro: `List<Entidad> lista = new ArrayList<>()`
- [ ] NO uso tipos raw: ~~`ArrayList lista`~~
- [ ] Agrego elementos con `add()`
- [ ] Recorro con for-each o Iterator

### Uso de Mapas (HashMap/TreeMap)
- [ ] Uso `HashMap<K, V>` o `TreeMap<K, V>` con generics
- [ ] Declaro: `Map<String, Entidad> mapa = new HashMap<>()`
- [ ] Uso claves apropiadas (String, Integer, etc.)
- [ ] Agrego con `put(clave, valor)`
- [ ] Busco con `get(clave)`

### Iteración de Colecciones
- [ ] Uso for-each: `for (Entidad e : lista)`
- [ ] O uso Iterator cuando necesito eliminar durante iteración
- [ ] O uso forEach() con lambdas (opcional)
- [ ] NO modifico colecciones incorrectamente durante iteración

### Excepciones Personalizadas
- [ ] Creo mínimo 2 excepciones personalizadas
- [ ] Las excepciones están en el paquete `excepciones/`
- [ ] Extienden `Exception` o `RuntimeException`
- [ ] Tienen constructores con y sin mensaje
- [ ] Los nombres terminan en "Exception"
  - Ejemplo: `ProductoNoEncontradoException`

### Manejo de Excepciones
- [ ] Uso try-catch en operaciones riesgosas
- [ ] Lanzo excepciones con `throw new MiException("mensaje")`
- [ ] Propago con `throws` en la firma cuando es necesario
- [ ] Los mensajes de error son descriptivos
- [ ] Uso finally cuando necesito liberar recursos

---

## ⚙️ Funcionalidad del Sistema (20%)

### Menú Interactivo
- [ ] El programa muestra un menú al iniciar
- [ ] Las opciones están numeradas claramente
- [ ] Incluyo opción para salir (0 o última opción)
- [ ] El menú se muestra en bucle hasta que el usuario salga
- [ ] Manejo entradas inválidas sin crashes

### Operaciones CRUD
- [ ] **CREATE**: Puedo agregar nuevas entidades
- [ ] **READ**: Puedo listar todas las entidades
- [ ] **READ**: Puedo buscar/filtrar entidades específicas
- [ ] **UPDATE**: Puedo modificar entidades existentes
- [ ] **DELETE**: Puedo eliminar entidades

### Funcionalidades Adicionales
- [ ] Tengo mínimo 6 funcionalidades distintas
- [ ] Cada funcionalidad hace algo útil y tiene sentido
- [ ] Las operaciones complejas están en clases de servicio
- [ ] No toda la lógica está en Main.java

### Validaciones
- [ ] Valido entradas del usuario (no vacías, formato correcto)
- [ ] Valido antes de agregar a colecciones
- [ ] Valido antes de modificar o eliminar
- [ ] Prevengo duplicados cuando corresponde
- [ ] Muestro mensajes claros cuando algo falla

---

## 📝 Documentación (10%)

### README.md
- [ ] Incluyo título del proyecto
- [ ] Incluyo mi nombre completo y ficha
- [ ] Describo brevemente qué hace el sistema
- [ ] Listo los requisitos (JDK version)
- [ ] Explico cómo compilar el proyecto
- [ ] Explico cómo ejecutar el proyecto
- [ ] Listo las funcionalidades implementadas
- [ ] Incluyo capturas de pantalla (opcional pero recomendado)

### Diagrama de Clases UML
- [ ] Creo el diagrama con todas las clases
- [ ] Incluyo atributos (con tipo y visibilidad)
- [ ] Incluyo métodos principales (con parámetros y retorno)
- [ ] Muestro relaciones de herencia
- [ ] Muestro relaciones de asociación/composición
- [ ] Guardo como imagen (PNG, JPG o PDF)
- [ ] Lo incluyo en la carpeta `docs/`

### Comentarios en Código
- [ ] Las clases principales tienen comentarios Javadoc
  ```java
  /**
   * Descripción de la clase
   * @author Tu Nombre
   */
  ```
- [ ] Los métodos complejos tienen comentarios explicativos
- [ ] NO comento obviedades: ~~`// incrementa i`~~
- [ ] Los comentarios explican el "por qué", no el "qué"

### Informe Técnico
- [ ] Escribo 1-2 páginas explicando decisiones de diseño
- [ ] Explico qué principios de POO apliqué y dónde
- [ ] Describo desafíos encontrados y cómo los resolví
- [ ] Guardo como PDF en `docs/informe-tecnico.pdf`

---

## 🧪 Testing y Calidad

### Pruebas Manuales
- [ ] Pruebo TODAS las funcionalidades del menú
- [ ] Pruebo con datos válidos
- [ ] Pruebo con datos inválidos (entradas erróneas)
- [ ] Pruebo casos límite (listas vacías, búsquedas sin resultados)
- [ ] El programa nunca crashea, siempre muestra mensajes de error

### Compilación
- [ ] El código compila sin errores
- [ ] No hay warnings críticos
- [ ] Comando: `javac -d bin src/**/*.java` funciona

### Ejecución
- [ ] El programa ejecuta correctamente
- [ ] Comando: `java -cp bin Main` funciona
- [ ] No hay excepciones no manejadas en runtime

---

## 🎨 Calidad de Código

### Convenciones de Nombres
- [ ] Clases: `PascalCase` (ProductoDigital)
- [ ] Métodos y variables: `camelCase` (calcularTotal)
- [ ] Constantes: `UPPER_SNAKE_CASE` (MAX_INTENTOS)
- [ ] Paquetes: `lowercase` (modelo, servicio)

### Organización
- [ ] Cada clase está en su propio archivo
- [ ] Las clases están en los paquetes correctos
- [ ] No hay código duplicado extensivamente
- [ ] Los métodos son cortos y enfocados (<50 líneas)
- [ ] La lógica de negocio NO está en Main.java

### Buenas Prácticas
- [ ] Uso constantes en lugar de "magic numbers"
- [ ] Cierro recursos (Scanner) apropiadamente
- [ ] No hay código comentado sin usar
- [ ] No hay imports innecesarios
- [ ] Uso nombres descriptivos, no abreviaturas crípticas

---

## 📦 Preparación para Entrega

### Estructura del ZIP
- [ ] Creo carpeta con formato: `ApellidoNombre-ProyectoFinal/`
- [ ] Incluyo carpeta `src/` completa
- [ ] Incluyo carpeta `docs/` con:
  - [ ] Diagrama de clases (imagen)
  - [ ] Informe técnico (PDF)
- [ ] Incluyo `README.md` en la raíz
- [ ] Comprimo todo en un archivo .zip
- [ ] Verifico que el ZIP no esté corrupto

### Verificación Final
- [ ] Descomprimo el ZIP en otra ubicación
- [ ] Compilo desde cero en esa ubicación
- [ ] Ejecuto y pruebo que funciona
- [ ] Reviso que todos los archivos estén incluidos
- [ ] El tamaño del ZIP es razonable (<5 MB sin archivos innecesarios)

### Antes de Enviar
- [ ] Verifico la fecha y hora límite de entrega
- [ ] Leo las instrucciones de entrega una vez más
- [ ] Envío con tiempo suficiente (no último minuto)
- [ ] Guardo copia de respaldo del proyecto
- [ ] Confirmo que la entrega fue exitosa

---

## 🎤 Preparación para Presentación

### Contenido de la Presentación (10 min)
- [ ] Preparo introducción del proyecto (30 seg)
- [ ] Explico diagrama de clases (2 min)
- [ ] Demuestro funcionalidades principales (4 min)
- [ ] Explico aplicación de POO (2 min)
- [ ] Muestro código relevante (1 min)
- [ ] Conclusiones y cierre (30 seg)

### Práctica
- [ ] Practico la presentación al menos 2 veces
- [ ] Me aseguro de no pasarme del tiempo (10 min)
- [ ] Preparo respuestas a posibles preguntas:
  - [ ] ¿Por qué elegiste esta jerarquía?
  - [ ] ¿Dónde aplicaste polimorfismo?
  - [ ] ¿Qué excepciones personalizadas creaste?
  - [ ] ¿Por qué usaste HashMap en lugar de ArrayList aquí?

### Día de la Presentación
- [ ] Llego 10 minutos antes
- [ ] Tengo el código listo para ejecutar
- [ ] Tengo el diagrama UML visible
- [ ] Tengo una actitud profesional y confiada

---

## 🏆 Criterios de Excelencia (Ir más allá)

Si quieres obtener 4.5+, considera:

### Funcionalidades Avanzadas
- [ ] Implemento patrón Singleton, Factory o Strategy
- [ ] Guardo/cargo datos desde archivo (txt, csv, json)
- [ ] Creo interfaz gráfica básica con Swing o JavaFX
- [ ] Implemento búsquedas avanzadas o filtros complejos
- [ ] Agrego ordenamiento personalizado

### Calidad Excepcional
- [ ] Testing unitario con JUnit
- [ ] Uso de Git con commits significativos
- [ ] Documentación Javadoc completa
- [ ] Código extremadamente limpio y organizado
- [ ] README con capturas y ejemplos de uso

---

## ⚠️ Errores Comunes a Evitar

### NO Hagas Esto:
- ❌ Dejar atributos públicos sin getters/setters
- ❌ No usar generics en colecciones: ~~`ArrayList lista`~~
- ❌ Tener toda la lógica en Main.java
- ❌ Copiar código de internet sin entender
- ❌ No manejar excepciones (programa se crashea)
- ❌ Nombres de variables sin sentido: `a`, `b`, `x1`
- ❌ No validar entradas del usuario
- ❌ Entregar sin probar todas las funcionalidades
- ❌ No incluir README o diagrama UML
- ❌ Entregar fuera de plazo

---

## 📊 Auto-Evaluación Rápida

Suma tus puntos:

### Requisitos Mínimos (Pasa/Falla)
- [ ] 5+ clases del dominio
- [ ] 1 jerarquía de herencia (padre + 2 hijos)
- [ ] Encapsulación completa
- [ ] 1 clase abstracta O 1 interface
- [ ] Polimorfismo aplicado
- [ ] ArrayList/LinkedList usado
- [ ] HashMap/TreeMap usado
- [ ] 2+ excepciones personalizadas
- [ ] Try-catch implementado
- [ ] Menú funcional
- [ ] 4+ funcionalidades
- [ ] CRUD básico (Create + Read)
- [ ] README con instrucciones
- [ ] Diagrama UML

**Si NO cumples TODOS estos, tu nota será <3.5**

### Puntos Adicionales
- [ ] 8+ funcionalidades (0.3)
- [ ] CRUD completo (0.2)
- [ ] Validaciones robustas (0.2)
- [ ] Código muy limpio (0.3)
- [ ] Documentación excelente (0.2)
- [ ] Presentación clara (0.3)

---

## 🎯 Mensaje Final

**Este checklist es tu mejor amigo**. Imprímelo o tenlo abierto mientras trabajas.

Revísalo diariamente durante el desarrollo:
- **Día 1**: Planificación y diseño
- **Día 2-3**: Implementación core
- **Día 4**: Testing y documentación
- **Día 5**: Revisión final y entrega

**Recuerda**: Es mejor entregar un proyecto simple pero completo y funcional, que uno ambicioso pero incompleto.

---

## ✨ ¡Mucho Éxito!

Si completaste este checklist, estás listo para entregar un excelente proyecto final. 🚀

**Pregunta al instructor ante cualquier duda. Es mejor preguntar que adivinar.**

---

**Versión**: 1.0  
**Última actualización**: Noviembre 2025  
**Uso**: Proyecto Final - Semana 09
