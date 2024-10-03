package fr.campus.donjondragon;

import fr.campus.donjondragon.personnage.Ennemi;

class Cases {
    private Bonus bonus;

    private Ennemi ennemi;

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public Ennemi getEnnemi() {
        return ennemi;
    }

    public void setEnnemi(Ennemi ennemi) {
        this.ennemi = ennemi;
    }
}
