import JdbcPrictices.Connector;

import java.sql.Connection;
import java.sql.*;
import java.util.Scanner;

public class DeleteFile {

    public static void delete() {
        Scanner sc = new Scanner(System.in);

        Connection c = Connector.getConnection();

        try{

            String q ="DELETE FROM documents WHERE id=?";

            PreparedStatement pstmt = c.prepareStatement(q);

            System.out.print("Enter the File ID you want to Delete: ");

            int id = sc.nextInt();

            pstmt.setInt(1, id);


            int rows = pstmt.executeUpdate();

            if (rows > 0) {

                System.out.println("File Deleted Successfully!");

            } else {

                System.out.println("File Not Found!");

            }

            pstmt.close();
            c.close();


        } catch (Exception e) {
            e.printStackTrace();
        }




    }



}
