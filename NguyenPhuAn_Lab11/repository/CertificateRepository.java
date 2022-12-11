package repository;

import config.JdbcConnection;
import entity.Certification;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CertificateRepository {
    private Connection connection = JdbcConnection.getConnection();

    public CertificateRepository() throws SQLException {
    }

    public List<Certification> getAllCertificate() throws SQLException {
        List<Certification> result = new ArrayList();
        String query = "SELECT MaNV, MaMB FROM chungnhan";
        PreparedStatement pStatement = null;
        Certification certification;

        try {
            pStatement = connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                certification = new Certification();
                certification.setEmpCode(resultSet.getString(1));
                certification.setPlaneCode(resultSet.getInt(2));
                result.add(certification);
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

    public List<Certification> getCertificateNV() throws SQLException {
        List<Certification> result = new ArrayList();
        String query = "SELECT C.MaNV, C.MaMB FROM chungnhan C JOIN maybay M ON C.MaMB=M.MaMB WHERE M.Loai LIKE 'Boeing%'";
        PreparedStatement pStatement = null;
        Certification certification;
        try {
            pStatement = connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                certification = new Certification();
                certification.setEmpCode(resultSet.getString(1));
                certification.setPlaneCode(resultSet.getInt(2));
                result.add(certification);
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

    public List<Certification> getCertificateNVs() throws SQLException {
        List<Certification> result = new ArrayList();
        String query = "SELECT C.MaNV, C.MaMB FROM chungnhan C JOIN maybay M ON C.MaMB=M.MaMB WHERE M.Loai LIKE 'Boeing%' AND M.Loai LIKE 'Airbus%'";
        PreparedStatement pStatement = null;
        Certification certification;
        try {
            pStatement = connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                certification = new Certification();
                certification.setEmpCode(resultSet.getString(1));
                certification.setPlaneCode(resultSet.getInt(2));
                result.add(certification);
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

    public List<Certification> getCertificateOfNguyen() throws SQLException {
        List<Certification> result = new ArrayList();
        String query = "SELECT C.MaNV, C.MaMB FROM chungnhan C JOIN nhanvien N ON C.MaNV=N.MaNV WHERE N.Ten LIKE 'Nguyen%'";
        PreparedStatement pStatement = null;
        Certification certification;
        try {
            pStatement = connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                certification = new Certification();
                certification.setEmpCode(resultSet.getString(1));
                certification.setPlaneCode(resultSet.getInt(2));
                result.add(certification);
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
    public List<Certification> getCertificateOf3PlaneType() throws SQLException {
        List<Certification> result = new ArrayList();
        String query = "SELECT MaNV FROM chungnhan GROUP BY MaNV HAVING COUNT(MaMB) = 3";
        PreparedStatement pStatement = null;
        Certification certification;
        try {
            pStatement = connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                certification = new Certification();
                certification.setEmpCode(resultSet.getString(1));
                result.add(certification);
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
    public List<Certification> getCertificateMoreThan3PlaneType() throws SQLException {
        List<Certification> result = new ArrayList();
        String query = "SELECT c.MaNV, MAX(m.TamBay) FROM chungnhan c JOIN maybay m ON c.MaMB=m.MaMB GROUP BY c.MaNV HAVING COUNT(c.MaMB) > 3";
        PreparedStatement pStatement = null;
        Certification certification;
        try {
            pStatement = connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                certification = new Certification();
                certification.setEmpCode(resultSet.getString(1));
                certification.setPlaneCode(resultSet.getInt(2));
                result.add(certification);
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
    public List<Certification> getCertificateAllPlaneType() throws SQLException {
        List<Certification> result = new ArrayList();
        String query = "SELECT MaNV, COUNT(MaMB) FROM chungnhan GROUP BY MaNV";
        PreparedStatement pStatement = null;
        Certification certification;
        try {
            pStatement = connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                certification = new Certification();
                certification.setEmpCode(resultSet.getString(1));
                certification.setPlaneCode(resultSet.getInt(2));
                result.add(certification);
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
