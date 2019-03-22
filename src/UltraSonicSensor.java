
// T‰m‰ k‰ytt‰‰ ultra‰‰nisensoria

import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.lcd.*;

public class UltraSonicSensor {

	static EV3UltrasonicSensor EV3US = new EV3UltrasonicSensor(SensorPort.S4);
	SampleProvider sp = EV3US.getDistanceMode();
	float[] sample = new float[sp.sampleSize()];

	public EV3UltrasonicSensor getSensor() {
		return EV3US;
	}

	public float getRange() {
		sp.fetchSample(sample, 0);
		return sample[0];
	}

	// Metodi haistelee ultra‰‰nisensensoria, ja tulostaa sen arvon riville 4.
	// Sekunnin kuluttua tyhjennet‰‰n rivi 4, ja tulostetaan uusi arvo.
	// Metodilla testataan sensorin toimivuutta jatkok‰yttˆ‰ varten.
	public void SensoriTesti() {
		System.out.println("Tama tulee USensorista:");
		while (Button.ESCAPE.isUp()) {
			String s = Float.toString(getRange());
			LCD.drawString(s, 1, 4);
			Delay.msDelay(1000);
			LCD.clear(4);
		}
	}
}