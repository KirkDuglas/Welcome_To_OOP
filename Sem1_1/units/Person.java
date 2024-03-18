package units;

import java.util.*;
public abstract class Person {
    protected String name;
    protected int health;
    protected int power;
    protected int age;
    protected int armor;
    protected int Mana;
    protected int endurance; //выносливость
    protected String weapon;
    protected int gold;
    protected String className;
    protected Position position;


    public Person(String name, int health, int power, int age, int armor, int endurance, String weapon, int gold, String className, int x, int y) {
    
        this.name = name;
        this.health = health;
        this.power = power;
        this.age = age;
        this.armor = armor;
        this.endurance = endurance;
        this.weapon = weapon;
        this.gold = gold;
        this.className = className;
        this.position = new Position(x, y);
    }
 @Override
    public String toString(){
        return (className + " >>> " +  name + " (" + age + ") " + position.x + ":" + position.y );
    // @Override
    // public String toString() {
    //     return name;
    }
    public Person findNearestPerson(ArrayList<Person> persons)
    {
        Person target = null;
        float minDistance = Float.MAX_VALUE;

        for (Person p : persons)
        {
            if (p.health > 0)
            {
                float dist = position.distanceTo(p.position);
                if (dist < minDistance)
                {
                    minDistance = dist;
                    target = p;
                }
            }
        }
        return target;
    }
}

