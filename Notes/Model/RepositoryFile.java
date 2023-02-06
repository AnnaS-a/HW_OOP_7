package Notes.Model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository{
    private NoteMapper mapper = new NoteMapper();
    private FileInterface fileInterface;
    
    public RepositoryFile(FileInterface fileInterface) {
        this.fileInterface = fileInterface;
    }

    @Override
    public String CreateNote(Note note) {
        List<Note> notes = getAllNotes();
        int max = 0;
        for (Note item : notes) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        note.setId(id);
        notes.add(note);
        List<String> lines = new ArrayList<>();
        for (Note item : notes) {
            lines.add(mapper.map(item));
        }
        fileInterface.saveAllLines(lines);
        return id;
    }

    @Override
    public List<Note> getAllNotes() {
        List<String> lines = fileInterface.readAllLines();
        List<Note> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(mapper.map(line));
        }
        return notes;
    }

    @Override
    public void UpdateNote(Note note, Fields field, String param) {
        if(field == Fields.NAME) {
            note.setName(param);
        }
        else if(field == Fields.TEXT) {
            note.setText(param);
        }
        else if(field == Fields.DATECREATE) {
            note.setDateCreate(param);
        }
        saveNote(note);
    }

    private void saveNote(Note note) {
        List<String> lines = new ArrayList<>();
        List<Note> notes = getAllNotes();
        for (Note item: notes) {
            if(note.getId().equals(item.getId())) {
                lines.add(mapper.map(note));
            }
            else {
                lines.add(mapper.map(item));
            }
        }
        fileInterface.saveAllLines(lines);
    }

    public void delNote(List notes) {
        List<String> lines = new ArrayList<>();
        List<Note> del_note = notes;
        for (Note item: del_note) {
            lines.add(mapper.map(item));
            }
        fileInterface.saveAllLines(lines);   
        System.out.println("Удалено!"); 
    }
}
