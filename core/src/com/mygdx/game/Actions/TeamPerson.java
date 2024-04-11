package com.mygdx.game.Actions;
import com.mygdx.game.units.Person;

public class TeamPerson {
    public TeamType team;
    public Person person;
    public boolean active;

    public TeamPerson(TeamType team, Person person)
    {
        this.team = team;
        this.person = person;
        active = false;
    }

}
