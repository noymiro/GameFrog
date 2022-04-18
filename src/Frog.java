import javax.swing.*;
import java.awt.*;

public class Frog extends Definitions {

    private ImageIcon frog ;
    private boolean alive ;
    private Definitions image ;


    public Frog(){
        super(500 , 500 , 800, 600 );
        this.alive = true;
        this.frog = new ImageIcon("FrogUp.png");
        this.image = new Definitions(Main.WINDOW_WIDTH  / 2 , Main.WINDOW_HEIGHT - 10  , 40 , 40 );
    }
    public void paint (Graphics graphics){
        if (this.alive) {
         //   this.image.paintIcon;
        }
    }
    public void moveRight () {
    //    this.frog.setImage(frog);
        this.moveRight();

    }

    public void moveLeft () {
     //   this.head.moveLeft();
        this.moveLeft();

    }

    public void moveUp () {
    //    this.head.moveUp();
        this.moveUp();

    }

    public void moveDown () {
  //      this.head.moveDown();
        this.moveDown();

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
