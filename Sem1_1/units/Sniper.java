package units;

//Снайпер
public class Sniper extends Person {
    private int arrowsNum;
    boolean inGame = true;
    public Sniper(String name, int age, int x, int y) {
        super(name, 60, 40, age, 20, 30, "gun", 40, "Снайпер", x, y);

    }

    public void attack(Person person) {
        person.health -= this.power;
    }
    public boolean isInGame() {
        return this.arrowsNum == 0 ? false : true;
    }
}