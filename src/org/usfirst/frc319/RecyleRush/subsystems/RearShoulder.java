// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc319.RecyleRush.subsystems;

import java.security.cert.CertPathValidatorException.Reason;

import org.usfirst.frc319.RecyleRush.RobotMap;
import org.usfirst.frc319.RecyleRush.Robot;
import org.usfirst.frc319.RecyleRush.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class RearShoulder extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	
	CANTalon rearShoulderMotor = RobotMap.rearShoulderMotor;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	
	double p = 6;  //was 4
	double i = 0.001;
	double d = 2;
	double f = 0.0001;
	
	int iZone = 100; 
	double rampRate = 50;
	int profileup = 0;
	
	double pdown = 1; //was 3.5 for up motion
	double idown = 0.001;
	double ddown = 2;
	double fdown = 0.0001;
	
	int izonedown = 100;
	double rampRateDown = 24;
	int profiledown = 1;
	//============================================================
	
	double pLoadedUp = 1;  //3.5
	double iLoadedUp = 0.02;
	double dLoadedUp = 2;
	double fLoadedUp = 0.0001;
	
	double pLoadedDown = 0.1;  //3.5
	double iLoadedDown = 0.02;
	double dLoadedDown = 2;
	double fLoadedDown = 0.0001;
	
	//============================================================
	
	double pTwoCan = 6;  //was 4
	double iTwoCan = 0.001;
	double dTwoCan = 2;
	double fTwoCan = 0.0001;
	
	
	
	//Rear Shoulder Tote Scoring Heights
	public double ground = -2538; // old arm = -400
	public double autoPickup = -2000;   //used to be 0
	
	public double fallenContainer =-60;//needs to be adjusted
	public double oneTote = -1964;//just a guess was 360
	public double stepHeight = 100; // TEST ME
	public double twoTote = -1675;// old -->360
	public double threeTote = -1400;//old -->1007
	public double fourTote = -1160;// was 1251
	public double fiveTote = -900;
	public double sixTote = -295;
	public double storageHeight = 0;
	
	public double topSoftLimitOffset = 200;
	public double bottomSoftLimitOffset = 100;
	
	public double storageHeightSoftLimit = storageHeight - topSoftLimitOffset;
	public double groundSoftLimit = ground + bottomSoftLimitOffset;
	
	public double rangeOfMotionTilted = 355;
	
	public double maxHeightWhileTilted = -1200;
	
	public double shoulderHoldPosition = 0;
	public double twoCanGrabHeight = -1587;
	
	public double clawAutoCloseHeight = -1750;
	public double chainLoweredMinHeight = -1850;
	
	
	public RearShoulder() {
		
	    // Put methods for controlling this subsystem
	    // here. Call these from Commands.
		  
		rearShoulderMotor.changeControlMode(ControlMode.Position);
		//rearShoulderMotor.changeControlMode(controlMode.);
		rearShoulderMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		rearShoulderMotor.setPID(p, i , d, f, iZone, rampRate, profileup);
		rearShoulderMotor.setPID(pdown, idown, ddown, fdown, izonedown, rampRateDown, profiledown);
		rearShoulderMotor.reverseSensor(false);//was true 
		rearShoulderMotor.reverseOutput(true); 
	
		rearShoulderMotor.enableLimitSwitch(true, true);
	}

    public void initDefaultCommand() {
    	
        setDefaultCommand(new RearShoulderManualDrive());
        
    }
    
    public void goToTop(){
    	rearShoulderMotor.set(725);
    	//System.out.println("Encoder = "+cANTalon.getEncPosition());
    	//System.out.println("current = "+cANTalon.getOutputCurrent());
    }
    public void goToBottom(){
    	smartSelectPIDConstants(true, ground);
    	rearShoulderMotor.set(ground);
    }
    
    public void goToAutoPickup(){
    	smartSelectPIDConstants(true, autoPickup);
    	rearShoulderMotor.set(autoPickup);
    	//System.out.println("Encoder = "+cANTalon.getEncPosition());
    	//System.out.println("current = "+cANTalon.getOutputCurrent());
    }
    
    public void goToFallenContainer(){
    	//smartSelectPIDConstants(Robot.rearClaw.isClawClosed(), fallenContainer);
    	rearShoulderMotor.set(fallenContainer);
    }
    
    public void goToOneTote(){
    	smartSelectPIDConstants(true, oneTote);
    	rearShoulderMotor.set(oneTote);
    }
    public void goToStepHeight(){
    	smartSelectPIDConstants(true, twoTote);
    	rearShoulderMotor.set(stepHeight);
    	
    }
    
    public void goToTwoTote(){
    	smartSelectPIDConstants(true, twoTote);
    	rearShoulderMotor.set(twoTote);
    	
    }

    public void goToTwoCanGrabHeight(){
    	smartSelectPIDConstants(true, twoTote);
    	rearShoulderMotor.set(twoCanGrabHeight);
    	
    }
    
    public void goToThreeTote(){
    	
    	smartSelectPIDConstants(true, threeTote);
    	rearShoulderMotor.set(threeTote);
    }
    
    public void goToFourTote(){
    	smartSelectPIDConstants(true, fourTote);
    	rearShoulderMotor.set(fourTote);
    	
    }
    public void goToFiveTote(){
    	smartSelectPIDConstants(true, fiveTote);
    	rearShoulderMotor.set(fiveTote);
    	
    }
    
    public void goToSixTote(){
    	smartSelectPIDConstants(true, sixTote);
    	rearShoulderMotor.set(sixTote);
    	
    }
    public void goToStorageHeight(){
    	smartSelectPIDConstants(true, storageHeight);
    	rearShoulderMotor.set(storageHeight);
    	
    }
    public void driveRearShoulderDown(double counter){
    	rearShoulderMotor.set(counter);
    }
    public void driveRearShoulderUp(double counter){
    	rearShoulderMotor.set(counter);
    }
    
    public void scoreContainer(){
    	//rearShoulderMotor.set(Robot.rearShoulder.rearShoulderMotor.getSetpoint() - 100);
    } // TEST ME NOAR
    
    public void spin(){// don't use this
    	rearShoulderMotor.set(6);
    	}

    public void stop() {
    	//Robot.motor.cANTalon.set();
    	//Robot.elevator2.cANTalon.getEncPosition();
    	System.out.println("IS TOP SWITCH CLOSED = "+ rearShoulderMotor.isFwdLimitSwitchClosed());
    	System.out.println("IS Bottom SWITCH CLOSED = "+ rearShoulderMotor.isRevLimitSwitchClosed());
    	
    }
    public boolean getRearShoulderTopLimit(){
    	return rearShoulderMotor.isFwdLimitSwitchClosed();
    }
    
    public boolean getRearShoulderBottomLimit(){
    	return rearShoulderMotor.isRevLimitSwitchClosed();
    }
    
    
    
    
    public boolean isFinished(){
    	double error = rearShoulderMotor.getEncPosition()-rearShoulderMotor.getSetpoint();
    	//System.out.println("Setpoint = "+ elevatorMotorLead.getSetpoint());	
    	//int error = elevatorMotorLead.getClosedLoopError();
    	shoulderHoldPosition = rearShoulderMotor.getEncPosition(); //this updates the "manualDrive's "lastPosition" so that
    																//when the command finishes, it doesn't go to the last
    																//position we manually drove it too.
    	
    	if(getRearShoulderBottomLimit() && error < 0){
    		rearShoulderMotor.setPosition(0);
    		//System.out.println("Bottom limit switch hit - Elevator position set to zero");
    		return true;
    	
    	}
    	else if (error<50 && error>-50){
    		//System.out.println("Acheived Position, Error =" + error);
    		return true;
    	}
    	else{
    		//System.out.println("Position Not Reached, Error = "+ error);
    		return false;
		}
	}
    
	public boolean autoIsFinished(){
    	double error = rearShoulderMotor.getEncPosition()-rearShoulderMotor.getSetpoint();
    	//System.out.println("Setpoint = "+ elevatorMotorLead.getSetpoint());	
    	//int error = elevatorMotorLead.getClosedLoopError();
    	if (error<200 && error>-200){
    	//	System.out.println("Acheived Position, Error =" + error);
    		return true;
    	}else{
    		//System.out.println("Position Not Reached, Error = "+ error);
    		return false;
    	
    	}
    }
    	
	public int encoderPositionForDrive(){
    	//return Robot.elevator.elevatorMotorLead.getEncPosition();
    	return Robot.rearShoulder.rearShoulderMotor.getEncPosition();
    }
    	
    public void printEncoder(){
    	System.out.println("RearShoulder= "+rearShoulderMotor.getPosition());
    }
    public void resetEncoder(){
    	rearShoulderMotor.setPosition(0);
    }
    public double encoderPosition(){
    	return rearShoulderMotor.getEncPosition();
    }
    public double getSetpoint(){
    	return rearShoulderMotor.getSetpoint();
    }
   
    
    public void selectUpProfile(){
    	rearShoulderMotor.setProfile(profileup);
    }
    public void selectDownProfile(){
    	rearShoulderMotor.setProfile(profiledown);
    }
    public void selectLoadedUpPIDConstants(){
    	rearShoulderMotor.setPID(pLoadedUp,iLoadedUp,dLoadedDown);
    }
    public void selectLoadedDownPIDConstants(){
    	rearShoulderMotor.setPID(pLoadedDown,iLoadedDown,dLoadedDown);
    }
    public void selectUnloadedUpPIDConstants(){
    	rearShoulderMotor.setPID(p,i,d);
    }
    public void selectUnloadedDownPIDConstants(){
    	rearShoulderMotor.setPID(pdown,idown,ddown);
    }
    public void smartSelectPIDConstants(boolean bClawClosed, double desiredPosition){
    	double directionError = rearShoulderMotor.getEncPosition()- desiredPosition;
    	
    	if(directionError < 0){
    		selectUpProfile();
    		System.out.println("Selected Up Profile");
    	}
    	else{
    		selectDownProfile();
    		System.out.println("Selected Down Profile");
    	}
    	/*
    	if(bClawClosed){// Use Loaded Constants
    		if(directionError < 0){ //Going up
    			selectLoadedUpPIDConstants(); 
    			System.out.println("Using RearShoulder Loaded Up Constants");
    		}
    		else{ //Going Down
    			selectLoadedDownPIDConstants();
    			System.out.println("Using RearShoulder Loaded Down Constants");
    		}
    	}
    	else{ // Use Unloaded Constants
    		if(directionError < 0){ //Going Up
    			selectUnloadedUpPIDConstants();
    			System.out.println("Using RearShoulder UnLoaded Up Constants");
    		}
    		else{ //Going Down
    			selectUnloadedDownPIDConstants();
    			System.out.println("Using RearShoulder Loaded Down Constants");
    		}
    	}*/
    }
    public double getError(){
    	double error = rearShoulderMotor.getEncPosition()-rearShoulderMotor.getSetpoint();
    	return error;
    }
    
    public void manualDrive(){
    	double yAxisValue = -Robot.oi.xboxController2.getRawAxis(5);
    	
    	//System.out.println("yAxisValue = "+ yAxisValue);
    	
    	if(yAxisValue < 0.1 && yAxisValue > -0.1){								//FIX ME SO I CANRIVE PAST 0 TO FIX MYSELF -A Flustered Eric...
    		
    		rearShoulderMotor.changeControlMode(ControlMode.Position);
    		rearShoulderMotor.set(shoulderHoldPosition);
    		
    		//System.out.println("In controlMode.Position");
    	}
    	else{
    		rearShoulderMotor.changeControlMode(ControlMode.PercentVbus);
    		double currentPosition = rearShoulderMotor.getEncPosition();
    		
    		//Automatically Raise Arm Above safeHeight
    		if(currentPosition >= maxHeightWhileTilted && Robot.rearArm.isLowered() && !Robot.rearClaw.isClawClosed()){
    			
    			Robot.rearArm.chainRaise();
    		}
    		//Automatically raise arm earlier if claw is closed
    		else if(currentPosition >= (maxHeightWhileTilted- 100) && Robot.rearArm.isLowered() && Robot.rearClaw.isClawClosed()){
    			
    			Robot.rearArm.chainRaise();
    		} 
    		//Automatically Closes the claw at a certain height.
    		else if(currentPosition <= clawAutoCloseHeight && Robot.rearArm.isLowered() && !Robot.rearClaw.isClawClosed() && yAxisValue < 0){
    			Robot.rearClaw.close();
    		}
    		
    		// Top Cushion
    		if(currentPosition >= storageHeightSoftLimit && yAxisValue > 0){
    			double distanceFromHardLimit = Math.abs(currentPosition - storageHeight);
    			double maxYAxisOutput = (distanceFromHardLimit/topSoftLimitOffset);//*(distanceFromHardLimit/topSoftLimitOffset);
    			
    			if(yAxisValue > maxYAxisOutput){
    				yAxisValue = maxYAxisOutput;
    			}
    			
    			//System.out.println("TopCushion Active");
    		}
    		//Bottom Cushion
    		else if(currentPosition <= groundSoftLimit && yAxisValue < 0){
    			double distanceFromHardLimit = Math.abs(currentPosition - ground);
    			double maxYAxisOutput = -(distanceFromHardLimit/bottomSoftLimitOffset);//*(distanceFromHardLimit/bottomSoftLimitOffset);
    			
    			if(yAxisValue < maxYAxisOutput){
    				yAxisValue = maxYAxisOutput;
    			}
    			//System.out.println("GroundCushion Active");
    			
    		}
    		//Don't go below the minimum height while lowered
    		if(currentPosition <= chainLoweredMinHeight && Robot.rearArm.isLowered() && yAxisValue < 0){
    			yAxisValue = 0;
    		}
    		
    		//System.out.println("Moving motor @ " + yAxisValue);
    		rearShoulderMotor.set(-yAxisValue);
    		
    		currentPosition = rearShoulderMotor.getEncPosition();
    		shoulderHoldPosition = currentPosition;
    		//System.out.println("In controlMode.PercentVBus");
    	}
    	
    	
    	
    	
    	//rearShoulderMotor.s
    }
    public void setPID(double p, double i, double d){
		rearShoulderMotor.setPID(p, i, d);
	}
    
    public void setTwoCanPIDValues(){
    	setPID(pTwoCan, iTwoCan, dTwoCan);
    }
}

