import javax.swing.*;
import java.awt.*;

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
        this.backGround = new ImageIcon("BackGround.png");
        this.carLeft = new ImageIcon("Car1-Left.png");
        this.carRight = new ImageIcon("Car1-Right.png");
        this.truckLeft = new ImageIcon("Truck-Left.png");
        this.truckRight = new ImageIcon("Truck-Right.png");
        this.rose = new ImageIcon("lilyPad.png");
        this.snake = new ImageIcon("Snake.png");
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
                        frog.setyFrog(Final.WINDOW_HEIGHT - Final.NEW_POSITION_FROG);
                    }

                    if (xTruckLeft >= Final.WINDOW_WIDTH + Final.OBJECT_POSITION) {
                        xTruckLeft -= Final.WINDOW_WIDTH + Final.OBJECT_POSITION;
                    }
                    if (xCarLeft >= Final.WINDOW_WIDTH + Final.OBJECT_POSITION) {
                        xCarLeft -= Final.WINDOW_WIDTH + Final.OBJECT_POSITION;
                    }
                    if (xCarRight <= -Final.OBJECT_POSITION) {
                        xCarRight += Final.WINDOW_WIDTH + Final.OBJECT_POSITION;
                    }
                    if (xTruckRight <= 0) {
                        xTruckRight += Final.WINDOW_WIDTH + Final.OBJECT_POSITION;
                    }
                    xTruckLeft += Final.STEPS;
                    xTruckRight -= Final.STEPS;
                    xCarLeft += Final.STEPS;
                    xCarRight -= Final.STEPS;
                    if (frog.getyFrog() <= 0) {
                        YouWin youWin = new YouWin(Final.X_PIC, Final.Y_PIC, Final.WINDOW_WIDTH, Final.WINDOW_HEIGHT);
                        this.add(youWin);
                    }
                    if (time == 0) {
                        GameOver gameOver = new GameOver(Final.X_PIC, Final.Y_PIC, Final.WINDOW_WIDTH, Final.WINDOW_HEIGHT);
                        this.add(gameOver);
                    }
                    repaint();
                    Thread.sleep(Final.MILLIS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }


    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.backGround.paintIcon(this, graphics, Final.X_PIC, Final.Y_PIC);
        this.carLeft.paintIcon(this, graphics, this.xCarLeft, this.yCarLeft);
        this.carLeft.paintIcon(this, graphics, this.xCarLeft - Final.OBJECT_POSITION_NEW, this.yCarLeft);
        this.carLeft.paintIcon(this, graphics, this.xCarLeft - Final.OBJECT_POSITION, this.yCarLeft);
        this.carRight.paintIcon(this, graphics, this.xCarRight, this.yCarRight);
        this.carRight.paintIcon(this, graphics, this.xCarRight + Final.OBJECT_POSITION_NEW, this.yCarRight);
        this.carRight.paintIcon(this, graphics, this.xCarRight + Final.OBJECT_POSITION, this.yCarRight);
        this.truckLeft.paintIcon(this, graphics, this.xTruckLeft, this.yTruckLeft);
        this.truckLeft.paintIcon(this, graphics, this.xTruckLeft - Final.OBJECT_POSITION_NEW, this.yTruckLeft);
        this.truckLeft.paintIcon(this, graphics, this.xTruckLeft - Final.OBJECT_POSITION, this.yTruckLeft);
        this.truckRight.paintIcon(this, graphics, this.xTruckRight, this.yTruckRight);
        this.truckRight.paintIcon(this, graphics, this.xTruckRight + Final.OBJECT_POSITION_NEW, this.yTruckRight);
        this.truckRight.paintIcon(this, graphics, this.xTruckRight + Final.OBJECT_POSITION, this.yTruckRight);
        this.rose.paintIcon(this, graphics, this.xRose, this.yRose);
        this.rose.paintIcon(this, graphics, this.xRose + Final.ROSE1, this.yRose);
        this.rose.paintIcon(this, graphics, this.xRose + Final.ROSE2, this.yRose);
        this.rose.paintIcon(this, graphics, this.xRose + Final.ROSE3, this.yRose);
        this.snake.paintIcon(this, graphics, this.xSnake + Final.SNAKE1, this.ySnake);
        this.snake.paintIcon(this, graphics, this.xSnake + Final.SNAKE2, this.ySnake);
        this.snake.paintIcon(this, graphics, this.xSnake + Final.SNAKE3, this.ySnake);
        this.frog.paintComponent(graphics);
        time--;
        String timer = String.valueOf(time);
        String timeSec = "Frog time left :";
        getGraphics().drawString(timeSec + timer, Final.X_TIME, Final.Y_TIME);
    }

    public boolean collision(Frog frog) {
        boolean alive = true;
        if (frog.getyFrog() <= Final.START_ROAD1 && frog.getyFrog() >= Final.END_ROAD1) { // ROAD 1
            if (frog.getxFrog() == xTruckLeft
                    || frog.getxFrog() == xTruckLeft - Final.OBJECT_POSITION_NEW
                    || frog.getxFrog() == xTruckLeft - Final.OBJECT_POSITION) {
                alive = false;
            }
        }
        if (frog.getyFrog() <= Final.START_ROAD2 && frog.getyFrog() >= Final.END_ROAD2) { // ROAD 2
            if (frog.getxFrog() == xTruckRight
                    || frog.getxFrog() == xTruckRight + Final.OBJECT_POSITION_NEW
                    || frog.getxFrog() == xTruckRight + Final.OBJECT_POSITION) {
                alive = false;
            }
        }
        if (frog.getyFrog() <= Final.START_RIVER && frog.getyFrog() >= Final.END_RIVER) { //RIVER
            if (frog.getyFrog() <= Final.START_ROSE && frog.getyFrog() >= Final.END_ROSE) { // ROSE
                System.out.println("rose x:" + xRose + " frog x:" + frog.getxFrog());
                if ((frog.getxFrog() >= xRose - Final.START_AND_END_ROSE1 && frog.getxFrog() <= xRose + Final.START_AND_END_ROSE1)
                        ||
                        (frog.getxFrog() >= xRose + Final.START_ROSE2 && frog.getxFrog() <= xRose + Final.END_ROSE2)
                        ||
                        (frog.getxFrog() >= xRose + Final.START_ROSE3 && frog.getxFrog() <= xRose + Final.END_ROSE3)
                        ||
                        (frog.getxFrog() >= xRose + Final.START_ROSE4 && frog.getxFrog() <= xRose + Final.END_ROSE4)) {
                    alive = true;
                } else {
                    alive = false;
                }
            } else {
                alive = false;
            }
        }
        if (frog.getyFrog() <= Final.START_ROAD3 && frog.getyFrog() >= Final.END_ROAD3) { // ROAD 3
            if (frog.getxFrog() == xCarLeft
                    || frog.getxFrog() == xCarLeft - Final.OBJECT_POSITION_NEW
                    || frog.getxFrog() == xCarLeft - Final.OBJECT_POSITION) {
                alive = false;
            }
        }
        if (frog.getyFrog() <= Final.START_ROAD4 && frog.getyFrog() >= Final.END_ROAD4) { // ROAD 4
            if (frog.getxFrog() == xCarRight
                    || frog.getxFrog() == xCarRight + Final.OBJECT_POSITION_NEW
                    || frog.getxFrog() == xCarRight + Final.OBJECT_POSITION) {
                alive = false;
            }
        }
        return alive;
    }
}