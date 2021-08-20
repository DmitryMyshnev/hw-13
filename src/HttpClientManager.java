import Comments.Comment;
import Comments.Comments;
import Json.JsonManager;
import PostsByUser.Post;
import PostsByUser.Posts;
import Users.User;
import Users.Users;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class HttpClientManager {
    private String url;
    JsonManager jsonManager;
    private String filePath;

    public HttpClientManager(String url) {
        this.url = url;
        jsonManager = new JsonManager();
        filePath = "src\\Comments\\";
    }

    public User getUserById(long id) throws Exception {
        String response = getResponse(url + "/users/" + id).body();
        if (response.equals("{}"))
            return null;
        return jsonManager.getObjectFromJson(response, User.class);
    }

    public ArrayList<User> getUserByUserName(String username) throws Exception {
        String response = getResponse(url + "/users?username=" + username).body();
        System.out.println(response);
        if (response.equals("{}"))
            return null;
        return jsonManager.getAllFromJson(response, Users.class);
    }

    public ArrayList<User> getAllUsers() throws Exception {
        return jsonManager.getAllFromJson(getResponse(url + "/users").body(), Users.class);
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
        String correctUrl = url + "/posts/1";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(correctUrl))
                .DELETE().build();
        HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());
        return resp.statusCode();
    }

    public void postNewUser(User user) throws Exception {
        String json = jsonManager.ConvertUserToJson(user);
        String correctUrl = url + "/users";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(correctUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json)).build();
        HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(resp.body());
    }

    public void updateUser(User user) throws Exception {
        String json = jsonManager.ConvertUserToJson(user);
        String correctUrl = url + "/posts/1";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(correctUrl))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json)).build();
        HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(resp.body());
    }

    public ArrayList<Comment> getAllCommentsFromPostByUserId(Long userId) throws Exception {
        ArrayList<Post> posts = getAllPostsFromUserId(userId);
        Long maxPostId = posts.stream().max(Post::compare).get().getId();
        ArrayList<Comment> comments = jsonManager.getAllFromJson(getResponse(url + "/posts/" + maxPostId + "/comments").body(), Comments.class);
        String nameFile = "user-" + userId + "-post-" + maxPostId + ".json";
        jsonManager.createFileFromJson(comments, filePath + nameFile);
        return comments;
    }

    public ArrayList<Post> getAllPostsFromUserId(long id) throws Exception {
        return jsonManager.getAllFromJson(getResponse(url + "/users/" + id + "/posts").body(), Posts.class);
    }

}
