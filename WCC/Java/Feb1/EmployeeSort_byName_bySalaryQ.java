package Feb1;

import java.util.Arrays;

public class EmployeeSort_byName_bySalaryQ {
   public static void main(String[] args) {
      Employee[] staff = new Employee[5];

      staff[0] = new Employee("Harry Hacker", 35000);
      staff[1] = new Employee("Carl Cracker", 75000);
      staff[2] = new Employee("Tony Tester", 38000);
      staff[3] = new Employee("Abigail Lawford", 52000);
      staff[4] = new Employee("Miguel Cardona", 66000);

      // *****************************
      // Sort by Salary
      // *****************************
      // print out information about all Employee objects
      // *****************************
      // Sort by Name
      // *****************************
      // print out information about all Employee objects
      Employee.setSort(Employee.bySalary);
      System.out.println("Sort by salary");
      Arrays.sort(staff);
      for (Employee e : staff) {
         System.out.println("name = " + e.getName() + ", salary = $" + e.getSalary());
      }
      Employee.setSort(Employee.byName);
      System.out.println("Sort by name");
      Arrays.sort(staff);
      for (Employee e : staff) {
         System.out.println("name = " + e.getName() + ", salary = $" + e.getSalary());
      }
   }
}

class Employee implements Comparable<Employee> {

   private String name;
   private double salary;

   // **************************************************************
   // Added three class data members and a class member function.
   static public int sort_type;
   static public final int byName = 1;
   static public final int bySalary = 2;

   // **************************************************************

   public Employee(String n, double s) {
      name = n;
      salary = s;
   }

   public String getName() {
      return name;
   }

   public double getSalary() {
      return salary;
   }

   public void raiseSalary(double byPercent) {
      double raise = salary * byPercent / 100;
      salary += raise;
   }

   public static void setSort(int sort_type) {
      Employee.sort_type = sort_type;
   }

   @Override
   public int compareTo(Employee o) {
      switch (sort_type) {
         case bySalary:
            if (salary < o.salary)
               return -1;
            if (salary > o.salary)
               return 1;
            return 0;
         case byName:
            return name.compareTo(o.name);
         default:
            return -1;
      }
   }

}