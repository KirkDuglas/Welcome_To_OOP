package com.mygdx.game.units;

// import java.util.ArrayList;

import com.mygdx.game.Actions.*;
import com.mygdx.game.BaseSettings.SnipersSettings;
//Арбалетчик
public class Crossbowman extends SnipersSettings{
    // private static final int HEALTH = 800;
    // private static final int POWER = 35;
    // private static final int AGILITY = 20;
    // private static final int DEFENCE = 5;
    // private static final int DISTANCE = 16;
    // private static final int arrows = 12;
    // private static final int effectDist = 3;
    

    /**
     * Создание экзеспляра Арбалетчика
     * @param name Имя
     * @param pos  Положение в прогстранстве
     */
    // public Crossbowman(String name, Position pos) {
    //     super(name, 3, HEALTH, POWER, AGILITY, DEFENCE, DISTANCE, ARROWS, EFFECTIVE_DISTANCE, pos);
    // }

    public Crossbowman(String name, Position pos) {
        super(name, 800, 35, 5, pos, 3, 20, 16, 3, 12);

    }

    @Override
    public String toString() {
        return String.format("[Арбалетчик] (%s) %s { ❤️=%d, \uD83C\uDFF9=%d }", position.toString(), name, health, ammunition);
    }
    
    @Override
    public String getInfo() {
        return "Арбалетчик " + conseq;
    }
    
    
    

    // public void attack(Person person) {
    //     person.health -= this.power;
    // }
    // public boolean isInGame() {
    //     return this.arrowsNum == 0 ? false : true;
    // }

    // @Override
    // public void step(ArrayList<Person> enemies, ArrayList<Person> friends) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'step'");
    // }
}
