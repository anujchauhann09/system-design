import java.util.ArrayList;
import java.util.List;

class NumberCollection {

    List<Integer> numbers = new ArrayList<>();

    public void add(int number) {
        numbers.add(number);
    }

    public Iterator createReverseIterator() {
        return new ReverseIterator();
    }

    private class ReverseIterator implements Iterator {

        int position = numbers.size() - 1;

        public boolean hasNext() {
            return position >= 0;
        }

        public int next() {
            return numbers.get(position--);
        }
    }
}
