package fr.campus.donjondragon.equipements;

public class Sort extends EquipementOffensif {

    // Constructeur qui appelle celui de la classe parente
    public Sort(String nom, int level, String type) {
        super(type, nom, level);  // Appelle le constructeur de la classe parente
    }

    @Override
    public String toString() {
        return "fr.campus.donjondragon.equipements.Sort{" +
                "name='" + getNom() + '\'' +  // Utilisation des getters car les attributs sont privés
                ", level=" + getLevel() +
                ", type='" + getType() + '\'' +
                '}';
    }
}

