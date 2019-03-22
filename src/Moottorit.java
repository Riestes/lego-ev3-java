
// Tämä säie käyttää molempia moottoreita
// https://ev3dev-lang-java.github.io/docs/support/fundamentals/actuators/regulated-motors.html

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class Moottorit implements Runnable {
	Valosensori v;
	UltraSonicSensor u;
	Soitin s;

	private EV3LargeRegulatedMotor motorA;
	private EV3LargeRegulatedMotor motorD;

	public Moottorit(Valosensori valo, UltraSonicSensor ultra, Soitin soitin) {
		this.v = valo;
		this.u = ultra;
		this.s = soitin;
		motorA = new EV3LargeRegulatedMotor(MotorPort.A);
		motorD = new EV3LargeRegulatedMotor(MotorPort.D);
	}

	@Override
	public void run() {
		while (Button.ESCAPE.isUp()) {

			if (u.getRange() < 0.20) {
				esteenVaistoOikea2();
			}

			// vasen
			if (v.getRedValue() > 0.03) {
				motorA.setSpeed(200);
				motorD.setSpeed(100);
				motorA.forward();
				motorD.forward();
				// oikea
			} else if (v.getRedValue() < 0.03) {
				motorD.setSpeed(200);
				motorA.setSpeed(100);
				motorA.forward();
				motorD.forward();
			} else {
				motorD.setSpeed(500);
				motorA.setSpeed(500);
				motorA.forward();
				motorD.forward();
			}
		}
	}

	public void esteenVaistoOikea2() {
		// Otetaan alkuperäinen nopeus talteen, ja asetetaan uudeksi nopeudeksi 300

		int aS = motorA.getSpeed();
		int dS = motorD.getSpeed();

		// 1. käännös, oikealle
		motorA.setSpeed(150);
		motorD.setSpeed(300);
		motorA.forward();
		motorD.forward();
		Delay.msDelay(1500);

		while (v.getRedValue() > 0.01) {
			// 2. käännös, vasemmalle
			motorD.setSpeed(185);
			motorA.setSpeed(300);
			motorA.forward();
			motorD.forward();
		}
		Sound.beep();
		motorA.stop();
		motorD.stop();
		motorD.setSpeed(300);
		motorD.forward();
		motorA.backward();
		Delay.msDelay(500);

		// Palauttaa alkuperäisen nopeuden
		motorA.setSpeed(aS);
		motorD.setSpeed(dS);
	}
}