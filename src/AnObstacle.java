import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AnObstacle extends JPanel {
    private ArrayList<Definitions> obstacles;
    private ImageIcon carLeft;
    private ImageIcon carRight;
    private ImageIcon truckLeft;
    private ImageIcon truckRight;
    private ImageIcon rose;
    private ImageIcon frogger;
    private ImageIcon backGround ;

//    private int xFrogger;
//    private int yFrogger;
    private int yTruckLeft;
    private int xTruckLeft;
    private int yTruckRight;
    private int xTruckRight;
    private int xCarLeft;
    private int yCarLeft;
    private int xCarRight;
    private int yCarRight;
    private int xRose ;
    private int yRose;

//    public int getxFrogger() {
//        return xFrogger;
//    }
//
//    public void setxFrogger(int xFrogger) {
//        this.xFrogger = xFrogger;
//    }
//
//    public int getyFrogger() {
//        return yFrogger;
//    }
//
//    public void setyFrogger(int yFrogger) {
//        this.yFrogger = yFrogger;
//    }

    public int getyTruckLeft() {
        return yTruckLeft;
    }

    public void setyTruckLeft(int yTruckLeft) {
        this.yTruckLeft = yTruckLeft;
    }

    public int getxTruckLeft() {
        return xTruckLeft;
    }

    public void setxTruckLeft(int xTruckLeft) {
        this.xTruckLeft = xTruckLeft;
    }

    public int getyTruckRight() {
        return yTruckRight;
    }

    public void setyTruckRight(int yTruckRight) {
        this.yTruckRight = yTruckRight;
    }

    public int getxTruckRight() {
        return xTruckRight;
    }

    public void setxTruckRight(int xTruckRight) {
        this.xTruckRight = xTruckRight;
    }

    public int getxCarLeft() {
        return xCarLeft;
    }

    public void setxCarLeft(int xCarLeft) {
        this.xCarLeft = xCarLeft;
    }

    public int getyCarLeft() {
        return yCarLeft;
    }

    public void setyCarLeft(int yCarLeft) {
        this.yCarLeft = yCarLeft;
    }

    public int getxCarRight() {
        return xCarRight;
    }

    public void setxCarRight(int xCarRight) {
        this.xCarRight = xCarRight;
    }

    public int getyCarRight() {
        return yCarRight;
    }

    public void setyCarRight(int yCarRight) {
        this.yCarRight = yCarRight;
    }

    public int getxRose() {
        return xRose;
    }

    public void setxRose(int xRose) {
        this.xRose = xRose;
    }

    public int getyRose() {
        return yRose;
    }

    public void setyRose(int yRose) {
        this.yRose = yRose;
    }

    public AnObstacle() {
        this.setBackground(Color.GREEN);
        this.setBounds(0,0,Final.WINDOW_WIDTH,Final.WINDOW_HEIGHT);
        this.obstacles = new ArrayList<>();
        this.backGround = new ImageIcon("backGround.png");
        this.carLeft = new ImageIcon("Car1-Left.png");
        this.carRight = new ImageIcon("Car1-Right.png");
        this.truckLeft = new ImageIcon("Truck-Left.png");
        this.truckRight = new ImageIcon("Truck-Right.png");
        this.rose = new ImageIcon("lilyPad.png");
//        this.frogger = new ImageIcon("FrogUp.png");
//        this.yFrogger = Final.WINDOW_HEIGHT -75  ;
//        this.xFrogger = Final.WINDOW_WIDTH / 2 ;
        this.yTruckLeft =  500 ;
        this.yTruckRight = 440  ;
        this.yCarLeft =  320 ;
        this.yCarRight = 260;
        this.yRose = 110 ;
        this.xCarRight = Final.WINDOW_WIDTH ;
        this.xTruckRight = Final.WINDOW_WIDTH  ;
    }


//    protected void paintComponent(Graphics graphics) {
//        super.paintComponent(graphics);
//        GameScene gameScene = new GameScene(0,0,Final.WINDOW_WIDTH,Final.WINDOW_HEIGHT);
//        this.backGround.paintIcon(this, graphics , 0 , 0);
//        this.carLeft.paintIcon(this, graphics, this.xCarLeft, this.yCarLeft);
//        this.carLeft.paintIcon(this, graphics, this.xCarLeft-150, this.yCarLeft);
//        this.carLeft.paintIcon(this, graphics, this.xCarLeft-300, this.yCarLeft);
//        this.carRight.paintIcon(this, graphics, this.xCarRight, this.yCarRight);
//        this.truckLeft.paintIcon(this, graphics, this.xTruckLeft, this.yTruckLeft);
//        this.truckLeft.paintIcon(this, graphics, this.xTruckLeft-150, this.yTruckLeft);
//        this.truckLeft.paintIcon(this, graphics, this.xTruckLeft-300, this.yTruckLeft);
//        this.truckRight.paintIcon(this, graphics, this.xTruckRight, this.yTruckRight);
//        this.truckRight.paintIcon(this, graphics, this.xTruckRight+150, this.yTruckRight);
//        this.truckRight.paintIcon(this, graphics, this.xTruckRight+300, this.yTruckRight);
//        this.rose.paintIcon(this, graphics, this.xRose+50, this.yRose);
//        this.rose.paintIcon(this, graphics, this.xRose+225, this.yRose);
//        this.rose.paintIcon(this, graphics, this.xRose+375, this.yRose);
//        this.rose.paintIcon(this, graphics, this.xRose+525, this.yRose);
//       this.frogger.paintIcon(this, graphics, this.xFrogger  , this.yFrogger);
//
//    }
//    public boolean collision(Frog frog){
//        boolean alive = true;
//        if(frog.getyFrog() <= 517 && frog.getyFrog() >= 477 ){
//            if(frog.getxFrog() == this.getxTruckLeft()){
//                alive = false;
//            }
//
//        }
//
//        return alive;
//    }
}
