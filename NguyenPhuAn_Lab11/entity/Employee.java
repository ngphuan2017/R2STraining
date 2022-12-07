package entity;

public class Employee {
    private String empCode;
    private String name;
    private int salary;

    public Employee() {
    }

    public Employee(String empCode, String name, int salary) {
        this.empCode = empCode;
        this.name = name;
        this.salary = salary;
    }

    public String getEmpCode() {
        return this.empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
