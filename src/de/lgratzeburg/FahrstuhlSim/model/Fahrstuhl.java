package de.lgratzeburg.FahrstuhlSim.model;

public class Fahrstuhl {
//	nötige Werte
//	vertPos
//	movementState
//	schachtID
//	doorState
//	doorRuntime
	

	// TODO ID-Werte durch Enum-Werte ersetzen

	// Werte für Position des Fahrstuhls
	private double verticalPos=0;

	// Status der Bewegung: 0=ruhend; 1=hoch; 2=runter
	private int movementState=0;

	// Ganze Zahl als Ziel des Fahrstuhls
	private double targetLevel=0;

	// ganzer Wert für Zugehörigkeit zum Schacht
	private int schachtID=0;

	// Ganzer Wert als Status für Tür: 0=zu; 1=geht zu; 2=öffnet; 3=auf
	private int doorStat=0;

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
			this.movementState = 2;
		} if (this.targetLevel - verticalPos>0){
			this.movementState = 1;
		} if (this.targetLevel - verticalPos == 0){
			this.movementState = 0;
			// sollte das zahl = mit der Pos sein, führt er nicht
			return;
		}
		
		
		if (this.movementState != 0){
			// dauerhaftes erhöhen der Pos, bis Ziel erreicht
			while(verticalPos != targetLevel && movementState == 1){
				// rundet die Kommazahl
				this.verticalPos =Math.round(( verticalPos + 0.1)*10d)/10d;
				System.out.println("Elevator level: "+ this.verticalPos);

				// Debugg um die Pos zu sehen
				System.out.println("Elevator level: "+ this.verticalPos);
			}
			// see above
			while(verticalPos != targetLevel && movementState == 2){
				// rundet die Kommazahl
				this.verticalPos =Math.round(( verticalPos - 0.1)*10d)/10d;
				System.out.println("Elevator level: "+ this.verticalPos);

			}

			this.movementState = 0;

		}

	}
	
	
	public double getVertPos(){
		return this.verticalPos;
	}
	
	public int getSchachtID(){
		return this.schachtID;
	}
	
	 
	
	
	
	

}
