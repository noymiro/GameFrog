import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameScene extends JPanel {
    private Frog frog;
    private ArrayList<Definitions> obstacles;
    private ImageIcon carLeft;
    private ImageIcon carRight;
    private ImageIcon truckLeft;
    private ImageIcon truckRight;
    private ImageIcon flower;
    private ImageIcon frogger;
    private ImageIcon backGround ;

    private int xFrog;
    private int yFrog;
    private int xTruck;
    private int yTruck;
    private int xCar;
    private int yCar;
    private int xRose ;
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
        this.flower = new ImageIcon("lilyPad.png");
        this.frogger = new ImageIcon("FrogUp.png");
        this.mainGameLoop();
        this.yFrog = 500; //starting y
        this.yTruck = 500 ;



    }

    private void mainGameLoop () {
        new Thread(() -> {
            while (true) {
                try {
                    xTruck++;
                    repaint();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }




    public Frog getFrog() {
        return frog;
    }


    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.backGround.paintIcon(this, graphics , 0 , 0);
        this.carLeft.paintIcon(this, graphics, 0, 0);
        this.carRight.paintIcon(this, graphics, 40, 0);
        this.truckLeft.paintIcon(this, graphics, this.xTruck, this.yTruck);
        this.truckRight.paintIcon(this, graphics, 160, 0);
        this.flower.paintIcon(this, graphics, 220, 0);
        this.frogger.paintIcon(this, graphics, this.xFrog, this.yFrog);



    }

}
