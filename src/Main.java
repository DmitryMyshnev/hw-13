import PostsByUser.Post;
import Users.Address;
import Users.Company;
import Users.Geo;
import Users.User;

import java.util.ArrayList;

public class Main {
    static final String url = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) {
        HttpClientManager manager = new HttpClientManager(url);

        User newUser = new User(0, "John",
                "JohnWick",
                " Wick@mail.com",
                new Address("Wall St", "Apt. 1", "New York", "13258-65", new Geo(40.707691106420995, -74.01160424999983)),
                "+12124033990",
                "onewallstreet.com",
                new Company("onewallstreet", "Love going there for a coffee", "We have already covered basics of Functional"));
//Task1.1 _______________________________
        //manager.postNewUser(newUser);
//Task1.2 _______________________________
        //  manager.updateUser(newUser);
//Task1.3 ________________________________
        // System.out.println("Status Code: " + manager.deleteUser());
//Task1.4 ________________________________
        /*   ArrayList<User> user = manager.getAllUsers();
        for (User u : user) {
            System.out.println(u.toString());
        }*/
//Task1.5 __________________________________
        //System.out.println(manager.getUserById(2L).toString());
//Task1.6 __________________________________
        // System.out.println(manager.getUserByUserName("Samantha").toString());
//Task2 ____________________________________
        // manager.getAllCommentsFromPostByUserId(5L);
//Task3 ____________________________________
        //manager.getAllNotCompletedTaskByUserId(10L);

    }
}
