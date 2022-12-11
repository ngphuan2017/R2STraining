package repository;

import config.JdbcConnection;
import entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private Connection connection = JdbcConnection.getConnection();

    public EmployeeRepository() throws SQLException {
    }

    public List<Employee> getAllEmployee() throws SQLException {
        List<Employee> result = new ArrayList();
        String query = "SELECT MaNV, Ten, Luong FROM nhanvien";
        PreparedStatement pStatement = null;
        Employee emp;
        try {
            pStatement = connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                emp = new Employee();
                emp.setEmpCode(resultSet.getString(1));
                emp.setName(resultSet.getString(2));
                emp.setSalary(resultSet.getInt(3));
                result.add(emp);
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

    public void setEmployee(String empCode, String name, int salary) throws SQLException {
        connection.setAutoCommit(false);
        String query = "INSERT INTO nhanvien (MaNV, Ten, Luong) VALUES (?,?,?)";
        PreparedStatement pStatement = null;

        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, empCode);
            pStatement.setString(2, name);
            pStatement.setInt(3, salary);
            pStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            if(pStatement != null){
                pStatement.close();
            }
            connection.close();
        }

    }

    public List<Employee> getEmployeeSalary10000() throws SQLException {
        List<Employee> result = new ArrayList();
        String query = "SELECT MaNV, Ten, Luong FROM nhanvien WHERE Luong < 10000";
        PreparedStatement pStatement = null;
        Employee emp;
        try {
            pStatement = connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                emp = new Employee();
                emp.setEmpCode(resultSet.getString(1));
                emp.setName(resultSet.getString(2));
                emp.setSalary(resultSet.getInt(3));
                result.add(emp);
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

    public int getSumSalary() throws SQLException {
        int sum = 0;
        String query = "SELECT MaNV, Ten, Luong FROM nhanvien";
        PreparedStatement pStatement = null;

        try {
            pStatement = connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();
            while(resultSet.next()) {
                sum += resultSet.getInt(3);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            if(pStatement != null){
                pStatement.close();
            }
            connection.close();
        }

        return sum;
    }

    public List<Employee> getEmployeePlaneCode747() throws SQLException {
        List<Employee> result = new ArrayList();
        String query = "SELECT n.MaNV, n.Ten, n.Luong FROM nhanvien n JOIN chungnhan c ON n.MaNV=c.MaNV WHERE c.MaMB=747";
        PreparedStatement pStatement = null;
        Employee emp;
        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                emp = new Employee();
                emp.setEmpCode(resultSet.getString(1));
                emp.setName(resultSet.getString(2));
                emp.setSalary(resultSet.getInt(3));
                result.add(emp);
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

    public List<Employee> getEmployeeBoeing() throws SQLException {
        List<Employee> result = new ArrayList();
        String query = "SELECT n.MaNV, n.Ten, n.Luong FROM nhanvien n JOIN chungnhan c ON n.MaNV=c.MaNV JOIN maybay m ON c.MaMB=m.MaMB WHERE m.Loai LIKE 'Boeing%'";
        PreparedStatement pStatement = null;
        Employee emp;
        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                emp = new Employee();
                emp.setEmpCode(resultSet.getString(1));
                emp.setName(resultSet.getString(2));
                emp.setSalary(resultSet.getInt(3));
                result.add(emp);
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
    public List<Employee> getEmployeeNotPilot() throws SQLException {
        List<Employee> result = new ArrayList();
        String query = "SELECT n.MaNV, n.Ten, n.Luong FROM nhanvien n LEFT JOIN chungnhan c ON n.MaNV=c.MaNV WHERE c.MaNV is null";
        PreparedStatement pStatement = null;
        Employee emp;
        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                emp = new Employee();
                emp.setEmpCode(resultSet.getString(1));
                emp.setName(resultSet.getString(2));
                emp.setSalary(resultSet.getInt(3));
                result.add(emp);
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
    public List<Employee> getEmployeeMaxSalary() throws SQLException {
        List<Employee> result = new ArrayList();
        String query = "SELECT TOP(1) MaNV, Ten, Luong FROM nhanvien ORDER BY Luong DESC";
        PreparedStatement pStatement = null;
        Employee emp;
        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                emp = new Employee();
                emp.setEmpCode(resultSet.getString(1));
                emp.setName(resultSet.getString(2));
                emp.setSalary(resultSet.getInt(3));
                result.add(emp);
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
    public int getEmployeeSumSalaryIsPilot() throws SQLException {
        String query = "SELECT SUM(n.Luong) FROM nhanvien n JOIN chungnhan c ON n.MaNV=c.MaNV";
        PreparedStatement pStatement = null;
        int sum = 0;
        try {
            pStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = pStatement.executeQuery();

            while(resultSet.next()) {
                sum += resultSet.getInt(1);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            if(pStatement != null){
                pStatement.close();
            }
            connection.close();
        }

        return sum;
    }
}
