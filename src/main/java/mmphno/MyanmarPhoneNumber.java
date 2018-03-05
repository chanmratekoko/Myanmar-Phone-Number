package mmphno;

import mmphno.exception.InvalidMyanmarTelecomNameException;
import mmphno.impl.MyanmarPhoneNumberValidatorImpl;
import mmphno.impl.SanitizerImpl;

public class MyanmarPhoneNumber {

	private Sanitizer sanitizer;

	private MyanmarPhoneNumberValidator validator;

	public MyanmarPhoneNumber() {
		this.sanitizer = new SanitizerImpl();
		this.validator = new MyanmarPhoneNumberValidatorImpl(sanitizer);
	}

	public String getTelecomName(String phoneNumber) {
		return getTelecomName(phoneNumber, true);
	}
	
	public String getTelecomName(String phoneNumber, boolean sanitize) {

		if (phoneNumber == null) {
			throw new NullPointerException();
		}

		String telecomName = "Unknown";

		if (sanitize) {
			phoneNumber = sanitizer.normalize(phoneNumber);
		}
		
		if (validator.isMyanmarPhoneNumber(phoneNumber, false)) {
			for (MyanmarTelecomOperator myanmarTelecomOperator : MyanmarTelecomOperator.values()) {
				if (phoneNumber.matches(myanmarTelecomOperator.getRegEx())) {
					telecomName = myanmarTelecomOperator.getName();
					break;
				}
			}
		}

		return telecomName;
	}
	
	public boolean isTelecomPhoneNumber(String phoneNumber, String telecomOperatorName)
			throws InvalidMyanmarTelecomNameException {
		return isTelecomPhoneNumber(phoneNumber, telecomOperatorName, true);
	}

	public boolean isTelecomPhoneNumber(String phoneNumber, String telecomOperatorName, boolean sanitize)
			throws InvalidMyanmarTelecomNameException {

		if (telecomOperatorName == null || phoneNumber == null) {
			throw new NullPointerException();
		}

		if (sanitize) {
			phoneNumber = sanitizer.normalize(phoneNumber);
		}

		MyanmarTelecomOperator myanmarTelecomOperator = MyanmarTelecomOperator
				.getMyanmarTelecomOperator(telecomOperatorName);
		return phoneNumber.matches(myanmarTelecomOperator.getRegEx());
	}

}
