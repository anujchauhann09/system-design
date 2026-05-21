class Client {
    public static void main(String[] args) {
        ChatRoom room = new ChatRoom("General");

        ChatUser alice = new ChatUser("Alice");
        ChatUser bob   = new ChatUser("Bob");
        ChatUser carol = new ChatUser("Carol");

        room.addObserver(alice);
        room.addObserver(bob);
        room.addObserver(carol);

        room.sendMessage("Alice", "Hey everyone!");

        System.out.println();

        room.sendMessage("Bob", "Hello Alice!");

        System.out.println();

        room.removeObserver(carol);
        room.sendMessage("Alice", "Carol left the room.");
    }
}
