package Notes.Model;

public class Note {
    public static Object getName;
    private String id = "";
    private String name;
    private String text;
    private String dateCreate;

    public Note(String name, String text, String dateCreate) {
        this.name = name;
        this.text = text;
        this.dateCreate = dateCreate;
    }

    public Note(String id, String name, String text, String dateCreate) {
        this(name, text, dateCreate);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public String toString() {
        return String.format("id: %s  Заголовок: %s; Текст: %s; Дата создания: %s", id, name, text, dateCreate);
    }
}
