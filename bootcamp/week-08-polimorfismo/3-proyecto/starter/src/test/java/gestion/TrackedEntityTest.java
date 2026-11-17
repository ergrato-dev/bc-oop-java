package gestion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;

/**
 * Tests de la subclase que cuenta salidas. Hereda todo de tu clase y sobrescribe
 * {@code take} y {@code describe}.
 */
class TrackedEntityTest {

    // --- La clase ---

    @Test
    void extendsTheEntityNotTheReservedOne() {
        assertThat(TrackedEntity.class.getSuperclass()).isEqualTo(Entity.class);
    }

    @Test
    void onlyDeclaresThePrivateTaken() {
        Field[] fields = TrackedEntity.class.getDeclaredFields();
        assertThat(fields)
                .as("el código, el nombre y las unidades se heredan: solo se declara taken")
                .hasSize(1);
        assertThat(fields[0].getName()).isEqualTo("taken");
        assertThat(fields[0].getType()).isEqualTo(int.class);
        assertThat(Modifier.isPrivate(fields[0].getModifiers())).as("taken debe ser private").isTrue();
        assertThat(Modifier.isFinal(fields[0].getModifiers()))
                .as("taken cambia con cada salida: no puede ser final")
                .isFalse();
    }

    @Test
    void overridesTakeAndDescribe() throws NoSuchMethodException {
        assertThat(TrackedEntity.class.getDeclaredMethod("take")).isNotNull();
        assertThat(TrackedEntity.class.getDeclaredMethod("describe")).isNotNull();
    }

    // --- El constructor ---

    @Test
    void startsWithoutTakes() {
        TrackedEntity item = new TrackedEntity(" bk-042 ", " Ficciones ", 2);
        assertThat(item.getCode()).isEqualTo("BK-042");
        assertThat(item.getName()).isEqualTo("Ficciones");
        assertThat(item.getQuantity()).isEqualTo(2);
        assertThat(item.getTaken()).isZero();
    }

    @Test
    void theParentConstructorStillValidates() {
        assertThatThrownBy(() -> new TrackedEntity("BK-042", "Ficciones", -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Unidades no válidas: -1");
    }

    // --- Lo que sobrescribe ---

    @Test
    void takeCountsEveryTake() {
        TrackedEntity item = new TrackedEntity("BK-042", "Ficciones", 3);
        item.take();
        item.take();
        assertThat(item.getQuantity()).isEqualTo(1);
        assertThat(item.getTaken()).isEqualTo(2);
    }

    @Test
    void aFailedTakeIsNotCounted() {
        TrackedEntity item = new TrackedEntity("BK-042", "Ficciones", 0);
        assertThatThrownBy(item::take)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("No quedan unidades de BK-042");
        assertThat(item.getTaken()).isZero();
    }

    @Test
    void restockIsInheritedAndNotCounted() {
        TrackedEntity item = new TrackedEntity("BK-042", "Ficciones", 1);
        item.take();
        item.restock(4);
        assertThat(item.getQuantity()).isEqualTo(4);
        assertThat(item.getTaken()).isEqualTo(1);
    }

    @Test
    void describeAddsTheTakes() {
        TrackedEntity item = new TrackedEntity("BK-042", "Ficciones", 2);
        item.take();
        assertThat(item.describe()).isEqualTo("BK-042 · Ficciones · disponibles: 1 · salidas: 1");
    }

    // --- Polimorfismo: la variable es Entity, el objeto decide ---

    @Test
    void throughAnEntityVariableTheOverrideRuns() {
        Entity item = new TrackedEntity("BK-042", "Ficciones", 2);
        item.take();
        assertThat(item.toString()).isEqualTo("BK-042 · Ficciones · disponibles: 1 · salidas: 1");
    }

    @Test
    void theSameLoopRunsThreeDifferentTakes() {
        Entity[] items = {
            new Entity("BK-042", "Ficciones", 1),
            new ReservedEntity("BK-900", "Atlas universal", 1, 1),
            new TrackedEntity("BK-311", "Rayuela", 1)
        };
        int rejected = 0;
        for (Entity item : items) {
            try {
                item.take();
            } catch (IllegalStateException e) {
                rejected++;
            }
        }
        assertThat(rejected).isEqualTo(1);
        assertThat(items[0].getQuantity()).isZero();
        assertThat(items[1].getQuantity()).isEqualTo(1);
        assertThat(items[2]).hasToString("BK-311 · Rayuela · disponibles: 0 · salidas: 1");
    }

    @Test
    void theInventoryCountsTheTakes() {
        Inventory inventory = new Inventory(2);
        TrackedEntity item = new TrackedEntity("BK-042", "Ficciones", 5);
        inventory.add(item);
        inventory.take("bk-042");
        inventory.take("BK-042");
        assertThat(item.getTaken()).isEqualTo(2);
    }
}
