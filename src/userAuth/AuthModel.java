
package userAuth;

import java.io.BufferedReader;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class AuthModel {
    public static void performUserRegistration(String userName, String password, Map<String, String> regUser) {
        if (!userName.isEmpty() && password.length() > 0) {
            if (!regUser.containsKey(userName)) {
                regUser.put(userName, password);
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true));
                    writer.write(userName + ":" + password);
                    writer.newLine();
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Sign-up successful");
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error occurred, try again");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username already exists");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Username or password cannot be empty");
        }
    }
    
    public static boolean isLoginSuccessful(String enteredUsername, String enteredPassword) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            boolean userFound = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length >= 2) {
                    String usernameFromFile = parts[0];
                    String passwordFromFile = parts[1];
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
