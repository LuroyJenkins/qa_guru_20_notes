package guru.qa.repository;

import guru.qa.domain.Note;
import guru.qa.domain.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface NotesRepository {

    List<Note> getAllByUsername(String username);

    void saveNote(Note note);

    class MockNotesRepository implements NotesRepository {

        private final List<Note> stored = new ArrayList<>(
                List.of(
                        new Note("dima", "first note!"),
                        new Note("dima", "second note!")
                ));

        @Override
        public List<Note> getAllByUsername(String username) {
            if ("dima".equals(username)) {
                return stored;
            }
            return Collections.emptyList();
        }

        @Override
        public void saveNote(Note note) {
            stored.add(note);
        }
    }
}
