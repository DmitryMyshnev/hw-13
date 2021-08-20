import PostsByUser.Post;
import PostsByUser.Posts;
import Users.Address;
import Users.Company;
import Users.Geo;
import Users.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static final String url = "https://jsonplaceholder.typicode.com";
    static final String urlForPost = "https://jsonplaceholder.typicode.com/posts/1";
    static final String urlForUsersPost = "https://jsonplaceholder.typicode.com/users/1/posts";
    public static void main(String[] args) throws Exception {
        HttpClientManager manager = new HttpClientManager(url);
//       User user = manager.getUserByUserName("Bret");
//        System.out.println(user.getName());
        //  Long id = manager.getMaxId();
        User newUser = new User(1, "John",
                "JohnWick",
                " Wick@mail.com",
                new Address("Wall St", "Apt. 1", "New York", "13258-65", new Geo(40.707691106420995, -74.01160424999983)),
                "+12124033990",
                "onewallstreet.com",
                new Company("onewallstreet", "Love going there for a coffee", "Love going there for a coffee"));

        //manager.updateUser(newUser);
       // manager.postNewUser(newUser);
        // System.out.println(manager.deleteUserById());
        ArrayList<User> user = manager.getAllUsers();
        for (User p : user) {
            System.out.println(p.toString());
        }

         //List<User> user = manager.getAllUsers();

        // System.out.println(manager.getUserById(4).toString());
        // System.out.println( manager.getMaxId().toString());
    }
}