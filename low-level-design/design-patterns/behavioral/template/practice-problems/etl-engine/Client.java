public class Client {

    public static void main(String args[]) {

        ETLEngine database = new DatabaseETL();
        database.run();

        System.out.println();

        ETLEngine api = new ApiETL();
        api.run();

        System.out.println();

        ETLEngine file = new FileETL();
        file.run();
    }
}
