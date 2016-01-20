package de.lgratzeburg.FahrstuhlSim.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private static Model instance;
	private List <Elevator> elevator;
	private List <Level> level;
	
	
	/**
	 * Erlaubt einen Zugriff auf die Elevator-Liste
	 */
	public Elevator getElevatorList(int Id) {
		return elevator.get(Id);
	}
	
	/**
	 * Erlaubt einen Zugriff auf die Level-Liste
	 */
	public Level getLevelList(int Id) {
		return level.get(Id);
	}
	
	
	/**
	 * Eine Liste aller Objekte, welche der Singleton wieder zurückgibt und erstellt
	 */
	private Model(){
		elevator = new ArrayList<Elevator>();
		level = new ArrayList<Level>();
		elevator.add(new Elevator(0,0));
		elevator.add(new Elevator(0,1));
		level.add(new Level(0));
		level.add(new Level(1));
		level.add(new Level(2));
		level.add(new Level(3));
	}
	
	/**
	 * Erstellt die Objekte, welche im Model vermerkt sind
	 * @return Eine Liste aller Objekte des Models
	 */
	public static Model instance(){
		if (instance == null){
			instance = new Model();
		}
		return instance;
	}
}

