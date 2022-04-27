import javax.swing.*;
import java.awt.*;

public class OpenScene extends JPanel {
    private int x;
    private int y;
    private int width;
    private int height;
    private ImageIcon openPic;
    private GameScene gameScene;

    public OpenScene(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.openPic = new ImageIcon("GreenFrog.png");
        this.gameScene = new GameScene(x, y, width, height);


    }

    protected void paintComponent(Graphics graphics) {
        InformationScene informationScene = new InformationScene(Final.X_PIC, Final.Y_PIC, Final.WINDOW_WIDTH, Final.WINDOW_HEIGHT);
        super.paintComponent(graphics);
        this.openPic.paintIcon(this, graphics, Final.X_PIC, Final.Y_PIC);
        JButton button = new JButton("Start Game");
        button.setBounds(Final.X_BUTTON, Final.Y_BUTTON1, Final.BUTTON_WIDTH, Final.BUTTON_HEIGHT);
        this.add(button);
        button.setOpaque(true);
        button.setBackground(Color.green);
        JButton button2 = new JButton("Information");
        button2.setBounds(Final.X_BUTTON, Final.Y_BUTTON2, Final.BUTTON_WIDTH, Final.BUTTON_HEIGHT);
        this.add(button2);
        button2.setOpaque(true);
        button2.setBackground(Color.ORANGE);
        button.addActionListener((event) -> {
            this.remove(button);
            this.remove(button2);
            this.add(gameScene);
            gameScene.mainGameLoop();

        });

        button2.addActionListener((event) -> {
            this.add(informationScene);
            repaint();
            this.remove(button2);

        });


    }


}

