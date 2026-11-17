package gestion;

import java.util.Locale;

/**
 * Reglas para leer, validar y mostrar los campos de una entidad de tu dominio.
 *
 * <p>Todavía no hay objetos: son métodos {@code static}, que se llaman con el nombre de la
 * clase ({@code Fields.parseAmount("12,5")}). En la semana 05 pasan a ser parte de tu clase.
 */
public class Fields {

    /**
     * Convierte el texto de una cantidad en un {@code double}.
     *
     * <p>Quita los espacios de los lados y acepta coma o punto decimal:
     * {@code "  12,5 "} da {@code 12.5}.
     */
    public static double parseAmount(String text) {
        throw new UnsupportedOperationException("TODO: parseAmount");
    }

    /**
     * Normaliza un código: sin espacios a los lados y en mayúsculas.
     * {@code " bk-042 "} da {@code "BK-042"}.
     */
    public static String normalizeCode(String code) {
        throw new UnsupportedOperationException("TODO: normalizeCode");
    }

    /**
     * Describe un campo con dos decimales y su unidad.
     * {@code describe("Precio", 12.5, "USD")} da {@code "Precio: 12.50 USD"}.
     *
     * <p>Usa {@link Locale#ROOT} al formatear para que el separador sea siempre un punto,
     * esté el sistema en español o en inglés.
     */
    public static String describe(String label, double amount, String unit) {
        throw new UnsupportedOperationException("TODO: describe");
    }

    /** {@code true} si {@code value} está entre {@code min} y {@code max}, ambos incluidos. */
    public static boolean isInRange(double value, double min, double max) {
        throw new UnsupportedOperationException("TODO: isInRange");
    }

    /** {@code true} si {@code quantity} no es negativa y cabe en {@code capacity}. */
    public static boolean fits(int quantity, int capacity) {
        throw new UnsupportedOperationException("TODO: fits");
    }
}
