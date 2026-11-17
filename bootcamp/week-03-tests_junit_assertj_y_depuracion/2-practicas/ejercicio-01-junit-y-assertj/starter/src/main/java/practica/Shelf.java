package practica;

import java.util.Locale;

/** Operaciones de un estante de biblioteca: el código que pruebas en este ejercicio. */
public class Shelf {

    /** Quita los espacios de los extremos y pasa a mayúsculas: " bk-042 " da "BK-042". */
    public static String normalize(String code) {
        return code.strip().toUpperCase(Locale.ROOT);
    }

    /** Códigos de una línea separada por comas, ya normalizados. */
    public static String[] codes(String line) {
        String[] parts = line.split(",");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = normalize(parts[i]);
        }
        return parts;
    }

    /**
     * Huecos libres en un estante.
     *
     * @throws IllegalArgumentException si used es negativo o mayor que capacity
     */
    public static int free(int capacity, int used) {
        if (used < 0 || used > capacity) {
            // Para el programa con un mensaje claro en lugar de devolver un número absurdo.
            throw new IllegalArgumentException("Ocupación fuera de rango: " + used);
        }
        return capacity - used;
    }

    /** Porcentaje ocupado del estante, entre 0 y 100. */
    public static double occupancy(int capacity, int used) {
        return used * 100.0 / capacity;
    }
}
