package units;
//Копейщик
public class Spearman extends Person{
    public Spearman(String name, int age) {
        super(name, 80, 30, age, 5, 30, "Stick", 30);
    }

    public void attack(Person person) {
        person.health -= this.power;
    }
}
