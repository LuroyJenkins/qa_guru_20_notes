package guru.qa.repository;

import guru.qa.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> getByUsername(String username);

}
