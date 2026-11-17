// Ejercicio 03: protected abre más de lo que parece, final cierra la herencia, y no todo
// lo que comparte datos debe heredar.

class Main {

    void main() {
        // ============================================
        // PASO 1: protected deja entrar a la subclase... y al resto del paquete
        // ============================================
        // copies es protected en Book. RareBook lo usa en restore(); Main, también.
        // Descomenta las siguientes líneas:
        // RareBook chronicle = new RareBook("BK-001", "Crónica de Núremberg", 0, "Sala de fondo antiguo");
        // chronicle.restore();
        // IO.println(chronicle.describe());
        // chronicle.copies = -7;
        // IO.println(chronicle.describe());

        // ============================================
        // PASO 2: un método final no se sobrescribe
        // ============================================
        // Descomenta el método getCode() dentro de RareBook, ejecuta, lee el error y vuelve
        // a comentarlo. Aquí no hay nada que descomentar.

        // ============================================
        // PASO 3: de una clase final no se hereda
        // ============================================
        // Descomenta la clase FakeIsbn al final del archivo, ejecuta, lee el error y vuelve
        // a comentarla. Aquí no hay nada que descomentar.

        // ============================================
        // PASO 4: una herencia que no tiene sentido
        // ============================================
        // Un préstamo no es un libro, pero Loan extends Book para reutilizar sus datos.
        // Descomenta las siguientes líneas:
        // Loan loan = new Loan("BK-042", "Ficciones", 1, "Ana");
        // loan.restock(5);
        // IO.println(loan.describe() + " · socio: " + loan.getMember());

        // ============================================
        // PASO 5: la misma idea, por composición
        // ============================================
        // BookLoan tiene un libro y un socio, y solo ofrece lo que tiene sentido en un préstamo.
        // Descomenta las siguientes líneas:
        // Book ficciones = new Book("BK-042", "Ficciones", 2);
        // BookLoan ana = new BookLoan(ficciones, "Ana");
        // IO.println(ana.describe());
        // IO.println(ficciones.describe());

        // ============================================
        // PASO 6: una subclase que rompe la promesa de su padre
        // ============================================
        // lend() promete: "presto un ejemplar o me niego". GhostBook no cumple ninguna de las dos.
        // Descomenta las siguientes líneas:
        // Book ghost = new GhostBook("BK-666", "Libro fantasma", 1);
        // ghost.lend();
        // ghost.lend();
        // ghost.lend();
        // IO.println(ghost.describe());
    }
}

class Book {
    private final String code;
    private final String title;
    protected int copies;

    Book(String code, String title, int copies) {
        if (copies < 0) {
            throw new IllegalArgumentException("Ejemplares no válidos: " + copies);
        }
        this.code = code;
        this.title = title;
        this.copies = copies;
    }

    final String getCode() {
        return code;
    }

    String getTitle() {
        return title;
    }

    void lend() {
        if (copies == 0) {
            throw new IllegalStateException("No quedan ejemplares de " + code);
        }
        copies--;
    }

    void restock(int units) {
        if (units <= 0) {
            throw new IllegalArgumentException("Unidades no válidas: " + units);
        }
        copies += units;
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

    // Vuelve a dejar un ejemplar en la sala, aunque se hubiera perdido.
    void restore() {
        copies = 1;
    }

    // PASO 2: descomenta este método, ejecuta y vuelve a comentarlo.
    // @Override
    // String getCode() {
        // return "RARO-" + super.getCode();
    // }
}

// Un código ISBN que nadie debe poder imitar: la clase es final.
final class Isbn {
    private final String value;

    Isbn(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }
}

// Herencia mal usada: un préstamo no es un libro.
class Loan extends Book {
    private final String member;

    Loan(String code, String title, int copies, String member) {
        super(code, title, copies);
        this.member = member;
    }

    String getMember() {
        return member;
    }
}

// Composición: un préstamo tiene un libro y un socio.
class BookLoan {
    private final Book book;
    private final String member;

    BookLoan(Book book, String member) {
        book.lend();
        this.book = book;
        this.member = member;
    }

    String describe() {
        return member + " tiene " + book.getTitle() + " (" + book.getCode() + ")";
    }
}

// Sobrescribe lend() sin cumplir lo que promete Book: ni presta ni se niega.
class GhostBook extends Book {

    GhostBook(String code, String title, int copies) {
        super(code, title, copies);
    }

    @Override
    void lend() {
    }
}

// PASO 3: descomenta este código, ejecuta y vuelve a comentarlo.
// class FakeIsbn extends Isbn {
    // FakeIsbn() {
        // super("000");
    // }
// }
