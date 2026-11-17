// Ejercicio 03 · Depuración
// Ejecuta con: java Main.java
// Cada paso trae un error escondido. El README te dice cómo encontrarlo.

// Media entera de un array.
int average(int[] values) {
    return sum(values) / values.length;
}

int sum(int[] values) {
    int total = 0;
    for (int v : values) {
        total += v;
    }
    return total;
}

// Cuántos préstamos superan el límite de días.
int lateCount(int[] days, int limit) {
    int count = 0;
    for (int i = 1; i < days.length; i++) {
        if (days[i] > limit) {
            count++;
        }
    }
    return count;
}

void main() {
    // ============================================
    // PASO 1: leer un stack trace
    // ============================================
    // Una media sin datos. Lee el error de abajo arriba.
    // Descomenta las siguientes líneas:
    // int[] noLoans = {};
    // IO.println("Media: " + average(noLoans));

    // ============================================
    // PASO 2: el mensaje de NullPointerException
    // ============================================
    // Un array de String recién creado tiene null en las posiciones sin rellenar.
    // Descomenta las siguientes líneas:
    // String[] titles = new String[3];
    // titles[0] = "Rayuela";
    // titles[1] = "Ficciones";
    // for (String title : titles) {
        // IO.println(title.toUpperCase());
    // }

    // ============================================
    // PASO 3: imprimir para ver qué pasa
    // ============================================
    // Hay 3 préstamos de más de 14 días, pero el programa dice otra cosa.
    // Descomenta las siguientes líneas:
    // int[] loanDays = {20, 3, 15, 30, 7};
    // IO.println("Retrasados: " + lateCount(loanDays, 14));

    // ============================================
    // PASO 4: assert, una comprobación que se activa con -ea
    // ============================================
    // 3 lotes de 900 millones de céntimos no caben en un int.
    // Descomenta las siguientes líneas:
    // int lots = 3;
    // int totalCents = lots * 900_000_000;
    // assert totalCents >= 0 : "total negativo: " + totalCents;
    // IO.println("Total en céntimos: " + totalCents);
}
