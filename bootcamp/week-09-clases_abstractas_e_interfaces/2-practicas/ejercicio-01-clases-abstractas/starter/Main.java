// Ejercicio 01: una clase que no se puede crear, pero que da forma a todas sus hijas.

class Main {

    void main() {
        // ============================================
        // PASO 1: las hijas sí se crean
        // ============================================
        // Descomenta las siguientes líneas:
        // LibraryItem[] shelf = {
            // new Book("BK-042", "Ficciones", "Borges"),
            // new Magazine("RV-007", "Revista de Occidente", 512)
        // };
        // for (LibraryItem item : shelf) {
            // IO.println(item.card());
        // }

        // ============================================
        // PASO 2: el padre abstracto no se crea
        // ============================================
        // Descomenta la siguiente línea:
        // LibraryItem something = new LibraryItem("XX-001", "Algo de la biblioteca");

        // ============================================
        // PASO 3: una hija tiene que escribir el método abstracto
        // ============================================
        // Descomenta la clase Dvd, al final del archivo.
        // Descomenta la siguiente línea:
        // IO.println(new Dvd("DV-010", "Metrópolis").card());

        // ============================================
        // PASO 4: el constructor del padre abstracto sí se ejecuta
        // ============================================
        // Descomenta las siguientes líneas:
        // try {
            // new Magazine(" ", "Sin código", 1);
        // } catch (IllegalArgumentException e) {
            // IO.println("Rechazado: " + e.getMessage());
        // }

        // ============================================
        // PASO 5: un método final no se sobrescribe
        // ============================================
        // Descomenta el método card() de Magazine, más abajo.
    }
}

// Algo que la biblioteca presta. No existe "algo" sin más: existe un libro, una revista...
// Por eso es abstract: guarda lo común y obliga a cada hija a escribir lo que solo ella sabe.
abstract class LibraryItem {

    private final String code;
    private final String title;

    // Una clase abstracta tiene constructor: lo llaman sus hijas con super(...).
    LibraryItem(String code, String title) {
        if (code.isBlank()) {
            throw new IllegalArgumentException("Código vacío");
        }
        this.code = code;
        this.title = title;
    }

    String getCode() {
        return code;
    }

    // Sin cuerpo: cada hija decide cuántos días se presta.
    abstract int loanDays();

    // El esqueleto de la ficha, igual para todas; final para que ninguna hija lo cambie.
    final String card() {
        return code + " · " + title + " · " + loanDays() + " días";
    }
}

class Book extends LibraryItem {

    private final String author;

    Book(String code, String title, String author) {
        super(code, title);
        this.author = author;
    }

    @Override
    int loanDays() {
        return 14;
    }
}

class Magazine extends LibraryItem {

    private final int issue;

    Magazine(String code, String title, int issue) {
        super(code, title);
        this.issue = issue;
    }

    @Override
    int loanDays() {
        return 7;
    }

    // PASO 5: descomenta este código.
    // @Override
    // String card() {
        // return "Número " + issue + " · " + super.card();
    // }
}

// PASO 3: descomenta este código.
// class Dvd extends LibraryItem {
    // Dvd(String code, String title) {
        // super(code, title);
    // }
// }
