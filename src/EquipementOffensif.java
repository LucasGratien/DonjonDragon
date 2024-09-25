abstract class EquipementOffensif {
    // Déclaration des attributs privés
    private String name;
    private int level;
    private String type;

    // Constructeur qui initialise les trois attributs
    public EquipementOffensif(String type, String name, int level) {
        this.name = name;
        this.level = level;
        this.type = type;
    }

    // Getters pour accéder aux attributs privés
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }

    // Setters pour modifier les attributs privés
    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setType(String type) {
        this.type = type;
    }

}
