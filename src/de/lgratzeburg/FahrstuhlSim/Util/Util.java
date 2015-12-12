package de.lgratzeburg.FahrstuhlSim.util;

/**
 * Util ist eine Factory-Klasse für andere Utility-Klassen, welche nützliche Zusatzfunktionen beinhalten. Über eine
 * Singleton-Instanz können Instanzen dieser Utility-Klassen erstellt werden
 */
public class Util {

	// Singleton-Instanz
	private static Util instance;

	private Runnable utilThread;

	/**
	 * Privater Konstruktor, um das Erstellen von Util-Instanzen außerhalb der Util-Klasse zu verhindern
	 */
	private Util() {
		// Lambda-Ausdruck für einen Thread, der die run()-Funktion aufruft
		utilThread = () -> run();
		new Thread(utilThread, "Util-Thread").start();
	}

	/**
	 * Beschreibt den Util-Thread
	 */
	private void run() {
		// TODO
		// Der Util-Thread wurde für eine frühere Version des Timer benutzt, welcher jetzt den Timer aus java.util
		// benutzt. Der Thread ist nur übrig geblieben, falls er doch noch gebraucht wird.
	}

	/**
	 * Gibt eine Singleton-Instanz der Util-Klasse zurück, oder erstellt diese vorher, falls nötig
	 * @return einzige Instanz der Util-Klasse
	 */
	public static Util getInstance() {
		// erstelle eine Instanz, wenn noch keine erstellt wurde
		if(instance == null) {
			instance = new Util();
		}

		return instance;
	}

	/**
	 * Erstellt einen {@link Timer}
	 * @param time - Zeit in Sekunden, die der Timer braucht um abzulaufen
	 * @param startTimer - ob der Timer direkt gestartet werden soll
	 * @param runInfinite - ob der Timer unendlich lange laufen soll
	 * @return Instanz eines {@link Timer}
	 */
	public Timer makeTimer(float time, boolean startTimer, boolean runInfinite) {
		return new Timer(time, startTimer, runInfinite);
	}
	/**
	 * Erstellt einen {@link Timer}, der nur einmal läuft
	 * @param time - Zeit in Sekunden, die der Timer braucht um abzulaufen
	 * @param startTimer - ob der Timer direkt gestartet werden soll
	 * @return Instanz eines {@link Timer}
	 * @see #makeTimer(float, boolean)
	 */
	public Timer makeTimer(float time, boolean startTimer) {
		return makeTimer(time, startTimer, false);
	}
	/**
	 * Erstellt einen {@link Timer}, der nur einmal läuft und direkt startet
	 * @param time - Zeit in Sekunden, die der Timer brauch um abzulaufen
	 * @return Instanz eines {@link Timer}
	 * @see #makeTimer(float, boolean)
	 * @see #makeTimer(float, boolean, boolean)
	 */
	public Timer makeTimer(float time) {
		return makeTimer(time, true);
	}

}
