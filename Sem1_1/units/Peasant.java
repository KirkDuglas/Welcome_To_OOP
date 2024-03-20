package units;
import java.util.ArrayList;

import Actions.ActionInterface;
//Крестьянин
public class Peasant extends Person {
    private int arrowsNum;
    boolean inGame = true;

    public Peasant(String name, int age, int x, int y) {
        super(name, 20, 5, age, 0, 20, "nothing", 20, "Крестьянин", x, y);
    }

    public void giveArrows (int val) {
        this.arrowsNum -= val;
        if (!isInGame()){
            inGame = false;
        }
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
