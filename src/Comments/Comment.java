package Comments;

public class Comment {
    private Long postId;
    private Long id;
    private String name;
    private  String email;
    private String body;

    public Comment(Long posId, Long id, String name, String email, String body) {
        this.postId = posId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public Comment() {
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
