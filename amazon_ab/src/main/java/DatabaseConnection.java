import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection
    {
        public DatabaseConnection
        {

            String url = "jdbc:postgresql://localhost:5435/amazon";
            String User = "postgres";
            String Password = "ROOT"   ;


            try
            {
                Connection C = DriverManager.getConnection(url, User, Password);
                System.out.println("PostgreSql connected Successfully");
                return C;
            }


            catch (SQLException e)
            {
                System.out.println("Connection Failed");
                System.out.println("error" + e.getMessage());
                e.printStackTrace();
                return null;
            }

        }

    }