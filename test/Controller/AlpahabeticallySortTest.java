/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controller;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AlpahabeticallySortTest {

    // Test case to verify sorting tasks alphabetically
    @Test
    public void testSortTasksAlphabetically() {
        // Prepare a temporary Task.txt file with sample unsorted tasks
        String fileName = "Task_Alphabetical.txt";
        try {
            PrintWriter writer = new PrintWriter(fileName);
            writer.println("Task C, 12:00, 2024-04-01");
            writer.println("Task A, 10:00, 2024-04-03");
            writer.println("Task B, 11:30, 2024-04-02");
            writer.close();
        } catch (FileNotFoundException e) {
            fail("Could not create test file: " + e.getMessage());
        }

        // Call the sort method
        TaskManagerHelper.sortTasksAlphabeticallyAndRewriteFile(fileName);

        // Check if tasks are sorted alphabetically
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String prevLine = null;
            String line;
            boolean sorted = true;
            while ((line = reader.readLine()) != null) {
                if (prevLine != null && prevLine.compareTo(line) > 0) {
                    sorted = false;
                    break;
                }
                prevLine = line;
            }
            reader.close();
            assertTrue("Tasks should be sorted alphabetically", sorted);
        } catch (IOException e) {
            fail("Error reading test file: " + e.getMessage());
        }
    }

// Test case to verify sorting tasks by time


}
