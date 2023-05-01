import java.util.Scanner;

class Employee {

    Scanner input = new Scanner(System.in);
    public String name;
    public int empID;

    public String toString() {
        String str = "Employee Name: " + name + "(ID:) " + empID;
        return str;
    }

    Employee(String name, int empID) {
        this.name = name;
        this.empID = empID;
    }
}

class HourlyEmployee extends Employee {
    Scanner input = new Scanner(System.in);
    public int hourlyIncome;
    public int totalHours;
    int totalIncome;

    HourlyEmployee(String name, int empID, int hourlyIncome) {
        super(name, empID);
        System.out.println("Enter your total hours (Hourly Employee)");
        totalHours = input.nextInt();
    }

    public int calculateHourlyIncome() {
        totalIncome = totalHours * 500;
        return totalIncome;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        String str = "This month salary = 150 x 500 = " + calculateHourlyIncome();
        return str;
    }
}

class PermanentEmployee extends Employee {
    int income;

    PermanentEmployee(String name, int empID, int hourlyIncome) {
        super(name, empID);
    }

    public int calculateIncome() {
        income = 180 * 500;
        return income;
    }

    public String toString() {
        System.out.println(super.toString());
        String str = "This month salary @ 500PKR/Hour: " + calculateIncome();

        return str;
    }
}

public class Test {
    public static void main(String[] args) {
        Employee e = new Employee("Ali", 731);
        HourlyEmployee he = new HourlyEmployee("Ahmed", 23, 500);
        PermanentEmployee pe = new PermanentEmployee("Huzaifa", 104, 500);
        System.out.println(e.toString());
        System.out.println(he.toString());
        System.out.println(pe.toString());
    }
}
