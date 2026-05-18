class Post {
    String title;
    String content;
    String mediaUrl;
    User user;

    Post addPost(String title, String content, String mediaUrl) {
        if (title == null || content == null || mediaUrl == null) {
            System.out.println("Please fill all fields.");
            return null;
        }

        if (title.trim().isEmpty()) {
            System.out.println("Enter title!");
            return null;
        } else if (content.trim().isEmpty()) {
            System.out.println("Enter content!");
            return null;
        } else if (mediaUrl.trim().isEmpty()) {
            System.out.println("Enter media!");
            return null;
        }

        this.title = title;
        this.content = content;
        this.mediaUrl = mediaUrl;

        System.out.println("Post added successfully.");
        return this;
    }

    boolean removePost(int postId) {
        if (postId <= 0) {
            System.out.println("Post ID is not valid.");
            return false;
        }

        this.title = null;
        this.content = null;
        this.mediaUrl = null;

        System.out.println("Post removed successfully.");
        return true;
    }

    boolean updatePost(String title, String content, String mediaUrl) {
        if (title == null || content == null || mediaUrl == null) {
            System.out.println("Please fill all fields.");
            return false;
        }

        if (title.trim().isEmpty()) {
            System.out.println("Enter title!");
            return false;
        } else if (content.trim().isEmpty()) {
            System.out.println("Enter content!");
            return false;
        } else if (mediaUrl.trim().isEmpty()) {
            System.out.println("Enter media!");
            return false;
        }

        this.title = title;
        this.content = content;
        this.mediaUrl = mediaUrl;

        System.out.println("Post updated successfully.");
        return true;
    }
}
