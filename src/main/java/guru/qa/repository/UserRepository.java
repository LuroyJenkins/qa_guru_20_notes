package guru.qa.repository;

import guru.qa.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> getByUsername(String username);

    class MockUserRepository implements UserRepository {
        @Override
        public Optional<User> getByUsername(String username) {
            if ("dima".equals(username)) {
                return Optional.of(new User(username, "12345"));
            }
            return Optional.empty();
        }
    }
}
