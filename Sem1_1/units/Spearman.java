package units;
//Копейщик
public class Spearman extends Person{
    public Spearman(String name, int age, int x, int y) {
        super(name, 80, 30, age, 25, 50, "Pike", 10, "Копейщик", x, y);
    }

    public void attack(Person person) {
        person.health -= this.power;
    }
}
