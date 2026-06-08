class OAuthAuth extends AuthFlow {

    protected void validateCredentials() {
        System.out.println("Validating OAuth authorization code...");
    }

    protected void authenticate() {
        System.out.println("Exchanging code for access token with provider...");
    }
}
