import java.util.GregorianCalendar;
import java.util.LinkedList;

public class TodaysRatings {
    private GregorianCalendar date;
    private LinkedList<Integer> rankings;
    private LinkedList<Integer> downloads;

    public TodaysRatings(GregorianCalendar date, LinkedList<Integer> rankings, LinkedList<Integer> downloads) {
        this.date = date;
        this.rankings = rankings;
        this.downloads = downloads;
    }

    /**
     * Gets the date stored by the object
     * 
     * @return returns the date
     */
    public GregorianCalendar getDate() {
        return date;
    }

    /**
     * Gets the ranking list stored by the object
     * 
     * @return returns the ranking list
     */
    public LinkedList<Integer> getRankings() {
        return rankings;
    }

    /**
     * Gets the downloads stored by the object
     * 
     * @return returns the download list
     */
    public LinkedList<Integer> getDownloads() {
        return downloads;
    }
}