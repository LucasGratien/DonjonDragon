import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(); // Création d'une instance de Game

        boolean jouer = true;
        while (jouer) {
            System.out.println("=== Menu ===");
            Date currentDate = new Date();
            System.out.println(currentDate);
            System.out.println("1. Démarrer la partie");
            System.out.println("2. Quitter");
            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    game.resetPosition(); // Réinitialise la position avant chaque partie
                    jouerPartie(game, scanner);
                    break;
                case 2:
                    jouer = false;
                    System.out.println("Merci d'avoir joué !");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez choisir 1 ou 2.");
            }
        }
        scanner.close();
    }

    public static void jouerPartie(Game game, Scanner scanner) {
        System.out.println("Bienvenue dans le jeu !");
        System.out.println("Quel type de personnage voulez-vous créer ?");
        System.out.println("1. Guerrier");
        System.out.println("2. Magicien");

        int choix = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Entrez le nom de votre personnage :");
        String nom = scanner.nextLine();

        Personnage personnage;
        if (choix == 1) {
            personnage = new Guerrier(nom, "Guerrier");
        } else if (choix == 2) {
            personnage = new Magicien(nom, "Magicien");
        } else {
            System.out.println("Choix invalide !");
            return; // Sortir si le choix est invalide
        }

        personnage.afficherInfos();

        // Initialisation du plateau
        Plateau plateau = new Plateau();
        plateau.affichePlateau();

        while (game.getPosition() < 64) { // Continue tant que le joueur n'a pas atteint la fin
            System.out.println("Appuyez sur 'Entrée' pour lancer le dé ou tapez 'exit' pour quitter.");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Merci d'avoir joué !");
                return; // Sortir de la partie
            }

            game.jouer(); // Jouer un tour
        }


        System.out.println("Vous avez terminé la partie !");
    }
}
