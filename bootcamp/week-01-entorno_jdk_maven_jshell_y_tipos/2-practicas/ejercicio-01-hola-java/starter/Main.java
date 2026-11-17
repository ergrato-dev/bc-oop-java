// Ejercicio 01: tu primer programa Java 25.
//
// Descomenta cada PASO cuando el README te lo pida y ejecuta:
//     java Main.java

void main() {
    IO.println("Ejercicio 01 · Hola, Java");

    // ============================================
    // PASO 3: llamar a un método propio
    // ============================================
    // greet está definido más abajo, fuera de main. Aquí solo lo usas.
    // Descomenta las siguientes líneas:
    // IO.println(greet("Ana"));
    // IO.println(greet("   "));

    // ============================================
    // PASO 4: qué Java te está ejecutando
    // ============================================
    // Runtime.version() es la versión de la JVM; os.name, el sistema operativo.
    // Descomenta las siguientes líneas:
    // IO.println("Java " + Runtime.version().feature());
    // IO.println("Sistema: " + System.getProperty("os.name"));

    // ============================================
    // PASO 6: un error que solo aparece al ejecutar
    // ============================================
    // Compila sin problema: el texto "doce" no es un número, pero eso no se sabe
    // hasta que la línea se ejecuta. Lee el stack trace de abajo arriba.
    // Descomenta las siguientes líneas:
    // int copies = Integer.parseInt("doce");
    // IO.println("Copias: " + copies);
}

// ============================================
// PASO 3 (continuación): el método greet
// ============================================
// String greet(String name): recibe un texto y devuelve otro.
// strip() quita los espacios de los lados; isEmpty() pregunta si quedó vacío.
// Descomenta las siguientes líneas:
// String greet(String name) {
    // String clean = name.strip();
    // if (clean.isEmpty()) {
        // return "Hola, mundo";
    // }
    // return "Hola, " + clean;
// }
