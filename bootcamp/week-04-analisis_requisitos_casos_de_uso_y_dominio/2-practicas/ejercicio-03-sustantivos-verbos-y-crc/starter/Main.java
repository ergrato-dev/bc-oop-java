// Ejercicio 03: tres arrays paralelos que son, en realidad, un solo sustantivo: el libro.
// La posición i de cada array habla del mismo libro. Nada en Java lo garantiza: lo haces tú.

String[] codes = {"BK-311", "BK-042", "BK-107"};
String[] titles = {"Rayuela", "Ficciones", "El túnel"};
String[] authors = {"Cortázar", "Borges", "Sábato"};

String describe(int i) {
    return codes[i] + " · " + titles[i] + " · " + authors[i];
}

void printAll() {
    for (int i = 0; i < codes.length; i++) {
        IO.println(describe(i));
    }
    IO.println("--");
}

void main() {
    // ============================================
    // PASO 1: el catálogo
    // ============================================
    // Cada línea junta la posición i de los tres arrays.
    // Descomenta las siguientes líneas:
    // printAll();

    // ============================================
    // PASO 2: dar de alta un libro
    // ============================================
    // Un libro nuevo obliga a hacer crecer los tres arrays a la vez.
    // Descomenta las siguientes líneas:
    // codes = Arrays.copyOf(codes, 4);
    // codes[3] = "BK-500";
    // titles = Arrays.copyOf(titles, 4);
    // titles[3] = "Pedro Páramo";
    // authors = Arrays.copyOf(authors, 4);
    // printAll();

    // ============================================
    // PASO 3: ordenar por título
    // ============================================
    // Arrays.sort ordena un array. Solo uno.
    // Descomenta las siguientes líneas:
    // Arrays.sort(titles);
    // printAll();
}
