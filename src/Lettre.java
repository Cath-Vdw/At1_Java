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
        lettreRepresentee = ' ';         // vide tant que le joker n'a pas de valeur assignée
        if (caractere == '?')
            joker = true;                // tuiles joker ont la valeur ? pour les différencier des autres
    }

    // Getters
    public char getCaractere() {
        if (joker && lettreRepresentee != ' ')
            return lettreRepresentee;  // si le joker a été assigné,c'est cette lettre qu'onrenvoie
        else return caractere;
    }

    public boolean estJoker() {
        return joker;
    }

    public int getValeur() {
        return valeur;
    }

    public char getLettreRepresentee() {
        return lettreRepresentee;
    }

    // Transforme le joker en lettre si la case est un joker et n'a pas encore de lettre
    public void setLettreRepresentee(char lettre) {
        if (joker && lettreRepresentee == ' ') this.lettreRepresentee = lettre;
    }
}
