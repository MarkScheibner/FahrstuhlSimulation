package de.lgratzeburg.FahrstuhlSim.control;

import de.lgratzeburg.FahrstuhlSim.model.Elevator;
import de.lgratzeburg.FahrstuhlSim.observer.Observable;
import de.lgratzeburg.FahrstuhlSim.observer.Observer;

import javax.swing.*;

public class ControlUnit implements Observable, Observer {

	// Singleton-Instanz
	private static ControlUnit instance;

	private ObserverController oc;
	private SimulationController sc;

	private Observer observer;



	/**
	 * Privater Konstruktor, um das Erstellen von ControlUnit
	 */
	private ControlUnit() {
		oc = new ObserverController();
		sc = new SimulationController(true);

		registerObserver(oc);
	}

	/**
	 * Gibt eine Singleton-Instanz der ControlUnit-Klasse zurück, oder erstellt diese vorher, falls nötig
	 * @return einzige Instanz der ControlUnit-Klasse
	 */
	public static ControlUnit instance() {
		if(instance == null) {
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
