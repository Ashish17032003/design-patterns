package BehavioralDesignPatterns._Chain_of_Responsibility;

public abstract class Handler {
    private Handler next;
    public Handler setHandlerNext(Handler next) {
        this.next = next;
        return next;
    }
    public abstract boolean handle(String username, String password);

    // convienient default behaviour of the handler which forwards the req to the next object
    protected boolean handleNext(String username, String password) {
        if(next == null) {
            return true;
        }
        return next.handle(username, password);
    }
}
