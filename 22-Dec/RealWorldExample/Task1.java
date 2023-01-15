// Lab Quiz
// Command Design Pattern 
// Date: 29-12-2022

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

interface Command {
    public void execute();
}

class Document {
    Scanner input = new Scanner(System.in);

    public void open() {
        System.out.println("Opening Document");
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("E:\\Study\\5th Semester\\Design-Pattern-Lab\\Lab Quiz 4\\file.txt"));
            Runtime.getRuntime().exec("notepad.exe E:\\Study\\5th Semester\\Design-Pattern-Lab\\Lab Quiz 4\\file.txt");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void save() {
        System.out.println("Document Saved");
        try {

            System.out.print("Enter content to save: \n");
            String content = input.nextLine();

            FileWriter fw = new FileWriter("E:\\Study\\5th Semester\\Design-Pattern-Lab\\Lab Quiz 4\\file.txt");
            fw.write(content);
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class OpenDocumentCommand implements Command {
    private Document doc;

    public OpenDocumentCommand(Document doc) {
        this.doc = doc;
    }

    public void execute() {
        doc.open();
    }
}

class SaveDocumentCommand implements Command {
    private Document doc;

    public SaveDocumentCommand(Document doc) {
        this.doc = doc;
    }

    public void execute() {
        doc.save();
    }
}

class Button {
    private Command command;

    public Button(Command command) {
        this.command = command;
    }

    public void click() {
        command.execute();
    }
}

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Document doc = new Document();
        Button openButton = new Button(new OpenDocumentCommand(doc));
        Button saveButton = new Button(new SaveDocumentCommand(doc));
        int enterNum = 0;
        do {
            System.out.println("\n\nSelect an option: ");
            System.out.println("1. Open Document");
            System.out.println("2. Save Document");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            enterNum = input.nextInt();
            if (enterNum == 1) {
                openButton.click();
            } else if (enterNum == 2) {
                saveButton.click();
            }
        } while (enterNum != 3);

    }
}
