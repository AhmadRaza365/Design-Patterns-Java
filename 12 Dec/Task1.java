// Proxy Design Pattern
// 12 December 2022

interface Student {
    public void attendClass();
}

class Ahmad implements Student {
    @Override
    public void attendClass() {
        System.out.println("Ahmad: Attending class.");
    }
}

class Proxy implements Student {
    private Ahmad ahmad;

    @Override
    public void attendClass() {
        System.out.println("Someone doing proxy for Ahmad");
        if (ahmad == null) {
            ahmad = new Ahmad();
        }
        ahmad.attendClass();
    }
}

class Junaid implements Student {
    @Override
    public void attendClass() {
        System.out.println("Junaid: Attend class.");
    }

    public void doProxy() {
        Proxy proxy = new Proxy();
        proxy.attendClass();
    }
}

public class Task1 {

    public static void main(String[] args) {
        Junaid junaid = new Junaid();

        System.out.println("\n\nJunaid doing proxy for Ahmad\n\n");
        junaid.doProxy();
    }

}