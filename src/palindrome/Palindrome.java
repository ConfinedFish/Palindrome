package palindrome;

import java.io.File;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		new Palindrome().run();
    }
    private void run(){
	    File file = new File("file.txt");
	    Scanner scanner;
	    String value;
	    LinkedList<MyVector> listOfVectors = new LinkedList<>();
	    try{
	    	scanner = new Scanner(file);
		    while (scanner.hasNext()){
				listOfVectors.add(convertToMyVector(scanner.nextLine()));
		    }
	    } catch (Exception e){
		    print("Invalid file.");
	    }
	    print(palindrome(listOfVectors) ? "Palindrome" : "Not a Palindrome");
    }
    public MyVector convertToMyVector(String str){
		double[] initValues = new double[str.length()];
		char[] chars = str.toCharArray();
		for (int i = 0; i < str.length(); i++){
			char c = chars[i];
			if(Character.isDigit(c)){
				initValues[i] = Double.parseDouble(Character.toString(c));
			}
		}
		return new MyVector(initValues);
    }
    public boolean palindrome(LinkedList<MyVector> list){
		boolean localBool = false;
	    ListIterator<MyVector> start = list.listIterator();
	    ListIterator<MyVector> back = list.listIterator(list.size());
	    for (int i = list.size() / 2; i > 0; i--){
		    localBool = start.next().equals(back.previous());
	    }
		return localBool;
    }
    private void print(Object obj){
        System.out.print(obj);
    }
    private void println(Object obj){
    	System.out.println(obj);
    }
}
