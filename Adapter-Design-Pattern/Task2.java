// Adapter Design Pattern

interface Bulb {
    public void turnAc(String bulbName);

    public void turnDc(String bulbName);
}

interface Switch {
    public void turnOn(String currentType, String bulbName);
}

class AcBulb implements Bulb {
    public void turnAc(String bulbName) {
        System.out.println("AC Current " + bulbName + " is turned on");
    }

    public void turnDc(String bulbName) {
        // do nothing
    }
}

class DcBulb implements Bulb {
    public void turnAc(String bulbName) {
        // do nothing
    }

    public void turnDc(String bulbName) {
        System.out.println("DC Current " + bulbName + " is turned on");
    }
}

class BulbAdapter implements Switch {
    Bulb bulb;

    public BulbAdapter(String currentType) {
        if (currentType == "AC") {
            bulb = new AcBulb();
        } else if (currentType == "DC") {
            bulb = new DcBulb();
        }
    }

    public void turnOn(String currentType, String bulbName) {
        if (currentType == "AC") {
            bulb.turnAc(bulbName);
        } else if (currentType == "DC") {
            bulb.turnDc(bulbName);
        }
    }
}

class AcSwitch implements Switch {
    BulbAdapter bulbAdapter;

    public void turnOn(String currentType, String bulbName) {
        if (currentType == "AC") {
            System.out.println("AC Current " + bulbName + " is turned on");
        } else if (currentType == "DC") {
            bulbAdapter = new BulbAdapter(currentType);
            bulbAdapter.turnOn(currentType, bulbName);
        }
    }
}

public class Task2 {
    public static void main(String[] args) {
        AcSwitch acSwitch = new AcSwitch();
        acSwitch.turnOn("AC", "Philips Bulb");
        acSwitch.turnOn("DC", "Led Bulb");
    }

}
