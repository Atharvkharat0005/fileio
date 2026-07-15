import JdbcPrictices.Connector;

import javax.swing.*;
import java.sql.*;
import java.io.*;

import static JdbcPrictices.Connector.con;

class UploadFile {

   public static void upload() {


            Connection c =  Connector.getConnection();

       JFileChooser jfc = new JFileChooser();

       int result = jfc.showOpenDialog(null);

            try {

//laod Driver





//                Class.forName("com.mysql.cj.jdbc.Driver");
//
//
//                String url = "jdbc:mysql://localhost:3306/payment";
//                String username = "root";
//                String password = "root";
//
//                Connection con = DriverManager.getConnection(url,username,password);



                 if (result== JFileChooser.ERROR_OPTION ){
                     System.out.println("Error");

                 }
                String q = "INSERT INTO documents (File_Name, File_Blob) VALUES (?, ?)";

                PreparedStatement pstmt = c.prepareStatement(q);

                if (result == JFileChooser.APPROVE_OPTION) {

                    File file = jfc.getSelectedFile();

                    FileInputStream fis = new FileInputStream(file);

                    pstmt.setString(1, file.getName()); // First parameter = File_Name

                    pstmt.setBlob(2, fis);              // Second parameter = image

                    int rows = pstmt.executeUpdate();

                    if (rows > 0) {
                        System.out.println("File uploaded successfully!");
                    }
                }

//                FileInputStream fis = new FileInputStream("C:/Users/SAI/OneDrive/cloud/Desktop/Demoimg.jpg");



                System.out.println("inserted....");

                JOptionPane.showMessageDialog(null, "Done");

                con.close();

            } catch (Exception e) {
                e.printStackTrace();

            }






    }
}