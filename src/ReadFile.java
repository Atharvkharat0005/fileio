import JdbcPrictices.Connector;

import java.sql.*;

public class ReadFile {


        public static String read(){

            Connection c =  Connector.getConnection();
            String str = "";

            try {



                String q = "SELECT id, File_Name FROM documents";

                PreparedStatement pstmt = c.prepareStatement(q);

                ResultSet rs = pstmt.executeQuery();

                System.out.println("ID\tFile Name");
                System.out.println("--------------------");

                while (rs.next()) {

                    int id = rs.getInt("id");
                    String fileName = rs.getString("File_Name");

                    System.out.println(id + "\t" + fileName);
                    str+=(id + "\t" + fileName+"\n");
                }

                rs.close();
                pstmt.close();
                c.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }


