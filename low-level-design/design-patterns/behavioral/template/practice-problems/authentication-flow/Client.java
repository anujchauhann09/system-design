public class Client {

    public static void main(String args[]) {

        AuthFlow password = new PasswordAuth();
        password.login();

        System.out.println();

        AuthFlow oauth = new OAuthAuth();
        oauth.login();

        System.out.println();

        AuthFlow sso = new SSOAuth();
        sso.login();
    }
}
