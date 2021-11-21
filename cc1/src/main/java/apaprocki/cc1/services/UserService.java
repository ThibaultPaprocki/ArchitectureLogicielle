package apaprocki.cc1.services;

import apaprocki.cc1.models.User;
import apaprocki.cc1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    public int addUser(User user) {
        return userRepository.saveUser(user);
    }

}
