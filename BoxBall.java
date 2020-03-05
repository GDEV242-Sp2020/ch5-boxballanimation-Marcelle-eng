import java.awt.*;
import java.awt.geom.*;

/**
 * Class BoxBall -  This class creates four wall that keep the ball(s)
 * on the screen. It also implements the aouncing and the direction 
 * of each of them.
 *
 * This movement can be initia graphical ball that observes the effectated by repeated calls to the "move" method.
 * 
 * @author Marcelle Tamegnon 
 * 
 * 2020/03/5
 */

public class BoxBall
{
  
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private Canvas canvas;
    private int ySpeed = 15;// initial downward speed
    private int xSpeed = 15; // initial the left to right speed
    private int topWall;
    private int leftWall;
    private int rightWall;
    private int bottomWall;
    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param drawingCanvas  the canvas to draw this ball on
     * @field topWall sets the upper limit of the wall
     * @field leftWall sets the left limit of the wall
     * @field rightWall sets the right limit of the wall
     * @field bottomWall sets the lower limit of the wall
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int groundPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        topWall = 0;
        leftWall = 0;
        rightWall = 600;
        bottomWall = 500;
        canvas = drawingCanvas;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
     public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        //ySpeed += GRAVITY;
        yPosition += ySpeed;
        xPosition += xSpeed;

       if(yPosition >= (500 - diameter)) { // draw again at new position and reverse direction       
            yPosition = (int)(bottomWall - diameter);
            ySpeed = -ySpeed;
        }
        
       if (xPosition >= (600 - diameter) ){ // draw again at new position   and reverse direction  
        xPosition = (int)(rightWall - diameter);
            xSpeed = -xSpeed; 
        }
        
       if(yPosition <= 0) { // draw again at new position   and reverse direction    
        yPosition = (int)topWall ;
         ySpeed = -ySpeed;
        }
        
       if(xPosition <=0) { // draw again at new position and reverse direction      
         xPosition = (int) leftWall;
          xSpeed = -xSpeed;
        }
        draw();
       }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
