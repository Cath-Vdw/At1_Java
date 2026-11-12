public class Lettre {
    // Attributs privés
    private char caractere;             // la lettre sur une tuile
    private boolean joker;              // si la tuile est un joker
    private int valeur;                 // la valeur correspondant à la lettre
    private char lettreRepresentee;     // la lettre que vaut le joker une fois posé

    // Constructeur
    public Lettre(char caractere, int valeur) {
        this.caractere = caractere;
        this.valeur = valeur;
        lettreRepresentee = ' ';                // vide tant que le joker n'a pas de valeur assignée
        if (caractere == '?') joker = true;     // on donne aux tuiles joker la valeur ?
    }

    // Getters
    public char getCaractere() {
        return caractere;
    }

    public boolean isJoker() {
        return joker;
    }

    public int getValeur() {
        return valeur;
    }

    public char getLettreRepresentee() {
        return lettreRepresentee;
    }

    // Methode permettant de transformer le joker en une autre lettre
    public void setLettreRepresentee(char lettre) {
        // ne fonctionne que si la case est un joker et n'a pas encore de lettre assignée
        if (joker && lettreRepresentee == ' ') this.lettreRepresentee = lettre;
    }
}
