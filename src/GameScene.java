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

    private int x;


    public GameScene(int x, int y, int width, int height) {
        this.setBackground(Color.GREEN);
        this.setBounds(x, y, width, height);
        this.frog = new Frog();
        this.obstacles = new ArrayList<>();
        this.carLeft = new ImageIcon("Car1-Left.png");
        this.carRight = new ImageIcon("Car1-Right.png");
        this.truckLeft = new ImageIcon("Truck-Left.png");
        this.truckRight = new ImageIcon("Truck-Right.png");
        this.flower = new ImageIcon("lilyPad.png");
        this.frogger = new ImageIcon("FrogUp.png");
        this.mainGameLoop();
        //this.mainGameLop ;
    }

    private void mainGameLoop () {
        new Thread(() -> {
            while (true) {
                try {
                    x++;
                    repaint();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // לחזור לעשות את המודה של גיים לופ


    public Frog getFrog() {
        return frog;
    }


    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        this.carLeft.paintIcon(this, graphics, 0, 0);
        this.carRight.paintIcon(this, graphics, 40, 0);
        this.truckLeft.paintIcon(this, graphics, 80, 0);
        this.truckRight.paintIcon(this, graphics, 160, 0);
        this.flower.paintIcon(this, graphics, 220, 0);
        this.frogger.paintIcon(this, graphics, x, 500);


    }

}
