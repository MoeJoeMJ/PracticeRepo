package UserManagement;

import UserManagement.User;

import java.util.Scanner;

// Regular UserManagement.User inherits UserManagement.User and implements UserManagement.UserActions interface
public class RegularUser extends User implements UserActions {

    public RegularUser(String username, String password) {
        super(username, password);
    }

    // Overriding methods in UserManagement.UserActions interface
    @Override
    public void viewProfile() {
        System.out.println(getUsername() + " can view details");
    }

    @Override
    public void editProfile() {
        System.out.println(getUsername() + " can edit details");
    }

    // Overriding abstract method
    @Override
    public void getOption(Scanner scanner) {
        while(true) {
            System.out.println("1. View Details\n2. Edit Details\n3. Back");
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
                    return;
                }
            }
        }
    }

}
