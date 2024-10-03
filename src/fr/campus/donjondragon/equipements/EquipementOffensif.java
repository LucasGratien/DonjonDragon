package fr.campus.donjondragon.equipements;

public abstract class EquipementOffensif {
    // Déclaration des attributs privés
    private String nom;
    private int level;
    private String type;

    // Constructeur qui initialise les trois attributs
    public EquipementOffensif(String type, String nom, int level) {
        this.nom = nom;
        this.level = level;
        this.type = type;
    }

    // Getters pour accéder aux attributs privés
    public String getNom() {
        return nom;
    }

    public int getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }

    // Setters pour modifier les attributs privés
    public void setName(String nom) {
        this.nom = nom;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setType(String type) {
        this.type = type;
    }

}
