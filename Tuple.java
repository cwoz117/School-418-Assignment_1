
public class Tuple<T> implements Comparable<Tuple<T>>{
	private T letter;
	private int count;
	
	public Tuple(T a){
		letter = a;
		count = 1;
	}
	
	public int getCount(){
		return count;
	}
	public T getLetter(){
		return letter;
	}
	public void setCount(int i){
		count = i;
	}
	public void setLetter(T a){
		letter = a;
	}
	public void increment(){
		count += 1;
	}
	
	public int compareTo(Tuple<T> t){
		
		return t.getCount() - this.count;
	}
	public String toString(){
		String a = "( " + letter + " | " + count + " ) ";
		return a;
	}
}

