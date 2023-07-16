package guru.qa.repository;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import guru.qa.domain.Note;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FileNotesRepository implements NotesRepository {

    private final Path path;

    public FileNotesRepository(Path path) {
        this.path = path;
    }

    @Override
    public List<Note> getAllByUsername(String username) {
        try (InputStream is = Files.newInputStream(path);
             CSVReader reader = new CSVReader(new InputStreamReader(is))) {
            Optional<String[]> row = reader.readAll().stream()
                    .filter(r -> username.equals(r[0]))
                    .findFirst();

            if (row.isEmpty()) {
                return new ArrayList<>();
            } else {
                String[] cells = row.get();
                List<Note> notesList = new ArrayList<>();
                for (int i = 1; i < cells.length; i++) {
                    notesList.add(new Note(cells[0], cells[i]));
                }
                return notesList;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveNote(Note note) {
        List<String[]> allData = getAllData();
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.getFileName().toString()))) {
            Optional<String[]> row = allData.stream()
                    .filter(r -> note.getUsername().equals(r[0]))
                    .findFirst();
            if (row.isEmpty()) {
                allData.add(new String[]{note.getUsername(), note.getText()});
                writer.writeAll(allData);
            } else {
                String[] cells = Arrays.copyOf(row.get(), row.get().length + 1);
                cells[cells.length - 1] = note.getText();
                allData.set(getDataIndexByUsername(allData, note.getUsername()), cells);
                writer.writeAll(allData);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<String[]> getAllData() {
        try (InputStream is = Files.newInputStream(path);
             CSVReader reader = new CSVReader(new InputStreamReader(is))) {
            List<String[]> lines = reader.readAll();
            return lines;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getDataIndexByUsername(List<String[]> dataList, String username) {
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i)[0].equals(username))
                return i;
        }
        throw new RuntimeException("Some problems with DB");
    }
}
