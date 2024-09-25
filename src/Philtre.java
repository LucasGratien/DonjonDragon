public class Philtre extends EquipementDefensif{
public Philtre(String name, int resistance, String type){
    super(name, resistance, type);
}
    public String toString() {
        return "philtre{" +
                "name='" + getName() + '\'' +
                ", level=" + getResistance() +
                ", type='" + getType() + '\'' +
                '}';
}
}
