package gestion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/** El inventario: un objeto compuesto de entidades, con los datos de la Biblioteca. */
class InventoryTest {

    private final Inventory inventory = new Inventory(3);
    private final Entity ficciones = new Entity("BK-042", "Ficciones", 2);
    private final Entity rayuela = new Entity("BK-311", "Rayuela", 7);

    // --- constructor ---

    @Test
    void aNewInventoryIsEmpty() {
        assertThat(inventory.size()).isZero();
        assertThat(inventory.total()).isZero();
        assertThat(inventory.items()).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void capacityMustBePositive(int capacity) {
        assertThatThrownBy(() -> new Inventory(capacity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Capacidad no válida: " + capacity);
    }

    // --- add ---

    @Test
    void addKeepsTheOrder() {
        inventory.add(ficciones);
        inventory.add(rayuela);
        assertThat(inventory.size()).isEqualTo(2);
        assertThat(inventory.items()).containsExactly(ficciones, rayuela);
    }

    @Test
    void addRejectsARepeatedCode() {
        inventory.add(ficciones);
        assertThatThrownBy(() -> inventory.add(new Entity("bk-042", "Otro título", 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Código repetido: BK-042");
        assertThat(inventory.size()).isEqualTo(1);
    }

    @Test
    void addFailsWhenFull() {
        inventory.add(ficciones);
        inventory.add(rayuela);
        inventory.add(new Entity("BK-107", "El túnel"));
        assertThatThrownBy(() -> inventory.add(new Entity("BK-500", "Pedro Páramo")))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Inventario lleno: 3");
        assertThat(inventory.size()).isEqualTo(3);
    }

    // --- contains y find ---

    @Test
    void containsNormalizesTheCode() {
        inventory.add(rayuela);
        assertThat(inventory.contains(" bk-311 ")).isTrue();
        assertThat(inventory.contains("BK-042")).isFalse();
    }

    @Test
    void findReturnsTheSameObject() {
        inventory.add(ficciones);
        inventory.add(rayuela);
        assertThat(inventory.find("bk-311")).isSameAs(rayuela);
    }

    @Test
    void findRejectsAMissingCode() {
        inventory.add(ficciones);
        assertThatThrownBy(() -> inventory.find(" bk-999 "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("No existe: BK-999");
    }

    // --- take y total: el inventario delega en sus entidades ---

    @Test
    void takeDelegatesToTheEntity() {
        inventory.add(ficciones);
        inventory.take("BK-042");
        assertThat(ficciones.getQuantity()).isEqualTo(1);
        assertThat(inventory.total()).isEqualTo(1);
    }

    @Test
    void takeWithoutUnitsFailsLikeTheEntity() {
        inventory.add(new Entity("BK-107", "El túnel"));
        assertThatThrownBy(() -> inventory.take("BK-107"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("No quedan unidades de BK-107");
    }

    @Test
    void totalAddsTheUnitsOfEveryEntity() {
        inventory.add(ficciones);
        inventory.add(rayuela);
        assertThat(inventory.total()).isEqualTo(9);
    }

    // --- encapsulación: nadie de fuera toca el array ---

    @Test
    void itemsReturnsACopy() {
        inventory.add(ficciones);
        inventory.add(rayuela);
        Entity[] copy = inventory.items();
        copy[0] = null;
        assertThat(inventory.items()).containsExactly(ficciones, rayuela);
        assertThat(inventory.total()).isEqualTo(9);
    }

    @Test
    void attributesArePrivate() {
        for (Field field : Inventory.class.getDeclaredFields()) {
            assertThat(Modifier.isPrivate(field.getModifiers()))
                    .as("el atributo %s debe ser private", field.getName())
                    .isTrue();
        }
    }
}
