// Ejercicio 03: métodos y String.
//
// Descomenta cada PASO cuando el README te lo pida y ejecuta:
//     java Main.java
// Los PASOS 1, 2 y 3 tienen dos partes: la llamada, aquí en main, y el método,
// más abajo. Descomenta las dos.

void main() {
    IO.println("Ejercicio 03 · Métodos y String");

    // ============================================
    // PASO 1: un método que devuelve un valor
    // ============================================
    // Descomenta las siguientes líneas:
    // IO.println("Con impuesto: " + withTax(100.0, 0.19));
    // IO.println("Con impuesto: " + withTax(12.5, 0.0));

    // ============================================
    // PASO 2: sobrecarga
    // ============================================
    // Dos métodos con el mismo nombre y distintos parámetros.
    // Java elige cuál según los argumentos.
    // Descomenta las siguientes líneas:
    // IO.println(label("BK-042"));
    // IO.println(label("BK-042", 3));

    // ============================================
    // PASO 3: Java pasa copias
    // ============================================
    // Un parámetro recibe una copia del valor. Si el valor es una flecha
    // (un array), la copia apunta al mismo array.
    // Descomenta las siguientes líneas:
    // int copies = 5;
    // int[] stock = {5, 2};
    // tryToChange(copies, stock);
    // IO.println("copies sigue en " + copies);
    // IO.println("stock[0] ahora es " + stock[0]);

    // ============================================
    // PASO 4: trocear y buscar en un String
    // ============================================
    // Las posiciones de un String empiezan en 0, como en un array.
    // substring(a, b) incluye a y excluye b.
    // Descomenta las siguientes líneas:
    // String line = "BK-042;Cien años de soledad;12.5";
    // String[] parts = line.split(";");
    // IO.println("Campos: " + parts.length);
    // IO.println("Título: " + parts[1]);
    // int dash = parts[0].indexOf('-');
    // IO.println("Prefijo: " + parts[0].substring(0, dash));
    // IO.println("Número: " + parts[0].substring(dash + 1));
    // IO.println("¿Empieza por BK? " + line.startsWith("BK"));
    // IO.println("¿Habla de soledad? " + line.contains("soledad"));
    // IO.println(String.join(" | ", parts));

    // ============================================
    // PASO 5: construir texto con StringBuilder
    // ============================================
    // Un String no cambia; sumar en un bucle crea un objeto nuevo por vuelta.
    // StringBuilder acumula en el mismo objeto.
    // Descomenta las siguientes líneas:
    // String[] codes = {"BK-042", "BK-107", "BK-311"};
    // StringBuilder report = new StringBuilder();
    // for (int i = 0; i < codes.length; i++) {
        // report.append(i + 1).append(". ").append(codes[i]).append('\n');
    // }
    // IO.print(report.toString());

    // ============================================
    // PASO 6: recorrer los caracteres
    // ============================================
    // charAt(i) devuelve un char. Character sabe clasificarlo.
    // Descomenta las siguientes líneas:
    // String code = "BK-042";
    // int letters = 0;
    // int digits = 0;
    // for (int i = 0; i < code.length(); i++) {
        // char c = code.charAt(i);
        // if (Character.isLetter(c)) {
            // letters++;
        // } else if (Character.isDigit(c)) {
            // digits++;
        // }
    // }
    // IO.println(code + ": " + letters + " letras, " + digits + " dígitos");
}

// ============================================
// PASO 1 (continuación): el método withTax
// ============================================
// Recibe el precio y la tasa, devuelve el precio con impuesto.
// Descomenta las siguientes líneas:
// double withTax(double price, double rate) {
    // return price + price * rate;
// }

// ============================================
// PASO 2 (continuación): los dos label
// ============================================
// El segundo reutiliza al primero en lugar de repetir código.
// Descomenta las siguientes líneas:
// String label(String code) {
    // return "[" + code + "]";
// }
//
// String label(String code, int copies) {
    // return label(code) + " x" + copies;
// }

// ============================================
// PASO 3 (continuación): el método tryToChange
// ============================================
// Descomenta las siguientes líneas:
// void tryToChange(int n, int[] values) {
    // n = 0;
    // values[0] = 0;
// }
