// Decorator Design Pattern
// Date: 21 Nov 2022
// Example: from book Page # 200 

interface DataSource {
    void writeData(String data);

    String readData();
}

class FileDataSource implements DataSource {
    private String fileName;

    public FileDataSource(String name) {
        this.fileName = name;
    }

    @Override
    public void writeData(String data) {
        System.out.println("Writing data to the file.");
    }

    @Override
    public String readData() {
        System.out.println("Reading data from the file.");
        return "data";
    }
}

class DataSourceDecorator implements DataSource {
    private DataSource wrappee;

    public DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}

class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        System.out.println("Encrypting data");
        super.writeData(data);
    }

    @Override
    public String readData() {
        System.out.println("Decrypting data");
        return super.readData();
    }
}

class Compression extends DataSourceDecorator {
    public Compression(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        System.out.println("Compressing data");
        super.writeData(data);
    }

    @Override
    public String readData() {
        System.out.println("Decompressing data");
        return super.readData();
    }
}

public class Example1 {
    public static void main(String[] args) {
        DataSource source = new FileDataSource("data.txt");
        source.writeData("Some data");
        source.readData();

        System.out.println("------------");

        DataSourceDecorator decorator = new EncryptionDecorator(source);
        decorator.writeData("Some data");
        decorator.readData();

        System.out.println("------------");

        DataSourceDecorator decorator2 = new Compression(decorator);
        decorator2.writeData("Some data");
        decorator2.readData();
    }
}
