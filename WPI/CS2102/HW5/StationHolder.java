import java.util.LinkedList;

public class StationHolder implements IStation {
    private LinkedList<TodaysRatings> dailyRatings;

    public StationHolder() {
        dailyRatings = new LinkedList<>();
    }

    // adds the given object to the list
    public IStation add(TodaysRatings o) {
        dailyRatings.add(o);
        return this;
    }

    // gets the list
    public LinkedList<TodaysRatings> get() {
        return dailyRatings;
    }

    // returns the size of the list
    public int size() {
        return dailyRatings.size();
    }

    public TodaysRatings get(int index) {
        return dailyRatings.get(index);
    }
}
