package de.lgratzeburg.FahrstuhlSim.observer;

import javax.swing.*;

/**
 * Ein Observable beschreibt ein Objekt, welches einen oder mehrere Observer registriert und diese bei Veränderung von
 * Zuständen informiert
 * @author Mark Scheibner
 */
public interface Observable {

	void registerObserver(Observer o);
	void notifyObserver(JComponent actor, String state);

}
