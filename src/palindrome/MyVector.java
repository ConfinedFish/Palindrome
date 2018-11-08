package palindrome;

import java.util.ArrayList;

/**
 * MyVector Object.
 * Used to store arraylists and provide methods to manipulate the lists.
 */
public class MyVector {
    private final ArrayList<Double> myVector;
    
    /**
     * Constructor for a MyVector object.
     * @param initValues - initial values for the array
     */
    public MyVector(double[] initValues){
        myVector = new ArrayList<>();
        for (double initvalue : initValues) {
            myVector.add(initvalue);
        }
    }

    /**
     * Copy constructor for a MyVector object.
     * Uses a for loop to iterate over each value in the array and copies them to a new array.
     * @param source - MyVector object to copy values from.
     */
    public MyVector(MyVector source){
        myVector = new ArrayList<>();
        for (int i = 0; i < source.getLength(); i++){
            myVector.add(source.getValueAt(i));
        }
    }

    /**
     * Gets the length of the array.
     * @return length as an int
     */
    public int getLength(){
        return myVector.size();
    }

    /**
     * Gets a value at a specific position in the array.
     * If the position is not in the array or is a negative number the method returns 0.
     * @param k - index to get the value from.
     * @return value at the specified location.
     */
    public double getValueAt(int k){
        if (k > myVector.size() || k < 0){
            return 0;
        }
        return myVector.get(k);
    }

    /**
     * Sets the value at a specific position in the array.
     * If the position is larger than the size of the array, the value is added to the last index of the array.
     * If the position is less than 0, the value is set to the first index of the array.
     * @param k - index to set the value of.
     * @param value - value to set.
     */
    public void setValueAt(int k, double value){
        if (k > myVector.size()){
            myVector.add(value);
        }else if(k < 0){
            myVector.set(0, value);
        }
        else{
            myVector.set(k, value);
        }
    }

    /**
     * Add a value to the array.
     * @param value - value to add to the array.
     */
    public void add(double value){
        myVector.add(value);
    }

    /**
     * Checks whether the two MyVector objects are equal.
     * @param source - MyVector object to check against the current object.
     * @return - true if the objects are equal and false if they are unequal.
     */
    @Override
    public boolean equals(Object source){
        if (!(source instanceof MyVector)){
            return false;
        }
        MyVector localVector = (MyVector)source;
        if(localVector.getLength() != this.getLength()){
        	return false;
        }
        for (int i = 0; i < myVector.size(); i++){
            if (myVector.get(i) != localVector.getValueAt(i)){
                return false;
            }
        }
        return true;
    }

    /**
     * Iterates over the array and prints out each value.
     * @return string containing the values of the array.
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (Double value : myVector) {
            str.append(value.toString()).append(" ");
        }
        return str.toString();
    }

    /**
     * Adds the values of two MyVector objects together.
     * @param source - MyVector object to add to the current object.
     * @return a new MyVector object containing the added values.
     * @throws Exception if the MyVector Arrays are unequal.
     */
    public MyVector plus(MyVector source) throws Exception{
        if(source.getLength() != this.getLength()){
            throw new Exception();
        }
        MyVector localVector = new MyVector(new double[0]);
        for (int i = 0; i < source.getLength(); i++){
            double value = myVector.get(i) + source.getValueAt(i);
            localVector.add(value);
        }
        return localVector;
    }
    /**
     * Subtracts the values of two MyVector objects from each other.
     * @param source - MyVector object to subtract from the current object.
     * @return a new MyVector object containing the subtracted values.
     * @throws Exception if the MyVector Arrays are unequal.
     */
    public MyVector minus(MyVector source) throws Exception{
        if(source.getLength() != this.getLength()){
            throw new Exception();
        }
        MyVector localVector = new MyVector(new double[0]);
        for (int i = 0; i < source.getLength(); i++){
            double value = myVector.get(i) - source.getValueAt(i);
            localVector.add(value);
        }
        return localVector;
    }

    /**
     * Multiplies the entire array by a specified value.
     * @param scale - value to scale the array.
     * @return a new MyVector object containing the new values.
     */
    public MyVector scaleBy(int scale){
        MyVector localVector = new MyVector(new double[0]);
        for (Double value : myVector) {
            localVector.add(value * scale);
        }
        return localVector;
    }

    /**
     * Gets the absolute value of the MyVector object.
     * @return a new MyVector object containing the new values.
     */
    public MyVector abs(){
        MyVector localVector = new MyVector(this);
        for (int i = 0; i < localVector.getLength(); i++){
            localVector.setValueAt(i, Math.sqrt(localVector.getValueAt(i) * localVector.getValueAt(i)));
        }
        return localVector;
    }

    /**
     * Multiplies the values of two MyVector objects, then adds those values together.
     * @param source - MyVector object to multiply the current object.
     * @return the total value of the multiplication and addition.
     */
    public double dotProduct(MyVector source){
        double collect = 0.0;
        for (int i = 0; i < source.getLength(); i++){
            collect += (myVector.get(i) * source.getValueAt(i));
        }
        return collect;
    }
}
