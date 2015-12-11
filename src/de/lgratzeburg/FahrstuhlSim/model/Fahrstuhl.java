package de.lgratzeburg.FahrstuhlSim.model;

public class Fahrstuhl {
//	nötige Werte
//	vertPos
//	movementState
//	schachtID
//	doorState
//	doorRuntime
	

	// TODO ID-Werte durch Enum-Werte ersetzen
	//change!
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

	// Noch nicht ganz genau beschriebene Eigenschaft, welche vllt unn�tig ist
	private float doorRuntime=0;
	
	public Fahrstuhl(int verticalPos, int schachtID){
		this.verticalPos=verticalPos;
		this.schachtID=schachtID;
	}

	// Methode um die Position mithilfe eines ganzahligen Wertes des Zieles zu ver�ndern
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

				// Debugg um die Pos zu sehen
				System.out.println("Elevator level: "+ this.verticalPos);
			}
			// see above
			while(verticalPos != targetLevel && movementState == MovementState.DOWN){
				// rundet die Kommazahl
				this.verticalPos =Math.round(( verticalPos - 0.1)*10d)/10d;
				System.out.println("Elevator level: "+ this.verticalPos);

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
	
	 
	
	
	
	

}
