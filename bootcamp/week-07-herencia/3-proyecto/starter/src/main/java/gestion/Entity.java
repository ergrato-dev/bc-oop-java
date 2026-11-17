package gestion;

/**
 * La entidad principal de tu dominio: un objeto con su código, su nombre y las unidades que
 * quedan. Sustituye a los arrays paralelos {@code codes}, {@code titles} y {@code quantities}.
 *
 * <p><strong>No la copies a tu proyecto</strong>: tu clase de la semana 06 (por ejemplo,
 * {@code Bicycle}) ya tiene escrito todo lo demás. Este archivo es la referencia de lo que
 * cambia esta semana, marcado con {@code // SEMANA 07}: lo aplicas a mano en tu clase.
 *
 * <p>Está encapsulada: los atributos son {@code private}, el código y el nombre no cambian
 * ({@code final}) y las unidades solo cambian con {@link #take()} y {@link #restock(int)}. El
 * constructor rechaza los datos que no valen, así que no puede existir una entidad en mal estado.
 */
public class Entity {

    // private en los tres; final en los que no cambian nunca.
    private final String code;
    private final String name;
    private int quantity;

    /**
     * Crea la entidad con el código normalizado ({@code Fields.normalizeCode}) y el nombre sin
     * espacios en los extremos. {@code new Entity(" bk-042 ", " Ficciones ", 2)} tiene código
     * {@code "BK-042"} y nombre {@code "Ficciones"}.
     *
     * @throws IllegalArgumentException si el código normalizado no es válido según
     *     {@code Stock.isValidCode} ({@code "Código no válido: " + code}), si el nombre es
     *     {@code null} o está en blanco ({@code "Nombre vacío"}) o si {@code quantity} es negativo
     *     ({@code "Unidades no válidas: " + quantity})
     */
    public Entity(String code, String name, int quantity) {
        throw new UnsupportedOperationException("Por escribir");
    }

    /** Crea la entidad sin unidades: un alta en el catálogo antes de recibir existencias. */
    public Entity(String code, String name) {
        throw new UnsupportedOperationException("Por escribir");
    }

    // Getters, solo de lectura. No hay setters.
    public String getCode() {
        throw new UnsupportedOperationException("Por escribir");
    }

    public String getName() {
        throw new UnsupportedOperationException("Por escribir");
    }

    public int getQuantity() {
        throw new UnsupportedOperationException("Por escribir");
    }

    /** Una línea con código, nombre y unidades: {@code "BK-042 · Ficciones · disponibles: 2"}. */
    public String describe() {
        throw new UnsupportedOperationException("Por escribir");
    }

    // SEMANA 07: sobrescribe el toString de Object con @Override. Su única línea es
    // return describe();
    /**
     * La misma línea que {@link #describe()}. Sobrescribe el {@code toString} de {@code Object},
     * así que {@code System.out.println(item)} y {@code "" + item} muestran la descripción.
     */
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Por escribir");
    }

    /** {@code true} si queda al menos una unidad. */
    public boolean isAvailable() {
        throw new UnsupportedOperationException("Por escribir");
    }

    /**
     * Saca una unidad: un préstamo, una venta, una reserva... según tu dominio.
     *
     * @throws IllegalStateException con el mensaje {@code "No quedan unidades de " + code} si
     *     no queda ninguna; en ese caso la cantidad no cambia
     */
    public void take() {
        throw new UnsupportedOperationException("Por escribir");
    }

    /**
     * Suma {@code units} unidades.
     *
     * @throws IllegalArgumentException con el mensaje {@code "Unidades no válidas: " + units}
     *     si {@code units} no es positivo
     */
    public void restock(int units) {
        throw new UnsupportedOperationException("Por escribir");
    }

    /**
     * {@code true} si el nombre contiene {@code query}, sin distinguir mayúsculas y sin los
     * espacios de los extremos de {@code query}, como {@code Catalog.search}.
     *
     * @throws IllegalArgumentException con el mensaje {@code "Búsqueda vacía"} si
     *     {@code query} es {@code null} o está en blanco
     */
    public boolean matches(String query) {
        throw new UnsupportedOperationException("Por escribir");
    }

    /** El nivel de sus unidades frente a {@code capacity}, como {@code Stock.level}. */
    public String level(int capacity) {
        throw new UnsupportedOperationException("Por escribir");
    }

    /**
     * Posición de la entidad con ese código en {@code items}, o {@code -1} si no está.
     * El código se busca normalizado: {@code " bk-107 "} encuentra {@code "BK-107"}.
     */
    public static int indexOf(Entity[] items, String code) {
        throw new UnsupportedOperationException("Por escribir");
    }

    /** Suma las unidades de todas las entidades. Un array vacío suma {@code 0}. */
    public static int total(Entity[] items) {
        throw new UnsupportedOperationException("Por escribir");
    }
}
