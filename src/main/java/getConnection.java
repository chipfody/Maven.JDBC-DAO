import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class getConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/JDBC?serverTimezone=UTC";
    public static final String USER = "new_user";
    public static final String PASS = "password";

    private static Connection connection = null;

   public static Connection makeConnection() {
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Opened database successfully in connect");
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }return connection;
   }
    }
