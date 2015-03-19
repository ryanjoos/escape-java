/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.control;

import byui.cit260.escape.model.Item;
import byui.cit260.escape.model.Map;
import byui.cit260.escape.model.Player;
import byui.cit260.escape.model.Scene;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carissa
 */
public class GameControlTest {

    public GameControlTest() {
    }

    /**
     * Test of getTotalResources method, of class GameControl.
     */
    @Test
    public void testGetTotalResources() {
        System.out.println("getTotalResources");

        /**********************************
         * Test Case #1 
         *******************************/
        System.out.println("getTotalResources 1");
        // input values
        int days = 16;

        // expected outcome
        int expResult = 560;

        // create instance
        GameControl instance = new GameControl();

        // call function to run the test
        int result = instance.getTotalResources(days);

        // compare expected return with actual value returned 
        assertEquals(expResult, result, 0.0001);

        /**********************************
         * Test Case #2 
         *******************************/
        System.out.println("getTotalResources 2");
        // input values
        days = 50;

        // expected outcome
        expResult = -1;

        // call function to run the test
        result = instance.getTotalResources(days);

        // compare expected return with actual value returned 
        assertEquals(expResult, result, 0.0001);

        /**********************************
         * Test Case #3 
         *******************************/
        System.out.println("getTotalResources 3");
        // input values
        days = -1;

        // expected outcome
        expResult = -1;

        // call function to run the test
        result = instance.getTotalResources(days);

        // compare expected return with actual value returned 
        assertEquals(expResult, result, 0.0001);

        /*******************************
         * Test Case #4
        *******************************/
        System.out.println("getTotalResources 4");
        // input values
        days = 'b';

        // expected outcome
        expResult = -1;

        // call function to run the test
        result = instance.getTotalResources(days);

        // compare expected return with actual value returned 
        assertEquals(expResult, result, 0.0001);
        
        /******************************
         * Test Case #5
        *******************************/
        System.out.println("getTotalResources 5");
        // input values
        days = 0;

        // expected outcome
        expResult = -1;

        // call function to run the test
        result = instance.getTotalResources(days);

        // compare expected return with actual value returned 
        assertEquals(expResult, result, 0.0001);
        
        /******************************
         * Test Case #6
        *******************************/
        System.out.println("getTotalResources 6");
        // input values
        days = 1;

        // expected outcome
        expResult = 35;

        // call function to run the test
        result = instance.getTotalResources(days);

        // compare expected return with actual value returned 
        assertEquals(expResult, result, 0.0001);
        
        /******************************
         * Test Case #7
        *******************************/
        System.out.println("getTotalResources 7");
        // input values
        days = 45;

        // expected outcome
        expResult = 1575;

        // call function to run the test
        result = instance.getTotalResources(days);

        // compare expected return with actual value returned 
        assertEquals(expResult, result, 0.0001);
        
    }

}
