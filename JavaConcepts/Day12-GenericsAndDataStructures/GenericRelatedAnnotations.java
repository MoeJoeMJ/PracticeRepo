import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GenericClass<T> {

    T t;

    void print(T t) {
        System.out.println(t);
    }

    @SafeVarargs // Suppresses heap pollution warning
    final <T> void varArgsMethod(List<T>... lists) {  // @SafeVarargs cannot be used in non-final instance method

        for (List<T> list : lists)
            System.out.println(list);
    }

}
public class GenericRelatedAnnotations {

    @SuppressWarnings("unchecked") // Suppresses unchecked warning
    public static void main(String[] args) {
        GenericClass genericClass = new GenericClass();
        genericClass.print("Hi");

        List<Integer> iList = new ArrayList<>(Arrays.asList(1,2,3));
        List<String> strList = new ArrayList<>(Arrays.asList("Hi","Hello","Namaste"));

        genericClass.varArgsMethod(iList,strList);
    }


}
