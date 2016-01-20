package de.lgratzeburg.FahrstuhlSim.model;

import java.util.ArrayList;


public class Elevator {

	// Werte für Position des Fahrstuhls
	private double verticalPos=0;

	// Status der Bewegung:
	private MovementState movementState = MovementState.RESTING;

	// Ganze Zahl als Ziel des Fahrstuhls
	private double targetLevel=0;

	// ganzer Wert für Zugehörigkeit zum Schacht
	private int schachtID=0;

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

	/**
	 * Wert für die Control unit, sollte sie die Geschwindigkeit des Fahrstuhls verändern wollen
	 * (Standartwert muss noch festgelegt werden)
	 */
	private double elevatorSpeed = 1;

	// Gwünschter Zustand der Tür
	boolean open = false;

	/**
	 * Eine Liste aller eingegebenen Ziele
	 */
	private List <Integer> targetList = new ArrayList<Integer>();

	/**
	 * Erlaubt einen Zugriff auf die targetList
	 */
	public List<Integer> getTargetList() {
		return targetList;
	}


	/**
	 * Konstruktor eines Objektes der Klasse Elevator
	 * @param verticalPos -Starpostion des Fahrstuhls, als einen ganzzahligen Wert
	 * @param schachtID -Zuweisung eines Fahrstuhls zu einem Schacht
	 */
	public Elevator(int verticalPos, int schachtID){
		this.verticalPos=verticalPos;
		this.schachtID=schachtID;
	}



	/**
	 * Gibt die aktuelle Position des Fahrstuhls in Relation zu den Stockwerken zurück
	 * @return - Aktuelle Position des Fahrstuhls in Relation zu den Stockwerken
	 */
	public double getVertPos(){
		return this.verticalPos;
	}

	/**
	 * Gibt die Schachtzugehörigkeit zurück
	 * @return - SchachtID stimmt mit der ID des besetzten Schachtes überein
	 */
	public int getSchachtID(){
		return this.schachtID;
	}

	/**
	 * Gibt die momentane Bewegungsart zurück
	 * @return - Enum Wert, ob der Fahrstuhl still steht, sich nach oben, oder nach unten bewegt
	 */
	public MovementState getMovementState(){
		return this.movementState;
	}

	/**
	 * Gibt den Öffnungszustand der Fahrstuhltür zurück
	 * @return - Enum Wert, ob die Tür offen, oder geschlossen ist
	 */
	public DoorState getDoorState(){
		return this.doorState;
	}

	/**
	 * Legt die Geschwindigkeit des Fahrstuhls fest
	 * @param elevatorSpeed - Wert, welcher die Geschwindigkeit des Fahrstuhls angibt (Absprache nötig)
	 */
	public void setElevatorSpeed(double elevatorSpeed) {
		this.elevatorSpeed = elevatorSpeed;
	}


	/**
	 * Gibt die Maximalgeschwindigkeit des Fahrstzuhls zur&uuml;ck
	 * @return - Wert, welcher die Geschwindigkeit des Fahrstuhls angibt (Absprache n&ouml;tig)
	 */
	public double getElevatorSpeed() {
		return elevatorSpeed;
	}


	/**
	 * Legt eines Ganzzahligen Wert für die Mindestöffnungsdauer der Tür in ms fest
	 * @param doorRuntime -Mindestdauer für die Tür den Zustand OPENED behalten zu müssen
	 */
	public void setDoorRuntime(int doorRuntime) {
		this.doorRuntime = doorRuntime;
	}

	/**
	 * Legt die Dauer für eine Änderung von einem Vorgang der Öffnung und Schließung in ms fest
	 * @param doorMoveSpeed - Dauer der Öffnung, Schließung einer Tür in ms
	 */
	public void setDoorMoveSpeed(int doorMoveSpeed) {
		this.doorMoveSpeed = doorMoveSpeed;
	}

	/**
	 *  Ändert den Zustand der Fahrstuhltür
	 * @param doorState -Zustand der Tür
	 */
	public void setDoorState(DoorState doorState) {
		this.doorState = doorState;
	}

	/**
	 * Legt einen neuen Wert der vertikalen Position fest, welcher auf eine Nachkommastelle gerundet wird
	 * @param verticalPos - Wert für momentane vertikale Position des Fahrstuhls, in Relation zu den Stockwerken
	 */
	public void setNewVertPosition (double verticalPos) {
		this.verticalPos = verticalPos + 0.1;
	}


	/**
	 * Ändert den Bewegungszustand des Fahrstuhls
	 * @param movementState - Zustand der Bewegung RESTING, UP, DOWN
	 */
	public void setMovementState(MovementState movementState) {
		this.movementState = movementState;
	}



/**
 * changeVertPos Funktion wurde rausgenommen und an die Control übergeben
 * (Ich hab hier zum Abschreiben die Funktion noch da gelassen)
 *

 /**
 *  Methode um die Position mithilfe eines ganzahligen Wertes des Zieles zu veraendern
 * @param targetLevel - gewünschter Endwert der vertikalen Fahrstuhlposition

public void changeVertPos(int targetLevel){
this.targetLevel = targetLevel;
// Bestimmung der Fahrtrichtung
if (this.targetLevel - verticalPos<0){
this.movementState = MovementState.DOWN;
} if (this.targetLevel - verticalPos>0){
this.movementState = MovementState.UP;
} if (this.targetLevel - verticalPos == 0){
this.movementState = MovementState.RESTING;
// sollte das zahl = mit der Pos sein, führt er nichts aus
return;
}


if (this.movementState != MovementState.RESTING){
// dauerhaftes erhöhen der Pos, bis Ziel erreicht
while(verticalPos != targetLevel && movementState == MovementState.UP){
// rundet die Kommazahl
this.verticalPos =Math.round(( verticalPos + 0.1)*10d)/10d;
System.out.println("Elevator level: "+ this.verticalPos);


// Debugg um die Pos zu sehen
System.out.println("Elevator level: "+ this.verticalPos);
}
// see above
while(verticalPos != targetLevel && movementState == MovementState.DOWN){
// rundet die Kommazahl
this.verticalPos =Math.round(( verticalPos - 0.1)*10d)/10d;

//Debugg, um die Pos zu sehen
System.out.println("Elevator level: "+ this.verticalPos);

}

//Lässt den Fahrstuhl wieder still stehen
this.movementState = MovementState.RESTING;

}
 */

/**
 * changeDoorStatus Funktion wurde rausgenommen und an die Control übergeben
 * (Ich hab hier zum Abschreiben die Funktion noch da gelassen)
 *
*
*	 * Methode um die Tür zu öffnen und zu schließen, indem man einen bool Wert für Tür eingibt
*	 * (Wird wahrscheinlich auf die Control übertragen)
*	 * @param open - Wenn true dann soll die Tür sich öffnen
*
*	public void changeDoorStatus(boolean open){
*		this.open = open;
*		if  (this.open && doorState != DoorState.OPENED){
*
*
*			 * Debugg Code
*
*			System.out.println("Tür wird geöffnet, bitte haben Sie Geduld");
*
*			this.doorState = DoorState.OPENED;
*
*
*			 * Debugg Code
*
*			System.out.println("Tür ist jetzt offen");
*			return;
*		}
*
*		 * Selbes Szenario, bloß mit der Angabe die Tür zu öffnen
*
*		if (!this.open && doorState != DoorState.CLOSED){
*
*
*			 * Debugg Code
*
*			System.out.println("Tür wird geschlossen, bitte haben Sie Geduld");
*
*
*
*			 * Debugg Code
*
*			System.out.println("Tür ist jetzt geschlossen");
*			return;
*		}
*
*		System.out.println("Die Tür ist bereits in diesem Zustand ( "+this.doorState +" ), es wurden keine Veränderungen vorgenommen");
*	}
*/
}
