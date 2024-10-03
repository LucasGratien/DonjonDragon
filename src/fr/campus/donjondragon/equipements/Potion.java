package fr.campus.donjondragon.equipements;

public class Potion extends EquipementOffensif {
    public Potion(String nom, int level, String type){
        super(type, nom, level);
    }
    @Override
    public String toString() {
        return "fr.campus.donjondragon.equipements.Arme{" +
                "name='" + getNom() + '\'' +
                ", level=" + getLevel() +
                ", type='" + getType() + '\'' +
                '}';
    }
}

