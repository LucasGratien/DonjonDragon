package fr.campus.donjondragon.personnage;

public class Guerrier extends Personnage {

    public Guerrier(String nom, String typePersonnage) {
        super(nom, typePersonnage);
    }

    public String toString() {
        return "fr.campus.donjondragon.personnage.Guerrier{" +
                "name='" + getNom() + '\'' +
                ", type='" + getTypePersonnage() + '\'' +
                '}';
    }
}
