package day2;

public class SwitchTest {

	public static void main(String[] args) {
		// 1-12 난수 발생
		// 3,4,5 이면 "계절은 봄입니다"
		// 6,7,8 이면 "계절은 여름입니다"
		// 9,10,11이면 "계절은 가을입니다"
		// 나머지는 "계절은 겨울입니다"
		int month = (int)(Math.random()*12) + 1;
		System.out.println("현재 "+month+"월 이고");
		switch(month) {
//		case 3:// if (month == 3)을 의미
//			System.out.println("계절은 봄입니다");
//			break; // break 안하면 아래 모든 조건 실행
//		case 4: // 바로 위에 break가 없었다면 이것의 참/거짓 구분 없이 실행
//			System.out.println("계절은 봄입니다");
//			break;
//		default:
//			System.out.println("해당사항 없습니다");
		
		//
		
		case 3: //문장 없다 month가 3이면 아래에 break가 있을 때까지 쭉 진행
		case 4:
		case 5:
			System.out.println("계절은 봄입니다");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("게절은 여름입니다");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("게절은 가을입니다");
			break;
		default:
			System.out.println("게절은 겨울입니다");
			
		}
	}
		
}