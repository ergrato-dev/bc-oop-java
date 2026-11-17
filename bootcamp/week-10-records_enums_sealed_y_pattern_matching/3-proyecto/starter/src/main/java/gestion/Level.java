package gestion;

/**
 * El nivel de las unidades de una entidad frente a una capacidad. Es un {@code enum}: un tipo
 * con un número fijo de valores, los cuatro de abajo, y ninguno más. Hace lo mismo que
 * {@code Stock.level}, pero con un tipo en lugar de un texto: {@code "agtoado"} compila,
 * {@code Level.AGTOADO} no.
 */
public enum Level {
    SOLD_OUT("agotado"),
    LOW("bajo"),
    NORMAL("normal"),
    FULL("completo");

    private final String label;

    // El constructor de un enum es privado: solo lo usan las cuatro constantes de arriba.
    Level(String label) {
        this.label = label;
    }

    /** El texto del nivel, el mismo que devuelve {@code Stock.level}: {@code "agotado"}... */
    public String label() {
        throw new UnsupportedOperationException("Por escribir");
    }

    /**
     * {@code true} si hay que reponer: agotado o bajo. Escríbelo con un {@code switch} que cubra
     * las cuatro constantes sin {@code default}.
     */
    public boolean isAlert() {
        throw new UnsupportedOperationException("Por escribir");
    }

    /**
     * El nivel de {@code quantity} frente a {@code capacity}, con las reglas de
     * {@code Stock.level}: agotado si es 0, bajo hasta un cuarto de la capacidad (incluido),
     * normal por debajo de la capacidad y completo si la alcanza o la supera.
     */
    public static Level of(int quantity, int capacity) {
        throw new UnsupportedOperationException("Por escribir");
    }
}
