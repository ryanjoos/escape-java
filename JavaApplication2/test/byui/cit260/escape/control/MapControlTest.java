/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.control;

import byui.cit260.escape.exceptions.MapControlException;
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
    public void testCalcRunSpeed() throws MapControlException {
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
    
    public void testBridgeRaftSize() {
        System.out.println("calcBridgeSize Test 1");
        double length = 10.0;
        double width = 11.0;
        double height = 0.8;
        RaftControl instance = new RaftControl();
        double expResult = 88.0;
        double result = instance.calcRaftSize(length, width, height);
        assertEquals(expResult, result, 0.001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        
        /**********************************
        * Test Case two
        ***********************************/
        System.out.println("calcBridgeSize Test 2");
        length = -1.0;
        width = 12.0;
        height = 1.0;
        expResult = -1;
        result = instance.calcRaftSize(length, width, height);
        assertEquals(expResult, result, 0.001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
       
        /**********************************
        * Test Case Three
        ***********************************/
        System.out.println("calcBridgeSize Test 3");
        length = 9.0;
        width = 12.0;
        height = -1.0;
        expResult = -1;
        result = instance.calcRaftSize(length, width, height);
        assertEquals(expResult, result, 0.001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");

        /**********************************
        * Test Case Four
        ***********************************/
         System.out.println("calcBridgeSize Test 4");
        length = 11.0;
        width = -1;
        height = 0.95;
        expResult = -1;
        result = instance.calcRaftSize(length, width, height);
        assertEquals(expResult, result, 0.001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        /**********************************
        * Test Case Five
        ***********************************/
         System.out.println("calcBridgeSize Test 5");
        length = 0.0;
        width = 15.0;
        height = 1.0;
        expResult = -1;
        result = instance.calcRaftSize(length, width, height);
        assertEquals(expResult, result, 0.001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        /**********************************
        * Test Case Six
        ***********************************/
         System.out.println("calcBridgeSize Test 6");
        length = 9.0;
        width = 9.0;
        height = 0.75;
        expResult = 60.75;
        result = instance.calcRaftSize(length, width, height);
        assertEquals(expResult, result, 0.001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        /**********************************
        * Test Case Seven
        ***********************************/
         System.out.println("calcBridgeSize Test 7");
        length = 12.0;
        width = 15.0;
        height = 1.0;
        expResult = 180.0;
        result = instance.calcRaftSize(length, width, height);
        assertEquals(expResult, result, 0.001);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
