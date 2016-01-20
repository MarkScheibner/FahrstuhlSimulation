package de.lgratzeburg.FahrstuhlSim.util;

import java.util.TimerTask;

/**
 * Timer ist eine Wrappe-Klasse für den {@link java.util.Timer} und stellt ein einfacher zu benutzendes Interface dar.
 *
 */
public class Timer {

	// java.util.Timer-Instanz, die von dieser Klasse gewrapped wird
	private final java.util.Timer jTimer = new java.util.Timer();
	// TimerTask für den jTimer
	private final TimerTask task = new TimerTask() {
		public void run() {
			isFinished = true;
		}
	};

	private boolean running;

	private long time;
	private boolean runInfinite;

	private volatile boolean isFinished;



	protected Timer(float time, boolean startTimer, boolean runInfinite) {

		this.time = (long) (time * 1000);
		this.runInfinite = runInfinite;

		// starte Timer
		if(startTimer) {
			if(runInfinite){
				jTimer.schedule(task, this.time, this.time);
			} else {
				jTimer.schedule(task, this.time);
			}
		}
	}



	/**
	 * Gibt an, ob der Timer seit dem letzten Aufruf von {@link #hasFinished()} abgelaufen ist
	 * @return true, wenn der Timer abgelaufen ist
	 */
	public boolean hasFinished() {
		// setze isFinished zurück auf false, wenn der Timer unendlich lange laufen soll
		if(isFinished && runInfinite) {
			isFinished = false;
			return true;
		} else {
			return isFinished;
		}
	}

	/**
	 * Startet den Timer, wenn dieser nicht schon läuft
	 */
	public void startTimer() {
		if(running) {
			System.out.println("Ein Timer, welcher schon läuft, wurde versucht gestartet zu werden");
			return;
		}

		// starte Timer
		running = true;
		if(runInfinite){
			jTimer.schedule(task, this.time, this.time);
		} else {
			jTimer.schedule(task, this.time);
		}
	}
}
