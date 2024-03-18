package units;
public class Magician extends Person {
    private int mana;
    private int healVal;
    private int healPrice; 
    private int attackPrice;

    public Magician(String name, int age, int x, int y) {
        super(name, 80, 30, age, 5, 30, "Stick", 30, "Колдун", x, y);
        this.mana = 10;
        this.healPrice = 2;
        this.attackPrice = 1;
    }


    public void attack(Person person) {
        person.health -= this.power;
        this.mana -= price("attack"); //this.atackPrice; //price
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
        else if (action == "atack") return attackPrice;
        return 0;
    }
}
