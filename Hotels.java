
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;

// view
public class Hotels {

	public static void hotelReservation(ArrayList <HotelsModel> reservations, ArrayList <HotelsModel2> list) throws FileNotFoundException {
		
		Scanner in = new Scanner(System.in);
		
		File myFile = new File("reservations.txt"); // creates file
		
		String hotelName, hotelLocation;
		
		System.out.println("Hotel Name: ");
		hotelName = in.next();
		System.out.println("Hotel Location: ");
		hotelLocation = in.next();

		boolean a = false; // returns true if the hotel searched for is located at the location entered. 
		
		while(!a) {
			for (HotelsModel2 i : list)	// runs through the hotels list to check if the user input matches. 
			{
				if(i.getHotels().equals(hotelName) && i.getLocations().equals(hotelLocation)) {
					a = true;
				}			
				else{}
			}
			
			if(!a) // asks the users to enter the hotel name and location again if not found. 
			{
			System.out.println("Hotel not found at the location entered.");
			System.out.println("Hotel Name: ");
			hotelName = in.next();
			System.out.println("Hotel Location: ");
			hotelLocation = in.next();	
			}
		}
			
		System.out.println("Hotel: " + hotelName + "   Location: " + hotelLocation);
		
		int choice, singleRooms, doubleRooms, checkInDate, checkInMonth, checkOutMonth, checkOutDate;
		String name;
		int reservationID = 0; double price=0;
		
	   // menu for the hotel the user chose. 
	do {	
		System.out.println("\n1. Make Hotel Reservation");
		System.out.println("2. Search for a Hotel Reservation");
		System.out.println("3. Cancel Hotel Reservation");
		System.out.println("4. Main Menu");
		choice = in.nextInt();
	
		switch(choice) { 
		case 1: // make a reservation

			System.out.println("Enter a name for the reservation: ");
			name = in.next();
			
			System.out.println("Reservations open from May to December 2019.");
			System.out.println("Check in month(1-12): ");
			checkInMonth = in.nextInt(); 
			
			while(checkInMonth < 5 || checkInMonth > 12) { // checks if the check in month entered is in the past. 
				System.out.println("Error: Invalid Month. Enter again: ");
				checkInMonth = in.nextInt();
			}

			System.out.println("Check in date(1-31): "); 
			checkInDate = in.nextInt(); 
			
			if(checkInMonth == 5) { // checks if the check in date entered is in the past. 
				while(checkInDate < 15 || checkInDate > 30)	{
					System.out.println("Error: Invalid Date. Enter again: ");
					checkInDate = in.nextInt();
					}
			}
			else { // checks if the date is valid based on the month entered. 
				if(checkInMonth % 2 == 0) {
					while(checkInDate < 0 || checkInDate > 30) {
						System.out.println("Error: Invalid Date. Enter again: ");
						checkInDate = in.nextInt();
						}
					}
				
				if(checkInMonth % 2 != 0) { // checks if the date is valid based on the month entered. 
					while(checkInDate < 0 || checkInDate > 31) {
						System.out.println("Error: Invalid Date. Enter again: ");
						checkInDate = in.nextInt();
						}
					}
				}
				
			System.out.println("Check out month(1-12): ");
			checkOutMonth = in.nextInt(); 
			
			while(checkOutMonth < 5 || checkOutMonth > 12) { // checks for check out month in the past or if invalid. 
				System.out.println("Check out month cannot be in the past. Enter again: ");
				checkOutMonth = in.nextInt();
			}
			
			while(checkOutMonth < checkInMonth)	{ // checks is the check out month is before check in month. 
				System.out.println("Check out month cannot be in the past. Enter again: ");
				checkOutMonth = in.nextInt();
			}
			
			System.out.println("Check out date(1-31): ");
			checkOutDate = in.nextInt(); 
				
			if(checkInMonth == checkOutMonth){ // checks if the date is valid based on the month entered. 
				while(checkOutDate < checkInDate || checkOutDate > 30){
					System.out.println("Error: Invalid Date. Enter again: ");
					checkOutDate = in.nextInt();
				 }
			}
			else if(checkOutMonth == 5) { // checks if the date is valid based on the check in date entered. 
				while(checkOutDate < checkInDate || checkOutDate > 30){
					System.out.println("Error: Invalid Date. Enter again: ");
					checkOutDate = in.nextInt();
				 	}
				}
			
			else { // checks if the date is valid based on the month entered. 
				if(checkOutMonth % 2 == 0) {
					while(checkOutDate < 0 || checkOutDate > 30) {
						System.out.println("Error: Invalid Date. Enter again: ");
						checkOutDate = in.nextInt();
					}
				}
				if(checkOutMonth % 2 != 0)	{ // checks if the date is valid based on the month entered. 
					while(checkOutDate < 0 || checkOutDate > 31) {
						System.out.println("Error: Invalid Date. Enter again: ");
						checkOutDate = in.nextInt();
						}
					}
				}	
			
			System.out.println("Single Rooms: ");;
			singleRooms = in.nextInt(); 
			
			int choice2;
			boolean b = false;
			
			while(!b) { // checks if enough single rooms are available in the hotel 
				for(HotelsModel2 i : list) {
					if(hotelName.equals(i.getHotels())) {
						if(singleRooms < i.getMaxSingleRooms()) {
							b = true;
						}
						else{}	
					}
					else {}
				}
				
				if(!b)
				{
				System.out.println("Requested rooms exceed the total numbers of rooms in the hotel.");
				System.out.println("1. Enter a different number of rooms.");
				System.out.println("2. Exit.");
				choice2 = in.nextInt();
					if(choice2==1)
					{
						System.out.println("Single Rooms: ");;
						singleRooms = in.nextInt(); 
					}
					else if(choice2==2)
					{
						singleRooms = 0;
						break;
					}
				}
			} // while(!b) closes

			boolean d = false; 			
			
			int emptySingleRooms = 0, totalBookedSingleRooms = 0, choice4;
		
			for(int i = 0; i < reservations.size(); i++) { // calculates the total number of single rooms already booked
				totalBookedSingleRooms = totalBookedSingleRooms + reservations.get(i).getSingleRooms();
			}
							
			while(!d) { // checks if the number entered is not more than maximum rooms 
			for(int i = 0; i < reservations.size(); i++) {
				if(!(checkInMonth == reservations.get(i).getCheckInMonth() && checkInDate == reservations.get(i).getCheckInDate()
						&& checkOutMonth == reservations.get(i).getCheckOutMonth() && checkOutDate == reservations.get(i).getCheckOutDate())) {
					d = true;
				}	
			}
			
			if(!d) {						
				for(HotelsModel2 i : list) {
					if(hotelName.equals(i.getHotels())) {
					emptySingleRooms = i.getMaxSingleRooms() - totalBookedSingleRooms;
					}
				}
			
				System.out.println(singleRooms);
				if(singleRooms > emptySingleRooms) {
					System.out.println("Enough rooms not available.");	
					System.out.println("1. Enter a different number of rooms.");
					System.out.println("2. Exit.");
					choice4 = in.nextInt();
					if(choice4==1) {
						System.out.println("Single Rooms: ");;
						singleRooms = in.nextInt(); 
					}
					else if(choice4==2) { // the user will be taken back to the hotel menu
						singleRooms = 0;
						break;
					}
				}	
				else{
					d = true;
				}
				}
			} // while(!d) closes; 

			System.out.println("Double Rooms: ");;
			doubleRooms = in.nextInt(); 
					
			int choice3;
			boolean c = false;
			
			while(!c) { // checks if the number entered is not more than maximum rooms 
				for(HotelsModel2 i : list) {
					if(hotelName.equals(i.getHotels())) {
						if(doubleRooms < i.getMaxDoubleRooms()) {
							c = true;
						}
						else{}	
					}
					else {}
				}
					 
				if(!c) 
					{
					System.out.println("Enough rooms not available.");
					System.out.println("1. Enter a different number of rooms.");
					System.out.println("2. Exit.");
					choice3 = in.nextInt();
						if(choice3==1) {
							System.out.println("Double Rooms: ");;
							doubleRooms = in.nextInt(); 
						}
						else if(choice3==2) { // takes the user back to the hotel menu
							doubleRooms = 0; 
							break;
						}
					}
			}
			
			boolean e = false; int totalBookedDoubleRooms = 0, emptyDoubleRooms = 0, choice5;
				
			for(HotelsModel i : reservations) {
				totalBookedDoubleRooms = totalBookedDoubleRooms + i.getDoubleRooms();
			}	
			
			while(!e) {  // checks if there are enough double rooms available on the dates entered 
				for(HotelsModel i : reservations) {
					if(!(checkInMonth == i.getCheckInMonth() && checkInDate == i.getCheckInDate() && checkOutMonth == i.getCheckOutMonth() 
							&& checkOutDate == i.getCheckOutDate())) 	{
						e = true;
					}				
				}			
				if(!e) {						
					for(HotelsModel2 i : list) {
						if(hotelName.equals(i.getHotels())) {
						emptyDoubleRooms = i.getMaxDoubleRooms() - totalBookedDoubleRooms;
						}
					}
					if(doubleRooms > emptyDoubleRooms) {
						System.out.println("Enough rooms not available.");	
						System.out.println("1. Enter a different number of rooms.");
						System.out.println("2. Exit.");
						choice5 = in.nextInt();
						if(choice5==1) {
							System.out.println("Double Rooms: ");;
							doubleRooms = in.nextInt(); 
						}
						else if(choice5==2) { // takes the user back to the hotel menu
							doubleRooms = 0;
							break;
						}
					}	
					else {
						e = true;
					}
				}
			}
	
			if(!(singleRooms == 0 && doubleRooms == 0)) { // if the user decides to exit out of the case because of not enough rooms, it will stop here.				
				
				for(int i = 0; i <= reservations.size(); i++) // assigns reservation number
				{
					if(i == reservations.size())
					{
					int j = reservations.get(i-1).getReservationID();
					reservationID = j + 1;
					}
				}
				
			int days; 
			for(HotelsModel2 i : list) { 
				if(hotelName.equals(i.getHotels())) {
					price = (singleRooms * i.getSingleRate()) + (doubleRooms * i.getDoubleRate());
				}
				else {}
			}
			
			HotelsModel A1 = new HotelsModel (hotelName, hotelLocation, name, checkInMonth, checkInDate, checkOutMonth, checkOutDate, singleRooms, doubleRooms, reservationID, price);
			reservations.add(A1);
			
			
			for(HotelsModel i : reservations) {				
				if(reservationID == i.getReservationID()) {
					days = i.getDays();
					System.out.println("Number of days: " + days);
					System.out.println("Total Price: " + i.getPrice());
				}
			}
			
			System.out.println("Your reservation number is: " + reservationID);
			
			try { 
			PrintWriter writer = new PrintWriter("reservations.txt"); // writes the data to the file	
			reservations.forEach(i -> { // lambda expression
				writer.println();
				writer.println("Name: " + i.getName());
				writer.println("Hotel: " + i.getHotelName());
				writer.println("Location: " + i.getHotelLocation());
				writer.println("Check In Date: " + i.getCheckInMonth() + "/" + i.getCheckInDate());
				writer.println("Check Out Date: " + i.getCheckOutMonth() + "/" + i.getCheckOutDate());
				writer.println("Rooms: " + i.getSingleRooms() + " single, " + i.getDoubleRooms() + " double ");
				writer.println("ReservationID: " + i.getReservationID());
			});
			writer.close();
			}			
			catch (FileNotFoundException f) {
				f.printStackTrace();
			}
			}
			else {}
			
			Payment.makePayment(reservations); // calls the payment method for payment

			break;
	
		case 2:	// searches for a hotel reservation
			int searchRes;
			System.out.println("Enter the Reservation ID: ");
			searchRes = in.nextInt();

			boolean search = false;
			
			for(HotelsModel i : reservations) {
				if(searchRes == i.getReservationID()) { // checks for the reservation using the reservation number
					System.out.println("Name: " + i.getName());
					System.out.println("Hotel: " + i.getHotelName());
					System.out.println("Location: " + i.getHotelLocation());
					System.out.println("Check In Date: " + i.getCheckInMonth() + "/" + i.getCheckInDate());
					System.out.println("Check Out Month: " + i.getCheckOutMonth() + "/" + i.getCheckOutDate());
					System.out.println("Rooms: " + i.getSingleRooms() + " single, " + i.getDoubleRooms() + " double ");
					System.out.println("ReservationID: " + i.getReservationID());
				}
					search = true;
				}
			
			if (!search)
				System.out.println("The list doesn't contain the Reservation ID entered.");
			break;
			
			
		case 3: // cancels a reservation
			System.out.println("Enter Reservation ID for cancellation: ");
			int cancelRes = in.nextInt();
		
			reservations.removeIf(i -> cancelRes == (i.getReservationID()));
			System.out.println("The reservation was cancelled.");
			
			PrintWriter writer = new PrintWriter("reservations.txt");			
			reservations.forEach(i -> { 
				writer.println("Name: " + i.getName());
				writer.println("Hotel: " + i.getHotelName());
				writer.println("Location: " + i.getHotelLocation());
				writer.println("Check In Date: " + i.getCheckInMonth() + "/" + i.getCheckInDate());
				writer.println("Check Out Date: " + i.getCheckOutMonth() + "/" + i.getCheckOutDate());
				writer.println("Rooms: " + i.getSingleRooms() + " single, " + i.getDoubleRooms() + " double ");
				writer.println("ReservationID: " + i.getReservationID());
			});
			writer.close();		
			break;
			
		case 4:
			break;	
		}
		} while(choice != 4);
	}	
}


