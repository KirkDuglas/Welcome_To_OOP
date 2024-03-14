package units;

//Крестьянин
public class Peasant extends Person {
    private int arrowsNum;
    boolean inGame = true;

    public Peasant(String name, int age) {
        super(name, 20, 5, age, 0, 20, "nothing", 20);
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
    public String toString() {
        return super.name;
    }
}
