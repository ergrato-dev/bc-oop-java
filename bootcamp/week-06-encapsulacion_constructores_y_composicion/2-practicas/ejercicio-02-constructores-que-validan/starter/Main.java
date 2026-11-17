// Ejercicio 02: un constructor que valida hace imposible un objeto en mal estado.

import java.util.Locale;

class Main {

    void main() {
        // ============================================
        // PASO 1: el constructor prepara los datos
        // ============================================
        // Código en mayúsculas y título sin espacios en los extremos.
        // Descomenta las siguientes líneas:
        // Book ficciones = new Book(" bk-042 ", "  Ficciones ", 2);
        // IO.println(ficciones.describe());

        // ============================================
        // PASO 2: el constructor rechaza lo que no vale
        // ============================================
        // Si un dato no vale, lanza una excepción y el objeto no llega a existir.
        // Descomenta las siguientes líneas:
        // try {
            // Book broken = new Book("BK-042", "   ", 2);
            // IO.println("Creado: " + broken.describe());
        // } catch (IllegalArgumentException e) {
            // IO.println("Rechazado: " + e.getMessage());
        // }
        // tryToCreate("BK042", "Ficciones", 2);
        // tryToCreate("BK-500", "Pedro Páramo", -1);
        // tryToCreate("BK-500", "Pedro Páramo", 1);

        // ============================================
        // PASO 3: validar antes de asignar
        // ============================================
        // HalfBook asigna y luego comprueba: mira qué queda si falla.
        // Descomenta las siguientes líneas:
        // HalfBook half = new HalfBook("BK-311", "Rayuela", 3);
        // try {
            // half.change("BK-312", "Rayuela, 2.ª ed.", -4);
        // } catch (IllegalArgumentException e) {
            // IO.println("Rechazado: " + e.getMessage());
        // }
        // IO.println(half.describe());

        // ============================================
        // PASO 4: dos constructores, una sola validación
        // ============================================
        // Book(code, title) llama a Book(code, title, 0) con this(...).
        // Primero descomenta el constructor de dos parámetros dentro de Book.
        // Descomenta las siguientes líneas:
        // Book aleph = new Book("bk-777", "El Aleph");
        // IO.println(aleph.describe());
        // try {
            // new Book("bk 777", "El Aleph");
        // } catch (IllegalArgumentException e) {
            // IO.println("Rechazado: " + e.getMessage());
        // }

        // ============================================
        // PASO 5: final, un atributo que no cambia
        // ============================================
        // code es final. Descomenta el método rename() dentro de Book, ejecuta,
        // lee el error y vuelve a comentarlo. Aquí no hay nada que descomentar.

        // ============================================
        // PASO 6: final en una variable de referencia
        // ============================================
        // La flecha no se puede mover, pero el objeto sí puede cambiar por dentro.
        // Descomenta las siguientes líneas:
        // final Book fixed = new Book("BK-107", "El túnel", 1);
        // fixed.restock(2);
        // IO.println(fixed.describe());
        // fixed = new Book("BK-108", "Otro", 1);
    }

    void tryToCreate(String code, String title, int copies) {
        try {
            IO.println("Creado: " + new Book(code, title, copies).describe());
        } catch (IllegalArgumentException e) {
            IO.println("Rechazado: " + e.getMessage());
        }
    }
}

class Book {
    private final String code;
    private final String title;
    private int copies;

    Book(String code, String title, int copies) {
        // Se valida todo antes de asignar nada.
        String normalized = code.strip().toUpperCase(Locale.ROOT);
        // Letras, un guion y dígitos: la regla de Stock.isValidCode, escrita en una línea.
        if (!normalized.matches("[A-Z]+-[0-9]+")) {
            throw new IllegalArgumentException("Código no válido: " + normalized);
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Título vacío");
        }
        if (copies < 0) {
            throw new IllegalArgumentException("Ejemplares no válidos: " + copies);
        }
        this.code = normalized;
        this.title = title.strip();
        this.copies = copies;
    }

    // PASO 4: descomenta este constructor.
    // Book(String code, String title) {
        // this(code, title, 0);
    // }

    // PASO 5: descomenta este método, ejecuta y vuelve a comentarlo.
    // void rename(String newCode) {
        // this.code = newCode;
    // }

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

// Lo que no hay que hacer: cambia los atributos uno a uno y comprueba al final.
class HalfBook {
    private String code;
    private String title;
    private int copies;

    HalfBook(String code, String title, int copies) {
        this.code = code;
        this.title = title;
        this.copies = copies;
    }

    void change(String code, String title, int copies) {
        this.code = code;
        this.title = title;
        if (copies < 0) {
            throw new IllegalArgumentException("Ejemplares no válidos: " + copies);
        }
        this.copies = copies;
    }

    String describe() {
        return code + " · " + title + " · ejemplares: " + copies;
    }
}
