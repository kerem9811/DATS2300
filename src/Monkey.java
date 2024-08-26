import java.util.Random;

public class Monkey {

    private static final String CHARACTERS = " ABCDEFGHIJKLMNOPQRSTUVWXYZ .,!?;:'\"";
    private static final Random random = new Random();

    public static void main(String[] args) {
        int length = 1000; // Length of the generated text

        String monkeyText = generateMonkeyText(length);
        System.out.println(monkeyText);
    }

    private static String generateMonkeyText(int length) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            text.append(randomChar);
        }
        return text.toString();
    }
}