
// enum cannot have generic parameters but it can be passed as a type argument
enum Status {
    AVAILABLE,AWAY,BREAK
}

class SomeClass<T> {

    private T enumVar;

    public SomeClass(T enumVar) {
        this.enumVar = enumVar;
    }

    public T getStatus() {
        return enumVar;
    }

}
public class GenericEnumTest {
    public static void main(String[] args) {
        SomeClass<Status> someClass = new SomeClass<>(Status.AVAILABLE);
        System.out.println(someClass.getStatus());
    }

}
