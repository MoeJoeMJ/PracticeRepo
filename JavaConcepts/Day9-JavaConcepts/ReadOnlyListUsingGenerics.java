import java.util.ArrayList;
import java.util.Arrays;

public class ReadOnlyListUsingGenerics {
    public static void main(String[] args) {
        ArrayList<? extends Number> arrList = new ArrayList<>(Arrays.asList(6,7,8)); // Can add elements at the declaration
        // arrList.add(Integer.parseInt("6"));  // Can't add. Read Only list.
        System.out.println(arrList);
    }

}
