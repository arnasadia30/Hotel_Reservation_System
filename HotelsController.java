import java.io.FileNotFoundException;
import java.util.ArrayList;

public class HotelsController {

			//Objects for MV
			public HotelsModel model;
			public HotelsModel2 model2;
			public Hotels view;
			
			public HotelsController(HotelsModel model, Hotels view, HotelsModel2 model2){
				this.model = model;
				this.view = view;
				this.model2 = model2;
			}
			//Updating Model
			
			//Setting data in model
//	//*		public void setHotelName(String hotelName){
//				model.setHotelName(hotelName);
//			}
//			public String getHotelName(){
//				return model.getHotelName();
//			}
//			public void setHotelLocation(String hotelLocation){
//				model.setHotelLocation(hotelLocation);				
//			}
//			public String getHotelLocation(){
//				return model.getHotelLocation();				
//			}
//			public void setName(String name) {
//				model.setName(name);
//			}
//			public String getName() {
//				return model.getName();
//			}
//			public void setSingleRooms(int singleRooms) {
//				model.setSingleRooms(singleRooms);
//			}
//			public int getSingleRooms() {
//				return model.getSingleRooms();
//			}
//			public void setDoubleRooms(int doubleRooms) {
//				model.setDoubleRooms(doubleRooms);
//			}
//			public int getDoubleRooms() {
//				return model.getDoubleRooms();
//			}
//			public void setCheckInDate(int checkInDate){
//				model.setCheckInDate(checkInDate);
//			}
//			public int getCheckInDate(){
//				return model.getCheckInDate();				
//			}
//			public void setCheckOutDate(int checkOutDate){
//				model.setCheckOutDate(checkOutDate);
//			}
//			public int getCheckOutDate(){
//				return model.getCheckOutDate();				
//			}
//			public void setCheckInMonth(int checkInMonth){
//				model.setCheckInMonth(checkInMonth);
//			}
//			public int getCheckInMonth(){
//				return model.getCheckInMonth();				
//			}
//			public void setCheckOutMonth(int checkOutMonth){
//				model.setCheckOutMonth(checkOutMonth);
//			}
//			public void setReservationID(int reservationID ) {
//				model.setReservationID(reservationID);
//			}
//			public int getReservationID() {
//				return model.getReservationID();
//			}
//			public double getPrice() {
//				return model.getPrice();
//			}
//			public void setHotels(String hotels) {
//				model2.setHotels(hotels);
//			}
//			public String getHotels() {
//				return model2.getHotels();
//			}
//			public void setLocation(String locations) {
//				model2.setLocations(locations);
//			}
//			public String getLocations() {
//				return model2.getLocations();
//			}
//			public void setMaxSingleRooms(int maxSingleRooms) {
//				model2.setMaxSingleRooms(maxSingleRooms);
//			}
//			public int getMaxSingleRooms() {
//				return model2.getMaxSingleRooms();
//			}
//			public void setMaxDoubleRooms(int maxDoubleRooms) {
//				model2.setMaxDoubleRooms(maxDoubleRooms);
//			}
//			public int getMaxDoubleRooms() {
//				return model2.getMaxDoubleRooms();
//			}
//			public void setSingleRate(double singleRate) {
//				model2.setSingleRate(singleRate);
//			}
//			public double getSingleRate() {
//				return model2.getSingleRate();
//			}
//			public void setDoubleRate(double doubleRate) {
//				model2.setDoubleRate(doubleRate);
//			}
//			public double getDoubleRate() {
//				return model2.getDoubleRate();
//			}
//	//*					
			//Update the view
			public void updateHotelsView(ArrayList <HotelsModel> reservations, ArrayList <HotelsModel2> list) throws FileNotFoundException{
				view.hotelReservation(reservations, list);
			}
	}



