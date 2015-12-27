package de.lgratzeburg.FahrstuhlSim.model;

import java.util.ArrayList;

public class Level {

	//Angabe der Höhe des Stockwerkes
	private int levelNumber = 0;
	

	//Momentaner Zustand der Tür
	private DoorState doorState= DoorState.CLOSED;
	
	/** Noch nicht ganz genau beschriebene Eigenschaft, welche vllt unnötig ist
	 * (Wert lässt sich möglicherweise in einer setDoorSpeed Methode verändern)
	 */
	private int doorRuntime=0;

	
	/**Noch nicht ganz genau bestimmter Wert, um die Tür kurzzeitg in einer halboffenen/geschlossenen Phase zu lassen
	 * (Wert lässt sich möglicherweise in einer setDoorSpeed Methode verändern)
	 * (Bis auf weiteres unnütz, da die Sleep "Blöcke" entfernt wurden)
	 */
	private int doorMoveSpeed = 1000;
	
	/** Gewünschter Zustand der Tür als bool Wert
	*(Möglicherweise unnötig durch den Enum Wert geworden)
	*/
	boolean open = false;
	
	/**
	 * Eine Liste aller Türen mit Zustand
	 * !!ACHTUNG!! Um die Türen nicht zu verwechseln, stell bitte sicher, dass der Index einer Tür im Array
	 * mit der hoistwayNumber des Schachtes übereinstimmt
	 * (Möglicherweise kommt eine neue Funktion um Hoistways und Türen zu erstellen)
	 */
	private ArrayList <DoorState> doorList = new ArrayList<DoorState>();
	
	
	/**
	 * Ein Getter, um auf die Liste aller Türen eines Stockwerkes zugreifen zu können
	 * @return -Eine Liste aller Türen eines Stockwerkes
	 */
	public ArrayList<DoorState> getDoorList() {
		return doorList;
	}

	/** 
	 * Gibt die Höhe des Stockwerkes zurück
	 * @return -aktuelle Höhe des Stockwerkes
	 */
	public int getLevelNumber() {
		return levelNumber;
	}



	/**
	 * Setzt eine neue Höhe für ein Stockwerk
	 * @param levelNumber -aktuelle Höhe des Stockwerkes
	 */
	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}



	/**
	 * Gibt den momentanen Zustand der Tür zurück
	 * @return -Aktueller Tür Status als Enum-Wert
	 */
	public DoorState getDoorState() {
		return doorState;
	}



	/**
	 * Setzt einen neuen Türzustand
	 * @param doorState -Tür Status als Enum-Wert
	 */
	public void setDoorState(DoorState doorState) {
		this.doorState = doorState;
	}


	/**
	 * Gibt einen ganzzahligen Wert für die Mindestöffnungsdauer der Tür in ms zurück
	 * @return -Mindestdauer für die Tür den Zustand OPENED behalten zu müssen
	 * 
	 */
	public int getDoorRuntime() {
		return doorRuntime;
	}


	/**
	 * Setzt einen ganzzahligen Wert für die Mindestöffnungsdauer der Tür in ms
	 * @param doorRuntime -Mindestdauer für die Tür den Zustand OPENED behalten zu müssen
	 */
	public void setDoorRuntime(int doorRuntime) {
		this.doorRuntime = doorRuntime;
	}


	/**
	 * Gibt die Dauer für eine Änderung von einem Vorgang der Öffnung und Schließung in ms zurück
	 * @return -Mindestdauer für einen Vorgang der Zustandsänderung
	 */
	public int getDoorMoveSpeed() {
		return doorMoveSpeed;
	}


	/**
	 * Setzt die Dauer für eine Änderung von einem Vorgang der Öffnung und Schließung in ms
	 * @param doorMoveSpeed -Mindestdauer für einen Vorgang der Zustandsänderung
	 */
	public void setDoorMoveSpeed(int doorMoveSpeed) {
		this.doorMoveSpeed = doorMoveSpeed;
	}
	
	/**
	 * Gibt den gewünschten Wert der Tür zurück
	 *(Möglicherweise unnötig)
	 * @return -Gewünschter Zustand der Tür
	 */
	public boolean isOpen() {
		return open;
	}

	/**
	 * Setzt einen gewünschten bool Wert der Tür
	 *(Möglicherweise unnötig)
	 * @param open-Gewünschter Zusstand der Tür
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}

	/**
	 * Konstruktor eines Objektes der Klasse Level
	 * @param levelNumber -Höhe des Stockwerkes als ganzzahligen Wert
	 */
	public Level(int levelNumber){
		this.levelNumber = levelNumber;
	}
	
	
	
}
