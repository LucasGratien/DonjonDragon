public class Magicien extends Personnage {
    public Magicien(String nom, String typePersonnage) {
        super(nom, typePersonnage);
    }

    public String toString() {
        return "Magicien{" +
                "name='" + getNom() + '\'' +
                ", type='" + getTypePersonnage() + '\'' +
                '}';
    }
}