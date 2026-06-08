abstract class AuthFlow {

    public final void login() {

        validateCredentials();

        authenticate();

        generateToken();

        audit();
    }

    protected abstract void validateCredentials();

    protected abstract void authenticate();

    private void generateToken() {
        System.out.println("Generating session token...");
    }

    private void audit() {
        System.out.println("Recording login in audit log...");
    }
}
