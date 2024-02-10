import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DepartmentImpl implements Department {

    private final static int MAXIMUM_TEAM_NUM = 4;
    private final static int MAXIMUM_TEAM_CAPACITY = 3;

    List<OrderedList<Engineer>> teams;

    public DepartmentImpl() {
        teams = new ArrayList<>(MAXIMUM_TEAM_NUM);
        for (int i = 0; i < MAXIMUM_TEAM_NUM; i++) {
            teams.add(new OrderedListImpl<>());
        }
    }

    @Override
    public void hire(Engineer e, int teamId) {
        if (teamId < 0 || teamId > MAXIMUM_TEAM_NUM - 1) {
            throw new IndexOutOfBoundsException("Wrong team id");
        }

        if (teams.get(teamId).size() < MAXIMUM_TEAM_CAPACITY) {
            teams.get(teamId).add(e);
        }
    }

    @Override
    public void giveOutBonus() {
        for (OrderedList<Engineer> team : teams) {
            int teamSize = team.size();
            for (int i = 0; i < teamSize; i++) {
                team.get(i).setBonus(Rating.EXCEED_EXPECTATION);
            }
        }
    }

    @Override
    public void layoff(double bonusThreshold) {
        teams.replaceAll(engineerOrderedList -> engineerOrderedList.subList(employee -> employee.getBonus() >= bonusThreshold));
    }

    @Override
    public Iterator<Engineer> iterator() {
        return new DepartmentIterator(teams);
    }

}
