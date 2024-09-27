import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Plateau {
    private Personnage personnage;
    private List<Bonus> bonusList;
    private Random random;

    public Plateau(Personnage personnage) {
        this.personnage = personnage;
        this.bonusList = new ArrayList<>();
        this.random = new Random();
        initialiserBonus();
        randomiseBonus();
    }

    private void initialiserBonus() {
        bonusList.add(Bonus.creerBonus("Arme", "Massue"));
        bonusList.add(Bonus.creerBonus("Arme", "Épée"));
        bonusList.add(Bonus.creerBonus("Sort", "Eclair"));
        bonusList.add(Bonus.creerBonus("Sort", "Boule de feu"));
        bonusList.add(Bonus.creerBonus("Potion", "Grande potion"));
        bonusList.add(Bonus.creerBonus("Potion", "Petite potion"));
    }

    private void randomiseBonus() {
        Collections.shuffle(bonusList, random);
    }


    public Bonus getBonusAtPosition(int position) {
        if (position < 0 || position >= bonusList.size()) {
            return null;
        }
        return bonusList.get(position);
    }

    public void AppliqBonus(Bonus bonus) {
        int xpGagne = random.nextInt(5) + 5;
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

    }
}
