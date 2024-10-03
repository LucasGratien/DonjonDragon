package fr.campus.donjondragon.personnage;

public class Personnage {
    private String nom;
    private String typePersonnage;
    private int pDv;
    private int attaque;
    private String equipementOffensif;
    private String equipementDefensif;
    private int xpPerso;
    int position;

    public Personnage() {}

    public Personnage(String nom, String typePersonnage) {
       this.nom = nom;
       this.typePersonnage = typePersonnage;
    }

    public Personnage(String nom, String typePersonnage, int pDv, int attaque, String equipementOffensif, String equipementDefensif) {

        this.nom = nom;
        this.typePersonnage = typePersonnage;
        this.pDv = pDv;
        this.attaque = attaque;
        this.equipementOffensif = equipementOffensif;
        this.equipementDefensif = equipementDefensif;
        this.xpPerso = 0;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public int getPosition(Personnage personnage) {
        return position;
    }

    public String getTypePersonnage() {
        return typePersonnage;
    }

    public int getpDv() {
        return pDv;
    }

    public int getAttaque() {
        return attaque;
    }

    public String getEquipementOffensif() {
        return equipementOffensif;
    }

    public String getEquipementDefensif() {
        return equipementDefensif;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setpDv(int pDv) {
        this.pDv = pDv;
    }


    public void setPosition(int position) {
        this.position = position;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }
    public int getXpPerso() {
        return xpPerso;
    }

    public void gagnerXP(int xp) {
        this.xpPerso += xp;
    }

    public void afficherInfos() {
        System.out.println("Nom : " + nom);
        System.out.println("Type : " + typePersonnage);
        System.out.println("Points de Vie : " + pDv);
        System.out.println("Attaque : " + attaque);
    }
}
