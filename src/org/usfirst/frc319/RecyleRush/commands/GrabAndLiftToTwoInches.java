// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc319.RecyleRush.commands;
import org.usfirst.frc319.RecyleRush.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GrabAndLiftToTwoInches extends CommandGroup {
    
    public  GrabAndLiftToTwoInches() {
        
    	
    	addSequential(new ToteClawClose());
    	addSequential(new ElevatorTwoInchPosition());
    	
    	//addSequential(new IncrementToteCount()); //Normally adds to totecounter. MOVED INTO COMMAND GROUP** Eric's note - I did this without testing!
    	//Robot.elevator.numberOfTotesPossessed++;
    	//System.out.println("I have "+Robot.elevator.numberOfTotesPossessed+" Totes.");
    }
}
