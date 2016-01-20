package de.lgratzeburg.FahrstuhlSim.control;

import de.lgratzeburg.FahrstuhlSim.model.DoorState;
import de.lgratzeburg.FahrstuhlSim.model.Elevator;
import de.lgratzeburg.FahrstuhlSim.model.MovementState;
import de.lgratzeburg.FahrstuhlSim.util.Timer;
import de.lgratzeburg.FahrstuhlSim.util.Util;

/**
 * Der SimulationController kontrolliert die Hauptsimulation und berechnet die einzelnen Zustände unabhäng von den
 * Eingaben des View
 * @author Mark
 */
public class SimulationController {

	private Elevator elevator;
	private boolean running;

	// Länge der angestrebten Zeitdifferenz zwischen Simulationsiterationen (16.67ms)
	private static final long SIMULATION_STEP_SIZE = 1000000000 / 60;



	/**
	 * Erstellt einen SimulationController, welcher nicht von selbst startet
	 * @param elevatorModel - Referenz auf die zu benutzende {@link Elevator}-Instanz
	 */
	public SimulationController(Elevator elevatorModel) {
		this(elevatorModel, false);
	}

	/**
	 * Erstellt einen SimulationController, welcher bei bedarf automatisch gestartet wird
	 * @param elevatorModel - Referenz auf die zu benutzende {@link Elevator}-Instanz
	 * @param startSimulation - gibt an, ob die Simulation sofort gestartet werden soll
	 */
	public SimulationController(Elevator elevatorModel, boolean startSimulation) {
		this.elevator = elevatorModel;
		this.running = startSimulation;

		// Starte die Simulation, wenn gefordert
		if(running) {
			runSimulation();
		}
	}

	/**
	 * Läuft die Simulation durch zeitlich geplantes aufrufen von {@link #updateSim(float)} alle 16.67ms
	 */
	private void runSimulation() {
		// speichere momentane Systemzeit als Zeitpunkt des letzten Simulationsiteration
		long past = System.nanoTime();

		while (running) {
			// berechnen der seit der letzten Simulationsiteration vergangenen Zeit
			long deltaTime = System.nanoTime() - past;

			// updateSim() nur aufrufen, wenn deltaTime groß genug ist
			if(deltaTime >= SIMULATION_STEP_SIZE) {
				float delta = deltaTime / 1000000000f;
				updateSim(delta);
				past = System.nanoTime();
			}
		}
	}

	Timer doorTimer;

	/**
	 * Berechnet einen einzelne Simulationsiteration
	 * @param delta - vergangene Zeit zwischen diesem und der letzten Simulationsiteration
	 */
	public void updateSim(float delta) {
		int target = elevator.getTargetList().get(0);

		switch(elevator.getMovementState()) {
			case RESTING: {
				// TODO Tür öffnen bzw. schließen und in Richtung des nächsten Ziels bewegen

				elevator.setDoorState(handleDoorState(elevator.getDoorState()));
				if(elevator.getDoorState() == DoorState.CLOSED) {
					if(target > elevator.getVertPos()) {
						elevator.setMovementState(MovementState.UP);
					} else {
						elevator.setMovementState(MovementState.DOWN);
					}
				}
				break;
			}
			case UP: {
				// der Fahrstuhl sollte sich nach unten bewegen
				if(target < elevator.getVertPos()) {
					elevator.setMovementState(MovementState.DOWN);
				}

				double nPos = elevator.getVertPos() + (elevator.getElevatorSpeed() * delta);

				// verhindert ein überlaufen des Ziels
				if(nPos >= target) {
					nPos = target;
					elevator.setMovementState(MovementState.RESTING);
				}

				elevator.setNewVertPosition(nPos);

				break;
			}
			case DOWN: {
				// der Fahrstuhl sollte sich nach oben bewegen
				if(target > elevator.getVertPos()) {
					elevator.setMovementState(MovementState.UP);
				}

				double nPos = elevator.getVertPos() - (elevator.getElevatorSpeed() * delta);

				// verhindert ein überlaufen des Ziels
				if(nPos <= target) {
					nPos = target;
					elevator.setMovementState(MovementState.RESTING);
				}

				elevator.setNewVertPosition(nPos);

				break;
			}
		}
	}


	private DoorState handleDoorState(DoorState doorState) {
		switch(elevator.getDoorState()) {
			case CLOSED: {

				return doorState;
			}
			case OPENED: {

				return doorState;
			}
			case OPENING: {
				if(doorTimer == null) {
					// OPENING-state wurde erst im letzten Iterations-Schritt betreten
					doorTimer = Util.getInstance().makeTimer(5);
				} else if(doorTimer.hasFinished()) {
					doorTimer = null;
					return DoorState.OPENED;
				}

				return doorState;
			}
			case CLOSING: {

				return doorState;
			}
			default: {
				System.out.println("Hier lief etwas schief... " + doorState);
				return doorState;
			}
		}
	}


	/**
	 * Startet die Simulation, wenn diese nicht schon läuft
	 */
	public void startSim() {
		// return, wenn die Simulation schon läuft
		if(running) return;

		// starte die Simulation andernfalls
		this.running = true;
		runSimulation();
	}
	/**
	 * Beendet die Simulation
	 */
	public void stopSimulation() {
		// return, wenn die Simulation nicht läuft
		if(!running) return;

		// beende die Simulation andernfalls
		this.running = false;
	}


}
