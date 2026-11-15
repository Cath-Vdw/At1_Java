import java.util.*;

public class Chevalet {
    // Attribut privé
    private List<Lettre> tuiles;

    // Constructeur
    public Chevalet() {
        tuiles = new ArrayList<Lettre>();
    }

    // Méthode qui affiche le chevalet
    public void afficheChevalet() {
        System.out.println("Chevalet: ");
        for (Lettre l : tuiles) {
            if (l.estJoker()) System.out.printf("joker | ");
            else System.out.printf(l.getCaractere() + " | ");
        }
    }

    // Méthode qui vérifie si le joueur possède bien la tuile qu'il veut jouer
    public boolean possedeTuiles(List<Lettre> lettresCherchees) {
        return false;
    }

    // Méthode qui retire les tuiles jouées
    public void retireTuile(List<Lettre> tuilesJoues){

    }

    // Méthode qui remplit le chevalet à la fin du tour
    public void remplitChevalet(Sac sac){

    }
}
