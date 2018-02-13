/*
 * Author: George Othen
 * Date: 9/12/2015
 * Title: Ball Panel
 */

package ballthreads;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;


public class BallPanel extends JPanel implements ActionListener
{
    //create boolean to set whether paused or not
    boolean paused;
    
    //create Timer
    Timer timer;
    
    //create random number generator
    Random rand;
    
    //integers representing ball speed & ball radius
    int speed, radius;
    
    //create actionListener for timer
    ActionListener timerListener = new TimerListener();
    
    //Hold list of all Ball objects
    List<Ball> balls;
    
    //Hold list of all threads
    List<Thread> threads;
    
    
    public BallPanel()
    {
        //intialise arrays
        balls = new ArrayList<>();
        threads = new ArrayList<>();
        //create timer
        timer = new Timer(5, timerListener);
        //start timer
        timer.start();
        //initialise random num generator
        rand = new Random();
        //initialise speed;
        speed = 1;
    }   
    
    class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            repaint(); //call repaint 5 times per second
        }
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g); //recall paintComponent;
        
        for (Ball ball : balls) 
        { //draw an ellipse for all objects in array list balls
                Ellipse2D ballShape = new Ellipse2D.Double(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius());
                g2.setColor(ball.getColour()); //set ball colour
                g2.fill(ballShape); //fill in ellipse
        } 
    }
    
    public void addBallToPanel(){
        Ball ball = new Ball(); //create new ball
        if(speed != 1){
            ball.setSpeed(speed); //set default speed
        }
        balls.add(ball); //add new ball to list
        
        Thread t = new Thread(new BallRun(ball, this)); //create new runnable thread of new ball
        t.start();     
        
        threads.add(t); //add thread to list
    }
    
    public void pauseAnim()
    {
        paused = !paused; //inverse pause boolean
    }
    
    public boolean paused()
    {
        return paused; //return paused
    }
    
    public void setSpeed(int speed)
    {
        for(Ball ball : balls)
        { //set speed for all balls in array list
            this.speed = speed;
            ball.setSpeed(speed);
        }
    } 
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {    //abstract method required by ballPanel    
    }
}
