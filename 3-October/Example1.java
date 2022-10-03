interface Laptop {
    void displayInfo();
}

class Dell implements Laptop {
    @Override
    public void displayInfo() {
        System.out.println("Dell Laptop");
    }
}

class HP implements Laptop {
    @Override
    public void displayInfo() {
        System.out.println("HP Laptop");
    }
}

class Lenovo implements Laptop {
    @Override
    public void displayInfo() {
        System.out.println("Lenovo Laptop");
    }
}

class LaptopFactory {
    public Laptop getLaptop(String laptopType) {
        if (laptopType == "DELL") {
            return new Dell();
        } else if (laptopType == "HP") {
            return new HP();
        } else if (laptopType == "LENOVO") {
            return new Lenovo();
        }
        return null;
    }
}

public class Example1 {
    public static void main(String[] args) {
        LaptopFactory laptopFactory = new LaptopFactory();

        Laptop dell_laptop = laptopFactory.getLaptop("DELL");
        dell_laptop.displayInfo();

        Laptop hp_laptop = laptopFactory.getLaptop("HP");
        hp_laptop.displayInfo();
    }
}
