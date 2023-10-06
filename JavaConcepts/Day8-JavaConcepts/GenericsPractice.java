import java.util.List;

class ParentClass {
    public void printLocation() {
        System.out.println("From the method in ParentClass");
    }
}

class ChildClass extends ParentClass{
    public void printLocation() {
        System.out.println("From the method in ChildClass");
    }
}

public class GenericsPractice {

    // Using type parameter "T" to get back the same type as the list that's passed in
    static <T extends ParentClass> List<T> getSameTypeList(List<T> newList) {
        return newList;
    }

    // Using wildcard doesn't guarantee to return the same type that's the list passed in
    static List<? extends ParentClass> getList(List<? extends ParentClass> newList) {
        for(ParentClass p: newList) {
            p.printLocation(); // Exhibits polymorphic behaviour
        }
        return newList;
    }
    
    public static void main(String[] args) {

        List<ParentClass> newList = List.of(new ParentClass(), new ChildClass(),new ParentClass()); // Creating a list of objects of different type
        List<? extends ParentClass> typeUnknownList = getList(newList); // Using wildcard
        List<ParentClass> sameTypeList = getSameTypeList(newList); // Using type parameter "T"

        // Attempt to find which type does getList returns
        // Prints List still unknown everytime
        if (typeUnknownList instanceof ParentClass) {
            System.out.println("List is of Parent Class");
        } 
        else if (typeUnknownList instanceof ChildClass) {
            System.out.println("List is of Child Class");
        } 
        else {
            System.out.println("List still unknown");
        }
        
    }
    
}

