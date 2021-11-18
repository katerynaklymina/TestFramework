package frame_UI.helper;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Randomizer {

    public static int randomNumberForStars() {
        Random random = new Random();
        return random.nextInt(5) + 1;
    }

    public static String randomAlphanumeric(int symbolsQuantity){
        return RandomStringUtils.randomAlphanumeric(symbolsQuantity);
    }

    public static String randomEmail(int symbolsQuantity){
        String end = "@gmail.com";
        String random = RandomStringUtils.randomAlphanumeric(symbolsQuantity);

        //String result = random.concat(end);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(random);
        stringBuilder.append(end);
        return stringBuilder.toString();

    }
}
