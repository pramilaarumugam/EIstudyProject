package structural.facade;

import java.util.Random;

public class OTPService {
    public String generateOTP() {
        Random rand = new Random();
        int otp = 100000 + rand.nextInt(900000);
        return String.valueOf(otp);
    }

    public void sendOTP(String username, String otp) {
        System.out.println("Sending OTP " + otp + " to user " + username);
    }
}
