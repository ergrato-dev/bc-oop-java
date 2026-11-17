package gestion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import org.junit.jupiter.api.Test;

class FieldsTest {

    @Test
    void parseAmountWithDot() {
        assertThat(Fields.parseAmount("12.5")).isEqualTo(12.5);
    }

    @Test
    void parseAmountWithComma() {
        assertThat(Fields.parseAmount("12,5")).isEqualTo(12.5);
    }

    @Test
    void parseAmountTrimsSpaces() {
        assertThat(Fields.parseAmount("  30 ")).isEqualTo(30.0);
    }

    @Test
    void parseAmountZeroIsARealValue() {
        assertThat(Fields.parseAmount("0")).isZero();
    }

    @Test
    void parseAmountKeepsDecimals() {
        assertThat(Fields.parseAmount("0,1")).isCloseTo(0.1, within(1e-9));
    }

    @Test
    void normalizeCodeTrimsAndUppercases() {
        assertThat(Fields.normalizeCode(" bk-042 ")).isEqualTo("BK-042");
    }

    @Test
    void describeUsesTwoDecimalsAndDot() {
        assertThat(Fields.describe("Precio", 12.5, "USD")).isEqualTo("Precio: 12.50 USD");
    }

    @Test
    void describeRoundsHalfUp() {
        assertThat(Fields.describe("Peso", 1.005, "kg")).isEqualTo("Peso: 1.01 kg");
    }

    @Test
    void isInRangeIncludesBothLimits() {
        assertThat(Fields.isInRange(0.0, 0.0, 500.0)).isTrue();
        assertThat(Fields.isInRange(500.0, 0.0, 500.0)).isTrue();
    }

    @Test
    void isInRangeRejectsOutside() {
        assertThat(Fields.isInRange(-0.01, 0.0, 500.0)).isFalse();
        assertThat(Fields.isInRange(500.01, 0.0, 500.0)).isFalse();
    }

    @Test
    void fitsAcceptsFullCapacity() {
        assertThat(Fields.fits(10, 10)).isTrue();
    }

    @Test
    void fitsRejectsNegativeAndOverflow() {
        assertThat(Fields.fits(-1, 10)).isFalse();
        assertThat(Fields.fits(11, 10)).isFalse();
    }
}
