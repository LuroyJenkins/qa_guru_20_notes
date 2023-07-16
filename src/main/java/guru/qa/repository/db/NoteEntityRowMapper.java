package guru.qa.repository.db;

import guru.qa.domain.Note;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoteEntityRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Note(rs.getString("username"),
                rs.getString("text"));
    }
}
