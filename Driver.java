import java.util.Scanner;

public class Driver {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		FrequencyCount f = new FrequencyCount("cipherText.txt");
		f.printDocument();
		System.out.println();
		f.printFrequencyStatistics();
		char[] frequencyStats = {'e', 't', 'o', 'a', 'i', 'n', 's',
				  'h', 'r', 'd', 'c', 'm', 'l', 'w', 'y', 'u', 'b', 
				  'p', 'f', 'g', 'k', 'v', 'x', 'j', 'q', 'z' };

		for (int i = 0 ; i < frequencyStats.length; i++){
			String s = "";
			String t = "";
			s += f.getChar(i);
			t += frequencyStats[i];
			f.applyChange(s.charAt(0), t.charAt(0));
		}
		
		f.printDocument();

		
		in.close();
	}
}

// e h n o t