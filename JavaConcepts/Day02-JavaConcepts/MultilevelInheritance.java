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


public class MultilevelInheritance {
    public static void main(String[] args) {
        Thamizh thamizh = new Thamizh();
        thamizh.race();
        thamizh.nationality();
        thamizh.language();
    }
}

/*
Ouputs:
        This person is asian
        This person is an Indian
        This person speaks Thamizh
*/
