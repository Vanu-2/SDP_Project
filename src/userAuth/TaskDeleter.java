package userAuth;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class TaskDeleter {
    public static void deleteSelectedTask(String taskToDelete) {
        try {
            File inputFile = new File("task.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // Trim newline when comparing lines
                String trimmedLine = currentLine.trim();
                if (!taskToDelete.equalsIgnoreCase(trimmedLine)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }

            writer.close();
            reader.close();

            // Delete original file
            if (!inputFile.delete()) {
                JOptionPane.showMessageDialog(null, "Error deleting the original file.");
                return;
            }

            // Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inputFile)) {
                JOptionPane.showMessageDialog(null, "Error renaming the temporary file.");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
