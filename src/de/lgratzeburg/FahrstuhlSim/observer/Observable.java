package de.lgratzeburg.FahrstuhlSim.observer;

import javax.swing.*;

/**
 * Ein Observable beschreibt ein Objekt, welches einen oder mehrere Observer registriert und diese bei Veränderung von
 * Zuständen informiert
 * @author Mark Scheibner
 */
public interface Observable {

	/**
	 * Registriert einen {@link Observer} für dieses Observable
	 * @param o - zu regestrierender Observer
	 */
	void registerObserver(Observer o);

	/**
	 * Informiert den/die {@link Observer} über eine Veränderung an einem JComponent des JFrame
	 * @param actor - veränderter JComponent
	 * @param state - Beschreibung des veränderten Zustandes
	 */
	void notifyObserver(JComponent actor, String state);

}
