package mmphno;

public enum NetworkType {

	GSM("GSM",""),
	WCDMA("WCDMA","^(09|\\+?959)(55\\d{5}|25[2-4]\\d{6}|26\\d{7}|4(4|5|6)\\d{7})$"),
	CDMA_450("CDMA 450 MHz","^(09|\\+?959)(8\\d{6}|6\\d{6}|49\\d{6})$"), 
	CDMA_800("CDMA 800 MHz","^(09|\\+?959)(3\\d{7}|73\\d{6}|91\\d{6})$");
	
	private String name;
	
	private String regEx;
	
	private NetworkType(String name, String regEx){
		this.name = name;
		this.regEx = regEx;
	}

	public String getName() {
		return name;
	}

	public String getRegEx() {
		return regEx;
	}

}
