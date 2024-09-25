public class Bonus {
    private String name;
    private String type;
    private int effets;


    public Bonus(String name, String type, int effets) {
        this.name = name;
        this.type = type;
        this.effets = effets;
    }


    public static Bonus creerBonus(String type) {
        switch (type) {
            case "Arme":
                case "Sort":
                case "Potion":
                default:
                return null;
        }
    }
    public static Bonus creerArme(String nom) {
        switch (nom) {
            case "Épée":
                return new Bonus("Épée", "Arme", 5);
            case "Massue":
                return new Bonus("Massue", "Arme", 3);
            case "Eclair":
                return new Bonus("Eclair", "Sort", 2);
            case "Boule de feu":
                return new Bonus("Boule de feu", "Sort", 7);
            case "Petite potion":
                return new Bonus("Petite potion", "Potion", 2);
            case "Grande potion":
                return new Bonus("Grande potion", "Potion", 5);
            default:
                return null;
        }
    }
    public int getEffets() {
        return effets;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEffets(int effets) {
        this.effets = effets;
    }

    @Override
    public String toString() {
        return "Bonus{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", effets=" + effets +
                '}';
    }
}
