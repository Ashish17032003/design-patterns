package BehavioralDesignPatterns._Chain_of_Responsibility.ConcreteHandler;

import BehavioralDesignPatterns._Chain_of_Responsibility.Database;
import BehavioralDesignPatterns._Chain_of_Responsibility.Handler;

public class UserExistsHandler extends Handler {
    private Database database;

    public UserExistsHandler(Database database) {
        this.database = database;
    }

    @Override
    public boolean handle(String username, String password) {
        if (!database.isValidUser(username)) {
            System.out.println("This username is not registered!");
            System.out.println("Sign up to our app now!");
            return false;
        }
        return handleNext(username, password);
    }
}