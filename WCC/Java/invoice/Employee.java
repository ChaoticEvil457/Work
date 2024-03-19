package invoice;

//Employee.java
/**
 * @author WCC Computer User
 *         Employee abstract superclass implements Pay.
 *         Employee has a first Name, last Name and SSN
 */

public abstract class Employee implements Pay {
   private String firstName;
   private String lastName;
   private String socialSecurityNumber;

   // three-argument constructor
   /**
    * @param first
    * @param last
    * @param ssn
    */
   public Employee(String first, String last, String ssn) {
      firstName = first;
      lastName = last;
      socialSecurityNumber = ssn;
   }
   // set first name

   /**
    * @param first
    */
   public void setFirstName(String first) {
      firstName = first;
   }

   // return first name

   /**
    * @return firstNmae
    */
   public String getFirstName() {
      return firstName;
   }

   // set last name

   /**
    * @param last
    */
   public void setLastName(String last) {
      lastName = last;
   }

   // return last name
   public String getLastName() {
      return lastName;
   }

   // set social security number
   public void setSocialSecurityNumber(String ssn) {
      socialSecurityNumber = ssn;
   }

   // return social security number
   public String getSocialSecurityNumber() {
      return socialSecurityNumber;
   }

   // return String representation of Employee object
   @Override
   public String toString() {
      return "\nemployee: " + getFirstName() + " " + getLastName() +
            "\nsocial security number: " + getSocialSecurityNumber();
   }

   // Note: We do not implement Pay method getPaymentAmount here so
   // this class must be declared abstract to avoid a compilation error.
}
