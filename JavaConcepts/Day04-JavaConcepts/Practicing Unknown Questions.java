///////////////////////////CONSTRUCTORS CAN BE OVERLOADED///////////////////////////////////////////////////


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


