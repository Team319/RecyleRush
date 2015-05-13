package org.usfirst.frc319.RecyleRush;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class XboxLeftTrigger extends Button{

	private final Joystick xboxController;
	
	public XboxLeftTrigger(Joystick joystick){
			this.xboxController = joystick;

	}

public boolean get() {
	double triggerValue = xboxController.getRawAxis(2); 

	boolean pressed = false;
	
	if(triggerValue > .25){
		pressed = true;
	}
	return pressed;
	}

}
