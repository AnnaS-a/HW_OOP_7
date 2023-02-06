package Notes.View;

import java.util.Scanner;

import Notes.Controllers.Controller;
import Notes.Model.Fields;
import Notes.Model.Note;
import Notes.Utilities.Validate;

public class ViewUser {
    private final Controller сontroller;
    private final Validate validate;

    public ViewUser(Controller сontroller, Validate validate) {
        this.сontroller = сontroller;
        this.validate = validate;
    }

    public void run() {
        Menu com = Menu.NONE;
        showHelp();
        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Menu.valueOf(command.toUpperCase());
                if (com == Menu.EXIT)
                    return;
                switch (com) {
                    case CREATE:
                        create();
                        break;
                    case READ:
                        read();
                        break;
                    case UPDATE:
                        update();
                        break;
                    case DELETE:
                        delete();
                        break;
                    case LIST:
                        list();
                        break;
                    case HELP:
                        showHelp();
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private void showHelp() {
        System.out.println("Список команд:");
        for (Menu c : Menu.values()) {
            System.out.println(c);
        }
    }

    private void create() throws Exception {
        try {
            String name = prompt("Заголовок: ");
            String text = prompt("Текст записки: ");
            validate.checkNote(name, text);
            String dateCreate = prompt("Дата создания записки: ");
            if (dateCreate.isEmpty()) {
               dateCreate = "---";
           }
            

            сontroller.saveNote(new Note(name, text, dateCreate));
        } catch (Exception ex) {
            System.out.println("Произошла ошибка " + ex.toString());
        }
    }

    private void read() throws Exception {
        try {
            String id = prompt("Идентификатор записки: ");
            Note noteR = сontroller.readNote(id);
            System.out.println(noteR);
        } catch (Exception ex) {
            System.out.println("Произошла ошибка " + ex.toString());
        }
    }

    private void update() throws Exception {
        try {
            String userid = prompt("Идентификатор записки: ");
            String field_name = prompt("Какое поле (NAME,TEXT,DATECREATE): ");
            String param = prompt("Введите новые данные: ");
            Note noteUp = сontroller.readNote(userid);
            сontroller.updateNote(noteUp, Fields.valueOf(field_name.toUpperCase()), param);
        } catch (Exception ex) {
            System.out.println("Произошла ошибка " + ex.toString());
        }
    }

    private void delete() throws Exception {
        try {
            String id = prompt("Введите идентификатор записки, которую нужно удалить: ");
            System.out.println("Хотите удалить: ");
            System.out.println(сontroller.readNote(id));
            String consent = prompt("Введите y - удалить, n - не удалять: ");
            if (consent.equals("y")) {
                сontroller.deleteNote(id);
            } else {
                System.out.println("Удаление отклонено.");
            }
        } catch (Exception ex) {
            System.out.println("Произошла ошибка " + ex.toString());
        }
    }

    private void list() throws Exception {
        try {
            for (Note note : сontroller.getNotes()) {
                System.out.println(note);
            }
        } catch (Exception ex) {
            System.out.println("Произошла ошибка " + ex.toString());
        }
    }





}
