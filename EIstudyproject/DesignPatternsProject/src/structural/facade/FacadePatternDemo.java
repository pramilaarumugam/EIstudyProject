package structural.facade;

import java.util.Scanner;

public class FacadePatternDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AuthFacade auth = new AuthFacade();

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        boolean success = auth.login(username, password);
        if(!success) {
            System.out.println("Login failed. Please try again.");
        }
        
    }
}
