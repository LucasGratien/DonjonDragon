package fr.campus.donjondragon;

import java.util.Scanner;

public class Menu {


    public void afficherMenu() {
        System.out.println("=== fr.campus.donjondragon.Menu ===");
        System.out.println("1. Démarrer la partie");
        System.out.println("2. Quitter");
        System.out.print("Choisissez une option: ");
    }

    // Lit le choix de l'utilisateur
    public int lireChoix(Scanner scanner) {
        int choix = -1;
        try {
            choix = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Erreur de saisie. Veuillez entrer un chiffre.");
            scanner.nextLine();
        }
        return choix;
    }


    public void closeScanner(Scanner scanner) {
        if (scanner != null) {
            scanner.close();
        }
    }
}
