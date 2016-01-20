package de.lgratzeburg.FahrstuhlSim;


import de.lgratzeburg.FahrstuhlSim.control.ControlUnit;
import de.lgratzeburg.FahrstuhlSim.model.Model;

/**
 * Die Mainklasse definiert den Hauptzugriffspunkt der Applikation und startet das Programm
 */
public class Main {

	/**
	 * Hauptzugriffspunkt der Applikation
	 * @param args - Befehlszeilen-argumente
	 */
	public static void main(String args[]) {
		ControlUnit.instance();

	}

}
