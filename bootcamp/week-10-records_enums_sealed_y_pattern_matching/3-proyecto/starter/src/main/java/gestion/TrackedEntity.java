package gestion;

/**
 * <strong>No la copies a tu proyecto</strong>: es tu subclase de la semana 08, y solo está aquí
 * para que el starter compile.
 *
 * <p>Una entidad que cuenta sus salidas: cada {@code take()} que funciona suma una. En una
 * biblioteca, cuántas veces se prestó un libro; en un servicio de bicicletas, cuántas veces se
 * alquiló una.
 *
 * <p>Es hermana de {@link ReservedEntity}: las dos heredan de tu clase y cada una sobrescribe
 * {@code take()} a su manera. Quien tenga una variable de tu clase no sabe cuál le llega, y no
 * le hace falta.
 */
public class TrackedEntity extends Entity {

    private int taken;

    /** Crea la entidad sin salidas. El código, el nombre y las unidades los valida tu clase. */
    public TrackedEntity(String code, String name, int quantity) {
        super(code, name, quantity);
    }

    /** Cuántas veces funcionó {@code take()}. */
    public int getTaken() {
        throw new UnsupportedOperationException("Por escribir");
    }

    /**
     * Saca una unidad, como tu clase, y cuenta la salida.
     *
     * @throws IllegalStateException la misma excepción que el {@code take()} de tu clase si no
     *     quedan unidades; en ese caso no cuenta la salida
     */
    @Override
    public void take() {
        throw new UnsupportedOperationException("Por escribir");
    }

    /** La línea del {@code describe()} de tu clase con las salidas: {@code "... · salidas: 1"}. */
    @Override
    public String describe() {
        throw new UnsupportedOperationException("Por escribir");
    }
}
