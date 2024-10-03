package fr.campus.donjondragon.equipements;

abstract class EquipementDefensif {
    // Déclaration des attributs privés
    private String nom; // Nom de l'équipement défensif (ex: fr.campus.donjondragon.equipements.Bouclier, Protection divine)
    private int resistance; // Niveau de résistance de l'équipement défensif
    private String type; // Type d'équipement défensif (ex: bouclier, philtre)

    // Constructeur qui initialise les attributs : nom, résistance et type de l'équipement défensif
    public EquipementDefensif(String name, int resistance, String type) {
        this.nom = name;
        this.resistance = resistance;
        this.type = type;
    }

    // Getters pour accéder aux attributs privés depuis l'extérieur de la classe
    public String getNom() {
        return nom;
    }

    public int getResistance() {
        return resistance;
    }

    public String getType() {
        return type;
    }

    // Setters pour modifier les attributs privés depuis l'extérieur de la classe
    public void setName(String name) {
        this.nom = name; // Corriger l'affectation
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public void setType(String type) {
        this.type = type;
    }
}
