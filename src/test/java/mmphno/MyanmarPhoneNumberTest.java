package mmphno;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import mmphno.exception.InvalidMyanmarTelecomNameException;

public class MyanmarPhoneNumberTest {

	protected MyanmarPhoneNumber myanmarPhoneNumber;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() {
		myanmarPhoneNumber = new MyanmarPhoneNumber();
	}

	@Test
	public void testGetTelecomName() {

		String telecomName = myanmarPhoneNumber.getTelecomName("09968089999", false);
		Assert.assertEquals("Ooredoo", telecomName);

		telecomName = myanmarPhoneNumber.getTelecomName("+959968089999", false);
		Assert.assertEquals("Ooredoo", telecomName);

		telecomName = myanmarPhoneNumber.getTelecomName("+95 996 808 9999", false);
		Assert.assertEquals("Unknown", telecomName);

		telecomName = myanmarPhoneNumber.getTelecomName("099 68089 999", false);
		Assert.assertEquals("Unknown", telecomName);

		telecomName = myanmarPhoneNumber.getTelecomName("+95 996 808 9999", true);
		Assert.assertEquals("Ooredoo", telecomName);

		telecomName = myanmarPhoneNumber.getTelecomName("099 68089 999", true);
		Assert.assertEquals("Ooredoo", telecomName);

		thrown.expect(NullPointerException.class);
		myanmarPhoneNumber.getTelecomName(null, true);
	}
	
	@Test
	public void textIsTelecomPhoneNumber() throws InvalidMyanmarTelecomNameException{
		boolean retult = myanmarPhoneNumber.isTelecomPhoneNumber("09968089999", "Ooredoo");		
	}

}
