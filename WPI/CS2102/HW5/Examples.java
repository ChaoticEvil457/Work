import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

public class Examples {

    public Examples() {

    }

    GregorianCalendar cal = new GregorianCalendar(2000, 0, 1);// year 2000, January 1st
    StationHolder ratingList = new StationHolder();
    RadioStation r = new RadioStation(ratingList, cal);
    LinkedList<Survey> surveyList = new LinkedList<>();

    // Tests adding one survey
    @Test
    public void checkAddTodaysSurveys1() {
        surveyList.add(new Survey(1, 10));
        r.addTodaysSurveys(surveyList);
        assertTrue(10 == r.getDailyRatings().get(0).getDownloads().get(0));
        assertTrue(1 == r.getDailyRatings().get(0).getRankings().get(0));
    }

    // Tests adding multiple surveys to the same day
    @Test
    public void checkAddTodaysSurveys2() {
        surveyList.add(new Survey(1, 10));
        surveyList.add(new Survey(2, 5));
        r.addTodaysSurveys(surveyList);
        assertTrue(10 == r.getDailyRatings().get(0).getDownloads().get(0));
        assertTrue(1 == r.getDailyRatings().get(0).getRankings().get(0));
        assertTrue(5 == r.getDailyRatings().get(0).getDownloads().get(1));
        assertTrue(2 == r.getDailyRatings().get(0).getRankings().get(1));
    }

    // Tests adding multiple surveys to different days, makes sure the date is
    // increasing for each call
    @Test
    public void checkAddTodaysSurveys3() {
        surveyList.add(new Survey(1, 10));
        r = r.addTodaysSurveys(surveyList);
        surveyList.clear();
        surveyList.add(new Survey(2, 5));
        r = r.addTodaysSurveys(surveyList);
        assertTrue(10 == r.getDailyRatings().get(0).getDownloads().get(0));
        assertTrue(1 == r.getDailyRatings().get(0).getRankings().get(0));
        assertTrue(5 == r.getDailyRatings().get(1).getDownloads().get(0));
        assertTrue(2 == r.getDailyRatings().get(1).getRankings().get(0));
        assertEquals(new GregorianCalendar(2000, 0, 2), r.getDailyRatings().get(1).getDate());
    }

    // calling addTodaysSurveys with an empty surveyList will skip a day
    @Test
    public void checkAddTodaysSurveys4() {
        surveyList.add(new Survey(1, 10));
        r = r.addTodaysSurveys(surveyList);
        surveyList.clear();
        r = r.addTodaysSurveys(surveyList);
        surveyList.add(new Survey(2, 5));
        r = r.addTodaysSurveys(surveyList);
        assertEquals(new GregorianCalendar(2000, 0, 3), r.getDailyRatings().get(2).getDate());
    }

    // Tests if the function can get the downloads
    @Test
    public void checkTotalSongDownloads1() {
        surveyList.add(new Survey(1, 10));
        r = r.addTodaysSurveys(surveyList);
        assertEquals(10, r.totalSongDownloads(0, 2000));
    }

    // Tests if the function can get the downloads for multiple days
    @Test
    public void checkTotalSongDownloads2() {
        surveyList.add(new Survey(1, 10));
        r = r.addTodaysSurveys(surveyList);
        surveyList.clear();
        surveyList.add(new Survey(2, 5));
        r = r.addTodaysSurveys(surveyList);
        assertEquals(15, r.totalSongDownloads(0, 2000));
    }

    // Makes sure it skips empty lists
    @Test
    public void checkTotalSongDownloads3() {
        surveyList.add(new Survey(1, 10));
        r = r.addTodaysSurveys(surveyList);
        surveyList.clear();
        r = r.addTodaysSurveys(surveyList);
        surveyList.add(new Survey(2, 5));
        r = r.addTodaysSurveys(surveyList);
        assertEquals(15, r.totalSongDownloads(0, 2000));
    }

    // Can check downloads in other months
    @Test
    public void checkTotalSongDownloads4() {
        for (int i = 0; i < 31; i++) {
            r = r.addTodaysSurveys(surveyList);
        }
        surveyList.add(new Survey(1, 10));
        r = r.addTodaysSurveys(surveyList);
        surveyList.clear();
        r = r.addTodaysSurveys(surveyList);
        surveyList.add(new Survey(2, 5));
        r = r.addTodaysSurveys(surveyList);
        assertEquals(15, r.totalSongDownloads(1, 2000));
    }

    // works with a list containing many months of data
    @Test
    public void checkTotalSongDownloads5() {
        for (int i = 0; i < 31; i++) {
            r = r.addTodaysSurveys(surveyList);
        }
        surveyList.add(new Survey(1, 10));
        r = r.addTodaysSurveys(surveyList);
        surveyList.clear();
        r = r.addTodaysSurveys(surveyList);
        surveyList.add(new Survey(2, 5));
        r = r.addTodaysSurveys(surveyList);
        surveyList.clear();
        for (int i = 0; i < 31; i++) {
            r = r.addTodaysSurveys(surveyList);
        }
        for (int i = 0; i < 31; i++) {
            r = r.addTodaysSurveys(surveyList);
        }
        assertEquals(15, r.totalSongDownloads(1, 2000));
    }

    // Finds the best rank in a month
    @Test
    public void checkBestRankThisMonth1() {
        surveyList.add(new Survey(1, 10));
        r = r.addTodaysSurveys(surveyList);
        surveyList.clear();
        r = r.addTodaysSurveys(surveyList);
        surveyList.add(new Survey(2, 5));
        r = r.addTodaysSurveys(surveyList);
        assertEquals(1, r.bestRankThisMonth());
    }

    // Finds the best rank in the CURRENT month (even if there is a better option
    // previously)
    @Test
    public void checkBestRankThisMonth2() {
        for (int i = 0; i < 29; i++) {
            r = r.addTodaysSurveys(surveyList);
        }
        surveyList.add(new Survey(1, 10));
        r = r.addTodaysSurveys(surveyList);
        surveyList.clear();
        r = r.addTodaysSurveys(surveyList);
        surveyList.add(new Survey(2, 5));
        r = r.addTodaysSurveys(surveyList);
        assertEquals(2, r.bestRankThisMonth());
    }

    // tests when month is full of values
    @Test
    public void checkBestRankThisMonth3() {
        for (int i = 0; i < 28; i++) {
            r = r.addTodaysSurveys(surveyList);
        }
        surveyList.add(new Survey(1, 10));
        r = r.addTodaysSurveys(surveyList);
        surveyList.clear();
        r = r.addTodaysSurveys(surveyList);
        surveyList.add(new Survey(2, 5));
        r = r.addTodaysSurveys(surveyList);
        assertEquals(2, r.bestRankThisMonth());
    }
}
