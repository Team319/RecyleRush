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

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc319.RecyleRush.Robot;

/**
 *
 */
public class  AutoDriveForwardUntilDistanceIsReached extends Command {

	double initialDistance = 0;
	double desiredDistance = 0;
    public AutoDriveForwardUntilDistanceIsReached(double inches) {
    
    	desiredDistance = inches;
    	requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initialDistance = Robot.driveTrain.getDistanceFromEncoderValues();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//double moveValue = Robot.oi.xboxController.getRawAxis(1);
    	//double rotateValue = Robot.oi.xboxController.getRawAxis(4);
    	Robot.driveTrain.manualArcadeDrive(-0.7, 0);
    	//Robot.driveTrain.printEncoders();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Robot.driveTrain.getDistanceFromEncoderValues()- initialDistance > desiredDistance){
        	return true;	
        }  
        else 
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}