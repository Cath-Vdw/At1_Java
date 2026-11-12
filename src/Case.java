public class Case {
    // Attribut privé
    private Lettre lettre;          // type Lettre

    // Constructeur
    public Case() {
        this.lettre = null;         // grille vide au départ
    }

    // Getter
    public Lettre getLettre() {
        return lettre;
    }

    // Renvoie true si la case est occupée
    public boolean estOccupee() {
        return this.lettre != null;
    }

    // Place la lettre sur une case
    public void placerLettre(Lettre l) {
        this.lettre = l;
    }

    // Retirer la lettre d'une case
    public void retirerLettre() {
        this.lettre = null;
    }

}
