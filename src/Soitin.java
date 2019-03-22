
import lejos.hardware.Sound;
import lejos.utility.Delay;

public class Soitin implements Runnable {

	// https://lejos.sourceforge.io/rcx/tutorial/essential/hardware/sound.html
	/*
	 * inst - Instrument definition (5 ints in an array). freq - The note to play(in
	 * Hz) len - The duration of the note (in ms)
	 * 
	 */
	public final static int[] PIANO = new int[] { 4, 25, 500, 7000, 5 };
	int tauko = 350;

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			windmillVol2();
		}
	}

	private void tauko() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void windmillVol2() {

		playNotes("D4100-F4100-D5300");
		Delay.msDelay(tauko);

		playNotes("D4100-F4100-D5300");
		Delay.msDelay(tauko);

		playNotes("E5300-F5100-E5100-F5100-E5100-C5100-A4300");
		Delay.msDelay(tauko);

		playNotes("A4300-D4300-F4100-G4100-A4300");
		Delay.msDelay(tauko);

		playNotes("A4300-D4300-F4100-G4100-E4300");
		Delay.msDelay(tauko);

		playNotes("D4100-F4100-D5300");
		Delay.msDelay(tauko);

		playNotes("D4100-F4100-D5300");
		Delay.msDelay(tauko);

		playNotes("E5300-F5100-E5100-F5100-E5100-C5100-A4300");
		Delay.msDelay(tauko);

		playNotes("A4300-D4300-F4100-G4100-A4300");
		Delay.msDelay(tauko);

		playNotes("A4300-D4300");
	}

	private void playNotes(String notes) {
		int duration = 0;
		String[] parts = notes.split("-");
		for (String part : parts) {
			String nuotti = part.substring(0, 2);
			duration = Integer.parseInt(part.substring(2));
			switch (nuotti) {
			case " ":
				tauko();
				break;
			case "C4":
				Sound.playNote(PIANO, 262, duration); // C4
				break;
			case "D4":
				Sound.playNote(PIANO, 294, duration); // D4
				break;
			case "E4":
				Sound.playNote(PIANO, 330, duration); // E4
				break;
			case "F4":
				Sound.playNote(PIANO, 349, duration); // F4
				break;
			case "G4":
				Sound.playNote(PIANO, 392, duration); // G4
				break;
			case "A4":
				Sound.playNote(PIANO, 440, duration); // A4
				break;
			case "B4":
				Sound.playNote(PIANO, 494, duration); // B4
				break;
			case "C5":
				Sound.playNote(PIANO, 523, duration); // C5
				break;
			case "D5":
				Sound.playNote(PIANO, 587, duration); // D5
				break;
			case "E5":
				Sound.playNote(PIANO, 659, duration); // E5
				break;
			case "F5":
				Sound.playNote(PIANO, 698, duration); // F5
				break;
			case "G5":
				Sound.playNote(PIANO, 784, duration); // G5
				break;
			case "A5":
				Sound.playNote(PIANO, 880, duration); // A5
				break;
			case "B5":
				Sound.playNote(PIANO, 988, duration); // B5
				break;
			case "C6":
				Sound.playNote(PIANO, 1047, duration); // C6
				break;
			case "D6":
				Sound.playNote(PIANO, 1175, duration); // D6
				break;
			case "E6":
				Sound.playNote(PIANO, 1319, duration); // E6
				break;
			case "F6":
				Sound.playNote(PIANO, 1397, duration); // F6
				break;
			case "G6":
				Sound.playNote(PIANO, 1568, duration); // G6
				break;
			case "A6":
				Sound.playNote(PIANO, 1760, duration); // A6
				break;
			case "B6":
				Sound.playNote(PIANO, 1976, duration); // B6
				break;

			}
		}
	}
}
