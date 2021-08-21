import Comments.Comment;
import Comments.Comments;
import Json.JsonManager;
import PostsByUser.Post;
import PostsByUser.Posts;
import TodoList.ToDos;
import TodoList.TodoUserList;
import Users.User;
import Users.Users;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HttpClientManager {
    private final String url;
    JsonManager jsonManager;
    private final String filePath;

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


    public int deleteUser() throws Exception {
        String correctUrl = url + "/posts/1";
        return postResponse(correctUrl,"","DELETE").statusCode();
    }

    public void postNewUser(User user) throws Exception {
        String json = jsonManager.ConvertUserToJson(user);
        String correctUrl = url + "/users";
        System.out.println(postResponse(correctUrl, json, "POST").body());
    }

    public void updateUser(User user) throws Exception {
        String json = jsonManager.ConvertUserToJson(user);
        String correctUrl = url + "/posts/1";
        System.out.println(postResponse(correctUrl, json, "PUT").body());
    }

    public ArrayList<Comment> getAllCommentsFromPostByUserId(Long userId) throws Exception {
        ArrayList<Post> posts = getAllPostsByUserId(userId);
        Long maxPostId = posts.stream().max(Post::compare).get().getId();
        ArrayList<Comment> comments = jsonManager.getAllFromJson(getResponse(url + "/posts/" + maxPostId + "/comments").body(), Comments.class);
        String nameFile = "user-" + userId + "-post-" + maxPostId + ".json";
        jsonManager.createFileFromJson(comments, filePath + nameFile);
        return comments;
    }

    public ArrayList<Post> getAllPostsByUserId(long userId) throws Exception {
        return jsonManager.getAllFromJson(getResponse(url + "/users/" + userId + "/posts").body(), Posts.class);
    }

    public List<TodoUserList> getAllNotCompletedTaskByUserId(Long userId) throws Exception {
        List<TodoUserList> todoUserLists = jsonManager.getAllFromJson(getResponse(url + "/users/" + userId + "/todos").body(), ToDos.class);
        List<TodoUserList> lists = todoUserLists.stream().filter((x) -> !x.isCompleted()).collect(Collectors.toList());
        for (TodoUserList list : lists) {
            System.out.println(list.toString());
        }
        return lists;
    }

    private HttpResponse<String> getResponse(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private HttpResponse<String> postResponse(String url, String json, String method) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .method(method, HttpRequest.BodyPublishers.ofString(json)).build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

}
