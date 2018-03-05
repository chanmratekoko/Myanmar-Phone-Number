package mmphno;

import mmphno.exception.InvalidMyanmarTelecomNameException;

/**
 * Source https://www.numberingplans.com/?page=plans&sub=phonenr&alpha_2_input=MM&current_page=1
 * @author Chan Mrate Ko Ko
 *
 */
enum MyanmarTelecomOperator {

	OOREDOO("Ooredoo","^((09|\\+?959)9(7|6)\\d{7})$"),
	TELENOR("Telenor","^((09|\\+?959)7(9|8|7)\\d{7})$"),
	MPT("MPT","^((09|\\+?959)(5\\d{6}|4\\d{7,8}|2\\d{6,8}|3\\d{7,8}|6\\d{6}|8\\d{6}|7\\d{7}|9(0|1|9)\\d{5,6}))$");
	
	private String name;
	
	private String regEx;
	
	private MyanmarTelecomOperator(String name, String regEx){
		this.name = name;
		this.regEx = regEx;
	}

	public String getName() {
		return name;
	}

	public String getRegEx() {
		return regEx;
	}
	
	public static MyanmarTelecomOperator getMyanmarTelecomOperator(String telecomOperatorName) throws InvalidMyanmarTelecomNameException{
		MyanmarTelecomOperator telecomOperator = null;
		for(MyanmarTelecomOperator operator : MyanmarTelecomOperator.values()){
			if(operator.name.equalsIgnoreCase(telecomOperatorName)) {
				telecomOperator =  operator;
				break;
			}
		}
		if(telecomOperator == null){
			throw new InvalidMyanmarTelecomNameException();
		} else {
			return telecomOperator;
		}		
	}
}
