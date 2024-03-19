package invoice;

public class SalariedEmployee extends Employee {
    private double salary;

    /**
     * Constructor
     * 
     * @param firstName employee first name
     * @param lastName  employee last name
     * @param ssn       employee social security number
     * @param salary    weekly salary
     */
    public SalariedEmployee(String firstName, String lastName, String ssn, double salary) {
        super(firstName, lastName, ssn);
        this.salary = Math.round(salary * 100) / 100.0;
    }

    /**
     * getters get their respective variable
     * 
     */
    public double getWeeklySalary() {
        return salary;
    }

    public double getPaymentAmount() {
        return Math.round(salary * 1.1 * 100) / 100.0;
    }

    /**
     * setters set their respective variable
     * 
     */
    public void setWeeklySalary(double salary) {
        this.salary = Math.round(salary * 100) / 100.0;
    }

    /**
     * String format for salaried employee, increases salary by 10%
     * 
     * salaried employee: firstName lastName
     * social security number: ###-##-####
     * weekly salary: $###.##
     * new base salary with 10% increase is: $###.##
     * payment due: $###.##
     * 
     */
    public String toString() {
        String text = "\nsalaried employee: " + getFirstName() + " " + getLastName() +
                "\nsocial security number: " + getSocialSecurityNumber() +
                "\nweekly salary: $" + String.format("%,.2f", getWeeklySalary()) +
                "\nnew base salary with 10% increase is: $" + String.format("%.2f", getPaymentAmount()) +
                "\npayment due: $" + String.format("%,.2f", getPaymentAmount());
        setWeeklySalary(getPaymentAmount());
        return text;
    }
}
