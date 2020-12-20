package com.geekjk.tetris;

import java.util.Random;

/**
 * @author JackeyLee
 * @description:
 * @date 2020/12/19 13:33
 */
public enum BasicBlockType {
    J, Z, S, I, T, O, L;
    private static final Random random = new Random();

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
