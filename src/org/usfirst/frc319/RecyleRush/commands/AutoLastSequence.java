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
public class AutoLastSequence extends CommandGroup {
    
    public  AutoLastSequence() {
    	
    	//DRIVES BACKWARD INTO AUTO ZONE
    	addSequential(new DistancePIDResetEncoders());
    	//addParallel(new AutoFinalizeStack());
		addSequential(new AutoDriveStraightBackwardToDistance(1.0,-85.0)); //was 90 
		
		//TURN RIGHT, TO BRING TOTES AND REAR CONTAINER INTO ZONE
		//addSequential(new AutoRotate(107.5));
		
		//addSequential(new AutoDriveStop(0.5));  
		
		//DROP ALL THE THINGS AND BACK AWAY
		addParallel(new ToteClawOpen());
		addParallel(new ContainerClawOpen());
		addParallel(new ActiveCollectorOpen());
		addSequential(new DistancePIDResetEncoders());
		addSequential(new AutoDriveStraightBackwardToDistance(0.75, -12.0));
    } 
}
