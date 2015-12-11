package de.lgratzeburg.FahrstuhlSim.model;

public class Elevator {
//	nötige Werte
//	vertPos
//	movementState
//	schachtID
//	doorState
//	doorRuntime
	



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

	/** Noch nicht ganz genau beschriebene Eigenschaft, welche vllt unn�tig ist
	 * (Wert lässt sich möglicherweise in einer setDoorSpeed Methode verändern)
	 */
	private float doorRuntime=0;

	/**Noch nicht ganz genau bestimmter Wert, um die Tür kurzzeitg in einer halboffenen/geschlossenen Phase zu lassen
	 * (Wert lässt sich möglicherweise in einer setDoorSpeed Methode verändern)
	 */
	private int doorMoveSpeed = 1000;

	// Gwünschter Zustand der Tür
	boolean open = false;
	
	public Elevator(int verticalPos, int schachtID){
		this.verticalPos=verticalPos;
		this.schachtID=schachtID;
	}

	/**
	 *  Methode um die Position mithilfe eines ganzahligen Wertes des Zieles zu veraendern
	 * @param targetLevel - gewünschter Endwert der vertikalen Fahrstuhlposition
	 */
	public void changeVertPos(int targetLevel){
		this.targetLevel = targetLevel;
		// bestimmung der Fahrtrichtung
		if (this.targetLevel - verticalPos<0){
			this.movementState = MovementState.DOWN;
		} if (this.targetLevel - verticalPos>0){
			this.movementState = MovementState.UP;
		} if (this.targetLevel - verticalPos == 0){
			this.movementState = MovementState.RESTING;
			// sollte das zahl = mit der Pos sein, führt er nicht
			return;
		}
		
		
		if (this.movementState != MovementState.RESTING){
			// dauerhaftes erhöhen der Pos, bis Ziel erreicht
			while(verticalPos != targetLevel && movementState == MovementState.UP){
				// rundet die Kommazahl
				this.verticalPos =Math.round(( verticalPos + 0.1)*10d)/10d;
				System.out.println("Elevator level: "+ this.verticalPos);

				/**
				 * Simuliert eine "Bewegung" des Fahrstuhls
				 */
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// Debugg um die Pos zu sehen
				System.out.println("Elevator level: "+ this.verticalPos);
			}
			// see above
			while(verticalPos != targetLevel && movementState == MovementState.DOWN){
				// rundet die Kommazahl
				this.verticalPos =Math.round(( verticalPos - 0.1)*10d)/10d;
				System.out.println("Elevator level: "+ this.verticalPos);

				/**
				 * Simuliert eine "Bewegung" des Fahrstuhls
				 */
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

			this.movementState = MovementState.RESTING;

		}

	}
	
	
	public double getVertPos(){
		return this.verticalPos;
	}
	
	public int getSchachtID(){
		return this.schachtID;
	}



	/**
	 * Methode um die Tür zu öffnen und zu schließen, indem man einen bool Wert für Tür eingibt
	 * @param open - Wenn true dann soll die Tür sich öffnen
	 */
	public void changeDoorStatus(boolean open){
		this.open = open;
		if  (this.open && doorState != DoorState.OPENED){
			this.doorState = DoorState.OPENING;

			/**
			 * Debugg Code
			 */
			System.out.println("Tür wird geöffnet, bitte haben Sie Geduld");


			/**
			 * Lässt die Tür kurzzeitig zwischen offen und geschlossen verweilen
			 * (Nutzen muss noch diskutiert werden)
			 */
			try {
				Thread.sleep(doorMoveSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.doorState = DoorState.OPENED;

			/**
			 * Debugg Code
			 */
			System.out.println("Tür ist jetzt offen");
			return;
		}
		/**
		 * Selbes Szenario, bloß mit der Angabe die Tür zu öffnen
		 */
		if (!this.open && doorState != DoorState.CLOSED){
			this.doorState = DoorState.CLOSING;

			/**
			 * Debugg Code
			 */
			System.out.println("Tür wird geschlossen, bitte haben Sie Geduld");


			/**
			 * Lässt die Tür kurzzeitig zwischen offen und geschlossen verweilen
			 * (Nutzen muss noch diskutiert werden)
			 */
			try {
				Thread.sleep(doorMoveSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.doorState = DoorState.CLOSED;

			/**
			 * Debugg Code
			 */
			System.out.println("Tür ist jetzt geschlossen");
			return;
		}

		System.out.println("Die Tür ist bereits in diesem Zustand ( "+this.doorState +" ), es wurden keine Veränderungen vorgenommen");
	}
	
	
	
	

}
