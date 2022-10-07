interface Button {
    void getName();
}

class WinButton implements Button {
    public void getName() {
        System.out.println("WinButton");
    }
}

class MacButton implements Button {
    public void getName() {
        System.out.println("MacButton");
    }
}

interface CheckBox {
    void getName();
}

class WinCheckBox implements CheckBox {
    public void getName() {
        System.out.println("Win CheckBox");
    }
}

class MacCheckBox implements CheckBox {
    public void getName() {
        System.out.println("Mac CheckBox");
    }
}

interface GUIFactory {
    Button createButton();

    CheckBox createCheckBox();
}

class WinFactory implements GUIFactory {
    public Button createButton() {
        return new WinButton();
    }

    public CheckBox createCheckBox() {
        return new WinCheckBox();
    }
}

class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}

class CreateGUI {
    public GUIFactory createGUI(String os) {
        if (os.equalsIgnoreCase("Windows")) {
            return new WinFactory();
        } else if (os.equalsIgnoreCase("Mac")) {
            return new MacFactory();
        }
        return null;
    }
}

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        CreateGUI guiFactory = new CreateGUI();

        System.out.println("\n\nCreating Gui for Windows");

        GUIFactory winFactory = guiFactory.createGUI("Windows");
        Button winButton = winFactory.createButton();
        winButton.getName();
        CheckBox winCheckBox = winFactory.createCheckBox();
        winCheckBox.getName();

        System.out.println("\n\n==================");
        System.out.println("\n\nCreating Gui for Mac");

        GUIFactory macFactory = guiFactory.createGUI("Mac");
        Button macButton = macFactory.createButton();
        macButton.getName();
        CheckBox macCheckBox = macFactory.createCheckBox();
        macCheckBox.getName();

    }
}
