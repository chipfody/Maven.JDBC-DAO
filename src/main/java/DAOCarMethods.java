import daos.UserCarDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOCarMethods implements UserCarDao {

    private DAOCarModel extractCarFromResultSet(ResultSet carLot) throws SQLException {
        DAOCarModel carModel = new DAOCarModel ();

        carModel.setId ( carLot.getInt ( "id" ) );
        carModel.setMake ( carLot.getString ( "Make" ) );
        carModel.setModel ( carLot.getString ( "Model" ) );
        carModel.setYear ( carLot.getString ( "Model_Year" ) );
        carModel.setColor ( carLot.getString ( "Color" ) );

        return carModel;
    }

    @Override
    public DAOCarModel findCarById(int idNumber) {
        Connection connection = getConnection.makeConnection ();
        try {
            Statement stmt = connection.createStatement ();
            ResultSet rs = stmt.executeQuery ( "SELECT * FROM Car_Data WHERE id =" + idNumber );
            if (rs.next ()) {
                return extractCarFromResultSet ( rs );
            }
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        System.out.println ( "Car is not registered" );
        return null;
    }

    @Override
    public List getAllCars() {
        Connection connection = getConnection.makeConnection ();
        try {
            Statement stmt = connection.createStatement ();
            ResultSet rs = stmt.executeQuery ( "SELECT * FROM Car_Data" );
            List carLot = new ArrayList ();
            while (rs.next ()) {

                DAOCarModel carRetrieve = new DAOCarModel ();
                carLot.add ( carRetrieve );
            }
            return carLot;
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        return null;
    }

    @Override
    public Boolean insertCar(DAOCarModel newCar) {
        Connection connection = getConnection.makeConnection ();
        try {
            PreparedStatement prepState = connection.prepareStatement ( "INSERT INTO Car_Data VALUES (?, ?, ?, ?, ?)" );
            prepState.setInt ( 1, newCar.getId () );
            prepState.setString ( 2, newCar.getMake () );
            prepState.setString ( 3, newCar.getModel () );
            prepState.setString ( 4, newCar.getYear () );
            prepState.setString ( 5, newCar.getColor () );
            int inserted = prepState.executeUpdate ();

            if (inserted == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        return false;
    }

    @Override
    public DAOCarModel updateCar(DAOCarModel newCar) {
        Connection connection = getConnection.makeConnection ();
        try {
                PreparedStatement preparedStatement = connection.prepareStatement ( "UPDATE Car_Data SET Make=?, Model=?, Model_Year=?, Color=? WHERE id=?" );
                preparedStatement.setString ( 1, newCar.getMake () );
                preparedStatement.setString ( 2, newCar.getModel () );
                preparedStatement.setString ( 3, newCar.getYear () );
                preparedStatement.setString ( 4, newCar.getColor () );
                preparedStatement.setInt (5, newCar.getId ()  );
                int i = preparedStatement.executeUpdate ();

            if (i == 1) {

                return newCar;
            }
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        return null;
    }

    @Override
    public Boolean deleteCar(Integer id) {
        Connection connection = getConnection.makeConnection ();
        try {
            Statement statement = connection.createStatement ();
            Integer index = statement.executeUpdate ( "DELETE FROM Car_Data WHERE id = " + id );

            if (index == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        return false;
    }
}


