import java.util.Arrays;
import java.util.List;

class Client {

    public static void main(String args[]) {

        List<List<Integer>> data = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(3, 4),
            Arrays.asList(5)
        );

        NestedList nestedList = new NestedList(data);

        Iterator iterator = nestedList.createIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
