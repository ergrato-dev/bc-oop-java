// Ejercicio 03: los tres arrays paralelos de la semana 04, ahora como un array de libros.
// Cada posición guarda un solo objeto, con su código, su título y su autor dentro.

class Book {
    static int created = 0;

    String code;
    String title;
    String author;

    Book(String code, String title, String author) {
        this.code = code;
        this.title = title;
        this.author = author;
        created++;
    }

    String describe() {
        return code + " · " + title + " · " + author;
    }

    // PASO 5: un método de instancia responde sobre un libro; uno static, sobre varios.
    // Descomenta las siguientes líneas:
    // boolean matches(String query) {
        // return title.toLowerCase(Locale.ROOT).contains(query.strip().toLowerCase(Locale.ROOT));
    // }
//
    // static int indexOf(Book[] books, String code) {
        // for (int i = 0; i < books.length; i++) {
            // if (books[i].code.equals(code)) {
                // return i;
            // }
        // }
        // return -1;
    // }
}

Book[] books = {
    new Book("BK-311", "Rayuela", "Cortázar"),
    new Book("BK-042", "Ficciones", "Borges"),
    new Book("BK-107", "El túnel", "Sábato")
};

void printAll() {
    for (Book book : books) {
        IO.println(book.describe());
    }
    IO.println("--");
}

// Ordena por título: busca el menor de lo que queda y lo pone en la posición i.
void sortByTitle() {
    for (int i = 0; i < books.length - 1; i++) {
        int min = i;
        for (int j = i + 1; j < books.length; j++) {
            if (books[j].title.compareTo(books[min].title) < 0) {
                min = j;
            }
        }
        Book swap = books[i];
        books[i] = books[min];
        books[min] = swap;
    }
}

void main() {
    // ============================================
    // PASO 1: el catálogo
    // ============================================
    // Los mismos datos que en la semana 04, en un solo array.
    // Descomenta las siguientes líneas:
    // printAll();

    // ============================================
    // PASO 2: dar de alta un libro
    // ============================================
    // El array crece una vez, y el libro llega entero.
    // Descomenta las siguientes líneas:
    // books = Arrays.copyOf(books, 4);
    // books[3] = new Book("BK-500", "Pedro Páramo");
    // printAll();

    // ============================================
    // PASO 3: ordenar por título
    // ============================================
    // Cada intercambio mueve una referencia: el libro entero.
    // Descomenta las siguientes líneas:
    // sortByTitle();
    // printAll();

    // ============================================
    // PASO 4: un atributo static
    // ============================================
    // created no es de ningún libro: es de la clase Book.
    // Descomenta las siguientes líneas:
    // IO.println("Libros creados: " + Book.created);

    // ============================================
    // PASO 5: buscar
    // ============================================
    // indexOf se llama con el nombre de la clase; matches, sobre cada libro.
    // Descomenta las siguientes líneas:
    // IO.println("BK-107 está en la posición " + Book.indexOf(books, "BK-107"));
    // for (Book book : books) {
        // if (book.matches(" EL ")) {
            // IO.println("Contiene \"el\": " + book.title);
        // }
    // }
}
