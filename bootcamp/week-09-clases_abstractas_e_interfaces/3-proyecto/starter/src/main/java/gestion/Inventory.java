package gestion;

import java.util.Arrays;

/**
 * El inventario de tu sistema: un objeto que guarda y controla las entidades de tu dominio.
 * Es una composición: el inventario tiene entidades, y nadie de fuera toca su array.
 *
 * <p>El array tiene una capacidad fija y se llena de izquierda a derecha: las posiciones de
 * {@code 0} a {@code size - 1} tienen entidades y el resto, {@code null}. En la semana 13 lo
 * cambiarás por una lista.
 *
 * <p><strong>No la copies a tu proyecto</strong>: tu {@code Inventory} de la semana 06 ya tiene
 * escrito todo lo demás. Este archivo es la referencia de lo que cambia esta semana, marcado con
 * {@code // SEMANA 09}: lo añades a mano a tu inventario.
 */
public class Inventory {

    private final Entity[] items;
    private int size;

    /**
     * Crea un inventario vacío en el que caben {@code capacity} entidades.
     *
     * @throws IllegalArgumentException con el mensaje {@code "Capacidad no válida: " + capacity}
     *     si {@code capacity} no es positivo
     */
    public Inventory(int capacity) {
        throw new UnsupportedOperationException("Por escribir");
    }

    /**
     * Añade una entidad al final.
     *
     * @throws IllegalArgumentException con el mensaje {@code "Código repetido: " + code} si ya
     *     hay una entidad con su código
     * @throws IllegalStateException con el mensaje {@code "Inventario lleno: " + capacidad} si no
     *     cabe; en los dos casos el inventario no cambia
     */
    public void add(Entity item) {
        throw new UnsupportedOperationException("Por escribir");
    }

    /** {@code true} si hay una entidad con ese código, normalizado como en el constructor. */
    public boolean contains(String code) {
        throw new UnsupportedOperationException("Por escribir");
    }

    /**
     * La entidad con ese código.
     *
     * @throws IllegalArgumentException con el mensaje {@code "No existe: " + code} (normalizado)
     *     si no hay ninguna
     */
    public Entity find(String code) {
        throw new UnsupportedOperationException("Por escribir");
    }

    /** Saca una unidad de la entidad con ese código: el inventario delega en la entidad. */
    public void take(String code) {
        throw new UnsupportedOperationException("Por escribir");
    }

    /** Cuántas entidades hay, no cuántas caben. */
    public int size() {
        throw new UnsupportedOperationException("Por escribir");
    }

    /** Suma de las unidades de todas las entidades. */
    public int total() {
        throw new UnsupportedOperationException("Por escribir");
    }

    // Semana 08: dos métodos que recorren las entidades sin preguntar de qué clase son. Cada
    // objeto responde con su versión de isAvailable() y de toString().

    /**
     * Cuántas entidades están disponibles: las que responden {@code true} a {@code isAvailable()}.
     * Una entidad con reserva cuenta solo si le quedan unidades por encima de la reserva.
     */
    public int availableCount() {
        throw new UnsupportedOperationException("Por escribir");
    }

    /**
     * Una línea por entidad, en orden, cada una terminada en {@code "\n"}: lo que devuelve su
     * {@code toString()}. Vacío si no hay entidades.
     */
    public String report() {
        throw new UnsupportedOperationException("Por escribir");
    }

    // SEMANA 09: dos métodos que reciben un Criterion. El inventario no sabe qué clase de
    // criterio le llega: solo que tiene accepts() y count().

    /**
     * Las entidades que cumplen el criterio, en orden. Un array vacío si no cumple ninguna. Sirve
     * cualquier clase que implemente {@link Criterion}: el inventario no sabe cuál le llega.
     */
    public Entity[] select(Criterion criterion) {
        throw new UnsupportedOperationException("Por escribir");
    }

    /** Cuántas entidades cumplen el criterio: lo cuenta el propio criterio. */
    public int count(Criterion criterion) {
        throw new UnsupportedOperationException("Por escribir");
    }

    /**
     * Una copia del array con las entidades, sin las posiciones vacías. Cambiar la copia (poner
     * {@code null}, cambiar el orden) no cambia el inventario.
     */
    public Entity[] items() {
        throw new UnsupportedOperationException("Por escribir");
    }
}
