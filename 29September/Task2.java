// Book Page 

interface CloudHostingProvider {
    void creatServer(String region);

    void listServers(String region);
}

interface CDNProvider {
    void getCDNAddress();
}

interface CloudStorageProvider {
    void storeFile(String name);

    void getFile(String file);
}

class Amazon implements CloudHostingProvider, CDNProvider, CloudStorageProvider {
    public void creatServer(String region) {
        System.out.println("Create Server in " + region + " region");
    }

    public void listServers(String region) {
        System.out.println("Gives all Server in " + region + " region");
    }

    public void getCDNAddress() {
        System.out.println("CDN Address");
    }

    public void storeFile(String name) {
        System.out.println("Storing " + name + " file");
    }

    public void getFile(String file) {
        System.out.println("Gives " + file + " file");
    }
}

class DropBox implements CloudStorageProvider {
    public void storeFile(String name) {
        System.out.println("Storing " + name + " file");
    }

    public void getFile(String file) {
        System.out.println("Give " + file + " file");
    }
}

public class Task2 {

    public static void main(String[] args) {
        Amazon awsPk = new Amazon();
        
        System.out.println("Amazon Class\n\n");
        
        awsPk.creatServer("PK");
        awsPk.getCDNAddress();
        awsPk.storeFile("Doc 1");
        awsPk.getFile("Doc 1");
        
        System.out.println("\n\n ========================");
        System.out.println("DropBox Class\n\n");
        DropBox db = new DropBox();

        db.storeFile("Doc 2");
        db.getFile("Doc 2");
    }
}
