import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class JUnitCustomer{
	@Test
	public void testCustomer() {
		Customer myunit = new Customer(null, null, null, null);
		String result = myunit.Customer("Arna", "Sadia","arnasadia", "aaccss");
		assertEquals("aaccss",result);
}

}


