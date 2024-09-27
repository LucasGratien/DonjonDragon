public class Arme extends EquipementOffensif{
    public Arme(String name, int level, String type){
        super(type, name, level);
    }
    @Override
    public String toString() {
        return "Arme{" +
                "name='" + getName() + '\'' +
                ", level=" + getLevel() +
                ", type='" + getType() + '\'' +
                '}';
    }
}
