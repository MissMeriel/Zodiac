package v1;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//http://stackoverflow.com/questions/8919480/how-to-use-fieldposition-argument-in-java-messageformat-format-method

public class Tester {

	public static void main(String[] args) throws ParseException {

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

		Date birthdate = (Date) df.parse("06/16/1991");
		Date compareDate = (Date) df.parse("06/06/1666");
		Date ZacksButt = (Date) df.parse("09/12/1995");

		FieldPosition pos1 = new FieldPosition(DateFormat.MONTH_FIELD);
		FieldPosition pos2 = new FieldPosition(DateFormat.DATE_FIELD);
		StringBuffer sb1 = new StringBuffer();
		//StringBuffer sb2 = new StringBuffer();
		
//		System.out.println("birthdate toString: " + birthdate.toString());
//		System.out.println("compareDate toString: " + compareDate.toString());
//		System.out.println("ZacksButt toString: " + ZacksButt.toString());
//		System.out.println("birthdate cleverness: " + birthdate.toString().substring(4, 7));
//		System.out.println("birthdate cleverness again: " +  birthdate.toString().substring(9, endIndex));
		df.format(birthdate, sb1, pos1);
		System.out.println("sb1: " + sb1);
		System.out.println("Birthdate month substring: " + sb1.substring(pos1.getBeginIndex(), pos1.getEndIndex()));
		df.format(birthdate, sb1, pos2);
		System.out.println("sb1: " + sb1);
		System.out.println("Birthdate day substring: " + sb1.substring(pos2.getBeginIndex(), pos2.getEndIndex()));
		
		df.format(compareDate, sb1, pos1);
		System.out.println("sb1: " + sb1);
		System.out.println("compareDate month substring: " + sb1.substring(pos1.getBeginIndex(), pos1.getEndIndex()));
		//df.format(compareDate, sb1, pos2);
		//System.out.println("sb1: " + sb1);
		System.out.println("compareDate day substring: " + sb1.substring(pos2.getBeginIndex(), pos2.getEndIndex()));
	} // end main

}
