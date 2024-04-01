package Actions;

// import com.mygdx.game.TeamPerson;
import java.util.*;
public class TeamSort implements Comparator<TeamPerson> {
    
    @Override
    public int compare(TeamPerson o1, TeamPerson o2)
    {
        return Integer.compare(o2.person.getPosition().getY(), o1.person.getPosition().getY());
    }
}
