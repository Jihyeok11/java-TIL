package day2;

public class TIL {

	public static void main(String[] args) {
		/* 1번
		String title = "";
		int baseSalary = 500000;
		int basicFee = 0;
		double totalSalary = 0;
		int Fee,total;
		String ar [] = new String[5];
		ar[0] = "사원";
		ar[1] = "대리";
		ar[2] = "과장";
		ar[3] = "부장";
		ar[4] = "사장";
		for (int i=0;i<5;i++) {
			title = ar[i];
			switch(title) {
			case "사원":
				Fee=1000;
				total = baseSalary + Fee;
				break;
			case "사장":
				Fee=10000;
				total = (int)(baseSalary*(1.3)) + Fee;
				break;
			default:
				Fee = 5000;
				total = (int)(baseSalary*(1.2)) + Fee;
			}
			System.out.println(ar[i]+"의 급여는 "+ total);
		*/	
		
		/* 2번		

		char a = 'A';
		for (int i=0;i<26;i++) {
			System.out.print((char)(a+i));
		}
		char b = 'a';
		for (int i=0;i<26;i++) {
			System.out.print((char)(b+i));
		}
		*/
		
		/* 3 번
		 */
		int i = (int)(Math.random()*200 +1);
		System.out.println(i);
		while (i>50 && i<150) {
//			char res = (char) i;
			System.out.println(i);
			if (i>=65 && 90>=i) {
				System.out.println((char)i);
				System.out.println((char)(i+32));
			}
			else if (i>=97 && i<=122) {
				System.out.println((char)i);
				System.out.println((char)(i-32));
			}
			i = (int)(Math.random()*200 +1);
		}
			
	}
		

}
