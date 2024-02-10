import java.util.Iterator;
import java.util.List;

public class DepartmentIterator implements Iterator<Engineer> {

    int teamIndex;
    int engineerIndex;
    List<OrderedList<Engineer>> teams;

    public DepartmentIterator(List<OrderedList<Engineer>> teams) {
        this.teams = teams;
        teamIndex = 0;
        engineerIndex = 0;
    }

    @Override
    public boolean hasNext() {
        while (teamIndex != 4 && engineerIndex == teams.get(teamIndex).size()) {
            teamIndex++;
            engineerIndex = 0;
        }
        return teamIndex != 4;
    }

    @Override
    public Engineer next() {
        Engineer current = teams.get(teamIndex).get(engineerIndex);
        engineerIndex++;
        return current;
    }

}
