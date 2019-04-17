package me.xiaoyuu.inwust.utils;

import java.util.Random;

public class CharUtil {

    public static String getRandomString(Integer num) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        return getRandom(num, base);
    }

    public static String getRandomNum(Integer num) {
        String base = "0123456789";
        return getRandom(num, base);

    }

    private static String getRandom(Integer num, String base) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            stringBuilder.append(base.charAt(number));
        }
        return stringBuilder.toString();
    }
}
