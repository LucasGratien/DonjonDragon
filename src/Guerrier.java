public class Guerrier extends Personnage {

    public Guerrier(String nom, String typePersonnage) {
        super(nom, typePersonnage);
    }

    public String toString() {
        return "Guerrier{" +
                "name='" + getNom() + '\'' +
                ", type='" + getTypePersonnage() + '\'' +
                '}';
    }
}
