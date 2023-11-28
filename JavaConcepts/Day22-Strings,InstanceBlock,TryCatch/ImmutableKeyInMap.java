import java.util.HashMap;
import java.util.Map;

public class ImmutableKeyInMap {
    public static void main(String[] args) {
        StringBuilder keyOne = new StringBuilder("1");
        Map<StringBuilder,String> hm = new HashMap<>();
        hm.put(keyOne,"Hi");
        keyOne.append("0");
        System.out.println(hm);  // Outputs {10=Hi} That's why String and wrapper classes are preferred as keys
    }
}

/*
 Output:
     {10=Hi}

 ```That's why String and wrapper classes are preferred as keys```
*/
