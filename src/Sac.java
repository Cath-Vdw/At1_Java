import java.util.ArrayList;
import java.util.List;

public class Sac {
    // Attributs privés
    private List<Lettre> sac;

    // Constructeur
    public Sac() {
        sac = new ArrayList<>();
        remplitSac();
    }

    // Méthode qui remplit le sac au début de la partie
    private void remplitSac() {
    }

    // Méthode qui vérifie le nombre de tuiles qui restent dans le sac
    public int tuilesRestantes() {
        return sac.size();
    }

    // Méthode qui vérifie s'il reste des tuiles dans le sac
    public boolean estVide() {
        return sac.size() == 0;
    }

    // Méthode qui permet de piocher des tuiles s'il en reste dans le sac
    public Lettre piocheTuile() {
        return null;
    }
}
