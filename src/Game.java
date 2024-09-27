import java.util.Random;
import java.util.Scanner;

public class Game {
    private Random random;
    private int position;
    private Menu menu;
    private Scanner scanner;
    private Plateau plateau;
    private Personnage personnage;

    public Game() {
        random = new Random();
        position = 0;
        menu = new Menu();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        boolean jouer = true;
        while (jouer) {
            menu.afficherMenu();
            int choix = menu.lireChoix(scanner);
            switch (choix) {
                case 1:
                    jouerPartie();
                    resetPosition();
                    break;
                case 2:
                    jouer = false;
                    System.out.println("Merci d'avoir joué !");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez choisir 1 ou 2.");
            }
        }
        menu.closeScanner(scanner);
    }

    private void jouerPartie() {
        System.out.println("Bienvenue dans le jeu !");
        personnage = choisirPersonnage();
        if (personnage == null) {
            System.out.println("Erreur lors du choix du personnage.");
            return;
        }

        personnage.afficherInfos();
        plateau = new Plateau(personnage);

        while (position < 64) {
            System.out.println("Appuyez sur 'Entrée' pour lancer le dé ou tapez 'exit' pour quitter.");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Merci d'avoir joué !");
                return;
            }

            jouerTour();
        }

        System.out.println("Partie terminée!");
    }

    private Personnage choisirPersonnage() {
        System.out.println("Type de personnage");
        System.out.println("1. Guerrier");
        System.out.println("2. Magicien");

        int choix = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nom de votre personnage :");
        String nom = scanner.nextLine();

        if (choix == 1) {
            return new Guerrier(nom, "Guerrier");
        } else if (choix == 2) {
            return new Magicien(nom, "Magicien");
        } else {
            System.out.println("Choix invalide !");
            return null;
        }
    }

    private void jouerTour() {
        try {
            int resultat = lancer();
            System.out.println("Vous avez obtenu : " + resultat);
            position += resultat;

            if (position > 64) {
                position = 64;
            }
            System.out.println("XP actuel : " + personnage.getXpPerso());
            Bonus bonus = plateau.getBonusAtPosition(position);
            if (bonus != null) {
                System.out.println("Vous avez trouvé un bonus : " + bonus.getName());
                plateau.AppliqBonus(bonus);
            }

            if (position == 64) {
                System.out.println("Vous avez atteint la case " + position + " sur 64 !");
            } else {
                System.out.println("Vous êtes maintenant à la case " + position + " sur 64.");
            }
        } catch (Exception e) {
            position = 64;
            System.out.println(e.getMessage());
            System.out.println("Votre position est à la case " + position + ".");
        }
    }

    public int lancer() {
        return random.nextInt(6) + 1;
    }

    public void resetPosition() {
        position = 0;
    }
}
