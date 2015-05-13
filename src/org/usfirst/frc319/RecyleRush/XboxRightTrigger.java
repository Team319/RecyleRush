package org.usfirst.frc319.RecyleRush;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class XboxRightTrigger extends Button{

	private final Joystick xboxController;
	
	public XboxRightTrigger(Joystick joystick){
			this.xboxController = joystick;

	}

public boolean get() {
	double triggerValue = xboxController.getRawAxis(3); 

	boolean pressed = false;
	
	if(triggerValue > .25){
		pressed = true;
	}
	return pressed;
	}

}
