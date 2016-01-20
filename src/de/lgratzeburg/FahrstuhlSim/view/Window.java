package de.lgratzeburg.FahrstuhlSim.view;

import java.awt.*;

import javax.swing.*;

public class Window extends JFrame{

	
	/**
	 * The visible Window (JFrame)
	 * sets the main Window options and contains the content Panels
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel mainP;
	
	public Window(String title, Dimension dim){
		
		// Sets JFrame variables
		this.initJFrame(title, dim);	
		
	}
	
	private void initJFrame(String title, Dimension dim){
		
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.getContentPane().setPreferredSize(dim);
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		mainP = new JPanel();
		mainP.setPreferredSize(dim);
		mainP.setLayout(null);
		add(mainP);
		pack();
		setLocationRelativeTo(null);
		
		this.setVisible(true);
	}
	
	public void addContent(Component c){
		mainP.add(c);
		repaint();
	}
}
