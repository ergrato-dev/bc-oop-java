// Ejercicio 03: jerarquías selladas y pattern matching.

class Main {

    void main() {
        Item[] desk = {
            new Book("BK-042", "Ficciones", 240),
            new Book("BK-500", "Los miserables", 1500),
            new Magazine("RV-007", 512),
            new Dvd("DV-010", 153)
        };

        // ============================================
        // PASO 1: instanceof con un patrón de record
        // ============================================
        // Descomenta las siguientes líneas:
        // for (Item item : desk) {
        //     if (item instanceof Book(String code, String title, int pages)) {
        //         IO.println(code + ": " + title + ", " + pages + " páginas");
        //     }
        // }

        // ============================================
        // PASO 2: un switch con un caso por clase
        // ============================================
        // Descomenta las siguientes líneas:
        // for (Item item : desk) {
        //     IO.println(describe(item));
        // }

        // ============================================
        // PASO 3: un case de menos
        // ============================================
        // No hay líneas que descomentar: sigue el README.

        // ============================================
        // PASO 4: casos con condición, when
        // ============================================
        // Descomenta el método loanDays, más abajo.
        // Descomenta las siguientes líneas:
        // for (Item item : desk) {
        //     IO.println(item.code() + ": " + loanDays(item) + " días");
        // }

        // ============================================
        // PASO 5: una clase que no está en la lista
        // ============================================
        // Descomenta el record Poster, al final del archivo.
        // Descomenta la siguiente línea:
        // IO.println(describe(new Poster("PS-001", "Metrópolis")));
    }

    // Un caso por cada clase que permite Item. Cada case desmonta el record en sus componentes.
    static String describe(Item item) {
        return switch (item) {
            case Book(String code, String title, int pages) ->
                    code + " · libro · " + title + " · " + pages + " páginas";
            case Magazine(String code, int number) -> code + " · revista · número " + number;
            case Dvd(String code, int minutes) -> code + " · DVD · " + minutes + " minutos";
        };
    }

    // PASO 4: descomenta este método.
    // static int loanDays(Item item) {
    //     return switch (item) {
    //         case Book book when book.pages() > 1000 -> 30;
    //         case Book _ -> 21;
    //         case Magazine _ -> 7;
    //         case Dvd _ -> 3;
    //     };
    // }
}

// Solo tres clases pueden ser un Item, y el compilador lo sabe.
sealed interface Item permits Book, Magazine, Dvd {
    String code();
}

// El code() de cada record cumple el code() de Item.
record Book(String code, String title, int pages) implements Item {}

record Magazine(String code, int number) implements Item {}

record Dvd(String code, int minutes) implements Item {}

// PASO 5: descomenta este record.
// record Poster(String code, String film) implements Item {}
