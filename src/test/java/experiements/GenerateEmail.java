package experiements;

import java.util.Date;

public class GenerateEmail {
	
	public static void main(String[] args) {
		
		Date date = new Date();
		String dateString = date.toString();
		String noSpaceDateString = dateString.replaceAll("\\s", "");
		String noSpaceAndColons = noSpaceDateString.replaceAll("\\:", "");
		String emailWithTimeStamp = noSpaceAndColons+"@gmail.com";
		System.out.println(emailWithTimeStamp);
		
	}
	

}
