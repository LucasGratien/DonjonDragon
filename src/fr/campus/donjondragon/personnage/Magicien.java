package fr.campus.donjondragon.personnage;

public class Magicien extends Personnage {
    public Magicien(String nom, String typePersonnage) {
        super(nom, typePersonnage);
    }

    public String toString() {
        return "fr.campus.donjondragon.personnage.Magicien{" +
                "name='" + getNom() + '\'' +
                ", type='" + getTypePersonnage() + '\'' +
                '}';
    }
}