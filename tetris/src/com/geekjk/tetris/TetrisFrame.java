package com.geekjk.tetris;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

/**
 * @author JackeyLee
 * @description:
 * @date 2020/12/13 16:05
 */
public class TetrisFrame extends Frame {
    //1-初始化中，2-正常循环，3-可得分待消除，4-可得分已消除，5-失败游戏结束
    public final static int GAME_FRAME_STATUS_LAUCHING = 1;
    public final static int GAME_FRAME_STATUS_LOOPING = 2;
    public final static int GAME_FRAME_STATUS_NEEDSCORE = 3;
    public final static int GAME_FRAME_STATUS_SCORED = 4;
    public final static int GAME_FRAME_STATUS_GAMEOVER = 5;

    public static int autoFallSpeed = 100;


    public static int ABX = 3;
    public static int ABY = 26;
    public static int BLOCK_SIZE = 30;

    public static int MAIN_FRAME_STARTX = 750;
    public static int MAIN_FRAME_STARTY = 100;
    public static int MAIN_FRAME_WIDTH = 500;
    public static int MAIN_FRAME_HEIGHT = 800;
    public static int GAME_FRAME_STARTX = 45;
    public static int GAME_FRAME_STARTY = 60;
    public static int GAME_FRAME_WIDTH = 300;
    public static int GAME_FRAME_HEIGHT = 600;
    public static int gameStatus = GAME_FRAME_STATUS_LAUCHING;

    public BasicBlock movingBlocks = BasicBlock.getRandomBlock();


    public List<Block> fixedBlocks = new ArrayList<>();
    Map<String, String> fixdPoint = new HashMap<>();

    private Image offScreenImage = null;

    PaintThread paintThread;
    PaintMovingBlock paintMovingBlock;

    public void loadGame() {
        this.setTitle("Tetirs");
        this.setBounds(MAIN_FRAME_STARTX, MAIN_FRAME_STARTY, MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT);
        this.launch();
    }

    public void launch() {
        this.addKeyListener(movingBlocks.keysListener);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setResizable(false);
        addBorder2FixdMap();
        this.setVisible(true);

        paintThread = new PaintThread();
        paintThread.start();
//        paintMovingBlock = new PaintMovingBlock();
//        paintMovingBlock.start();
    }

    @Override
    public void paint(Graphics g) {
//        System.out.println("paint run " + new Date());
//        Graphics2D g2d = (Graphics2D) e;
//        g2d.setStroke(new BasicStroke(1f));
//        e.create(820, 220, 100, 100);
        //画游戏框架
        Color color = g.getColor();
        g.setColor(Color.BLACK);
        g.drawRect(MAIN_FRAME_STARTX, MAIN_FRAME_STARTY, GAME_FRAME_WIDTH, GAME_FRAME_HEIGHT);
        g.drawRect(GAME_FRAME_STARTX, GAME_FRAME_STARTY, 300, 600);
        //画网格
//        g2d.setStroke(new BasicStroke(1f));
        for (int i = 1; i < 10; i++) {
            g.drawLine(GAME_FRAME_STARTX + i * BLOCK_SIZE, GAME_FRAME_STARTY, GAME_FRAME_STARTX + i * BLOCK_SIZE, GAME_FRAME_STARTY + GAME_FRAME_HEIGHT);
        }
        for (int i = 1; i < 20; i++) {
            g.drawLine(GAME_FRAME_STARTX, GAME_FRAME_STARTY + BLOCK_SIZE * i, GAME_FRAME_STARTX + GAME_FRAME_WIDTH, GAME_FRAME_STARTY + BLOCK_SIZE * i);
        }

        //画方块
        movingBlocks.draw(g);
        //画固定方块
        for (Block fixedBlock : fixedBlocks) {
            fixedBlock.draw(g);
        }


    }

    public void addBorder2FixdMap() {
        for (int i = 1; i <= 10; i++) {
            this.fixdPoint.put(new Point(i - 0.5, 0.0).toString(), Constants.GAME_FRAME_BORDER);
            this.fixdPoint.put(new Point(i - 0.5, 20.0).toString(), Constants.GAME_FRAME_BORDER);
        }
        for (int i = 1; i <= 20; i++) {
            this.fixdPoint.put(new Point(0.0, i - 0.5).toString(), Constants.GAME_FRAME_BORDER);
            this.fixdPoint.put(new Point(10.0, i - 0.5).toString(), Constants.GAME_FRAME_BORDER);
        }
    }

    public void score() {
        //TODO 判断是否可得分
        if (1 == 2) {
            gameStatus = GAME_FRAME_STATUS_SCORED;
            //TODO 执行得分逻辑
        }
//        if (this.fixedBlocks.size() > 0) {
//            //TODO 检测是否碰撞存量方块
//        }
//
//        for (Block b : this.movingBlocks.blockList) {
//            if (b.luCo.getX() == 45 || b.ruCo.getX() == 45 + 10 * 30 || b.ldCo.getY() == 60 + 20 * 30) {
//                return false;
//            }
//        }
//        return true;
    }

//    @Override
//    public void update(Graphics g) {
////        System.out.println("update run " + new Date());
//        if(offScreenImage == null) {
//            offScreenImage = this.createImage(MAIN_FRAME_WIDTH,MAIN_FRAME_HEIGHT);
//            //这是游戏窗口的宽度和高度
//        }
//        Graphics gOff = offScreenImage.getGraphics();
//        paint(gOff);
//        g.drawImage(offScreenImage, 0, 0, null);
//
////        super.update(g);
//    }


    class PaintThread extends Thread {
        @Override
        public void run() {
            int i = 1;
            while (true) {
                try {
                    Thread.sleep(autoFallSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                fixedBlocks.add(new Block(1, 20, Color.RED));
//                fixedBlocks.add(new Block(2, 20, Color.RED));
//                fixedBlocks.add(new Block(3, 20, Color.RED));

                if (movingBlocks.status == Constants.BASIC_BLOCK_STATUS_NEW) {
                    movingBlocks.status = Constants.BASIC_BLOCK_STATUS_MOVABLE;
                }
//                movingBlocks.status = Constants.BASIC_BLOCK_STATUS_MOVABLE;
                //如果移动方块状态为已固定，则生成新方块，并判断是否与固定方块碰撞，如碰撞，则游戏结束。
                if (movingBlocks.status == Constants.BASIC_BLOCK_STATUS_FIXED) {
                    System.out.println("生成新方块~~~~~~~~~~~~~~~~~~~~~~~");
                    movingBlocks.regenerate();
                    movingBlocks.status = Constants.BASIC_BLOCK_STATUS_NEW;
                    if (1 == 2) { //TODO 游戏失败逻辑
                        System.out.println("======================================GAME OVER======================");
                    }
                }
                repaint();
                /*
                1、先判断是否已生成移动方块，如果已生成，那么执行下落。
                2、判断执行下落后方块碰撞情况
                    2.1 触底
                       2.1.1 不得分，将移动方块变为固定方块，修改移动方块flag，生成新的移动方块。
                       2.1.2 得分，进入得分逻辑，生成新的移动方块
                    2.2 未触底，无操作。
                 */

                if (movingBlocks.status == Constants.BASIC_BLOCK_STATUS_MOVABLE) {
//                    System.out.println("第"+i+"次下落前"+" 坐标为==="+movingBlocks.bottomF);
                    movingBlocks.fall();
//                    System.out.println("第"+i+"次下落后"+" 坐标为==="+movingBlocks.bottomF);
//                    i++;
                }

                System.out.println(movingBlocks.bottomF);
                Set<Map.Entry<String, String>> set = fixdPoint.entrySet();
                Iterator<Map.Entry<String, String>> iterator = set.iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, String> next = iterator.next();
                    if (next.getValue().equals(Constants.GAME_FRAME_FIXED_BLOCK)) {
                        System.out.println(next.getKey() + "==============" + next.getValue());
                    }
                }
                if (movingBlocks.bottomF.get(0).getY()>=17) {
                    System.out.println("!!!!!!!!");
                }
//                System.out.println(fixdPoint);
                movingBlocks.checkImpact(fixdPoint);
                if (movingBlocks.impactMap.get(Constants.BASIC_BLOCK_BOTTOM)) {
                    System.out.println("移动方块触底啦！！！！！！！！！！");
                    //得分逻辑
//                    score();
                    if (gameStatus != GAME_FRAME_STATUS_SCORED) {
                        fixedBlocks.addAll(movingBlocks.blockList);
                        for (Block fixedBlock : fixedBlocks) {
                            fixedBlock.refreshPoint();
                            fixdPoint.putIfAbsent(fixedBlock.topP.toString(), Constants.GAME_FRAME_FIXED_BLOCK);
                            fixdPoint.putIfAbsent(fixedBlock.BottomP.toString(), Constants.GAME_FRAME_FIXED_BLOCK);
                            fixdPoint.putIfAbsent(fixedBlock.leftP.toString(), Constants.GAME_FRAME_FIXED_BLOCK);
                            fixdPoint.putIfAbsent(fixedBlock.rightP.toString(), Constants.GAME_FRAME_FIXED_BLOCK);
                        }
                        movingBlocks.status = Constants.BASIC_BLOCK_STATUS_FIXED;
                    }
//                    movingBlocks.status = Constants.BASIC_BLOCK_STATUS_FIXED;
                }
//                movingBlocks = BasicBlock.getRandomBlock();
            }
        }
    }

    class PaintMovingBlock extends Thread {
        @Override
        public void run() {
//            System.out.println("PaintMovingBlock线程运行啦~~~~~~~~~~~~~~~~~~~");
            while (true) {
                if (movingBlocks.status == Constants.BASIC_BLOCK_STATUS_MOVABLE) {
                    if (null != movingBlocks) {
                        movingBlocks.move(fixdPoint);
                        repaint();
                    }
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }


}
