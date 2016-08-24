package v1;

/*
 * OOPDA, Myers, Spring 2016
 * Zodiac Lab
 * @author Meriel Stein
 * @version 1/31/2016
 */

import java.util.Date;

public class Sign {

	/*
	 * Name of the zodiac sign
	 */
	String sign;
	
	/*
	 * Start date and end date of the span of time that a given sign falls on
	 */
	Date startDate, endDate;
	
		public Sign(String sign, Date startDate, Date endDate){
			this.sign = sign;
			this.startDate = startDate;
			this.endDate = endDate;
		}
		
		/*
		 * Getters and setters for all params
		 */

		public String getSign() {
			return sign;
		}

		public void setSign(String sign) {
			this.sign = sign;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		
		@Override
		public String toString(){
			return sign + ", start date: "+startDate+", end date: "+endDate;
		}
		
}

