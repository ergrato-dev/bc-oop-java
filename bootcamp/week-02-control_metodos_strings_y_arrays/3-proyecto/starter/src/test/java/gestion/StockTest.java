package gestion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StockTest {

    @Test
    void parseCodesSplitsAndNormalizes() {
        assertThat(Stock.parseCodes("bk-042, BK-107 ,bk-311"))
                .containsExactly("BK-042", "BK-107", "BK-311");
    }

    @Test
    void parseCodesSkipsBlankItems() {
        assertThat(Stock.parseCodes("BK-042,, ,BK-107,")).containsExactly("BK-042", "BK-107");
    }

    @Test
    void parseCodesOfEmptyLineIsEmpty() {
        assertThat(Stock.parseCodes("")).isEmpty();
    }

    @Test
    void isValidCodeAcceptsLettersDashDigits() {
        assertThat(Stock.isValidCode("BK-042")).isTrue();
        assertThat(Stock.isValidCode("HAB-1")).isTrue();
    }

    @Test
    void isValidCodeRejectsLowercase() {
        assertThat(Stock.isValidCode("bk-042")).isFalse();
    }

    @Test
    void isValidCodeRejectsMissingOrWrongParts() {
        assertThat(Stock.isValidCode("BK-")).isFalse();
        assertThat(Stock.isValidCode("-042")).isFalse();
        assertThat(Stock.isValidCode("BK042")).isFalse();
        assertThat(Stock.isValidCode("BK-04A")).isFalse();
        assertThat(Stock.isValidCode("BK--042")).isFalse();
        assertThat(Stock.isValidCode("")).isFalse();
    }

    @Test
    void totalSumsAll() {
        assertThat(Stock.total(new int[] {4, 0, 7})).isEqualTo(11);
    }

    @Test
    void totalOfEmptyIsZero() {
        assertThat(Stock.total(new int[] {})).isZero();
    }

    @Test
    void indexOfFindsNormalizedCode() {
        String[] codes = {"BK-042", "BK-107", "BK-311"};
        assertThat(Stock.indexOf(codes, " bk-107 ")).isEqualTo(1);
    }

    @Test
    void indexOfMissingIsMinusOne() {
        String[] codes = {"BK-042", "BK-107"};
        assertThat(Stock.indexOf(codes, "BK-999")).isEqualTo(-1);
    }

    @Test
    void levelZeroIsOut() {
        assertThat(Stock.level(0, 10)).isEqualTo("agotado");
    }

    @Test
    void levelUpToAQuarterIsLow() {
        assertThat(Stock.level(2, 8)).isEqualTo("bajo");
        assertThat(Stock.level(1, 10)).isEqualTo("bajo");
    }

    @Test
    void levelBelowCapacityIsNormal() {
        assertThat(Stock.level(3, 8)).isEqualTo("normal");
        assertThat(Stock.level(9, 10)).isEqualTo("normal");
    }

    @Test
    void levelAtOrOverCapacityIsFull() {
        assertThat(Stock.level(10, 10)).isEqualTo("completo");
        assertThat(Stock.level(12, 10)).isEqualTo("completo");
    }

    @Test
    void reportHasOneLinePerItem() {
        String[] codes = {"BK-042", "BK-107"};
        int[] quantities = {0, 7};
        assertThat(Stock.report(codes, quantities, 10))
                .isEqualTo("BK-042: 0/10 (agotado)\nBK-107: 7/10 (normal)\n");
    }

    @Test
    void reportOfNothingIsEmpty() {
        assertThat(Stock.report(new String[] {}, new int[] {}, 10)).isEmpty();
    }

    @Test
    void missingUpToCapacity() {
        assertThat(Stock.missing(new int[] {4, 0, 10, 12}, 10)).containsExactly(6, 10, 0, 0);
    }

    @Test
    void missingDoesNotChangeInput() {
        int[] quantities = {4, 0};
        Stock.missing(quantities, 10);
        assertThat(quantities).containsExactly(4, 0);
    }
}
