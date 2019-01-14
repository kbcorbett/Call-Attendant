/*
 * author Kristoffer Corbett
 * test program for seat class
 */

import java.util.Scanner;

public class CallAttendant {
	
	//Seats are stored in a 2 dimensional array with a size based on the constant columns and rows variables below.
	//If you wish to adjust the number of columns you must also add to or remove column designations in the "assignColumn" method below
	//as well as add to or remove calls to the assignColumn method in the main method. 
	static final int columns = 5;
	static final int rows = 6;
	static Seat[][] seats = new Seat[columns][rows];

	/*
	 * The main method is a simple command line interface to test the object functionality of the seat class.
	 * This method creates 6 columns and 5 rows of seats and then prompts for user input to check the functionality of the
	 * 5 seats in the first column.
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//fill array with seat objects
		assignColumn("A");
		assignColumn("B");
		assignColumn("C");
		assignColumn("D");
		assignColumn("E");
		assignColumn("F");
		
		//basic input scanner
		Scanner input = new Scanner(System.in);
		//the main menu requests integer input but accepts string to handle errors
		String selectionInput;
		//this variable holds the status of whether the main menu's input can be sucessfully parsed to an integer
		boolean goodInput;
		//used in the main menu to hold user input
		int selection;
		//used in case option 1 to hold user input
		int selectionOne;
		//this variable controls the while loop for the main menu 
		boolean cont = true;
		
		//loops main menu until user exits the program
		while(cont)
		{
			//beginnning of loop assumes user has entered bad data
			goodInput = false;
			
			//print menu
			System.out.println("");
			System.out.println("Please type an integer 1 through 4 and hit return");
			System.out.println("1. Turn on a call light");
			System.out.println("2. View light status");
			System.out.println("3. Turn off all lights");
			System.out.println("4. Exit test software");
		
			//receive user input
			selectionInput = input.nextLine();
			
			/*
			 * this try/catch block sets a variable local to the main method to true only if the user input can be successfully parsed
			 * to an int without throwing an exception
			 */
			try
			{
				Integer.parseInt(selectionInput);
				goodInput = true;
			}
			catch (Exception ex)
			{
			
			}
			
			/*
			 * checks if the parse in the try/catch was successful before performing parse. If try/catch failed default
			 * is selected in the switch statement. Any integer inputs that do not match a case provide feedback via the default
			 */
			if (goodInput)
				selection = Integer.parseInt(selectionInput);
			else
				selection = 0;
			
			//selection is based off user input in main menu
			switch (selection)
			{
			case 1:
			{
				System.out.println("Please type which seat number(1-5) to turn on");
				
				/*
				 * as abovethis try/catch block sets a variable local to the main method to true only if the user input can 
				 * be successfully parsed to an int without throwing an exception
				 */
				goodInput = false;
				selectionInput = input.nextLine();
				try
				{
					Integer.parseInt(selectionInput);
					goodInput = true;
				}
				catch (Exception ex)
				{
				}
				
				/*
				 * checks if the parse in the try/catch was successful before performing parse. If try/catch failed default
				 * is selected in the switch statement. Any integer inputs that do not match a case provide feedback via the default
				 */
				if (goodInput)
					selectionOne = Integer.parseInt(selectionInput);
				else
					selectionOne = 0;
				
			
				//if input is invalid provide feedback and break to the main menu
				if (selectionOne > 5 || selectionOne < 1)
				{
					System.out.println("Invalid Selection");
					break;
				}
				
				//align user selection(1-5) with array(0-4)
				selectionOne = selectionOne-1;
				
				//checks and provides feedback if attempting to turn on an already lit call light then breaks to main menu
				if (seats[selectionOne][0].getCallStatus() == true)
				{
					System.out.println("The call light for seat " + seats[selectionOne][0].getSeatNumber() + " is already on!");
					break;
				}
				
				//uses object setter to turn on call light. provide feedback and break to main menu
				seats[selectionOne][0].setCallStatus(1);
				System.out.println("The call light for seat " + seats[selectionOne][0].getSeatNumber() + " is now on.");
				break;
			}
			case 2:
			{
				//iterate through all five seats
				for (int i = 0; i < 5; i++)
				{
					//true if call light is on, provide feedback on status
					if (seats[i][0].getCallStatus())
						System.out.println("Seat " + seats[i][0].getSeatNumber() + "'s call light is on");
					//provide feedback on status if call light on was not true
					else
						System.out.println("Seat " + seats[i][0].getSeatNumber() + "'s call light is off");
				}
				break;
			}
			case 3:
			{
				//call method to turn off all lights
				clearLights();
				System.out.println("All call lights are now off");
				break;
			}
			case 4:
			{
				//exit while loop so program can end
				cont = false;
				break;
			}
			default:
				System.out.println("Please enter a valid selection");
				
			}
		}
		
		//exit software and close resources
		System.out.println("Thank you for texting seat objects with this software");
		System.out.println("Press return to exit");
		selectionInput = input.nextLine();
		input.close();
		
	}
	
	/*
	 * this method is used to fill the seat array with seat objects
	 * provide a column letter (A-F) as argument
	 * if you intend to modify the number of columns in the array you must add or remove if statements in this method
	 * to correspond to new column letters
	*/
	static void assignColumn(String letter)
	{
		int column = 0;
		int seatNumber = 0;
		if (letter.equals("B"))
			column = 1;
		if (letter.equals("C"))
			column = 2;
		if (letter.equals("D"))
			column = 3;
		if (letter.equals("E"))
			column = 4;
		if (letter.equals("F"))
			column = 5;
			
		for (int i = 0; i < columns; i++)
		{
			seatNumber = i+1;
			seats[i][column] = new Seat(letter + seatNumber);
		}
	}
	
	//this method sets the call light status of all seats in the array to off
	static void clearLights()
	{
		for (int i = 0; i < columns; i++)
		{
			for (int j = 0; j < rows; j++)
			{
				seats[i][j].setCallStatus(0);
			}
		}
	}

}
