package behavioral.strategy;

import java.util.Scanner;

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    public CreditCardPayment(String cardNumber) { this.cardNumber = cardNumber; }
    public void pay(int amount) { System.out.println("Paid " + amount + " using Credit Card: " + cardNumber); }
}

class UPIPayment implements PaymentStrategy {
    private String upiId;
    public UPIPayment(String upiId) { this.upiId = upiId; }
    public void pay(int amount) { System.out.println("Paid " + amount + " using UPI: " + upiId); }
}

class WalletPayment implements PaymentStrategy {
    private String walletId;
    public WalletPayment(String walletId) { this.walletId = walletId; }
    public void pay(int amount) { System.out.println("Paid " + amount + " using Wallet: " + walletId); }
}

class ShoppingContext {
    private PaymentStrategy strategy;
    public void setPaymentStrategy(PaymentStrategy strategy) { this.strategy = strategy; }
    public void payAmount(int amount) { strategy.pay(amount); }
}

public class ShoppingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingContext context = new ShoppingContext();

        System.out.print("Enter payment method (CreditCard / UPI / Wallet): ");
        String method = sc.nextLine().trim();

        System.out.print("Enter amount: ");
        int amount = 0;
        try {
            amount = Integer.parseInt(sc.nextLine());
        } catch(Exception e) {
            System.out.println("[Error] Invalid amount.");
            return;
        }

        switch(method.toLowerCase()) {
            case "creditcard":
                System.out.print("Enter card number: ");
                String card = sc.nextLine();
                context.setPaymentStrategy(new CreditCardPayment(card));
                break;
            case "upi":
                System.out.print("Enter UPI ID: ");
                String upi = sc.nextLine();
                context.setPaymentStrategy(new UPIPayment(upi));
                break;
            case "wallet":
                System.out.print("Enter Wallet ID: ");
                String wallet = sc.nextLine();
                context.setPaymentStrategy(new WalletPayment(wallet));
                break;
            default:
                System.out.println("[Error] Invalid payment method.");
                return;
        }
        

        context.payAmount(amount);
        
    }
}
