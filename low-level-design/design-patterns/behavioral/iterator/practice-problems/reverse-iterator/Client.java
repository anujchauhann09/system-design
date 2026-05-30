class Client {

    public static void main(String args[]) {

        NumberCollection collection = new NumberCollection();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);

        Iterator iterator = collection.createReverseIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
