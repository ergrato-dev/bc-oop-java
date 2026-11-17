package gestion;

/**
 * Una entidad que guarda una reserva: las últimas {@code reserve} unidades no se sacan nunca.
 * En una biblioteca, el ejemplar de consulta que no sale de la sala; en una farmacia, el stock
 * mínimo de un medicamento crítico.
 *
 * <p>Es una subclase: hereda el código, el nombre, las unidades y todos los métodos de tu clase,
 * y solo sobrescribe lo que cambia con la reserva.
 */
public class ReservedEntity extends Entity {

    private final int reserve;

    /**
     * Crea la entidad con su reserva. El código, el nombre y las unidades los valida el
     * constructor de tu clase.
     *
     * @throws IllegalArgumentException con el mensaje {@code "Reserva no válida: " + reserve} si
     *     {@code reserve} es negativo, o la excepción del constructor de tu clase
     */
    public ReservedEntity(String code, String name, int quantity, int reserve) {
        // Paso 5: comprueba reserve antes de super(...).
        super(code, name, quantity);
        throw new UnsupportedOperationException("Por escribir");
    }

    public int getReserve() {
        throw new UnsupportedOperationException("Por escribir");
    }

    /** {@code true} si quedan unidades por encima de la reserva. */
    @Override
    public boolean isAvailable() {
        throw new UnsupportedOperationException("Por escribir");
    }

    /**
     * Saca una unidad si queda alguna por encima de la reserva.
     *
     * @throws IllegalStateException con el mensaje {@code "Solo queda la reserva de " + code} si
     *     las unidades que quedan son la reserva; sin unidades, la misma excepción que el
     *     {@code take()} de tu clase. En los dos casos la cantidad no cambia
     */
    @Override
    public void take() {
        throw new UnsupportedOperationException("Por escribir");
    }

    /** La línea del {@code describe()} de tu clase con la reserva: {@code "... · reserva: 1"}. */
    @Override
    public String describe() {
        throw new UnsupportedOperationException("Por escribir");
    }
}
