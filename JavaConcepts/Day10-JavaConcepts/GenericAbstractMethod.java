abstract class AbstractClass<E> {
    abstract <T>void print(T a);
}

class ConcreteClass<E> extends AbstractClass<E>{
    @Override
    <T>void print (T a) {

    }
}
public class GenericAbstractMethod {
    public static void main(String[] args) {

    }
}
