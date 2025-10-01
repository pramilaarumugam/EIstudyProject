package behavioral.strategy;

public class WalletPayment implements PaymentStrategy {
    private String walletId;

    public WalletPayment(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Wallet: " + walletId);
    }
}

