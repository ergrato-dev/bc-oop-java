package gestion;

/**
 * <strong>No la copies a tu proyecto</strong>: es tu criterio de la semana 09, y solo está aquí
 * para que el starter compile.
 *
 * <p>Acepta las entidades cuyo nombre contiene un texto, sin distinguir mayúsculas.
 */
public class NameCriterion implements Criterion {

    private final String query;

    /**
     * Crea el criterio con el texto que se busca.
     *
     * @throws IllegalArgumentException con el mensaje {@code "Búsqueda vacía"} si el texto es
     *     {@code null} o está en blanco
     */
    public NameCriterion(String query) {
        throw new UnsupportedOperationException("Por escribir");
    }

    /**
     * {@code true} si el nombre de la entidad contiene el texto: lo decide el {@code matches} de
     * tu clase.
     */
    @Override
    public boolean accepts(Entity item) {
        throw new UnsupportedOperationException("Por escribir");
    }
}
