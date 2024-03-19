package HW2;
import java.util.LinkedList;

abstract class AbsWriting implements IChallenge {
    LinkedList<Double> chapters;// chapters written
    int update;// date last updated

    AbsWriting(double words, int update) {
        chapters = new LinkedList<Double>();
        chapters.add(words);
        this.update = update;
    }

    public double addChapters() {
        if (chapters.isEmpty()) {
            return 0;
        }
        double c = 0;
        for (int i = 0; i < chapters.size(); i++) {
            c += chapters.get(i);
        }
        return c;
    }

    public double averagePerDay() {
        return addChapters() / update;
    }
}