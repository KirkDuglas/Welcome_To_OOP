package com.mygdx.game.Actions;
import com.mygdx.game.units.Person;

import java.util.*;

//Класс сортировки персонажей по приоритету 

public class PrioritySorting  implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o2.priority, o1.priority);
    }
} 
