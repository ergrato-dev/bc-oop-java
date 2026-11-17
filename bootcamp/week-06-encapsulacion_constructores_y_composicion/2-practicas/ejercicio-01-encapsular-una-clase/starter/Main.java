// Ejercicio 01: encapsular es decidir qué puede tocar el resto del programa.
// Main va primero y las demás clases después, cada una por su cuenta: así private protege
// de verdad (dentro de una misma clase, private no oculta nada).

class Main {

    void main() {
        // ============================================
        // PASO 1: un atributo abierto acepta cualquier valor
        // ============================================
        // OpenBook no protege nada: cualquiera escribe en sus atributos.
        // Descomenta las siguientes líneas:
        // OpenBook open = new OpenBook("BK-042", "Ficciones", 2);
        // open.copies = -5;
        // open.code = "";
        // IO.println(open.describe());

        // ============================================
        // PASO 2: private cierra la puerta
        // ============================================
        // Book tiene los mismos datos, pero private. La segunda línea no compila:
        // descoméntala, ejecuta, lee el error y vuelve a comentarla.
        // Descomenta las siguientes líneas:
        // Book ficciones = new Book("BK-042", "Ficciones", 2);
        // ficciones.copies = -5;

        // ============================================
        // PASO 3: getters para leer
        // ============================================
        // Se puede leer el estado, pero no cambiarlo desde fuera.
        // Descomenta las siguientes líneas:
        // IO.println(ficciones.getCode() + " tiene " + ficciones.getCopies() + " ejemplares");
        // IO.println(ficciones.describe());

        // ============================================
        // PASO 4: el estado cambia con métodos que conocen las reglas
        // ============================================
        // lend() presta un ejemplar si queda alguno; si no, se niega y no cambia nada.
        // Descomenta las siguientes líneas:
        // ficciones.lend();
        // ficciones.lend();
        // try {
            // ficciones.lend();
        // } catch (IllegalStateException e) {
            // IO.println("Rechazado: " + e.getMessage());
        // }
        // IO.println(ficciones.describe());

        // ============================================
        // PASO 5: un setter sin reglas no protege nada
        // ============================================
        // SetterBook tiene atributos private... y un setCopies que acepta cualquier número.
        // Descomenta las siguientes líneas:
        // SetterBook disguised = new SetterBook("BK-311", "Rayuela", 1);
        // disguised.setCopies(-5);
        // IO.println(disguised.describe());

        // ============================================
        // PASO 6: devolver y prestar, en el orden de la vida real
        // ============================================
        // giveBack() está dentro de Book: descoméntalo allí y después estas líneas.
        // Descomenta las siguientes líneas:
        // ficciones.giveBack();
        // IO.println(ficciones.describe());
        // try {
            // ficciones.giveBack();
            // ficciones.giveBack();
        // } catch (IllegalStateException e) {
            // IO.println("Rechazado: " + e.getMessage());
        // }
        // IO.println(ficciones.describe());
    }
}

// Sin private: el resto del programa puede escribir lo que quiera en sus atributos.
class OpenBook {
    String code;
    String title;
    int copies;

    OpenBook(String code, String title, int copies) {
        this.code = code;
        this.title = title;
        this.copies = copies;
    }

    String describe() {
        return "[" + code + "] · " + title + " · ejemplares: " + copies;
    }
}

// Con private: solo los métodos de Book cambian sus atributos.
class Book {
    private String code;
    private String title;
    private int copies;
    private int lent;

    Book(String code, String title, int copies) {
        this.code = code;
        this.title = title;
        this.copies = copies;
    }

    String getCode() {
        return code;
    }

    int getCopies() {
        return copies;
    }

    String describe() {
        return code + " · " + title + " · en estantería: " + (copies - lent) + " de " + copies;
    }

    void lend() {
        if (lent == copies) {
            throw new IllegalStateException("No quedan ejemplares de " + code);
        }
        lent++;
    }

    // PASO 6: descomenta este método.
    // void giveBack() {
        // if (lent == 0) {
            // throw new IllegalStateException("No hay préstamos de " + code);
        // }
        // lent--;
    // }
}

// private, pero con un setter que acepta cualquier valor: es un atributo abierto disfrazado.
class SetterBook {
    private String code;
    private String title;
    private int copies;

    SetterBook(String code, String title, int copies) {
        this.code = code;
        this.title = title;
        this.copies = copies;
    }

    void setCopies(int copies) {
        this.copies = copies;
    }

    String describe() {
        return code + " · " + title + " · ejemplares: " + copies;
    }
}
