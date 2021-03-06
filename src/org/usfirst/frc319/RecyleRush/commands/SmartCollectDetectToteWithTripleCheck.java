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
public class  SmartCollectDetectToteWithTripleCheck extends Command {
	double threshold = 0;
	double counter = 0;
	double targetWindow = 0;
	double falseNegative = 0;
	
	
    public SmartCollectDetectToteWithTripleCheck(double range, double time) {
    	threshold = range;
    	targetWindow = time;
        requires(Robot.elevator);

        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//System.out.println("Detecting Tote");
    	Robot.elevator.setToteInCollectorState(false);
    	falseNegative = 0;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(Robot.elevator.isToteWithinRange(threshold)){
    		counter++;
    		falseNegative = 0;
    		//System.out.println("I've seen the Tote " + counter + " times");
    	}
    	else{
    		//System.out.println("Tote not within Threshold");
    		falseNegative = 1;
    		//return; // ??? maybe? I just want it to go into the "isFinished" to check counter status   Else statement may be unnecessary
    	}
    	
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(falseNegative ==1){
    		//System.out.println("False reading seen:Reset Counter");
    		counter = 0;
    		falseNegative = 0;
    		return false;
    	} 
    	
    	if(counter < targetWindow){// if the counter hasn't seen the tote three times, command continues to loop    set 200 to target window later
    		System.out.println("counter = "+ counter);
    		return false;   // FOR TESTING SET COUNTER VALUE TO A MUCH HIGHER #
    	}
    	
    	else{ // else the command resets the counter and finishes.
    		System.out.println("I saw a tote and have reset counter");
    		counter = 0;
    		return true;
    		
    	}
    	
    	 
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.setToteInCollectorState(true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
