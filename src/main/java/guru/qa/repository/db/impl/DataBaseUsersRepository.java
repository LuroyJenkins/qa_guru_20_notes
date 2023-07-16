package guru.qa.repository.db.impl;

import guru.qa.domain.User;
import guru.qa.repository.UserRepository;
import guru.qa.repository.db.DataSourceProvider;
import guru.qa.repository.db.UserEntityRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Optional;

public class DataBaseUsersRepository implements UserRepository {

    private static final JdbcTemplate template =
            new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

    @Override
    public Optional<User> getByUsername(String username) {
        RowMapper<User> rowMapper = new UserEntityRowMapper();
        return Optional.ofNullable(template.queryForObject(
                "SELECT * FROM users WHERE username = ?",
                rowMapper,
                username));
    }
}
