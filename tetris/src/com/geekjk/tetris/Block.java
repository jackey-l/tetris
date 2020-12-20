package com.geekjk.tetris;

import java.awt.*;

/**
 * @author JackeyLee
 * @description:
 * @date 2020/12/15 21:15
 */
public class Block {
    private Integer xNo = 1;
    private Integer yNo = 1;
    private Color color;
    public Integer startX = 45;
    public Integer startY = 60;
    public Coordinate luCo = new Coordinate();
    public Coordinate ldCo = new Coordinate();
    public Coordinate ruCo = new Coordinate();
    public Coordinate rdCo = new Coordinate();

    public Point leftP = new Point(xNo-1.0,yNo-0.5);
    public Point rightP = new Point(xNo+0.0,yNo-0.5);
    public Point topP = new Point(xNo-0.5,yNo-1.0);
    public Point BottomP = new Point(xNo-0.5,yNo+0.0);
    private static final Integer BLOCK_SIZE = 30;

    public Block(Integer xNo, Integer yNo, Color color) {
        this.xNo = xNo;
        this.yNo = yNo;
        this.color = color;

        this.leftP.setX(xNo-1.0);
        this.leftP.setY(yNo-0.5);
        this.rightP.setX(xNo+0.0);
        this.rightP.setY(yNo-0.5);
        this.topP.setX(xNo-0.5);
        this.topP.setY(yNo-1.0);
        this.BottomP.setX(xNo-0.5);
        this.BottomP.setY(yNo+0.0);

        
        this.luCo.setX(this.startX+(this.xNo-1)*BLOCK_SIZE);
        this.luCo.setY(this.startY+(this.yNo-1)*BLOCK_SIZE);
        this.ldCo.setX(this.startX+(this.xNo-1)*BLOCK_SIZE);
        this.ldCo.setY(this.startY+(this.yNo)*BLOCK_SIZE);
        this.ruCo.setX(this.startX+(this.xNo)*BLOCK_SIZE);
        this.ruCo.setY(this.startY+(this.yNo-1)*BLOCK_SIZE);
        this.rdCo.setX(this.startX+(this.xNo)*BLOCK_SIZE);
        this.rdCo.setY(this.startY+(this.yNo)*BLOCK_SIZE);
    }

    public void refreshPoint() {
        this.leftP.setX(xNo-1.0);
        this.leftP.setY(yNo-0.5);
        this.rightP.setX(xNo+0.0);
        this.rightP.setY(yNo-0.5);
        this.topP.setX(xNo-0.5);
        this.topP.setY(yNo-1.0);
        this.BottomP.setX(xNo-0.5);
        this.BottomP.setY(yNo+0.0);
    }

    public void draw(Graphics g) {
        Color color = g.getColor();

        this.luCo.setX(this.startX+(this.xNo-1)*BLOCK_SIZE);
        this.luCo.setY(this.startY+(this.yNo-1)*BLOCK_SIZE);
        this.ldCo.setX(this.startX+(this.xNo-1)*BLOCK_SIZE);
        this.ldCo.setY(this.startY+(this.yNo)*BLOCK_SIZE);
        this.ruCo.setX(this.startX+(this.xNo)*BLOCK_SIZE);
        this.ruCo.setY(this.startY+(this.yNo-1)*BLOCK_SIZE);
        this.rdCo.setX(this.startX+(this.xNo)*BLOCK_SIZE);
        this.rdCo.setY(this.startY+(this.yNo)*BLOCK_SIZE);
        g.setColor(this.color);
        g.fillRect(this.luCo.getX()+1,this.luCo.getY()+1 , BLOCK_SIZE-1, BLOCK_SIZE-1);
        g.setColor(color);
    }

    @Override
    public String toString() {
        return "Block{" +
                "xNo=" + xNo +
                ", yNo=" + yNo +
                ", color=" + color +
                ", startX=" + startX +
                ", startY=" + startY +
                ", luCo=" + luCo +
                ", ldCo=" + ldCo +
                ", ruCo=" + ruCo +
                ", rdCo=" + rdCo +
                '}';
    }

    public Integer getxNo() {
        return xNo;
    }

    public void setxNo(Integer xNo) {
        this.xNo = xNo;
    }

    public Integer getyNo() {
        return yNo;
    }

    public void setyNo(Integer yNo) {
        this.yNo = yNo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
