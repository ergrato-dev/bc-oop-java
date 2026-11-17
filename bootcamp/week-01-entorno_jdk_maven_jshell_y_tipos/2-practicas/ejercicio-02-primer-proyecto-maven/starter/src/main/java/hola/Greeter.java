package hola;

/** Saludos. Un método static se llama con el nombre de la clase: Greeter.greet("Ana"). */
public class Greeter {

    public static String greet(String name) {
        String clean = name.strip();
        if (clean.isEmpty()) {
            return "Hola, mundo";
        }
        return "Hola, " + clean;
    }
}
