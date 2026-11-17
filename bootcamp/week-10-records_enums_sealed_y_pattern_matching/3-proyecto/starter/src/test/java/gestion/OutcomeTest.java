package gestion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Tests de los resultados de sacar una unidad: la interfaz sellada {@code Outcome} y sus dos
 * records, {@code Taken} y {@code Rejected}.
 */
class OutcomeTest {

    // --- records: Java escribe los métodos ---

    @Test
    void takenAndRejectedAreRecords() {
        assertThat(Taken.class.isRecord()).as("Taken se declara con record").isTrue();
        assertThat(Rejected.class.isRecord()).as("Rejected se declara con record").isTrue();
    }

    @Test
    void aRecordGivesItsComponents() {
        Taken taken = new Taken("BK-042", 1);
        assertThat(taken.code()).isEqualTo("BK-042");
        assertThat(taken.left()).isEqualTo(1);
    }

    @Test
    void twoRecordsWithTheSameComponentsAreEqual() {
        assertThat(new Taken("BK-042", 1))
                .isEqualTo(new Taken("BK-042", 1))
                .hasSameHashCodeAs(new Taken("BK-042", 1))
                .isNotEqualTo(new Taken("BK-042", 0));
    }

    @Test
    void aRecordShowsItsComponents() {
        assertThat(new Rejected("BK-042", "Agotado"))
                .hasToString("Rejected[code=BK-042, reason=Agotado]");
    }

    // --- constructor compacto: valida los componentes ---

    @Test
    void takenRejectsNegativeUnits() {
        assertThatThrownBy(() -> new Taken("BK-042", -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Unidades no válidas: -1");
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "   "})
    void rejectedNeedsAReason(String reason) {
        assertThatThrownBy(() -> new Rejected("BK-042", reason))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Motivo vacío");
    }

    // --- sealed: solo dos clases pueden ser un Outcome ---

    @Test
    void outcomeIsSealedWithTwoPermittedClasses() {
        assertThat(Outcome.class.isSealed()).as("Outcome se declara sealed").isTrue();
        assertThat(Outcome.class.getPermittedSubclasses())
                .containsExactlyInAnyOrder(Taken.class, Rejected.class);
    }

    // --- pattern matching: un switch que desmonta cada record ---

    @Test
    void messageOfATake() {
        assertThat(Outcome.message(new Taken("BK-042", 1))).isEqualTo("BK-042: sale una, quedan 1");
    }

    @Test
    void messageOfARejection() {
        assertThat(Outcome.message(new Rejected("BK-042", "No quedan unidades de BK-042")))
                .isEqualTo("Rechazado: No quedan unidades de BK-042");
    }

    @Test
    void messageCoversEveryCaseWithoutDefault() throws Exception {
        String source = Files.readString(Path.of("src/main/java/gestion/Outcome.java"));
        assertThat(source)
                .as("el switch de message cubre Taken y Rejected sin default")
                .contains("case Taken(")
                .contains("case Rejected(")
                .doesNotContain("default ->")
                .doesNotContain("default:")
                .doesNotContain("instanceof");
    }
}
