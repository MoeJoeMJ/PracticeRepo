import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your choice:\n1.Admin\n2.RegularUser\n3.Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println("Enter your username:");
                    String username = scanner.nextLine();
                    System.out.println("Enter your password:");
                    String password = scanner.nextLine();
                    AdminUser admin = new AdminUser(username, password); // Creates an AdminUser object
                    admin.getOption(scanner); // Calls getOption method from AdminUser class
                    break;
                }
                case 2: {
                    System.out.println("Enter your username:");
                    String username = scanner.nextLine();
                    System.out.println("Enter your password:");
                    String password = scanner.nextLine();
                    RegularUser regular = new RegularUser(username, password); // Creates an RegularUser Object
                    regular.getOption(scanner); // Calls getOption from RegularUser class
                    break;
                }
                case 3: {
                    return;
                }
            }

        }
    }

}