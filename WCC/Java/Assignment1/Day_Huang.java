package Assignment1;

public class Day_Huang {
    private String[] weekDays = { "Sunday", "Monday", "Tuesday", "Wednsday", "Thursday", "Friday", "Saturday" };
    private int day = 0;

    Day_Huang() {
    }

    /**
     * Constructor initializes the day to the given weekday held in the weekDays
     * array
     * 
     * @param day given day name
     */
    Day_Huang(String day) {// allows the input of the name of the day
        for (int i = 0; i < weekDays.length; i++) {
            if (weekDays[i].equalsIgnoreCase(day)) {// not case sensitive
                this.day = i;// set the current day to the passed date
            }
        }
        // day isn't changed if invalid
    }

    /**
     * Constructor initializes the day to the given array position
     * 
     * @param day position in the array
     */
    Day_Huang(int day) {// allows the input of the day number
        if (day < 7 && day >= 0) {
            this.day = day;
        }
    }

    /**
     * Sets the day to the given position in the weekDays array
     * 
     * @param day
     */
    public void setDay(int day) {// sets the day to a certain day number
        if (day < 7 && day >= 0) {
            this.day = day;
        } // doesn't change the day if the given day is an invalid number
    }

    /**
     * Sets the day to the position corresponding to the given day name
     * 
     * @param day given day name
     */
    public void setDay(String day) {// sets the day to a specific day
        for (int i = 0; i < weekDays.length; i++) {
            if (weekDays[i].equalsIgnoreCase(day)) {// not case sensitive
                this.day = i;
            }
        } // doesn't change the day if the given day is invalid
    }

    /**
     * Gets the current day
     * 
     * @return the current day
     */
    public String getDay() {
        return weekDays[day];
    }

    /**
     * gets the previous day
     * 
     * @return current day - 1, or 6 if the current day is Sunday (day = 0)
     */
    public String getPrevDay() {
        if (day - 1 < 0) {
            return weekDays[weekDays.length - 1];
        }
        return weekDays[day - 1];
    }

    /**
     * gets the next day
     * 
     * @return current day + 1, or 0 if the current day is Saturday (day = 6)
     */
    public String getNextDay() {
        if (day + 1 >= weekDays.length) {
            return weekDays[0];
        }
        return weekDays[day + 1];
    }

    /**
     * Advances the date by the given amount
     * ex: Monday + 2 is Wednsday, Saturday + 14 is Saturday
     * 
     * @param days number of days to move forwards/backwards
     * @return the new date
     */
    public String changeDateBy(int days) {
        day += days;
        day %= 7;
        return weekDays[day];
    }

    /**
     * Prints the current day
     */
    public void printDay() {
        System.out.println(weekDays[day]);
    }
}

class TestDay {
    public static void main(String[] args) {
        Day_Huang d1 = new Day_Huang();
        Day_Huang d2 = new Day_Huang("Friday");
        Day_Huang d3 = new Day_Huang(2);
        System.out.println(d1.getDay() + "\t = Sunday"); // test constructors and getter
        System.out.println(d2.getDay() + "\t = Friday");
        System.out.println(d3.getDay() + "\t = Tuesday");
        d1.printDay();
        System.out.println(" = Sunday");// printDay works
        d1.setDay("sda"); // invalid date check
        d2.setDay("sunday"); // valid date check
        d3.setDay(1); // valid date check number
        System.out.println(d1.getDay() + "\t = Sunday");
        System.out.println(d2.getDay() + "\t = Sunday");
        System.out.println(d3.getDay() + "\t = Monday");
        d1.setDay(-1); // invalid date check number
        d2.setDay(10); // invalid date check number
        System.out.println(d1.getDay() + "\t = Sunday");
        System.out.println(d2.getDay() + "\t = Sunday");

        System.out.println(d3.getPrevDay() + "\t = Sunday"); // default prev day test
        System.out.println(d3.getNextDay() + "\t = Tuesday"); // default next day test
        System.out.println(d1.getPrevDay() + " = Saturday"); // underflow prev day
        d1.setDay("Saturday");
        System.out.println(d1.getNextDay() + "\t = Sunday");// overflow next day
        d1.setDay(1);
        d1.changeDateBy(2);
        System.out.println(d1.getDay() + " = Wednsday");// changeDateBy default test

        d1.changeDateBy(7);
        System.out.println(d1.getDay() + " = Wednsday");// changeDateBy wraps

        d1.changeDateBy(15);
        System.out.println(d1.getDay() + " = Thursday");// changeDateBy wraps
    }
}
