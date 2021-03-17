package day2;

public class IfTest {

	public static void main(String[] args) {
		// 이자바 학생, 국어100 영어 88 수학 77
		//총점 / 정수평균 / 실수평균
		//정수평균 70점 이상이면 합격 / 불합격
		String name = "이자바";
		int kor = 100;
		int eng = 88;
		int mat = 77;
		// 국영수를 1-100 사이 난수 발생
		kor = (int)(Math.random() * 100) + 1;
		eng = (int)(Math.random() * 100) + 1;
		mat = (int)(Math.random() * 100) + 1;
		int sum = kor+eng+mat;
		int avgInt = sum / 3;
		float avgDouble = sum / (float)3;
		System.out.println("학생이름 = "+name);
		System.out.println("국어="+kor);
		System.out.println("영어="+eng);
		System.out.println("수학="+mat);
		System.out.println("총점="+sum);
		System.out.println("평균(정수)="+avgInt);
		System.out.println("평균(실수)="+avgDouble);
		/*
		if (avgInt >= 70)
			System.out.println("합격입니다.");
		else {
			System.out.println("불합격입니다.");
			System.out.println("공부 열심히 하세요");
		}
		
		// 80이상 A등급
		// 60이상 80미만 B등급
		// 40이상 60미만 C등급
		// 그 외는 낙제
		String grade;
		if (avgInt >= 80 && avgInt<=100) {
			grade = "A";
		}
		else if (avgInt >= 60 && avgInt < 80) {
			grade = "B";
		}
		else if (avgInt >= 40 && avgInt < 60) {
			grade = "C";
		}
		else {
			grade = "낙제";
		}
		System.out.println("등급은 "+grade+"입니다");
		*/
		int avgDecInt = avgInt/10;
		switch(avgDecInt) {
		case 4:
		case 5:
			System.out.println("C등급입니다");
			break;
		case 6:
		case 7:
			System.out.println("B등급입니다.");
			break;
		case 8:
		case 9:
		case 10:
			System.out.println("A등급입니다.");
			break;
		default:
			System.out.println("낙제입니다");	
		}
	}

}
