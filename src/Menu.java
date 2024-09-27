import java.util.Scanner;

public class Menu {

    // Affiche le menu principal
    public void afficherMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Démarrer la partie");
        System.out.println("2. Quitter");
        System.out.print("Choisissez une option: ");
    }

    // Lit le choix de l'utilisateur
    public int lireChoix(Scanner scanner) {
        int choix = -1;
        try {
            choix = scanner.nextInt();
            scanner.nextLine(); // Consomme la ligne vide après l'entier
        } catch (Exception e) {
            System.out.println("Erreur de saisie. Veuillez entrer un chiffre.");
            scanner.nextLine(); // Vide la ligne en cas d'erreur
        }
        return choix;
    }

    // Ferme le scanner (optionnel si tu gères le scanner dans la classe Game)
    public void closeScanner(Scanner scanner) {
        if (scanner != null) {
            scanner.close();
        }
    }
}
