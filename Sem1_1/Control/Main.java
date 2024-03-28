package Control;

import Actions.*;
import View.*;
import units.*;
// import BaseSettings.*;
import java.util.*;


public class Main {

    public static ArrayList<Person> greenPersons = new ArrayList<>();
    public static ArrayList<Person> bluePersons = new ArrayList<>();
    public static ArrayList<Person> allPersons = new ArrayList<>();

    public static void main(String[] args) {
        createTeam(greenPersons, 10, 0);
        createTeam(bluePersons, 10, 3);
        allPersons.addAll(bluePersons);
        allPersons.addAll(greenPersons);
//        all.sort(new PrioritySort());
        allPersons.sort((o1, o2) -> Integer.compare(o2.priority, o1.priority));

//        for (int i = 0; i < 30; i++) {
        Scanner in = new Scanner(System.in);
        while (true)
        {
//            for (Position p : allPersons) {
//                System.out.println(p.getInfo());
//            }

            View.view();

            for (Person p : allPersons) {
                if (greenPersons.contains(p)) {
                    p.step(bluePersons, greenPersons);

                } else {
                    p.step(greenPersons, bluePersons);
                }
                System.out.println(p.getInfo());
            }
            in.nextLine();
            if (!isLiving(greenPersons))
            {
                System.out.println("Blue team wins!");
                break;
            }
            if (!isLiving(bluePersons))
            {
                System.out.println("Green wins!");
                break;
            }

        }

    }

    private static boolean isLiving(ArrayList<Person> team)
    {
        for (Person person : team) {
            if (person.getHealth() > 0)
                return true;
        }
        return false;
    }

    public static void createTeam(ArrayList<Person> team, int num, int start)
    {
        Random rnd = new Random();
        int cy = 0;
        while (num-- > 0)
        {
            int n = start + rnd.nextInt(4);
            switch (n)
            {
                case 0:
                    team.add(new Crossbowman(Names.getRandomName(), new Position(9, cy)));
                    break;
                case 1:
                    team.add(new Spearman(Names.getRandomName(), new Position(9, cy)));
                    break;
                case 2:
                    team.add(new Magician(Names.getRandomName(), new Position(9, cy)));
                    break;
                case 3:
                    team.add(new Peasant(Names.getRandomName(), new Position((3-start)*3, cy)));
                    break;
                case 4:
                    team.add(new Sniper(Names.getRandomName(), new Position(0, cy)));
                    break;
                case 5:
                    team.add(new Monk(Names.getRandomName(), new Position(0, cy)));
                    break;
                case 6:
                    team.add(new Robber(Names.getRandomName(), new Position(0, cy)));
                    break;
                default:
                    System.out.println("ERROR! Пересмотри алгоритм, ламер!");
            }
            cy++;
        }
    }

}

// public class Main {

//     public static void main(String[] args) {
//         Yellow = teamCreator(0, 0);
//         Green = teamCreator(0, 3);
//         System.out.println(Yellow);
//         System.out.println();
//         System.out.println(Green);
//     }
//     public static ArrayList<Position> Yellow;
//     public static ArrayList<Position> Green;
    

//     private static ArrayList<Position> teamCreator(int val, int numm){
//         ArrayList<Position> team = new ArrayList<Position>();
//         int teamCount = 10;
//         for (int i = 0; i < teamCount; i++){
//             switch (new Random().nextInt(4) + numm){
//                 case 0:
//                     team.add(new Crossbowman(fillName(), 20, 0, i));
//                     break;
//                 case 1:
//                     team.add(new Monk(fillName(), 22, 0, i));
//                     break;
//                 case 2:
//                     team.add(new Spearman(fillName(), 35, 0, i));
//                     break;
//                     case 3:
//                     team.add(new Peasant(fillName(), 48, numm*3, i ));
//                     break;
//                 case 4:
//                     team.add(new Sniper(fillName(), 18, 9, i));
//                     break;
//                 case 5:
//                     team.add(new Magician(fillName(),60,  9, i));
//                     break;
//                 case 6:
//                     team.add(new Robber(fillName(),55, 9, i));
//                     break;
//             }
//         }
//         return team;
//     }
//     private static String fillName(){
//         return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
//     }


// }

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