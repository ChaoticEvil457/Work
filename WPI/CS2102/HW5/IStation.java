import java.util.LinkedList;

public interface IStation {
    // adds the given object to IStation
    public IStation add(TodaysRatings o);

    // gets the list in IStation
    public LinkedList<TodaysRatings> get();

    //returns the size of the list
    public int size();

    //returns a specific value in the list
    public TodaysRatings get(int index);
}
