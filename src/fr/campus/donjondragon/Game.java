package fr.campus.donjondragon;

import fr.campus.donjondragon.personnage.Guerrier;
import fr.campus.donjondragon.personnage.Magicien;
import fr.campus.donjondragon.personnage.Personnage;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Random random;
    private int position;
    private Menu menu;
    private Scanner scanner;
    private Plateau plateau;
    private Personnage personnage;
    private Connexion connexion = new Connexion();

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

    private Personnage choisirPersonnageExistant() {
        System.out.println("Liste des personnages existants :");
        List<Personnage> heroes = connexion.getHeroes();

        if (heroes.isEmpty()) {
            System.out.println("Aucun personnage existant trouvé.");
            return null;
        }

        for (Personnage Hero : heroes) {
            System.out.println(Hero.getNom() + " (" + Hero.getTypePersonnage() + ")");
        }

        System.out.println("Entrez le nom du personnage que vous souhaitez sélectionner :");
        String inputNom = scanner.nextLine();

        for (Personnage Hero : heroes) {
            if (Hero.getNom().equals(inputNom)) {
                return Hero;
            }
        }

        System.out.println("Nom invalide !");
        return null;
    }


    public Personnage choisirPersonnage() {
        System.out.println("Type de personnage");
        System.out.println("1. Guerrier");
        System.out.println("2. Magicien");
        System.out.println("3. Personnage existant");

        int choix = scanner.nextInt();
        scanner.nextLine();
        Connexion connexion = new Connexion();

        if (choix == 1) {
            System.out.println("Nom de votre guerrier :");
            String nom = scanner.nextLine();
            personnage = new Guerrier(nom, "Guerrier");
        } else if (choix == 2) {
            System.out.println("Nom de votre magicien :");
            String nom = scanner.nextLine();
            personnage = new Magicien(nom, "Magicien");
        } else if (choix == 3) {
            personnage = choisirPersonnageExistant();
            if (personnage != null) {
                System.out.println("Voulez-vous modifier les attributs de ce personnage ? (oui/non)");
                String reponse = scanner.nextLine();
                if (reponse.equalsIgnoreCase("oui")) {
                    String ancienNom = personnage.getNom();

                    System.out.println("Entrez le nouveau niveau de vie :");
                    int niveauVie = scanner.nextInt();
                    personnage.setpDv(niveauVie);
                    scanner.nextLine();
                    System.out.println("Entrez un nouveau nom du personnage :");
                    String nom = scanner.nextLine();
                    personnage.setNom(nom);

                    System.out.println("Entrez la nouvelle attaque :");
                    int attaque = scanner.nextInt();
                    personnage.setAttaque(attaque);

                    connexion.editHero(personnage, ancienNom);
                }
            } else {
                System.out.println("Personnage non trouvé.");
                return null;
            }
        } else {
            System.out.println("Choix invalide !");
            return null;
        }
        if (choix != 3) {
            try {
                connexion.createHero(personnage);
            } catch (Exception e) {
                System.out.println("Erreur lors de l'ajout du personnage dans la base de données : " + e.getMessage());
            }
        }
        return personnage;
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

            plateau.deplacerPersonnage(position - 1);

            int index = position - 1;

            Bonus bonus = plateau.getBonusAtPosition(index);
            if (bonus != null) {
                System.out.println("Vous avez trouvé un bonus : " + bonus.getName());
                plateau.appliquerBonus(index); // Appliquer le bonus à la bonne position
            }

            if (position == 64) {
                System.out.println("Vous avez atteint la case finale " + position + " sur 64 !");
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
