package Feb1;

import java.util.Date;
import java.util.GregorianCalendar;

public class EmployeeToDo implements Cloneable {

   private String name;
   private double salary;
   private Date hireDay;

   public EmployeeToDo(String name, double salary) {
      this.name = name;
      this.salary = salary;
      hireDay = new Date();
   }

   /**
    * Set the hire day to a given date.
    * 
    * @param year  the year of the hire day
    * @param month the month of the hire day
    * @param day   the day of the hire day
    */
   public void setHireDay(int year, int month, int day) {
      Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();

      // Example of instance field mutation
      hireDay.setTime(newHireDay.getTime());
   }

   public void raiseSalary(double byPercent) {
      double raise = salary * byPercent / 100;
      salary += raise;
   }

   public String toString() {
      return "Employee[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
   }
   
   public Object clone() {
      try {
         EmployeeToDo eclone = (EmployeeToDo) super.clone();
         eclone.hireDay = (Date) hireDay.clone();
         return eclone;

      } catch (CloneNotSupportedException ex) {
         return null;
      }
   }
}