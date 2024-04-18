/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controller;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.text.ParseException;

public class ClearAllTaskTest {

    // Test case to verify clearing all tasks
    @Test
    public void testClearAllTasks() throws ParseException {
        // Prepare a temporary Task.txt file with some tasks
        String fileName = "Task.txt";
        try {
            PrintWriter writer = new PrintWriter(fileName);
            writer.println("Task 1, 12:00, 2024-04-01");
            writer.println("Task 2, 10:00, 2024-04-03");
            writer.close();
        } catch (FileNotFoundException e) {
            fail("Could not create test file: " + e.getMessage());
        }

        // Call the clearAllTasks method
        try {
            TaskManagerHelper.clearAllTasks();
        } catch (IOException | ParseException e) {
            fail("Error clearing tasks: " + e.getMessage());
        }

        // Check if the file is empty
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            boolean isEmpty = true;
            while ((line = reader.readLine()) != null) {
                isEmpty = false; // If there is any line, the file is not empty
                break;
            }
            reader.close();
            assertTrue("All tasks should be cleared", isEmpty);
        } catch (IOException e) {
            fail("Error reading test file: " + e.getMessage());
        }
    }
}
