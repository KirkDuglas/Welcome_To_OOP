package com.mygdx.game.units;
// import java.util.ArrayList;

import com.mygdx.game.Actions.*;
import com.mygdx.game.BaseSettings.MagicSettings;
//Монах
public class Monk extends MagicSettings {
    // private int mana;
    // private int healVal;
    // private int healPrice;

    public Monk(String name, Position pos) {
        super(name, 600, 40, 0, pos, 1, 10, 8, 100);
        // this.mana = 10;
        // this.healPrice = 2;
        // this.attackPrice = 1;
    //     private static final int HEALTH = 600;
    // private static final int POWER = 40;
    // private static final int AGILITY = 10;
    // private static final int DEFENCE = 0;
    // private static final int DISTANCE = 8;
    // private static final int MANA = 100;
    }

    @Override
    public String toString()
    {
        return String.format("[Монах] %s, ❤️=%d, \uD83D\uDD25=%d, %s", name, health, mana, position.toString());
    }

    @Override
    public String getInfo() {
        return "Монах";
    }
}