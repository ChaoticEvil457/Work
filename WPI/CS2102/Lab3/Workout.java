public class Workout {
    int numberOfWorkouts;
    double workoutLength;// in minuites

    public Workout(int numberOfWorkouts, double workoutLength) {
        this.numberOfWorkouts = numberOfWorkouts;
        this.workoutLength = workoutLength;
    }

    // gives the total time working out
    public double totalWorkoutTime() {
        return numberOfWorkouts * workoutLength;
    }
}
