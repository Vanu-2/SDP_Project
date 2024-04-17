/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controller;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

public class TaskDeleterTest {
    
    // Test case to verify deletion of a task from task.txt
    @Test
    public void testDeleteSelectedTask() {
        // Prepare a temporary task.txt file with sample tasks
        String fileName = "task.txt";
        try {
            PrintWriter writer = new PrintWriter(fileName);
            writer.println("Task 1, 11:11, 2024-12-12");
            writer.println("Task 2, 12:12, 2024-12-13");
            writer.println("Task 3, 13:13, 2024-12-14");
            writer.close();
        } catch (FileNotFoundException e) {
            fail("Could not create test file: " + e.getMessage());
        }

        // Call the deleteSelectedTask method to delete a task
        TaskDeleter.deleteSelectedTask("Task 2, 12:12, 2024-12-13");

        // Check if the task was deleted successfully
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Task 2")) {
                    count++;
                }
            }
            reader.close();
            assertEquals("Task should be deleted from file", 0, count);
        } catch (IOException e) {
            fail("Error reading test file: " + e.getMessage());
        }
    }
}
