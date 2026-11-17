// Ejercicio 03: un objeto compuesto de otros, y cómo evitar que su array se escape.

import java.util.Arrays;
import java.util.Locale;

class Main {

    void main() {
        // ============================================
        // PASO 1: una estantería tiene libros
        // ============================================
        // Shelf guarda sus libros en un array private y cuenta cuántos lleva.
        // Descomenta las siguientes líneas:
        // Shelf shelf = new Shelf(3);
        // shelf.add(new Book("BK-042", "Ficciones", 2));
        // shelf.add(new Book("BK-311", "Rayuela", 1));
        // IO.println(shelf.size() + " libros, " + shelf.total() + " ejemplares");

        // ============================================
        // PASO 2: la estantería delega en sus libros
        // ============================================
        // Shelf no sabe prestar: busca el libro y le pide que preste él.
        // Descomenta las siguientes líneas:
        // shelf.lend("bk-311");
        // IO.println(shelf.size() + " libros, " + shelf.total() + " ejemplares");
        // try {
            // shelf.lend("BK-311");
        // } catch (IllegalStateException e) {
            // IO.println("Rechazado: " + e.getMessage());
        // }

        // ============================================
        // PASO 3: el dueño pone las reglas de la colección
        // ============================================
        // Código repetido y estantería llena: reglas de Shelf, no de Book.
        // Descomenta las siguientes líneas:
        // tryToAdd(shelf, new Book("bk-042", "Otra edición", 1));
        // tryToAdd(shelf, new Book("BK-107", "El túnel", 4));
        // tryToAdd(shelf, new Book("BK-500", "Pedro Páramo", 1));

        // ============================================
        // PASO 4: un array que se escapa
        // ============================================
        // leakyBooks() devuelve el array de verdad. Quien lo recibe puede romper la estantería.
        // Descomenta las siguientes líneas:
        // Book[] leaked = shelf.leakyBooks();
        // leaked[0] = null;
        // IO.println(shelf.total());

        // ============================================
        // PASO 5: una copia defensiva
        // ============================================
        // books() devuelve una copia: cambiarla no toca la estantería.
        // Comenta antes las tres líneas del PASO 4.
        // Descomenta las siguientes líneas:
        // Book[] copy = shelf.books();
        // copy[0] = null;
        // IO.println(Arrays.toString(shelf.codes()) + " · " + shelf.total() + " ejemplares");

        // ============================================
        // PASO 6: la copia es del array, no de los libros
        // ============================================
        // Las posiciones de la copia apuntan a los mismos libros.
        // Descomenta las siguientes líneas:
        // Book[] again = shelf.books();
        // again[2].lend();
        // IO.println(shelf.total() + " ejemplares");
    }

    void tryToAdd(Shelf shelf, Book book) {
        try {
            shelf.add(book);
            IO.println("Añadido: " + book.describe());
        } catch (IllegalArgumentException | IllegalStateException e) {
            IO.println("Rechazado: " + e.getMessage());
        }
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
        this.code = code.strip().toUpperCase(Locale.ROOT);
        this.title = title.strip();
        this.copies = copies;
    }

    String getCode() {
        return code;
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

// Composición: Shelf tiene libros, y es la única que toca su array.
class Shelf {
    private final Book[] books;
    private int size;

    Shelf(int capacity) {
        this.books = new Book[capacity];
    }

    void add(Book book) {
        if (indexOf(book.getCode()) >= 0) {
            throw new IllegalArgumentException("Código repetido: " + book.getCode());
        }
        if (size == books.length) {
            throw new IllegalStateException("Estantería llena: " + books.length);
        }
        books[size] = book;
        size++;
    }

    // Delegación: Shelf encuentra el libro y le pasa la orden.
    void lend(String code) {
        int i = indexOf(code);
        if (i < 0) {
            throw new IllegalArgumentException("No existe: " + code);
        }
        books[i].lend();
    }

    int size() {
        return size;
    }

    int total() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += books[i].getCopies();
        }
        return sum;
    }

    String[] codes() {
        String[] codes = new String[size];
        for (int i = 0; i < size; i++) {
            codes[i] = books[i].getCode();
        }
        return codes;
    }

    // Mal: entrega el array de verdad.
    Book[] leakyBooks() {
        return books;
    }

    // Bien: entrega una copia con las posiciones ocupadas.
    Book[] books() {
        return Arrays.copyOf(books, size);
    }

    private int indexOf(String code) {
        String wanted = code.strip().toUpperCase(Locale.ROOT);
        for (int i = 0; i < size; i++) {
            if (books[i].getCode().equals(wanted)) {
                return i;
            }
        }
        return -1;
    }
}
