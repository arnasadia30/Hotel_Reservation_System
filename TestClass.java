
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class TestClass {
	
	public static void main(String[] args) throws FileNotFoundException   {
		Scanner in = new Scanner (System.in);
		
		ArrayList <Customer> accounts = new ArrayList<Customer>();

		File myFile = new File("UsersData.txt"); // creates file

		accounts.add(new Customer ("Arna", "Sadia", "4321", "AS05"));
		accounts.add(new Customer ("Alissa", "Rose", "9876", "AR12"));
		accounts.add(new Customer ("Aayushi", "Patel", "1234", "AA99"));

		System.out.println("Hotel Reservations System");
			
		int choice = 0;

		System.out.println("1. Login");
		System.out.println("2. Add new User");
	
		choice = in.nextInt();
		int count = 0, count1 = 0;
		
		switch(choice)
			{
			case 1: 
				System.out.println("Enter ID: ");
				String loginID = in.next();
				System.out.println("Enter Password: ");
				String loginPassword = in.next();

				boolean id = false;
			while(!id)	{
				for(int i = 0; i < accounts.size(); i++) {
					
					if(loginID.equals(accounts.get(i).getCustomerID()))
					{
						id = true;
					}
					else if (!(loginID.equals(accounts.get(i).getCustomerID()))) {						
							System.out.println(accounts.get(i).getCustomerID());
							System.out.println("ID not found. Enter again: ");
							loginID = in.next();
					 } 
				}}
				
				for(Customer i : accounts) {
					while(loginID.equals(i.getCustomerID()) && count1 < 2) {
						if(loginPassword.equals(i.getPassword())) {
								System.out.println("Login Successful.");
								break;
							}
						else {
							System.out.println("Incorrect Password. Enter again: ");
							loginPassword = in.next();
							count++;
						}
					}
				}
				if(count1 >= 2)
				{
					System.out.println("Login Failed.");
				}				
				break; 
				
			case 2: //Add new customer
				System.out.println("First Name: ");	
				String fName = in.next();
				System.out.println("Last Name: ");	
				String lName = in.next();
				System.out.println("Customer ID: ");	
				String customerID = in.next();
				                         
				for (int i=0; i<accounts.size(); i++) {
					if(customerID == accounts.get(i).getCustomerID()){
						System.out.println("Error: ID already exists.");	
						customerID= in.next();
					}
				} //check if ID already exists
					
				System.out.println("Enter Password: ");	
				String password = in.next();
				
				Customer A = new Customer (fName, lName, customerID, password);
				
				try { 
				PrintWriter writer = new PrintWriter("UsersData.txt");					
				accounts.forEach(i ->
				{
					writer.println();
					writer.println(i.getfName());
					writer.println(i.getlName());
					writer.println(i.getCustomerID());
					writer.println(i.getPassword());
				});
				writer.close();
				break;
			}		
			catch (FileNotFoundException f) {
				f.printStackTrace();
			}

		}
		
		ArrayList <HotelsModel> reservations = new ArrayList<HotelsModel>();
		ArrayList <HotelsModel2> list = new ArrayList<HotelsModel2>();
		
		// reservations list - HotelsModel
		reservations.add(new HotelsModel("Hilton", "Philadelphia", "Jasleen", 5, 20, 5, 25, 5, 5, 100067, 750));
		reservations.add(new HotelsModel("Hilton", "Philadelphia", "Dan", 5, 20, 5, 25, 5, 5, 100068, 750));
		reservations.add(new HotelsModel("Hilton", "Philadelphia", "Emily", 5, 20, 5, 25, 5, 5, 100069, 750));
		reservations.add(new HotelsModel("Hilton", "Philadelphia", "Nad", 5, 20, 5, 25, 5, 5, 100070, 750));
		reservations.add(new HotelsModel("Hilton", "Philadelphia", "Ava", 5, 20, 5, 25, 5, 5, 100071, 750));
		reservations.add(new HotelsModel("Hillside", "NY", "Abyana", 8, 20, 8, 25, 5, 5, 100072, 950));
		reservations.add(new HotelsModel("Radisson", "Boston", "Alexa", 5, 15, 5, 17, 5, 5, 100073, 1200));
		reservations.add(new HotelsModel("HolidayInn", "Chicago", "Nick", 9, 11, 9, 15, 0, 4, 100074, 440));
		reservations.add(new HotelsModel("Marriot", "LA", "Varun", 6, 23, 6, 27, 2, 3, 100075, 840));
		reservations.add(new HotelsModel("Marriot", "LA", "Joe", 7, 6, 7, 9, 3, 2, 100076, 760));
		
		// hotels list - HotelsModel2
		list.add(new HotelsModel2 ("Hilton", "Philadelphia", 25, 28, 50, 100));
		list.add(new HotelsModel2 ("Hillside", "NY", 30, 33, 70, 120));
		list.add(new HotelsModel2 ("Radisson", "Boston", 20, 22, 90, 150));
		list.add(new HotelsModel2 ("HolidayInn", "Chicago", 50, 50, 60, 110));
		list.add(new HotelsModel2 ("Marriot", "LA", 100, 100, 120, 200));
		
		int choice1;
	
		do {
		System.out.println("\nWhat would you like to do?");
		System.out.println("1. Search for a Hotel");
		System.out.println("2. Logout");
		
		choice1 = in.nextInt();	
		
		switch(choice1)
		{
			case 1: // calls the view
				Hotels.hotelReservation(reservations, list);
				break;

			case 2: // exits
			System.out.println("Thank you for using the app.");	
			break;			
		}	
		} while (choice1 != 2);
	}
}
