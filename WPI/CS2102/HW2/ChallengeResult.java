package HW2;
public class ChallengeResult {
    ReadingResult readResult;
    WritingResult writeResult;

    public ChallengeResult(ReadingResult readResult, WritingResult writeResult) {
        this.readResult = readResult;
        this.writeResult = writeResult;
    }

    public double howClose() {// how close are you to your goal (needed average books per day - current
                              // average books per day * 10000 + words written)
        return readResult.differenceFromGoal() * 10000 + writeResult.differenceFromGoal();
    }
}
