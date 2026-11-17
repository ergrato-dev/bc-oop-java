// Ejercicio 02: una variable de tipo Book no guarda el libro, guarda una referencia a él.

class Book {
    String code;
    String title;
    int copies;

    Book(String code, String title, int copies) {
        this.code = code;
        this.title = title;
        this.copies = copies;
    }

    String describe() {
        return code + " · " + title + " · ejemplares: " + copies;
    }
}

Book[] shelf = new Book[3];

void emptyShelf(Book book) {
    book.copies = 0;
}

void replace(Book book) {
    book = new Book("BK-999", "Otro", 9);
}

void addOne(int copies) {
    copies++;
}

void main() {
    // ============================================
    // PASO 1: dos variables, un objeto
    // ============================================
    // La asignación copia la referencia, no el objeto.
    // Descomenta las siguientes líneas:
    // Book original = new Book("BK-042", "Ficciones", 2);
    // Book alias = original;
    // alias.copies = 0;
    // IO.println(original.describe());

    // ============================================
    // PASO 2: == compara referencias
    // ============================================
    // Dos objetos con los mismos datos siguen siendo dos objetos.
    // Descomenta las siguientes líneas:
    // Book twin = new Book("BK-042", "Ficciones", 0);
    // IO.println("original == alias: " + (original == alias));
    // IO.println("original == twin: " + (original == twin));

    // ============================================
    // PASO 3: pasar un objeto a un método
    // ============================================
    // El método recibe una copia de la referencia: apunta al mismo libro.
    // Descomenta las siguientes líneas:
    // Book rayuela = new Book("BK-311", "Rayuela", 3);
    // emptyShelf(rayuela);
    // IO.println(rayuela.describe());

    // ============================================
    // PASO 4: lo que un método no puede cambiar
    // ============================================
    // Reasignar el parámetro o cambiar un int solo cambia la copia del método.
    // Descomenta las siguientes líneas:
    // replace(rayuela);
    // IO.println(rayuela.describe());
    // int copies = 5;
    // addOne(copies);
    // IO.println("copies: " + copies);

    // ============================================
    // PASO 5: un array de objetos nace lleno de null
    // ============================================
    // new Book[3] crea tres referencias, no tres libros.
    // Descomenta las siguientes líneas:
    // shelf[0] = rayuela;
    // IO.println(Arrays.toString(shelf));
    // IO.println(shelf[0].describe());
    // IO.println(shelf[1].describe());

    // ============================================
    // PASO 6: comprobar null antes de usar
    // ============================================
    // Recorre el array y salta las posiciones vacías.
    // Descomenta las siguientes líneas:
    // for (Book book : shelf) {
        // if (book != null) {
            // IO.println("En la estantería: " + book.describe());
        // }
    // }
}
