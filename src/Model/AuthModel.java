/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author USER
 */
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
   }

