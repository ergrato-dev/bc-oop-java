// Ejercicio 01: condicionales y switch.
//
// Descomenta cada PASO cuando el README te lo pida y ejecuta:
//     java Main.java

void main() {
    IO.println("Ejercicio 01 · Condicionales y switch");

    // ============================================
    // PASO 1: if / else if / else
    // ============================================
    // Las condiciones se evalúan de arriba abajo y solo se ejecuta
    // el primer bloque cuya condición es true.
    // Descomenta las siguientes líneas:
    // int copies = 3;
    // if (copies == 0) {
        // IO.println("Agotado");
    // } else if (copies < 5) {
        // IO.println("Quedan pocas: " + copies);
    // } else {
        // IO.println("Hay de sobra");
    // }

    // ============================================
    // PASO 2: operadores lógicos
    // ============================================
    // && exige las dos condiciones, || basta con una, ! niega.
    // && y || paran en cuanto conocen el resultado (cortocircuito).
    // Descomenta las siguientes líneas:
    // double price = 12.5;
    // boolean active = true;
    // IO.println("¿En oferta? " + (active && price < 15));
    // IO.println("¿Revisar? " + (price <= 0 || price > 500));
    // IO.println("¿Retirado? " + !active);
    // String code = null;
    // IO.println("¿Código válido? " + (code != null && code.length() == 6));

    // ============================================
    // PASO 3: switch con flechas
    // ============================================
    // switch como expresión: devuelve un valor. Cada caso con -> y
    // sin break. Varias etiquetas se separan con comas.
    // Descomenta las siguientes líneas:
    // String day = "SAT";
    // String schedule = switch (day) {
        // case "MON", "TUE", "WED", "THU", "FRI" -> "9:00-18:00";
        // case "SAT" -> "10:00-14:00";
        // case "SUN" -> "Cerrado";
        // default -> "Día desconocido";
    // };
    // IO.println(day + ": " + schedule);

    // ============================================
    // PASO 4: switch con bloques y yield
    // ============================================
    // Si un caso necesita varias líneas, usa { } y yield para devolver.
    // Descomenta las siguientes líneas:
    // int month = 2;
    // int days = switch (month) {
        // case 4, 6, 9, 11 -> 30;
        // case 2 -> {
            // IO.println("Febrero: depende del año");
            // yield 28;
        // }
        // default -> 31;
    // };
    // IO.println("Días del mes " + month + ": " + days);

    // ============================================
    // PASO 5: el operador ternario
    // ============================================
    // condición ? siVerdad : siFalso. Útil para elegir entre dos valores;
    // para más de dos, mejor if o switch.
    // Descomenta las siguientes líneas:
    // int stock = 1;
    // IO.println(stock + (stock == 1 ? " copia" : " copias"));
    // stock = 4;
    // IO.println(stock + (stock == 1 ? " copia" : " copias"));

    // ============================================
    // PASO 6: el orden de las condiciones importa
    // ============================================
    // Este if tiene un error de lógica: compila, pero nunca llega a "Agotado".
    // Descomenta las siguientes líneas:
    // int left = 0;
    // if (left < 5) {
        // IO.println("Quedan pocas: " + left);
    // } else if (left == 0) {
        // IO.println("Agotado");
    // }
}
