package invoice;

public class ProductInvoice implements Pay {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    /**
     * Constructor
     * 
     * @param partNumber      part identification number
     * @param partDescription name of the part
     * @param quantity        number of parts
     * @param pricePerItem    cost of individual parts
     */
    public ProductInvoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.pricePerItem = Math.round(pricePerItem * 100) / 100.0;
    }

    /**
     * getters get their respective variable
     * 
     * 
     */
    public String getPartDescription() {
        return partDescription;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPaymentAmount() {
        return pricePerItem * quantity;
    }

    /**
     * setters set their respective variable
     * 
     */
    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = Math.round(pricePerItem * 100) / 100.0;// rounds to 2 decimal places
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * String format for product invoice
     * 
     * Product Invoice:
     * part number: ### (description)
     * quantity: ###
     * price per item: $###.##
     * payment due: $###.##
     */
    public String toString() {
        return "\nProduct Invoice:" +
                "\npart number: " + getPartNumber() + " (" + getPartDescription() + ")" +
                "\nquantity: " + getQuantity() +
                "\nprice per item: $" + String.format("%,.2f", getPricePerItem()) +
                "\npayment due: $" + String.format("%,.2f", getPaymentAmount());
    }
}
