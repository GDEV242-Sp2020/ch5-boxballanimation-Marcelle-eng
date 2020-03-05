import java.awt.*;
import java.awt.geom.*;

/**
 * Class BoxBall - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Michael Kölling (mik)
 * @author David J. Barnes
 * @author Bruce Quig
 *
 * @version 2011.07.31
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
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
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

        if(yPosition >= (500 - diameter)) { // draw again at new position       
            yPosition = (int)(bottomWall - diameter);
            ySpeed = -ySpeed;
        }
        
       if (xPosition >= (600 - diameter) ){ // check if it has hit the right wall
        xPosition = (int)(rightWall - diameter);
            xSpeed = -xSpeed; 
            //ySpeed -= ySpeed;
        }
        
        
       if(yPosition <= 0) { // draw again at new position       
        yPosition = (int)topWall ;
         ySpeed = -ySpeed;
        }
        
      if(xPosition <=0) { // draw again at new position       
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
