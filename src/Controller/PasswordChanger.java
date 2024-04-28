package Controller;

import java.io.*;

public class PasswordChanger {
    private static final int USERNAME_INDEX = 0;
    private static final int PASSWORD_INDEX = 1;
    private static final String USER_FILE_NAME = "users.txt"; 
    private static final String TEMP_FILE_NAME = "temp.txt"; 

    public static boolean changed_password = true;

    public static void changePassword(String oldUsername, String oldPassword, String newPassword) {
        boolean passwordChanged = false; // Flag to indicate if password was changed

        try {
            File file = new File(USER_FILE_NAME);
            File tempFile = new File(TEMP_FILE_NAME);

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length >= PASSWORD_INDEX + 1) {
                    String username = parts[USERNAME_INDEX];
                    String password = parts[PASSWORD_INDEX];

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

    public static void change(boolean b) {
        changed_password = b;
    }

    public static boolean getstatus() {
        return changed_password;
    }

}
