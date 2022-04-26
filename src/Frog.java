import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frog extends JPanel implements KeyListener {

    private ImageIcon frog;
    private Definitions image;
    private int xFrog;
    private int yFrog;

    public int getxFrog() {
        return xFrog;
    }

    public void setxFrog(int xFrog) {
        this.xFrog = xFrog;
    }

    public int getyFrog() {
        return yFrog;
    }

    public void setyFrog(int yFrog) {
        this.yFrog = yFrog;
    }

    public Frog() {
        this.frog = new ImageIcon("FrogUp.png");
        this.image = new Definitions(Final.WINDOW_WIDTH / 2, Final.WINDOW_HEIGHT - 10, 40, 40);
        this.yFrog = Final.WINDOW_HEIGHT - 75;
        this.xFrog = Final.WINDOW_WIDTH / 2;
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.frog.paintIcon(this, graphics, xFrog, yFrog);
    }



    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
                this.moveRight();
                break;
            case KeyEvent.VK_LEFT:
                moveLeft();
                break;
            case KeyEvent.VK_UP:
                moveUp();
                break;
            case KeyEvent.VK_DOWN:
                moveDown();
                break;
            case KeyEvent.VK_SPACE:
                jumpUp();
                break;
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void moveUp() {
        this.yFrog -= 2;
        System.out.println("moveUp: " + yFrog);
    }

    public void moveDown() {
        this.yFrog += 2;
        System.out.println("moveDown: " +yFrog);
        if (this.yFrog >= Final.WINDOW_HEIGHT-75){
            yFrog-=2;
        }

        System.out.println("Lower border");
    }

    public void moveRight() {
        this.xFrog += 2;
        System.out.println("moveRight: " + xFrog);
        if (this.xFrog >= Final.WINDOW_WIDTH-50) {
            xFrog -= 2;
        }
    }

    public void moveLeft() {
        this.xFrog -= 2;
        System.out.println("moveLeft: " + xFrog);
        if (this.xFrog <= 0) {
            xFrog += 2;
        }
    }

    public void jumpUp() {
        yFrog -= 80;
        System.out.println("moveUp: frog jumpUp" + this.yFrog);
    }
}