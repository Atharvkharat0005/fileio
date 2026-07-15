import JdbcPrictices.Connector;

import java.sql.*;
import java.io.*;
import java.util.Scanner;

import static JdbcPrictices.Connector.con;


public class RetrieveFile {

    static void retrieve() {

            Connection c =  Connector.getConnection();

         try{

             String q = "SELECT * FROM documents WHERE id = ?";

             PreparedStatement pstmt = c.prepareStatement(q);

             Scanner sc = new Scanner(System.in);

             System.out.print("Enter File ID: ");

             int id = sc.nextInt();

             pstmt.setInt(1, id);

             // Step 3: Execute query
             ResultSet rs = pstmt.executeQuery();

             // Step 4: Check if file exists
             if (rs.next()) {

                 // Get file name
                 String fileName = rs.getString("File_Name");

                 // Get Blob
                 Blob blob = rs.getBlob("File_Blob");

                 // Convert Blob to InputStream
                 InputStream is = blob.getBinaryStream();

                 // Location where file will be saved
                 FileOutputStream fos = new FileOutputStream(
                         "C:\\Users\\SAI\\OneDrive\\cloud\\Desktop\\" + fileName);

                 // Read and write data
                 byte[] buffer = new byte[1024];
                 int bytesRead;

                 while ((bytesRead = is.read(buffer)) != -1) {
                     fos.write(buffer, 0, bytesRead);
                 }

                 fos.close();
                 is.close();

                 System.out.println("File Retrieved Successfully!");

             } else {

                 System.out.println("No File Found!");

             }

             rs.close();
             pstmt.close();
             con.close();




         } catch (Exception e) {
             e.printStackTrace();
         }






        }

    }


