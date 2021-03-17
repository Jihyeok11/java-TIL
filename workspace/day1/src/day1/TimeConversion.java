package day1;

public class TimeConversion {

	public static void main(String[] args) {
		int time = 100000;// 초단위 시간
		// 시분초 단위 변경 출력
		int hour = time/3600;
		int min = (time - hour*3600)/60;
		int sec = time - hour*3600 - min*60;
		System.out.println("10000초는 "+hour+"시간" +min+"분"+sec+"초 입니다.");
		// hour 변수가 24 시간 초과되면 "만 `일이 경과했습니다" 출력
		// 아니면 "1일 이내입니다" 출력
		String result =  hour > 24 ? "만 1일이 경과했습니다" : "1일 이내입니다";
		System.out.println(result);
		
	}

}
