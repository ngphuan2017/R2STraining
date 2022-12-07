package service;

import config.JdbcConnection;
import entity.Certification;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CertificateService {
    private Connection connection = JdbcConnection.getConnection();

    public CertificateService() throws SQLException {
    }

    public List<Certification> getAllCertificate() throws SQLException {
        List<Certification> result = new ArrayList();
        String query = "SELECT MaNV, MaMB FROM chungnhan";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Certification certification = new Certification();
                certification.setEmpCode(resultSet.getString(1));
                certification.setPlaneCode(resultSet.getInt(2));
                result.add(certification);
            }
        } catch (Exception var9) {
            System.err.println(var9.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

        return result;
    }

    public List<Certification> getCertificateNV() throws SQLException {
        List<Certification> result = new ArrayList();
        String query = "SELECT C.MaNV, C.MaMB FROM chungnhan C JOIN maybay M ON C.MaMB=M.MaMB WHERE M.Loai LIKE 'Boeing%'";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Certification certification = new Certification();
                certification.setEmpCode(resultSet.getString(1));
                certification.setPlaneCode(resultSet.getInt(2));
                result.add(certification);
            }
        } catch (Exception var9) {
            System.err.println(var9.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

        return result;
    }

    public List<Certification> getCertificateNVs() throws SQLException {
        List<Certification> result = new ArrayList();
        String query = "SELECT C.MaNV, C.MaMB FROM chungnhan C JOIN maybay M ON C.MaMB=M.MaMB WHERE M.Loai LIKE 'Boeing%' AND M.Loai LIKE 'Airbus%'";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Certification certification = new Certification();
                certification.setEmpCode(resultSet.getString(1));
                certification.setPlaneCode(resultSet.getInt(2));
                result.add(certification);
            }
        } catch (Exception var9) {
            System.err.println(var9.getMessage());
        } finally {
            pStatement.close();
            this.connection.close();
        }

        return result;
    }

    public List<Certification> getCertificateNguyen() throws SQLException {
        List<Certification> result = new ArrayList();
        String query = "SELECT C.MaNV, C.MaMB FROM chungnhan C JOIN nhanvien N ON C.MaNV=N.MaNV WHERE N.Ten LIKE 'Nguyen%'";
        PreparedStatement pStatement = null;

        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                Certification certification = new Certification();
                certification.setEmpCode(resultSet.getString(1));
                certification.setPlaneCode(resultSet.getInt(2));
                result.add(certification);
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
