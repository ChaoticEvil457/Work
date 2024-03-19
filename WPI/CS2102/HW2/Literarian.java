package HW2;
public class Literarian {
    ChallengeResult result;// challenge result object
    String penName;

    public Literarian(String penName, ChallengeResult result) {
        this.penName = penName;
        this.result = result;
    }

    public boolean betterBookworm(Literarian l) {// are you closer to your reading goal than l
        return this.result.readResult.differenceFromGoal() < l.result.readResult.differenceFromGoal();
    }

    public boolean wittierWordsmith(Literarian l) {// have you written more than l
        return this.result.writeResult.averagePerDay() > l.result.readResult.averagePerDay();
    }

    public boolean successfulScholar(Literarian l) {// did you beat l in at least one of the above
        return wittierWordsmith(l) || betterBookworm(l);
    }
}
