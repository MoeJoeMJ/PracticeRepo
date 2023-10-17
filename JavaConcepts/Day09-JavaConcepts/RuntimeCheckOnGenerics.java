import java.util.Arrays;
import java.util.List;

class GenericClass<T> {
    T someType;

    public GenericClass(T someType) {
        T Obj = new T(); // Doesn't work because type infos won't be available at runtime
    }
}
public class RuntimeCheckOnGenerics {
    GenericClass<Integer> genericClass = new GenericClass<>(1);
}
