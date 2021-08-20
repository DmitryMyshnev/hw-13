import Json.JsonManager;
import PostsByUser.Post;
import Users.User;
import Users.Users;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class HttpClientManager {
    private String url;
    private String response;
    JsonManager jsonManager;

    public HttpClientManager(String url) {
        this.url = url;
        jsonManager = new JsonManager();
    }

    public User getUserById(long id) throws Exception {
       /* List<User> userList = getAllUsers();
        if (getMaxId() >= id) {
            return userList.stream().filter((x) -> x.getId() == id).findFirst().get();
        } else return null;*/
        return  jsonManager.getUserFromJson(getResponse(url + "/" + id).body(),User.class);
    }

    public User getUserByUserName(String name) throws Exception {
        List<User> userList = getAllUsers();
        return userList.stream().filter((x) -> x.getUsername().equals(name)).findFirst().get();
    }

    public ArrayList<User> getAllUsers() throws Exception {
        return jsonManager.getAllFromJson(getResponse(url +"/users").body(), Users.class);
    }

    private HttpResponse<String> getResponse(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    protected Long getMaxId() throws Exception {
        List<User> users = getAllUsers();
        return users.stream().max(User::compare).get().getId();
    }

    public int deleteUser() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .DELETE().build();
        HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());
        return resp.statusCode();
    }

    public void postNewUser(User user) throws Exception {
        String json = jsonManager.ConvertUserToJson(user);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json)).build();
        HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(resp.body());
    }

    public void updateUser(User user) throws Exception {
        String json = jsonManager.ConvertUserToJson(user);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json)).build();
        HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(resp.body());
    }
public List<Post> getAllPosts() throws  Exception{
        return jsonManager.getAllFromJson(getResponse(url +"/posts").body(),Post.class);
}

}
