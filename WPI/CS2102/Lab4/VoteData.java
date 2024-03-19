package Lab4;

import java.util.LinkedList;

class VoteData {
    // a list of the candidates
    LinkedList<String> ballot = new LinkedList<String>();
    // stores the number of votes for each candidate
    LinkedList<String> votes = new LinkedList<String>();

    VoteData() {
    }

    // record a vote for a candidate
    void castVote(String forCandidate) {
        votes.add(forCandidate);
    }

    // add candidate to the ballt
    void addCandidate(String name) {
        ballot.add(name);
    }

    // return list of all the candidates
    LinkedList<String> candidateList() {
        return this.ballot;
    }

    // count votes for a given candidate
    public int countVotes(String forcand) {
        int numvotes = 0;
        for (int vote = 0; vote < votes.size(); vote++) {// size-1 is one less than the needed, would be size-1 if it
                                                         // was <=
            if (votes.get(vote).toLowerCase().equals(forcand.toLowerCase())) {// comparing a lower case version of the
                                                                              // string to an unedited input
                numvotes++;// adding the current position to the number of votes makes no sense
            }
        }
        return numvotes;
    }

    // produce the name of the candidate with the most votes
    public String winner() {
        String currWinner = ballot.get(0);
        for (String candidate : ballot) {
            if (countVotes(currWinner) < countVotes(candidate)) {
                currWinner = candidate;// backwards
            }
        }
        return currWinner;
    }

    // produce the largest number of consecutive votes for the candidate
    // within the list of votes
    public int longestStreak(String forCandidate) {
        int maxStreak = 0; // longest sequence of votes for this candidate
        int currStreak = 0; // current consecutive votes for this candidate
        String lastVote = "";

        for (String vote : votes) {
            lastVote = vote;

            if (lastVote.equals(forCandidate)) {// flipped if statements
                if (vote.equals(forCandidate)) {
                    currStreak = currStreak + 1;
                } 
                else{
                    currStreak = 0;//should be currStreak, not maxStreak
                }
            }
            if (currStreak > maxStreak) {
                maxStreak = currStreak;// shouldn't reset streak here
            }
        }
        return maxStreak;
    }
}
