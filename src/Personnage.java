abstract class Personnage {

    // Déclaration des attributs privés
    private String nom; // Nom du personnage
    private String typePersonnage; // Type de personnage (Guerrier ou Magicien)
    private int pDv; // Points de vie du personnage
    private int Attaque; // Force d'attaque du personnage
    private EquipementOffensif equipementOffensif; // Équipement offensif du personnage
    private EquipementDefensif equipementDefensif; // Équipement défensif du personnage

    // Constructeur par défaut, ne fait rien pour l'instant
    public Personnage() {
    }

    // Constructeur avec le nom en paramètre
    public Personnage(String nom) {
        this.nom = nom;
    }

    // Constructeur qui initialise le nom et le type de personnage
    public Personnage(String nom, String typePersonnage) {
        this.nom = nom;
        this.typePersonnage = typePersonnage;

        // Si le type est "Guerrier", initialiser les attributs correspondants
        if (typePersonnage.equalsIgnoreCase("Guerrier")) {
            this.pDv = 10; // Le Guerrier a 10 points de vie
            this.Attaque = 10; // Le Guerrier a 10 en attaque
            this.equipementOffensif = new Sort("Épée d'halle",5 , "Arme"); // Épée pour l'offensive
            this.equipementDefensif = new Bouclier("Boubou", 5, "bouclier"); // Bouclier pour la défense
        }
        // Si le type est "Magicien", initialiser les attributs correspondants
        else if (typePersonnage.equalsIgnoreCase("Magicien")) {
            this.pDv = 6; // Le Magicien a 6 points de vie
            this.Attaque = 15; // Le Magicien a une attaque plus élevée, 15
            this.equipementOffensif = new Sort("Boule de feu", 5, "sort"); // Sort offensif "Boule de feu"
            this.equipementDefensif = new Philtre("Protection divine", 3, "philtre"); // Protection magique comme défense
        }
    }

    // Getters pour accéder aux attributs privés depuis l'extérieur de la classe
    public String getTypePersonnage() {
        return typePersonnage;
    }

    public String getNom() {
        return nom;
    }

    public int getpDv() {
        return pDv;
    }

    public int getAttaque() {
        return Attaque;
    }

    public EquipementOffensif getEquipementOffensif() {
        return equipementOffensif;
    }

    public EquipementDefensif getEquipementDefensif() {
        return equipementDefensif;
    }

    // Setters pour modifier les attributs privés
    public void setTypePersonnage(String typePersonnage) {
        this.typePersonnage = typePersonnage;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setpDv(int pDv) {
        this.pDv = pDv;
    }

    public void setAttaque(int Attaque) {
        this.Attaque = Attaque;
    }

    public void setEquipementOffensif(EquipementOffensif equipementOffensif) {
        this.equipementOffensif = equipementOffensif;
    }

    public void setEquipementDefensif(EquipementDefensif equipementDefensif) {
        this.equipementDefensif = equipementDefensif;
    }

    // Méthode pour afficher les informations du personnage
    public void afficherInfos() {
        System.out.println("Nom: " + nom); // Affiche le nom du personnage
        System.out.println("Type de personnage: " + typePersonnage); // Affiche le type de personnage (Guerrier ou Magicien)
        System.out.println("Points de vie: " + pDv); // Affiche les points de vie du personnage
        System.out.println("Force d'attaque: " + Attaque); // Affiche la force d'attaque
        // Affiche les informations sur l'équipement offensif
        System.out.println("Équipement offensif: " + equipementOffensif);
        // Affiche l'équipement défensif si présent, sinon affiche "Aucun"
        System.out.println("Équipement défensif: " + (equipementDefensif != null ? equipementDefensif : "Aucun"));
    }

}
