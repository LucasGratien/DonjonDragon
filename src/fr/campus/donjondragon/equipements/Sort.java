package fr.campus.donjondragon.equipements;

public class Sort extends EquipementOffensif {


    public Sort(String nom, int level, String type) {
        super(type, nom, level);
    }

    @Override
    public String toString() {
        return "fr.campus.donjondragon.equipements.Sort{" +
                "name='" + getNom() + '\'' +
                ", level=" + getLevel() +
                ", type='" + getType() + '\'' +
                '}';
    }
}

