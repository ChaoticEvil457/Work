public class ReadingResult implements IChallenge {
    int goal;// goal for average books per day
    BooksRead fiction;// fiction books read
    BooksRead nonFiction;// nonFiction books read

    public ReadingResult(int goal, BooksRead fiction, BooksRead nonFiction) {
        this.goal = goal;
        this.fiction = fiction;
        this.nonFiction = nonFiction;
    }

    public double averagePerDay() {// average books read per day
        return (fiction.read + nonFiction.read) / 31; // books read / 31 days in October
    }

    public double differenceFromGoal() {// how many books per day more are needed to reach your goal
        if (goal - averagePerDay() > 0)
            return goal - averagePerDay();
        return 0;
    }
}
