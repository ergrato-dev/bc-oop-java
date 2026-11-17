// Ejercicio 02: qué método se ejecuta lo decide el objeto, salvo cuando lo decide el compilador.

class Main {

    void main() {
        // ============================================
        // PASO 1: Book llama a un método que sus hijas sobrescriben
        // ============================================
        // Descomenta las siguientes líneas:
        // Book ficciones = new Book("BK-042", "Ficciones", 2);
        // Book chronicle = new RareBook("BK-001", "Crónica de Núremberg", 1, "Sala de fondo antiguo");
        // Book[] shelf = { ficciones, chronicle };
        // for (Book book : shelf) {
            // IO.println(book.card());
        // }

        // ============================================
        // PASO 2: la sobrecarga la elige el compilador
        // ============================================
        // Descomenta los dos métodos kind() de Main, más abajo.
        // Descomenta las siguientes líneas:
        // IO.println("kind(chronicle): " + kind(chronicle));
        // IO.println("chronicle.kind(): " + chronicle.kind());

        // ============================================
        // PASO 3: los métodos static no se sobrescriben
        // ============================================
        // Descomenta el método origin() de Book y el de RareBook.
        // Descomenta las siguientes líneas:
        // IO.println("chronicle.origin(): " + chronicle.origin());
        // IO.println("RareBook.origin(): " + RareBook.origin());

        // ============================================
        // PASO 4: una clase nueva, sin tocar Book ni el bucle
        // ============================================
        // Descomenta la clase Magazine, al final del archivo.
        // Descomenta las siguientes líneas:
        // Book[] rack = { ficciones, chronicle, new Magazine("RV-007", "Revista de Occidente", 4, 512) };
        // for (Book book : rack) {
            // IO.println(book.card());
        // }
    }

    // PASO 2: descomenta este código.
    // static String kind(Book book) {
        // return "un libro";
    // }
    // static String kind(RareBook book) {
        // return "un libro raro";
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

    String describe() {
        return code + " · " + title + " · ejemplares: " + copies;
    }

    // card() está solo en Book, y llama a describe(): ¿el de quién?
    String card() {
        return "[ " + describe() + " ]";
    }

    String kind() {
        return "un libro";
    }

    // PASO 3: descomenta este método.
    // static String origin() {
        // return "la clase Book";
    // }
}

class RareBook extends Book {
    private final String room;

    RareBook(String code, String title, int copies, String room) {
        super(code, title, copies);
        this.room = room;
    }

    @Override
    String describe() {
        return super.describe() + " · " + room;
    }

    @Override
    String kind() {
        return "un libro raro";
    }

    // PASO 3: descomenta este método.
    // static String origin() {
        // return "la clase RareBook";
    // }
}

// PASO 4: descomenta este código.
// class Magazine extends Book {
    // private final int issue;
    // Magazine(String code, String title, int copies, int issue) {
        // super(code, title, copies);
        // this.issue = issue;
    // }
    // @Override
    // String describe() {
        // return super.describe() + " · número " + issue;
    // }
// }
