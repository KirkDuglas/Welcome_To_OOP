package View;


import Actions.Position;
import units.Person;
import Control.*;

import java.util.Collections;


// import org.example.units.BaseHero;
// import java.util.Collections;

public class View {
    private static int step = 1;
    private static int l = 0;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");
    private static void tabSetter(int cnt, int max){
        int dif = max - cnt + 2;
        if (dif>0) System.out.printf("%" + dif + "s", ":\t"); else System.out.print(":\t");
    }
    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
    /**
     * @param x
     * @param y
     * @return
     */
    private static String getChar(int x, int y){
        String out = "| ";
        for (Person human: Main.allPersons)
        {
            Position pos = human.getPosition();
            if (pos.getX() == x && pos.getY() == y)
            {
                if (human.getHealth() <= 0)
                {
                    out = "│" + (AnsyView.ANSI_RED + human.getInfo().charAt(1) + AnsyView.ANSI_RESET);
                    break;
                }
                if (Main.greenPersons.contains(human)) out = "│" + (AnsyView.ANSI_GREEN + human.getInfo().charAt(1) + AnsyView.ANSI_RESET);
                if (Main.bluePersons.contains(human)) out = "│" + (AnsyView.ANSI_BLUE + human.getInfo().charAt(1) + AnsyView.ANSI_RESET);
                break;
            }
        }
        return out;
    }
    public static void view() {
        if (step == 1 ){
            System.out.print(AnsyView.ANSI_RED + "First step" + AnsyView.ANSI_RESET);
        } else {
            System.out.print(AnsyView.ANSI_RED + "Step:" + step + AnsyView.ANSI_RESET);
        }
        step++;
        Main.allPersons.forEach((v) -> l = Math.max(l, v.toString().length()));
        System.out.print("_".repeat(l*2));
        System.out.println();
        System.out.print(top10 + "    ");
        System.out.print("Blue side");
        // for (int i = 0; i < l[0]-9; i++)
        System.out.print(" ".repeat(l-9));
        System.out.println(":\tGreen side");
        for (int i = 1; i < 11; i++) {
            System.out.print(getChar(1, i));
        }
        System.out.print("|    ");
        System.out.print(Main.bluePersons.get(0));
        tabSetter(Main.bluePersons.get(0).toString().length(), l);
        System.out.println(Main.greenPersons.get(0));
        System.out.println(midl10);

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(Main.bluePersons.get(i-1));
            tabSetter(Main.bluePersons.get(i-1).toString().length(), l);
            System.out.println(Main.greenPersons.get(i-1));
            System.out.println(midl10);
        }
        for (int j = 1; j < 11; j++) {
            System.out.print(getChar(10, j));
        }
        System.out.print("|    ");
        System.out.print(Main.bluePersons.get(9));
        tabSetter(Main.bluePersons.get(9).toString().length(), l);
        System.out.println(Main.greenPersons.get(9));
        System.out.println(bottom10);
    }
}
