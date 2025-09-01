package utils;

import java.util.Date;

public class Utilitis {
	
	public static String getNewMailID() {
		return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@Email.com";

	}

}
