package fr.campus.donjondragon;

import fr.campus.donjondragon.personnage.Ennemi;
import fr.campus.donjondragon.personnage.Personnage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Plateau {
    private Personnage personnage;
    private ArrayList<Case> cases;
    private List<Ennemi> ennemiList;
    private List<Bonus> bonusList;
    private Random random;

    // Constructeur modifié pour accepter le personnage
    public Plateau(Personnage personnage) {
        this.personnage = personnage;
        cases = new ArrayList<>(64);
        for (int i = 0; i < 64; i++) {
            cases.add(new Case());
        }
        this.bonusList = new ArrayList<>();
        this.ennemiList = new ArrayList<>(10);
        this.random = new Random();

        initialiserBonus();
        randomiserBonusSurPlateau();
        randomiserEnnemisSurPlateau();
    }

    private void initialiserBonus() {
        bonusList.add(Bonus.creerBonus("Arme", "Massue"));
        bonusList.add(Bonus.creerBonus("Arme", "Épée"));
        bonusList.add(Bonus.creerBonus("Sort", "Éclair"));
        bonusList.add(Bonus.creerBonus("Sort", "Boule de feu"));
        bonusList.add(Bonus.creerBonus("Potion", "Grande potion"));
        bonusList.add(Bonus.creerBonus("Potion", "Petite potion"));
    }

    private void randomiserBonusSurPlateau() {
        Collections.shuffle(bonusList, random);
        for (Bonus bonus : bonusList) {
            boolean placed = false;
            while (!placed) {
                int index = random.nextInt(cases.size());
                Case currentCase = cases.get(index);
                if (currentCase.getBonus() == null && currentCase.getEnnemi() == null) {
                    currentCase.setBonus(bonus);
                    placed = true;
                }
            }
        }
    }

    private void randomiserEnnemisSurPlateau() {
        for (int i = 0; i < 5; i++) {
            String nomEnnemi = "Ennemi " + (i + 1);
            String typeEnnemi = "Type" + (i + 1);
            int degatsEnnemi = random.nextInt(10) + 1;
            Ennemi ennemi = new Ennemi(nomEnnemi, typeEnnemi, degatsEnnemi);

            boolean placed = false;
            while (!placed) {
                int index = random.nextInt(cases.size());
                Case currentCase = cases.get(index);
                if (currentCase.getEnnemi() == null && currentCase.getBonus() == null) {
                    currentCase.setEnnemi(ennemi);
                    ennemiList.add(ennemi);
                    placed = true;
                }
            }
        }
    }

    public Bonus getBonusAtPosition(int index) {
        if (index < 0 || index >= cases.size()) {
            return null;
        }
        return cases.get(index).getBonus();
    }

    public Ennemi getEnnemiAtPosition(int index) {
        if (index < 0 || index >= cases.size()) {
            return null;
        }
        return cases.get(index).getEnnemi();
    }

    public void appliquerBonus(int index) {
        if (index < 0 || index >= cases.size()) {
            System.out.println("Position invalide !");
            return;
        }

        Bonus bonus = getBonusAtPosition(index);
        if (bonus != null) {
            int xpGagne = random.nextInt(5) + 5; // Gain d'XP aléatoire entre 5 et 9
            personnage.gagnerXP(xpGagne);

            switch (bonus.getType()) {
                case "Arme":
                    System.out.println("Vous avez équipé " + bonus.getName());
                    break;
                case "Sort":
                    System.out.println("Vous avez appris le sort " + bonus.getName());
                    break;
                case "Potion":
                    System.out.println("Vous avez consommé la potion " + bonus.getName());
                    break;
                default:
                    System.out.println("Bonus inconnu !");
            }

            System.out.println("Vous avez gagné " + xpGagne + " points d'XP !");
            cases.get(index).setBonus(null);
        } else {
            System.out.println("Aucun bonus trouvé à cette position !");
        }
    }

    public void deplacerPersonnage(int index) {
        if (index < 0 || index >= cases.size()) {
            System.out.println("Position invalide !");
            return;
        }

        Ennemi ennemi = getEnnemiAtPosition(index);
        if (ennemi != null) {
            lancerCombat(ennemi);
        } else {
            System.out.println("Pas d'ennemi ici, continuez votre aventure !");
        }
    }

    private void choixJoueur(Personnage joueur, Ennemi ennemi) {
        Scanner scanner = new Scanner(System.in);
        while (joueur.getpDv() > 0 && ennemi.getpDv() > 0) {
            System.out.println("Choisissez une action : 1 - Attaquer, 2 - Fuir !");
            int choix = scanner.nextInt();

            if (choix == 1) {
                combat(joueur, ennemi);
            } else if (choix == 2) {
                int casesRecule = random.nextInt(6) + 1;
                System.out.println("Vous fuyez et reculez de " + casesRecule + " cases !");
                int nouvellePosition = Math.max(0, joueur.getPosition(personnage) - casesRecule);
                joueur.setPosition(nouvellePosition);
                break;
            } else {
                System.out.println("Choix invalide !");
            }
        }
    }

    private void combat(Personnage joueur, Ennemi ennemi) {
        while (joueur.getpDv() > 0 && ennemi.getpDv() > 0) {
            ennemi.setpDv(ennemi.getpDv() - joueur.getAttaque());
            System.out.println("Vous avez attaqué l'ennemi ! Niveau de vie de l'ennemi : " + ennemi.getpDv());

            if (ennemi.getpDv() <= 0) {
                System.out.println("L'ennemi est vaincu !");
                retirerEnnemiDuPlateau(ennemi);
                break;
            }

            joueur.setpDv(joueur.getpDv() - ennemi.getDegats());
            System.out.println("L'ennemi vous a frappé ! Niveau de vie du joueur : " + joueur.getpDv());

            if (joueur.getpDv() <= 0) {
                System.out.println("Vous avez été vaincu !");
                break;
            }
        }
    }

    private void lancerCombat(Ennemi ennemi) {
        System.out.println("Combat engagé contre " + ennemi.getNom() + " !");
        choixJoueur(personnage, ennemi);
    }

    private void retirerEnnemiDuPlateau(Ennemi ennemi) {
        for (Case currentCase : cases) {
            if (currentCase.getEnnemi() != null && currentCase.getEnnemi().equals(ennemi)) {
                currentCase.setEnnemi(null);
                ennemiList.remove(ennemi);
                System.out.println(ennemi.getNom() + " a été retiré du plateau !");
                break;
            }
        }
    }
}

class Case {
    private Bonus bonus;
    private Ennemi ennemi;

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public Ennemi getEnnemi() {
        return ennemi;
    }

    public void setEnnemi(Ennemi ennemi) {
        this.ennemi = ennemi;
    }
}
