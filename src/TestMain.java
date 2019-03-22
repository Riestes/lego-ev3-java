// Projektin p‰‰luokka, josta k‰ynnistet‰‰n s‰ikeet

//import java.awt.Image;

import lejos.hardware.*;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class TestMain {

	public static void main(String[] args) {

		// Alustetaan
		Valosensori valo = new Valosensori();
		UltraSonicSensor ultra = new UltraSonicSensor();
		Soitin soitin = new Soitin();
		Moottorit moottorit = new Moottorit(valo, ultra, soitin); 
		
		Thread saieMotor = new Thread(moottorit);
		Thread saieSoitin = new Thread(soitin);

		LCD.drawString("Kaynnista", 1, 1);
		LCD.drawString("painamalla:", 2, 2);
		LCD.drawString("enter", 3, 3);

		Button.waitForAnyPress();
		Delay.msDelay(1000);
		LCD.clear();
		
		saieMotor.start();
		saieSoitin.start();
	}
}