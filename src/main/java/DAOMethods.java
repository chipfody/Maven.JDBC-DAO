import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.util.Set;

public class DAOMethods implements UserDao {

    public String findCarById(int idNumber) {
        Connection connection = getConnection.makeConnection ();
        try {
            Statement stmt = connection.createStatement ();
            ResultSet rs = stmt.executeQuery ( "SELECT * FROM Car_Data WHERE id =" + idNumber );
            if (rs.next ()) {
                DAOModel carModel = new DAOModel ( idNumber );
                carModel.setId ( rs.getInt ( "id" ) );
                carModel.setMake ( rs.getString ( "Make" ) );
                carModel.setModel ( rs.getString ( "Model" ) );
                carModel.setYear ( rs.getString ( "Model_Year" ) );
                carModel.setColor ( rs.getString ( "Color" ) );

                return carModel.getMake ();
            }
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        return "Car is not registered";
    }

    public Boolean insertCar() {
        Connection connection = getConnection.makeConnection ();
        try {
            PreparedStatement prepState = connection.prepareStatement ( "INSERT INTO Car_Data VALUES (NULL, ?, ?, ?, ?)" );
            prepState.setString ( 1, DAOModel.getMake () );
            prepState.setString ( 2, DAOModel.getModel () );
            prepState.setString ( 3, DAOModel.getYear () );
            prepState.setString ( 4, DAOModel.getColor () );
            int inserted = prepState.executeUpdate ();

            if (inserted == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        return false;
    }
}

