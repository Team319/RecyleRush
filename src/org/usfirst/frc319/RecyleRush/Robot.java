// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc319.RecyleRush;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;










//import org.usfirst.frc319.PIDDrivetrain.Robot;
import org.usfirst.frc319.RecyleRush.commands.*;
import org.usfirst.frc319.RecyleRush.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;
    SendableChooser autoChooser;

    public static OI oi;
   
    public static DriveTrain driveTrain;
    public static RearClaw rearClaw;
    public static RearArm rearArm;
    public static PnuematicSystem pnuematicSystem;
    public static RearShoulder rearShoulder;
    public static Elevator elevator;
    public static ToteClaw toteClaw;
    public static ContainerClaw containerClaw;
    //public static DistancePID distancePID;;
    //public static RotationPID rotationPID;;
    public static ActiveCollector activeCollector;
    public static ToteLights toteLights;
    
    
    
    
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	RobotMap.init();

        driveTrain = new DriveTrain();
        rearClaw = new RearClaw();
        rearArm = new RearArm();
        pnuematicSystem = new PnuematicSystem();
        rearShoulder = new RearShoulder();
        elevator = new Elevator();
        toteClaw = new ToteClaw();
        containerClaw = new ContainerClaw();
        //distancePID = new DistancePID();
        //rotationPID = new RotationPID();
         activeCollector = new ActiveCollector();
         toteLights = new ToteLights();
         
        
        
        
        

        // OI must be constructed after subsystems. If the OI creates Commands 
        //(which it very likely will), subsystems are not guaranteed to be 
        // constructed yet. Thus, their requires() statements may grab null 
        // pointers. Bad news. Don't move it.
       
        
        oi = new OI();

        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        
        //MAYBE WE DONT NEED THIS HERE IF TRYING TO IMPLEMENT THE CHOOSER IN SMARTDASH
       
        //OLD AUTO "Constructor" vvvvvv
       // autonomousCommand = new FullAuto();   //ctrl+C me    = new FullAuto();
        autoChooser = new SendableChooser();
        autoChooser.addDefault("3 Tote 2 RC Auto", new FullAuto());
        autoChooser.addObject("Two Can Auto",new AutoTwoCan());
        autoChooser.addObject("AutoDoNothing", new AutoDoNothing());
       // autoChooser.addDefault("ToteClawOpen", new ToteClawOpen());
       //   autoChooser.addObject("ToteClawClose",new ToteClawClose());
        
        
        SmartDashboard.putData("Auto Chooser", autoChooser);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        Robot.rearShoulder.shoulderHoldPosition = Robot.rearShoulder.encoderPosition();
        Robot.elevator.elevatorHoldPosition = Robot.elevator.encoderPosition();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)    
    	//VVV is the old one...
       // if (autonomousCommand != null) autonomousCommand.start();
   
    // this should make a selection in smartdash for auto...
    	//the 2tote 3 RC auto is "default"
   
	    autonomousCommand = (Command) autoChooser.getSelected();
	    autonomousCommand.start();    
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
        Robot.rearShoulder.shoulderHoldPosition = Robot.rearShoulder.encoderPosition();
        Robot.elevator.elevatorHoldPosition = Robot.elevator.encoderPosition();
        //Robot.driveTrain.printDegreesFromEncoderValues();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        //initializes the toggle switch to be closed
        Robot.oi.ybuttonState=true;
      
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        //System.out.println(Robot.oi.xboxController.getPOV());
        
       // System.out.println("RearShoulderEncoder=" + Robot.rearShoulder.encoderPosition());
        //System.out.println("Setpoint="+ Robot.rearShoulder.getSetpoint());
        
        // System.out.println("LeftTrigger=" +Robot.oi.xboxController.getRawAxis(2));
        //System.out.println("RightTrigger=" +Robot.oi.xboxController.getRawAxis(3));
        
        SmartDashboard.putNumber("Elevator Position", Robot.elevator.encoderPosition());
        
        SmartDashboard.putNumber("RearArm Position", Robot.rearShoulder.encoderPosition());
        
        SmartDashboard.putNumber("LeftDetector", Robot.elevator.getLeftDetectorValues());
        
        SmartDashboard.putNumber("RightDetector", Robot.elevator.getRightDetectorValues());
       
        SmartDashboard.putNumber("degrees",Robot.driveTrain.getDegreesFromEncoderValues());
        
        SmartDashboard.putNumber("LeftDistance", Robot.driveTrain.getLeftDistance());
        SmartDashboard.putNumber("RightDistance", Robot.driveTrain.getRightDistance());
      //  SmartDashboard.putNumber("FrontRFDetector", Robot.driveTrain.getForeDistance());
       // SmartDashboard.putNumber("RearRFDetector", Robot.driveTrain.getRearDistance());
        
        SmartDashboard.putBoolean("Bottom Limit Switch", Robot.elevator.bottomLimitSwitch());
        
        SmartDashboard.putBoolean("Top Limit Switch", Robot.elevator.topLimitSwitch());
        
        SmartDashboard.putNumber("Lead Motor Current", Robot.elevator.getLeadMotorCurrent());
        SmartDashboard.putNumber("Follow Motor Current", Robot.elevator.getFollowMotorCurrent());
        SmartDashboard.putNumber("Elevator Current Diff", Robot.elevator.getCurrentDifference());
        
        SmartDashboard.putNumber("Lead Motor Voltage", Robot.elevator.getLeadMotorVoltage());
        SmartDashboard.putNumber("Follow Motor Voltage", Robot.elevator.getFollowMotorVoltage());
        SmartDashboard.putNumber("Elevator Voltage Diff", Robot.elevator.getVoltageDifference());
        
        SmartDashboard.putBoolean("TopSwitch", Robot.rearShoulder.getRearShoulderTopLimit());
        SmartDashboard.putBoolean("BottomSwitch", Robot.rearShoulder.getRearShoulderBottomLimit());
        
      //  Robot.driveTrain.printDegreesFromEncoderValues();
      // 	SmartDashboard.putNumber("Right Encoder", rightEncoder);
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}