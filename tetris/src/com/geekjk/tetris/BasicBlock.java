package com.geekjk.tetris;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.*;

/**
 * @author JackeyLee
 * @description:
 * @date 2020/12/15 21:15
 */
public class BasicBlock {


    //    public boolean noTouchLeft = true;
//    public boolean noTouchRight = true;
//    public boolean noTouchTop = true;
//    public boolean noTouchBottom = true;
    public BasicBlockType blockType;

    public List<Point> leftF = new ArrayList<>();
    public List<Point> rightF = new ArrayList<>();
    public List<Point> topF = new ArrayList<>();
    public List<Point> bottomF = new ArrayList<>();
    public boolean isTouchBottom = false;
    public KeysListener keysListener = new KeysListener(this);
    Map<String, Boolean> impactMap = new HashMap<>();
    boolean up, down, left, right;

    public boolean movable = true;
    public int status;

    public Color color;
    public List<Block> blockList = new ArrayList<>(4);

    public BasicBlock(BasicBlockType t, Color c) {
        this.impactMap.put(Constants.BASIC_BLOCK_TOP, false);
        this.impactMap.put(Constants.BASIC_BLOCK_BOTTOM, false);
        this.impactMap.put(Constants.BASIC_BLOCK_LEFT, false);
        this.impactMap.put(Constants.BASIC_BLOCK_RIGHT, false);

        switch (t) {
            case J:
                blockList.add(new Block(4, 1, c));
                blockList.add(new Block(4, 2, c));
                blockList.add(new Block(5, 2, c));
                blockList.add(new Block(6, 2, c));

                leftF.add(blockList.get(0).leftP);
                leftF.add(blockList.get(1).leftP);
                rightF.add(blockList.get(0).rightP);
                rightF.add(blockList.get(3).rightP);
                topF.add(blockList.get(0).topP);
                topF.add(blockList.get(2).topP);
                topF.add(blockList.get(3).topP);
                bottomF.add(blockList.get(1).BottomP);
                bottomF.add(blockList.get(2).BottomP);
                bottomF.add(blockList.get(3).BottomP);

                this.status = Constants.BASIC_BLOCK_STATUS_MOVABLE;
                break;
            case Z:
                blockList.add(new Block(4, 1, c));
                blockList.add(new Block(5, 1, c));
                blockList.add(new Block(5, 2, c));
                blockList.add(new Block(6, 2, c));

                leftF.add(blockList.get(0).leftP);
                leftF.add(blockList.get(2).leftP);
                rightF.add(blockList.get(1).rightP);
                rightF.add(blockList.get(3).rightP);
                topF.add(blockList.get(0).topP);
                topF.add(blockList.get(1).topP);
                topF.add(blockList.get(3).topP);
                bottomF.add(blockList.get(0).BottomP);
                bottomF.add(blockList.get(2).BottomP);
                bottomF.add(blockList.get(3).BottomP);
                this.status = Constants.BASIC_BLOCK_STATUS_MOVABLE;
                break;
            case S:
                blockList.add(new Block(4, 2, c));
                blockList.add(new Block(5, 2, c));
                blockList.add(new Block(5, 1, c));
                blockList.add(new Block(6, 1, c));

                leftF.add(blockList.get(0).leftP);
                leftF.add(blockList.get(2).leftP);
                rightF.add(blockList.get(1).rightP);
                rightF.add(blockList.get(3).rightP);
                topF.add(blockList.get(0).topP);
                topF.add(blockList.get(2).topP);
                topF.add(blockList.get(3).topP);
                bottomF.add(blockList.get(0).BottomP);
                bottomF.add(blockList.get(1).BottomP);
                bottomF.add(blockList.get(3).BottomP);
                this.status = Constants.BASIC_BLOCK_STATUS_MOVABLE;
                break;
            case I:
                blockList.add(new Block(4, 1, c));
                blockList.add(new Block(5, 1, c));
                blockList.add(new Block(6, 1, c));
                blockList.add(new Block(7, 1, c));

                leftF.add(blockList.get(0).leftP);
                rightF.add(blockList.get(3).rightP);
                topF.add(blockList.get(0).topP);
                topF.add(blockList.get(1).topP);
                topF.add(blockList.get(2).topP);
                topF.add(blockList.get(3).topP);
                bottomF.add(blockList.get(0).BottomP);
                bottomF.add(blockList.get(1).BottomP);
                bottomF.add(blockList.get(2).BottomP);
                bottomF.add(blockList.get(3).BottomP);
                this.status = Constants.BASIC_BLOCK_STATUS_MOVABLE;
                break;
            case T:
                blockList.add(new Block(4, 2, c));
                blockList.add(new Block(5, 2, c));
                blockList.add(new Block(6, 2, c));
                blockList.add(new Block(5, 1, c));

                leftF.add(blockList.get(0).leftP);
                leftF.add(blockList.get(3).leftP);
                rightF.add(blockList.get(2).rightP);
                rightF.add(blockList.get(3).rightP);
                topF.add(blockList.get(0).topP);
                topF.add(blockList.get(2).topP);
                topF.add(blockList.get(3).topP);
                bottomF.add(blockList.get(0).BottomP);
                bottomF.add(blockList.get(1).BottomP);
                bottomF.add(blockList.get(2).BottomP);
                this.status = Constants.BASIC_BLOCK_STATUS_MOVABLE;
                break;
            case O:
                blockList.add(new Block(5, 1, c));
                blockList.add(new Block(5, 2, c));
                blockList.add(new Block(6, 1, c));
                blockList.add(new Block(6, 2, c));

                leftF.add(blockList.get(0).leftP);
                leftF.add(blockList.get(2).leftP);
                rightF.add(blockList.get(1).rightP);
                rightF.add(blockList.get(3).rightP);
                topF.add(blockList.get(0).topP);
                topF.add(blockList.get(1).topP);
                bottomF.add(blockList.get(2).BottomP);
                bottomF.add(blockList.get(3).BottomP);
                this.status = Constants.BASIC_BLOCK_STATUS_MOVABLE;
                break;
            case L:
                blockList.add(new Block(4, 2, c));
                blockList.add(new Block(5, 2, c));
                blockList.add(new Block(6, 2, c));
                blockList.add(new Block(6, 1, c));

                leftF.add(blockList.get(0).leftP);
                leftF.add(blockList.get(3).leftP);
                rightF.add(blockList.get(2).rightP);
                rightF.add(blockList.get(3).rightP);
                topF.add(blockList.get(0).topP);
                topF.add(blockList.get(1).topP);
                topF.add(blockList.get(3).topP);
                bottomF.add(blockList.get(0).BottomP);
                bottomF.add(blockList.get(1).BottomP);
                bottomF.add(blockList.get(2).BottomP);
                this.status = Constants.BASIC_BLOCK_STATUS_MOVABLE;
                break;
        }
    }

    public static BasicBlock getRandomBlock() {
        return new BasicBlock(BasicBlockType.randomEnum(BasicBlockType.class), getRandomColor());
    }

    public void regenerate() {
        BasicBlock newBlock = getRandomBlock();
        this.blockList.removeAll(blockList);
        this.blockList.addAll(newBlock.blockList);

        this.leftF.removeAll(this.leftF);
        this.leftF.addAll(newBlock.leftF);
        this.rightF.removeAll(this.rightF);
        this.rightF.addAll(newBlock.rightF);
        this.topF.removeAll(this.topF);
        this.topF.addAll(newBlock.topF);
        this.bottomF.removeAll(this.bottomF);
        this.bottomF.addAll(newBlock.bottomF);

        this.color = newBlock.blockList.get(0).getColor();

        this.blockType = newBlock.blockType;

        this.movable = true;
        this.impactMap.put(Constants.BASIC_BLOCK_LEFT, true);
        this.impactMap.put(Constants.BASIC_BLOCK_RIGHT, true);
        this.impactMap.put(Constants.BASIC_BLOCK_BOTTOM, true);

        refeshPosition();

    }

    public void refeshPosition() {
        for (Block block : blockList) {
            block.refreshPoint();
        }
    }

    public void draw(Graphics g) {
        Color color = g.getColor();
        for (Block block : blockList) {
            g.setColor(block.getColor());
            block.draw(g);
        }
        g.setColor(color);
    }

    public void fall() {
        for (Block block : blockList) {
            block.setyNo(block.getyNo() + 1);
        }
        refeshPosition();
    }

    public static Color getRandomColor() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

    public void checkImpact(Map<String, String> map) {
        for (Point point : leftF) {
            if (map.containsKey(point.toString())) {
                this.impactMap.put(Constants.BASIC_BLOCK_LEFT, true);
            } else {
                this.impactMap.put(Constants.BASIC_BLOCK_LEFT, false);
            }
        }
        for (Point point : rightF) {
            if (map.containsKey(point.toString())) {
                this.impactMap.put(Constants.BASIC_BLOCK_RIGHT, true);
            } else {
                this.impactMap.put(Constants.BASIC_BLOCK_RIGHT, false);
            }
        }
        for (Point point : bottomF) {
            if (map.containsKey(point.toString())) {
                this.impactMap.put(Constants.BASIC_BLOCK_BOTTOM, true);
            } else {
                this.impactMap.put(Constants.BASIC_BLOCK_BOTTOM, false);
            }
        }
        for (Point point : topF) {
            if (map.containsKey(point.toString())) {
                this.impactMap.put(Constants.BASIC_BLOCK_TOP, true);
            } else {
                this.impactMap.put(Constants.BASIC_BLOCK_TOP, false);
            }
        }
    }

    public void change() {
    }

    public int move(Map<String, String> map) {
        //碰撞检测
        checkImpact(map);

        //左移
        if (!this.impactMap.get(Constants.BASIC_BLOCK_LEFT) && left) {
            for (Block block : this.blockList) {
                block.setxNo(block.getxNo() - 1);
            }
        }
        //右移
        if (!this.impactMap.get(Constants.BASIC_BLOCK_RIGHT) && right) {
            for (Block block : this.blockList) {
                block.setxNo(block.getxNo() + 1);
            }
        }
        //下移
        if (!this.impactMap.get(Constants.BASIC_BLOCK_BOTTOM) && down) {
            for (Block block : this.blockList) {
                block.setyNo(block.getyNo() + 1);
            }
        }
        //刷新方块碰撞点
        refeshPosition();
        //碰撞检测
        checkImpact(map);
        if (!this.impactMap.get(Constants.BASIC_BLOCK_BOTTOM)) {
            return Constants.AFTER_MOVING_STATUS_CANCONTINUE;
        }
        return Constants.AFTER_MOVING_STATUS_CANCONTINUE;
    }


    class KeysListener extends KeyAdapter {
        BasicBlock basicBlock;

        public KeysListener(BasicBlock basicBlock) {
            this.basicBlock = basicBlock;
        }


        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    basicBlock.left = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    basicBlock.right = true;
                    break;
                case KeyEvent.VK_UP:
                    basicBlock.up = true;
                    break;
                case KeyEvent.VK_DOWN:
                    basicBlock.down = true;
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    basicBlock.left = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    basicBlock.right = false;
                    break;
                case KeyEvent.VK_UP:
                    basicBlock.up = false;
                    break;
                case KeyEvent.VK_DOWN:
                    basicBlock.down = false;
                    break;
                default:
                    break;
            }
        }
    }
}
