abstract class EquipementDefensif {
    // Déclaration des attributs privés
    private String name; // Nom de l'équipement défensif (ex: Bouclier, Protection divine)
    private int resistance; // Niveau de résistance de l'équipement défensif
    private String type; // Type d'équipement défensif (ex: bouclier, philtre)

    // Constructeur qui initialise les attributs : nom, résistance et type de l'équipement défensif
    public EquipementDefensif(String name, int resistance, String type) {
        this.name = name;
        this.resistance = resistance;
        this.type = type;
    }

    // Getters pour accéder aux attributs privés depuis l'extérieur de la classe
    public String getName() {
        return name;
    }

    public int getResistance() {
        return resistance;
    }

    public String getType() {
        return type;
    }

    // Setters pour modifier les attributs privés depuis l'extérieur de la classe
    public void setName(String name) {
        this.name = name;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public void setType(String type) {
        this.type = type;
    }

}
