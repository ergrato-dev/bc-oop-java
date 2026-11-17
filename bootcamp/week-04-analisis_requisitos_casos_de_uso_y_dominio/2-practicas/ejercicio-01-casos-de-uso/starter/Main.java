// Ejercicio 01: el caso de uso CU-01 Prestar un libro, convertido en código.
// Cada flujo del caso de uso es una rama de lend(); el mensaje empieza por el flujo que tomó.

String[] codes = {"BK-042", "BK-107", "BK-311"};
int[] copies = {2, 0, 1};
String[] blocked = {"S-07"}; // socios con multa pendiente o con 3 préstamos (RN-03)

int indexOf(String code) {
    for (int i = 0; i < codes.length; i++) {
        if (codes[i].equals(code)) {
            return i;
        }
    }
    return -1;
}

boolean isBlocked(String member) {
    for (String b : blocked) {
        if (b.equals(member)) {
            return true;
        }
    }
    return false;
}

String lend(String member, String code) {
    if (isBlocked(member)) {                     // paso 1: el socio
        return "1a: " + member + " no puede llevarse más libros";
    }
    String wanted = code;                        // paso 2: el código
    int i = indexOf(wanted);
    if (i == -1) {
        return "2a: no existe el libro " + wanted;
    }
    if (copies[i] == 0) {                        // paso 3: queda un ejemplar
        return "3a: no quedan ejemplares de " + wanted;
    }
    copies[i]--;                                 // paso 4: registrar
    return "OK: " + member + " se lleva " + wanted + ", quedan " + copies[i];
}

void main() {
    // ============================================
    // PASO 1: el flujo principal
    // ============================================
    // Todo va bien: socio sin bloqueo, código que existe, quedan ejemplares.
    // Descomenta las siguientes líneas:
    // IO.println(lend("S-01", "BK-042"));

    // ============================================
    // PASO 2: flujo alternativo 2a
    // ============================================
    // Un código que no está en el catálogo.
    // Descomenta las siguientes líneas:
    // IO.println(lend("S-01", "BK-999"));

    // ============================================
    // PASO 3: flujo alternativo 3a
    // ============================================
    // BK-107 existe, pero tiene 0 ejemplares.
    // Descomenta las siguientes líneas:
    // IO.println(lend("S-02", "BK-107"));

    // ============================================
    // PASO 4: flujo alternativo 1a
    // ============================================
    // S-07 está en la lista de socios bloqueados.
    // Descomenta las siguientes líneas:
    // IO.println(lend("S-07", "BK-311"));

    // ============================================
    // PASO 5: el flujo que nadie escribió
    // ============================================
    // El bibliotecario escribe el código como lo lee en la etiqueta.
    // Descomenta las siguientes líneas:
    // IO.println(lend("S-03", " bk-311 "));

    // ============================================
    // PASO 6: la postcondición
    // ============================================
    // Dos préstamos más de BK-042, al que le queda 1 ejemplar.
    // Descomenta las siguientes líneas:
    // IO.println(lend("S-03", "BK-042"));
    // IO.println(lend("S-04", "BK-042"));
    // IO.println("Ejemplares: " + Arrays.toString(copies));
}
