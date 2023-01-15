// Software House Example with Factory Design Pattern

interface Software {
    public void platform();

    public void name();
}

class Website implements Software {
    public void platform() {
        System.out.println("Platform: Browsers");
    }

    public void name() {
        System.out.println("Name: Website");
    }
}

class AndoridApp implements Software {
    public void platform() {
        System.out.println("Platform: Android");
    }

    public void name() {
        System.out.println("Name: Android App");
    }
}

class IOSApp implements Software {
    public void platform() {
        System.out.println("Platform: IOS");
    }

    public void name() {
        System.out.println("Name: IOS App");
    }
}

class SoftwareHouse {
    public Software getSoftware(String softwareType) {
        if (softwareType == "Website") {
            return new Website();
        } else if (softwareType == "Android") {
            return new AndoridApp();
        } else if (softwareType == "IOS") {
            return new IOSApp();
        }
        return null;
    }
}

public class Question1 {
    public static void main(String[] args) {
        SoftwareHouse softwareHouse = new SoftwareHouse();

        System.out.println("Website");

        Software website = softwareHouse.getSoftware("Website");
        website.platform();
        website.name();

        System.out.println("\n\nAndroid App");
        Software androidApp = softwareHouse.getSoftware("Android");
        androidApp.platform();
        androidApp.name();

        System.out.println("\n\nIOS App");
        Software iosApp = softwareHouse.getSoftware("IOS");
        iosApp.platform();
        iosApp.name();
    }
}