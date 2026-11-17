package practica;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class FineTest {

    // ============================================
    // PASO 1: tres tests casi iguales
    // ============================================
    // Funcionan, pero solo cambian los datos: el PASO 2 los junta en uno.
    @Test
    void noDelayHasNoFine() {
        assertThat(Fine.category(0)).isEqualTo("sin multa");
    }

    @Test
    void threeDaysIsMinor() {
        assertThat(Fine.category(3)).isEqualTo("leve");
    }

    @Test
    void twentyDaysIsSerious() {
        assertThat(Fine.category(20)).isEqualTo("grave");
    }

    // ============================================
    // PASO 2: un test, varias filas de datos
    // ============================================
    // Cada fila de @CsvSource es una ejecución: el primer valor va a days, el segundo a expected.
    // Descomenta las siguientes líneas:
    // @ParameterizedTest
    // @CsvSource({
        // "0,  sin multa",
        // "3,  leve",
        // "20, grave",
        // "45, bloqueo"
    // })
    // void categoryByDays(int days, String expected) {
        // assertThat(Fine.category(days)).isEqualTo(expected);
    // }

    // ============================================
    // PASO 3: los valores límite
    // ============================================
    // Los errores viven en los bordes: el último día de cada tramo y el primero del siguiente.
    // Descomenta las siguientes líneas:
    // @ParameterizedTest
    // @CsvSource({
        // "1,  leve",
        // "7,  leve",
        // "8,  grave",
        // "30, grave",
        // "31, bloqueo"
    // })
    // void categoryAtBoundaries(int days, String expected) {
        // assertThat(Fine.category(days)).isEqualTo(expected);
    // }

    // ============================================
    // PASO 4: las entradas no válidas
    // ============================================
    // @ValueSource sirve cuando cada ejecución recibe un solo valor.
    // Descomenta las siguientes líneas:
    // @ParameterizedTest
    // @ValueSource(ints = {-1, -30})
    // void negativeDaysAreRejected(int days) {
        // assertThatThrownBy(() -> Fine.category(days))
                // .isInstanceOf(IllegalArgumentException.class)
                // .hasMessageContaining("negativos");
    // }

    // ============================================
    // PASO 5: válidos y no válidos
    // ============================================
    // Un caso por cada forma distinta de equivocarse, no diez del mismo tipo.
    // Descomenta las siguientes líneas:
    // @ParameterizedTest
    // @ValueSource(strings = {"BK-042", "BK-999"})
    // void acceptsValidCodes(String code) {
        // assertThat(Fine.isValidCode(code)).isTrue();
    // }
//
    // @ParameterizedTest
    // @ValueSource(strings = {"BK-42", "bk-042", "BK-04A", "BK042X", " BK-042"})
    // void rejectsInvalidCodes(String code) {
        // assertThat(Fine.isValidCode(code)).isFalse();
    // }

    // ============================================
    // PASO 6: null, vacío y en blanco
    // ============================================
    // @NullAndEmptySource añade dos ejecuciones: con null y con "".
    // Descomenta las siguientes líneas:
    // @ParameterizedTest
    // @NullAndEmptySource
    // @ValueSource(strings = {"   "})
    // void rejectsMissingCodes(String code) {
        // assertThat(Fine.isValidCode(code)).isFalse();
    // }
}
