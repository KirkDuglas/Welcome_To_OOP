package com.mygdx.game.units;

import java.util.ArrayList;
import com.mygdx.game.BaseSettings.*;
import com.mygdx.game.Actions.*;

//Крестьянин
public class Peasant extends Person {
    private static final int maxArrows = 240;
    private int arrowsNum;
    // private int bag;
    // boolean inGame = true;
    
    public Peasant(String name, Position pos) {
        // Person(String name, int health, int power, int armor, String weapon, String
        // className, Position pos, int priority, int agility, int distance)
        super(name, 500, 30, 0, pos, 2, 30, 1);
        arrowsNum = maxArrows;
    }

    @Override
    public void step(ArrayList<Person> enemies, ArrayList<Person> friends) {
        conseq.logNone();;

        if (health <= 0 || arrowsNum <= 0)
            return;
        SnipersSettings p = (SnipersSettings) getShooter(friends);
        if (p != null) {
            if (p.getAmmunition() < p.getMaxAmmunition()) {
                p.setAmmunition(p.getAmmunition() + 1);
                arrowsNum--;
                conseq.logGiveArrow(p);
            }
        }
    }

    /**
     * Ищет подходящего стрелка, с наименьшим запасом стрел
     *
     * @param friends Своя команда
     * @return Стрелок или null
     */
    private Person getShooter(ArrayList<Person> friends) {
        Person p = null;
        int min = Integer.MAX_VALUE;

        for (Person friend : friends) {
            if (friend.getHealth() > 0 && friend instanceof SnipersSettings) {
                if (min > ((SnipersSettings) friend).getAmmunition()) {
                    min = ((SnipersSettings) friend).getAmmunition();
                    p = friend;
                }
            }
        }
        return p;
    }

    @Override
    public String toString() {
        return String.format("[Крестьянин] (%s) %s { ❤️=%d, \uD83C\uDFF9=%d }", position.toString(), name, health, arrowsNum);
    }
}
