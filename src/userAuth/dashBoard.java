
package userAuth;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class dashBoard extends javax.swing.JFrame {

    private LogIn loginFrame;
    public dashBoard(LogIn loginFrame) {
        this.loginFrame = loginFrame;
        initComponents();
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setdataToTable(); 
    }
    private void setdataToTable(){
       DefaultTableModel dtm=(DefaultTableModel) jTable1.getModel();
       JTableHeader s= jTable1.getTableHeader();
        s.setBackground(Color.ORANGE);
       int rc=dtm.getRowCount();
       while(rc--!=0)
       {
           dtm.removeRow(0);
       }
        try{
     FileInputStream f= new FileInputStream("Task.txt");
     Scanner sc = new Scanner(f);
     //System.out.println(scr.nextLine());
     while (true)
     {
     try 
     { 
        Vector row =new Vector();
        row.add(sc.nextLine());
        dtm.addRow(row);
     }
     catch(Exception ex)
        {
           break;
        }
     f.close();
     }
         
    }catch(Exception ex)
        {
        }
    }
     private void setdataToTable2(){
       DefaultTableModel dtm=(DefaultTableModel) jTable1.getModel();
      
        try{
     FileInputStream f= new FileInputStream("Task.txt");
     Scanner sc = new Scanner(f);
     while (true)
     {
     try 
     { 
        Vector row =new Vector();
        row.add(sc.nextLine());
        dtm.addRow(row);
     }
     catch(Exception ex)
        {
           break;
        }
     f.close();
   }
         
    }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        t = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TaskManager Pro");

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TaskManager Pro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText(" Task");

        t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add Task");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(102, 255, 255));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(153, 0, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Task list with Time"
            }
        ));
        jTable1.setSelectionForeground(new java.awt.Color(102, 102, 0));
        jTable1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jTable1CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable1InputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setForeground(new java.awt.Color(102, 0, 102));
        jButton2.setText("Delete Task");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Time(HH:mm)");

        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("Sort Alphabeticaly");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 51, 51));
        jButton5.setForeground(new java.awt.Color(51, 51, 255));
        jButton5.setText("Clear all Tasks");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel4.setText("Date(yyyy-MM-dd)");

        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 102));
        jButton4.setForeground(new java.awt.Color(102, 0, 102));
        jButton4.setText("Sort By Time");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(102, 0, 102));
        jButton6.setText("Change Password");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(27, 27, 27))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(t)
                                            .addComponent(t1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(41, 41, 41)
                                        .addComponent(t2, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel3, jLabel4});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(t, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(t1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(t2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jLabel1, jLabel3, jLabel4});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        if (t.getText().equals("")||t1.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please enter all value");
        }
        else
        {
            try{
            FileOutputStream f= new FileOutputStream("Task.txt",true);
            PrintStream p=new PrintStream(f);
            String task = t.getText();
            String time = t1.getText();
            String date = t2.getText();
            task=task +",     ";
            task+=time+",      ";
             task+=date;
           //new ArrayList<>().add(new Task(taskName, time, date));
            p.println(task);
             JOptionPane.showMessageDialog(rootPane, "Task Added Successfully");
           setdataToTable();
             p.close();
            f.close();
            t.setText(null);
            t1.setText(null);
            t2.setText(null);
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
           }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tActionPerformed
        // TODO add your handling code here:
        JTableHeader s= jTable1.getTableHeader();
        s.setBackground(Color.ORANGE);
    }//GEN-LAST:event_tActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int ri = jTable1.getSelectedRow();
        if(ri!= -1)
        {
            String task= (String)jTable1.getValueAt(ri,0);
              
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
         if (!task.equalsIgnoreCase(s))
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
     setdataToTable();
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null,ex.getMessage());
            } 
        }
        else
        {
             JOptionPane.showMessageDialog(null,"please select task");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String filePath = "task.txt"; // Change this to your file path

       ArrayList <String> lines = new ArrayList<>();

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
            bw.close();
              JOptionPane.showMessageDialog(rootPane, "Sorted Successfully");
           setdataToTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         try {
        FileWriter fw = new FileWriter("Task.txt");
        fw.write(""); // Writing an empty string clears the file
        fw.close();
        JOptionPane.showMessageDialog(rootPane, "Cleared all taskss Successfully");// Clear the table
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0); // Set the row count to 0 to clear all rows
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Error clearing tasks: " + ex.getMessage());
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t2ActionPerformed

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
          try {
            ArrayList<Task> tasks = readTasksFromFile("task.txt");
            Collections.sort(tasks, new Comparator<Task>() {
                @Override
                public int compare(Task t1, Task t2) {
                    return t1.getTime().compareTo(t2.getTime());
                }
            });
            writeTasksToFile("task.txt", tasks);
            // bw.close();
              JOptionPane.showMessageDialog(rootPane, "Sorted Successfully");
           setdataToTable();
           
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable1CaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1CaretPositionChanged

    private void jTable1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable1InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1InputMethodTextChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        ChangePassword changePassword = new ChangePassword();
    changePassword.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed
    private ArrayList<Task> readTasksFromFile(String filename) throws IOException, ParseException {
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

    private void writeTasksToFile(String filename, ArrayList<Task> tasks) throws IOException {
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
    public static void main(String args[]) { 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField t;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    // End of variables declaration//GEN-END:variables

    private static class Stirng {

        public Stirng() {
        }
    }
}
