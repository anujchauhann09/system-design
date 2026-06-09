class Client {
    public static void main(String[] args) {

        // both calls return the very same Logger object
        Logger a = Logger.getInstance();
        Logger b = Logger.getInstance();

        a.log("Application started");
        b.log("Doing some work");

        System.out.println("Same instance? " + (a == b)); // true
    }
}
