import java.util.List;

class EvenNumberIterator implements Iterator {

    List<Integer> numbers;
    int position = 0;

    EvenNumberIterator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean hasNext() {
        while (position < numbers.size() && numbers.get(position) % 2 != 0) {
            position++;
        }
        return position < numbers.size();
    }

    public int next() {
        return numbers.get(position++);
    }
}