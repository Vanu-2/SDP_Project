/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class AuthControllerIT {
  @Test
    public void testLoginSuccessful() {
        String userData = "parth0:1234";
        String enteredUsername = "partho";
        String enteredPassword = "1234";

        try (BufferedReader reader = new BufferedReader(new StringReader(userData))) {
            assertTrue("Login should be successful",
                    AuthController.isLoginSuccessful(enteredUsername, enteredPassword));
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testLoginFailed() {
        String userData = "partho:1234";
        String enteredUsername = "testUser";
        String enteredPassword = "wrongPassword";

        try (BufferedReader reader = new BufferedReader(new StringReader(userData))) {
            assertFalse("Login should fail with incorrect password",
                    AuthController.isLoginSuccessful(enteredUsername, enteredPassword));
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testFileReadError() {
        String userData = "";
        String enteredUsername = "testUser";
        String enteredPassword = "testPassword";

        try (BufferedReader reader = new BufferedReader(new StringReader(userData))) {
            assertFalse("Login should fail with IOException",
                    AuthController.isLoginSuccessful(enteredUsername, enteredPassword));
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}