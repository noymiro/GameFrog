import javax.swing.*;
import java.awt.*;

public class OpenScene extends JPanel {
    private int x;
    private int y;
    private int width;
    private int height;
    private ImageIcon openPic;

    public OpenScene(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.openPic = new ImageIcon("greenFrog.png");

    }

    protected void paintComponent(Graphics graphics) {
        GameScene gameScene = new GameScene(0, 0, Final.WINDOW_WIDTH, Final.WINDOW_HEIGHT);
        InformationScene informationScene = new InformationScene(0, 0, Final.WINDOW_WIDTH, Final.WINDOW_HEIGHT);
        super.paintComponent(graphics);
        //graphics.setColor(Color.BLUE);
        this.openPic.paintIcon(this, graphics, 0, 0);
        JButton button = new JButton("Start Game");
        button.setBounds(0, 200, 200, 50);
        this.add(button);
        button.setOpaque(true);
        button.setBackground(Color.green);
        JButton button2 = new JButton("Information");
        button2.setBounds(0, 250, 200, 50);
        this.add(button2);
        button2.setOpaque(true);
        button2.setBackground(Color.ORANGE);
        button.addActionListener((event) -> {
            this.remove(button);
            this.remove(button2);
            this.add(gameScene);

        });
        button2.addActionListener((event) -> {
            this.add(informationScene);
            repaint();
            this.remove(button2);

        });


    }


}

