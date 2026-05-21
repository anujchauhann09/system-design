class TVDisplay implements Observer {

    @Override
    public void update(int temperature) {

        System.out.println(
                "TV Display: " + temperature
        );
    }
}