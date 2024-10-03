package fr.campus.donjondragon.personnage;

public class Ennemi extends Personnage {
    private int degats;

    public Ennemi(String nom, String typePersonnage, int degats) {
        super(nom, typePersonnage);
        this.degats = degats;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

        public String toString () {
            return "Ennemi{" +
                    "name='" + getNom() + '\'' +
                    ", type='" + getTypePersonnage() + '\'' +
                    '}';
        }
    }

