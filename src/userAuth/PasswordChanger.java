package userAuth;

import java.io.*;

public class PasswordChanger {
    public static void changePassword(String oldUsername, String oldPassword, String newPassword) {
        try {
            File file = new File("users.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Reading line: " + line); // Add logging
                String[] parts = line.split(":");
                if (parts.length >= 2) { // Add a check for array length
                    String username = parts[0];
                    String password = parts[1];

                    if (username.equals(oldUsername) && password.equals(oldPassword)) {
                        writer.write(oldUsername + ":" + newPassword);
                        System.out.println("Password changed successfully");
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
            System.out.println("User info updated successfully");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
