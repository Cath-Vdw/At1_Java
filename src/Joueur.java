public class Joueur {
    // Attributs privés
    private String nom;
    private int score;

    // Constructeur
    public Joueur(String nom) {
        this.nom = nom;
        this.score = 0;
    }

    // Getter
    public String getNom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    // Méthode qui ajoute les points du coup au score total
    public void augmenteScore(int pointsCoup) {
        score += pointsCoup;
    }
}
