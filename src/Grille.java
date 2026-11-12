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
        for (int i = 0; i < 15; i++) {
            System.out.println();

            for (int j = 0; j < 15; j++) {
                if (grille[i][j].estOccupee()) {
                    System.out.print(grille[i][j].getLettre().getCaractere() + " ");
                } else System.out.print("- ");
            }
        }
    }
}

