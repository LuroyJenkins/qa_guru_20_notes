package guru.qa.service;

import guru.qa.domain.User;

public class UserSession implements Session {

    private User user;

    public UserSession(User user) {
        this.user = user;
    }

    public UserSession() {
    }

    @Override
    public Session setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public User unwrap() {
        if (user != null) {
            return user;
        } else {
            throw new IllegalStateException("UserSession should wrap user before unwrapping");
        }
    }
}
