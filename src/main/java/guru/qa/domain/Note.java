package guru.qa.domain;

public class Note {

    private final String username;
    private final String text;

    public Note(String username, String text) {
        this.username = username;
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Note{text='" + text + "'}";
    }
}
