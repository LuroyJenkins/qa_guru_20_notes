package guru.qa;

import guru.qa.front.AuthFrontend;
import guru.qa.front.FrontContainer;
import guru.qa.front.NotesFrontend;
import guru.qa.repository.FileNotesRepository;
import guru.qa.repository.FileUserRepository;
import guru.qa.service.Base64PasswordService;
import guru.qa.service.UserSession;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        new FrontContainer(
                new AuthFrontend(
                        new FileUserRepository(
                                Path.of("users.csv")
                        ),
                        new Base64PasswordService()
                ),
                new NotesFrontend(
                        new FileNotesRepository(
                            Path.of("notes.csv")
                        )
                )
        ).start(new UserSession());
    }

}