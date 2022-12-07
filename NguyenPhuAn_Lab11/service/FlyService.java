package service;

import config.JdbcConnection;
import entity.Fly;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlyService {
    private Connection connection = JdbcConnection.getConnection();

    public FlyService() throws SQLException {
    }

    public List<Fly> getAllFly() throws SQLException {
        List<Fly> result = new ArrayList();
        String query = "SELECT MaCB, GaDi, GaDen, GioDi, GioDen, DoDai, ChiPhi FROM chuyenbay";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Fly fly = new Fly();
                fly.setFlyCode(resultSet.getString(1));
                fly.setGaDi(resultSet.getString(2));
                fly.setGaDen(resultSet.getString(3));
                fly.setGioDi(resultSet.getTime(4));
                fly.setGioDen(resultSet.getTime(5));
                fly.setDoDai(resultSet.getInt(6));
                fly.setChiPhi(resultSet.getInt(7));
                result.add(fly);
            }
        } catch (Exception var9) {
            System.err.println(var9.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

        return result;
    }

    public List<Fly> getFly() throws SQLException {
        List<Fly> result = new ArrayList();
        String query = "SELECT MaCB, GaDi, GaDen, GioDi, GioDen, DoDai, ChiPhi FROM chuyenbay WHERE GaDen = ?";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            pStatement.setString(1, "DAD");
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Fly fly = new Fly();
                fly.setFlyCode(resultSet.getString(1));
                fly.setGaDi(resultSet.getString(2));
                fly.setGaDen(resultSet.getString(3));
                fly.setGioDi(resultSet.getTime(4));
                fly.setGioDen(resultSet.getTime(5));
                fly.setDoDai(resultSet.getInt(6));
                fly.setChiPhi(resultSet.getInt(7));
                result.add(fly);
            }
        } catch (Exception var9) {
            System.err.println(var9.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

        return result;
    }

    public List<Fly> getFlyDoDai() throws SQLException {
        List<Fly> result = new ArrayList();
        String query = "SELECT MaCB, GaDi, GaDen, GioDi, GioDen, DoDai, ChiPhi FROM chuyenbay WHERE DoDai BETWEEN 8000 AND 10000";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Fly fly = new Fly();
                fly.setFlyCode(resultSet.getString(1));
                fly.setGaDi(resultSet.getString(2));
                fly.setGaDen(resultSet.getString(3));
                fly.setGioDi(resultSet.getTime(4));
                fly.setGioDen(resultSet.getTime(5));
                fly.setDoDai(resultSet.getInt(6));
                fly.setChiPhi(resultSet.getInt(7));
                result.add(fly);
            }
        } catch (Exception var9) {
            System.err.println(var9.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

        return result;
    }

    public List<Fly> getFlys() throws SQLException {
        List<Fly> result = new ArrayList();
        String query = "SELECT MaCB, GaDi, GaDen, GioDi, GioDen, DoDai, ChiPhi FROM chuyenbay WHERE GaDi = ? AND GaDen = ?";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            pStatement.setString(1, "SGN");
            pStatement.setString(2, "BMV");
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Fly fly = new Fly();
                fly.setFlyCode(resultSet.getString(1));
                fly.setGaDi(resultSet.getString(2));
                fly.setGaDen(resultSet.getString(3));
                fly.setGioDi(resultSet.getTime(4));
                fly.setGioDen(resultSet.getTime(5));
                fly.setDoDai(resultSet.getInt(6));
                fly.setChiPhi(resultSet.getInt(7));
                result.add(fly);
            }
        } catch (Exception var9) {
            System.err.println(var9.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

        return result;
    }

    public List<Fly> getFlySGN() throws SQLException {
        List<Fly> result = new ArrayList();
        String query = "SELECT MaCB, GaDi, GaDen, GioDi, GioDen, DoDai, ChiPhi FROM chuyenbay WHERE GaDi = ?";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            pStatement.setString(1, "SGN");
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Fly fly = new Fly();
                fly.setFlyCode(resultSet.getString(1));
                fly.setGaDi(resultSet.getString(2));
                fly.setGaDen(resultSet.getString(3));
                fly.setGioDi(resultSet.getTime(4));
                fly.setGioDen(resultSet.getTime(5));
                fly.setDoDai(resultSet.getInt(6));
                fly.setChiPhi(resultSet.getInt(7));
                result.add(fly);
            }
        } catch (Exception var9) {
            System.err.println(var9.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

        return result;
    }

    public List<Fly> getFlyAirbus() throws SQLException {
        List<Fly> result = new ArrayList();
        String query = "SELECT MaCB, GaDi, GaDen, GioDi, GioDen, DoDai, ChiPhi FROM chuyenbay WHERE DoDai < (SELECT TamBay FROM maybay WHERE Loai='Airbus A320')";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Fly fly = new Fly();
                fly.setFlyCode(resultSet.getString(1));
                fly.setGaDi(resultSet.getString(2));
                fly.setGaDen(resultSet.getString(3));
                fly.setGioDi(resultSet.getTime(4));
                fly.setGioDen(resultSet.getTime(5));
                fly.setDoDai(resultSet.getInt(6));
                fly.setChiPhi(resultSet.getInt(7));
                result.add(fly);
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
