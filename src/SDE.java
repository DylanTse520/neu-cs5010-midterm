public class SDE extends EngineerImpl{

    int linesOfCode;
    int numDesignDoc;

    public SDE(String name, int base, int linesOfCode, int numDesignDoc) {
        super(name, base);
        this.linesOfCode = linesOfCode;
        this.numDesignDoc = numDesignDoc;
    }

    @Override
    public void setBonus(Rating rating) {
        double baseBonus = getBaseBonus();

        double bonusRatio = linesOfCode / 80.0 + numDesignDoc / 5.0;
        if (rating == Rating.EXCEED_EXPECTATION) {
            bonusRatio = bonusRatio * 1.2;
        } else if (rating == Rating.SUPERB) {
            bonusRatio = bonusRatio * 1.7;
        }

        bonus = baseBonus * bonusRatio;
    }

}
