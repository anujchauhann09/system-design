class DirectorHandler extends Handler {

    private static final int LIMIT = 10;

    @Override
    public void handle(Request request) {
        if (request.getDays() <= LIMIT) {
            System.out.println("Director approved " + request.getDays()
                    + " day(s) leave for " + request.getEmployee());
        } else if (next != null) {
            next.handle(request);
        } else {
            System.out.println("Leave request for " + request.getEmployee() + " rejected");
        }
    }
}
