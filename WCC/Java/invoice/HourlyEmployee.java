package invoice;

public class HourlyEmployee extends Employee {
    private double wage;
    private double hours;

    /**
     * Constructor
     * 
     * @param firstName employee first name
     * @param lastName  employee last name
     * @param ssn       employee social security number
     * @param wage      earnings per hour
     * @param hours     hours worked per week
     */
    public HourlyEmployee(String firstName, String lastName, String ssn, double wage, double hours) {
        super(firstName, lastName, ssn);
        this.wage = Math.round(wage * 100) / 100.0;// rounds to 2 decimal places
        this.hours = hours;
    }

    /**
     * getters get their respective variables
     * 
     */
    public double getHours() {
        return hours;
    }

    public double getWage() {
        return wage;
    }

    public double getPaymentAmount() {// rounds to 2 decimal places
        if (hours > 40) {// overtime pay
            return Math.round((wage * 40 + wage * (hours - 40) * 1.5) * 100) / 100.0;
        }
        return Math.round(wage * hours * 100) / 100.0;
    }

    /**
     * setters set their respective variable
     * 
     */
    public void setHours(double hours) {
        this.hours = hours;
    }

    public void setWage(double wage) {
        this.wage = Math.round(wage * 100) / 100.0;// round to 2 decimal places
    }

    /**
     * String format for hourly employee
     * 
     * hourly employee: firstName lastName
     * social security number: ###-##-####
     * hourly wage: $###.##; hours worked: ##.##
     * payment due: $###.##
     */
    public String toString() {
        return "\nhourly employee: " + getFirstName() + " " + getLastName() +
                "\nsocial security number: " + getSocialSecurityNumber() +
                "\nhourly wage: $" + String.format("%,.2f", getWage()) + "; hours worked: "
                + String.format("%,.2f", getHours()) +
                "\npayment due: $" + String.format("%,.2f", getPaymentAmount());
    }

}
