package units;

//Разбойник
public class Robber extends Person{
    public Robber(String name, int age, int x, int y) {
        super(name, 100, 10, age, 20, 40, "Knife", 50, "Разбойник", x, y);

    }

    public void attack(Person person) {
        person.health -= this.power;
    }

    public void stealGold(int val) {
        super.gold += val;
    }
}
