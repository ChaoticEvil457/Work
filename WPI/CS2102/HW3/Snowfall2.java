

import java.util.LinkedList;

class Snowfall2 {
  Snowfall2() {
  }

  public LinkedList<MaxInchReport> l = new LinkedList<>();

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
    return null;
  }

  public void countSnow(LinkedList<Double> data, int month, double date, double inches) {
    if (data.isEmpty()) {
      return;
    }
    if (month == extractMonth(date)) {
      if (isDate(data.peek())) {
        l.add(new MaxInchReport(date, inches));
        countSnow(data, month, data.pop(), 0);
      } else {
        countSnow(data, month, date, data.pop());
      }
    } else {
      countSnow(data, month, data.pop(), 0);
    }
  }
}