package HW2;
import java.util.LinkedList;

public class PoemResult extends AbsWriting {
    int weeksSubmitted;

    public PoemResult(double words, int update, int weeksSubmitted) {
        super(words, update);
        this.weeksSubmitted = weeksSubmitted;
    }

    public double differenceFromGoal() {
        if (weeksSubmitted == 0) {
            return (addChapters() * (4 - weeksSubmitted)) / (31 - update + 1);
        }

        return ((addChapters() / weeksSubmitted) * (4 - weeksSubmitted)) / (31 - update + 1);
    }

    public PoemResult nextPoem(double words, boolean submitted) {
        this.chapters.add(words);
        if (submitted) {
            weeksSubmitted++;
        }
        return this;
    }

}
