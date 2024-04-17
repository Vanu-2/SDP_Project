/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author USER
 */
import java.io.*;

public class PasswordChanger {
    public static boolean changed_password = true;
    
   public static void changePassword(String oldUsername, String oldPassword, String newPassword) {
        boolean passwordChanged = false; // Flag to indicate if password was changed
        
        try {
            File file = new File("users.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length >= 2) {
                    String username = parts[0];
                    String password = parts[1];

                    if (username.equals(oldUsername) && password.equals(oldPassword)) {
                        writer.write(oldUsername + ":" + newPassword);
                        passwordChanged = true; // Set flag to true if password was changed
                    } else {
                        writer.write(line);
                    }
                    writer.newLine();
                } else {
                    System.out.println("Invalid line format: " + line); // Add logging
                }
            }
            reader.close();
            writer.close();
            if (!file.delete()) {
                System.out.println("Could not delete file");
                return;
            }
            
            if (!tempFile.renameTo(file)) {
                System.out.println("Could not rename file");
                return;
            }
          
            
            // Display appropriate message based on flag value
            if (passwordChanged) {
                System.out.println("Password changed successfully");
            } else {
                System.out.println("No valid username and password found");
            }
            //return  passwordChanged;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        change(passwordChanged);
    }
   public static void change(boolean b)
   {
       changed_password = b;
   }
   public static boolean getstatus()
   {
       return changed_password;
   }

}
