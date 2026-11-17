// Ejercicio 02: un contrato que cumplen clases sin ningún parentesco.

class Main {

    void main() {
        // ============================================
        // PASO 1: dos clases sin parentesco, un mismo contrato
        // ============================================
        // Descomenta las siguientes líneas:
        // Loanable[] desk = {
            // new Book("BK-042", "Ficciones", "Borges"),
            // new Laptop("PC-003", "Portátil del aula 2")
        // };
        // for (Loanable item : desk) {
            // IO.println(item.code() + ": " + item.loanDays() + " días");
        // }

        // ============================================
        // PASO 2: la variable decide qué se puede llamar
        // ============================================
        // Descomenta la siguiente línea:
        // IO.println(desk[0].author());

        // ============================================
        // PASO 3: una clase, dos contratos
        // ============================================
        // Descomenta las siguientes líneas:
        // Book rayuela = new Book("BK-311", "Rayuela", "Cortázar");
        // IO.println("cortázar: " + find(rayuela, "cortázar"));
        // IO.println("borges: " + find(rayuela, "borges"));

        // ============================================
        // PASO 4: un contrato que la clase no firmó
        // ============================================
        // Descomenta la siguiente línea:
        // IO.println(find(new Laptop("PC-004", "Portátil del aula 3"), "aula"));

        // ============================================
        // PASO 5: los métodos de una interfaz son public
        // ============================================
        // Descomenta la clase Projector, al final del archivo.
        // Descomenta la siguiente línea:
        // IO.println("PR-001: " + new Projector("PR-001").loanDays() + " días");
    }

    // Recibe cualquier cosa que cumpla Searchable: no le importa su clase.
    static String find(Searchable item, String text) {
        return item.matches(text) ? "encontrado" : "no encontrado";
    }
}

// Lo que se puede prestar: tiene un código y unos días de préstamo.
interface Loanable {
    String code();

    int loanDays();
}

// Lo que se puede buscar por texto.
interface Searchable {
    boolean matches(String text);
}

// Un libro firma los dos contratos.
class Book implements Loanable, Searchable {

    private final String code;
    private final String title;
    private final String author;

    Book(String code, String title, String author) {
        this.code = code;
        this.title = title;
        this.author = author;
    }

    String author() {
        return author;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public int loanDays() {
        return 14;
    }

    @Override
    public boolean matches(String text) {
        String wanted = text.toLowerCase();
        return title.toLowerCase().contains(wanted) || author.toLowerCase().contains(wanted);
    }
}

// Un portátil no es un libro ni hereda de nada en común con él, pero también se presta.
class Laptop implements Loanable {

    private final String code;
    private final String label;

    Laptop(String code, String label) {
        this.code = code;
        this.label = label;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public int loanDays() {
        return 2;
    }
}

// PASO 5: descomenta este código.
// class Projector implements Loanable {
    // private final String code;
    // Projector(String code) {
        // this.code = code;
    // }
    // @Override
    // public String code() {
        // return code;
    // }
    // @Override
    // int loanDays() {
        // return 3;
    // }
// }
