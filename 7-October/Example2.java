interface Laptop {
    void category();
}

class Gaming_Dell implements Laptop {
    public void category() {
        System.out.println("Gaming Dell Laptop");
    }

}

class Gaming_HP implements Laptop {
    public void category() {
        System.out.println("Gaming HP Laptop");
    }

}

class Bussiness_Dell implements Laptop {
    public void category() {
        System.out.println("Bussiness Dell Laptop");
    }

}

class Bussiness_HP implements Laptop {
    public void category() {
        System.out.println("Bussiness HP Laptop");
    }

}

interface LaptopFactory {
    Laptop create_Dell_Laptop();

    Laptop create_HP_Laptop();
}

class GamingLaptopFactory implements LaptopFactory {
    public Laptop create_Dell_Laptop() {
        return new Gaming_Dell();
    }

    public Laptop create_HP_Laptop() {
        return new Gaming_HP();
    }
}

class BussinessLaptopFactory implements LaptopFactory {
    public Laptop create_Dell_Laptop() {
        return new Bussiness_Dell();
    }

    public Laptop create_HP_Laptop() {
        return new Bussiness_HP();
    }
}

class CreateLaptopFactory {
    public LaptopFactory createLaptop(String category) {
        if (category.equalsIgnoreCase("Gaming")) {
            return new GamingLaptopFactory();
        } else if (category.equalsIgnoreCase("Bussiness")) {
            return new BussinessLaptopFactory();
        }
        return null;
    }
}

public class Example2 {
    public static void main(String[] args) {
        CreateLaptopFactory createLaptopFactory = new CreateLaptopFactory();
        System.out.println("\n\nCreating Gaming Laptops");

        LaptopFactory gamingLaptopFactory = createLaptopFactory.createLaptop("Gaming");
        Laptop gamingDellLaptop = gamingLaptopFactory.create_Dell_Laptop();
        gamingDellLaptop.category();
        Laptop gamingHPLaptop = gamingLaptopFactory.create_HP_Laptop();
        gamingHPLaptop.category();

        System.out.println("\n\n================");
        System.out.println("\n\nCreating Bussiness Laptops");

        LaptopFactory bussinessLaptopFactory = createLaptopFactory.createLaptop("Bussiness");
        Laptop bussinessDellLaptop = bussinessLaptopFactory.create_Dell_Laptop();
        bussinessDellLaptop.category();
        Laptop bussinessHPLaptop = bussinessLaptopFactory.create_HP_Laptop();
        bussinessHPLaptop.category();

    }
}
