import java.util.LinkedList;

public class Planning {

    public Planning() {

    }

    public double rainfall(LinkedList<Double> rainList) {
        double c = 0;
        int count = 0;
        for (int i = 0; i < rainList.size(); i++) {
            if (rainList.get(i) == -999) {
                i = rainList.size();
            } else if (rainList.get(i) >= 0) {
                count++;
                c += rainList.get(i);
            }
        }
        if (count == 0) {
            return 0;
        }
        return c / count;
    }
}
