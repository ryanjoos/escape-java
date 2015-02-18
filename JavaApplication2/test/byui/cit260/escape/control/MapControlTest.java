/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author owner
 */
public class MapControlTest {
    
    public MapControlTest() {
    }

    /**
     * Test of move method, of class MapControl.
     */
    @Test
    public void testCalcRunSpeed() {
        System.out.println("calcRunSpeed Test 1");
        double time = 30.0;
        double distance = 2.0;
        MapControl instance = new MapControl();
        double expResult = 4.0;
        double result = instance.calculateRunningSpeed(time,distance);
        assertEquals(expResult, result, 0.001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        /**********************************
        * Test Case two
        ***********************************/
        System.out.println("calcRunSpeed Test 2");
        time = 45.0;
        distance = -1.0;
        expResult = -1;
        result = instance.calculateRunningSpeed(time,distance);
        assertEquals(expResult, result, 0.001);
       
        /**********************************
        * Test Case Three
        ***********************************/
        System.out.println("calcRunSpeed Test 3");
        time = -1.0;
        distance = 0.5;
        expResult = -1;
        result = instance.calculateRunningSpeed(time,distance);
        assertEquals(expResult, result, 0.001);

        /**********************************
        * Test Case Four
        ***********************************/
        System.out.println("calcRunSpeed Test 4");
        time = 'b';
        distance = 1.0;
        expResult = -1;
        result = instance.calculateRunningSpeed(time,distance);
        assertEquals(expResult, result, 0.001);
        
        /**********************************
        * Test Case Five
        ***********************************/
        System.out.println("calcRunSpeed Test 5");
        time = 40.0;
        distance = 0.0;
        expResult = -1;
        result = instance.calculateRunningSpeed(time,distance);
        assertEquals(expResult, result, 0.001);
        
        /**********************************
        * Test Case Six
        ***********************************/
        System.out.println("calcRunSpeed Test 6");
        time = 40.0;
        distance = 0.5;
        expResult = 0.75;
        result = instance.calculateRunningSpeed(time,distance);
        assertEquals(expResult, result, 0.001);
        
        /**********************************
        * Test Case Seven
        ***********************************/
        System.out.println("calcRunSpeed Test 7");
        time = 45.0;
        distance = 2.0;
        expResult = 2.66667;
        result = instance.calculateRunningSpeed(time,distance);
        assertEquals(expResult, result, 0.001);
    }
    
}
