package gestion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;

/**
 * Tests de la subclase con reserva. Hereda todo de tu clase y sobrescribe
 * {@code isAvailable}, {@code take} y {@code describe}.
 */
class ReservedEntityTest {

    // --- La clase ---

    @Test
    void extendsTheEntity() {
        assertThat(ReservedEntity.class.getSuperclass()).isEqualTo(Entity.class);
    }

    @Test
    void onlyDeclaresThePrivateFinalReserve() {
        Field[] fields = ReservedEntity.class.getDeclaredFields();
        assertThat(fields)
                .as("el código, el nombre y las unidades se heredan: solo se declara reserve")
                .hasSize(1);
        assertThat(fields[0].getName()).isEqualTo("reserve");
        assertThat(Modifier.isPrivate(fields[0].getModifiers())).as("reserve debe ser private").isTrue();
        assertThat(Modifier.isFinal(fields[0].getModifiers())).as("reserve debe ser final").isTrue();
    }

    @Test
    void overridesIsAvailableTakeAndDescribe() throws NoSuchMethodException {
        assertThat(ReservedEntity.class.getDeclaredMethod("isAvailable")).isNotNull();
        assertThat(ReservedEntity.class.getDeclaredMethod("take")).isNotNull();
        assertThat(ReservedEntity.class.getDeclaredMethod("describe")).isNotNull();
    }

    // --- El constructor ---

    @Test
    void inheritsCodeNameAndQuantity() {
        ReservedEntity item = new ReservedEntity(" bk-042 ", " Ficciones ", 3, 1);
        assertThat(item.getCode()).isEqualTo("BK-042");
        assertThat(item.getName()).isEqualTo("Ficciones");
        assertThat(item.getQuantity()).isEqualTo(3);
        assertThat(item.getReserve()).isEqualTo(1);
    }

    @Test
    void rejectsANegativeReserve() {
        assertThatThrownBy(() -> new ReservedEntity("BK-042", "Ficciones", 3, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Reserva no válida: -1");
    }

    @Test
    void theParentConstructorStillValidatesTheCode() {
        assertThatThrownBy(() -> new ReservedEntity("bk042", "Ficciones", 3, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Código no válido: BK042");
    }

    @Test
    void theParentConstructorStillValidatesTheQuantity() {
        assertThatThrownBy(() -> new ReservedEntity("BK-042", "Ficciones", -2, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Unidades no válidas: -2");
    }

    // --- Lo que sobrescribe ---

    @Test
    void takeStopsAtTheReserve() {
        ReservedEntity item = new ReservedEntity("BK-042", "Ficciones", 2, 1);
        item.take();
        assertThat(item.getQuantity()).isEqualTo(1);
        assertThatThrownBy(item::take)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Solo queda la reserva de BK-042");
        assertThat(item.getQuantity()).isEqualTo(1);
    }

    @Test
    void withoutUnitsTakeFailsLikeTheParent() {
        ReservedEntity item = new ReservedEntity("BK-042", "Ficciones", 0, 1);
        assertThatThrownBy(item::take)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("No quedan unidades de BK-042");
    }

    @Test
    void aZeroReserveBehavesLikeTheParent() {
        ReservedEntity item = new ReservedEntity("BK-042", "Ficciones", 1, 0);
        assertThat(item.isAvailable()).isTrue();
        item.take();
        assertThat(item.getQuantity()).isZero();
        assertThat(item.isAvailable()).isFalse();
    }

    @Test
    void isAvailableOnlyAboveTheReserve() {
        assertThat(new ReservedEntity("BK-042", "Ficciones", 2, 1).isAvailable()).isTrue();
        assertThat(new ReservedEntity("BK-042", "Ficciones", 1, 1).isAvailable()).isFalse();
    }

    @Test
    void describeAddsTheReserve() {
        ReservedEntity item = new ReservedEntity("BK-042", "Ficciones", 2, 1);
        assertThat(item.describe()).isEqualTo("BK-042 · Ficciones · disponibles: 2 · reserva: 1");
    }

    // --- Lo que hereda ---

    @Test
    void restockIsInherited() {
        ReservedEntity item = new ReservedEntity("BK-042", "Ficciones", 1, 1);
        item.restock(2);
        assertThat(item.getQuantity()).isEqualTo(3);
        assertThat(item.isAvailable()).isTrue();
    }

    @Test
    void theInheritedToStringUsesTheNewDescribe() {
        ReservedEntity item = new ReservedEntity("BK-042", "Ficciones", 2, 1);
        assertThat(item.toString()).isEqualTo("BK-042 · Ficciones · disponibles: 2 · reserva: 1");
    }

    // --- Donde se espera tu clase ---

    @Test
    void fitsWhereTheEntityFits() {
        Entity item = new ReservedEntity("BK-042", "Ficciones", 1, 1);
        assertThat(item.isAvailable()).isFalse();
        assertThatThrownBy(item::take).hasMessage("Solo queda la reserva de BK-042");
    }

    @Test
    void indexOfAndTotalCountIt() {
        Entity[] items = {
            new Entity("BK-107", "El túnel", 4),
            new ReservedEntity("BK-042", "Ficciones", 3, 1),
        };
        assertThat(Entity.indexOf(items, "bk-042")).isEqualTo(1);
        assertThat(Entity.total(items)).isEqualTo(7);
    }

    @Test
    void theInventoryDelegatesToTheOverride() {
        Inventory inventory = new Inventory(3);
        inventory.add(new Entity("BK-107", "El túnel", 1));
        inventory.add(new ReservedEntity("BK-042", "Ficciones", 2, 1));
        inventory.take("BK-042");
        assertThatThrownBy(() -> inventory.take("bk-042"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Solo queda la reserva de BK-042");
        assertThat(inventory.total()).isEqualTo(2);
    }
}
