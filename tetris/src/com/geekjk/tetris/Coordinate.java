package com.geekjk.tetris;

/**
 * @author JackeyLee
 * @description:
 * @date 2020/12/15 21:17
 */
public class Coordinate {
    private Integer x;
    private Integer y;

    public Coordinate() {
    }

    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
