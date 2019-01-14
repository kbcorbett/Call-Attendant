/*  
 * Author Kristoffer Corbett
 * This class is used to create seat objects
 * Seats have a 2 digit designation with a letter corresponding to the column and a number designating the row
 * Seats also have a call status identifying whether the call attendant button has been pressed
*/


public class Seat {
	
	//variables are private, use getters and setters below to modify
	private String seatNumber;
	private boolean call = false;
	
	//all seats have a string designation and default to the call light as false(off)
	Seat(String newSeat) 
	{
		seatNumber = newSeat;
	}
	
	//returns the string stored as seat designation
	public String getSeatNumber()
	{
		return this.seatNumber;
	}
	
	//returns the current state of the seats call status
	public boolean getCallStatus()
	{
		return this.call;
	}
	
	//accepts 1 for true(on) and 0 for false(off) any other input results in an error message
	public void setCallStatus(int status)
	{
		if (status == 1)
			this.call = true;
		else if (status == 0)
			this.call = false;
		else
			System.out.println("Invalid status request sent for seat " + this.seatNumber + ".");
	}
	

}
