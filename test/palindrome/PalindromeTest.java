/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 *
 * @author Alex
 */
public class PalindromeTest {
    MyVector vector;
    double[] initValues;
    String value;
    Palindrome pal;

    public PalindromeTest() {
    }
    
    @Before
    public void setUp() {
        initValues = new double[5];
        initValues[0] = 1.0;
        initValues[1] = 2.0;
        initValues[2] = 3.0;
        initValues[3] = 4.0;
        initValues[4] = 5.0;
        vector = new MyVector(initValues);
        value = "12345";
        pal = new Palindrome();

    }

    /**
     * Test of convertToMyVector method, of class Palindrome.
     */
    @Test
    public void testConvertToMyVector() {
        MyVector actual = pal.convertToMyVector(value);
        MyVector expected = new MyVector(vector);
        assertEquals(expected, actual);
    }

    /**
     * Test of palindrome method, of class Palindrome.
     */
    @Test
    public void testPalindrome() {
        LinkedList<MyVector> list = new LinkedList<>();
        list.add(vector);
        MyVector vector2 = new MyVector(pal.convertToMyVector("258"));
        list.add(vector2);
        MyVector vector3 = new MyVector(vector);
        list.add(vector3);
        boolean actual = pal.palindrome(list);
        boolean expected = true;
        assertEquals(expected, actual);
    }
        /**
     * Test of palindrome method, of class Palindrome.
     */
    @Test
    public void testPalindromeFail() {
        LinkedList<MyVector> list = new LinkedList<>();
        list.add(vector);
        MyVector vector2 = new MyVector(pal.convertToMyVector("258"));
        list.add(vector2);
        MyVector vector3 = new MyVector(pal.convertToMyVector("33325"));
        list.add(vector3);
        boolean actual = pal.palindrome(list);
        boolean expected = false;
        assertEquals(expected, actual);
    }
}
