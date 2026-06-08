public class Client {

    public static void main(String args[]) {

        BeverageMaker tea = new TeaMaker();
        tea.prepareBeverage();

        System.out.println();

        BeverageMaker coffee = new CoffeeMaker();
        coffee.prepareBeverage();
    }
}
