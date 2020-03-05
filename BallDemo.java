import java.awt.Color;
import java.util.Random;
import java.util.HashSet;
import java.util.ArrayList;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @Marcelle Tamegnon
 * @ date: 2020/03/05
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }
    
    /**
     * Takes a parameter and craetes many balls moving in an infinite loop 
     * giving them different colors every time it is called
     */
     public void Boxbounce(int ballNum){
        myCanvas.setVisible(true);
        Random random = new Random();
        Random myColor = new Random();
        
        ArrayList colors = new ArrayList<>();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
       Color col =new Color (r,g,b);
       
        HashSet<BoxBall> ballSet = new HashSet<BoxBall>();
       for(int i = 0; i < ballNum; i++){
            BoxBall ball = new BoxBall(random.nextInt(600/2),
            random.nextInt(500/2), 10+2*i,col,40, myCanvas);
            ballSet.add(ball);
            ball.draw();
           }
        boolean finished =  false;
        while(!ballSet.isEmpty()) {
            myCanvas.wait(30);           // small delay
            for(BoxBall ball : ballSet){
                ball.move();
            }
       }
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
