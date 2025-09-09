
// Autora: Yu-Fong Chen
// Fecha: 05/11/2025
// Descripción: Lab 2. Arreglos y excepciones


import java.util.Scanner;
public class Main {
    public static void main(String [] args) {
        Scanner teclado = new Scanner(System.in);
        int filas = 0;
        int columnas = 0;
        int seleccion = 0;
        int ronda = 1;      // Lleva control de las rondas
        boolean juegoTerminado = false;

        System.out.print(
            "\n** Bienvenidos a MEMORIA **\n");

        // Ingresar el tamaño del tablero
        while (filas >= 7 || columnas >= 7 || filas <= 0 || columnas <= 3 ||
        (filas == 1 && columnas <= 3) || (filas % 2 != 0 && columnas % 2 != 0)) {
        System.out.print(
            "\nVamos a seleccionar el tamaño del tablero.\n" +
            "Se pueden desde 1x4, hasta 6x6 con al menos\n" + 
            "una fila o columna siendo un número par.\n" +
            "¿Cuántas filas tendrá su tablero? ");
            filas = teclado.nextInt();
        System.out.print(
            "¿Cuántas columnas tendrá su tablero? ");
            columnas = teclado.nextInt();
        }

        // Ingresar los nombre de los jugadores
        System.out.print(
            "\nSe puede jugar con dos jugadores.\n" +
            "¿Cuál es el nombre del jugador #1? ");
            teclado.nextLine();              // >:(
            String nombre1 = teclado.nextLine();
        System.out.print(
            "¿Cuál es el nombre del jugador #2? ");
            String nombre2 = teclado.nextLine();
        
        // Selecciona quién va a ir primero
        String seleccionado = Math.random() < 0.5 ? nombre1 : nombre2;
        System.out.print(
            "De manera aleatoria, " + seleccionado + " va a ir primero.\n"
        );
        // Inicio de las rondas
        System.out.print(
            "\n**** START ****\n"
        );
        Tablero tablero = new Tablero(filas, columnas);
        tablero.asignarSimbolos(filas, columnas);

        while (!juegoTerminado) {
            System.out.print("Ronda #" + ronda + "\n");
            tablero.mostrarTablero();
            
            // Ingresar la fila y columna de las dos cartas
            System.out.print("\nQué carta quiere mostrar primero? (fila,columna) Ej. '3,4' ");
            String carta1 = teclado.nextLine();         // Usar String y ya que es un Array/Arreglo de letras
            System.out.print("\nQué carta quiere mostrar segundo? (fila,columna) Ej. '4,4' ");
            String carta2 = teclado.nextLine();
            String[] partes1 = carta1.split(",");       // El 'split' no toma en cuenta la ',' y lo asigna a 'partes', se puede modificar el 'carta1', pero ahorita no es necesario.
            String[] partes2 = carta2.split(",");
            int fila1 = Integer.parseInt(partes1[0]);   // Asigna el valor de la fila en partes 1.
            int columna1 = Integer.parseInt(partes1[1]);
            int fila2 = Integer.parseInt(partes2[0]);
            int columna2 = Integer.parseInt(partes2[1]);
            
            // Mostrar las cartas elegidas
            tablero.revelarCarta1(fila1, columna1);
            tablero.revelarCarta2(fila2, columna2);
            tablero.mostrarTablero();

            juegoTerminado = tablero.todasMatched();
            ronda++;
        }

//        // Fin de la partida
//        System.out.print(
//            "El ganador es " + "\n" + // nombre del que ganó
//            nombre1 + " va ganando " + // número de rondas
//            " y " + nombre2  + " va ganando " // número de rondas
//        );
//
//        while (seleccion >= 3 || seleccion <= 0); // !! No entiendo pq no entra a este while.
//            System.out.print(
//            "¿Quieren jugar otra vez? (1) Sí (2) No");
//            seleccion = teclado.nextInt();
//
//        if (seleccion == 1) {
//            System.out.print(":)");
//        } else {
//            return;
//        }
    }
}
