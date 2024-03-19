public class Date {
    int day;
    int month;
    int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // isBefore returns true if the current date is before the given date
    public boolean isBefore(Date d) {
        if (this.year > d.year) {
            return true;
        }
        if (this.year == d.year && this.month > d.month) {
            return true;
        }
        if (this.year == d.year && this.month == d.month && this.day > day) {
            return true;
        }
        return false;
    }
}
