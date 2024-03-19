public class WritingResult implements IChallenge {
    double words;// words written
    int update;// date last updated

    public WritingResult(double words, int update) {
        this.words = words;
        this.update = update;
    }

    public double averagePerDay() {
        return words / update;
    }

    public double differenceFromGoal() {
        if ((50000 - words) / (30 - update + 1) > 0)
            return (50000 - words) / (30 - update + 1);
        return 0;
    }
}
