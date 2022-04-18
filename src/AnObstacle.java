import javax.swing.*;
import java.awt.*;

public class AnObstacle extends JPanel {
    private ImageIcon carLeft;
    private ImageIcon carRight;
    private ImageIcon truckLeft;
    private ImageIcon truckRight;
    public ImageIcon flower;

    public AnObstacle() {
        this.carLeft = new ImageIcon("Car1-Left.png");
        this.carRight = new ImageIcon("Car1-Right.png");
        this.truckLeft = new ImageIcon("Truck-Left.png");
        this.truckRight = new ImageIcon("Truck-Right.png");
        this.flower = new ImageIcon("lilyPad.png");
    }


    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.carLeft.paintIcon(this, graphics, 0, 0);
        this.carRight.paintIcon(this, graphics, 0, 0);
        this.truckLeft.paintIcon(this, graphics, 0, 0);
        this.truckRight.paintIcon(this, graphics, 0, 0);
        this.flower.paintIcon(this, graphics, 0, 0);

    }
}
