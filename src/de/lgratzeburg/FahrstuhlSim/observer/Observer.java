package de.lgratzeburg.FahrstuhlSim.observer;

import javax.swing.*;

/**
 * Ein Observer ist ein Objekt, welches über Änderungen der Zustände eines {@link Observable} informiert wird und
 * dementsprechend handelt
 */
public interface Observer {

	/**
	 * Über die notify-Methode kann ein {@link Observable} einen Observer über eine Veränderung des Zustandes
	 * informieren
	 * @param actor - Handelnder JComponent (z.B. gedrückter Knopf)
	 * @param state - Beschreibung des veränderten Zustandes
	 */
	void notify(JComponent actor, String state);

}
