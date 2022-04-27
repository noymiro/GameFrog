import javax.swing.*;
import java.awt.*;

public class InformationScene extends JPanel {
    private int x;
    private int y;
    private int width;
    private int height;
    private ImageIcon Information;

    public InformationScene(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.Information = new ImageIcon("Information.png");
        this.setBackground(Color.GREEN);
        this.setVisible(true);
        repaint();
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.Information.paintIcon(this, graphics, Final.X_PIC, Final.Y_PIC);

    }

}
