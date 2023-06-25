package guru.qa.repository;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import guru.qa.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class FileUserRepository implements UserRepository {

    private final Path path;

    public FileUserRepository(Path path) {
        this.path = path;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        try (InputStream is = Files.newInputStream(path);
            CSVReader reader = new CSVReader(new InputStreamReader(is))) {
            Optional<String[]> row = reader.readAll().stream()
                    .filter(r -> username.equals(r[0]))
                    .findFirst();

            if (row.isEmpty()) {
                return Optional.empty();
            } else {
                String[] cells = row.get();
                return Optional.of(new User(cells[0], cells[1]));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
