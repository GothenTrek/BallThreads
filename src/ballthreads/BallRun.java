/*
 * Author: George Othen
 * Date: 9/12/2015
 * Title: Ball runnable
 */

package ballthreads;


public class BallRun extends Thread
{
    
    Ball ball; //hold copy of ball
    BallPanel panel; //hold copy of panel
    
    public BallRun(Ball ball, BallPanel panel)
    {
        this.ball = ball;
        this.panel = panel;
    }
    
    public void run()
    {
        while(true)//run continously
        {
            try
            {
                if(!panel.paused())
                {
                    ball.moveBall(); //calculate new ball coords
                } 
                Thread.sleep(10);
            }
            catch(InterruptedException e){
                break;
            }
        }
    }
}