// Ejercicio 02: sobrescribir es dar a un método heredado otro cuerpo en la subclase.

class Main {

    void main() {
        // ============================================
        // PASO 1: sin sobrescribir, RareBook usa el describe() de Book
        // ============================================
        // Descomenta las siguientes líneas:
        // Book ficciones = new Book("BK-042", "Ficciones", 2);
        // RareBook chronicle = new RareBook("BK-001", "Crónica de Núremberg", 1, "Sala de fondo antiguo");
        // IO.println(ficciones.describe());
        // IO.println(chronicle.describe());

        // ============================================
        // PASO 2: RareBook sobrescribe describe()
        // ============================================
        // Descomenta el método describe() dentro de RareBook y ejecuta otra vez.
        // Aquí no hay nada que descomentar.

        // ============================================
        // PASO 3: @Override te avisa de las erratas
        // ============================================
        // Descomenta el método descrbe() dentro de RareBook, ejecuta, lee el error y vuelve
        // a comentarlo. Aquí no hay nada que descomentar.

        // ============================================
        // PASO 4: el método que se ejecuta lo decide el objeto
        // ============================================
        // Descomenta el método lend() dentro de RareBook. Los dos libros están en un array
        // de Book, y el bucle llama a lend() igual para los dos.
        // Descomenta las siguientes líneas:
        // Book[] shelf = { ficciones, chronicle };
        // for (Book book : shelf) {
            // try {
                // book.lend();
                // IO.println("Prestado: " + book.getCode());
            // } catch (IllegalStateException e) {
                // IO.println("Rechazado: " + e.getMessage());
            // }
        // }

        // ============================================
        // PASO 5: toString(), el método de Object que todos tienen
        // ============================================
        // Ejecuta primero así. Después descomenta toString() dentro de Book y ejecuta otra vez.
        // Descomenta las siguientes líneas:
        // IO.println(ficciones);
        // IO.println("En la sala: " + chronicle);
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

    // PASO 5: descomenta este método.
    // @Override
    // public String toString() {
        // return describe();
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

    // PASO 2: descomenta este método.
    // @Override
    // String describe() {
        // return super.describe() + " · " + room;
    // }

    // PASO 3: descomenta este método, ejecuta y vuelve a comentarlo.
    // @Override
    // String descrbe() {
        // return "con una errata";
    // }

    // PASO 4: descomenta este método.
    // @Override
    // void lend() {
        // throw new IllegalStateException(getCode() + " no sale de la " + room);
    // }
}
