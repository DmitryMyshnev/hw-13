package Json;
import PostsByUser.Post;
import PostsByUser.Posts;
import Users.Users;
import com.google.gson.Gson;
import Users.User;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonManager{

    public <T> ArrayList<T> getAllFromJson(String json, Class clazz){
      // return   new Gson().fromJson(json, new TypeToken<ArrayList<T>>() {}.getType());

        return  new Gson().fromJson(json, clazz.getGenericSuperclass());
    }
    public <T> T getUserFromJson(String json,Class clazz){
        return new Gson().fromJson(json,clazz.getGenericSuperclass());
    }

    public String ConvertUserToJson(Object o){
        return new Gson().toJson(o,o.getClass());
    }
    public String ConvertPostToJson(Post post){
        return new Gson().toJson(post,Post.class);
    }
}