class PasswordAuth extends AuthFlow {

    protected void validateCredentials() {
        System.out.println("Validating username and password format...");
    }

    protected void authenticate() {
        System.out.println("Authenticating against password hash...");
    }
}
