package day6;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTest {

	public static void main(String[] args) {
		// jdk 초기 날짜
//		java.util.Date now = new java.util.Date(); // import 를 이용해서 할 수 도 있다.
		Date now = new Date();
		System.out.println(now);
		
		// Date 기능을 이제 Calendar로 이동하여 사용
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal.get(Calendar.YEAR));
		
		// 날짜시간형식을 정해서 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy - MM - dd E HH-mm-ss"); // E는 윈도우 Locale에 따라 각 국에 따라 변함
		String dat1 = sdf.format(now);
		String dat2 = sdf.format(cal.getTime());
		System.out.println(dat1);
		System.out.println(dat2);
		
		// 숫자형 format
		DecimalFormat df = new DecimalFormat("###.###");
		System.out.println(df.format( (double)10 / 3));
		
		// 문자형 format
		System.out.println(String.format("%10s",  "java")); // 10칸을 사용, 우측 정렬
		System.out.println(String.format("%-10s",  "java")); // 10칸을 사용, 좌측 정렬

	}

}
