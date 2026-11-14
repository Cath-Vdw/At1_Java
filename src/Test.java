public class Test {
    public static void main(String[] args) {
        // Créer la grille
        Grille grille = new Grille();

        // Créer une lettre normale et la poser au centre
        Lettre a = new Lettre('A', 1);
        grille.getCase(7,7).placerLettre(a);

        // Créer une lettre de type joker et lui donner une valeur
        Lettre joker = new Lettre('?', 0);
        joker.setLettreRepresentee('Y');
        grille.getCase(7,8).placerLettre(joker);

        // Afficher la grille
        grille.afficheGrille();
    }
}
