package com.mygdx.game.Actions;

import java.util.*;

import com.mygdx.game.units.Person;
public interface ActionInterface {
    /**
     * @param enemies
     */
    void step(ArrayList<Person> enemies, ArrayList<Person> friends);

    String getInfo();
}
