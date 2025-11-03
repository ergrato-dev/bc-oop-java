# Assets Visuales - Semana 07

## 📊 Diagramas SVG Disponibles

Esta carpeta contiene 5 diagramas visuales (formato SVG) para la **Semana 07: Manejo de Paquetes y Excepciones**.

---

## 🎨 Lista de Recursos

### 1. `1-estructura-paquetes.svg`
**Descripción**: Diagrama mostrando la relación entre:
- Declaración de paquete (`package com.agencia.modelo;`)
- Estructura de carpetas en el sistema de archivos
- Ejemplo con múltiples paquetes (modelo, servicio, excepciones)

**Conceptos ilustrados**:
- Package declaration
- Folder structure matching
- Multiple package organization

**Uso recomendado**: Teoría de paquetes, ejercicios prácticos

---

### 2. `2-jerarquia-excepciones.svg`
**Descripción**: Árbol completo de la jerarquía de excepciones en Java.

**Elementos**:
- **Throwable** (raíz)
  - **Error** (OutOfMemoryError, StackOverflowError)
  - **Exception**
    - **Checked** (IOException, SQLException)
    - **RuntimeException** (Unchecked: NullPointerException, IllegalArgumentException)

**Conceptos ilustrados**:
- System errors vs Application exceptions
- Checked vs Unchecked distinction
- Common exception types

**Uso recomendado**: Teoría de jerarquía, decisiones de diseño

---

### 3. `3-try-catch-finally.svg`
**Descripción**: Flujo de ejecución visualizado en dos escenarios:
- **Flujo normal** (sin excepción): try → finally → continuar
- **Flujo con excepción**: try → catch → finally → continuar

**Conceptos ilustrados**:
- Execution flow paths
- Finally always executes
- Exception handling process

**Uso recomendado**: Explicar try-catch-finally, debugging

---

### 4. `4-checked-vs-unchecked.svg`
**Descripción**: Comparación lado a lado entre excepciones Checked y Unchecked.

**Comparación**:
| Aspecto | Checked | Unchecked |
|---------|---------|-----------|
| Herencia | `extends Exception` | `extends RuntimeException` |
| Compilación | Obligatorio manejar | Opcional |
| Uso | Errores recuperables | Errores de programación |
| Ejemplos | IOException, SQLException | NullPointerException, IllegalArgumentException |

**Conceptos ilustrados**:
- When to use each type
- Compilation requirements
- Code examples

**Uso recomendado**: Decisiones de diseño, creación de excepciones personalizadas

---

### 5. `5-propagacion-excepciones.svg`
**Descripción**: Call stack mostrando cómo las excepciones se propagan hacia arriba.

**Flujo ilustrado**:
1. **Llamadas descendentes**: main() → metodA() → metodB() → metodC()
2. **Excepción lanzada**: En metodC() (división por cero)
3. **Propagación ascendente**: metodC → metodB → metodA → main()
4. **Captura**: Try-catch en main() atrapa la excepción

**Conceptos ilustrados**:
- Call stack mechanism
- Exception bubbling up
- Try-catch at appropriate level

**Uso recomendado**: Debugging, comprensión de stack traces

---

## 🎯 Características de los SVG

### Estilo Visual
- **Tema**: Oscuro (fondo #1e1e1e)
- **Sin degradados**: Colores sólidos para mejor impresión
- **Contraste alto**: Texto blanco/claro sobre fondo oscuro
- **Tipografía**:
  - Títulos: Segoe UI (sans-serif)
  - Código: Courier New (monospace)

### Código de Colores
- **#569cd6**: Azul (elementos principales, estructura)
- **#ce9178**: Naranja (checked exceptions, packages)
- **#d7ba7d**: Amarillo (unchecked exceptions)
- **#f48771**: Rojo (errores, excepciones lanzadas)
- **#4ec9b0**: Verde (flujo correcto, éxito)
- **#6a9955**: Verde oscuro (comentarios)

### Dimensiones
- **Ancho**: 800-1100px (varía por diagrama)
- **Alto**: 600-750px
- **Formato**: Escalable (SVG vectorial)

---

## 📥 Cómo Usar

### En Markdown
```markdown
![Jerarquía de Excepciones](./0-assets/2-jerarquia-excepciones.svg)
```

### En HTML
```html
<img src="./0-assets/2-jerarquia-excepciones.svg" alt="Jerarquía de Excepciones" width="800">
```

### En Presentaciones
1. Abrir SVG en navegador
2. Captura de pantalla o exportar a PNG/PDF
3. Insertar en PowerPoint/Google Slides

### En Documentación
- Importar directamente en editores que soporten SVG
- Convertir a PNG para compatibilidad máxima

---

## 🔧 Herramientas de Visualización

### Navegadores
- Chrome, Firefox, Edge, Safari (soporte nativo)

### Editores
- VS Code (preview inline)
- IntelliJ IDEA (preview panel)
- Inkscape (edición avanzada)

### Conversión
```bash
# SVG to PNG (requiere Inkscape)
inkscape 1-estructura-paquetes.svg --export-type=png --export-dpi=300

# SVG to PDF
inkscape 1-estructura-paquetes.svg --export-type=pdf
```

---

## 📚 Relación con Material Teórico

| SVG | Archivo de Teoría | Sección |
|-----|-------------------|---------|
| 1-estructura-paquetes.svg | 01-organizacion-paquetes.md | Declaración y estructura |
| 2-jerarquia-excepciones.svg | 03-jerarquia-excepciones.md | Throwable y subclases |
| 3-try-catch-finally.svg | 02-manejo-excepciones.md | Sintaxis básica |
| 4-checked-vs-unchecked.svg | 03-jerarquia-excepciones.md | Tipos de excepciones |
| 5-propagacion-excepciones.svg | 02-manejo-excepciones.md | Propagación y stack |

---

## 💡 Tips Pedagógicos

### Para Instructores
1. **Proyectar en clase**: Usar durante explicaciones teóricas
2. **Imprimir**: Distribuir como referencia rápida
3. **Comparar**: Mostrar diferencias lado a lado
4. **Señalar**: Usar puntero láser para destacar elementos
5. **Preguntar**: "¿Qué pasa si...?" usando el diagrama

### Para Estudiantes
1. **Estudiar**: Revisar antes de codificar
2. **Referencia**: Tener abierto durante ejercicios
3. **Comparar**: Contrastar con tu código
4. **Imprimir**: Tener físicamente para consulta
5. **Compartir**: Explicar a compañeros usando diagramas

---

## 🎨 Personalización

Si necesitas modificar los SVG:

1. **Abrir** en editor de texto (es XML)
2. **Modificar** colores cambiando valores hexadecimales
3. **Ajustar** textos editando elementos `<text>`
4. **Guardar** con codificación UTF-8

**Ejemplo**:
```xml
<text class="text" x="100" y="200" fill="#ffffff">Tu Texto</text>
```

---

## ✅ Checklist de Uso

Antes de usar en presentación o documento:
- [ ] SVG se visualiza correctamente en navegador
- [ ] Texto es legible (tamaño apropiado)
- [ ] Colores tienen buen contraste
- [ ] Elementos no se superponen
- [ ] Exportado a formato requerido (si aplica)

---

## 📞 Soporte

Si encuentras problemas con los SVG:
1. Verificar navegador actualizado
2. Probar en otro visor
3. Reportar problema con screenshot
4. Consultar con instructor

---

**Tema**: Oscuro  
**Formato**: SVG (Scalable Vector Graphics)  
**Cantidad**: 5 diagramas  
**Semana**: 07 - Manejo de Paquetes y Excepciones
