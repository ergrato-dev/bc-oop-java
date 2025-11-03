# Ejercicio 03: Excepciones Personalizadas

## 🎯 Objetivo
Crear y usar excepciones específicas del dominio.

## ⏱️ Tiempo: 45 minutos

## 📋 Tareas

1. Crear 2 excepciones personalizadas (checked):
   - `ReservaInvalidaException`
   - `DisponibilidadException`

2. Agregar constructores:
   - Constructor con mensaje
   - Constructor con mensaje y causa

3. Usar en clase de servicio:
   - Lanzar con `throw`
   - Declarar con `throws`
   - Capturar en `Main`

## ✅ Estructura
```
src/
├── excepciones/
│   ├── ReservaInvalidaException.java
│   └── DisponibilidadException.java
├── GestorReservas.java
└── Main.java
```

**Ver carpeta `solucion/` para código completo**
