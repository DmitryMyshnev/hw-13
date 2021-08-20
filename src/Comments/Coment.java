package Comments;

public class Coment {
    private Long posId;
    private Long id;
    private String name;
    private  String email;
    private String body;

    public Coment(Long posId, Long id, String name, String email, String body) {
        this.posId = posId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
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
