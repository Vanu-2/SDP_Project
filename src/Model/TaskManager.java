/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author USER
 */
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TaskManager {
    public static void addTask(String task, String time, String date) throws IOException {
        try (FileWriter fw = new FileWriter("Task.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            String formattedTask = String.format("%s,    %s,    %s", task, time, date);
            out.println(formattedTask);
        }
    }
   
}
