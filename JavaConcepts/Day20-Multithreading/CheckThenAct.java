import java.util.Map;

public class CheckThenAct  {
    boolean condition = true;

    void checkThenAct(){
        if(condition) {
            System.out.println("True");
            condition = false;
        }
        else {
            System.out.println("False");
            condition = true;
        }
    }


    public static void main(String[] args) {
        CheckThenAct obj = new CheckThenAct();
        Thread thread = new Thread(() -> {
            for(int i=0;i<50;i++) {
                obj.checkThenAct();
            }
        });
        thread.start();

        Thread thread1 = new Thread(() -> {
            for(int i=0;i<50;i++) {
                obj.checkThenAct();
            }
        });
        thread1.start();
    }
}
