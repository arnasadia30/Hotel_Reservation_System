import java.util.ArrayList;
import java.util.Scanner;

		public class Customer {
	 
		private String fName;
		private String lName;
		private String customerID;
		private String password;
		
		public Customer (String fName, String lName, String customerID, String password) {
			this.fName = fName;
			this.lName = lName;
			this.customerID = customerID;
			this.password = password;
		}
		public String Customer (String fName, String lName, String customerID, String password) {
			this.fName = fName;
			this.lName = lName;
			this.customerID = customerID;
			return this.password = password;
		}

		public String getfName() {
			return fName;
		}

		public void setfName(String fName) {
			this.fName = fName;
		}

		public String getlName() {
			return lName;
		}

		public void setlName(String lName) {
			this.lName = lName;
		}

		public String getCustomerID() {
			return customerID;
		}

		public void setCustomerID(String customerID) {
			this.customerID = customerID;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}


