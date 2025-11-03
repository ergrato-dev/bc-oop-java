# Ejercicio 01: Organización en Paquetes

## 🎯 Objetivo
Crear una estructura de paquetes correcta siguiendo convenciones profesionales y practicar el uso de imports.

## ⏱️ Tiempo Estimado
30 minutos

## 📋 Instrucciones

### Paso 1: Crear Estructura de Paquetes
Crea la siguiente estructura de carpetas:
```
src/
└── com/
    └── agencia/
        ├── modelo/
        ├── servicio/
        └── util/
```

### Paso 2: Crear Clases en `modelo`
En `com.agencia.modelo`:
- `Reserva.java`: Atributos (codigo, cliente, fecha, precio)
- `Cliente.java`: Atributos (nombre, email)

### Paso 3: Crear Clase en `servicio`
En `com.agencia.servicio`:
- `GestorReservas.java`: Método `agregarReserva()` que usa clases de `modelo`

### Paso 4: Crear Clase en `util`
En `com.agencia.util`:
- `Validador.java`: Método estático `validarEmail(String email)`

### Paso 5: Crear Main
En `com.agencia`:
- `Main.java`: Usa todas las clases anteriores con imports

## ✅ Criterios de Éxito
- [ ] Declaración `package` correcta en cada archivo
- [ ] Imports necesarios (sin wildcards innecesarios)
- [ ] Estructura de carpetas coincide con paquetes
- [ ] Programa compila y ejecuta sin errores
- [ ] Se usa al menos 1 import estático

## 🚀 Compilación y Ejecución

### Desde terminal:
```bash
cd ejercicio-01-organizacion-paquetes/solucion

# Compilar
javac -d bin src/com/agencia/*/*.java src/com/agencia/*.java

# Ejecutar
java -cp bin com.agencia.Main
```

### Desde IntelliJ:
1. Abrir carpeta `ejercicio-01-organizacion-paquetes`
2. Clic derecho en `src` → Mark Directory as → Sources Root
3. Run → Run 'Main'

## 💡 Pistas
- Package siempre es la primera línea (después de comentarios)
- Import va después de package
- Usa `import static` para métodos utilitarios
- Verifica que carpetas = paquetes

---

**Ver carpeta `solucion/` para código completo comentado**
