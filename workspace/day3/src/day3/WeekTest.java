package day3;

import java.util.Calendar;

public class WeekTest {

	public static void main(String[] args) {
//		타입 이름 = 값;
//		변수 = enum.열거값;
		Week today = null;
//		System.out.println(today.name()); // null 데이터는 methods 사용 불가능
		// today 무슨 요일?
		java.util.Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1); // 월은 -1 되어서 나온다.
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		// 일요일 = 1, 월요일 = 2, 화요일 = 3 ...
		switch(cal.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			today = Week.SUNDAY;
			break;
		case 2:
			today = Week.MONDAY;
			break;
		case 3:
			today = Week.TUESDAY;
			break;
		case 4:
			today = Week.WEDNESDAY;
			break;
		case 5:
			today = Week.THURSDAY;
			break;
		case 6:
			today = Week.FRIDAY;
			break;
		case 7:
			today = Week.SATURDAY;
			break;
		}
		System.out.println(today);

	}

}
