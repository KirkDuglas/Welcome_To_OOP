package units;
// import java.util.ArrayList;
//import BaseSettings.*;
import Actions.*;
import BaseSettings.MagicSettings;
//Колдун
public class Magician extends MagicSettings {
    // // private int mana;
    // private int healVal;
    // private int healPrice; 
    // private int attackPrice;

    public Magician(String name, Position pos) {
        // private static final int HEALTH = 600;
        // private static final int POWER = 40;
        // private static final int AGILITY = 10;
        // private static final int DEFENCE = 0;
        // private static final int DISTANCE = 8;
        // private static final int MANA = 100;
        
        // protected MagicSettings(String name, int health, int power, int armor, String weapon, String className, Position pos, int priority, int agility, int distance, int mana)
        super(name, 600, 40, 0, "книга заклинаний", "Чернокнижник", pos, 1, 10, 8, 100);
        // this.mana = 10;
        // this.healPrice = 2;
        // this.attackPrice = 1;
    }


    @Override
    public String toString()
    {
        return String.format("[Чернокнижник] %s, ❤️=%d, \uD83D\uDD25=%d, %s", name, health, mana, position.toString());
    }

    @Override
    public String getInfo() {
        return "Чернокнижник";
    }
}
