public class Client {

    public static void main(String[] args) {

        WeatherStation station =
                new WeatherStation();

        Observer phone = new PhoneDisplay();
        Observer tv = new TVDisplay();

        station.addObserver(phone);
        station.addObserver(tv);

        station.setTemperature(35);
    }
}