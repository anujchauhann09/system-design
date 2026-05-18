class Student {

    private String name;
    private int marks;

    public void setName(String name) {

        if(name == null) {
            System.out.println("Please provide name");
            return;
        }
        else if(name.trim().isEmpty()) {
            System.out.println("Please provide name");
            return;
        }

        this.name = name;
    }

    public void setMarks(int marks) {

        if(marks < 0 || marks > 100) {
            System.out.println("Please provide valid marks");
            return;
        }

        this.marks = marks;
    }

    public String getName() {
        return this.name;
    } 

    public int getMarks() {
        return this.marks;
    }
}

