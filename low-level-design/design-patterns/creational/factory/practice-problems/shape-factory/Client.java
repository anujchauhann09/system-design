class Client {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        factory.createShape("circle").draw();      
        factory.createShape("rectangle").draw();   
        factory.createShape("square").draw();     
    }
}
