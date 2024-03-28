package units;
// import java.util.ArrayList;

import Actions.*;
import BaseSettings.PehotaSettings;
//Копейщик
public class Spearman extends PehotaSettings{
    public Spearman(String name, Position pos) {
        super(name, 1000, 80, 12, pos, 2, 10, 1);
    }
    // private static final int HEALTH = 1000;
    // private static final int POWER = 80;
    // private static final int AGILITY = 10;
    // private static final int DEFENCE = 12;
    // private static final int DISTANCE = 1;
    @Override
    public String toString() {
        return String.format("[Пикинер] %s, ❤️=%d, %s", name, health, position.toString());
    }

    @Override
    public String getInfo() {
        return "Пикинер " + conseq;
    }
}
