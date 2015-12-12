package de.lgratzeburg.FahrstuhlSim.control;

import de.lgratzeburg.FahrstuhlSim.model.Elevator;
import de.lgratzeburg.FahrstuhlSim.observer.Observable;
import de.lgratzeburg.FahrstuhlSim.observer.Observer;

import javax.swing.*;

public class ControlUnit implements Observable, Observer {

	// Singleton-Instanz
	private static ControlUnit instance;
	private static Elevator elevator;

	private ObserverController oc;
	private SimulationController sc;

	private Observer observer;



	/**
	 * Privater Konstruktor, um das Erstellen von ControlUnit
	 */
	private ControlUnit() {
		oc = new ObserverController();
		sc = new SimulationController(elevator, true);

		registerObserver(oc);
	}

	/**
	 * Initialisiert die ControlUnit-Klasse mit einer {@link Elevator}-Instanz, welche der {@link SimulationController}-
	 * Instanz bei der Erstellung übergeben wird
	 * @param e in der Simulation zu benutzende {@link Elevator}-Instanz
	 */
	public static void init(Elevator e) {
		elevator = e;
	}

	/**
	 * Gibt eine Singleton-Instanz der ControlUnit-Klasse zurück, oder erstellt diese vorher, falls nötig
	 * @return einzige Instanz der ControlUnit-Klasse
	 * @throws NullPointerException wenn die Klasse vorher nicht über {@link #init(Elevator)} mit einer {@link Elevator}-
	 * Instanz initialisiert wurde
	 */
	public static ControlUnit instance() throws NullPointerException {
		if(instance == null) {
			if(elevator == null) {
				throw new NullPointerException("ControlUnit muss erst mit einer Elevator-Instanz initialisiert werden");
			}
			instance = new ControlUnit();
		}

		return instance;
	}


	@Override
	public void registerObserver(Observer o) {
		this.observer = o;
	}

	@Override
	public void notifyObserver(JComponent actor, String state) {
		observer.notify(actor, state);
	}

	@Override
	public void notify(JComponent actor, String state) {
		notifyObserver(actor, state);
	}

}
