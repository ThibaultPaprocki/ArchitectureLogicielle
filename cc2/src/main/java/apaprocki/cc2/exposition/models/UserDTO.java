package apaprocki.cc2.exposition.models;

public class UserDTO {
    public int id;
    public String name;
    public String lastname;
    public String username;
    public String password;

    public static UserDTO of(int id, String name, String lastname,  String username, String password) {
        return new UserDTO(id,name,lastname,username,password);
    }

    private UserDTO(int id, String name, String lastName,  String userName, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastName;
        this.username = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastname + '\'' +
                ", userName=" + username + '\'' +
                ", password=" + password +
                '}';
    }
}
