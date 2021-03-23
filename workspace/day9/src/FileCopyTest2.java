import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest2 {

	public static void main(String[] args) {
		FileReader fi = null;
		FileWriter fo = null;
		
		try {
			fi = new FileReader(args[0]);
			fo = new FileWriter(args[1],true);
			while (true) {
				int result = fi.read();
				fo.write(result);;
				if(result == -1) {break;}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fi.close();
				fo.close();
			}catch(IOException e) {
				
			}
		}
	}
}