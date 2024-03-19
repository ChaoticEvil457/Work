public class Mouse {
    Food food;
    Workout work;
    Weight weight;
    String name;

    public Mouse(Food food, Workout work, Weight weight) {
        this.food = food;
        this.work = work;
        this.weight = weight;
    }

    // weighs the mouse with the food eaten and workout routine factored in
    public double weigh(Date d) {
        weight.date = d;
        performWorkout();
        eatFood();
        return weight.grams;
    }

    // works out based on routine
    public void performWorkout() {
        weight.excercise(work.totalWorkoutTime());
    }

    // eats based on food
    public void eatFood() {
        weight.eat(food.grams);
    }
}
