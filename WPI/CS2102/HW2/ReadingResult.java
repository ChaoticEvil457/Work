package HW2;

import java.util.ArrayList;

public class ReadingResult implements IChallenge {
    int goal;// goal for average books per day
    ArrayList<BooksRead> books;

    public ReadingResult(int goal, BooksRead fiction, BooksRead nonFiction) {
        books = new ArrayList<BooksRead>();
        this.goal = goal;
        books.add(fiction);
        books.add(nonFiction);
    }

    public String bestGenreByType(boolean invested) {
        BooksRead highest = null;
        if (books.isEmpty() || books.get(0) == null) {
            return null;
        } else {
            highest = books.get(0);
        }
        for (BooksRead b : books) {
            if (b == null) {
                break;
            }
            if ((b.read > highest.read && invested == !b.skimmed) || (b.read > highest.read && !invested)) {
                highest = b;
            }
        }
        if (highest == books.get(0) && books.get(0).skimmed && invested) {
            return null;
        }
        return highest.genre;
    }

    public ReadingResult readSomeBooks(BooksRead b) {
        books.add(b);
        return this;
    }

    public double averagePerDay() {// average books read per day
        if (books.isEmpty()) {
            return 0;
        }
        double c = 0;
        for (BooksRead i : books) {
            c += i.read;
        }
        return c / 31; // books read / 31 days in October
    }

    public double differenceFromGoal() {// how many books per day more are needed to reach your goal
        if (goal - averagePerDay() > 0)
            return goal - averagePerDay();
        return 0;
    }
}
