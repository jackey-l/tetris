package com.geekjk.tetris;

/**
 * @author JackeyLee
 * @description:
 * @date 2020/12/19 9:58
 */
public class Point {
    private Double x;
    private Double y;

    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {

    }



    public static Point string2Point(String s) {
        String[] split = s.split("@");
        return new Point(Double.valueOf(split[0].split("=")[1]), Double.valueOf(split[1].split("=")[1]));

    }

    @Override
    public String toString() {
        return "X=" + this.getX() + "@" + "Y=" + this.getY();
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}
