package palindrome;

import java.io.File;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Palindrome {
    /**
     * Main method of the program. Calls the run() method.
     * @param args args
     */
    public static void main(String[] args) {
        new Palindrome().run();
    }
	
	/**
	 * This method runs the conversions of the program. The input is parsed from a file
	 * and processed. Each line of the file is loaded as a string, and processed
	 * individually. If the file doesnt exist, the program exits with the invalid file
	 * message printed. This is because the file name is hard coded and does not depend on
	 * user input.
	 */
	private void run(){
        File file = new File("files.txt");
        Scanner scanner;
        LinkedList<MyVector> listOfVectors = new LinkedList<>();
        try{
            scanner = new Scanner(file);
            while (scanner.hasNext()){
                listOfVectors.add(convertToMyVector(scanner.nextLine()));
            }
	        print(palindrome(listOfVectors) ? "Palindrome" : "Not a Palindrome");
        } catch (Exception e){
                print("Invalid file.");
        }
    }
	
	/**
	 * Analyzes a string and builds a MyVector object based on the string. This takes
	 * the string and converts it into a Character array. Then, the method iterates over
	 * the the array, and checks if it is a digit, then converts it into a double and
	 * stores it in a double array. The purpose of this is to convert a string into a
	 * double array and pass it into a new MyVector. Then the method returns the newly
	 * constructed MyVector object.
	 * @param str The string to convert into a MyVector object
	 * @return a new MyVector object with the values of the string stored
	 */
	MyVector convertToMyVector(String str){
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
	
	/**
	 * This method takes a LinkedList of MyVector objects and determines if the list is
	 * a palindrome. The definition of a palindrome is a sequence that can be reversed
	 * without changing what the value is. For example, ABABA can be reversed and will not
	 * be different from the initial value. The way the method checks this is to create
	 * two iterator objects, one at the start and one at the end of the list. A loop that
	 * executes the size of the list divided by 2 moves the iterator at the start forward and the
	 * iterator at the end backwards to meet in the middle, each time, checking the values each
	 * iterator against the other. From this a boolean value will be set and returned based
	 * on the result of the checks.
	 * @param list The list to check
	 * @return true if the list is a palindrome and false if it is not
	 */
	boolean palindrome(LinkedList<MyVector> list){
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
