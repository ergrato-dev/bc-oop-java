package gestion;

/**
 * <strong>No la copies a tu proyecto</strong>: es tu interfaz de la semana 09, y solo está aquí
 * para que el starter compile.
 *
 * <p>Un criterio para elegir entidades: dice si una entidad le vale o no. Es un contrato, no una
 * clase: no guarda datos ni sabe cómo decide cada criterio. Cada clase que lo implementa escribe
 * su {@code accepts}, y tu {@code Inventory} trabaja con cualquiera de ellas sin conocerlas.
 */
public interface Criterion {

    /** {@code true} si la entidad cumple el criterio. */
    boolean accepts(Entity item);

    /**
     * Cuántas entidades del array cumplen el criterio. Es un método {@code default}: tiene cuerpo
     * y lo heredan todas las clases que implementan el criterio, que solo escriben
     * {@code accepts}.
     */
    default int count(Entity[] items) {
        throw new UnsupportedOperationException("Por escribir");
    }
}
