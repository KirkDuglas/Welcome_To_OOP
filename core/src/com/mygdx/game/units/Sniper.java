package com.mygdx.game.units;
// import java.util.ArrayList;
import com.mygdx.game.BaseSettings.*;
import com.mygdx.game.Actions.*;
//Снайпер
public class Sniper extends SnipersSettings {

    // private int arrowsNum;
    // boolean inGame = true;

    public Sniper(String name, Position pos) {
        super(name, 800, 35, 5, pos, 3, 20, 16, 3, 12);

    }

    @Override
    public String toString() {
        return String.format("[Снайпер] %s, ❤️=%d, \uD83C\uDFF9=%d, %s", name, health, ammunition, position.toString());
    }

    @Override
    public String getInfo() {
        return "Снайпер";

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
}