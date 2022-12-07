package service;

import config.JdbcConnection;
import entity.Plane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaneService {
    private Connection connection = JdbcConnection.getConnection();

    public PlaneService() throws SQLException {
    }

    public List<Plane> getAllPalne() throws SQLException {
        List<Plane> result = new ArrayList();
        String query = "SELECT MaMB, TamBay, Loai FROM maybay";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Plane plane = new Plane();
                plane.setPlaneCode(resultSet.getInt(1));
                plane.setFlight(resultSet.getInt(2));
                plane.setType(resultSet.getString(3));
                result.add(plane);
            }
        } catch (Exception var9) {
            System.err.println(var9.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

        return result;
    }

    public List<Plane> getPalne() throws SQLException {
        List<Plane> result = new ArrayList();
        String query = "SELECT MaMB, TamBay, Loai FROM maybay WHERE TamBay > 10000";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Plane plane = new Plane();
                plane.setPlaneCode(resultSet.getInt(1));
                plane.setFlight(resultSet.getInt(2));
                plane.setType(resultSet.getString(3));
                result.add(plane);
            }
        } catch (Exception var9) {
            System.err.println(var9.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

        return result;
    }

    public List<Plane> getPalneType() throws SQLException {
        List<Plane> result = new ArrayList();
        String query = "SELECT MaMB, TamBay, Loai FROM maybay WHERE Loai LIKE ?";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            pStatement.setString(1, "Boeing%");
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Plane plane = new Plane();
                plane.setPlaneCode(resultSet.getInt(1));
                plane.setFlight(resultSet.getInt(2));
                plane.setType(resultSet.getString(3));
                result.add(plane);
            }
        } catch (Exception var9) {
            System.err.println(var9.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

        return result;
    }

    public List<Plane> getPalneVN280() throws SQLException {
        List<Plane> result = new ArrayList();
        String query = "SELECT MaMB, TamBay, Loai FROM maybay WHERE TamBay > (SELECT DoDai FROM chuyenbay WHERE MaCB='VN280')";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Plane plane = new Plane();
                plane.setPlaneCode(resultSet.getInt(1));
                plane.setFlight(resultSet.getInt(2));
                plane.setType(resultSet.getString(3));
                result.add(plane);
            }
        } catch (Exception var9) {
            System.err.println(var9.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

        return result;
    }
}
