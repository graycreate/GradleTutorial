package me.ghui.gradledemo;

import java.util.Random;

/**
 * Created by vann on 12/21/14.
 */
public class NumUtils {
    public static int getRandomNum(int maxNum) {
        return new Random().nextInt(maxNum);
    }
}
