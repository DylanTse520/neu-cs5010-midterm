public class JuniorSDE extends EngineerImpl {

    int linesOfCode;

    public JuniorSDE(String name, int base, int linesOfCode) {
        super(name, base);
        this.linesOfCode = linesOfCode;
    }

    @Override
    public void setBonus(Rating rating) {
        double baseBonus = getBaseBonus();

        double bonusRatio = linesOfCode / 100.0;
        if (rating == Rating.SUPERB) {
            bonusRatio = bonusRatio * 2.0;
        }

        bonus = baseBonus * bonusRatio;
    }

}
