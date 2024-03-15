//Снайпер, колдун, копейщик, арбалетчик, монах

import units.*;

public class Main {

    public static void main(String[] args) {

        Robber robber = new Robber("Andrey", 20);
        Peasant peasant = new Peasant("Anton", 40);
        Crossbowman crossbowman = new Crossbowman("Vasya", 20);

        Magician magician = new Magician("Dima", 20);
        Monk monk = new Monk("Apollon", 20);
        Sniper sniper = new Sniper("OKO", 20);
        Spearman spearman = new Spearman("Jalo", 20);
        System.out.println(robber);
        System.out.println(peasant);

       System.out.println(crossbowman);
       System.out.println(magician);
       System.out.println(monk);
       System.out.println(sniper);
        System.out.println(spearman);
    }

    
}