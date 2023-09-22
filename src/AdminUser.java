import java.util.Scanner;

public class AdminUser extends RegularUser {
    public AdminUser(String username, String password){
        super(username,password);
    }

    public void displayMenu(){
        System.out.println("1. View Details");
        System.out.println("2. Edit Details");
        System.out.println("3. Manage Users");
    }

    @Override
    public void getOption(Scanner scanner){
        while(true) {
            System.out.println("1. View Details\n2. Edit Details\n3. Manage Users\n4. Back");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1: {
                    viewProfile();
                    break;
                }
                case 2: {
                    editProfile();
                    break;
                }
                case 3: {
                    manageUsers();
                    break;
                }
                case 4: {
                    return;
                }
            }
        }
    }

    public void manageUsers(){
        System.out.println(getUsername() + " can manage other users as well");
    }

}
