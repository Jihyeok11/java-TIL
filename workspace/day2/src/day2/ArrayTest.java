package day2;

import java.text.DecimalFormat;

public class ArrayTest {

	public static void main(String[] args) {
		// 5명의 학생
		String names [] = new String[5];
		names[0] = "홍미미";
		names[1] = "이민정";
		names[2] = "서형준";
		names[3] = "김범근";
		names[4] = "김우일";
//		
//		int scores [] = new int[names.length];
//		scores[0] = 100;
//		scores[1] = 80;
//		scores[2] = 90;
//		scores[3] = 20;
//		scores[4] = 77;
//		System.out.println("학생수=점수갯수 : "+scores.length);
//		for (int i=0;i<names.length;i++) {
//			System.out.println(i+1+"번째 학생, "+names[i]+"의 점수는 "+scores[i]);	
//		}
		int [] [] scores = new int [names.length][3];
		double avg [] = new double[names.length];
		/* 
		 * 첫번쨰 학생의 국어 영어 수학
		 * 두번쨰 학생의 국어 영어 수학
		 * 세번쨰 학생의 국어 영어 수학
		 * 네번쨰 학생의 국어 영어 수학
		 * 다섯번쨰 학생의 국어 영어 수학
		 * 점수를 1-100 난수 발생 초기화 출력
		 * 각 학생별 3과목 실수평균 저장 배열
		 */
		for (int i=0;i<names.length;i++) {
			double res = 0;
			for (int j=0; j<3; j++) {
				scores[i][j] = (int)(Math.random()*100+1);
				System.out.print(scores[i][j]+"\t");
				res = res + scores[i][j];
			}
			avg[i] = res/3;
//			java.text.DecimalFormat dec = new DecimalFormat("###.##"); // 소수점 이하 0이면 삭제
			java.text.DecimalFormat dec = new DecimalFormat("###.00"); // 소수점 이하 0이여도 0을 표시 
			System.out.println(dec.format(avg[i]));
		}
		
		
		// 2차원 배열
//		int two_ar [][] = new int [3][4];
//		System.out.println(two_ar.length);
//		System.out.println(two_ar[1].length);
//		for (int i=0;i<12;i++) {
//			two_ar[i/4][i%3]=i;
//		}
		
		//현재 5행짜리 names를 10개로 증가
//		names = new String[10]; // 새로운 배열이 생성되므로 이전의 저장 상태가 삭제된다.
//		System.out.println(names[0]);
		
		// 기존의 names를 유지해보자
		String [] names2 = new String[10];
		for(int i=0;i<names.length; i++) {
			names2[i] = names[i];
		}
		for(int i=0; i<names2.length; i++) {
			System.out.println(names2[i]);
		}
		// 향상된 for 문 (jdk 1.5버전 이상)
		for (String n:names2) {
			System.out.println(n);
		}
	}

}

