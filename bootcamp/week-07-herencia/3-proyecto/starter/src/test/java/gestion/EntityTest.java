package gestion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

/** La entidad principal como objeto encapsulado, con los datos de la Biblioteca. */
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

    // --- Semana 06: getters ---

    @Test
    void gettersReturnTheNormalizedData() {
        Entity item = new Entity(" bk-107 ", "  El túnel ", 5);
        assertThat(item.getCode()).isEqualTo("BK-107");
        assertThat(item.getName()).isEqualTo("El túnel");
        assertThat(item.getQuantity()).isEqualTo(5);
    }

    @Test
    void quantityChangesOnlyThroughTakeAndRestock() {
        ficciones.take();
        ficciones.restock(4);
        assertThat(ficciones.getQuantity()).isEqualTo(5);
    }

    // --- Semana 06: el constructor protege al objeto ---

    @Test
    void constructorWithoutQuantityStartsWithNoUnits() {
        Entity item = new Entity("bk-500", "Pedro Páramo");
        assertThat(item.getQuantity()).isZero();
        assertThat(item.describe()).isEqualTo("BK-500 · Pedro Páramo · disponibles: 0");
    }

    @ParameterizedTest
    @CsvSource({"bk042, BK042", "BK-, BK-", "-042, -042", "' bk-4a ', BK-4A"})
    void constructorRejectsInvalidCodes(String code, String normalized) {
        assertThatThrownBy(() -> new Entity(code, "Ficciones", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Código no válido: " + normalized);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    void constructorRejectsBlankNames(String name) {
        assertThatThrownBy(() -> new Entity("BK-042", name, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Nombre vacío");
    }

    @Test
    void constructorRejectsNegativeQuantities() {
        assertThatThrownBy(() -> new Entity("BK-042", "Ficciones", -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Unidades no válidas: -1");
    }

    // --- Semana 06: tests de diseño ---
    // Revisan la clase, no un objeto: qué atributos y métodos declara y con qué modificadores.

    @Test
    void attributesArePrivate() {
        for (Field field : Entity.class.getDeclaredFields()) {
            assertThat(Modifier.isPrivate(field.getModifiers()))
                    .as("el atributo %s debe ser private", field.getName())
                    .isTrue();
        }
    }

    @Test
    void textAttributesAreFinal() {
        for (Field field : Entity.class.getDeclaredFields()) {
            if (field.getType() == String.class) {
                assertThat(Modifier.isFinal(field.getModifiers()))
                        .as("el atributo %s debe ser final", field.getName())
                        .isTrue();
            }
        }
    }

    @Test
    void hasNoSetters() {
        for (Method method : Entity.class.getDeclaredMethods()) {
            assertThat(method.getName())
                    .as("las unidades cambian con take y restock, no con un setter")
                    .doesNotStartWith("set");
        }
    }

    // --- Semana 07: toString ---

    @Test
    void toStringReturnsDescribe() {
        Entity item = new Entity("BK-042", "Ficciones", 2);
        assertThat(item.toString()).isEqualTo("BK-042 · Ficciones · disponibles: 2");
    }

    @Test
    void concatenationUsesToString() {
        Entity item = new Entity("BK-311", "Rayuela", 0);
        assertThat("Ficha: " + item).isEqualTo("Ficha: BK-311 · Rayuela · disponibles: 0");
    }
}
