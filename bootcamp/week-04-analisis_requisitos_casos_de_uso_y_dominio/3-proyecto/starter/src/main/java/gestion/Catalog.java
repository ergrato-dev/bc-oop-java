package gestion;

/**
 * El catálogo de tu dominio: buscar, dar de alta y dar de baja.
 *
 * <p>Sigue trabajando con arrays paralelos: {@code codes[i]} se titula {@code titles[i]}.
 * Ningún método cambia el array que recibe: {@code add} y {@code remove} devuelven uno nuevo.
 * En la semana 05 el catálogo guardará objetos; en la 13, una colección.
 */
public class Catalog {

    /**
     * Posiciones de los títulos que contienen {@code query}, de menor a mayor, sin distinguir
     * mayúsculas y sin tener en cuenta los espacios de los extremos de {@code query}.
     * {@code search({"Rayuela", "Ficciones", "El túnel"}, "el")} da {@code [0, 2]}.
     * Las tildes cuentan: {@code "tunel"} no encuentra {@code "El túnel"}.
     *
     * @throws IllegalArgumentException con el mensaje {@code "Búsqueda vacía"} si
     *     {@code query} es {@code null} o está en blanco
     */
    public static int[] search(String[] titles, String query) {
        throw new UnsupportedOperationException("Por escribir");
    }

    /**
     * Da de alta un código: devuelve un array nuevo con los de {@code codes} y, al final,
     * {@code code} normalizado. {@code add({"BK-042"}, " bk-500 ")} da {@code ["BK-042", "BK-500"]}.
     *
     * @throws IllegalArgumentException con el mensaje {@code "Código no válido: " + code}
     *     si, ya normalizado, no es un código válido ({@code Stock.isValidCode}), o con
     *     {@code "Código repetido: " + normalizado} si ya está en {@code codes}
     */
    public static String[] add(String[] codes, String code) {
        throw new UnsupportedOperationException("Por escribir");
    }

    /**
     * Da de baja un código: devuelve un array nuevo sin él y con los demás en el mismo orden.
     * El código se busca normalizado: {@code " bk-107 "} encuentra {@code "BK-107"}.
     *
     * @throws IllegalArgumentException con el mensaje {@code "No existe: " + code} si no está
     */
    public static String[] remove(String[] codes, String code) {
        throw new UnsupportedOperationException("Por escribir");
    }
}
