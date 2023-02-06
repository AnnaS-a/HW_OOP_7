package Notes.Model;

public class NoteMapper {
    
    public String map(Note note) {
        return String.format("%s, %s, %s, %s", note.getId(), note.getName(), note.getText(), note.getDateCreate());
    }

    public Note map(String line) {
        String[] lines = line.split(",",-1);
        return new Note(lines[0], lines[1], lines[2], lines[3]);
    }

}
