

import java.util.LinkedList;

class Snowfall1 {
  Snowfall1() {
  }

  // checks whether a datum is a date
  boolean isDate(double anum) {
    return (int) anum >= 101;
  } // Jan 1st
  // extracts the month from an 4-digit date

  int extractMonth(double dateNum) {
    return ((int) (dateNum / 100));
  }

  public LinkedList<MaxInchReport> dailyMaxForMonth(LinkedList<Double> data,
      int month) {
    if (data.isEmpty()) {
      return null;
    }
    double maxSnow = 0;
    double date = data.getFirst();
    LinkedList<MaxInchReport> l = new LinkedList<>();
    for (int i = 1; i < data.size(); i++) {
      if (month == extractMonth(date)) {
        if (isDate(data.get(i))) {
          l.add(new MaxInchReport(date, maxSnow));
          maxSnow = 0;
          date = data.get(i);

        } else {
          if (maxSnow < data.get(i)) {
            maxSnow = data.get(i);
          }
        }
      } else {
        date = data.get(i);
      }
    }
    l.add(new MaxInchReport(date, maxSnow));
    return l;
  }
}
