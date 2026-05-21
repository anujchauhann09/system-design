class Client {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency("BBC News");

        Observer alice = new NewsReader("Alice");
        Observer bob   = new NewsReader("Bob");
        Observer carol = new NewsReader("Carol");

        agency.addObserver(alice);
        agency.addObserver(bob);
        agency.addObserver(carol);

        agency.publishNews("Technology", "AI surpasses human performance in coding tasks");

        System.out.println();

        agency.removeObserver(bob);
        agency.publishNews("Sports", "India wins the World Cup");
    }
}
