package apaprocki.cc2.domain.models;

import java.util.Objects;

public class User {
    private Id id;
    private String name;
    private String firstname;
    private String username;
    private String password;

    public User(Id id, String name, String firstname, String username, String password) {
        this.id = id;
        this.name = Objects.requireNonNull(name,"User name must be not null");
        this.firstname = Objects.requireNonNull(firstname,"User firstname must be not null");
        this.username = Objects.requireNonNull(username,"User username must be not null");
        this.password = Objects.requireNonNull(password,"User name must be not null");
    }

    public static User of(Id id, String name, String firstname, String username, String password){
        return new User(id,name,firstname,username,password);
    }

    public Id getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = Objects.requireNonNull(username,"Username must be initialized");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Objects.requireNonNull(password,"Password must be initialized");
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
