package gestion;

/** Reglas de negocio de tu dominio: retrasos, penalizaciones, cantidades y reservas. */
public class Rules {

    /**
     * Días que se pasa del plazo permitido. 0 si se devolvió o terminó a tiempo.
     *
     * @throws IllegalArgumentException si endDay es anterior a startDay o allowedDays es negativo
     */
    public static int overdueDays(int startDay, int endDay, int allowedDays) {
        if (endDay < startDay || allowedDays < 0) {
            throw new IllegalArgumentException(
                    "Días no válidos: " + startDay + ", " + endDay + ", " + allowedDays);
        }
        return endDay - startDay - allowedDays;
    }

    /**
     * Penalización por retraso: días por tarifa diaria, con un tope, redondeada a 2 decimales.
     *
     * @throws IllegalArgumentException si overdueDays o dailyRate son negativos
     */
    public static double penalty(int overdueDays, double dailyRate, double maxPenalty) {
        if (overdueDays < 0 || dailyRate < 0) {
            throw new IllegalArgumentException("Retraso o tarifa negativos");
        }
        double raw = Math.min(overdueDays * dailyRate, maxPenalty);
        return Math.round(raw * 100) / 100;
    }

    /**
     * Convierte un texto en una cantidad: de 1 a 6 dígitos, sin signo; los espacios de los extremos
     * se ignoran.
     *
     * @throws IllegalArgumentException si el texto es null, está en blanco o no son solo dígitos
     */
    public static int parseQuantity(String text) {
        throw new UnsupportedOperationException("TODO: parseQuantity");
    }

    /**
     * Si se puede abrir una reserva o préstamo nuevo: quedan plazas y no hay penalización pendiente.
     *
     * @throws IllegalArgumentException si maxActive no es positivo
     */
    public static boolean canReserve(int active, int maxActive, double pendingPenalty) {
        throw new UnsupportedOperationException("TODO: canReserve");
    }
}
