package gestion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

/** La entidad principal como objeto, con los datos de la Biblioteca. */
class EntityTest {

    // Cada test crea sus objetos: así ningún test depende de lo que otro cambió.
    private final Entity ficciones = new Entity("BK-042", "Ficciones", 2);
    private final Entity rayuela = new Entity("BK-311", "Rayuela", 0);

    // --- constructor y describe ---

    @Test
    void describeShowsCodeNameAndQuantity() {
        assertThat(ficciones.describe()).isEqualTo("BK-042 · Ficciones · disponibles: 2");
    }

    @Test
    void constructorNormalizesCodeAndName() {
        Entity item = new Entity(" bk-107 ", "  El túnel ", 5);
        assertThat(item.describe()).isEqualTo("BK-107 · El túnel · disponibles: 5");
    }

    @Test
    void eachObjectKeepsItsOwnData() {
        ficciones.take();
        assertThat(ficciones.describe()).endsWith("disponibles: 1");
        assertThat(rayuela.describe()).endsWith("disponibles: 0");
    }

    // --- isAvailable ---

    @Test
    void availableWithUnitsLeft() {
        assertThat(ficciones.isAvailable()).isTrue();
    }

    @Test
    void notAvailableWithZeroUnits() {
        assertThat(rayuela.isAvailable()).isFalse();
    }

    // --- take ---

    @Test
    void takeRemovesOneUnit() {
        ficciones.take();
        assertThat(ficciones.describe()).isEqualTo("BK-042 · Ficciones · disponibles: 1");
    }

    @Test
    void takingTheLastUnitLeavesItUnavailable() {
        ficciones.take();
        ficciones.take();
        assertThat(ficciones.isAvailable()).isFalse();
    }

    @Test
    void takeWithoutUnitsFailsAndChangesNothing() {
        assertThatThrownBy(() -> rayuela.take())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("No quedan unidades de BK-311");
        assertThat(rayuela.describe()).endsWith("disponibles: 0");
    }

    @Test
    void anAliasChangesTheSameObject() {
        Entity alias = ficciones;
        alias.take();
        assertThat(ficciones.describe()).endsWith("disponibles: 1");
    }

    // --- restock ---

    @Test
    void restockAddsUnits() {
        rayuela.restock(3);
        assertThat(rayuela.describe()).isEqualTo("BK-311 · Rayuela · disponibles: 3");
        assertThat(rayuela.isAvailable()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void restockRejectsUnitsThatAreNotPositive(int units) {
        assertThatThrownBy(() -> ficciones.restock(units))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Unidades no válidas: " + units);
        assertThat(ficciones.describe()).endsWith("disponibles: 2");
    }

    // --- matches ---

    @Test
    void matchesPartOfTheName() {
        assertThat(rayuela.matches("el")).isTrue();
    }

    @Test
    void matchesIgnoresCaseAndOuterSpaces() {
        assertThat(ficciones.matches("  FICC ")).isTrue();
    }

    @Test
    void doesNotMatchOtherText() {
        assertThat(ficciones.matches("Borges")).isFalse();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    void matchesRejectsEmptyQueries(String query) {
        assertThatThrownBy(() -> ficciones.matches(query))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Búsqueda vacía");
    }

    // --- level ---

    @ParameterizedTest
    @CsvSource({"0, agotado", "2, bajo", "5, normal", "8, completo"})
    void levelUsesTheQuantityOfTheObject(int quantity, String expected) {
        Entity item = new Entity("BK-500", "Pedro Páramo", quantity);
        assertThat(item.level(8)).isEqualTo(expected);
    }

    // --- indexOf y total (static) ---

    private final Entity[] items = {
        new Entity("BK-042", "Ficciones", 2),
        new Entity("BK-107", "El túnel", 0),
        new Entity("BK-311", "Rayuela", 7)
    };

    @Test
    void indexOfFindsTheCode() {
        assertThat(Entity.indexOf(items, "BK-311")).isEqualTo(2);
    }

    @Test
    void indexOfNormalizesTheCode() {
        assertThat(Entity.indexOf(items, " bk-107 ")).isEqualTo(1);
    }

    @Test
    void indexOfMissingCodeIsMinusOne() {
        assertThat(Entity.indexOf(items, "BK-999")).isEqualTo(-1);
    }

    @Test
    void totalAddsAllUnits() {
        assertThat(Entity.total(items)).isEqualTo(9);
    }

    @Test
    void totalOfNothingIsZero() {
        assertThat(Entity.total(new Entity[0])).isZero();
    }
}
