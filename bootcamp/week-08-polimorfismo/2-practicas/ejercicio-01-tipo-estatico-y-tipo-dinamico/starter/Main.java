// Ejercicio 01: una variable tiene un tipo y el objeto al que apunta, otro.

class Main {

    void main() {
        // ============================================
        // PASO 1: una variable Book con un RareBook dentro
        // ============================================
        // Descomenta las siguientes líneas:
        // Book chronicle = new RareBook("BK-001", "Crónica de Núremberg", 1, "Sala de fondo antiguo");
        // IO.println(chronicle.describe());
        // IO.println("La variable es Book; el objeto es " + chronicle.getClass().getSimpleName());

        // ============================================
        // PASO 2: la variable decide qué métodos se pueden llamar
        // ============================================
        // Descomenta la siguiente línea, ejecuta, lee el error y vuelve a comentarla:
        // IO.println(chronicle.getRoom());

        // ============================================
        // PASO 3: un array de Book con tres clases dentro
        // ============================================
        // Descomenta las siguientes líneas:
        // Book[] shelf = {
            // new Book("BK-042", "Ficciones", 2),
            // chronicle,
            // new AudioBook("BK-500", "Pedro Páramo", 3, 241)
        // };
        // for (Book book : shelf) {
            // IO.println(book.describe());
        // }

        // ============================================
        // PASO 4: un parámetro Book acepta cualquier hija
        // ============================================
        // Descomenta el método label() de Main, más abajo.
        // Descomenta las siguientes líneas:
        // for (Book book : shelf) {
            // IO.println(label(book));
        // }

        // ============================================
        // PASO 5: al revés no se puede
        // ============================================
        // Descomenta la siguiente línea, ejecuta, lee el error y vuelve a comentarla:
        // RareBook fake = new Book("BK-002", "Códice", 1);
    }

    // PASO 4: descomenta este método.
    // static String label(Book book) {
        // return "Ficha de " + book.getCode() + ": " + book.describe();
    // }
}

class Book {
    private final String code;
    private final String title;
    private final int copies;

    Book(String code, String title, int copies) {
        this.code = code;
        this.title = title;
        this.copies = copies;
    }

    String getCode() {
        return code;
    }

    String getTitle() {
        return title;
    }

    String describe() {
        return code + " · " + title + " · ejemplares: " + copies;
    }
}

class RareBook extends Book {
    private final String room;

    RareBook(String code, String title, int copies, String room) {
        super(code, title, copies);
        this.room = room;
    }

    String getRoom() {
        return room;
    }

    @Override
    String describe() {
        return super.describe() + " · " + room;
    }
}

class AudioBook extends Book {
    private final int minutes;

    AudioBook(String code, String title, int copies, int minutes) {
        super(code, title, copies);
        this.minutes = minutes;
    }

    @Override
    String describe() {
        return super.describe() + " · " + minutes + " min";
    }
}
