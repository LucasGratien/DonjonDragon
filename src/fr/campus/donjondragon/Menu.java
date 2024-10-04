package fr.campus.donjondragon;

import java.util.Scanner;

public class Menu {


    public void afficherMenu() {
        System.out.println(Ascii.ART4);
        System.out.println("1. Démarrer la partie");
        System.out.println("2. Quitter");
        System.out.print("Choisissez une option: ");
    }


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
