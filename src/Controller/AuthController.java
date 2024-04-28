package Controller;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Controller class for authentication functionality.
 * Validates user login credentials.
 *
 * @author USER
 */
public class AuthController {
    private static final int USERNAME_INDEX = 0; 
    private static final int PASSWORD_INDEX = 1; 
    private static final String USER_FILE_NAME = "users.txt"; 

    /**
     * Validates if the login attempt is successful.
     *
     * @param enteredUsername The username entered by the user.
     * @param enteredPassword The password entered by the user.
     * @return True if the login attempt is successful, otherwise false.
     */
    public static boolean isLoginSuccessful(String enteredUsername, String enteredPassword) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE_NAME))) {
            String line;
            boolean userFound = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length >= PASSWORD_INDEX + 1) { // Checking if parts has enough elements
                    String usernameFromFile = parts[USERNAME_INDEX];
                    String passwordFromFile = parts[PASSWORD_INDEX];
                    if (usernameFromFile.equals(enteredUsername) && passwordFromFile.equals(enteredPassword)) {
                        userFound = true;
                        break;
                    }
                }
            }
            return userFound;
        } catch(IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while reading user information");
            return false;
        }
    }
}
