package invoice;

public class PayTest {
    public static void main(String[] args) {
        // create six-element Pay array
        Pay[] payItems = new Pay[5];

        // populate array with objects that implement Pay
        payItems[0] = new ProductInvoice("9000", "nut", 6, 100.00);
        payItems[1] = new ProductInvoice("56789", "headlight", 2, 59.95);
        payItems[2] = new SalariedEmployee("Joe", "Kane", "121-11-1111", 900.00);
        payItems[3] = new HourlyEmployee("Jane", "Doe", "342-22-9222", 20.75, 50);
        payItems[4] = new CommissionEmployee(
                "Sue", "Jones", "333-33-3333", 20000, .09);
        System.out.println("\nInvoices and Employees processed polymorphically:");
        for (Pay p : payItems) {
            System.out.println(p);
        }
        System.out.println("\n*************************************************************");
    }
}
