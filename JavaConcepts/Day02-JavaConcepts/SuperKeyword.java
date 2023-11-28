// Parent class
class Country {
    String nationality;

    Country(String nationality) {
        this.nationality = nationality;
    }

    void displayNationality() {
        System.out.println("This person is an " + nationality);
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

public class SuperKeyword {
    public static void main(String[] args) {
        India india = new India("Indian");
        india.displayNationality();  // Outputs "This person is an Indian"
    }
}


