import java.*;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelsModel {

	private String hotelName;
	private String hotelLocation;
	private String name;
	private int singleRooms;
	private int doubleRooms;
	private int checkInDate;
	private int checkInMonth;
	private int checkOutDate;
	private int checkOutMonth;
	private int reservationID;
	public int days;
	public double price;

	
	public HotelsModel(String hotelName, String hotelLocation, String name, int checkInMonth, int checkInDate, int checkOutMonth, int checkOutDate, int singleRooms, int doubleRooms, int reservationID, double price) {
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.name = name;
		this.checkInDate = checkInDate;
		this.checkInMonth = checkInMonth;
		this.checkOutDate = checkOutDate;
		this.checkOutMonth = checkOutMonth;
		this.singleRooms = singleRooms;
		this.doubleRooms = doubleRooms;
		this.reservationID = reservationID;
		this.price = price;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelLocation() {
		return hotelLocation;
	}

	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSingleRooms() {
		return singleRooms;
	}

	public void setSingleRooms(int singleRooms) {
		this.singleRooms = singleRooms;
	}

	public int getDoubleRooms() {
		return doubleRooms;
	}

	public void setDoubleRooms(int doubleRooms) {
		this.doubleRooms = doubleRooms;
	}

	public int getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(int checkInDate) {
		this.checkInDate = checkInDate;
	}

	public int getCheckInMonth() {
		return checkInMonth;
	}

	public void setCheckInMonth(int checkInMonth) {
		this.checkInMonth = checkInMonth;
	}

	public int getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(int checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getCheckOutMonth() {
		return checkOutMonth;
	}

	public void setCheckOutMonth(int checkOutMonth) {
		this.checkOutMonth = checkOutMonth;
	}

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}
	
	public int getDays(){
		int counter = 0;
		days = 0;
		if(checkInMonth == checkOutMonth) // if check in month is equal to check out month
		{
			days = 1 + (checkOutDate - checkInDate);
		}
		
		if(checkInMonth < checkOutMonth) // if check in month is not equal to check out month
		{
			counter = checkOutMonth - checkInMonth; 
			for(int i = 0; i < counter; i++)
			{
				while (!(checkInMonth == checkOutMonth)) // 
				{
					if(checkInMonth == 5 /*may*/ || checkInMonth == 7 /*july*/ || checkInMonth == 8 /*august*/|| checkInMonth == 10 /*october*/|| checkInMonth ==12 /*december*/)
					{
						days = days + (31 - (checkInDate - 1));
						checkInMonth++;
						while (!(checkInMonth == checkOutMonth))
						{
							if(checkInMonth == 5 || checkInMonth == 7 || checkInMonth == 8 || checkInMonth == 10 || checkInMonth ==12)
							{
							days = days + 31;
							checkInMonth++;
							}
							else if(checkInMonth == 6 || checkInMonth == 9 || checkInMonth == 11)
							{
								days = days + 31;
							}
						}
						if(checkInMonth == checkOutMonth)
						{
							days = days + checkOutDate;
						}
						
					}
					else if(checkInMonth == 6 /*june*/|| checkInMonth == 9 /*september*/|| checkInMonth == 11 /*november*/)
					{
						days = days + (30 - (checkInDate - 1));
						checkInMonth++;
						while (!(checkInMonth == checkOutMonth))
						{
							if(checkInMonth == 5 || checkInMonth == 7 || checkInMonth == 8 || checkInMonth == 10 || checkInMonth ==12)
							{
							days = days + 31;
							checkInMonth++;
							}
							else if(checkInMonth == 6 || checkInMonth == 9 || checkInMonth == 11)
							{
								days = days + 30;
							}
						}
						if(checkInMonth == checkOutMonth)
						{
							days = days + checkOutDate;
						}
					}
				}
			}
		} 	
		// days = ((31-(checkInDate-1)) + ((31*(counter-1) + (checkOutDate+1))));	
		return days;
	}
	
	public double getPrice() {
		return days * price;
	}

}

