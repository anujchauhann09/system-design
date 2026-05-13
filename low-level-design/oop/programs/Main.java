public class Main {

    public static void main(String[] args) {
        
        // Car
        
        Car bmw = new Car();
        bmw.color = "Red";
        bmw.speed = 200;

        Car audi = new Car();
        audi.color = "White";
        audi.speed = 180;

        System.out.println(bmw.color);
        System.out.println(audi.color);

        bmw.start();
        audi.stop();

        // Student

        Student s1 = new Student();
        s1.name = "Anuj Chauhan";
        s1.age = 13;
        s1.marks = 65;

        s1.info();

        // BankAccount

        BankAccount b1 = new BankAccount();
        b1.deposit(-100);
        b1.deposit(100);
        b1.withdraw(200);
        b1.withdraw(100);
    }
}