class SocialMedia {
    public static void main(String[] args) {
        User u = new User();
        u.register("John", "john@email.com", "pass123");

        Post p = new Post();
        p.user = u;
        p.addPost("My first post", "Hello world", "image.jpg");

        Comment c = new Comment();
        c.user = u;
        c.post = p;
        c.addComment("Nice post!");
    }
}
