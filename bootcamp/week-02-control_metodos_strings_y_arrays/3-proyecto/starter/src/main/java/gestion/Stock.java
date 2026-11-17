package gestion;

import java.util.Arrays;
import java.util.Locale;

/**
 * Reglas sobre el inventario de tu dominio: varios códigos con sus cantidades.
 *
 * <p>Los datos viajan en dos arrays paralelos: {@code codes[i]} tiene {@code quantities[i]}
 * unidades. En la semana 05 cada par será un objeto; en la 13, una colección.
 */
public class Stock {

    /**
     * Separa una línea de códigos por comas y normaliza cada uno.
     * {@code "bk-042, ,BK-107"} da {@code ["BK-042", "BK-107"]}: los vacíos se descartan.
     */
    public static String[] parseCodes(String line) {
        throw new UnsupportedOperationException("TODO: parseCodes");
    }

    /**
     * Un código válido tiene una o más letras mayúsculas, un guion y uno o más dígitos,
     * y nada más: {@code "BK-042"} y {@code "HAB-1"} sí; {@code "bk-042"} y {@code "BK042"} no.
     */
    public static boolean isValidCode(String code) {
        throw new UnsupportedOperationException("TODO: isValidCode");
    }

    /** Suma todas las cantidades. Un array vacío suma {@code 0}. */
    public static int total(int[] quantities) {
        throw new UnsupportedOperationException("TODO: total");
    }

    /**
     * Posición del código en el array, o {@code -1} si no está.
     * El código buscado se normaliza antes: {@code " bk-107 "} encuentra {@code "BK-107"}.
     */
    public static int indexOf(String[] codes, String code) {
        throw new UnsupportedOperationException("TODO: indexOf");
    }

    /**
     * Nivel de una cantidad frente a la capacidad: {@code "agotado"} si es 0,
     * {@code "bajo"} hasta un cuarto de la capacidad (incluido), {@code "normal"} por debajo
     * de la capacidad y {@code "completo"} si la alcanza o la supera.
     */
    public static String level(int quantity, int capacity) {
        throw new UnsupportedOperationException("TODO: level");
    }

    /**
     * Una línea por código, terminada en {@code \n}, con el formato
     * {@code "BK-042: 3/10 (normal)"}. Sin códigos, {@code ""}.
     */
    public static String report(String[] codes, int[] quantities, int capacity) {
        throw new UnsupportedOperationException("TODO: report");
    }

    /**
     * Cuántas unidades faltan en cada posición para llegar a la capacidad (nunca negativo).
     * Devuelve un array nuevo: {@code quantities} no cambia.
     */
    public static int[] missing(int[] quantities, int capacity) {
        throw new UnsupportedOperationException("TODO: missing");
    }
}
