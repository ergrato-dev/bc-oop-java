package gestion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Tests del enum {@code Level}: cuatro valores fijos, cada uno con su etiqueta, y las mismas
 * reglas que {@code Stock.level}.
 */
class LevelTest {

    // --- un enum: valores fijos ---

    @Test
    void levelIsAnEnum() {
        assertThat(Level.class.isEnum()).as("Level se declara con enum, no con class").isTrue();
    }

    @Test
    void thereAreExactlyFourLevelsInOrder() {
        assertThat(Level.values())
                .containsExactly(Level.SOLD_OUT, Level.LOW, Level.NORMAL, Level.FULL);
    }

    @Test
    void valueOfFindsAConstantByItsName() {
        assertThat(Level.valueOf("LOW")).isSameAs(Level.LOW);
        assertThatThrownBy(() -> Level.valueOf("bajo"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // --- label: cada constante guarda su texto ---

    @Test
    void eachLevelHasItsLabel() {
        assertThat(Level.SOLD_OUT.label()).isEqualTo("agotado");
        assertThat(Level.LOW.label()).isEqualTo("bajo");
        assertThat(Level.NORMAL.label()).isEqualTo("normal");
        assertThat(Level.FULL.label()).isEqualTo("completo");
    }

    // --- of: las reglas de Stock.level, con un tipo ---

    @ParameterizedTest
    @CsvSource({"0, 10, SOLD_OUT", "1, 10, LOW", "2, 8, LOW", "3, 8, NORMAL", "9, 10, NORMAL",
            "10, 10, FULL", "12, 10, FULL"})
    void ofAppliesTheRules(int quantity, int capacity, Level expected) {
        assertThat(Level.of(quantity, capacity)).isEqualTo(expected);
    }

    // --- isAlert: un switch sobre el enum ---

    @Test
    void soldOutAndLowAreAlerts() {
        assertThat(Level.SOLD_OUT.isAlert()).isTrue();
        assertThat(Level.LOW.isAlert()).isTrue();
    }

    @Test
    void normalAndFullAreNotAlerts() {
        assertThat(Level.NORMAL.isAlert()).isFalse();
        assertThat(Level.FULL.isAlert()).isFalse();
    }
}
