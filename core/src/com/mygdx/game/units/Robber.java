package com.mygdx.game.units;
// import java.util.ArrayList;
import com.mygdx.game.Actions.*;
import com.mygdx.game.BaseSettings.PehotaSettings;

//Разбойник
public class Robber extends PehotaSettings{
    public Robber(String name, Position pos) {
        
        super(name, 1000, 70, 10, pos, 2, 60, 1);
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
