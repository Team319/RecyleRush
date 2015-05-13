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
public class  AutoRearShoulderGoToStorageHeight extends Command {

    public AutoRearShoulderGoToStorageHeight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.rearShoulder);
        requires(Robot.rearArm);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.rearArm.retract();
    	Robot.rearShoulder.goToStorageHeight();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//if rear shoulder is above the value, it's safe to move forward
        return Robot.rearShoulder.encoderPosition() > -1600;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
