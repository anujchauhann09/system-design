import java.util.List;

class NestedList {

    List<List<Integer>> data;

    NestedList(List<List<Integer>> data) {
        this.data = data;
    }

    public Iterator createIterator() {
        return new FlattenIterator();
    }

    private class FlattenIterator implements Iterator {

        int outer = 0;
        int inner = 0;

        public boolean hasNext() {
            while (outer < data.size() && inner >= data.get(outer).size()) {
                outer++;
                inner = 0;
            }
            return outer < data.size();
        }

        public int next() {
            return data.get(outer).get(inner++);
        }
    }
}
