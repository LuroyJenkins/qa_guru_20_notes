package guru.qa.domain;

public class Note {

    private final String username;
    private final String text;

    public Note(String username, String text) {
        this.username = username;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note{text='" + text + "'}";
    }
}
