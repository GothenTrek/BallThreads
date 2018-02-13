/*
 * Author: George Othen
 * Date: 9/12/2015
 * Title: Ball Viewer
 */
package ballthreads;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Gurge
 */
public class BallThreads 
{    
    static JFrame frame;
    public static void main(String[] args) 
    {
        //Set frame size
        final int FRAME_HEIGHT = 400;
        final int FRAME_WIDTH = 600;
        
        
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                //set frame attributes
                frame = new BallThreadsFrame(); //create frame frame
                frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);    //set frame size    
                frame.setTitle("BounceFrame"); 
                frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null); //centre frame
                frame.pack();
                frame.setVisible(true);  
            }
        });
    }
}
