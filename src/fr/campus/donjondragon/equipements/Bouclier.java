package fr.campus.donjondragon.equipements;

public class Bouclier extends EquipementDefensif {

    public Bouclier(String name, int resistance, String type ) {
    super(name, resistance, type);
}

@Override
public String toString() {
    return "fr.campus.donjondragon.equipements.Bouclier{" +
            "name='" + getNom() + '\'' +
            ", level=" + getResistance() +
            ", type='" + getType() + '\'' +
            '}';
}
}
