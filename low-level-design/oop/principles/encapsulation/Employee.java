class Employee {
    
    private String name;
    private float salary;

    public void setSalary(float amount) {

        if(amount > 0) {
            this.salary = amount;
        }
    }

    public int getSalary() {
        return this.salary;
    }
}