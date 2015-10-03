import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FrequencyCount {
	private List<Tuple<Character>> cipherText;
	//private List<Tuple<String>> wordCount;
	private char[] document;
	
	public FrequencyCount(String f){
		String doc = "";
		cipherText = new ArrayList<Tuple<Character>>();
		//wordCount = new ArrayList<Tuple<String>>();
		for (int i = 0; i < 26; i++ ){
			cipherText.add(new Tuple<Character>((char)(i+65)));
		}
		try{
			Scanner in = new Scanner(new FileReader(f));
			while (in.hasNextLine()){
				doc += in.nextLine();
				doc += '\n';
			}
			in.close();			
		}catch (FileNotFoundException e){
			System.out.println("Whoops");
			e.printStackTrace();
		}
		document = doc.toCharArray();
		findFrequency();
		//findWordCount();
	}

	public void findFrequency(){
		for (int i = 0; i < document.length ; i ++){
			if (((int)document[i] > 64) && ((int)document[i] <= 90)){
				cipherText.get((int)document[i] - 65).increment();
			}
		}
		Collections.sort(cipherText);
	}
	
	/*
	public void findWordCount(){
		String a = new String(document);
		String b[] = a.split(" ");
		for (int i = 0; i < b.length; i++){
			if wordCount.c
			wordCount.add(new Tuple<String>(b[i]));
		}
		Collections.sort(wordCount);
	} 
	*/
	
	public char getChar(int i){
		return cipherText.get(i).getLetter();
	}
	
	public void printFrequencyStatistics() {
		System.out.println("Letter Statistics");
		for(int i = 0; i < cipherText.size(); i++){
			//if (i < cipherText.size()){
			System.out.print(cipherText.get(i) + "\t ");
			//} else {
			//	System.out.print("\t");
			//}
			//System.out.println(wordCount.get(i));
			//if ((i % 4 == 3) && (i > 0)){
				System.out.println();
			//}
		}
		System.out.println("\n");
	}
	public void printDocument(){
		System.out.println("Document:");
		System.out.println(document);
	}
	public void applyChange(char cipher, char plain){
		String s = "";
		s += plain;
		for (int i = 0; i < document.length; i++){
			if (document[i] == cipher){
				document[i] = s.toLowerCase().charAt(0);
			}
		}
	}
}
