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

public class TaskSortTimeTest {

    // Test case to verify sorting tasks alphabetically
    // Test case to verify sorting tasks by time
@Test
public void testSortTasksByTime() {
    // Prepare a temporary Task_ByTime.txt file with sample unsorted tasks
    String fileName = "Task_ByTime.txt";
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
    try {
        TaskManagerHelper.sortTasksByTimeAndRewriteFile(fileName);
    } catch (IOException | ParseException e) {
        fail("Error sorting tasks: " + e.getMessage());
    }

    // Check if tasks are sorted by time
    try {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm, yyyy-MM-dd");
        Date prevDateTime = null;
        String line;
        boolean sorted = true;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(", ");
            Date dateTime = sdf.parse(parts[1] + ", " + parts[2]); // Parse time and date separately
            if (prevDateTime != null && prevDateTime.compareTo(dateTime) > 0) {
                sorted = false;
                break;
            }
            prevDateTime = dateTime;
        }
        reader.close();
        assertTrue("Tasks should be sorted by time and date", sorted);
    } catch (IOException | ParseException e) {
        fail("Error reading test file: " + e.getMessage());
    }
}


}
