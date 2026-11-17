package gestion;

/**
 * Salió una unidad de la entidad {@code code} y le quedan {@code left}. Es un {@code record}:
 * Java escribe por ti el constructor, {@code code()}, {@code left()}, {@code equals},
 * {@code hashCode} y {@code toString}, y los dos componentes son {@code private final}.
 */
public record Taken(String code, int left) implements Outcome {

    /**
     * Constructor compacto: valida antes de que Java asigne los componentes.
     *
     * @throws IllegalArgumentException con el mensaje {@code "Unidades no válidas: " + left} si
     *     {@code left} es negativo
     */
    public Taken {
        throw new UnsupportedOperationException("Por escribir");
    }
}
