class Employee {

    private String name;
    private double salary;
    private String designation;
    
    public void work() {
        System.out.println("Employee is working...");
    }

    public void displayInfo() {
        System.out.println("Name: " + this.name + " Designation: " + this.designation + " Salary: " + this.salary);
    }

    public void setInfo(String name, double salary, String designation) {
        if(name == null || salary <= 0 || designation == null) {
            System.out.println("Please provide all fields");
            return;
        }

        this.name = name;
        this.salary = salary;
        this.designation = designation;
    }

    public double getSalary() {
        return this.salary;
    }
}