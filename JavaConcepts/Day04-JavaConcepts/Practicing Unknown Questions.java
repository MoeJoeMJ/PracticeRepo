///////////////////////////CONSTRUCTORS CAN BE OVERLOADED///////////////////////////////////////////////////

class ConstructorOverloading {
    int variable;
    public ConstructorOverloading() {
        this.variable = 1;
    }
    public ConstructorOverloading(int variable) {
        this.variable = variable;
    }
}
public class Main {
    public static void main(String[] args) {
       ConstructorOverloading constructorOverload = new ConstructorOverloading(9);
       ConstructorOverloading constructorOverload1 = new ConstructorOverloading();
       System.out.println(constructorOverload.variable);
       System.out.println(constructorOverload1.variable);
        }
    }



////////////////////////////ABSTRACT CLASSES CAN HAVE MULTIPLE CONSTRUCTORS///////////////////////////////////

abstract class AbstractSuperClass {
    private int variable;
    public AbstractSuperClass() {
        this.variable = 1;
    }
    public AbstractSuperClass(int variable) {
        this.variable = variable;
    }
}

class SubClass extends AbstractSuperClass {
    public SubClass(int variable) {
        super(variable);
    }

    public SubClass() {
        super();
    }
    public int getVariable() {
        return this.variable;
    }
}

public class Main {
    public static void main(String[] args) {
       SubClass subClass = new SubClass(9);
       SubClass subClass1 = new SubClass();
       System.out.println(subClass1.getVariable());
        }
    }



////////////////////////////ABSTRACT CAN HAVE STATIC METHODS//////////////////////////////////////


abstract class CheckAbstract {
    int variable;
    public static String returnOne() {
        return "1";
    }
}
public class Main {
    public static void main(String[] args) {
       System.out.println(CheckAbstract.returnOne());
        }
    }


