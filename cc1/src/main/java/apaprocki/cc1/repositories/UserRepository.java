package apaprocki.cc1.repositories;

import apaprocki.cc1.models.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private final Map<Integer, User> data = new ConcurrentHashMap<>();

    public User getUserById(int id) {
        return data.get(id);
    }

    public int saveUser(User user) {
        data.put(user.getId(), user);
        return user.getId();
    }
}