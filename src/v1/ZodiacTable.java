package v1;

/*
 * OOPDA, Myers, Spring 2016
 * Zodiac Lab
 * @author Meriel Stein
 * @version 01/31/2016
 * 
 * A class to define the signs of the zodiac, determine sign based on birthdate
 */

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.text.ParseException;

public class ZodiacTable {

	/*
	 * Holds the zodiac signs
	 */
	ArrayList<Sign> signs = new ArrayList<>();

	/*
	 * Date format for all inputs and params
	 */
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

	/*
	 * Initializes and adds each zodiac sign to the signs table
	 */
	public ZodiacTable() throws ParseException {
		// add Aries
		signs.add(new Sign("Aries", df.parse("03/21/2016"), df.parse("04/19/2016")));
		// add Taurus
		signs.add(new Sign("Taurus", df.parse("04/20/2016"), df.parse("05/20/2016")));
		// add Gemini
		signs.add(new Sign("Gemini", df.parse("05/21/2016"), df.parse("06/20/2016")));
		// add Cancer
		signs.add(new Sign("Cancer", df.parse("06/21/2016"), df.parse("07/22/2016")));
		// add Leo
		signs.add(new Sign("Leo", df.parse("07/23/2016"), df.parse("08/22/2016")));
		// add Virgo
		signs.add(new Sign("Virgo", df.parse("08/23/2016"), df.parse("09/22/2016")));
		// add Libra
		signs.add(new Sign("Libra", df.parse("09/23/2016"), df.parse("10/22/2016")));
		// add Scorpio
		signs.add(new Sign("Scorpio", df.parse("10/23/2016"), df.parse("11/21/2016")));
		// add Sagittarius
		signs.add(new Sign("Sagittarius", df.parse("11/22/2016"), df.parse("12/21/2016")));
		// add Capricorn
		signs.add(new Sign("Capricorn", df.parse("12/22/2016"), df.parse("01/19/2017")));
		// add Aquarius
		signs.add(new Sign("Gemini", df.parse("01/20/2017"), df.parse("02/18/2017")));
		// add Pisces
		signs.add(new Sign("Gemini", df.parse("02/19/2017"), df.parse("03/20/2017")));
	}

	/*
	 * Displays the zodiac table
	 */
	public void display() {
		for (Sign sign : signs) {
			System.out.println(sign);
		}
	}

	/*
	 * Determines the sign based on birthdate
	 * 
	 * @return sign String of the sign name that the birthdate falls on
	 */
	public String determineSign(Date birthdate){
		
		FieldPosition pos1 = new FieldPosition(DateFormat.MONTH_FIELD);
		FieldPosition pos2 = new FieldPosition(DateFormat.DATE_FIELD);
		StringBuffer sb1 = new StringBuffer();
		
		df.format(birthdate, sb1, pos1);
		int birthMonth = Integer.parseInt(sb1.substring(pos1.getBeginIndex(), pos1.getEndIndex()));
		df.format(birthdate, sb1, pos2);
		int birthDay = Integer.parseInt(sb1.substring(pos2.getBeginIndex(), pos2.getEndIndex()));
		
		for (Sign sign: signs){
			
			StringBuffer sb2 = new StringBuffer();
			df.format(sign.getStartDate(), sb2, pos1);
			int startDateMonth = Integer.parseInt(sb2.substring(pos1.getBeginIndex(), pos1.getEndIndex()));
			df.format(sign.getStartDate(), sb2, pos2);
			int startDateDay = Integer.parseInt(sb2.substring(pos2.getBeginIndex(), pos2.getEndIndex()));
			
			df.format(sign.getEndDate(), sb2, pos1);
			int endDateMonth = Integer.parseInt(sb2.substring(pos1.getBeginIndex(), pos1.getEndIndex()));
			df.format(sign.getEndDate(), sb2, pos2);
			int endDateDay = Integer.parseInt(sb2.substring(pos2.getBeginIndex(), pos2.getEndIndex()));
			
			if ((birthMonth == startDateMonth && birthDay >= startDateDay)){
					return sign.getSign();
			}
			
			else if(birthMonth == endDateMonth && birthDay <= endDateDay){
				return sign.getSign();
			}
		} // end for loop
		
		//if birthdate does not match any date in year
		return "Please enter a valid birthdate.";
	}
}