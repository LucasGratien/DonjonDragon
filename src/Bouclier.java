public class Bouclier extends EquipementDefensif{

    public Bouclier(String name, int resistance, String type ) {
    super(name, resistance, type);
}

@Override
public String toString() {
    return "Bouclier{" +
            "name='" + getName() + '\'' +
            ", level=" + getResistance() +
            ", type='" + getType() + '\'' +
            '}';
}
}
