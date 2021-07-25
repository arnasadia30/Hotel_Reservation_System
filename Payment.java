import java.util.ArrayList;
import java.util.Scanner;

public class Payment {

	public static void makePayment(ArrayList <HotelsModel> reservations)
	{
		Scanner in = new Scanner(System.in);

		System.out.println("\nPlease enter the following informations: ");
		System.out.println("Billing Country: ");
		String Country = in.next();		
		System.out.println("Billing State: ");
		String State = in.next();
		System.out.println("Billing City: ");
		String City = in.next();
		System.out.println("Billing House Number: ");
		String HouseNumber = in.next();
		System.out.println("Billing Zip: ");
		String Zip = in.next();
		System.out.println("Card Holder First Name: ");
		String FName = in.next(); 
		System.out.println("Card Holder Last Name: ");
		String LName = in.next(); 						
		System.out.println("Card Type: ");
		String type = in.next();
						
		String numb = "";
		int count = 0, count1 = 0, count2 = 0;
		
		boolean failed = true;
		
		while((!(type.equals("visa") || type.equals("mastercard"))) && count < 2) // checks if the payment method is valid
		{
			System.out.println("Please enter a valid card type!");
			System.out.println("Card Type: ");
			type = in.next(); 
		}	
		if (count >= 2){
			System.out.println("Payment failed!"); // end
			failed = false;
		}
						
		if(failed) { 
			System.out.println("Card Number: ");
			numb= in.next();
		}
		
		while(!(numb.length() == 16) && count1 < 2) // checks if the card number is valid
		{
			System.out.println("Please enter a valid card number!");
			System.out.println("Card Number: ");
			numb = in.next(); 
			count1++;
		}	
		if (count1 >= 2){
			System.out.println("Payment failed!"); // end
			failed = false;
		}
						
		if(failed) {
			System.out.println("Expiration Month: ");										
			int month = in.nextInt();						
			System.out.println("Expiration Year: ");
			int year = in.nextInt();
						
			while(((month < 5 && year < 2019) || year < 2019) && count2 < 2) // checks if the card is expired
			{
				System.out.println("Expired");
				System.out.println("Expiration Month: ");										
				month = in.nextInt();							
				System.out.println("Expiration Year: ");
				year = in.nextInt();
				count2++;
			}
			
			if(count2 >= 2)
			{
				System.out.println("Payment failed!"); // end
				failed = false;
			}
		}
		
		if(failed);
		{
		System.out.println("Enter your reservation number to review payment information: ");
		int resID = in.nextInt();

		boolean review = false; 
		int j=0;
						
		while(!review && j <= 2) {
			for(int i = 0; i < reservations.size(); i++) {
				if(resID == reservations.get(i).getReservationID()) {
					review = true;
					System.out.println("Name: " + reservations.get(i).getName());
					System.out.println("Hotel: " + reservations.get(i).getHotelName());
					System.out.println("Location: " + reservations.get(i).getHotelLocation());
					System.out.println("Check In Date: " + reservations.get(i).getCheckInMonth() + "/" + reservations.get(i).getCheckInDate());
					System.out.println("Check Out Month: " + reservations.get(i).getCheckOutMonth() + "/" + reservations.get(i).getCheckOutDate());
					System.out.println("Rooms: " + reservations.get(i).getSingleRooms() + " single, " + reservations.get(i).getDoubleRooms() + " double ");
					System.out.println("Total: " + reservations.get(i).getPrice());
					break;
				}
			}
			if(!review) {
				System.out.println("Invalid number, enter again: ");
				j++;
				resID = in.nextInt();
			}
		}
	
		if(!review) {
			System.out.println("Payment Cancelled."); //end
		}
		else {
			System.out.println("Please confirm payment by entering confirm or cancel to cancel payment!");	
			String response= in.next();
						
			if(response.equals("confirm")) {
			System.out.println("Your payment has been successful! Thank you!");
			}
			else if(response.equals("cancel")) {
			System.out.println("Payment cancelled!");
			}	
		}
		} // if(!failed) ends
	}									
}
