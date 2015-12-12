package de.lgratzeburg.FahrstuhlSim.model;


public class Hoistway {

	/**
	 * Die ID des Fahrstuhlschachtes, welche als seine Position fungiert
	 */
	private int hoistwayNumber =0;

	/**
	 * Konstrukter eines Fahrstuhlschachtes mit Zuweisung einer Schachtnummer
	 * @param hoistwayNumber - Die ID des Fahrstuhlschachtes, welche als seine Position fungiert
	 */
	public Hoistway (int hoistwayNumber){
		this.hoistwayNumber = hoistwayNumber;
	}

	/**
	 *Funktionen, um die HoistwayNumber neu zu setzen und wieder abzurufen
	 */
	public int getHoistwayNumber() {
		return hoistwayNumber;
	}

	public void setHoistwayNumber(int hoistwayNumber) {
		this.hoistwayNumber = hoistwayNumber;
	}
}
