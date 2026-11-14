import java.util.*;

public class Grille {
    // Attributs privés
    private Case[][] grille = new Case[15][15];

    // Constructeur
    public Grille() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                grille[i][j] = new Case();
            }
        }
    }

    // Getter
    public Case getCase(int ligne, int colonne) {
        return grille[ligne][colonne];
    }

    // Méthode permettant d'afficher la grille
    public void afficheGrille() {
        System.out.printf("   "); // décalage pour les numéros de ligne
        for (int i = 0; i < 15; i++) {
            System.out.printf("%c ", (char) ('A' + i)); // transforme les chiffres en caractères pour les numéros de colonne
        }
        for (int i = 0; i < 15; i++) {
            System.out.println();
            System.out.printf("%02d ", (i + 1));
            for (int j = 0; j < 15; j++) {
                if (grille[i][j].estOccupee()) {
                    System.out.print(grille[i][j].getLettre().getCaractere() + " ");
                } else System.out.print("- ");
            }
        }
    }

    // Méthode permettant de placer un mot
    public boolean placerMot(List<Lettre> tuiles, int ligneDep, int colonneDep, boolean horizontal) {
        if (estPlacementValide(tuiles, ligneDep, colonneDep, horizontal)) {
            List<int[]> positions = positionTuiles(tuiles, ligneDep, colonneDep, horizontal);
            int count = 0;
            for (int[] p : positions) {
                Case c = getCase(p[0], p[1]);
                c.placerLettre(tuiles.get(count));
                count++;
            }
            return true;
        }
        return false;
    }

    // Méthode permettant de s'assurer que le mot peut être placé en l'état
    public boolean estPlacementValide(List<Lettre> tuiles, int ligneDep, int colonneDep, boolean horizontal) {
        // PAS valide si :
        if (!resteDanslaGrille(tuiles, ligneDep, colonneDep, horizontal)) return false; // 1) on sort de la grille
        if (!getCase(7, 7).estOccupee()) { // 2) premier coup
            if (!passeParLeCentre(tuiles, ligneDep, colonneDep, horizontal))
                return false; // et que la case centrale n'est pas occupé à la fin
        } else {
            if (!entreEnContact(tuiles, ligneDep, colonneDep, horizontal))
                return false; // 3) Aucun contact avec d'autres mots
        }
        return true;
    }

    // Méthode vérifiant si une case est dans la grille ou non
    private boolean estDansLaGrille(int ligne, int colonne) {
        if (ligne < 0 || ligne >= 15 || colonne < 0 || colonne >= 15) return false; // sort de la grille
        return true;
    }

    // Méthode permettant de renvoyer les positions des tuiles en tableaux multidimensionnels à deux entrées
    // p. ex [7,5], [7,6], [7,8]
    private List<int[]> positionTuiles(List<Lettre> tuiles, int ligne, int colonne, boolean horizontal) {
        List<int[]> positions = new ArrayList<>();
        int count = tuiles.size();
        while (count > 0) {
            if (!estDansLaGrille(ligne, colonne))
                return positions; // renverra une liste plus courte, ce qui indique qu'on sort de la grille
            Case c = getCase(ligne, colonne);
            if (!c.estOccupee()) {
                count--;
                positions.add(new int[]{ligne, colonne});
            }
            if (horizontal) colonne++;
            else ligne++;
        }
        return positions;
    }

    // Méthode vérifiant si le mot posé passe par la case centrale
    private boolean passeParLeCentre(List<Lettre> tuiles, int ligneDep, int colonneDep, boolean horizontal) {
        List<int[]> positions = positionTuiles(tuiles, ligneDep, colonneDep, horizontal);
        for (int[] p : positions) {
            if (p[0] == 7 && p[1] == 7) return true;
        }
        return false;
    }

    //  Méthode vérifiant si la case a un contact avec une case voisine
    private boolean contacteAutreTuile(int ligne, int colonne) {
        return estDansLaGrille(ligne - 1, colonne) && getCase(ligne - 1, colonne).estOccupee() // case du dessus
                || estDansLaGrille(ligne + 1, colonne) && getCase(ligne + 1, colonne).estOccupee() // case du dessous
                || estDansLaGrille(ligne, colonne - 1) && getCase(ligne, colonne - 1).estOccupee() // case de gauche
                || estDansLaGrille(ligne, colonne + 1) && getCase(ligne, colonne + 1).estOccupee(); // case de droite
    }

    // Méthode permettant de vérifier si le mot qu'on pose entre en contact avec une autre case
    private boolean entreEnContact(List<Lettre> tuiles, int ligneDep, int colonneDep, boolean horizontal) {
        List<int[]> positions = positionTuiles(tuiles, ligneDep, colonneDep, horizontal);
        for (int[] p : positions) {
            if (contacteAutreTuile(p[0], p[1])) return true;
        }
        return false;
    }

    // Méthode permettant de s'assurer que le mot reste dans la grille
    private boolean resteDanslaGrille(List<Lettre> tuiles, int ligneDep, int colonneDep, boolean horizontal) {
        List<int[]> positions = positionTuiles(tuiles, ligneDep, colonneDep, horizontal);
        return positions.size() == tuiles.size();
    }


}

