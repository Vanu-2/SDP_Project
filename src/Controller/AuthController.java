/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class AuthController {
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
     public class MockOptionPane extends JOptionPane {
    private String lastMessage;

    public void showMessageDialog(Object parentComponent, Object message) {
        lastMessage = (String) message;
    }

//    static void setOptionPane(AuthControllerIT.MockOptionPane optionPane) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//    
}
}
