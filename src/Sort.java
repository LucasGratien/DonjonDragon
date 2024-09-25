public class Sort extends EquipementOffensif {

    // Constructeur qui appelle celui de la classe parente
    public Sort(String name, int level, String type) {
        super(type, name, level);  // Appelle le constructeur de la classe parente
    }

    @Override
    public String toString() {
        return "Sort{" +
                "name='" + getName() + '\'' +  // Utilisation des getters car les attributs sont privés
                ", level=" + getLevel() +
                ", type='" + getType() + '\'' +
                '}';
    }
}

