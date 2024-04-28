package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EditTask {
    private static final int TASK_INDEX = 0;
    private static final int TIME_INDEX = 1;
    private static final int DATE_INDEX = 2;

    public static void editTask(String task, String time, String date) throws IOException {
        // Read the contents of the Task.txt file
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("task.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split each line by ","
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String existingTask = parts[TASK_INDEX].trim();
                    String existingTime = parts[TIME_INDEX].trim();
                    String existingDate = parts[DATE_INDEX].trim();
                    
                    // Check if the task, time, and date match
                    if (existingTask.equals(task)) {
                        // If a match is found, update the line with the new values
                        line = task + ", " + time + ", " + date;
                    }
                }
                lines.add(line);
            }
        }
        
        // Write the updated contents back to the Task.txt file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Task.txt"))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
