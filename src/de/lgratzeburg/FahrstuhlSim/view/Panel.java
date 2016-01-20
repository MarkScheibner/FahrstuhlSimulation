package de.lgratzeburg.FahrstuhlSim.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Panel extends JPanel{

	/**
	 * Basic Parent class to view JPanels
	 */
	private static final long serialVersionUID = 1L;
	
	Point pos;
	Dimension dim;
	
	public Panel(Color c, int borderThickness, Point p, Dimension d){
		/*
		 * If a color is given, the Panel gets a colored Border
		 */
		this.setLayout(null);	
		this.setFixedPosition(p.x, p.y, d.width, d.height);
		createBorder(c, borderThickness);
		
	}
	
	public Panel(Point p, Dimension d){
		this.setLayout(null);
		this.setFixedPosition(p.x, p.y, d.width, d.height);
	}
	
	private void createBorder(Color c, int thickness){
		this.setBorder(BorderFactory.createLineBorder(c, thickness, true));		
	}
	
	protected void setFixedPosition(int x, int y, int width, int height){
		/*
		 * Inits the window for a fixed position
		 */
		this.setBounds(x, y, width, height);
		this.repaint();
	}
	
}
