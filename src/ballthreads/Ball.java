/*
 * Author: George Othen
 * Date: 9/12/2015
 * Title: Ball
 */

package ballthreads;

import java.awt.Color;
import java.util.Random;


public class Ball {
    //create new random number generator
    Random rand = new Random();
    
    //create integer representations of x & y coords, ball radius & speed of ball on both x & y
    int x, y, radius, ballSpeedX, ballSpeedY;
    
    //hold colour and thread
    Color colour; Thread thread;
    
    public Ball(){
        //set radius of ball
        radius = 20;
        
        //set random ball coords
        x = rand.nextInt();
        y = rand.nextInt();     
        
        //set random ball direction X
        ballSpeedX = rand.nextInt(4) - 2; 
        if(ballSpeedX == 0) ballSpeedX += 1; //if direction = 0, don't do that
        
        //set random ball direction Y
        ballSpeedY = rand.nextInt(4) - 2;
        if(ballSpeedY == 0) ballSpeedY += 1; //if direction = 0, don't do that
        
        colour = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); //generate random colour
    }
    
    public void moveBall(){
        
        if(x < 0 || x > BallThreadsFrame.buttonPanel.getWidth())
            ballSpeedX = -ballSpeedX; //if ball leaves left or right boundaries, inverse magnitude of ballspeed
        
        if(y < 0 || y > BallThreadsFrame.buttonPanel.getHeight())
            ballSpeedY = -ballSpeedY; //if ball leaves up or bottom boundaries, inverse magnitude of ballspeed
        
        //move ball measure of ballspeed per timer event
        x += ballSpeedX; 
        y += ballSpeedY;
    }
    
    public void setSpeed(int speed){
        if(ballSpeedX < 0){ //if ball is moving left set magnitude of ballspeed negative
            ballSpeedX = -speed;
        } 
        
        else if(ballSpeedY > 0){ //if ball is moving right set magnitude of ballspeed positive
            ballSpeedX = speed;
        }
        
        if(ballSpeedY < 0){ //if ball is moving up set magnitude of ballspeed negative
            ballSpeedY = -speed;
        }
        
        else if(ballSpeedY > 0){ //if ball is moving down set magnitude of ballspeed positive
            ballSpeedY = speed;
        }
    }
    
    //return radius of ball
    public int getRadius(){
        return radius;
    }
    
    //return x coord of ball
    public int getX(){
        return x;
    }
    
    //return y coord of ball
    public int getY(){
        return y;
    }
      
    //return colour of ball
    public Color getColour(){
        return colour;
    }
}
