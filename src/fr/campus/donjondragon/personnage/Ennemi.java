package fr.campus.donjondragon.personnage;

public class Ennemi extends Personnage {
    private int degats;


    public Ennemi(String nom, String typePersonnage, int degatsEnnemi) {
        super(nom, typePersonnage);
        this.degats = degatsEnnemi;
        setpDv(100);
    }


    public int getDegats() {
        return degats;
    }


    public void setDegats(int degats) {
        this.degats = degats;
    }
}

