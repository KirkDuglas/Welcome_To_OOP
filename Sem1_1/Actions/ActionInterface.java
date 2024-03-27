package Actions;

import java.util.*;

import units.Person;
public interface ActionInterface {
    /**
     * @param enemies
     */
    void step(ArrayList<Person> enemies, ArrayList<Person> friends);

    String getInfo();
}
