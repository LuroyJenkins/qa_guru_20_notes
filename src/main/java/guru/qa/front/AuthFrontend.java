package guru.qa.front;

import guru.qa.domain.User;
import guru.qa.repository.UserRepository;
import guru.qa.service.PasswordService;
import guru.qa.service.Session;

import javax.swing.*;
import java.util.Optional;

public class AuthFrontend implements Frontend {

    private final UserRepository userRepository;
    private final PasswordService passwordService;

    public AuthFrontend(UserRepository userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    @Override
    public void start(Session session) {
        final String login = JOptionPane.showInputDialog("Login:");
        final String password = JOptionPane.showInputDialog("Password:");

        final String hash = this.passwordService.encode(password);

        Optional<User> userFromDb = userRepository.getByUsername(login);
        if (userFromDb.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Invalid username or password",
                    "Authentication error",
                    JOptionPane.ERROR_MESSAGE
            );
            this.start(session);
        } else {
            User user = userFromDb.get();
            if (user.isPasswordEquals(hash)) {
                JOptionPane.showMessageDialog(
                        null,
                        "Success authentication!",
                                "Info",
                        JOptionPane.INFORMATION_MESSAGE
                );
                session.setUser(user);
            }
        }
    }
}
