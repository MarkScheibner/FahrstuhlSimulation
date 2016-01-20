package de.lgratzeburg.FahrstuhlSim.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Floor extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JLabel nameLabel;
	private String name;
	
	public Floor(String floorName, Color c, int borderThickness, Point p, Dimension d){
		super(c, borderThickness, p, d);
		
		name = floorName;		
		
		// Create "Call" Button
		
		JButton callButton = new JButton("Call");
		callButton.setBounds(0 + (this.getWidth() - 50) / 6, 0 + ( this.getHeight() - 30 ) / 2 , 50, 30);
		callButton.setBorder(null);
		callButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {

		  }
		});
		this.add(callButton);

		
		// Create Name Label
		this.nameLabel = new JLabel(this.name);
		this.nameLabel.setBounds(10, 10, 30, 10);
		this.add(nameLabel);

        Door door = new Door(new Color(255, 0, 255), 1, new Point(this.getWidth() - this.getWidth() / 5, 0), new Dimension(this.getWidth()/5,this.getHeight()));
        add(door);
	}	
	
	public String getName(){
		return name;
	}
}
