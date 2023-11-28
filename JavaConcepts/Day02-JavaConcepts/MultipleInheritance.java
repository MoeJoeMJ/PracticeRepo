interface TamilSpeakable {
    void speakTamil();
}

interface MalaySpeakable {
    void speakMalay();
}

class Tamilian implements TamilSpeakable {
    @Override
    public void speakTamil() {
        System.out.println("Can speak Tamil");
    }
}

class Malaysian implements MalaySpeakable {
    @Override
    public void speakMalay() {
        System.out.println("Can speak Malay");
    }
}

class NRI implements TamilSpeakable, MalaySpeakable {
    @Override
    public void speakTamil() {
        System.out.println("Can speak Tamil but not that well versed");
    }

    @Override
    public void speakMalay() {
        System.out.println("Can speak only basic phrases in Malay");
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        Tamilian tamilian = new Tamilian();
        Malaysian malaysian = new Malaysian();
        NRI nri = new NRI();

        tamilian.speakTamil(); // Can speak Tamil
        malaysian.speakMalay();  // Can speak Malay
        nri.speakTamil();  // Can speak Tamil but not that well versed
        nri.speakMalay(); // Can speak only basic phrases in Malay
    }
}

