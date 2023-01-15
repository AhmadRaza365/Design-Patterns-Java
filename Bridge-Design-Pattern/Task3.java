// Bridge Design Pattern

interface Device {
    boolean isTurnedOn();

    void turnOn();

    void turnOff();
}

class LedLight implements Device {
    private boolean on = false;

    public boolean isTurnedOn() {
        return on;
    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }
}

class Fan implements Device {
    private boolean on = false;

    public boolean isTurnedOn() {
        return on;
    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }
}

// Implementor for bridge pattern
interface Switch {
    void press();
}

class CommonSwitch implements Switch {
    private Device device;

    public CommonSwitch(Device device) {
        this.device = device;
    }

    public void press() {
        System.out.println("Pressing the common switch");
        if (device.isTurnedOn()) {
            device.turnOff();
        } else {
            device.turnOn();
        }
    }
}

class PushButtonSwitch implements Switch {
    private Device device;

    public PushButtonSwitch(Device device) {
        this.device = device;
    }

    public void press() {
        System.out.println("Pressing the push button switch");

        // first press turn on - then after 5 seconds turn off

        device.turnOn();
        System.out.println("... device turned on");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        device.turnOff();
        System.out.println("device turned off after 5 seconds");
    }
}

public class Task3 {
    public static void main(String[] args) {
        Device ledLight = new LedLight();
        Switch commonSwitch = new CommonSwitch(ledLight);
        commonSwitch.press();
        commonSwitch.press();
        commonSwitch.press();

        Device fan = new Fan();
        Switch pushButtonSwitch = new PushButtonSwitch(fan);
        pushButtonSwitch.press();
    }
}
