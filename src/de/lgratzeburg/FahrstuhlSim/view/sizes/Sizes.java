package de.lgratzeburg.FahrstuhlSim.view.sizes;

import java.awt.*;

/*
Stores all Variables
Some of them will be outsourced later to the Model

 */


public class Sizes {

	// All usergiven variables
	public static String title = "Elevator Simulation v3";
	public static int windowWidth = 800;
	public static int windowHeight = 600;

	public static String[] floorNames = {"KG", "EG", "OG1", "OG2"};
	public static int floorAmount = floorNames.length;

	public static int elevatorAmount = 1;


	public static Dimension windowDimension = new Dimension(windowWidth, windowHeight);
	// Border between different ViewComponents

	public static int padding = 10;
	// Panel Dimensions
	public static Dimension floorViewDimension = new Dimension((int) (windowWidth * 0.4) - padding, windowHeight);
	public static Point floorViewPos = new Point(0, 0);

	public static Dimension elevatorViewDimension = new Dimension((int) (windowWidth * 0.1 - padding), windowHeight);
	public static Point elevatorViewPos = new Point((int) (windowWidth * 0.4), 0);

	public static Dimension controlsDimension = new Dimension((int) (windowWidth * 0.5), windowHeight);
	public static Point controlsPos = new Point((int) (windowWidth * 0.5), 0);



}
