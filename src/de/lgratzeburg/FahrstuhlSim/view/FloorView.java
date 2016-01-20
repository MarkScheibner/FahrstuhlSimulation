package de.lgratzeburg.FahrstuhlSim.view;

import de.lgratzeburg.FahrstuhlSim.view.sizes.Sizes;

import java.awt.*;

public class FloorView extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Floor[] floors;
	private int floorHeight;

	public FloorView(Point p, Dimension d, Color floorColor, int floorBorderThickness, int floorAmount, String[] floorNames){
		super(p, d);

		/*
		floorBorderHeight = floorHeight * borderPercent

		windowHeight = floorHeight * floorAmount + floorBorderHeight * (floorAmount - 1)
		windowHeight = floorHeight * floorAmount + floorHeight * borderPercent * (floorAmount - 1)
		windowHeight = floorHeight * (floorAmount + borderPercent * (floorAmount - 1))
		windowHeight = floorHeight * (floorAmount + borderPercent * floorAmount + borderPercent * - 1)
		windowHeight = floorHeight * (floorAmount + borderPercent * floorAmount - borderPercent)

		floorHeight = windowHeight / (floorAmount + borderPercent * floorAmount - borderPercent)
		 */
		double borderPercent = 0.3;

		floorHeight = (int) ( Sizes.windowHeight / (floorAmount + borderPercent * floorAmount - borderPercent) );
		int floorBorderHeight = (int) (floorHeight * borderPercent + 1);

		// Create the single Floors
		floors = new Floor[floorAmount];
		for(int n = 0; n < floorAmount; n++){
			floors[n] = new Floor(floorNames[n], floorColor, floorBorderThickness, new Point(p.x, p.y + n * (floorHeight + floorBorderHeight)), new Dimension(this.getWidth(), floorHeight));
		}
		
		for(Floor f : floors){
			add(f);
		}
		
	}
	public int getFloorHeight() { return floorHeight;}
	public Floor[] getFloors(){
		return floors;
	}
}
