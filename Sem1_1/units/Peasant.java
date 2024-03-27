package units;

import java.util.ArrayList;
import BaseSettings.*;
import Actions.*;

//Крестьянин
public class Peasant extends Person {
    private static final int maxArrows = 240;
    private int arrowsNum;
    // private int bag;
    // boolean inGame = true;
    
    public Peasant(String name, Position pos) {
        // Person(String name, int health, int power, int armor, String weapon, String
        // className, Position pos, int priority, int agility, int distance)
        super(name, 500, 30, 0, "Сумка", "Крестьянин", pos, 2, 30, 1);
        arrowsNum = maxArrows;
    }

    @Override
    public void step(ArrayList<Person> enemies, ArrayList<Person> friends) {
        conseq = "";

        if (health <= 0 || arrowsNum <= 0)
            return;
        SnipersSettings p = (SnipersSettings) getShooter(friends);
        if (p != null) {
            if (p.getAmmunition() < p.getMaxAmmunition()) {
                p.setAmmunition(p.getAmmunition() + 1);
                arrowsNum--;
                conseq = String.format(" дал стрелу %s", p);
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
