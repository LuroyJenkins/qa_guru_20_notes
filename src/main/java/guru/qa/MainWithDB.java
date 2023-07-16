package guru.qa;

import guru.qa.front.AuthFrontend;
import guru.qa.front.FrontContainer;
import guru.qa.front.NotesFrontend;
import guru.qa.repository.db.impl.DataBaseNotesRepository;
import guru.qa.repository.db.impl.DataBaseUsersRepository;
import guru.qa.service.Base64PasswordService;
import guru.qa.service.UserSession;

public class MainWithDB {

    public static void main(String[] args) {
        new FrontContainer(
                new AuthFrontend(
                        new DataBaseUsersRepository(),
                        new Base64PasswordService()
                ),
                new NotesFrontend(
                        new DataBaseNotesRepository()
                )
        ).start(new UserSession());
    }

}