interface Employee {
    public void doWork();
}

class Company {
    void getEmployees() {
        System.out.println("Employees Data");
    }

    void creatSoftware() {
        System.out.println("Creating Software");
    }
}

class GameDevCompany extends Company implements Employee {
    public void doWork() {
        System.out.println("Develop games");
    }
}

class OutSourcingCompany extends Company implements Employee {
    public void doWork() {
        System.out.println("Out Source the work");
    }
}

class Task1 {
    public static void main(String[] args) {
        GameDevCompany gameDeveloper = new GameDevCompany();
        gameDeveloper.doWork();

        OutSourcingCompany outSourcer = new OutSourcingCompany();
        outSourcer.doWork();

    }
}