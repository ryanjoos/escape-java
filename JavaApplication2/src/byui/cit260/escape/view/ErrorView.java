/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.escape.view;

import escapePackage.Escape;
import java.io.PrintWriter;

/**
 *
 * @author Carissa
 */
public class ErrorView {

    public static final PrintWriter errorFile = Escape.getOutFile();
    public static final PrintWriter logFile = Escape.getLogFile();

    public static void display(String className, String errorMessage) {
        errorFile.println(
                "------------------------------------------------------------"
                + "\n- ERROR - " + errorMessage
                + "\n----------------------------------------------------------");

        // log error
        logFile.println(className + " - " + errorMessage);
    }
}
