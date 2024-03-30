/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
///import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author partho
 */
//import org.junit.jupiter.api.Test;
//import org.junit.Test;

public class TaskManagerTest {

  //  @Test
//   


    @Test
    public void testAddTask() throws IOException {
        // Define the task details
        String task = "Task1";
        String time = "10:00";
        String date = "2024-03-29";
        String task1 = "Task1";
        String time1 = "10:00";
        String date1 = "2024-03-29";

        // Call the addTask method
        TaskManager.addTask(task, time, date);

        // Read the contents of the file and verify the task details
        try (BufferedReader reader = new BufferedReader(new FileReader("Task.txt"))) {
            String line;
            boolean taskFound = false;
            while ((line = reader.readLine()) != null) {
                // Split the line by commas and check if it contains the task, time, and date
                String[] parts = line.split(",");
                if (parts.length == 3 && parts[0].trim().equals(task1) && parts[1].trim().equals(time1) && parts[2].trim().equals(date1)) {
                    taskFound = true;
                    break;
                }
            }
            assertTrue(taskFound, "Task not found in the file.");
        } catch (IOException e) {
            System.out.println(e);
            //fail(e.getMessage() + "IOException occurred while reading the file: ");
        }
    }
}

//    partho  ,    11:11  ,  2024-03-23  
//    partho  ,    11:11  ,  2024-03-23  
//      partho  ,    11:11  ,  2024-03-23  

