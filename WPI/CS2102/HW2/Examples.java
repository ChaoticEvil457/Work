package HW2;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.LinkedList;

public class Examples {
    WritingResult w1 = new WritingResult(10, 10);
    WritingResult w2 = new WritingResult(20, 10);

    // test making BooksRead
    BooksRead booksRead1 = new BooksRead(1.0, "fiction", false);
    BooksRead booksRead2 = new BooksRead(3.5, "non-fiction", true);

    // test making each of the Result classes
    ReadingResult readingResult = new ReadingResult(2, booksRead1, booksRead2); // goal average books per day, fiction
                                                                                // books read, non fiction books read.
    WritingResult writingResult = new WritingResult(25000.5, 15); // words written, last day novel was updated
    ChallengeResult challengeResult = new ChallengeResult(readingResult, writingResult);

    // test making literarians
    Literarian literarian1 = new Literarian("Litty", challengeResult);
    Literarian literarian2 = new Literarian("Reeds", challengeResult);

    // test averagePerDay and differenceFromGoal methods

    PoemResult poemResult = new PoemResult(100, 5, 1);

    BooksRead techManuals = new BooksRead(100, "technical manuals", false);

    String s = readingResult.bestGenreByType(false);

    // test LitJam
    LinkedList<Literarian> lits = new LinkedList<Literarian>();
    LinkedList<Literarian> lits2 = new LinkedList<Literarian>();

    @Test
    public void checkNextChapter1() {
        w1.nextChapter(10);
        assertEquals(20, w1.addChapters(), .1);
    }

    @Test
    public void checkNextChapter2() {
        w2.nextChapter(10);
        assertEquals(30, w2.addChapters(), .1);
    }

    @Test
    public void checkAveragePerDay1() {
        assertEquals(1, w1.averagePerDay(), 0.1);
    }

    @Test
    public void checkAveragePerDay2() {
        assertEquals(2, w2.averagePerDay(), 0.1);
    }

    @Test
    public void checkDifferenceFromGoal1() {
        assertEquals(2380.48, w1.differenceFromGoal(), 0.1);
    }

    @Test
    public void checkDifferenceFromGoal2() {
        assertEquals(2380, w2.differenceFromGoal(), 0.1);
    }

    @Test
    public void checkNextPoem1() {
        assertEquals(110,
                poemResult.nextPoem(10, true).addChapters(), 0.1);
    }

    @Test
    public void checkNextPoem2() {
        assertEquals(2,
                poemResult.nextPoem(10, true).weeksSubmitted, 0.1);
    }

    @Test
    public void checkDifferenceFromGoalPoem1() {
        assertEquals(11.11, poemResult.differenceFromGoal(), .1);
    }

    @Test
    public void checkAveragePerDay3() {
        assertEquals(0.15, readingResult.averagePerDay(), 0.1);
    }

    @Test
    public void checkBestGenreByType1() {
        assertEquals("non-fiction", readingResult.bestGenreByType(false));
    }

    @Test
    public void checkBestGenreByType2() {
        assertEquals("fiction", readingResult.bestGenreByType(true));
    }

    ReadingResult readingResult2 = new ReadingResult(2, null, null);
    ReadingResult readingResult3 = new ReadingResult(2, null, booksRead2);

    @Test
    public void checkBestGenreByType3() {
        assertEquals(null, readingResult2.bestGenreByType(false));
    }

    @Test
    public void checkBestGenreByType4() {
        assertEquals(null, readingResult3.bestGenreByType(true));
    }

    @Test
    public void checkFinalScore() {
        lits.add(literarian1);
        LitJam litJam = new LitJam(5, lits);
        assertEquals(5, litJam.finalScoreForLiterarian("Litty"));
    }

    @Test
    public void checkAnyImprovement() {
        lits.add(literarian1);
        LitJam litJam1 = new LitJam(5, lits);
        Literarian l1 = new Literarian("Litty", new ChallengeResult(new ReadingResult(0, booksRead2, booksRead1), w1));
        l1.result.readResult = l1.result.readResult
                .readSomeBooks(new BooksRead(300, "comics", false));
        l1.result.readResult = l1.result.readResult
                .readSomeBooks(new BooksRead(300, "2", false));
        l1.result.readResult = l1.result.readResult
                .readSomeBooks(new BooksRead(300, "3", false));
        l1.result.writeResult = l1.result.writeResult.nextChapter(300000);
        lits2.add(l1);
        LitJam litJam2 = new LitJam(5, lits2);
        assertEquals(true, litJam2.anyImprovement(litJam1));
    }
}
