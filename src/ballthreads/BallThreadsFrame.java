/*
 * Author: George Othen
 * Date: 9/12/2015
 * Title: Ball threads frame
 */

package ballthreads;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class BallThreadsFrame extends JFrame{
    //panel to hold buttons & slider
    public static JPanel buttonPanel;
    
    //button
    JButton button;
    
    //slider
    JSlider speedSlide;
    
    //gridbagconstraints for controlled placement
    GridBagConstraints c;
    
    //new ballpanel panel   
    BallPanel bouncingBallsPanel;   

    BallThreadsFrame()
    {
        bouncingBallsPanel = new BallPanel(); //create ballpanel panel
        bouncingBallsPanel.setPreferredSize(new Dimension(550, 310)); //set ballpanel size        
        createButtons(); //create buttons
        add(buttonPanel, BorderLayout.SOUTH); //set button panel to bottom of frame
        add(bouncingBallsPanel, BorderLayout.CENTER); //set ballpanel to top of frame
        
        
    }

    public void createButtons()
    {
        c = new GridBagConstraints();
        
        //create panel with gridbag layout
        buttonPanel = new JPanel(new GridBagLayout());
        
        //start far left
        c.gridx = 0;
        
        //add action listener to start button and button to panel
        button = new JButton("Start");               
        ActionListener start = new StartBallsListener();
        button.addActionListener(start);
        buttonPanel.add(button, c);
        
        //move 1 to the right
        c.gridx = 1;
        
        //add action listener to pause button and button to panel
        button = new JButton("Pause");
        ActionListener pause = new PauseBallsListener();
        button.addActionListener(pause);
        buttonPanel.add(button, c);
        
        //move 1 to the right
        c.gridx = 2;
        
        //add action listener to stop button and button to panel
        button = new JButton("Stop");
        ActionListener stop = new StopBallsListener();
        button.addActionListener(stop);
        buttonPanel.add(button, c);
        
        //tell gridbag size of slider and move 1 to the right
        c.weightx = 3;
        c.gridx = 4;
        
        //create slider and add change listener
        speedSlide = new JSlider(1, 5, 3);
        speedSlide.addChangeListener(new SpeedSliderListener());
        
        //set ticks spacing and draw ticks
        speedSlide.setMajorTickSpacing(1);
        speedSlide.setPaintTicks(true);
        speedSlide.setPaintLabels(true);
        
        //add slider to panel
        buttonPanel.add(speedSlide, c);
        
    }
    
    
    //actionlistener for start button
    class StartBallsListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            bouncingBallsPanel.addBallToPanel(); //add ball to panel upon click of start
        }
    }
    
    //actionlistener for pause button
    class PauseBallsListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            bouncingBallsPanel.pauseAnim(); //pause all balls upon click of pause button
        }
    }
    
    //actionlistener for stop button
    class StopBallsListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            
        }
    }
    
    //changelistener for slider
    class SpeedSliderListener implements ChangeListener
    {
        public void stateChanged(ChangeEvent event)
        {
            JSlider source = (JSlider) event.getSource(); //get slider event source
            int speed = (int) source.getValue(); //set speed to sliders current value
            bouncingBallsPanel.setSpeed(speed); //set speed of balls
        }
    }
}



