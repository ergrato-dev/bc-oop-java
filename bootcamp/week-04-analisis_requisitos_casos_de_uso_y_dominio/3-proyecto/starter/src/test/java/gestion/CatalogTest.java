package gestion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Criterios de aceptación del catálogo (Biblioteca). Cada test empieza por el criterio
 * que prueba: CA-01 a CA-04 son de "Buscar libros por título", CA-05 a CA-07 de
 * "Dar de alta un libro" y CA-08 y CA-09 de "Dar de baja un libro".
 */
class CatalogTest {

    private final String[] titles = {"Rayuela", "Ficciones", "El túnel"};
    private final String[] codes = {"BK-042", "BK-107", "BK-311"};

    // --- search ---

    @Test
    @DisplayName("CA-01 buscar 'el' encuentra Rayuela y El túnel, en orden")
    void searchFindsEveryTitleContainingTheText() {
        assertThat(Catalog.search(titles, "el")).containsExactly(0, 2);
    }

    @Test
    @DisplayName("CA-02 la búsqueda ignora mayúsculas y espacios de los extremos")
    void searchIgnoresCaseAndOuterSpaces() {
        assertThat(Catalog.search(titles, "  FICC ")).containsExactly(1);
    }

    @Test
    @DisplayName("CA-03 una búsqueda sin coincidencias da un array vacío")
    void searchWithoutMatchesIsEmpty() {
        assertThat(Catalog.search(titles, "Borges")).isEmpty();
    }

    @Test
    @DisplayName("CA-03 buscar en un catálogo vacío da un array vacío")
    void searchInEmptyCatalogIsEmpty() {
        assertThat(Catalog.search(new String[0], "el")).isEmpty();
    }

    @Test
    @DisplayName("Las tildes cuentan: 'túnel' encuentra, 'tunel' no")
    void searchKeepsAccents() {
        assertThat(Catalog.search(titles, "túnel")).containsExactly(2);
        assertThat(Catalog.search(titles, "tunel")).isEmpty();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    @DisplayName("CA-04 una búsqueda vacía se rechaza")
    void searchRejectsBlankQueries(String query) {
        assertThatThrownBy(() -> Catalog.search(titles, query))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Búsqueda vacía");
    }

    // --- add ---

    @Test
    @DisplayName("CA-05 dar de alta añade el código normalizado al final")
    void addAppendsNormalizedCode() {
        assertThat(Catalog.add(codes, " bk-500 ")).containsExactly("BK-042", "BK-107", "BK-311", "BK-500");
    }

    @Test
    @DisplayName("CA-05 dar de alta no cambia el array original")
    void addKeepsOriginal() {
        Catalog.add(codes, "BK-500");
        assertThat(codes).containsExactly("BK-042", "BK-107", "BK-311");
    }

    @Test
    @DisplayName("CA-05 el primer libro de un catálogo vacío")
    void addToEmptyCatalog() {
        assertThat(Catalog.add(new String[0], "bk-1")).containsExactly("BK-1");
    }

    @ParameterizedTest
    @ValueSource(strings = {"BK500", "500", "BK-", "-12", "B K-1", ""})
    @DisplayName("CA-06 un código mal formado se rechaza")
    void addRejectsMalformedCodes(String code) {
        assertThatThrownBy(() -> Catalog.add(codes, code))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Código no válido: " + code);
    }

    @Test
    @DisplayName("CA-07 un código repetido se rechaza, aunque venga en minúsculas")
    void addRejectsDuplicates() {
        assertThatThrownBy(() -> Catalog.add(codes, " bk-107"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Código repetido: BK-107");
    }

    // --- remove ---

    @Test
    @DisplayName("CA-08 dar de baja quita el código y conserva el orden de los demás")
    void removeKeepsOrder() {
        assertThat(Catalog.remove(codes, "bk-107")).containsExactly("BK-042", "BK-311");
        assertThat(codes).hasSize(3);
    }

    @Test
    @DisplayName("CA-08 dar de baja el único libro deja el catálogo vacío")
    void removeLastBook() {
        assertThat(Catalog.remove(new String[] {"BK-042"}, "BK-042")).isEmpty();
    }

    @Test
    @DisplayName("CA-09 dar de baja un código que no existe se rechaza")
    void removeRejectsUnknownCode() {
        assertThatThrownBy(() -> Catalog.remove(codes, "BK-999"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("No existe: BK-999");
    }
}
