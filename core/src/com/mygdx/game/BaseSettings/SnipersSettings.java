package com.mygdx.game.BaseSettings;

import java.util.*;
import com.mygdx.game.Actions.Position;
import com.mygdx.game.units.*;

public class SnipersSettings extends Person {

    //Класс параметров для стрелков
    protected int ammunition; // боеприпасов в наличии
    protected int level; // уровень (зависит от опыта и даёт увеличение урона)
    protected int maxDistance; // макс. дальность эффективной стрельбы
    protected int maxammunition; 
    /**
     * Конструктор базы Стрелков
     *
     * @param name     Имя
     * @param priority Приоритет хода
     * @param health   Текущее здоровье
     * @param power    Сила
     * @param agility  Ловкость (%). 3 ловкости = 1% к увороту, и 10 ловкости = 1% к критическому удару
     * @param defence  Защита (% к сопротивлению урону)
     * @param distance Дистанция воздействия на другой объект (10 у мага, 1 у крестьянина и тд)
     * @param ammunition Количество боезапаса (стрел)
     * @param maxDistance Эффективная дальность стрельбы
     * @param pos Положение в прогстранстве
     */
    // public Person(String name, int health, int power, int armor, String weapon, String className, Position pos, int priority, int agility, int distance) 

    protected SnipersSettings(String name, int health, int power, int armor, 
            Position pos, int priority, int agility, int distance, int maxDistance, int ammunition) {
        super(name, health, power, armor, pos, priority, agility, distance);
        this.ammunition = ammunition;
        this.maxDistance = maxDistance;
        this.level = 1;
    }

    public int getAmmunition() {
        return ammunition;
    }

    public int getMaxAmmunition() {
        return maxammunition;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }

    /**
     * Ход персонажа
     *
     * @param enemies Список его врагов
     */
    @Override
    public void step(ArrayList<Person> enemies, ArrayList<Person> friends) {
        if (health <= 0 || ammunition <= 0) {
            if (ammunition <= 0) {
                System.out.print(name + ": " + "подайте стрел!");
            }
            return;
        }
        Person target = this.findNearestPerson(enemies);
        if (target != null) {
            shot(target);
        }
    }

   
    /**
     * Атака противника
     * 
     * @param target Противник
     */
    protected void shot(Person target) {
        System.out.print(" Стреляет по " + target);
        ammunition--;
        float dist = position.distanceTo(target.position);
        int damage = getRound(power, 10) + (power / 10);
        if (dist > maxDistance)
            damage *= 0.5f;
        else if (dist < maxDistance)
            damage *= 1.2f;

        boolean critical = (this.agility / 3) >= rnd.nextInt(100);
        if (critical) {
            damage *= 2.0f;
        }
        int res = target.getDamage(damage);
        if (res > 0) {
            if (critical)
                System.out.print(" и наносит критический удар в " + res + " повреждений!");
            else
                System.out.print(" и наносит " + res + " повреждений.");
        } else {
            System.out.print(", но " + target.name + " увернулся!");
        }
        if (target.health <= 0) {
            System.out.print("\n" + target + " вышел из чата!");
        }
    }
}

    // @Override
    // public void step(ArrayList<Person> enemies, ArrayList<Person> friends) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'step'");
    // }

 // @Override
    // public void step(ArrayList<Person> enemies, ArrayList<Person> friends) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'step'");
    // }

    // @Override
    // public void step(ArrayList<Person> enemies, ArrayList<Person> friends) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'step'");
    // }

    // @Override
    // public void step(ArrayList<Person> enemies, ArrayList<Person> friends) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'step'");
    // }

