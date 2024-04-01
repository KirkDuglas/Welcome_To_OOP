package Actions;
import units.Person;

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
