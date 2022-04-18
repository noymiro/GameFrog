import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerControl implements KeyListener {
    private GameScene gameScene;


    public PlayerControl(GameScene gameScene) {
        this.gameScene = gameScene;
    }

    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent keyEvent) {

        int keyCode = keyEvent.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
          this.gameScene.getFrog().moveRight();
          break;
            case KeyEvent.VK_LEFT:
                this.gameScene.getFrog().moveLeft();
                break;

            case KeyEvent.VK_UP:
                this.gameScene.getFrog().moveUp();
                break;
            case KeyEvent.VK_DOWN:
                this.gameScene.getFrog().moveDown();
                break;

        }

    }


    public void keyReleased(KeyEvent e) {

    }
}
