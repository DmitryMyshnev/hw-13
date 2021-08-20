package TodoList;

public class TodoUserList {
    private Long id;
    private Long userId;
    private String title;
    private boolean completed;

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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "TodoUserList{" +'\n' +
                "id = " + id +'\n' +
                "userId = " + userId +'\n' +
                "title : " + title + '\n' +
                "completed : " + completed +'\n' +
                '}';
    }
}
