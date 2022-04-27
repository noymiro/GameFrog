import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class GameScene extends JPanel {

    private Frog frog;
    private ImageIcon carLeft;
    private ImageIcon carRight;
    private ImageIcon truckLeft;
    private ImageIcon truckRight;
    private ImageIcon rose;
    private ImageIcon backGround;
    private ImageIcon snake;

    private int yTruckLeft;
    private int xTruckLeft;
    private int yTruckRight;
    private int xTruckRight;
    private int xCarLeft;
    private int yCarLeft;
    private int xCarRight;
    private int yCarRight;
    private int xRose;
    private int yRose;
    private int xSnake;
    private int ySnake;
    private int time;

    public GameScene(int x, int y, int width, int height) {
        this.setBackground(Color.GREEN);
        this.setBounds(x, y, width, height);
        this.frog = new Frog();
        this.backGround = new ImageIcon("backGround.png");
        this.carLeft = new ImageIcon("Car1-Left.png");
        this.carRight = new ImageIcon("Car1-Right.png");
        this.truckLeft = new ImageIcon("Truck-Left.png");
        this.truckRight = new ImageIcon("Truck-Right.png");
        this.rose = new ImageIcon("lilyPad.png");
        this.snake = new ImageIcon("snake.png");
        this.ySnake = Final.Y_SNAKE;
        this.yTruckLeft = Final.Y_TRUCK_LEFT;
        this.yTruckRight = Final.Y_TRUCK_RIGHT;
        this.yCarLeft = Final.Y_CAR_LEFT;
        this.yCarRight = Final.Y_CAR_RIGHT;
        this.yRose = Final.Y_ROSE;
        this.xCarRight = Final.WINDOW_WIDTH;
        this.xTruckRight = Final.WINDOW_WIDTH;
        this.time = Final.TIMER;


    }

    public void mainGameLoop() {

        new Thread(() -> {
            this.setFocusable(true);
            this.requestFocus();
            this.addKeyListener(this.frog);
            System.out.println("mainGameLoop: start");
            while (true) {
                try {

                    if (!collision(frog)) {
                        frog.setyFrog(Final.WINDOW_HEIGHT - 75);
                    }

                    if (xTruckLeft >= Final.WINDOW_WIDTH + Final.OBJECT_POSITION) {
                        xTruckLeft -= Final.WINDOW_WIDTH + Final.OBJECT_POSITION;
                    }
                    if (xCarLeft >= Final.WINDOW_WIDTH + Final.OBJECT_POSITION) {
                        xCarLeft -= Final.WINDOW_WIDTH + Final.OBJECT_POSITION;
                    }
                    if (xCarRight <= -300) {
                        xCarRight += Final.WINDOW_WIDTH + Final.OBJECT_POSITION;//275-243
                    }
                    if (xTruckRight <= 0) {
                        xTruckRight += Final.WINDOW_WIDTH + Final.OBJECT_POSITION;
                    }
                    xTruckLeft += 2;
                    xTruckRight -= 2;
                    xCarLeft += 2;
                    xCarRight -= 2;
                    if(frog.getyFrog() <= 0 ) {
                     //   frog.setyFrog(Final.WINDOW_HEIGHT);
                        YouWin youWin = new YouWin(0, 0, Final.WINDOW_WIDTH, Final.WINDOW_HEIGHT);
                        this.add(youWin);
                    }
                        if (time == 0 ) {
                            GameOver gameOver = new GameOver(0 , 0 , Final.WINDOW_WIDTH , Final.WINDOW_HEIGHT);
                            this.add(gameOver);
                    }
                    repaint();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        }



    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.backGround.paintIcon(this, graphics, 0, 0);
        this.carLeft.paintIcon(this, graphics, this.xCarLeft, this.yCarLeft);
        this.carLeft.paintIcon(this, graphics, this.xCarLeft - 150, this.yCarLeft);
        this.carLeft.paintIcon(this, graphics, this.xCarLeft - Final.OBJECT_POSITION, this.yCarLeft);
        this.carRight.paintIcon(this, graphics, this.xCarRight, this.yCarRight);
        this.carRight.paintIcon(this, graphics, this.xCarRight + 150, this.yCarRight);
        this.carRight.paintIcon(this, graphics, this.xCarRight + Final.OBJECT_POSITION, this.yCarRight);
        this.truckLeft.paintIcon(this, graphics, this.xTruckLeft, this.yTruckLeft);
        this.truckLeft.paintIcon(this, graphics, this.xTruckLeft - 150, this.yTruckLeft);
        this.truckLeft.paintIcon(this, graphics, this.xTruckLeft - Final.OBJECT_POSITION, this.yTruckLeft);
        this.truckRight.paintIcon(this, graphics, this.xTruckRight, this.yTruckRight);
        this.truckRight.paintIcon(this, graphics, this.xTruckRight + 150, this.yTruckRight);
        this.truckRight.paintIcon(this, graphics, this.xTruckRight + Final.OBJECT_POSITION, this.yTruckRight);
        this.rose.paintIcon(this, graphics, this.xRose, this.yRose);
        this.rose.paintIcon(this, graphics, this.xRose + 220, this.yRose);
        this.rose.paintIcon(this, graphics, this.xRose + 520, this.yRose);
        this.rose.paintIcon(this, graphics, this.xRose + 750, this.yRose);
        this.snake.paintIcon(this, graphics, this.xSnake + 630, this.ySnake);
        this.snake.paintIcon(this, graphics, this.xSnake + 350, this.ySnake);
        this.snake.paintIcon(this, graphics, this.xSnake + 100, this.ySnake);
        this.frog.paintComponent(graphics);
        time--;
        String timer = String.valueOf(time);
        String timeSec = "Frog time left :";
        getGraphics().drawString(timeSec + timer, 15, 15);


    }

    public boolean collision(Frog frog) {
        boolean alive = true;
        if (frog.getyFrog() <= 517 && frog.getyFrog() >= 477) {
            if (frog.getxFrog() == xTruckLeft
                    || frog.getxFrog() == xTruckLeft - 150
                    || frog.getxFrog() == xTruckLeft - Final.OBJECT_POSITION) {
                alive = false;
            }
        }
        if (frog.getyFrog() <= 465 && frog.getyFrog() >= 425) {
            if (frog.getxFrog() == xTruckRight
                    || frog.getxFrog() == xTruckRight + 150
                    || frog.getxFrog() == xTruckRight + Final.OBJECT_POSITION) {
                alive = false;
            }
        }
        if (frog.getyFrog() <= 182 && frog.getyFrog() >= 35) {
            if (frog.getyFrog() <= 113 && frog.getyFrog() >= 103) {
                System.out.println("rose x:" + xRose + " frog x:" + frog.getxFrog());
                if ((frog.getxFrog() >= xRose - 5 && frog.getxFrog() <= xRose + 5)
                        ||
                        (frog.getxFrog() >= xRose + 215 && frog.getxFrog() <= xRose + 225)
                        ||
                        (frog.getxFrog() >= xRose + 515 && frog.getxFrog() <= xRose + 525)
                        ||
                        (frog.getxFrog() >= xRose + 745 && frog.getxFrog() <= xRose + 755)) {
                    alive = true;
                } else {
                    alive = false;
                }
            }else {
                alive = false;
            }
        }
        if (frog.getyFrog() <= 351 && frog.getyFrog() >= 291) {
            if (frog.getxFrog() == xCarLeft
                    || frog.getxFrog() == xCarLeft - 150
                    || frog.getxFrog() == xCarLeft - Final.OBJECT_POSITION) {
                alive = false;
            }
        }
        if (frog.getyFrog() <= 283 && frog.getyFrog() >= 241) {
            if (frog.getxFrog() == xCarRight
                    || frog.getxFrog() == xCarRight + 150
                    || frog.getxFrog() == xCarRight + Final.OBJECT_POSITION) {
                alive = false;
            }
        }
        return alive;
    }
}