package HW2;
import java.util.LinkedList;

public class WritingResult extends AbsWriting{

    public WritingResult(double words, int update) {
        super(words, update);
    }

    public WritingResult nextChapter(double words){
        chapters.add(words);
        return this;
    }

    public double differenceFromGoal() {
        if ((50000 - addChapters()) / (30 - update + 1) > 0)
            return (50000 - addChapters()) / (30 - update + 1);
        return 0;
    }
}
