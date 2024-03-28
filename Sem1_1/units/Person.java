package units;
import Actions.ActionInterface;
import Actions.Position;
// import BaseSettings.*;

import java.util.*;

public abstract class Person implements ActionInterface {
    protected static Random rnd;
    static {
        rnd = new Random();
    }
    public String name; //имя
    public int health; //здоровье
    protected int power; //сила
    protected int armor; //защита
    protected String weapon; // оружие
    protected String className; //класс сословия
    public Position  position; //позиция
    public int priority; //приоритет хода  
    protected int agility;            // ловкость
    protected int distance; // дистанция воздействия на другой объект
    protected final int maxHealth;
    protected int Mana; //мана
    protected String conseq;
   //protected int gold;
//    protected int endurance; //выносливость
    // public Person(String name, int health, int power, int age, int armor, int endurance, String weapon, int gold, String className, int x, int y) {
    
       
    protected Person(String name, int health, int power, int armor, Position pos,
            int priority, int agility, int distance) {
        this.name = name;
        this.health = getRound(health, 10);
        this.power = getRound(power, 10);
        this.armor = armor;
        this.weapon = weapon;
        this.className = className;
        this.position = pos;
        this.priority = priority;
        this.agility = getRound(agility, 10);
        this.distance = distance;
        this.maxHealth = this.health;
        this.conseq = "";
        // this.endurance = endurance;
        //this.gold = gold;
    }
    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    protected int getRound(int origin, int percent)
    {
        if (percent > origin)
            return origin;
        int n = (origin * percent) / 100;
        return origin + (rnd.nextInt(0, n * 2 + 1) - n);
    }
    
    public void setPosition(int x, int y)
    {
        position.setXY(x, y);
    }
    public Position getPosition()
    {
        return position;
    }

    public void healed(int health)
    {
        this.health = Math.min(this.health + health, this.maxHealth);
    }
    
    public int getDamage(int damage)
    {
        boolean probability = (this.agility / 2) >= rnd.nextInt(100);
        if (probability) {
            return 0; // увернулись
        }
        int loss = damage - (this.armor * damage) / 100;
        loss = Math.min(loss, this.health);
        this.health -= loss;
        return loss;
    }
 @Override
    public String toString(){
        return (className + " >>> " +  name + " (" + weapon + ") " + position.toString());
    
    }
    public Person findNearestPerson(ArrayList<Person> persons)
    {
        Person target = null;
        float minDistance = Float.MAX_VALUE;

        for (Person p : persons) {
            if (p.health > 0) {
                float dist = position.distanceTo(p.position);
                if (dist < minDistance) {
                    minDistance = dist;
                    target = p;
                }
            }
        }
        return target;
    }
    @Override
    public String getInfo() {
        return this.toString() + conseq;
}
}

