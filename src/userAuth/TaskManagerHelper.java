package userAuth;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;

public class TaskManagerHelper {
 public static void clearAllTasks() throws IOException, ParseException {
        try {
            FileWriter fw = new FileWriter("Task.txt");
            fw.write(""); // Writing an empty string clears the file
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void sortTasksAlphabeticallyAndRewriteFile(String filePath) {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Collections.sort(lines);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortTasksByTimeAndRewriteFile(String filename) throws IOException, ParseException {
        ArrayList<Task> tasks = readTasksFromFile(filename);
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.getTime().compareTo(t2.getTime());
            }
        });
        writeTasksToFile(filename, tasks);
    }

    private static ArrayList<Task> readTasksFromFile(String filename) throws IOException, ParseException {
        ArrayList<Task> tasks = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String task = parts[0].trim();
            String time = parts[1].trim();
            String date = parts[2].trim();
            tasks.add(new Task(task, time, date));
        }
        reader.close();
        return tasks;
    }
    
    
    private static void writeTasksToFile(String filename, ArrayList<Task> tasks) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Task task : tasks) {
            writer.write(task.getTask() + ",    " + task.getTimeAsString() + ",    " + task.getDate());
            writer.newLine();
        }
        writer.close();
    }
    private static class Task {
        private String task;
        private Date time;
        private String date;
        public Task(String task, String time, String date) throws ParseException {
            this.task = task;
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm yyyy-MM-dd");
            this.time = sdf.parse(time + " " + date);
            this.date = date;
        }
        public Date getTime() {
            return time;
        }
        public String getTimeAsString() {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            return sdf.format(time);
        }
        // Method to get date of task
        public String getDate() {
            return date;
        }
        public String getTask() {
            return task;
        }
@Override
        public String toString() {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm yyyy-MM-dd");
            return task + ", " + sdf.format(time);
        }
    }
}
