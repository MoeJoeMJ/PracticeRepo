package UserManagement;

import java.util.Scanner;

//Defined an abstract class for UserManagement.User
abstract class User {
    private String username;
    private String password;
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    // Declaring abstract method
    public abstract void getOption(Scanner scanner);

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

}
