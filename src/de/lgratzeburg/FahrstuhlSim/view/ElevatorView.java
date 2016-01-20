package de.lgratzeburg.FahrstuhlSim.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

public class ElevatorView extends Panel{

	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Elevator> elevators;

	public ElevatorView(Color c, int borderThickness, Point p, Dimension d, int elevatorAmount, int floorHeight){
		super(p ,d);

		int elevatorHeight = floorHeight;
		int elevatorWidth = d.width / elevatorAmount - borderThickness * 2;

		Dimension elevatorDimension = new Dimension(elevatorWidth, elevatorHeight);

		for(int n = 0; n < elevatorAmount; n++){
			// TODO Tim hat gepfuscht, und ich habs gesehen!
			elevators.add(new Elevator(c, borderThickness, new Point(0, 0), (Dimension) null));
		}
		Elevator elevator = new Elevator(c, borderThickness, new Point(0, 0), elevatorDimension);
		add(elevator);

		
	}
}
