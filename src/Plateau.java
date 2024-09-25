public class Plateau {
    private int[] plateau; // Tableau linéaire de 64 cases représentant le plateau de jeu

    // Constructeur qui initialise le tableau de 64 cases
    public Plateau() {
        plateau = new int[64]; // Le tableau contient 64 éléments, indexés de 0 à 63
    }

    public void affichePlateau() {
        for (int i = 0; i < 64; i++) { // Boucle sur chaque case du tableau
            System.out.print(plateau[i] + " "); // Affiche chaque case séparée par un espace
        }
        System.out.println(); // Saut de ligne à la fin de l'affichage du plateau
    }
}
