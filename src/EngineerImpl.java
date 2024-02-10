public abstract class EngineerImpl implements Engineer {

    String name;
    int baseSalary;
    double bonus;

    public EngineerImpl(String name, int baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBonus() {
        return bonus;
    }

    public double getBaseBonus() {
        double baseBonus = baseSalary;
        baseBonus += pullDepartmentProfit();
        baseBonus += pullNASDQIndex();
        baseBonus += pullManagerMood();
        baseBonus += pullCPI();

        return baseBonus;
    }

    @Override
    public int compareTo(Engineer o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return this.getName() + " $" + this.getBonus();
    }
}
