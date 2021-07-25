import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnit {
	@Test
	public void testModel() { // checks if the number of days calculated in the model is correct. 
		
		HotelsModel myunit = new HotelsModel("A", "NY", "Jasleen", 5, 20, 5, 25, 5, 5, 100067, 4500);
		int days = myunit.getDays();
		assertEquals(6, days);
		
	}
}

