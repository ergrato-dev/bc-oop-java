// Ejercicio 02: bucles y arrays.
//
// Descomenta cada PASO cuando el README te lo pida y ejecuta:
//     java Main.java

import java.util.Arrays;

void main() {
    IO.println("Ejercicio 02 · Bucles y arrays");

    // ============================================
    // PASO 1: while
    // ============================================
    // Repite mientras la condición sea true. Si nada la cambia dentro,
    // el bucle no termina nunca.
    // Descomenta las siguientes líneas:
    // int copies = 3;
    // while (copies > 0) {
        // IO.println("Presto una, quedan " + (copies - 1));
        // copies--;
    // }

    // ============================================
    // PASO 2: for clásico
    // ============================================
    // for (inicio; condición; paso): el contador vive solo dentro del bucle.
    // Descomenta las siguientes líneas:
    // int sum = 0;
    // for (int i = 1; i <= 10; i++) {
        // sum += i;
    // }
    // IO.println("Suma de 1 a 10: " + sum);

    // ============================================
    // PASO 3: arrays y for-each
    // ============================================
    // Un array tiene tamaño fijo y sus posiciones van de 0 a length - 1.
    // for-each recorre los valores sin manejar índices.
    // Descomenta las siguientes líneas:
    // String[] codes = {"BK-042", "BK-107", "BK-311"};
    // int[] stock = {4, 0, 7};
    // IO.println("Hay " + codes.length + " códigos; el primero es " + codes[0]);
    // int total = 0;
    // for (int q : stock) {
        // total += q;
    // }
    // IO.println("Total en stock: " + total);
    // IO.println(Arrays.toString(stock));

    // ============================================
    // PASO 4: buscar con índice, break y continue
    // ============================================
    // Cuando necesitas la posición, usa el for clásico.
    // break sale del bucle; continue salta a la siguiente vuelta.
    // Descomenta las siguientes líneas:
    // for (int i = 0; i < stock.length; i++) {
        // if (stock[i] == 0) {
            // IO.println("Agotado: " + codes[i] + " (posición " + i + ")");
            // break;
        // }
    // }
    // for (int i = 0; i < stock.length; i++) {
        // if (stock[i] == 0) {
            // continue;
        // }
        // IO.println("Disponible: " + codes[i]);
    // }

    // ============================================
    // PASO 5: copiar no es asignar
    // ============================================
    // Un array es un objeto: = copia la flecha, no los datos.
    // Arrays.copyOf crea un array nuevo.
    // Descomenta las siguientes líneas:
    // int[] alias = stock;
    // int[] copy = Arrays.copyOf(stock, stock.length);
    // alias[1] = 99;
    // IO.println("stock: " + Arrays.toString(stock));
    // IO.println("copy:  " + Arrays.toString(copy));
    // Arrays.sort(copy);
    // IO.println("copy ordenada: " + Arrays.toString(copy));

    // ============================================
    // PASO 6: salirse del array
    // ============================================
    // La última posición es length - 1. Este bucle usa <= y se pasa una.
    // Descomenta las siguientes líneas:
    // for (int i = 0; i <= codes.length; i++) {
        // IO.println(i + ": " + codes[i]);
    // }
}
