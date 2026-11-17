// Ejercicio 03: métodos con cuerpo dentro de una interfaz, default y static.

class Main {

    void main() {
        Book[] shelf = {
            new Book("BK-042", "Ficciones", 2),
            new Book("BK-107", "Rayuela", 0),
            new Book("BK-311", "Rayuela ilustrada", 1)
        };

        // ============================================
        // PASO 1: un método default, escrito una vez y heredado por todos
        // ============================================
        // Descomenta las siguientes líneas:
        // Criterion available = new AvailableCriterion();
        // Criterion rayuela = new NameCriterion("rayuela");
        // IO.println("Disponibles: " + available.count(shelf));
        // IO.println("Con rayuela: " + rayuela.count(shelf));

        // ============================================
        // PASO 2: una clase puede sobrescribir el default
        // ============================================
        // Descomenta el método label() de NameCriterion, más abajo.
        // Descomenta las siguientes líneas:
        // IO.println(available.label());
        // IO.println(rayuela.label());

        // ============================================
        // PASO 3: un método static de la interfaz se llama con su nombre
        // ============================================
        // Descomenta la siguiente línea:
        // IO.println("¿Alguno disponible? " + Criterion.any(available, shelf));

        // ============================================
        // PASO 4: y no a través de una variable
        // ============================================
        // Descomenta la siguiente línea:
        // IO.println(available.any(available, shelf));

        // ============================================
        // PASO 5: dos default con el mismo nombre
        // ============================================
        // Descomenta la clase Duplicate, al final del archivo.
        // Descomenta la siguiente línea:
        // IO.println("BK-900: " + new Duplicate().label());
    }
}

class Book {

    private final String code;
    private final String name;
    private final int quantity;

    Book(String code, String name, int quantity) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }

    String getName() {
        return name;
    }

    boolean isAvailable() {
        return quantity > 0;
    }
}

interface Criterion {

    // Sin cuerpo: cada criterio decide.
    boolean accepts(Book book);

    // default: tiene cuerpo y lo heredan todos los criterios.
    default int count(Book[] books) {
        int count = 0;
        for (Book book : books) {
            if (accepts(book)) {
                count++;
            }
        }
        return count;
    }

    // default: un texto por defecto que cada criterio puede cambiar.
    default String label() {
        return "un criterio";
    }

    // static: de la interfaz, no de cada criterio. Una utilidad que recibe el criterio.
    static boolean any(Criterion criterion, Book[] books) {
        return criterion.count(books) > 0;
    }
}

class AvailableCriterion implements Criterion {

    @Override
    public boolean accepts(Book book) {
        return book.isAvailable();
    }
}

class NameCriterion implements Criterion {

    private final String query;

    NameCriterion(String query) {
        this.query = query;
    }

    @Override
    public boolean accepts(Book book) {
        return book.getName().toLowerCase().contains(query);
    }

    // PASO 2: descomenta este código.
    // @Override
    // public String label() {
        // return "nombre con \"" + query + "\"";
    // }
}

interface Loanable {
    default String label() {
        return "se presta";
    }
}

interface Sellable {
    default String label() {
        return "se vende";
    }
}

// PASO 5: descomenta este código.
// class Duplicate implements Loanable, Sellable {
// }
