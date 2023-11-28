public class InstanceBlockCheck {
    static {
        System.out.println("Static block");
    }
    {
        System.out.println("Instance Block");
    }
    InstanceBlockCheck(){
        System.out.println("Constructor");
    }
    public static void main(String[] args) {
        new InstanceBlockCheck();
    }
}


/*
Output:
        Static block
        Instance Block
        Constructor
*/

