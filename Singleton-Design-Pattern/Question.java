// Singleton Design Pattern

class AudioDriverService {
    private static AudioDriverService instance;

    private AudioDriverService() {
    }

    public static AudioDriverService getDriver() {
        if (instance == null) {
            instance = new AudioDriverService();
        }
        return instance;
    }

    public void playAudio(String media) {
        System.out.println("Playing " + media);
    }
}

class WindowsMediaPlayer {
    AudioDriverService audioDriver;

    public WindowsMediaPlayer() {
        audioDriver = AudioDriverService.getDriver();
    }

    public void playMedia(String media) {
        System.out.println("Windows Media Player");
        audioDriver.playAudio(media);
    }
}

class YoutubePlayer {
    AudioDriverService audioDriver;

    public YoutubePlayer() {
        audioDriver = AudioDriverService.getDriver();
    }

    public void playMedia(String media) {
        System.out.println("Youtube Player");
        audioDriver.playAudio(media);
    }
}

public class Question {

    public static void main(String[] args) {
        WindowsMediaPlayer p1 = new WindowsMediaPlayer();
        YoutubePlayer yt = new YoutubePlayer();

        p1.playMedia("Song 1");

        System.out.println("\n------------\n");

        yt.playMedia("Youtube Video 123");
    }
}