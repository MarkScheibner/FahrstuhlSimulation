package de.lgratzeburg.FahrstuhlSim;


import de.lgratzeburg.FahrstuhlSim.control.ControlUnit;
import de.lgratzeburg.FahrstuhlSim.model.Model;
import de.lgratzeburg.FahrstuhlSim.view.View;

/**
 * Die Mainklasse definiert den Hauptzugriffspunkt der Applikation und startet das Programm
 */
public class Main {

	/**
	 * Hauptzugriffspunkt der Applikation
	 * @param args - Befehlszeilen-argumente
	 */
	public static void main(String args[]) {
		for(int i = 0; i < 4; i++) {
			Model.instance().getElevatorList(0).getTargetList().add(10-i);
		}

		System.out.println("Start!");

		ControlUnit.instance();
		View v = new View();
	}

}
