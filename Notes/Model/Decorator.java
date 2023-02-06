package Notes.Model;
import java.util.List;

public class Decorator implements Repository {
    private Repository repos;
    private LogDateable logger;

    public Decorator(Repository repos, LogDateable logger) {
        this.repos = repos;
        this.logger = logger;
    }
    
    @Override
    public String CreateNote(Note note) {
        String res = repos.CreateNote(note);
        return res;
    }

    @Override
    public void UpdateNote(Note note, Fields field, String param) {
        repos.UpdateNote(note, field, param);
    }

    @Override
    public List<Note> getAllNotes() {
        List<Note> res = repos.getAllNotes();
        return res;
    }

    @Override
    public void delNote(List notes) {
      repos.delNote(notes);
      logger.logg("Дата и время удаления записки: ");
      
    }
}
