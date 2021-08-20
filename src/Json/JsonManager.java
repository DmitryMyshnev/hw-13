package Json;
import Comments.Comment;
import PostsByUser.Post;
import PostsByUser.Posts;
import Users.Users;
import com.google.gson.Gson;
import Users.User;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonManager{

    public <T> ArrayList<T> getAllFromJson(String json, Type type){
      // return   new Gson().fromJson(json, new TypeToken<ArrayList<T>>() {}.getType());

        return  new Gson().fromJson(json, type);
    }
    public <T> T getObjectFromJson(String json, Type type){
        return new Gson().fromJson(json,type);
    }

    public String ConvertUserToJson(Object o){
        return new Gson().toJson(o,o.getClass());
    }
    public String ConvertPostToJson(Post post){
        return new Gson().toJson(post,Post.class);
    }
    public void  createFileFromJson(ArrayList<Comment> comments,String path){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(comments);
        File file = new File(path);
        try (FileWriter writeJson = new FileWriter(file)) {
            writeJson.write(json);
            writeJson.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
