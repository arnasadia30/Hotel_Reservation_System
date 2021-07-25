import java.util.ArrayList;

public class HotelsModel2 {
	
	private String hotels;
	private String locations;
	private int maxSingleRooms;
	private int maxDoubleRooms;
	private double singleRate;
	private double doubleRate;
	
	public HotelsModel2(String hotels, String locations, int maxSingleRooms, int maxDoubleRooms, double singleRate, double doubleRate)
	{
		this.hotels = hotels;
		this.locations = locations;
		this.maxSingleRooms = maxSingleRooms;
		this.maxDoubleRooms = maxDoubleRooms;
		this.singleRate = singleRate;
		this.doubleRate = doubleRate;
	}
		
	public String Model(String hotels, String locations) {
		this.hotels = hotels;
		this.locations = locations;
		return	this.hotels = hotels;
	}
	
	public HotelsModel2() {
	}
	public String getHotels() {
		return hotels;
	}
	public void setHotels(String hotels) {
		this.hotels = hotels;
	}
	public String getLocations() {
		return locations;
	}
	public void setLocations(String locations) {
		this.locations = locations;
	}		
	public int getMaxSingleRooms() {
		return maxSingleRooms;
	}
	public void setMaxSingleRooms(int maxSingleRooms) {
		this.maxSingleRooms = maxSingleRooms;
	}
	public int getMaxDoubleRooms() {
		return maxDoubleRooms;
	}
	public void setMaxDoubleRooms(int maxDoubleRooms) {
		this.maxDoubleRooms = maxDoubleRooms;
	}
	public double getSingleRate() {
		return singleRate;
	}
	public void setSingleRate(double singleRate) {
		this.singleRate = singleRate;
	}
	public double getDoubleRate() {
		return doubleRate;
	}
	public void setDoubleRate(double doubleRate) {
		this.doubleRate = doubleRate;
	}
}


