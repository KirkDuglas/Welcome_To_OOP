package units;
// import java.util.ArrayList;
import Actions.*;
import BaseSettings.PehotaSettings;

//Разбойник
public class Robber extends PehotaSettings{
    public Robber(String name, Position pos) {
        
        super(name, 1000, 70, 10, "Нож", "Разбойник", pos, 2, 60, 1);
    }
    // private static final int HEALTH = 1000;
    // private static final int POWER = 70;
    // private static final int AGILITY = 60;
    // private static final int DEFENCE = 10;
    // private static final int DISTANCE = 1;
    @Override
    public String toString() {
        return String.format("[Разбойник] %s, ❤️=%d, %s", name, health, position.toString());
    }

    @Override
    public String getInfo() {
        return "Разбойник " + conseq;
    }
}
