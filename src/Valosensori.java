
// T‰m‰ k‰ytt‰‰ valosensoria 

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.*;

public class Valosensori {

	Valosensori ColorSensor;

	static EV3ColorSensor EV3CS = new EV3ColorSensor(SensorPort.S1);
	public int sampleSize;
	float[] sample;

	public Valosensori() {
		setRedMode();
		EV3CS.setFloodlight(true);
		EV3CS.setFloodlight(Color.RED);
	}

	public void setRedMode() {
		EV3CS.setCurrentMode("Red");
		sample = new float[EV3CS.sampleSize()];
	}

	public int getSampleSize() {
		return sampleSize;
	}

	public void setSampleSize(int sampleSize) {
		this.sampleSize = sampleSize;
	}

	public float getRedValue() {
		EV3CS.fetchSample(sample, 0);
		return sample[0];
	}
}