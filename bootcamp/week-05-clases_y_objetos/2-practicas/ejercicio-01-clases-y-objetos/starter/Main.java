// Ejercicio 01: una clase es el molde; cada new fabrica un objeto con sus propios datos.

class Book {
    String code;
    String title;
    int copies;

    // PASO 3: un método de instancia usa los datos del objeto sobre el que se llama.
    // Descomenta las siguientes líneas:
    // String describe() {
        // return code + " · " + title + " · ejemplares: " + copies;
    // }

    // PASO 4: un método también puede cambiar los datos del objeto.
    // Descomenta las siguientes líneas:
    // String lend() {
        // if (copies == 0) {
            // return "No quedan ejemplares de " + code;
        // }
        // copies--;
        // return "Prestado " + code + ", quedan " + copies;
    // }
}

class Member {
    String id;
    String name;

    // PASO 5: el constructor da valor a los atributos al crear el objeto.
    // Descomenta las siguientes líneas:
    // Member(String id, String name) {
        // id = id;
        // this.name = name;
    // }
}

void main() {
    // ============================================
    // PASO 1: un objeto recién creado
    // ============================================
    // new reserva un objeto Book; sus atributos empiezan con el valor por defecto de su tipo.
    // Descomenta las siguientes líneas:
    // Book empty = new Book();
    // IO.println(empty.code + " · " + empty.title + " · " + empty.copies);

    // ============================================
    // PASO 2: dos objetos de la misma clase
    // ============================================
    // Cada objeto guarda sus propios datos: cambiar uno no toca al otro.
    // Descomenta las siguientes líneas:
    // Book rayuela = new Book();
    // rayuela.code = "BK-311";
    // rayuela.title = "Rayuela";
    // rayuela.copies = 1;
    // Book ficciones = new Book();
    // ficciones.code = "BK-042";
    // ficciones.title = "Ficciones";
    // ficciones.copies = 2;
    // IO.println(rayuela.title + " tiene " + rayuela.copies + "; " + ficciones.title + " tiene " + ficciones.copies);

    // ============================================
    // PASO 3: describe()
    // ============================================
    // El mismo método da resultados distintos según el objeto que va delante del punto.
    // Descomenta las siguientes líneas:
    // IO.println(rayuela.describe());
    // IO.println(ficciones.describe());

    // ============================================
    // PASO 4: lend()
    // ============================================
    // Cada llamada cambia el estado de rayuela: el siguiente resultado depende del anterior.
    // Descomenta las siguientes líneas:
    // IO.println(rayuela.lend());
    // IO.println(rayuela.lend());
    // IO.println(ficciones.describe());

    // ============================================
    // PASO 5: un constructor
    // ============================================
    // Con un constructor, el objeto nace con sus datos en una sola línea.
    // Descomenta las siguientes líneas:
    // Member ana = new Member("S-01", "Ana");
    // IO.println(ana.id + " · " + ana.name);

    // ============================================
    // PASO 6: el constructor vacío ya no existe
    // ============================================
    // Descomenta la siguiente línea, ejecuta, lee el error y vuelve a comentarla:
    // Member nobody = new Member();
}
