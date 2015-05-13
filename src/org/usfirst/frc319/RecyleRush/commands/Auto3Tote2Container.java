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
public class Auto3Tote2Container extends CommandGroup {
    
    public  Auto3Tote2Container() { //BAG DAY WORKING CODE //Time: 20 seconds
      
    	//REAR ARM SHOULD BE EXTENDED BUT JUST IN CASE
    	addSequential(new RearArmExtend());
    	
    	//GRAB REAR CONTAINER
    	addSequential(new RearClawClose());
    	
    	//LIFTS REAR ARM AND GRABS REAR CONTAINER,LIFTS ELEVATOR SO TOTE CAN SLIDE UNDER
    	addParallel(new RearShoulderGoToThreeTote()); //Parallels are tied to
    	addSequential(new CollectContainer());//  the next sequential^^^ is finished=Elevator is Up
    	
    	//DRIVES FORWARD UNTIL 1st TOTE IS DETECTED  
    	
    	//AutoDriveStraightStage1 is slowed down, so the tote isn't pushed to far
    	//(P,I,D,F)= (1.0, 0.0, 0.0, 0.02) Speed = -0.85
    	
    	addSequential(new AutoDriveStraight(-0.57)); // is finished = toteready 
    	
    	//PLACES CONTAINER ONTO TOTE/DROPS ELEVATOR DOWN AND GRABS 1st TOTE    	
    	
    	addSequential(new PrepareToAquire());//"opens claw,elevator to bottom,detect, close claw"
    										// is finished  = claw is closed
    	
    	
    								//these motors are "Cold Warm"
    	
    	
    	// LIFTS 1st TOTE off the ground (So it doesn't drag as we spin)
    		addSequential(new ElevatorTwoInchPosition());
    	
    	//Lifts TO ELEVATOR to Clearance AND TURNS 180 @ THE SAME TIME
    		//AutoTurn 180 : (P,I,D,F)= (1, 0.0, 0.0, 0.02) Setpoint = 150
    		
    		addParallel(new GrabAndLiftToClearance()); 
    		addSequential(new AutoTurn180()); //is finished = isOnTarget tolerence = 1 (degree).
    								
    	//Resets encoders so it doesn't start auto correcting to "finish"
    		addSequential(new DistancePIDResetEncoders()); 
    		
    	// DRIVES FORWARD UNTIL RF's SEES 2nd TOTE
    		//AutoDriveStraight : (P,I,D,F)= (1.0, 0.0, 0.0, 0.02) Speed = -0.95	
    		//Maybe add a timeout
    		addSequential(new AutoDriveStraight(-0.63)); // is finished = istoteready

    	// OPENS CLAW AND DROPS TO FLOOR PICKUP THEN GRABS 2ND TOTE
    		addSequential(new PrepareToAquire());
    	
    	//LIFTS 2ND TOTE	
    		addSequential(new GrabAndLiftToClearance());
    							
    	// DRIVES FORWARD UNTIL RF's SEES 3rd TOTE	
    		addSequential(new AutoDriveStraight(-0.63));//is finished = claw closed
    		
    										     		
    	// OPENS CLAW AND DROPS TO FLOOR PICKUP THEN GRABS 3rd TOTE
    		addSequential(new PrepareToAquire());
    	
    	//Lifts 3rd TOTE OFF FLOOR TO REDUCE FRICTION	
    		addSequential(new GrabAndLiftToTwoInches());
    	
    	//CLOSES CLAW ROTATES 90    	
    		//AutoTurn(62) : (P,I,D,F)= (1, 0.0, 0.0, 0.02) Setpoint = 62
    		addSequential(new AutoRotate(62)); //need to check clockwise counterclockwise
    	
    	//RESETS ENCODERS BEFORE DRIVING STRAIGHT
    		addSequential(new DistancePIDResetEncoders());
    		
    	//DRIVES FORWARD INTO AUTO ZONE
    		//Sets .arcadeDrive(-1.0, 0); distance = ie- 6 Feet //(Robot.driveTrain.getDistanceFromEncoderValues()- initialDistance > 6*12)
    		addSequential(new AutoDriveForwardUntilDistanceIsReached(72.0)); // is finished = distance reached
    	
    	// OPEN TOTE CLAW, OPEN CONTAINER CLAW - SLAM!	
    		addSequential(new ContainerClawOpen());
    		addSequential(new ToteClawOpen());
    	
    	//BACK UP TWO INCHES
    		
    	
    	
    }
}