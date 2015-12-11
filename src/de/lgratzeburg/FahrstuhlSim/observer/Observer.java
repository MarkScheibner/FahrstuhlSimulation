package de.lgratzeburg.FahrstuhlSim.observer;

import javax.swing.*;

/**
 * Ein Observer ist ein Objekt, welches über Änderungen der Zustände eines {@link Observable} informiert wird und
 * dementsprechend handelt
 * @author Mark Scheibner
 */
public interface Observer {

	/**
	 * Informiert den Observer von außerhalb über eine Veränderung eines JComponents des Views
	 * @param actor - Veränderter JComponent
	 * @param state - Beschreibung des veränderten Zustandes
	 */
	void notify(JComponent actor, String state);

}
