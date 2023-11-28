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

class HierarchialInheritance {
    public static void main(String[] args) {
        TamilNadu tamilnadu = new TamilNadu();
        Karnataka karnataka = new Karnataka();
        tamilnadu.language();
        karnataka.language();
    }
}

/*
Ouputs:
        Speaks Thamizh
        Speaks Kannada
*/
