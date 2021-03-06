package com.austindorff.programs.calculators.grades;

import javax.swing.JOptionPane;

public class FinalGradeCalculator
{
	double currGrade = 0.0;
	double finalWeight = 0.0;
	double desiredGrade = 0.0;
	
	public FinalGradeCalculator()
	{
		currGrade = getCurrentGrade();
		finalWeight = getFinalWeight();
		desiredGrade = getDesiredGrade();
		JOptionPane.showMessageDialog(null, "You need to get a grade of " + calculateTheNeededGrade() + "% on the final to get a final grade of " + desiredGrade + "% in the class.");
	}
	
	public double getCurrentGrade()
	{
		return Double.parseDouble(JOptionPane.showInputDialog(null, "Please Enter Your Current Grade."));
	}
	
	public double getFinalWeight()
	{
		return Double.parseDouble(JOptionPane.showInputDialog(null, "Please Enter The Weight Of The Final."));
	}
	
	public double getDesiredGrade()
	{
		return Double.parseDouble(JOptionPane.showInputDialog(null, "Please Enter Your Desired Final Grade In The Class."));
	}
	
	public double calculateTheNeededGrade()
	{
		double neededDifference = desiredGrade - (currGrade * ((100 - finalWeight)/100));
		return neededDifference / (finalWeight / 100);
	}
}