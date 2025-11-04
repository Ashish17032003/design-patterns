package BehavioralDesignPatterns._Chain_of_Responsibility.ConcreteHandler;

import BehavioralDesignPatterns._Chain_of_Responsibility.AuthService;
import BehavioralDesignPatterns._Chain_of_Responsibility.Database;
import BehavioralDesignPatterns._Chain_of_Responsibility.Handler;

public class Demo {
    public static void main(String[] args) {
        Database database = new Database();

        Handler handler = new UserExistsHandler(database);
        handler.setHandlerNext(new ValidPasswordHandler(database))
                .setHandlerNext(new RoleCheckHandler());

        AuthService service = new AuthService(handler);

        System.out.println("---- Test 1 ----");
        service.logIn("admin_username", "admin_pass");

        System.out.println("\n---- Test 2 ----");
        service.logIn("user1", "wrong_pass");

        System.out.println("\n---- Test 3 ----");
        service.logIn("new_user", "1234");
    }
}
