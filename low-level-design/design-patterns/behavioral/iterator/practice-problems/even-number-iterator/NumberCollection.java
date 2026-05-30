import java.util.ArrayList;
import java.util.List;

class NumberCollection {

    List<Integer> numbers = new ArrayList<>();

    public void add(int number) {
        numbers.add(number);
    }

    public Iterator createEvenNumberIterator() {
        return new EvenNumberIterator(numbers);
    }
}