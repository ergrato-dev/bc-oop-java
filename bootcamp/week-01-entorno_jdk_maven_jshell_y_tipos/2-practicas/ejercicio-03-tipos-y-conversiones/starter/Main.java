// Ejercicio 03: tipos y conversiones.
//
// Descomenta cada PASO cuando el README te lo pida y ejecuta:
//     java Main.java

void main() {
    IO.println("Ejercicio 03 · Tipos y conversiones");

    // ============================================
    // PASO 1: los primitivos y sus límites
    // ============================================
    // int guarda enteros de 32 bits; long, de 64. Pasarse del máximo no da error:
    // da la vuelta (overflow) y el resultado es negativo.
    // Descomenta las siguientes líneas:
    // int copies = Integer.MAX_VALUE;
    // IO.println("int máximo: " + copies);
    // IO.println("int máximo + 1: " + (copies + 1));
    // long big = Integer.MAX_VALUE + 1L;
    // IO.println("long: " + big);

    // ============================================
    // PASO 2: double no es exacto
    // ============================================
    // 0.1 no tiene representación binaria exacta. Dos double se comparan
    // con una tolerancia, nunca con ==.
    // Descomenta las siguientes líneas:
    // double sum = 0.1 + 0.2;
    // IO.println("0.1 + 0.2 = " + sum);
    // IO.println("¿== 0.3? " + (sum == 0.3));
    // IO.println("¿casi 0.3? " + (Math.abs(sum - 0.3) < 1e-9));

    // ============================================
    // PASO 3: división entera y casting
    // ============================================
    // Entre dos int, / descarta los decimales. (double) convierte antes de dividir;
    // (int) trunca, no redondea.
    // Descomenta las siguientes líneas:
    // IO.println("7 / 2 = " + (7 / 2));
    // IO.println("7 % 2 = " + (7 % 2));
    // IO.println("(double) 7 / 2 = " + ((double) 7 / 2));
    // IO.println("(int) 4.99 = " + (int) 4.99);
    // IO.println("Math.round(4.5) = " + Math.round(4.5));

    // ============================================
    // PASO 4: de texto a número
    // ============================================
    // Lo que llega del teclado o de un archivo es String. parseInt y parseDouble
    // convierten; si el texto no es un número, lanzan NumberFormatException.
    // Descomenta las siguientes líneas:
    // int year = Integer.parseInt("1967");
    // double price = Double.parseDouble("12,5".replace(',', '.'));
    // IO.println("Año + 1: " + (year + 1));
    // IO.println("Precio x 2: " + (price * 2));
    // IO.println("Texto + número: " + "1967" + 1);

    // ============================================
    // PASO 5: char, boolean y var
    // ============================================
    // char es un carácter Unicode y también un número. var deduce el tipo
    // del valor inicial: sigue siendo un tipo fijo.
    // Descomenta las siguientes líneas:
    // char grade = 'B';
    // IO.println("Siguiente letra: " + (char) (grade + 1));
    // boolean available = price > 10 && year < 2000;
    // IO.println("¿Disponible? " + available);
    // var title = "Cien años de soledad";
    // IO.println("Letras: " + title.length());

    // ============================================
    // PASO 6: String: comparar y formatear
    // ============================================
    // equals compara el contenido; == compara si es el mismo objeto.
    // String.format con Locale.ROOT usa siempre punto decimal.
    // Descomenta las siguientes líneas:
    // String typed = new String("BK-042");
    // IO.println("¿== ? " + (typed == "BK-042"));
    // IO.println("¿equals? " + typed.equals("BK-042"));
    // IO.println(String.format(Locale.ROOT, "%s: %.2f USD", "Precio", price));
    // IO.println(String.format(Locale.ROOT, "%05d", 42));
}
