/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.control;

import byui.cit260.escape.exceptions.RaftControlException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ryanjoos
 */
public class RaftControlTest {
    
    public RaftControlTest() {
    }

    /**
     * Test of calcRaftSize method, of class RaftControl.
     */
    @Test
    public void testCalcRaftSize() throws RaftControlException {
        System.out.println("calcRaftSize Test 1");
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
        System.out.println("calcRaftSize Test 2");
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
        System.out.println("calcRaftSize Test 3");
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
         System.out.println("calcRaftSize Test 4");
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
         System.out.println("calcRaftSize Test 5");
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
         System.out.println("calcRaftSize Test 6");
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
         System.out.println("calcRaftSize Test 7");
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
