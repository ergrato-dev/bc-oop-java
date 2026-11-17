package gestion;

/**
 * <strong>No la copies a tu proyecto</strong>: es tu criterio de la semana 09, y solo está aquí
 * para que el starter compile.
 *
 * <p>Acepta las entidades disponibles: le pregunta a cada una con {@code isAvailable()}.
 */
public class AvailableCriterion implements Criterion {

    /**
     * {@code true} si la entidad está disponible. Con reserva, la que respeta la reserva: decide
     * el objeto.
     */
    @Override
    public boolean accepts(Entity item) {
        throw new UnsupportedOperationException("Por escribir");
    }
}
