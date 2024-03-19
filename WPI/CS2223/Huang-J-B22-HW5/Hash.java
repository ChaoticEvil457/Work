import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class Hash {
    public static void main(String args[]) throws IOException {
        int C = 123;// larger hash value than every value in the table
        int m = 293;// size of hash table
        File f = new File("EdgarAllanPoeBellsB2022groomed.txt");// poe file
        FileWriter writer = new FileWriter("outputTable.txt");// output file
        Hashtable<Integer, String> table = new Hashtable<>(m);// hash table, int key and string value, size of 293
        Scanner scan = new Scanner(f);// file reader
        String word;// holds the current word
        int hashVal;// holds the current hash value
        while (scan.hasNext()) {
            word = clean(scan.next());// removes extra characters from the word and stores it
            hashVal = hash(word, C, m);// hashes the word
            if (!table.contains(word) && table.get(hashVal) != null) {// if the word is in the table but the spot is
                                                                      // filled
                while (table.get(hashVal) != null) {// cycle through the table until you find an empty slot
                    hashVal++;
                    if (hashVal == m) {// wraps around
                        hashVal = 0;
                    }
                }
                table.put(hashVal, word);// inserts the word
            } else {
                table.putIfAbsent(hashVal, word);// inserts non-duplicate words
            }
        }
        table.forEach((key, val) -> {
            try {
                writer.write(key + " " + val + " " + hash(val, C, m) + "\n");// writes each value to the output file
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        int gap = 0;// stores the size of the largest gap (sequential empty spaces)
        int gapPos = 0;// stores the position of the largest gap
        int temp = 0;// counts the number of sequential gaps
        int cluster = 0;// counts the number of sequential filled values
        int largeCluster = 0;// stores the size of the largest cluster
        int nonEmptySpaces = 0;// stores the number of non-empty spaces
        int clusterPos = 0;// stores the position of the largest cluster
        int realHash = 0;// the hashed value of the current value
        int bigDifference = 0;// the difference between the hashed value and the stored key
        int prevHash = 0;// the previous hashed value (for counting number of same hashes)
        int commonHash = 0;// stores the hash with the most values
        int mostWords = 1;// stores the number of words stored in the most common hash
        int mostWordsTemp = 1;// counts the number of sequential words with the same hash
        String bigDiff = "";// stores the word with the biggest difference between key and hash
        for (int i = 0; i < m; i++) {
            if (table.get(i) == null) {// if the spot is empty
                cluster = 0;// reset the filled spot counter
                temp++;// increase the gap counter
                if (temp > gap) {// if the number of gaps if bigger than the currently held number
                    gap++;// increase largest number of sequential gaps
                    gapPos = i - gap;// store gap position
                }
            } else {// if the spot is filled
                realHash = hash(table.get(i), C, m);// get the real hash value for the given spot
                if (differenceFromHash(realHash, i) > bigDifference) {// checks difference between hash and key
                    bigDifference = differenceFromHash(realHash, i);// stores the difference
                    bigDiff = table.get(i);// stores the value
                }
                if (realHash == prevHash) {// checks if the hash is used multiple times
                    mostWordsTemp++;// increase most hashed to a specific value counter
                    if (mostWordsTemp > mostWords) {// if it's bigger than the currently stored value
                        mostWords++;// increase the largest hash value
                        commonHash = realHash;// store the value
                    }
                } else {
                    mostWordsTemp = 1;// resets the counter
                    prevHash = realHash;// stores the current hash
                }
                cluster++;// increase largest cluster size counter
                nonEmptySpaces++;// increase number of non-empty spaces counter
                temp = 0;// reset gap counter
                if (cluster > largeCluster) {// if current cluster is bigger than stored value
                    largeCluster++;// increase largest stored cluster size
                    clusterPos = i - largeCluster;// store the position
                }
            }
        }
        // formatting and printing
        System.out.println("There are " + nonEmptySpaces + " non-empty addresses in the table, so the load factor is "
                + (((float) nonEmptySpaces) / ((float) m)) + ".\nThe longest empty area in the table is "
                + gap
                + " spaces wide from " + (gapPos + 1) + " to " + (gapPos + gap) + ".\nThe largest cluster is "
                + largeCluster
                + " from "
                + (clusterPos + 1) + " to " + (clusterPos + largeCluster) + ".\n" + commonHash
                + " is one of the hashes with the greatest number of distinct words with " + mostWords
                + " words hashing to that value.\n" + bigDiff + " is farthest from its actual hash value with "
                + bigDifference + " spaces in between");
        writer.close();
        scan.close();
    }

    /**
     * Hashes the given word using modulo m and constant C
     * 
     * @param word Given word being hashed
     * @param C    Number bigger than any ascii value being used
     * @param m    size of hash table
     * @return returns the hashed word
     */
    public static int hash(String word, int C, int m) {
        int h = 0;
        for (int i = 0; i < word.length(); i++) {
            h = (h * C + word.charAt(i)) % m;
        }
        return h;
    }

    /**
     * Cleans the given word (removes extra characters like . or ,)
     * 
     * @param word given word
     * @return cleaned string
     */
    public static String clean(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != 39 && word.charAt(i) != 45 && !(word.charAt(i) > 64 && word.charAt(i) < 91)
                    && !(word.charAt(i) > 96 && word.charAt(i) < 123)) {
                word = word.substring(0, i) + word.substring(i + 1);
            }
        }
        return word;
    }

    /**
     * Gets the difference between the real hash and the key. Accounts for
     * wraparound
     * 
     * @param realHash real hash value
     * @param key      key
     * @return returns the difference
     */
    public static int differenceFromHash(int realHash, int key) {
        if (key - realHash > 293 - key) {
            return key - realHash;
        } else {
            return key - 293;
        }
    }
}
