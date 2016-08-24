package v1;

/*
 * OOPDA, Myers 
 * Zodiac
 * Driver class 
 * @author Meriel Stein
 * @version 1/25/2016
 * 
 * @param birthdateString	input from user
 * @param  birthdate	parsed user input birthdate between 03/21/2016 and 03/20/2017
 * @param  zodiac 		class containing arraylist of all signs, their start dates and their enddates
 */

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.*;

//Zodiac dates via whats-your-sign.com/zodiac-sign-dates.html

public class Driver {

	private static BufferedReader br;

	public static void main(String[] args) throws IOException, ParseException {
		boolean cont = true;
		do {
			// no instance variable/class name in front of getBirthdate() -->
			// it's
			// inside the driver
			Date birthdate = getBirthdate();
			ZodiacTable zodiac = createZodiacTable();
			System.out.println(zodiac.determineSign(birthdate));

			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Continue: true/false");
			if (br.readLine().toLowerCase().startsWith("f")) {
				cont = false;
			}
		} while (cont);
	}

	public static Date getBirthdate() throws IOException, ParseException {

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your birthdate (format like '11/25/1995'): ");
			String birthdateString = br.readLine();
			Date birthdate = new Date();
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			birthdate = (Date) df.parse(birthdateString);
			return birthdate;
		} // end try block for inputting birthdate
		catch (ParseException | IOException e) {
			System.err.println("Caught Exception: " + e.getMessage());
			throw e;
		} // end catch block
	}

	public static ZodiacTable createZodiacTable() throws ParseException {
		return new ZodiacTable();
	}
}
