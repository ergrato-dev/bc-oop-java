package gestion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;

/**
 * Tests de la interfaz {@code Criterion} y de sus dos implementaciones. La interfaz declara
 * {@code accepts} sin cuerpo y trae {@code count} escrito como método {@code default}.
 */
class CriterionTest {

    private final Entity ficciones = new Entity("BK-042", "Ficciones", 2);
    private final Entity empty = new Entity("BK-107", "Rayuela", 0);

    // --- la interfaz: un contrato ---

    @Test
    void criterionIsAnInterface() {
        assertThat(Criterion.class.isInterface())
                .as("Criterion se declara con interface, no con class")
                .isTrue();
    }

    @Test
    void acceptsHasNoBodyAndCountIsDefault() throws Exception {
        assertThat(Modifier.isAbstract(Criterion.class.getMethod("accepts", Entity.class).getModifiers()))
                .as("accepts no tiene cuerpo: lo escribe cada criterio")
                .isTrue();
        assertThat(Criterion.class.getMethod("count", Entity[].class).isDefault())
                .as("count tiene cuerpo en la interfaz: es default")
                .isTrue();
    }

    @Test
    void bothCriteriaImplementTheInterface() {
        assertThat(Criterion.class).isAssignableFrom(AvailableCriterion.class);
        assertThat(Criterion.class).isAssignableFrom(NameCriterion.class);
        assertThat(AvailableCriterion.class.getSuperclass())
                .as("implements Criterion, no extends de otra clase")
                .isEqualTo(Object.class);
        assertThat(NameCriterion.class.getSuperclass()).isEqualTo(Object.class);
    }

    // --- AvailableCriterion: le pregunta a cada objeto ---

    @Test
    void availableAcceptsWhenThereAreUnits() {
        assertThat(new AvailableCriterion().accepts(ficciones)).isTrue();
    }

    @Test
    void availableRejectsWhenThereAreNoUnits() {
        assertThat(new AvailableCriterion().accepts(empty)).isFalse();
    }

    @Test
    void availableRespectsTheReserve() {
        Criterion available = new AvailableCriterion();
        assertThat(available.accepts(new ReservedEntity("BK-900", "Atlas universal", 1, 1))).isFalse();
        assertThat(available.accepts(new ReservedEntity("BK-901", "Atlas escolar", 2, 1))).isTrue();
    }

    // --- NameCriterion: un dato propio, el texto que busca ---

    @Test
    void nameAcceptsIgnoringCase() {
        assertThat(new NameCriterion("ficc").accepts(ficciones)).isTrue();
        assertThat(new NameCriterion("FICC").accepts(ficciones)).isTrue();
    }

    @Test
    void nameRejectsOtherNames() {
        assertThat(new NameCriterion("rayuela").accepts(ficciones)).isFalse();
    }

    @Test
    void nameRejectsAnEmptyQueryWhenCreated() {
        assertThatThrownBy(() -> new NameCriterion("  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Búsqueda vacía");
        assertThatThrownBy(() -> new NameCriterion(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Búsqueda vacía");
    }

    @Test
    void nameOnlyDeclaresThePrivateFinalQuery() {
        Field[] fields = NameCriterion.class.getDeclaredFields();
        assertThat(fields).hasSize(1);
        assertThat(fields[0].getName()).isEqualTo("query");
        assertThat(Modifier.isPrivate(fields[0].getModifiers())).as("query debe ser private").isTrue();
        assertThat(Modifier.isFinal(fields[0].getModifiers()))
                .as("el texto no cambia después de crear el criterio: final")
                .isTrue();
    }

    // --- count: escrito una vez en la interfaz, heredado por todos ---

    @Test
    void countCountsTheAcceptedEntities() {
        Entity[] items = {ficciones, empty, new Entity("BK-311", "Rayuela ilustrada", 1)};
        assertThat(new AvailableCriterion().count(items)).isEqualTo(2);
        assertThat(new NameCriterion("rayuela").count(items)).isEqualTo(2);
        assertThat(new NameCriterion("kafka").count(items)).isZero();
    }

    @Test
    void anyNewCriterionInheritsCount() {
        // Un criterio que no existía: solo escribe accepts y ya sabe contar.
        class LongName implements Criterion {
            @Override
            public boolean accepts(Entity item) {
                return item.getName().length() > 8;
            }
        }
        Entity[] items = {ficciones, empty, new Entity("BK-311", "Rayuela ilustrada", 1)};
        assertThat(new LongName().count(items)).isEqualTo(2);
    }
}
