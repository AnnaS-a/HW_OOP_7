package Notes.Controllers;

import java.util.List;

import Notes.Model.Fields;
import Notes.Model.Note;
import Notes.Model.Repository;
import Notes.Utilities.Validate;

public class Controller {
    private final Repository repository;
    private final Validate validate;
    
    public Controller(Repository repository, Validate validate) {
        this.repository = repository;
        this.validate = validate;
    }

    public List<Note> getNotes() throws Exception {
        return repository.getAllNotes();
    }

    public void saveNote(Note note) throws Exception {
        validate.checkNote(note.getName(),note.getText());
        
        repository.CreateNote(note);
    }

    

    public Note readNote(String noteId) throws Exception {
        List<Note> notes = repository.getAllNotes();
        for (Note note : notes) {
            if (note.getId().equals(noteId)){
                return note;
            }
        }
        throw new Exception("Записка не найдена");
    }

    public void updateNote(Note note, Fields field, String param) throws Exception {
        if(field == Fields.NAME) {
            validate.checkNote(param, note.getText());
        }
        if(field == Fields.TEXT) {
            validate.checkNote(note.getName(),param);
        }
        repository.UpdateNote(note, field, param);
    }

    public  Note deleteNote(String noteId) throws Exception {
        List<Note> notes = repository.getAllNotes();
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                notes.remove(note);
                repository.delNote(notes);
                return note;
            }
        }
        throw new Exception("Записка не найдена");
    }

}
