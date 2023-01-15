// Software House Example with Builder Design Pattern

interface SoftwarePlan {
    public void setPlatform(String platform);

    public void setName(String name);

    public void setVersion(String version);
}

class Software implements SoftwarePlan {
    private String platform;
    private String name;
    private String version;

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void softwareDetails() {
        System.out.println("Operating System: " + platform);
        System.out.println("Name: " + name);
        System.out.println("Version" + version);
    }

}

interface SoftwareBuilder {
    public void developSoftware();

    public Software getSoftware();
}

class Website implements SoftwareBuilder {

    private Software website;

    public Website() {
        this.website = new Software();
    }

    public void developSoftware() {
        website.setName("Website");
        website.setPlatform("Browsers");
        website.setVersion("v2");
    }

    public Software getSoftware() {
        System.out.println("Website");
        return this.website;
    }
}

class Android implements SoftwareBuilder {

    private Software android;

    public Android() {
        this.android = new Software();
    }

    public void developSoftware() {
        android.setName("Android App");
        android.setPlatform("Android");
        android.setVersion("v1");
    }

    public Software getSoftware() {
        System.out.println("Andorid Software");
        return this.android;
    }
}

class Developer {
    private SoftwareBuilder softwareDeveloper;

    public Developer(SoftwareBuilder developer) {
        this.softwareDeveloper = developer;
    }

    public Software getSoftware() {
        return this.softwareDeveloper.getSoftware();
    }

    public void developSoftware() {
        this.softwareDeveloper.developSoftware();
    }
}

class SoftwareHouse {
    SoftwareBuilder software;
    Developer developer;

    Developer makeSoftware(String software) {

        if (software == "website") {
            this.software = new Website();
        } else if (software == "android") {
            this.software = new Android();
        } else {
            return null;
        }

        return developer = new Developer(this.software);
    }
}

public class Question3 {
    public static void main(String[] args) {
        SoftwareHouse systems = new SoftwareHouse();
        Developer softwareEngineer = systems.makeSoftware("website");
        softwareEngineer.developSoftware();

        Software software = softwareEngineer.getSoftware();

        System.out.println(software);

    }

}