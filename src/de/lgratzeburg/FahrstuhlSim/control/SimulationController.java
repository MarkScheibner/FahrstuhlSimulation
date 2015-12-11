package de.lgratzeburg.FahrstuhlSim.control;

import de.lgratzeburg.FahrstuhlSim.model.Elevator;

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
				updateSim(deltaTime);
				past = System.nanoTime();
			}
		}
	}

	/**
	 * Berechnet einen einzelne Simulationsiteration
	 * @param delta - vergangene Zeit zwischen diesem und der letzten Simulationsiteration
	 */
	public void updateSim(float delta) {
		// TODO Simulation schreiben
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
