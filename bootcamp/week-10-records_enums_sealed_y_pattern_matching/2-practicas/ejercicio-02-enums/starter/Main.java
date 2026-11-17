// Ejercicio 02: enums, un tipo con un número fijo de valores.

class Main {

    void main() {
        // ============================================
        // PASO 1: un formato como texto
        // ============================================
        // Descomenta las siguientes líneas:
        // IO.println("papel: " + daysFor("papel") + " días");
        // IO.println("Papel: " + daysFor("Papel") + " días");
        // IO.println("pdf: " + daysFor("pdf") + " días");

        // ============================================
        // PASO 2: el mismo formato, como enum
        // ============================================
        // Descomenta las siguientes líneas:
        // Format paper = Format.PAPER;
        // IO.println(paper + ": " + paper.days() + " días");
        // for (Format format : Format.values()) {
        //     IO.println(format.ordinal() + " · " + format + " · " + format.days() + " días");
        // }

        // ============================================
        // PASO 3: un valor que no existe no compila
        // ============================================
        // Descomenta la siguiente línea:
        // Format wrong = Format.PAPPER;

        // ============================================
        // PASO 4: de texto a enum, con valueOf
        // ============================================
        // Descomenta las siguientes líneas:
        // IO.println("EBOOK: " + Format.valueOf("EBOOK").days() + " días");
        // IO.println(Format.valueOf("ebook"));

        // ============================================
        // PASO 5: un switch que cubre todos los valores
        // ============================================
        // Descomenta el método place, más abajo.
        // Descomenta las siguientes líneas:
        // for (Format format : Format.values()) {
        //     IO.println(format + " se guarda en " + place(format));
        // }

        // ============================================
        // PASO 6: cada constante existe una sola vez
        // ============================================
        // Descomenta las siguientes líneas:
        // Format chosen = Format.valueOf("AUDIO");
        // IO.println(chosen == Format.AUDIO);
        // IO.println(chosen.name() + " es " + (chosen.days() > 10 ? "largo" : "corto"));
    }

    // Con textos, cualquier String vale: lo que no se reconoce cae en el último return.
    static int daysFor(String format) {
        if (format.equals("papel")) {
            return 21;
        }
        if (format.equals("ebook")) {
            return 7;
        }
        return 14;
    }

    // PASO 5: descomenta este método.
    // static String place(Format format) {
    //     return switch (format) {
    //         case PAPER -> "la estantería";
    //         case EBOOK -> "el servidor";
    //     };
    // }
}

// Tres formatos y ninguno más. Cada constante guarda sus días de préstamo.
enum Format {
    PAPER(21),
    EBOOK(7),
    AUDIO(14);

    private final int days;

    Format(int days) {
        this.days = days;
    }

    int days() {
        return days;
    }
}
