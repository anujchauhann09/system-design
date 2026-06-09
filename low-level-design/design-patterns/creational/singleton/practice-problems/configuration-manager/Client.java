class Client {
    public static void main(String[] args) {

        // both calls return the very same ConfigurationManager object
        ConfigurationManager a = ConfigurationManager.getInstance();
        ConfigurationManager b = ConfigurationManager.getInstance();

        System.out.println("app.name = " + a.get("app.name"));
        System.out.println("app.env  = " + a.get("app.env"));

        // a change made through one reference is visible through the other
        a.set("app.env", "prod");
        System.out.println("app.env  = " + b.get("app.env")); // prod

        System.out.println("Same instance? " + (a == b)); // true
    }
}
