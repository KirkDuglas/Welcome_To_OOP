package units;
public class Magician extends Person {
    private int mana;

    public Magician(String name, int age) {
        super(name, 80, 30, age, 5, 30, "Stick", 30);
    }

    public void attack(Person person) {
        person.health -= this.power;
    }
}
