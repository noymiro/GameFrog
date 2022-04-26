import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class GameScene extends JPanel {
    private ArrayList<Definitions> obstacles;
    private Frog frog;
    //    private Timer timer;
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
    private int time ;

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
        this.snake = new ImageIcon("snake.png");
        this.ySnake = 110 ;
        this.yTruckLeft = 500;
        this.yTruckRight = 440;
        this.yCarLeft = 320;
        this.yCarRight = 260;
        this.yRose = 110;
        this.xCarRight = Final.WINDOW_WIDTH;
        this.xTruckRight = Final.WINDOW_WIDTH;
//        this.timer = new Timer();


    }

    public void mainGameLoop() {

        new Thread(() -> {
            this.setFocusable(true);
            this.requestFocus();
            this.addKeyListener(this.frog);
            System.out.println("mainGameLoop: start");
//            countDown();
            while (true) {
                try {

                    if (!collision(frog)) {
                        frog.setyFrog(Final.WINDOW_HEIGHT - 75);
                    }

                    if (xTruckLeft >= Final.WINDOW_WIDTH + 300) {
                        xTruckLeft -= Final.WINDOW_WIDTH + 300;
                    }
                    if (xCarLeft >= Final.WINDOW_WIDTH + 300) {
                        xCarLeft -= Final.WINDOW_WIDTH + 300;
                    }
                    if (xCarRight <= -300) {
                        xCarRight += Final.WINDOW_WIDTH + 300;//275-243
                    }
                    if (xTruckRight <= 0) {
                        xTruckRight += Final.WINDOW_WIDTH +300;
                    }

                    xTruckLeft += 2;
                    xCarLeft += 2;
                    xCarRight -= 2;
                    xTruckRight -= 2;
                    // xRose++;
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

        if(frog.getyFrog() <= 0){
            JLabel jLabel = new JLabel();
            jLabel.setBounds(Final.WINDOW_WIDTH/2,Final.WINDOW_HEIGHT/2,250,160);
            jLabel.setText("END GAME");
            this.add(jLabel);
            frog.setyFrog(Final.WINDOW_HEIGHT - 75);

        }
    }


    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.backGround.paintIcon(this, graphics, 0, 0);
        this.carLeft.paintIcon(this, graphics, this.xCarLeft, this.yCarLeft);
        this.carLeft.paintIcon(this, graphics, this.xCarLeft - 150, this.yCarLeft);
        this.carLeft.paintIcon(this, graphics, this.xCarLeft - 300, this.yCarLeft);
        this.carRight.paintIcon(this, graphics, this.xCarRight, this.yCarRight);
        this.carRight.paintIcon(this, graphics, this.xCarRight + 150, this.yCarRight);
        this.carRight.paintIcon(this, graphics, this.xCarRight + 300, this.yCarRight);
        this.truckLeft.paintIcon(this, graphics, this.xTruckLeft, this.yTruckLeft);
        this.truckLeft.paintIcon(this, graphics, this.xTruckLeft - 150, this.yTruckLeft);
        this.truckLeft.paintIcon(this, graphics, this.xTruckLeft - 300, this.yTruckLeft);
        this.truckRight.paintIcon(this, graphics, this.xTruckRight, this.yTruckRight);
        this.truckRight.paintIcon(this, graphics, this.xTruckRight + 150, this.yTruckRight);
        this.truckRight.paintIcon(this, graphics, this.xTruckRight + 300, this.yTruckRight);
       this.rose.paintIcon(this, graphics, this.xRose, this.yRose);
        this.rose.paintIcon(this, graphics, this.xRose  + 220, this.yRose);
        this.rose.paintIcon(this, graphics, this.xRose + 520, this.yRose);
        this.rose.paintIcon(this, graphics, this.xRose + 750, this.yRose);
        this.snake.paintIcon(this, graphics , this.xSnake  + 630, this.ySnake);
        this.snake.paintIcon(this, graphics , this.xSnake  + 350, this.ySnake);
        this.snake.paintIcon(this, graphics , this.xSnake  + 100, this.ySnake);


        //this.rose.paintIcon(this, graphics, this.xRose + 525, this.yRose);
        this.frog.paintComponent(graphics);
      //  graphics.drawString("60".trim(), 15, 15);
        time--;
        String timer = String.valueOf(time);
        String timeSec = "Time of the game :";
        getGraphics().drawString( timeSec+timer,15,15);


    }

    public boolean collision(Frog frog) {
        boolean alive = true;
        if (frog.getyFrog() <= 517 && frog.getyFrog() >= 477) {
            if (frog.getxFrog() == xTruckLeft
                    || frog.getxFrog() == xTruckLeft - 150
                    || frog.getxFrog() == xTruckLeft - 300) {
                alive = false;
            }
        }
        if (frog.getyFrog() <= 465 && frog.getyFrog() >= 425) {
            if (frog.getxFrog() == xTruckRight
                    || frog.getxFrog() == xTruckRight + 150
                    || frog.getxFrog() == xTruckRight + 300) {
                alive = false;
            }
        }
        if (frog.getyFrog() <= 182 && frog.getyFrog() >= 35) {
            if (frog.getyFrog() <= 113 && frog.getyFrog() >= 103) {
                System.out.println("rose x:" + xRose + " frog x:" + frog.getxFrog());
                if (frog.getxFrog() >= xRose - 8 && frog.getxFrog() <= xRose + 12)//צריך למצוא פתרון לכל הפרחים תופס רק על הראשון
                {
                    alive = true;
                } else {
                    alive = false;
                }
            }
        }
        if (frog.getyFrog() <= 351 && frog.getyFrog() >= 291) {
            if (frog.getxFrog() == xCarLeft
                    || frog.getxFrog() == xCarLeft - 150
                    || frog.getxFrog() == xCarLeft - 300) {
                alive = false;
            }
        }
        if (frog.getyFrog() <= 283 && frog.getyFrog() >= 241) {
            if (frog.getxFrog() == xCarRight
                   || frog.getxFrog() == xCarRight + 150
                        || frog.getxFrog() == xCarRight + 300) {
                alive = false;
            }
        }
        return alive;
    }
}
//    }
//    public void countDown(){
//        System.out.println("countDown start");
//        JLabel jLabel = new JLabel();
//        jLabel.setBounds(0, 0, Final.WINDOW_WIDTH/8, Final.WINDOW_HEIGHT/11);
//        setBackground(Color.black);
//        jLabel.setVisible(true);
//
//        TimerTask task = new TimerTask(){
//            private int i = 4;
//            public void run(){
//                if (i >= 0) {
//                    jLabel.setText("time left:" + i--);
//                }
//            }
//        };
//        this.add(jLabel);
//        //timer.scheduleAtFixedRate(task, 0, 1000);
//    }





