import java.util.*;
class SuperClass {

}

class SubClass extends SuperClass {

}
public class WildcardSubtyping {
    public static void main(String[] args) {
        List<SubClass> faultySubList = new ArrayList<>();
//        List<SuperClass> faultySuperList = faultySubList;  // Doesn't work as List<Integer> isn't a subtype of List<Number>

        List<? extends SubClass> subList = new ArrayList<>();
        List<? extends SuperClass> superList = subList;  // Works because List<? extends Integer> is a subtype of List<? extends Number>
    }
}
