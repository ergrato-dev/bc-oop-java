package gestion;

/** Punto de entrada: ./mvnw -q compile exec:java */
public class App {

    public static void main(String[] args) {
        // Cambia estos tres registros por tres de tu dominio. Uno con coma decimal.
        String code = Fields.normalizeCode(" bk-042 ");
        double price = Fields.parseAmount("12,5");
        System.out.println(code + " · " + Fields.describe("Precio", price, "USD"));

        System.out.println("BK-107 · " + Fields.describe("Precio", Fields.parseAmount("8.99"), "USD"));
        System.out.println("BK-311 · " + Fields.describe("Precio", Fields.parseAmount(" 30 "), "USD"));

        System.out.println("¿Precio válido? " + Fields.isInRange(price, 0.0, 500.0));
    }
}
