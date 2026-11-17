package gestion;

/** No salió ninguna unidad de la entidad {@code code}, por el motivo {@code reason}. */
public record Rejected(String code, String reason) implements Outcome {

    /**
     * Constructor compacto: un rechazo siempre dice por qué.
     *
     * @throws IllegalArgumentException con el mensaje {@code "Motivo vacío"} si {@code reason}
     *     es {@code null} o está en blanco
     */
    public Rejected {
        throw new UnsupportedOperationException("Por escribir");
    }
}
