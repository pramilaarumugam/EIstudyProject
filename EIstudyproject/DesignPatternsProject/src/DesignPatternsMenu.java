import java.util.Scanner;

// Import all patterns
import behavioral.observer.*;
import behavioral.strategy.*;
import creational.factory.*;
import creational.builder.*;
import structural.adapter.*;
import structural.facade.*;

public class DesignPatternsMenu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Design Patterns Project Menu ===");

        while(running) {
            System.out.println("\nSelect a use case to run:");
            System.out.println("1. Observer Pattern");
            System.out.println("2. Strategy Pattern");
            System.out.println("3. Factory Method Pattern");
            System.out.println("4. Builder Pattern");
            System.out.println("5. Adapter Pattern");
            System.out.println("6. Facade Pattern");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("[Error] Invalid input. Enter a number.");
                continue; // retry
            }

            switch(choice) {
                case 1:
                    System.out.println("\n--- Observer Pattern ---");
                    ObserverPatternDemo.main(null);
                    break;
                case 2:
                    System.out.println("\n--- Strategy Pattern ---");
                    ShoppingApp.main(null);
                    break;
                case 3:
                    System.out.println("\n--- Factory Method Pattern ---");
                    FactoryPatternDemo.main(null);
                    break;
                case 4:
                    System.out.println("\n--- Builder Pattern ---");
                    BuilderPatternDemo.main(null);
                    break;
                case 5:
                    System.out.println("\n--- Adapter Pattern ---");
                    AdapterPatternDemo.main(null);
                    break;
                case 6:
                    System.out.println("\n--- Facade Pattern ---");
                    FacadePatternDemo.main(null);
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("[Error] Invalid choice. Enter 0-6.");
            }
        }

        sc.close();
    }
}
