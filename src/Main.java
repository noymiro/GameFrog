import javax.swing.*;

public class Main extends JFrame {


    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        OpenScene openScene = new OpenScene(Final.X_PIC, Final.Y_PIC, Final.WINDOW_WIDTH, Final.WINDOW_HEIGHT);
        this.add(openScene);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Final.WINDOW_WIDTH, Final.WINDOW_HEIGHT);
        this.setVisible(true);
        repaint();
    }
}
