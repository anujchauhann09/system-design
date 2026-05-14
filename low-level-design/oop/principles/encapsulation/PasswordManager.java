class PasswordManager {

    private String password;

    public void setPassword(String password) {

        if(password == null || password.trim().isEmpty()) {
            System.out.println("Please provide password");
            return;
        }

        this.password = password;
    }

    public boolean verifyPassword(String input) {
        if(input == null) {
            System.out.println("Please provide a password to match");
            return false;
        }

        return this.password.equals(input);
    }
}