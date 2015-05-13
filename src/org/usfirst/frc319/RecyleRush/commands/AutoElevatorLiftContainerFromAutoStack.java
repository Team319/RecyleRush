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

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc319.RecyleRush.Robot;

/**
 *
 */
public class  AutoElevatorLiftContainerFromAutoStack extends Command {

    public AutoElevatorLiftContainerFromAutoStack() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.elevator);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.elevator.enableCAN();
    	//Timer.delay(.1);   2/15/15 don't know why its needed...
    	Robot.elevator.selectUpProfile();
    	Robot.elevator.liftContainerFromAutoStack();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.elevator.printEncoder();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//return false;
       return Robot.elevator.isFinished();
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.elevator.printEncoder();
    	
    //	Robot.elevator.disableCAN();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
