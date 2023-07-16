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

}
