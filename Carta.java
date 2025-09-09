public class Carta {
    private String simbolo;
    private boolean revealed;
    private boolean isMatched;

    public Carta () {
        this.simbolo = ":)";
        this.revealed = false;
        this.isMatched = false;
    }
    public boolean isMatched() {
        return isMatched;
    }

    // Getters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public String getSimbolo() {
        // if (isRevealed == true){
        //     return simbolo;
        // }
        // else{
        //     return "[?]";
        // }
        return revealed ? simbolo : "?";
    }
    public boolean isRevealed() {
        return revealed;
    }
    // Para revelar la carta
    public void reveal(){
        this.revealed = true;
    }
    // Para ocultar la carta
    public void hide(){
        this.revealed = false;
    }
    
    // Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
