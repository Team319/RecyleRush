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
import org.usfirst.frc319.RecyleRush.subsystems.ActiveCollector;

/**
 *
 */
public class  ActiveCollectorAlignTote extends Command {

	public double farThreshold = 4.25;
	public double closeThreshold = 3.75;
	
	
	public double leftValue = 0;
	public double rightValue = 0;
    public ActiveCollectorAlignTote() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);    	
    	requires(Robot.activeCollector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Aligning Tote");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	leftValue = Robot.elevator.getLeftDetectorValues();
    	rightValue = Robot.elevator.getRightDetectorValues();
    	
    	//System.out.println("Left Detector: "+ leftValue +" Right Detector: "+ rightValue);
    	
    	if( rightValue > farThreshold && leftValue > farThreshold){   // ALL 5.5's used to just be 5's
    		Robot.activeCollector.collectRight(.7);
    		Robot.activeCollector.collectLeft(.7);
    	}else if(rightValue > farThreshold){
    		Robot.activeCollector.collectRight(.5);
    		Robot.activeCollector.collectLeft(0);
    	}else if(leftValue > farThreshold){
    		Robot.activeCollector.collectLeft(.5);
    		Robot.activeCollector.collectRight(0);
    	}else if( rightValue < closeThreshold && leftValue < closeThreshold){   // ALL 5.5's used to just be 5's
    		Robot.activeCollector.collectRight(-0.5);
    		Robot.activeCollector.collectLeft(-0.5);
    	}else if(rightValue < closeThreshold){
    		Robot.activeCollector.collectRight(-.5);
    		Robot.activeCollector.collectLeft(0);
    	}else if(leftValue < closeThreshold){
    		Robot.activeCollector.collectLeft(-.5);
    		Robot.activeCollector.collectRight(0);
    	}
    	
    	else{
    		Robot.activeCollector.stop(); //Stop sets the tote presence to false, will this boolean affect auto overall?
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (rightValue <= farThreshold && leftValue <= farThreshold && rightValue >= farThreshold - 0.5 && leftValue >= farThreshold - 0.5){
    		Robot.activeCollector.stop();
    		return true;
    	}
    	else
    		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.setToteInCollectorState(true);
    	Robot.activeCollector.stop();
    	System.out.println("Exiting Align Tote");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}