package fr.campus.donjondragon.equipements;

public class Philtre extends EquipementDefensif {

    public Philtre(String nom, int resistance, String type){
    super(nom, resistance, type);
}
    public String toString() {
        return "philtre{" +
                "name='" + getNom() + '\'' +
                ", level=" + getResistance() +
                ", type='" + getType() + '\'' +
                '}';
}
}
