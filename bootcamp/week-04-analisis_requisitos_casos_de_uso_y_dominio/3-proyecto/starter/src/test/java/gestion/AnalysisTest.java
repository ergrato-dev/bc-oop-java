package gestion;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Comprueba que docs/analisis.md está completo. No juzga si tu análisis es bueno
 * (eso lo hace el instructor): solo que no falta ninguna sección ni quedan TODO.
 */
class AnalysisTest {

    private static final Path DOC = Path.of("docs", "analisis.md");

    private static String doc() throws IOException {
        return Files.readString(DOC);
    }

    /** Cuántos identificadores distintos hay con ese prefijo: RF-01, RF-02... */
    private static long ids(String prefix) throws IOException {
        return Pattern.compile("\\b" + prefix + "-\\d{2}\\b").matcher(doc()).results()
                .map(MatchResult::group).distinct().count();
    }

    @Test
    @DisplayName("El análisis está en docs/analisis.md")
    void documentExists() {
        assertThat(DOC).isRegularFile();
    }

    @Test
    @DisplayName("No queda ningún TODO de la plantilla")
    void noTodoLeft() throws IOException {
        List<String> pending = doc().lines().filter(line -> line.contains("TODO")).toList();
        assertThat(pending).as("Líneas con TODO en docs/analisis.md").isEmpty();
    }

    @Test
    @DisplayName("Al menos 6 requisitos funcionales")
    void sixFunctionalRequirements() throws IOException {
        assertThat(ids("RF")).as("Requisitos funcionales distintos (RF-01, RF-02...)").isGreaterThanOrEqualTo(6);
    }

    @Test
    @DisplayName("Al menos 2 requisitos no funcionales")
    void twoNonFunctionalRequirements() throws IOException {
        assertThat(ids("RNF")).as("Requisitos no funcionales distintos (RNF-01...)").isGreaterThanOrEqualTo(2);
    }

    @Test
    @DisplayName("Al menos 3 reglas de negocio")
    void threeBusinessRules() throws IOException {
        assertThat(ids("RN")).as("Reglas de negocio distintas (RN-01...)").isGreaterThanOrEqualTo(3);
    }

    @Test
    @DisplayName("Al menos 2 casos de uso")
    void twoUseCases() throws IOException {
        assertThat(ids("CU")).as("Casos de uso distintos (CU-01...)").isGreaterThanOrEqualTo(2);
    }

    @Test
    @DisplayName("Al menos 4 criterios de aceptación")
    void fourAcceptanceCriteria() throws IOException {
        assertThat(ids("CA")).as("Criterios de aceptación distintos (CA-01...)").isGreaterThanOrEqualTo(4);
    }

    @Test
    @DisplayName("Al menos 3 tarjetas CRC")
    void threeCrcCards() throws IOException {
        long cards = Pattern.compile("(?m)^### CRC: ").matcher(doc()).results().count();
        assertThat(cards).as("Encabezados '### CRC: <Clase>'").isGreaterThanOrEqualTo(3);
    }
}
