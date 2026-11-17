package practica;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RenewalTest {

    // ============================================
    // PASO 1: CA-01, el flujo principal
    // ============================================
    // Dado un préstamo sin renovar, sin reservas y a tiempo,
    // cuando el socio lo renueva, entonces puede.
    // Descomenta las siguientes líneas:
    // @Test
    // @DisplayName("CA-01 un préstamo sin renovar, sin reservas y a tiempo se renueva")
    // void freshLoanCanBeRenewed() {
        // assertThat(Renewal.canRenew(0, 0, 0)).isTrue();
    // }

    // ============================================
    // PASO 2: CA-02, el límite de renovaciones
    // ============================================
    // Dado un préstamo ya renovado 2 veces, cuando lo renueva, entonces no puede.
    // Descomenta las siguientes líneas:
    // @Test
    // @DisplayName("CA-02 un préstamo renovado 2 veces no se renueva más")
    // void loanRenewedTwiceCannotBeRenewed() {
        // assertThat(Renewal.canRenew(2, 0, 0)).isFalse();
    // }

    // ============================================
    // PASO 3: CA-03, el libro reservado
    // ============================================
    // Dado que otro socio ha reservado el libro, cuando lo renueva, entonces no puede.
    // Descomenta las siguientes líneas:
    // @Test
    // @DisplayName("CA-03 un libro reservado por otro socio no se renueva")
    // void reservedBookCannotBeRenewed() {
        // assertThat(Renewal.canRenew(0, 1, 0)).isFalse();
    // }

    // ============================================
    // PASO 4: CA-04, el retraso
    // ============================================
    // Dado un préstamo con 3 días de retraso, cuando lo renueva, entonces no puede.
    // Descomenta las siguientes líneas:
    // @Test
    // @DisplayName("CA-04 un préstamo con retraso no se renueva")
    // void overdueLoanCannotBeRenewed() {
        // assertThat(Renewal.canRenew(0, 0, 3)).isFalse();
    // }

    // ============================================
    // PASO 5: CA-05, la nueva fecha
    // ============================================
    // Dado un préstamo que vence el día 15, cuando lo renueva, entonces vence el día 22.
    // Descomenta las siguientes líneas:
    // @Test
    // @DisplayName("CA-05 renovar suma 7 días a la fecha de devolución")
    // void renewalAddsSevenDays() {
        // assertThat(Renewal.newDueDay(15)).isEqualTo(22);
    // }

    // ============================================
    // PASO 6: todos los criterios en una tabla
    // ============================================
    // Las filas que solo cambian los datos van juntas. as(criterion) pone el criterio
    // en el mensaje de fallo; {0} lo pone en el nombre que muestra tu editor.
    // Descomenta las siguientes líneas:
    // @ParameterizedTest(name = "{0}")
    // @CsvSource({
        // "CA-01 todo en orden,          0, 0, 0, true",
        // "CA-02 última renovación,      1, 0, 0, true",
        // "CA-02 sin renovaciones,       2, 0, 0, false",
        // "CA-03 reservado,              0, 1, 0, false",
        // "CA-04 un día tarde,           0, 0, 1, false",
        // "CA-03 y CA-04 a la vez,       1, 2, 5, false"
    // })
    // void canRenew(String criterion, int renewals, int reservations, int overdueDays,
            // boolean expected) {
        // assertThat(Renewal.canRenew(renewals, reservations, overdueDays)).as(criterion)
                // .isEqualTo(expected);
    // }
}
