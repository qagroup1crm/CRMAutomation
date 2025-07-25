package utils;

import java.util.Random;
import java.util.UUID;

public class RandomDataGenerator {
	
	
	private final String[] FIRST_NAMES = {"John", "Alice", "David", "Priya", "Ravi", "Emma"};
    private final String[] LAST_NAMES = {"Smith", "Patel", "Brown", "Kumar", "Johnson"};

    public String getRandomFullName() {
        Random random = new Random();
        return FIRST_NAMES[random.nextInt(FIRST_NAMES.length)] + " " + LAST_NAMES[random.nextInt(LAST_NAMES.length)];
    }

    public String getRandomMobileNumber() {
        Random random = new Random();
        return "9" + (random.nextInt(900000000) + 100000000); // Starts with 9
    }

    public String getRandomEmail() {
        return "user" + UUID.randomUUID().toString().substring(0, 5) + "@test.com";
    }

    public String getRandomUsername() {
        return "user_" + UUID.randomUUID().toString().substring(0, 6);
    }

    public String getRandomPassword() {
        return "Pwd@" + (new Random().nextInt(9000) + 1000); // Simple random password
    }
}

