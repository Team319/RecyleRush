package org.usfirst.frc319.RecyleRush;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DpadRight extends Button{

	private final Joystick xboxController;
	
	public DpadRight(Joystick joystick){
			this.xboxController = joystick;

	}

public boolean get() {
	double Dpad = xboxController.getPOV(); 

	boolean pressed = false;
	
	if(Dpad == 90){
		pressed = true;
	}
	return pressed;
	}

}
