package gestion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class RulesTest {

    // --- overdueDays ---

    @ParameterizedTest
    @CsvSource({
        "1, 10, 14, 0",   // a tiempo
        "1, 15, 14, 0",   // el último día permitido
        "1, 16, 14, 1",   // un día tarde
        "5, 30, 7,  18",
        "3, 3,  0,  0"    // empieza y termina el mismo día, sin plazo
    })
    void overdueDays(int start, int end, int allowed, int expected) {
        assertThat(Rules.overdueDays(start, end, allowed)).isEqualTo(expected);
    }

    @Test
    void overdueDaysRejectsEndBeforeStart() {
        assertThatThrownBy(() -> Rules.overdueDays(10, 5, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void overdueDaysRejectsNegativeAllowance() {
        assertThatThrownBy(() -> Rules.overdueDays(1, 5, -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // --- penalty ---

    @ParameterizedTest
    @CsvSource({
        "0,  0.5,  10, 0.0",
        "4,  0.5,  10, 2.0",
        "5,  0.5,  10, 2.5",
        "3,  0.35, 10, 1.05",
        "30, 0.5,  10, 10.0"   // el tope manda
    })
    void penalty(int days, double rate, double max, double expected) {
        assertThat(Rules.penalty(days, rate, max)).isCloseTo(expected, within(0.001));
    }

    @Test
    void penaltyRejectsNegativeDays() {
        assertThatThrownBy(() -> Rules.penalty(-1, 0.5, 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void penaltyRejectsNegativeRate() {
        assertThatThrownBy(() -> Rules.penalty(2, -0.5, 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // --- parseQuantity ---

    @ParameterizedTest
    @CsvSource({
        "7,        7",
        "' 12 ',   12",
        "000,      0",
        "999999,   999999"
    })
    void parsesQuantities(String text, int expected) {
        assertThat(Rules.parseQuantity(text)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-3", "+3", "12a", "1 000", "1234567", "3.5"})
    void rejectsMalformedQuantities(String text) {
        assertThatThrownBy(() -> Rules.parseQuantity(text))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Cantidad no válida: " + text);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    void rejectsMissingQuantities(String text) {
        assertThatThrownBy(() -> Rules.parseQuantity(text))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Cantidad vacía");
    }

    // --- canReserve ---

    @ParameterizedTest
    @CsvSource({
        "0, 3, 0.0, true",
        "2, 3, 0.0, true",
        "3, 3, 0.0, false",   // sin plazas
        "1, 3, 0.5, false"    // penalización pendiente
    })
    void canReserve(int active, int max, double pending, boolean expected) {
        assertThat(Rules.canReserve(active, max, pending)).isEqualTo(expected);
    }

    @Test
    void canReserveRejectsZeroMax() {
        assertThatThrownBy(() -> Rules.canReserve(0, 0, 0.0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
