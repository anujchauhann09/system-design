class Comment {
    String content;
    Post post;
    User user;

    Comment addComment(String content) {
        if (content == null) {
            System.out.println("Please fill all fields.");
            return null;
        }

        if (content.trim().isEmpty()) {
            System.out.println("Enter comment!");
            return null;
        }

        this.content = content;

        System.out.println("Comment added successfully.");
        return this;
    }

    boolean removeComment(int commentId) {
        if (commentId <= 0) {
            System.out.println("Comment ID is not valid.");
            return false;
        }

        this.content = null;

        System.out.println("Comment removed successfully.");
        return true;
    }

    boolean updateComment(String content) {
        if (content == null) {
            System.out.println("Please fill all fields.");
            return false;
        }

        if (content.trim().isEmpty()) {
            System.out.println("Enter comment!");
            return false;
        }

        this.content = content;

        System.out.println("Comment updated successfully.");
        return true;
    }
}
