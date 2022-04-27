import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel {
    private int x;
    private int y;
    private int width;
    private int height;
    private ImageIcon gameOver;

    public GameOver(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.gameOver = new ImageIcon("GameOver.png");
        this.setVisible(true);
        repaint();
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.gameOver.paintIcon(this, graphics, Final.X_PIC, Final.Y_PIC);
    }
}



