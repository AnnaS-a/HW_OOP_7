package Notes.Utilities;

public class Validate {
    public void checkNote(String name, String text) throws Exception {
        if (name.length() == 0) {
            throw new Exception("Отсутствует заголовок");
        }
        if (text.length() == 0) {
            throw new Exception("Отсутствует текст");
        }
    }
}
