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
    
    public PalindromeTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of convertToMyVector method, of class Palindrome.
     */
    @Test
    public void testConvertToMyVector() {
        System.out.println("convertToMyVector");
        String str = "";
        Palindrome instance = new Palindrome();
        MyVector expResult = null;
        MyVector result = instance.convertToMyVector(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of palindrome method, of class Palindrome.
     */
    @Test
    public void testPalindrome() {
        System.out.println("palindrome");
        LinkedList<MyVector> list = null;
        Palindrome instance = new Palindrome();
        boolean expResult = false;
        boolean result = instance.palindrome(list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
