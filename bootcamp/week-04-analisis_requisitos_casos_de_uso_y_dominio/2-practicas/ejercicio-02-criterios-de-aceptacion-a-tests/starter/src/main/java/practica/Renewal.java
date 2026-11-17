package practica;

/**
 * Reglas de la historia "Renovar un préstamo".
 *
 * <p>Como socio, quiero renovar un préstamo para quedarme el libro 7 días más.
 * Los criterios de aceptación están en el README del ejercicio.
 */
public class Renewal {

    /**
     * {@code true} si el préstamo se puede renovar: lleva menos de 2 renovaciones,
     * ningún otro socio ha reservado el libro y no va con retraso.
     */
    public static boolean canRenew(int renewals, int reservations, int overdueDays) {
        return renewals < 2 && overdueDays == 0;
    }

    /** Nuevo día de devolución tras renovar: 7 días después del actual. */
    public static int newDueDay(int dueDay) {
        return dueDay + 7;
    }
}
