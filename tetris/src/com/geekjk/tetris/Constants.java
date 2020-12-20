package com.geekjk.tetris;

/**
 * @author JackeyLee
 * @description:
 * @date 2020/12/19 12:55
 */
public class Constants {
    public static final String BASIC_BLOCK_TOP = "UP";
    public static final String BASIC_BLOCK_BOTTOM = "BOTTOM";
    public static final String BASIC_BLOCK_LEFT = "LEFT";
    public static final String BASIC_BLOCK_RIGHT = "RIGHT";
    public static final String GAME_FRAME_BORDER = "GAME_FRAME_BORDER";
    public static final String GAME_FRAME_FIXED_BLOCK = "GAME_FRAME_FIXED_BLOCK";
   // 0-未生成，1-等待生成中，2-生成失败（游戏结束），3-已生成（新），4-可移动，5-已固定，6-已消除；
    public static final int BASIC_BLOCK_STATUS_NULL = 0;
    public static final int BASIC_BLOCK_STATUS_WAIT4CREATE = 1;
    public static final int BASIC_BLOCK_STATUS_CREATEFAIL_GAME_OVER = 2;
    public static final int BASIC_BLOCK_STATUS_NEW = 3;
    public static final int BASIC_BLOCK_STATUS_MOVABLE = 4;
    public static final int BASIC_BLOCK_STATUS_FIXED = 5;
    public static final int BASIC_BLOCK_STATUS_SCORED = 5;

    //移动后3种状态，1-可继移动，2-固定，3-消除其他方块
    public static final int AFTER_MOVING_STATUS_CANCONTINUE = 1;
    public static final int AFTER_MOVING_STATUS_FIXED = 2;
    public static final int AFTER_MOVING_STATUS_SCORE = 3;

}
