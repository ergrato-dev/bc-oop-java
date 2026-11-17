package hola;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GreeterTest {

    @Test
    void greetsByName() {
        assertThat(Greeter.greet("Ana")).isEqualTo("Hola, Ana");
    }

    // ============================================
    // PASO 5: un test que falla a propósito
    // ============================================
    // El valor esperado está mal escrito (mayúsculas). Lee el mensaje de fallo
    // y después corrige "ANA" por "Ana".
    // Descomenta las siguientes líneas:
    // @Test
    // void trimsSpaces() {
        // assertThat(Greeter.greet("  Ana ")).isEqualTo("Hola, ANA");
    // }

    // ============================================
    // PASO 6: el caso del texto vacío
    // ============================================
    // Descomenta las siguientes líneas:
    // @Test
    // void blankNameGreetsTheWorld() {
        // assertThat(Greeter.greet("   ")).isEqualTo("Hola, mundo");
    // }
}
