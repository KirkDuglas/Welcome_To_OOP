package units;

public class Monk extends Person {
    
    private int healVal;
    private int healPrice; 
    private int mana;
    private int atackPrice;

    public Monk(String name, int age) {
        super(name, 80, 30, age, 5, 30, "Stick", 30);
        this.mana = 10;
        this.healPrice = 2;
        this.atackPrice = 1;
    }

    public void attack(Person person) {
        person.health -= this.power;
        this.mana -= this.atackPrice;
    }

    public void heal(Person person, int val) {
        person.health += this.healVal;
    }

    public void heal(int val) {
        super.health += this.healVal;
        this.mana -= this.healPrice;
    }

    private int price(String action){
        if (action == "heal") return healPrice;
        else if (action == "atack") return atackPrice;
        return 0;
    }
}