package repository;

import config.JdbcConnection;
import entity.Plane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaneRepository {
    private Connection connection = JdbcConnection.getConnection();

    public PlaneRepository() throws SQLException {
    }

    public List<Plane> getAllPlane() throws SQLException {
        List<Plane> result = new ArrayList();
        String query = "SELECT MaMB, TamBay, Loai FROM maybay";
        PreparedStatement pStatement = null;
        Plane plane;
        try {
            pStatement = connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                plane = new Plane();
                plane.setPlaneCode(resultSet.getInt(1));
                plane.setFlight(resultSet.getInt(2));
                plane.setType(resultSet.getString(3));
                result.add(plane);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            if(pStatement != null){
                pStatement.close();
            }
            connection.close();
        }

        return result;
    }

    public List<Plane> getPlaneByTamBay10000() throws SQLException {
        List<Plane> result = new ArrayList();
        String query = "SELECT MaMB, TamBay, Loai FROM maybay WHERE TamBay > 10000";
        PreparedStatement pStatement = null;
        Plane plane;
        try {
            pStatement = connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                plane = new Plane();
                plane.setPlaneCode(resultSet.getInt(1));
                plane.setFlight(resultSet.getInt(2));
                plane.setType(resultSet.getString(3));
                result.add(plane);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            if(pStatement != null){
                pStatement.close();
            }
            connection.close();
        }

        return result;
    }

    public List<Plane> getPlaneOfType() throws SQLException {
        List<Plane> result = new ArrayList();
        String query = "SELECT MaMB, TamBay, Loai FROM maybay WHERE Loai LIKE ?";
        PreparedStatement pStatement = null;
        Plane plane;
        try {
            pStatement = this.connection.prepareStatement(query);
            pStatement.setString(1, "Boeing%");
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                plane = new Plane();
                plane.setPlaneCode(resultSet.getInt(1));
                plane.setFlight(resultSet.getInt(2));
                plane.setType(resultSet.getString(3));
                result.add(plane);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            if(pStatement != null){
                pStatement.close();
            }
            connection.close();
        }

        return result;
    }

    public List<Plane> getPlaneByVN280() throws SQLException {
        List<Plane> result = new ArrayList();
        String query = "SELECT MaMB, TamBay, Loai FROM maybay WHERE TamBay > (SELECT DoDai FROM chuyenbay WHERE MaCB='VN280')";
        PreparedStatement pStatement = null;
        Plane plane;
        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                plane = new Plane();
                plane.setPlaneCode(resultSet.getInt(1));
                plane.setFlight(resultSet.getInt(2));
                plane.setType(resultSet.getString(3));
                result.add(plane);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            if(pStatement != null){
                pStatement.close();
            }
            connection.close();
        }

        return result;
    }
}
