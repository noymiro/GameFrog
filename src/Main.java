import javax.swing.*;

public class Main extends  JFrame {


    public static void main(String[] args) {
        new Main();


    }
    public Main(){
        OpenScene openScene = new OpenScene(0 , 0 , Final.WINDOW_WIDTH, Final.WINDOW_HEIGHT);
        this.add(openScene);
//        GameScene gameScene = new GameScene(0 , 0 , Final.WINDOW_WIDTH , Final.WINDOW_HEIGHT);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Final.WINDOW_WIDTH, Final.WINDOW_HEIGHT);
        this.setVisible(true);

//        this.add(gameScene);

        repaint();

    }

}
