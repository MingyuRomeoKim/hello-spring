package hello.hello_spring.java.user;

public class User {

    private Long id;
    private String name;
    private String email;
    private Grade grade;

    public User(Long id, String name, String email, Grade grade) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.grade = grade;
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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
