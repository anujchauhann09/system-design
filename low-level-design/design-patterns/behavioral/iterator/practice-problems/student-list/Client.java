class Client {

    public static void main(String args[]) {

        StudentList studentList = new StudentList();
        studentList.addStudent("Aarav", 101);
        studentList.addStudent("Diya", 102);
        studentList.addStudent("Kabir", 103);

        StudentIterator iterator = studentList.createIterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.rollNo + " - " + student.name);
        }
    }
}
