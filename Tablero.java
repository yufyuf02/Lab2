import java.util.ArrayList;
import java.util.Collections;

public class Tablero {
    private Carta[][] cartas;
    private int filas; 
    private int columnas;
    private String[] simbolos = {"♠️", "♦️", "♣️", "♥️", "🩷", "🧡", "💛", "💚", "💙", "🩵", "💜", "🤎", "🖤", "🩶", "🤍", "♟️", "🃏", "🎴", "🀄"}; 

    // Asigna el número de filas y columnas para hacer el Tablero
    public Tablero (int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.cartas = new Carta[filas][columnas];
        iniciarTableroVacio();
    }

    // Muestra el Tablero vacío
    private void iniciarTableroVacio() {
        for (int i=0; i< filas; i++) {
            for (int j=0; j<columnas; j++) {
                cartas[i][j] = new Carta(); // Carta vacía
            }
        }
    }
    public void mostrarTablero() {
        for (int i=0; i< filas; i++) {
            for (int j=0; j<columnas; j++) {
                Carta carta = cartas[i][j];
                if (carta.isRevealed()) {
                    System.out.print (cartas[i][j].getSimbolo() + "");
                } else {
                    System.out.print ("?");
                }
            }
            System.out.println();
        }
    }

    // Asigna aleatoriamente símbolo pares a las cartas
    public void asignarSimbolos(int filas, int columnas) {

        // Crea los simbolos dependiendo del tamaño del Tablero
        ArrayList<String> simbolosParaRepartir = new ArrayList<>();
        for (String simbolo : simbolos) {
            simbolosParaRepartir.add(simbolo);
            simbolosParaRepartir.add(simbolo);  // Hace dos de cada símbolo
        }

        // Mezcla la lista
        Collections.shuffle(simbolosParaRepartir);

        int index = 0;
        for (int i = 0; i<filas; i++) {
            for (int j = 0; j<columnas; j++) {
                cartas[i][j].setSimbolo(simbolosParaRepartir.get(index));
            }
        }
    }

    // Revela la primera carta
    public void revelarCarta1(int fila1, int columna1) {
        cartas[fila1][columna1].reveal();
    }
    // Revela la segunda carta
    public void revelarCarta2(int fila2, int columna2) {
        cartas[fila2][columna2].reveal();
    }

    // Para verificar si todas las cartas son "true" (continúa el while de las rondas)
    public boolean todasMatched() {
        for (int i = 0; i < cartas.length; i++) {
            for (int j = 0; j < cartas[i].length; j++) {
                if (!cartas[i][j].isMatched()) {
                    return false; // Si encuentra una carta no "isMatched"
                }
            }
        }
        return true; // Todas las cartas están "isMatched"
    }
}
