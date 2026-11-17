package practica;

/** Reglas de multas de una biblioteca: el código que pruebas en este ejercicio. */
public class Fine {

    /**
     * Categoría de un retraso: 0 días "sin multa", de 1 a 7 "leve", de 8 a 30 "grave" y más de 30
     * "bloqueo".
     *
     * @throws IllegalArgumentException si lateDays es negativo
     */
    public static String category(int lateDays) {
        if (lateDays < 0) {
            throw new IllegalArgumentException("Días negativos: " + lateDays);
        }
        if (lateDays == 0) {
            return "sin multa";
        }
        if (lateDays < 7) {
            return "leve";
        }
        if (lateDays <= 30) {
            return "grave";
        }
        return "bloqueo";
    }

    /** true si el código es "BK-" seguido de exactamente 3 dígitos, como "BK-042". */
    public static boolean isValidCode(String code) {
        if (code == null || code.length() != 6 || !code.startsWith("BK-")) {
            return false;
        }
        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
