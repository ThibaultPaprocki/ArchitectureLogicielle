package apaprocki.cc2.domain.repositories;

import apaprocki.cc2.domain.models.Id;
import apaprocki.cc2.domain.models.User;

import java.util.List;

public interface UserRepository {

    Id getNextId();

    User getUserById(Id id);

    List<User> getAll();

    User saveUser(User user);

}