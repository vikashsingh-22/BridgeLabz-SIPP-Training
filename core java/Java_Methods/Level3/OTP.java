package Java_Methods.Level3;

import java.util.Arrays;

public class OTP {

    public static int generateOtp() {
        return (int)(Math.random() * 900000) + 100000;
    }

    public static boolean areOtpsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps = new int[10];

        for (int i = 0; i < 10; i++) {
            otps[i] = generateOtp();
        }

        System.out.println("Generated OTPs: " + Arrays.toString(otps));

        if (areOtpsUnique(otps)) {
            System.out.println("All OTPs are unique.");
        } else {
            System.out.println("Duplicate OTPs found.");
        }
    }
}
