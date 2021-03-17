package day2;

public class GugudanTest {

	public static void main(String[] args) {

		for (int i=1;i<10;i++) {
			for( int j=2; j<10;j++) {
				if (j==5) {
					continue;
				}
				System.out.print(j+" * "+i+" = "+(i*j)+"\t");
			}
			System.out.println();
		}

	}

}
