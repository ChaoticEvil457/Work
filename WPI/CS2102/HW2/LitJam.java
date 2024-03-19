package HW2;

import java.util.LinkedList;

public class LitJam {
    int uniqueGenres;
    LinkedList<Literarian> litList;

    public LitJam(int uniqueGenres, LinkedList<Literarian> litList) {
        this.uniqueGenres = uniqueGenres;
        this.litList = litList;
    }

    public LinkedList<String> readingDNF() {
        LinkedList<String> dnfList = new LinkedList<String>();
        for (Literarian l : litList) {
            if (l.result.readResult.books.size() < uniqueGenres) {
                dnfList.add(l.penName);
            }
        }
        return dnfList;
    }

    public int finalScoreForLiterarian(String name) {
        Literarian l = new Literarian("", null);
        for (int i = 0; i < litList.size(); i++) {
            if (litList.get(i).penName == name) {
                l = litList.get(i);
            }
        }
        if(l.result==null){
            return -1;
        }
        int score = 0;
        if (!readingDNF().contains(l.penName)) {
            score += 25;
        }
        for (BooksRead b : l.result.readResult.books) {
            if (!b.skimmed) {
                score += ((int) (b.read)) * 5;
            }
        }
        if (l.result.readResult.differenceFromGoal() == 0) {
            score += 5;
        }
        if (l.result.writeResult.addChapters() >= 50000) {
            score += 25 + 5 * (30 - l.result.writeResult.update);
        }
        return score;
    }
    
    public boolean anyImprovement(LitJam lj) {
        for (Literarian l : this.litList) {
            if (this.finalScoreForLiterarian(l.penName) > lj.finalScoreForLiterarian(l.penName)) {
                return true;
            }
        }
        return false;
    }
    // I don't think there are any helper methods I could use to make anyImprovement
    // better, but finalScore could be shortened
    // significantly throught the addition of helper methods for each of reading
    // results and writing results
}
