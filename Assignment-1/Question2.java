// Software House Example with Abstract Factory Design Pattern

interface Website {
    public void details();
}

class Wordpress implements Website {
    public void details() {
        System.out.println("Platform: Browsers");
        System.out.println("Name: Wordpress");
    }
}

class Shopify implements Website {
    public void details() {
        System.out.println("Platform: Browsers");
        System.out.println("Name: Shopify");
    }
}

class React implements Website {
    public void details() {
        System.out.println("Platform: Browsers");
        System.out.println("Name: React");
    }
}

interface AndroidApp {
    public void details();
}

class JavaApp implements AndroidApp {
    public void details() {
        System.out.println("Platform: Android");
        System.out.println("Name: Java App");
    }
}

class KotlinApp implements AndroidApp {
    public void details() {
        System.out.println("Platform: Android");
        System.out.println("Name: Kotlin App");
    }
}

class ReactNativeApp implements AndroidApp {
    public void details() {
        System.out.println("Platform: Android");
        System.out.println("Name: React Native App");
    }
}

interface Agency {
    public Website getWebsite(String websiteType);

    public AndroidApp getAndroidApp(String androidAppType);
}

class WebAgency implements Agency {
    public Website getWebsite(String websiteType) {
        if (websiteType == "Wordpress") {
            return new Wordpress();
        } else if (websiteType == "Shopify") {
            return new Shopify();
        } else if (websiteType == "React") {
            return new React();
        }
        return null;
    }

    public AndroidApp getAndroidApp(String androidAppType) {
        return null;
    }
}

class AppAgency implements Agency {
    public Website getWebsite(String websiteType) {
        return null;
    }

    public AndroidApp getAndroidApp(String androidAppType) {
        if (androidAppType == "Java") {
            return new JavaApp();
        } else if (androidAppType == "Kotlin") {
            return new KotlinApp();
        } else if (androidAppType == "ReactNative") {
            return new ReactNativeApp();
        }
        return null;
    }
}

class SoftwareHouse {
    public Agency getAgency(String agencyType) {
        if (agencyType == "Web") {
            return new WebAgency();
        } else if (agencyType == "App") {
            return new AppAgency();
        }
        return null;
    }
}

public class Question2 {
    public static void main(String[] args) {
        SoftwareHouse softwareHouse = new SoftwareHouse();

        System.out.println("Website");

        Agency webAgency = softwareHouse.getAgency("Web");
        Website website = webAgency.getWebsite("Wordpress");
        website.details();

        System.out.println("\n\nAndroid App");

        Agency appAgency = softwareHouse.getAgency("App");
        AndroidApp androidApp = appAgency.getAndroidApp("Java");
        androidApp.details();
    }
}