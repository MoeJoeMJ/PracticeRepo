class Sample {
    int n;
    // Private Constructor
    private Sample(int n) {
        this.n =n;
    }

    public static Sample initializeSample(int n) {
        return new Sample(n);
    }
}

public class PrivateConstructor {
    public static void main(String[] args) {
        Sample sample = Sample.initializeSample(6);
    }
}
