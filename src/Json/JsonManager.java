package Json;

import Comments.Comment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class JsonManager {

    public <T> ArrayList<T> getAllFromJson(String json, Type type) {
        return new Gson().fromJson(json, type);
    }

    public <T> T getObjectFromJson(String json, Type type) {
        return new Gson().fromJson(json, type);
    }

    public String ConvertUserToJson(Object o) {
        return new Gson().toJson(o, o.getClass());
    }

    public void createFileFromJson(ArrayList<Comment> comments, String path) {
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
