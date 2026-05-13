class User {
    String name;
    String email;
    String password;

    boolean register(String name, String email, String password) {
        if (name == null || email == null || password == null) {
            System.out.println("Please fill all fields.");
            return false;
        }

        if (name.trim().isEmpty()) {
            System.out.println("Enter name!");
            return false;
        } else if (email.trim().isEmpty()) {
            System.out.println("Enter email!");
            return false;
        } else if (password.trim().isEmpty()) {
            System.out.println("Enter password!");
            return false;
        }

        this.name = name;
        this.email = email;
        this.password = password;

        System.out.println("User registered successfully.");
        return true;
    }

    boolean login(String email, String password) {
        if (email == null || password == null) {
            System.out.println("Please fill all fields.");
            return false;
        }

        if (email.trim().isEmpty()) {
            System.out.println("Enter email!");
            return false;
        } else if (password.trim().isEmpty()) {
            System.out.println("Enter password!");
            return false;
        }

        System.out.println("User login successfully.");
        return true;
    }

    void logout() {
        System.out.println("User logout successfully.");
    }
}
