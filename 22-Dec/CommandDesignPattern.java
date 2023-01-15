import java.util.Scanner;

// command Design Pattern
// Date: 22-12-2022

interface Command {
    public void execute();
}

class Copy {
    public void copy() {
        System.out.println("copying text");
    }
}

class Paste {
    public void paste() {
        System.out.println("pasting text");
    }
}

class CopyCommand implements Command {
    private Copy copy;

    public CopyCommand(Copy copy) {
        this.copy = copy;
    }

    public void execute() {
        copy.copy();
    }
}

class PasteCommand implements Command {
    private Paste paste;

    public PasteCommand(Paste paste) {
        this.paste = paste;
    }

    public void execute() {
        paste.paste();
    }
}

class Button {
    private Command command;
    private String name;

    public Button(String btnname) {
        name = btnname;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void click() {
        System.out.println(name + " clicked");
        command.execute();
    }
}

public class CommandDesignPattern {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Copy copy = new Copy();
        Paste paste = new Paste();

        CopyCommand copyCommand = new CopyCommand(copy);

        Button rightClickCopy = new Button("Right Click Copy Button");
        rightClickCopy.setCommand(copyCommand);

        Button copyShortcut = new Button("Copy Shortcut Key");
        copyShortcut.setCommand(copyCommand);

        Button copyMenuBtn = new Button("Copy Menu Button");
        copyMenuBtn.setCommand(copyCommand);

        PasteCommand pasteCommand = new PasteCommand(paste);

        Button rightClickPaste = new Button("Right Click Paste Button");
        rightClickPaste.setCommand(pasteCommand);

        Button pasteShortcut = new Button("Paste Shortcut Key");
        pasteShortcut.setCommand(pasteCommand);

        Button pasteMenuBtn = new Button("Paste Menu Button");
        pasteMenuBtn.setCommand(pasteCommand);

        int choice;

        // menu to choose one command
        do {

            System.out.println("Menu to choose one command");
            System.out.println("1. Copy with Right Click");
            System.out.println("2. Copy with Shortcut Key");
            System.out.println("3. Copy with Menu Button");
            System.out.println("4. Paste with Right Click");
            System.out.println("5. Paste with Shortcut Key");
            System.out.println("6. Paste with Menu Button");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    rightClickCopy.click();
                    break;
                case 2:
                    copyShortcut.click();
                    break;
                case 3:
                    copyMenuBtn.click();
                    break;
                case 4:
                    rightClickPaste.click();
                    break;

                case 5:

                    pasteShortcut.click();
                    break;
                case 6:
                    pasteMenuBtn.click();
                    break;

                case 7:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
            // clear output
            System.out.println("\n\n");

        } while (choice != 7);

    }
}
