package gestion;

/**
 * El resultado de intentar sacar una unidad: o salió ({@link Taken}) o no salió
 * ({@link Rejected}). Tiene que ser una interfaz sellada: solo esas dos clases pueden
 * implementarla, y el compilador lo sabe. Por eso un {@code switch} sobre un {@code Outcome}
 * puede cubrir todos los casos sin {@code default}.
 */
public interface Outcome {

    /**
     * Una línea para mostrar el resultado: {@code "BK-042: sale una, quedan 1"} o
     * {@code "Rechazado: No quedan unidades de BK-042"}.
     */
    static String message(Outcome outcome) {
        throw new UnsupportedOperationException("Por escribir");
    }
}
