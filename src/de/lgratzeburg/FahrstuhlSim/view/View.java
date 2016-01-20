package de.lgratzeburg.FahrstuhlSim.view;

import de.lgratzeburg.FahrstuhlSim.view.sizes.Sizes;

import java.awt.*;

public class View {
	
	
	// Frame to view all Components
	private Window w;
	// ComponentContainers (Panels)
	public FloorView floorView;
	public Panel elevatorView;
	public Panel controlView;
	
	// Content
	public FloorView fv;
	public ElevatorView ev;
	
	public View(){
		
		// Create Window
		w = new Window(Sizes.title, Sizes.windowDimension);
		/* Create Content
		 * 		Panels
		 * 		PanelContent
		 * 		
		 * 		Add PanelContent to Panels
		 * 		Add Panels to the Window
		 */
		createViews();
		w.addContent(floorView);
		w.addContent(elevatorView);
		w.addContent(controlView);
	}
	
	private void createViews(){
		Color c = new Color(255, 0, 0);
		int b = 2;
		floorView = new FloorView(Sizes.floorViewPos, Sizes.floorViewDimension, c, b, Sizes.floorAmount, Sizes.floorNames);
		elevatorView = new ElevatorView(c, b, Sizes.elevatorViewPos, Sizes.elevatorViewDimension, Sizes.elevatorAmount, floorView.getFloorHeight());
		controlView =  new Panel(c, b, Sizes.controlsPos, Sizes.controlsDimension);
	}
	
	public ElevatorView getElevatorView(){
		return ev;
	}
}

