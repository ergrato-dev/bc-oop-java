// Ejercicio 01: records, clases que solo llevan datos.

class Main {

    void main() {
        // ============================================
        // PASO 1: una clase de datos escrita a mano
        // ============================================
        // Descomenta las siguientes líneas:
        // LoanCard a = new LoanCard("BK-042", "Ana", 14);
        // LoanCard b = new LoanCard("BK-042", "Ana", 14);
        // IO.println(a.getCode() + " para " + a.getMember());
        // IO.println(a);
        // IO.println(a.equals(b));

        // ============================================
        // PASO 2: el mismo dato, como record
        // ============================================
        // Descomenta las siguientes líneas:
        // Loan first = new Loan("BK-042", "Ana", 14);
        // Loan second = new Loan("BK-042", "Ana", 14);
        // IO.println(first.code() + " para " + first.member());
        // IO.println(first);
        // IO.println(first.equals(second));

        // ============================================
        // PASO 3: los componentes no cambian
        // ============================================
        // Descomenta la siguiente línea:
        // first.days = 21;

        // ============================================
        // PASO 4: un record no tiene getters
        // ============================================
        // Descomenta la siguiente línea:
        // IO.println(first.getCode());

        // ============================================
        // PASO 5: un constructor compacto que valida
        // ============================================
        // Descomenta el constructor compacto de Loan, más abajo.
        // Descomenta las siguientes líneas:
        // try {
        //     new Loan("BK-107", "Luis", 0);
        // } catch (IllegalArgumentException e) {
        //     IO.println("Rechazado: " + e.getMessage());
        // }

        // ============================================
        // PASO 6: cambiar un record es crear otro
        // ============================================
        // Descomenta las siguientes líneas:
        // Loan longer = first.extended(7);
        // IO.println(longer);
        // IO.println(first);
    }
}

// Una clase de datos escrita a mano: atributos, constructor y getters. Sin equals ni toString.
class LoanCard {

    private final String code;
    private final String member;
    private final int days;

    LoanCard(String code, String member, int days) {
        this.code = code;
        this.member = member;
        this.days = days;
    }

    String getCode() {
        return code;
    }

    String getMember() {
        return member;
    }

    int getDays() {
        return days;
    }
}

// Lo mismo en una línea: Java escribe los atributos, el constructor, code(), member(), days(),
// equals, hashCode y toString.
record Loan(String code, String member, int days) {

    // PASO 5: descomenta este constructor compacto.
    // Loan {
    //     if (days <= 0) {
    //         throw new IllegalArgumentException("Días no válidos: " + days);
    //     }
    // }

    // Un record no cambia: para alargar el préstamo, crea uno nuevo.
    Loan extended(int extra) {
        return new Loan(code, member, days + extra);
    }
}
