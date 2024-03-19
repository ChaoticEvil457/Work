public class Survey {
    private int rank;
    private int downloads;

    public Survey(int rank, int downloads) {
        this.rank = rank;
        this.downloads = downloads;
    }

    /**
     * Gets the rank recorded by the survey
     * 
     * @return returns the rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * Gets the number of downloads recorded by the survey
     * 
     * @return returns the number of downloads
     */
    public int getDownloads() {
        return downloads;
    }
}
