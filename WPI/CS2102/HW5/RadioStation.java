import java.util.GregorianCalendar;
import java.util.LinkedList;

public class RadioStation {
    private IStation dailyRatings;
    private GregorianCalendar today;

    public RadioStation(IStation dailyRatings,
            GregorianCalendar today) {
        this.dailyRatings = dailyRatings;
        this.today = today;
    }

    /**
     * Returns the lowest rank from the current month
     * 
     * @return Returns the lowest rank
     */
    public int bestRankThisMonth() {
        int rank = Integer.MAX_VALUE;
        for (int i = 0; i < today.get(GregorianCalendar.DAY_OF_MONTH) && i < dailyRatings.size(); i++) {
            for (int j = 0; j < dailyRatings.get(dailyRatings.size() - i - 1).getRankings().size(); j++) {
                if (dailyRatings.get(dailyRatings.size() - i - 1).getRankings().get(j) < rank) {
                    rank = dailyRatings.get(dailyRatings.size() - i - 1).getRankings().get(j);
                }
            }
        }
        return rank;
    }

    /**
     * Takes in a month and year, and returns the total song downloads for that
     * month
     * 
     * @param month Given month
     * @param year  Given year
     * @return Returns total song downloads from the given month and year
     */
    public int totalSongDownloads(int month, int year) {
        int downloads = 0;
        int start = 0;
        for (int i = 0; i < dailyRatings.size(); i++) {
            if (dailyRatings.get(i).getDate().get(GregorianCalendar.MONTH) == month) {
                start = i;
                break;
            }
        }
        for (int i = 0; i < dailyRatings.get(start).getDate().getActualMaximum(GregorianCalendar.DAY_OF_MONTH)
                && i < dailyRatings.size() - start; i++) {
            for (int j = 0; j < dailyRatings.get(start + i).getDownloads().size(); j++) {
                downloads += dailyRatings.get(start + i).getDownloads().get(j);
            }
        }
        return downloads;
    }

    /**
     * Takes in a list of surveys and then adds one to the current day and saves a
     * new TodaysRatings object containing the current day, and the rankings and
     * downloads for that day
     * 
     * @param surveys List of surveys containings the day's ranks and downloads
     * @return Returns the RadioStation object
     */
    public RadioStation addTodaysSurveys(LinkedList<Survey> surveys) {
        LinkedList<Integer> downloads = new LinkedList<>();
        LinkedList<Integer> rankings = new LinkedList<>();
        GregorianCalendar newDate = new GregorianCalendar(today.get(GregorianCalendar.YEAR),
                today.get(GregorianCalendar.MONTH), today.get(GregorianCalendar.DAY_OF_MONTH));
        for (int i = 0; i < surveys.size(); i++) {
            downloads.add(surveys.get(i).getDownloads());
            rankings.add(surveys.get(i).getRank());
        }
        dailyRatings.add(new TodaysRatings(newDate, rankings, downloads));
        today.add(GregorianCalendar.DAY_OF_YEAR, 1);
        return this;
    }

    /**
     * Gets the list of ratings for each day
     * 
     * @return returns the list of ratings for each day
     */
    public IStation getDailyRatings() {
        return dailyRatings;
    }
}

/*
 * 1) A theoretically better way of doing this project (at least a more clean
 * way in my opinion) would be through the use of multiple minHeaps all of which
 * have a year and month stored so you could easily find the heap you want, and
 * it would be easy to find the top ranking as it would be at the top of the
 * heap
 * 2) To implement this, I would create a Key class which contains a year,
 * month, and a Heap. Then I would create a Heap class containing downloads,
 * ranking, and left and right nodes. After that I would make a list of keys
 * stored in a third class, the same way the current LinkedList method is.
 * This would vastly speed up the bestRankThisMonth method as you could just
 * look for the correct key, then get the top value.
 * 3) The interface wouldn't need any changes as the above implementation
 * doesn't require any additional methods.
 * 
 */