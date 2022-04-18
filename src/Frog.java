import javax.swing.*;
import java.awt.*;

public class Frog extends Definitions {

    private ImageIcon frog ;
    private boolean alive ;
    private Definitions image ;


    public Frog(){
        super(Final.WINDOW_HEIGHT - 75  , Final.WINDOW_WIDTH / 2  , 40, 40 );
        this.alive = true;
        this.frog = new ImageIcon("FrogUp.png");
        //this.image = new Definitions(Final.WINDOW_WIDTH  / 2 , Final.WINDOW_HEIGHT - 10  , 40 , 40 );
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.frog.paintIcon(this , graphics , Final.WINDOW_HEIGHT -75 ,Final.WINDOW_WIDTH / 2 );
    }
    public void paint (Graphics graphics){
        if (this.alive) {
         //   this.image.paintIcon;
        }
    }
    public void moveRight () {

       this.image.moveRight();

    }

    public void moveLeft () {
        this.image.moveLeft();

    }

    public void moveUp () {
        this.image.moveUp();
    }

    public void moveDown () {
        this.image.moveDown();

    }
    public boolean checkCollision (Definitions obstacle){
        boolean collision = false;

        // this.anObstacle.();
        // איך של התגנשות


return collision ;
    }

    public void Kill (){
        this.alive = false;
    }
}
