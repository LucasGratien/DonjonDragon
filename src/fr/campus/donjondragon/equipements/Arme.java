package fr.campus.donjondragon.equipements;

public class Arme extends EquipementOffensif {
    public Arme(String nom, int level, String type){
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
