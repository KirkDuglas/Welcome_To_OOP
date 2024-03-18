package units;
//Монах
public class Monk extends Person {
    private int mana;
    private int healVal;
    private int healPrice;

    public Monk(String name, int age, int x, int y) {
        super(name, 80, 30, age, 5, 30, "Stick", 30, "Монах",x, y);
        this.mana = 10;
        this.healPrice = 1;
    }

    public void heal(Person person, int val) {
        person.health += price("heal"); //this.healVal;
    }

    public void heal(int val) {
        super.health += this.healVal;
        this.mana -= price("heal");//this.healPrice;
    }

    private int price(String action){
        if (action == "heal") return healPrice;
        return 0;
    }
}