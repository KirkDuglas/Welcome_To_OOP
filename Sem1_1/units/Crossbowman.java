package units;

import java.util.ArrayList;

import Actions.ActionInterface;
//Арбалетчик
public class Crossbowman extends Person{
    private int arrowsNum;
    boolean inGame = true;
    public Crossbowman(String name, int age, int x, int y) {
        super(name, 60, 40, age, 20, 40, "Crossbow", 40, "Арбалетчик", x, y);

    }

    public void attack(Person person) {
        person.health -= this.power;
    }
    public boolean isInGame() {
        return this.arrowsNum == 0 ? false : true;
    }

    @Override
    public void step(ArrayList<Person> enemies, ArrayList<Person> friends) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'step'");
    }
}
