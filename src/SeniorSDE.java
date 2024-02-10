public class SeniorSDE extends EngineerImpl{

    int numOfReports;

    public SeniorSDE(String name, int base, int numOfReports) {
        super(name, base);
        this.numOfReports = numOfReports;
    }

    @Override
    public void setBonus(Rating rating) {
        double baseBonus = getBaseBonus();
        double bonusRatio = numOfReports / 5.0;

        bonus = baseBonus * bonusRatio;
    }

}
