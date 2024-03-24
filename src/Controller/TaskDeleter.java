/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author USER
 */
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class TaskDeleter {
   public static void deleteSelectedTask(String taskToDelete) {
        try {
                FileOutputStream f = new FileOutputStream("temp.txt");
                 PrintStream p=new PrintStream(f);
                  FileInputStream ff= new FileInputStream("task.txt");
     Scanner sc = new Scanner(ff);
     while (true)
     {
     try 
     { 
         String s=sc.nextLine();
         if (!taskToDelete.equalsIgnoreCase(s))
         {
              p.println(s);
         } 
     }
     catch(Exception ex)
        {
           break;
        }
     }
     p.close();
            sc.close();
            f.close();
            ff.close();
            File file =new File("task.txt");
     file.delete();
     File tempFile =new File ("temp.txt");
     File newFile =new File("task.txt");
     tempFile.renameTo(newFile);
     //setdataToTable();
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null,ex.getMessage());
            } 
        }
}


