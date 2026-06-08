public class Client {

    public static void main(String args[]) {

        PaymentProcessor upi = new UpiPayment();
        upi.pay();

        System.out.println();

        PaymentProcessor card = new CardPayment();
        card.pay();

        System.out.println();

        PaymentProcessor wallet = new WalletPayment();
        wallet.pay();
    }
}
