// Ejercicio 03: preguntar el tipo de un objeto funciona, pero casi siempre hay algo mejor.

class Main {

    void main() {
        // ============================================
        // PASO 1: bajar de Book a RareBook con un cast
        // ============================================
        // Descomenta las siguientes líneas:
        // Book ficciones = new Book("BK-042", "Ficciones", 2);
        // Book chronicle = new RareBook("BK-001", "Crónica de Núremberg", 1, "Sala de fondo antiguo");
        // Book audio = new AudioBook("BK-500", "Pedro Páramo", 3, 241);
        // RareBook rare = (RareBook) chronicle;
        // IO.println("Sala: " + rare.getRoom());

        // ============================================
        // PASO 2: un cast equivocado compila y revienta al ejecutar
        // ============================================
        // Descomenta la siguiente línea, ejecuta, lee el error y vuelve a comentarla:
        // RareBook wrong = (RareBook) ficciones;

        // ============================================
        // PASO 3: instanceof antes de bajar
        // ============================================
        // Descomenta las siguientes líneas:
        // Book[] shelf = { ficciones, chronicle, audio };
        // for (Book book : shelf) {
            // if (book instanceof RareBook rareBook) {
                // IO.println(book.getCode() + ": solo en la " + rareBook.getRoom());
            // } else {
                // IO.println(book.getCode() + ": se presta");
            // }
        // }

        // ============================================
        // PASO 4: una regla escrita con instanceof
        // ============================================
        // Descomenta el método loanDays(Book) de Main, más abajo.
        // Descomenta las siguientes líneas:
        // for (Book book : shelf) {
            // IO.println(book.getCode() + ": " + loanDays(book) + " días");
        // }

        // ============================================
        // PASO 5: llega una clase nueva
        // ============================================
        // Descomenta las siguientes líneas:
        // Book magazine = new Magazine("RV-007", "Revista de Occidente", 4);
        // IO.println(magazine.getCode() + ": " + loanDays(magazine) + " días");

        // ============================================
        // PASO 6: la regla, dentro de cada clase
        // ============================================
        // Descomenta el método loanDays() de Book, RareBook, AudioBook y Magazine.
        // Descomenta las siguientes líneas:
        // Book[] all = { ficciones, chronicle, audio, magazine };
        // for (Book book : all) {
            // IO.println(book.getCode() + ": " + book.loanDays() + " días, sin instanceof");
        // }
    }

    // PASO 4: descomenta este método.
    // static int loanDays(Book book) {
        // if (book instanceof RareBook) {
            // return 0;
        // } else if (book instanceof AudioBook) {
            // return 21;
        // }
        // return 14;
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

    // PASO 6: descomenta este método.
    // int loanDays() {
        // return 14;
    // }
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

    // PASO 6: descomenta este método.
    // @Override
    // int loanDays() {
        // return 0;
    // }
}

class AudioBook extends Book {
    private final int minutes;

    AudioBook(String code, String title, int copies, int minutes) {
        super(code, title, copies);
        this.minutes = minutes;
    }

    // PASO 6: descomenta este método.
    // @Override
    // int loanDays() {
        // return 21;
    // }
}

// Las revistas se prestan 7 días. loanDays(Book) no lo sabe: nadie le añadió la rama.
class Magazine extends Book {
    Magazine(String code, String title, int copies) {
        super(code, title, copies);
    }

    // PASO 6: descomenta este método.
    // @Override
    // int loanDays() {
        // return 7;
    // }
}
