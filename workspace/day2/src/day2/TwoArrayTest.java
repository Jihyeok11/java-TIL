package day2;

public class TwoArrayTest {

	public static void main(String[] args) {
		// 2차배열 - 1차 배열의 길이가 4로 동일한 경우
//		int [][] two_ar = new int[3][4];
//		for (int i=0; i<two_ar.length; i++) {
//			for (int j=0; j<two_ar[i].length; j++) {
//				two_ar[i][j] = two_ar[i].length*i+j+1;
//				System.out.print(two_ar[i][j] + "\t");
//			}
//			System.out.println();
//		}
		// 2차배열 - 1차 배열의 길이가 다 다른경우
		int [][] two_ar = new int[3][];
		for (int i=0; i<two_ar.length; i++) {
			two_ar[i] = new int[i+2]; // 1행은 2개, 2행은 3개, 3행은 4개 
			for (int j=0; j<two_ar[i].length; j++) {
				two_ar[i][j] = two_ar[i].length*i+j+1;
				System.out.print(two_ar[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

}
