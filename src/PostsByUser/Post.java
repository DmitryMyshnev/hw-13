package PostsByUser;

public class Post {
    private Long id;
    private Long userId;
    private  String title;
    private String body;

    public Post(Long id, Long userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post: {" +'\n' +
                "id= " + id + '\n' +
                "userId= " + userId + '\n' +
                "title= " + title + '\n' +
                "body= " + body + '\n' +
                '}';
    }

    public static int compare(Post post1, Post post2) {
        if(post1.getId() > post2.getId())
            return 1;
        return -1;
    }
}
