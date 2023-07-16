package guru.qa.repository.db.impl;

import guru.qa.domain.Note;
import guru.qa.repository.NotesRepository;
import guru.qa.repository.db.DataSourceProvider;
import guru.qa.repository.db.NoteEntityRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.util.List;

public class DataBaseNotesRepository implements NotesRepository {

    private static final JdbcTemplate template =
            new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());
    private static final RowMapper<Note> rowMapper = new NoteEntityRowMapper();

    @Override
    public @Nullable
    List<Note> getAllByUsername(String username) {
            return template.query(
                    "SELECT * FROM notes WHERE username = ?",
                    rowMapper,
                    username);
    }

    @Override
    public void saveNote(Note note) {
        template.update("INSERT INTO notes (username, text) values (?, ?)",
                note.getUsername(),
                note.getText());

    }
}
