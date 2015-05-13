package org.usfirst.frc319.RecyleRush;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DpadLeft extends Button{

	private final Joystick xboxController;
	
	public DpadLeft(Joystick joystick){
			this.xboxController = joystick;

	}

public boolean get() {
	double Dpad = xboxController.getPOV(); 

	boolean pressed = false;
	
	if(Dpad == 270){
		pressed = true;
	}
	return pressed;
	}

}
