import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameScene extends JPanel  {
    private ArrayList<Definitions> obstacles;
    private Frog frog;
    private ImageIcon carLeft;
    private ImageIcon carRight;
    private ImageIcon truckLeft;
    private ImageIcon truckRight;
    private ImageIcon rose;
    private ImageIcon frogger;
    private ImageIcon backGround;

    private int xFrogger;
    private int yFrogger;
    private int yTruckLeft;
    private int xTruckLeft;
    //    private int yTruckLeft1;
//    private int xTruckLeft1;
    private int yTruckRight;
    private int xTruckRight;
    private int xCarLeft;
    private int yCarLeft;
    //    private int xCarLeft2;
//    private int yCarLeft2;
    private int xCarRight;
    private int yCarRight;
    private int xRose;
    private int yRose;

    public GameScene(int x, int y, int width, int height) {
        this.setBackground(Color.GREEN);
        this.setBounds(x, y, width, height);
        this.frog = new Frog();
        this.obstacles = new ArrayList<>();
        this.backGround = new ImageIcon("backGround.png");
        this.carLeft = new ImageIcon("Car1-Left.png");
        this.carRight = new ImageIcon("Car1-Right.png");
        this.truckLeft = new ImageIcon("Truck-Left.png");
        this.truckRight = new ImageIcon("Truck-Right.png");
        this.rose = new ImageIcon("lilyPad.png");
        this.frogger = new ImageIcon("FrogUp.png");
        this.yFrogger = Final.WINDOW_HEIGHT - 75;
        this.xFrogger = Final.WINDOW_WIDTH / 2;
        this.yTruckLeft = 500;
        this.yTruckRight = 440;
        this.yCarLeft = 320;
        this.yCarRight = 260;
        this.yRose = 110;
        this.xCarRight = Final.WINDOW_WIDTH;
        this.xTruckRight = Final.WINDOW_WIDTH;
        this.mainGameLoop();

    }

    private void mainGameLoop() {
        new Thread(() -> {
            this.setFocusable(true);
            this.requestFocus();
            this.addKeyListener(this.frog);
            while (true) {
                try {
//                    dead();
                    if (xTruckLeft >= Final.WINDOW_WIDTH + 300 || xCarLeft >= Final.WINDOW_WIDTH + 300) {
                        xTruckLeft -= Final.WINDOW_WIDTH + 300;
                        xCarLeft -= Final.WINDOW_WIDTH + 300;
                    }
                    xTruckLeft += 2;
                    xCarLeft += 2;
                    xCarRight--;
                    xTruckRight -= 2;
                    xRose++;
                    if (xRose >= Final.WINDOW_WIDTH) {
                        xRose = 0;
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
        this.carLeft.paintIcon(this, graphics, this.xCarLeft - 300, this.yCarLeft);
        this.carRight.paintIcon(this, graphics, this.xCarRight, this.yCarRight);
        this.truckLeft.paintIcon(this, graphics, this.xTruckLeft, this.yTruckLeft);
        this.truckLeft.paintIcon(this, graphics, this.xTruckLeft - 150, this.yTruckLeft);
        this.truckLeft.paintIcon(this, graphics, this.xTruckLeft - 300, this.yTruckLeft);
        this.truckRight.paintIcon(this, graphics, this.xTruckRight, this.yTruckRight);
        this.truckRight.paintIcon(this, graphics, this.xTruckRight + 150, this.yTruckRight);
        this.truckRight.paintIcon(this, graphics, this.xTruckRight + 300, this.yTruckRight);
        this.rose.paintIcon(this, graphics, this.xRose + 50, this.yRose);
        this.rose.paintIcon(this, graphics, this.xRose + 225, this.yRose);
        this.rose.paintIcon(this, graphics, this.xRose + 375, this.yRose);
        this.rose.paintIcon(this, graphics, this.xRose + 525, this.yRose);
        this.frog.paintComponent(graphics);
//        this.frogger.paintIcon(this, graphics, this.xFrogger  , this.yFrogger);
        //חייב למצוא פתרון יותר יפה לזה
    }




}