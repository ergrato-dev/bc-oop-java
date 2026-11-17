// Ejercicio 01: una subclase hereda lo que tiene su clase padre y añade lo suyo.
// Como en la semana 06, Main va primero y las demás clases después, cada una por su cuenta.

class Main {

    void main() {
        // ============================================
        // PASO 1: la clase padre
        // ============================================
        // Book es la clase de la semana 06, encapsulada.
        // Descomenta las siguientes líneas:
        // Book ficciones = new Book("BK-042", "Ficciones", 2);
        // ficciones.lend();
        // IO.println(ficciones.describe());

        // ============================================
        // PASO 2: una subclase hereda los métodos
        // ============================================
        // RareBook extends Book: no declara lend() ni describe(), pero los tiene.
        // Descomenta las siguientes líneas:
        // RareBook chronicle = new RareBook("BK-001", "Crónica de Núremberg", 1, "Sala de fondo antiguo");
        // IO.println(chronicle.describe());
        // chronicle.lend();
        // IO.println(chronicle.getCode() + " tiene " + chronicle.getCopies() + " ejemplares");

        // ============================================
        // PASO 3: y añade lo suyo
        // ============================================
        // room, getRoom() y label() solo existen en RareBook.
        // Descomenta las siguientes líneas:
        // IO.println(chronicle.getRoom());
        // IO.println(chronicle.label());

        // ============================================
        // PASO 4: la cadena llega hasta Object
        // ============================================
        // getClass() dice de qué clase es un objeto; getSuperclass(), de quién hereda esa clase.
        // Descomenta las siguientes líneas:
        // IO.println(chronicle.getClass().getSimpleName());
        // IO.println(chronicle.getClass().getSuperclass().getSimpleName());
        // IO.println(ficciones.getClass().getSuperclass().getSimpleName());

        // ============================================
        // PASO 5: un RareBook es un Book
        // ============================================
        // Cabe en una variable de tipo Book. La última línea no compila: descoméntala,
        // ejecuta, lee el error y vuelve a comentarla.
        // Descomenta las siguientes líneas:
        // Book asBook = chronicle;
        // IO.println(asBook.describe());
        // IO.println(chronicle instanceof Book);
        // IO.println(asBook.getRoom());

        // ============================================
        // PASO 6: lo private de Book no se toca desde RareBook
        // ============================================
        // Descomenta el método restore() dentro de RareBook, ejecuta, lee el error y vuelve
        // a comentarlo. Aquí no hay nada que descomentar.

        // ============================================
        // PASO 7: el constructor de la subclase llama al de la padre
        // ============================================
        // Descomenta el segundo constructor de RareBook, ejecuta, lee el error y vuelve a
        // comentarlo. Aquí no hay nada que descomentar.
    }
}

class Book {
    private final String code;
    private final String title;
    private int copies;

    Book(String code, String title, int copies) {
        if (copies < 0) {
            throw new IllegalArgumentException("Ejemplares no válidos: " + copies);
        }
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

    int getCopies() {
        return copies;
    }

    void lend() {
        if (copies == 0) {
            throw new IllegalStateException("No quedan ejemplares de " + code);
        }
        copies--;
    }

    String describe() {
        return code + " · " + title + " · ejemplares: " + copies;
    }
}

// Un libro raro es un libro que, además, se guarda en una sala concreta.
class RareBook extends Book {
    private final String room;

    RareBook(String code, String title, int copies, String room) {
        // Primero se construye la parte de Book; después, lo que añade RareBook.
        super(code, title, copies);
        this.room = room;
    }

    // PASO 7: descomenta este constructor, ejecuta y vuelve a comentarlo.
    // RareBook(String code, String title) {
        // this.room = "Depósito";
    // }

    String getRoom() {
        return room;
    }

    String label() {
        return getTitle() + " (" + room + ")";
    }

    // PASO 6: descomenta este método, ejecuta y vuelve a comentarlo.
    // void restore() {
        // copies = 1;
    // }
}
