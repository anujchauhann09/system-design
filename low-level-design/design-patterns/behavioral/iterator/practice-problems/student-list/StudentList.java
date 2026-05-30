import java.util.ArrayList;
import java.util.List;

class StudentList {

    List<Student> students = new ArrayList<>();

    public void addStudent(String name, int rollNo) {
        students.add(new Student(name, rollNo));
    }

    public StudentIterator createIterator() {
        return new ListIterator();
    }

    private class ListIterator implements StudentIterator {

        int position = 0;

        public boolean hasNext() {
            return position < students.size();
        }

        public Student next() {
            return students.get(position++);
        }
    }
}
