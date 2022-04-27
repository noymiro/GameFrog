import javax.swing.*;
import java.awt.*;

public class YouWin extends JPanel {
    private int x;
    private int y;
    private int width;
    private int height;
    private ImageIcon youWin;
    private GameScene gameScene;

    public YouWin(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.youWin = new ImageIcon("YouWin.png");
        this.setVisible(true);
        repaint();
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.youWin.paintIcon(this, graphics, Final.X_PIC, Final.Y_PIC);
    }
}



