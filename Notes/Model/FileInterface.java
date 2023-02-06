package Notes.Model;

import java.util.List;

public interface FileInterface {
    
    List<String> readAllLines();

    void saveAllLines(List<String> lines);
}
