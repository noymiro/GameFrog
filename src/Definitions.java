import java.awt.*;

public class Definitions {
    private int x ;
    private int y ;
    private int width ;
    private int height ;

    public Definitions(int x , int y , int width , int height){
        this.y = y ;
        this.x = x ;
        this.height = height ;
        this.width = width ;


    }
    public void paint (Graphics graphics){


    }

    public void moveUp (){
        this.y--;
    }
    public void moveDown (){
        this.y++;
    }
    public void moveRight (){
        this.x++;
    }
    public void moveLeft (){
        this.x--;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
