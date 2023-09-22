
// MULTI_LEVEL INHERITANCE

// Parent class
class Asian {
    void race(){
        System.out.println("This person is asian");
    }
}


// Child class inheriting from Parent class
class Indian extends Asian {
    void nationality(){
        System.out.println("This person is an Indian");
    }
}

// Another child class inheriting from Indian class
class Thamizh extends Indian{
    public void language(){
        System.out.println("This person speaks Thamizh");
    }
}


public class Main {
    public static void main(String[] args) {
        Thamizh thamizh = new Thamizh();
        thamizh.race();
        thamizh.nationality();
        thamizh.language();
    }
}




// HIERARCHIAL INHERITANCE

// Parent class
class India {
    void language() {
        System.out.println("Speaks English");
    }
}

// Child class inheriting India class
class TamilNadu extends India {
    void language() {
        System.out.println("Speaks Thamizh");
    }
}

// Another child class inheriting India class
class Karnataka extends India {
    void language() {
        System.out.println("Speaks Kannada");
    }
}

class Main {
    public static void main(String[] args) {
        TamilNadu tamilnadu = new TamilNadu();
        Karnataka karnataka = new Karnataka();
        tamilnadu.language();
        karnataka.language();
    }
}





// MULTIPLE INHERITANCE USING INTERFACE

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

public class Main {
    public static void main(String[] args) {
        Tamilian tamilian = new Tamilian();
        Malaysian malaysian = new Malaysian();
        NRI nri = new NRI();

        tamilian.speakTamil();
        malaysian.speakMalay();
        nri.speakTamil();
        nri.speakMalay();
    }
}


// USAGE OF Super KEYWORD


// Parent class
class Country {
    String nationality;

    Vehicle(String nationality) {
        this.nationality = nationality;
    }

    void displayNationality() {
        System.out.println("This person is an" + nationality);
    }
}

class India extends Country {
    India(String nationality) {
        super(nationality); // Calls Parent class constructor
    }

    @Override
    void displayNationality() {
        super.displayNationality(); // Calls the Parent class method
    }
}

public class Main {
    public static void main(String[] args) {
        India india = new India("Indian");
        india.displayNationality();
    }
}



// POLYMORPHISM


// Method overloading and Method overriding
class Parent {
    void show() {
        System.out.println("Parent class");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Overridden method");
    }

    void show(String str) {
        System.out.println(str + " method");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.show();
        Child child = new Child();
        child.show();
        child.show("Overloaded");
    }
}



// A protected instance method can be made public
class Parent {
    protected void show() {
        System.out.println("Protected method");
    }
}

class Child extends Parent() {
    @Override
    public void show() {
        System.out.println("Overridden as Public method");
    }
}

class Main {
    public static void main(String[] args) {
        Parent parent = new Child;
        parent.show();
    }
}