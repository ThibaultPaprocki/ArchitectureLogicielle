package apaprocki.cc2.domain.services;

import apaprocki.cc2.domain.models.Id;
import apaprocki.cc2.domain.models.User;
import apaprocki.cc2.domain.repositories.UserRepository;
import apaprocki.cc2.exposition.models.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Id getNextId() {
        return userRepository.getNextId();
    }

    public User getUserById(Id id) {
        return userRepository.getUserById(id);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User addUser(UserDTO userdto) {
        User user = User.of(Id.of(userdto.id), userdto.name, userdto.lastname, userdto.username, userdto.password);
        return userRepository.saveUser(user);
    }

    public User addUser(User user) {
       return userRepository.saveUser(user);
    }

    public User changeUsername(Id id, String userName) {
        User user = getUserById(id);
        user.setUsername(userName);
        return userRepository.saveUser(user);
    }

    public User changePassword(Id id, String password) {
        User user = getUserById(id);
        user.setPassword(password);
        return userRepository.saveUser(user);
    }

    public boolean userExist(Id id) {
        try {
            getUserById(id);
        } catch (Exception e) {
            return false;
        }
        return true;

    }
}