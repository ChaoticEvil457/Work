public class Transaction {
    private int actNum;
    private double transAmt;
    public Transaction(int actNum, double transAmt){
        this.actNum = actNum;
        this.transAmt = transAmt;
    }

    //gets account number
    public int getActNum() {
        return actNum;
    }
    
    //gets transaction amount
    public double getTransAmt() {
        return transAmt;
    }

    //sets account number
    public void setActNum(int actNum) {
        this.actNum = actNum;
    }

    //sets transaction amount
    public void setTransAmt(double transAmt) {
        this.transAmt = transAmt;
    }
    
}
