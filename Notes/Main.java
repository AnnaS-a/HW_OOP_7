package Notes;

import Notes.Controllers.Controller;
import Notes.Model.Decorator;
import Notes.Model.FileActions;
import Notes.Model.FileInterface;
import Notes.Model.LogDate;
import Notes.Model.Repository;
import Notes.Model.RepositoryFile;
import Notes.Utilities.Validate;
import Notes.View.ViewUser;

public class Main {
    public static void main(String[] args) {
        FileInterface fileInterface = new FileActions("book.txt");
        Repository repository = new Decorator(new RepositoryFile(fileInterface), new LogDate());
        Validate validate = new Validate();
        Controller controller = new Controller(repository, validate);
        ViewUser view = new ViewUser(controller, validate);
        view.run();
    }
}
