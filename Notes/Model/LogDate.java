package Notes.Model;
import java.time.LocalDateTime;

public class LogDate implements LogDateable{
    
    @Override
    public void logg(String msg) {
        System.out.println(msg + LocalDateTime.now());
    }
}
