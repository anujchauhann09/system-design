class SSOAuth extends AuthFlow {

    protected void validateCredentials() {
        System.out.println("Validating SAML assertion...");
    }

    protected void authenticate() {
        System.out.println("Authenticating via identity provider...");
    }
}
