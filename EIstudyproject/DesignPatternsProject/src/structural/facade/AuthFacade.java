package structural.facade;

public class AuthFacade {
    private UserDatabase userDb;
    private OTPService otpService;

    public AuthFacade() {
        userDb = new UserDatabase();
        otpService = new OTPService();
    }

    public boolean login(String username, String password) {
        if (!userDb.validateUser(username, password)) {
            System.out.println("Invalid username or password.");
            return false;
        }
        String otp = otpService.generateOTP();
        otpService.sendOTP(username, otp);

        // Simulate user entering OTP (for demo, accept any OTP)
        System.out.println("User entered OTP: " + otp);
        System.out.println("Login successful!");
        return true;
    }
}

