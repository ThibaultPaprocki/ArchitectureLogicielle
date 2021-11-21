package apaprocki.cc1.models;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String firstname;
    private String username;
    private String password;

    public User(int id, String name, String firstname, String username, String password) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.username = username;
        this.password = password;
    }

    public static User of(int id, String name, String firstname, String username, String password){
        return new User(id,name,firstname,username,password);
    }

    public int getId() {
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
