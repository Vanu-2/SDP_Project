/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class AuthModelTest {

    @Test
    public void testPerformUserRegistration() {
        Map<String, String> regUser = new HashMap<>();

        // Test case 1: Valid registration
        String userName1 = "partho";
        String password1 = "1234";
        AuthModel.performUserRegistration(userName1, password1, regUser);
        assertTrue("Registration failed for valid input", regUser.containsKey(userName1));

       
        // Test case 2: Empty username
        String userName3 = "";
        String password3 = "234";
        AuthModel.performUserRegistration(userName3, password3, regUser);
        assertFalse("Registration succeeded for empty username", regUser.containsKey(userName3));

        // Test case 3: Empty password
        String userName4 = "susmita";
        String password4 = "";
        AuthModel.performUserRegistration(userName4, password4, regUser);
        assertFalse("Registration succeeded for empty password", regUser.containsKey(userName4));

        // Test case 5: Valid registration with existing username
           }
}
