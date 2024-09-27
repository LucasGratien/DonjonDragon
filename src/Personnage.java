public abstract class Personnage {
    private String nom;
    private String typePersonnage;
    private int pDv;
    private int attaque;
    private EquipementOffensif equipementOffensif;
    private EquipementDefensif equipementDefensif;
    private int xpPerso;

    public Personnage(String nom, String typePersonnage) {
        this.nom = nom;
        this.typePersonnage = typePersonnage;
        this.xpPerso = 0;

        if (typePersonnage.equalsIgnoreCase("Guerrier")) {
            this.pDv = 10;
            this.attaque = 10;
            this.equipementOffensif = new Sort("Épée d'halle", 5, "Arme");
            this.equipementDefensif = new Bouclier("Boubou", 5, "bouclier");
        } else if (typePersonnage.equalsIgnoreCase("Magicien")) {
            this.pDv = 6;
            this.attaque = 15;
            this.equipementOffensif = new Sort("Boule de feu", 5, "sort");
            this.equipementDefensif = new Philtre("Protection divine", 3, "philtre");
        }
    }

    public void gagnerXP(int xp) {
        this.xpPerso += xp; // Méthode pour gagner de l'XP
    }

    // Getters
    public String getNom() {
        return nom;
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

    public int getXpPerso() {
        return xpPerso;
    }

    // Méthode pour afficher les informations du personnage
    public void afficherInfos() {
        System.out.println("Nom: " + nom);
        System.out.println("Type de personnage: " + typePersonnage);
        System.out.println("Points de vie: " + pDv);
        System.out.println("Force d'attaque: " + attaque);
        System.out.println("XP actuel : " + xpPerso);
        System.out.println("Équipement offensif: " + equipementOffensif);
        System.out.println("Équipement défensif: " + (equipementDefensif != null ? equipementDefensif : "Aucun"));
    }
}
