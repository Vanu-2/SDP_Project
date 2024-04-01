package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PasswordChangerTest {
    
    private final String testFilePath = "users.txt";

    @Before
   public void setUp() throws IOException {
    // Original content of the test file
    String originalContent = "partho:1234\n" +
                             "user2:pass2\n" +
                             "user3:pass3\n";

    // Append the original content to the test file
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFilePath, true))) {
        writer.write(originalContent);
    }
}


    

    @Test
    public void testChangePassword_Successful() {
        // Test changing password for an existing user
        PasswordChanger.changePassword("user2", "pass2", "newpass");

        // Verify if the password is changed correctly
        try (BufferedReader reader = new BufferedReader(new FileReader(testFilePath))) {
            String line;
            boolean user2Found = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String username = parts[0];
                String password = parts[1];
                if (username.equals("user2")) {
                    assertEquals("newpass", password);
                    user2Found = true;
                }
            }
            assertTrue("User2's password should be changed", user2Found);
        } catch (IOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidCredentials_NoChange() {
        // Test changing password with invalid old credentials
        PasswordChanger.changePassword("user2", "wrongpass", "newpass");

        // Verify that password remains unchanged
        try (BufferedReader reader = new BufferedReader(new FileReader(testFilePath))) {
            String line;
            boolean user2Found = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String username = parts[0];
                String password = parts[1];
                if (username.equals("user2")) {
                    assertEquals("pass2", password);
                    user2Found = true;
                }
            }
            assertTrue("User2's password should remain unchanged", user2Found);
        } catch (IOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}