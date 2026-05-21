class Client {
    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel("TechWithAnuj");

        Observer alice = new Subscriber("Alice");
        Observer bob   = new Subscriber("Bob");
        Observer carol = new Subscriber("Carol");

        channel.addObserver(alice);
        channel.addObserver(bob);
        channel.addObserver(carol);

        channel.uploadVideo("Observer Pattern Explained");

        System.out.println();

        channel.removeObserver(bob);
        channel.uploadVideo("Strategy Pattern Deep Dive");
    }
}
