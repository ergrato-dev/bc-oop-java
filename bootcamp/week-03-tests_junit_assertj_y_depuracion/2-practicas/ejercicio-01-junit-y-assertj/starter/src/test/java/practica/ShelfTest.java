package practica;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShelfTest {

    // ============================================
    // PASO 1: un test que ya funciona
    // ============================================
    // Llama a un método con un valor conocido y comprueba el resultado.
    @Test
    void normalizesSpacesAndCase() {
        assertThat(Shelf.normalize(" bk-042 ")).isEqualTo("BK-042");
    }

    // ============================================
    // PASO 2: la misma comprobación con JUnit
    // ============================================
    // assertEquals viene con JUnit: primero el esperado, después el real.
    // Descomenta las siguientes líneas:
    // @Test
    // void normalizesWithAssertEquals() {
        // assertEquals("BK-042", Shelf.normalize(" bk-042 "));
    // }

    // ============================================
    // PASO 3: un test que falla a propósito
    // ============================================
    // El valor esperado está mal: lee el mensaje de fallo y corrígelo.
    // Descomenta las siguientes líneas:
    // @Test
    // void freeRoom() {
        // assertThat(Shelf.free(10, 3)).isEqualTo(3);
    // }

    // ============================================
    // PASO 4: textos y arrays
    // ============================================
    // Varias comprobaciones encadenadas sobre el mismo valor.
    // Descomenta las siguientes líneas:
    // @Test
    // void normalizedCodeShape() {
        // assertThat(Shelf.normalize(" bk-042 ")).startsWith("BK").contains("-").hasSize(6);
    // }
//
    // @Test
    // void splitsAndNormalizesCodes() {
        // assertThat(Shelf.codes("bk-042, bk-107 ,bk-311"))
                // .hasSize(3)
                // .containsExactly("BK-042", "BK-107", "BK-311");
    // }

    // ============================================
    // PASO 5: decimales con margen
    // ============================================
    // 1 de 3 es 33.333...: se compara con un margen, no con isEqualTo.
    // Descomenta las siguientes líneas:
    // @Test
    // void occupancyOfOneInThree() {
        // assertThat(Shelf.occupancy(3, 1)).isCloseTo(33.33, within(0.01));
    // }

    // ============================================
    // PASO 6: comprobar que lanza una excepción
    // ============================================
    // La llamada va dentro de una lambda () -> ... para que AssertJ la ejecute y capture el error.
    // Descomenta las siguientes líneas:
    // @Test
    // void freeRejectsOverflow() {
        // assertThatThrownBy(() -> Shelf.free(10, 12))
                // .isInstanceOf(IllegalArgumentException.class)
                // .hasMessage("Ocupación fuera de rango: 12");
    // }

    // ============================================
    // PASO 7: preparar, actuar, comprobar
    // ============================================
    // Las tres partes de un test, separadas, y un nombre legible con @DisplayName.
    // Descomenta las siguientes líneas:
    // @Test
    // @DisplayName("un estante lleno no tiene huecos")
    // void fullShelfHasNoRoom() {
        // // Arrange: los datos de partida
        // int capacity = 8;
//
        // // Act: la llamada que se prueba
        // int room = Shelf.free(capacity, capacity);
//
        // // Assert: el resultado esperado
        // assertThat(room).isZero();
    // }
}
