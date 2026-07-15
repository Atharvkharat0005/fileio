package JdbcPrictices;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {

public static Connection con;

    public static Connection getConnection() {

    try {
        if (con == null || con.isClosed()) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DocStore", "root", "root");
        }
    }catch(Exception e){

        e.printStackTrace();

    }
        return con;


    }
}

