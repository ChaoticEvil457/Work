package invoice;

public class CommissionEmployee extends Employee {
    private double grossSales;
    private double commissionRate;

    /**
     * Constructor
     * 
     * @param firstName      employee first name
     * @param lastName       employee last name
     * @param ssn            employee social security number
     * @param grossSales     money made from sales
     * @param commissionRate commission rate as a decimal, not a percentage
     */
    public CommissionEmployee(String firstName, String lastName, String ssn, double grossSales, double commissionRate) {
        super(firstName, lastName, ssn);
        this.grossSales = Math.round(grossSales * 100) / 100.0;// round to 2 decimal places
        this.commissionRate = commissionRate;
    }

    /**
     * getters get their respective variable
     * 
     */
    public double getCommissionRate() {
        return commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public double getPaymentAmount() {
        return commissionRate * grossSales;
    }

    /**
     * setters set their respective variable
     * 
     */
    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = Math.round(grossSales * 100) / 100.0;// round to 2 decimal places
    }

    /**
     * String format for commission employee
     * 
     * commission employee: firstName lastName
     * social security number: ###-##-####
     * gross sales: $###.##; commission rate: ##.##
     * payment due: $###.##
     */
    public String toString() {
        return "\ncommission employee: " + getFirstName() + " " + getLastName() +
                "\nsocial security number: " + getSocialSecurityNumber() +
                "\ngross sales: $" + String.format("%,.2f", getGrossSales()) + "; commission rate: "
                + String.format("%,.2f", getCommissionRate()) +
                "\npayment due: $" + String.format("%,.2f", getPaymentAmount());
    }

}
