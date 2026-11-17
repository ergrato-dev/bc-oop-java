package gestion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/** Tus tests, con valores de tu dominio calculados a mano. Sustituye este ejemplo. */
class MyDomainTest {

    @Test
    void exampleReplaceMe() {
        assertThat(Fields.describe("Precio", Fields.parseAmount("8,99"), "USD"))
                .isEqualTo("Precio: 8.99 USD");
    }
}
