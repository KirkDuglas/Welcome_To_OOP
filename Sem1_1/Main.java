
//Снайпер, колдун, копейщик, арбалетчик, монах
import units.*;
import java.util.*;



public class Main {

    public static void main(String[] args) {
        Yellow = teamCreator(0, 0);
        Green = teamCreator(0, 3);
        System.out.println(Yellow);
        System.out.println();
        System.out.println(Green);
    }
    public static ArrayList<Person> Yellow;
    public static ArrayList<Person> Green;
    // static ArrayList<Person> Yelow = new ArrayList<>();
    // static ArrayList<Person> Green = new ArrayList<>();

    // public static void main(String[] args) {
    //     createTeam(Yelow, 10, 0);
    //     createTeam(Green, 10, 3);
    //     System.out.println(Yelow);
    //     System.out.println(Green);

    private static ArrayList<Person> teamCreator(int val, int numm){
        ArrayList<Person> team = new ArrayList<Person>();
        int teamCount = 10;
        for (int i = 0; i < teamCount; i++){
            switch (new Random().nextInt(4) + numm){
                case 0:
                    team.add(new Crossbowman(fillName(), 20, 0, i));
                    break;
                case 1:
                    team.add(new Monk(fillName(), 22, 0, i));
                    break;
                case 2:
                    team.add(new Spearman(fillName(), 35, 0, i));
                    break;
                    case 3:
                    team.add(new Peasant(fillName(), 48, numm*3, i ));
                    break;
                case 4:
                    team.add(new Sniper(fillName(), 18, 9, i));
                    break;
                case 5:
                    team.add(new Magician(fillName(),60,  9, i));
                    break;
                case 6:
                    team.add(new Robber(fillName(),55, 9, i));
                    break;
            }
        }
        return team;
    }
    private static String fillName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
    }


}

// public static void main(String[] args) {

//     Robber robber = new Robber("Andrey", 20);
//     Peasant peasant = new Peasant("Anton", 40);
//     Crossbowman crossbowman = new Crossbowman("Vasya", 20);
//     Magician magician = new Magician("Dima", 20);
//     Monk monk = new Monk("Apollon", 20);
//     Sniper sniper = new Sniper("Strelok", 20);
//     Spearman spearman = new Spearman("Igor", 20);
//     System.out.println(robber);
//     System.out.println(peasant);

//     System.out.println(crossbowman);
//     System.out.println(magician);
//     System.out.println(monk);
//     System.out.println(sniper);
//     System.out.println(spearman);
// }